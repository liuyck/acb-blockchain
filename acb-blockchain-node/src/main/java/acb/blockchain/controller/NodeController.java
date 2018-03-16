package acb.blockchain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import acb.blockchain.NodeClient;
import acb.blockchain.entity.Block;
import acb.blockchain.util.BlockUtils;


@RestController
public class NodeController {
	private static final Logger logger = LoggerFactory.getLogger(NodeController.class); 
	
	@ResponseBody
	@GetMapping("/Block/{id}")
	public Block getBlock(@PathVariable(value = "id") Integer id) {
//		Gson gson = new Gson();
		return NodeClient.getInstance().getBlockChain().get(id);
	}
	
	@GetMapping("/BlockChain")
	public String getBlockChain() {
		Gson gson = new Gson();
		return gson.toJson(NodeClient.getInstance().getBlockChain());
	}
	
	@PostMapping("/Block")
	public String newBlock() {
		Block lastBlock = NodeClient.getInstance().getBlockChain().get(NodeClient.getInstance().getBlockChain().size() - 1);
        Block newBlock = BlockUtils.generateBlock(lastBlock, 11111);
        
        if (BlockUtils.isBlockValid(newBlock, lastBlock)) {
        	NodeClient.getInstance().getBlockChain().add(newBlock);
        	Gson gson = new Gson();
        	logger.debug(gson.toJson(newBlock));
        } else {
            return "HTTP 500: Invalid Block Error";
        }

        return "success!";
	}
}
