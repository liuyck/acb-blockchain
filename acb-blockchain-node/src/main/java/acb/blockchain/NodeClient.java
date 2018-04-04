package acb.blockchain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import acb.blockchain.entity.Address;
import acb.blockchain.entity.block.Block;
import acb.blockchain.util.BlockUtils;


public class NodeClient {
	private ArrayList<Block> blockChain;
	private static NodeClient nodeClient;
	private List<Address> addList;

	public ArrayList<Block> getBlockChain() {
		return blockChain;
	}

	private NodeClient() {
		Block genesisBlock = new Block();

//		genesisBlock.setIndex(0);
//		genesisBlock.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//		genesisBlock.setVac(0);
//		genesisBlock.setPrevHash("");
//		genesisBlock.setHash(BlockUtils.calculateHash(genesisBlock));

		blockChain = new ArrayList<Block>();
		blockChain.add(genesisBlock);

        setAddList(new ArrayList<Address>());
	}

	public static NodeClient getInstance(){
		Object obj = new Object();
		if (nodeClient==null) {
			synchronized (obj) {
				if (nodeClient == null) {
					nodeClient = new NodeClient();
				}
			}
		}
		return nodeClient;
	}

	/**
	 * 切换链
	 *
	 * @param newBlocks
	 */
	public void replaceChain(ArrayList<Block> newBlocks) {
		if (newBlocks.size() > blockChain.size()) {
			blockChain = newBlocks;
		}
	}

	public List<Address> getAddList() {
		return addList;
	}

	public void setAddList(List<Address> addList) {
		this.addList = addList;
	}

}
