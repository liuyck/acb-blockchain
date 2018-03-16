package acb.blockchain.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import acb.blockchain.NodeClient;
import acb.blockchain.entity.Address;
import acb.blockchain.tcp.thread.BroadCastThread;
import acb.blockchain.tcp.thread.NodeThread;

public class TCPServer {
	private static final Logger logger = LoggerFactory.getLogger(TCPServer.class); 
	private ServerSocket serverSocket;
	
	public void start() throws IOException {
		// 建立TCP监听8333
        serverSocket = new ServerSocket(8333);
       
        Address address = new Address("127.0.0.1", 8333);
        NodeClient.getInstance().getAddList().add(address);
        
        logger.info("*** Node is started,waiting for others ***");
        // 监听对等网络中的结点
        for(;;) {
            final Socket socket = serverSocket.accept();
            
            Address otherAdd = new Address(socket.getInetAddress().getHostAddress(), socket.getPort());
            NodeClient.getInstance().getAddList().add(otherAdd);
            
            System.out.println(NodeClient.getInstance().getAddList());
            // 创建一个新的线程 ,和建立连接的结点通讯
            new NodeThread(socket, NodeClient.getInstance().getBlockChain()).start();
            // 模拟网络结点广播
            new BroadCastThread(socket, NodeClient.getInstance().getBlockChain()).start();
        }
	}

	public static void main(String[] args) throws IOException {
		TCPServer tcpServer = new TCPServer();
		tcpServer.start();
	}
}
