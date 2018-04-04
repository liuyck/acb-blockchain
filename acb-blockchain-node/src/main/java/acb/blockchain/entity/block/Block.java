package acb.blockchain.entity.block;


import java.util.List;

public class Block {

    /**块头*/
    private BlockHeader blockHeader;

    /**显而易见就是块生成时的时间戳*/
    private String rlp;

    /**交易*/
    private List<Transaction> transactions;

	/**虚拟资产。我们要记录的数据*/
//	private Transaction transaction;
}
