package acb.blockchain.entity;

/**
 * 账户
 * @author liuyck
 *
 */
public class Account {

	/** 若为EOA是发送的交易序号，如为CA是合约创建的序号。  */
	private String Nonce    ;

	/** 这个地址的余额  */
	private long Balance;

	/** 账户自身内容RPL编码组成的Merkle Trie的根哈希  */
	private String Root         ;

	/** 账户绑定的EVM Code，账户一经创建不可修改。 */
	private byte[] CodeHash ;
}
