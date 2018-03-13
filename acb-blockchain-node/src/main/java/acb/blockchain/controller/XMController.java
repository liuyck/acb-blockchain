package acb.blockchain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcits.serviceplatform.NodeClient;
import com.dcits.serviceplatform.entity.Block;
import com.google.gson.Gson;

@RestController
public class XMController {
	private static final Logger logger = LoggerFactory.getLogger(XMController.class); 

	@GetMapping("/Block")
	public String getBlock() {
		return null;
	}
	
	@GetMapping("/BlockChain")
	public String getBlockChain() {
		return null;
	}
	
	@PostMapping("/Block")
	public String newBlock() {
		Block lastBlock = NodeClient.blockChain.get(NodeClient.blockChain.size() - 1);

        Block newBlock = NodeClient.generateBlock(lastBlock, 11111);

        if (NodeClient.isBlockValid(newBlock, lastBlock)) {

        	NodeClient.blockChain.add(newBlock);
        	Gson gson = new Gson();
        	logger.debug(gson.toJson(newBlock));

        } else {

            return "HTTP 500: Invalid Block Error";

        }

        return "success!";
	}
}
