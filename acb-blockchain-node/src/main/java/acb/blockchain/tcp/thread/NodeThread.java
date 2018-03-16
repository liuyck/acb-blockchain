package acb.blockchain.tcp.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import acb.blockchain.controller.NodeController;
import acb.blockchain.entity.Block;
import acb.blockchain.util.BlockUtils;

public class NodeThread extends Thread{
	private static final Logger logger = LoggerFactory.getLogger(NodeController.class); 

	private Socket socket;
	private ArrayList<Block> blockChain;
	private Gson gson;
	private InetAddress address;
	
	public NodeThread(Socket socket, ArrayList<Block> blockChain) {
		this.socket = socket;
		this.blockChain = blockChain;
		this.address = socket.getInetAddress();
		this.gson = new Gson();
	}

	@Override
	public void run() {
		BufferedReader br = null;
        PrintWriter pw = null;
        try {
            //提示结点输入
            pw = new PrintWriter(socket.getOutputStream());
            pw.write("please enter a new number(vac):\n");
            pw.flush();
            String info = null;

            // 读取结点发送的信息
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while ((info = br.readLine()) != null) {
                try {
                    int vac = Integer.parseInt(info);
                    // 根据vac创建区块
                    Block newBlock = BlockUtils.generateBlock(blockChain.get(blockChain.size() - 1), vac);
                    if (BlockUtils.isBlockValid(newBlock, blockChain.get(blockChain.size() - 1))) {
                        blockChain.add(newBlock);
                        pw.write("Success!\n");
                        pw.write(gson.toJson(blockChain));
                    } else {
                        pw.write("HTTP 500: Invalid Block Error\n");
                    }
                    logger.info("add new block with vac：" + vac);
                } catch (Exception e) {
                	logger.error("not a number:", e);
                    pw.write("not a number! \n");
                }
                pw.write("Please enter a new number(vac):" + "\n");
                // 调用flush()方法将缓冲输出
                pw.flush();
            }
            
        } catch (Exception e) {
        	logger.error("TCP i/o error Or client closed", e);
        } finally {
        	logger.info("node closed:" + address.getHostAddress() + ",port:" + socket.getPort());
            // 关闭资源
            try {
                if (pw != null) {
                    pw.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
            	logger.error("close error:", e);
            }
        }
	}
}
