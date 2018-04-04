package acb.blockchain.entity.block;

public class Transaction {
    /**
     * 发起交易的账户的nonce
     */
    private long AccountNonce;

    /**
     * 这笔交易消耗的gas单价
     */
    private long Price;

    /**
     * 你愿意为这笔交易最多可以支付的上限
     */
    private long GasLimit;

    /**
     * 接收账户的地址，如果为空说明接受账户是一个CA，否则是EOA
     */
    private String Recipient;

    /**
     * 到接收者的额度
     */
    private long Amount;

    /**
     * 如果交易类型是消息调用则Palload写为Td，表示输入数据，例如消息的参数，假设有一个注册域名的合约服务，则Td就是该服务需要的参数如IP等。如果交易类型是创建合约，则Payload写为Ti，表示一段代码，这段代码用于创建合约账户，这段初始化代码只会被执行一次就丢弃掉，第二次执行的是创建完的合约代码体。
     */
    private byte[] Payload;

    /**
     * 本区块所有交易tree的根hash
     */
    private String Hash;
}
