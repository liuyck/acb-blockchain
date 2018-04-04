package acb.blockchain.tcp.thread;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import acb.blockchain.controller.NodeController;
import acb.blockchain.entity.block.Block;

public class BroadCastThread extends Thread{
	private static final Logger logger = LoggerFactory.getLogger(NodeController.class); 
	
	private Socket socket;
	private ArrayList<Block> blockChain;
	private Gson gson;
	public BroadCastThread(Socket socket, ArrayList<Block> blockChain) {
		super();
		this.socket = socket;
		this.blockChain = blockChain;
	}
	
	@Override
	public void run() {
		for (;;) {
            PrintWriter pw = null;
            try {
                Thread.sleep(30000);
                logger.info("\n------------broadcast-------------\n");
                logger.info(gson.toJson(blockChain));
                pw = new PrintWriter(socket.getOutputStream());
                // 发送到其他结点
                pw.write("------------broadcast-------------\n");
                pw.write(gson.toJson(blockChain));
                pw.flush();
            } catch (InterruptedException e) {
            	logger.error("error:", e);
            } catch (IOException e) {
            	logger.error("error:", e);
            } 
        }
	}
}
