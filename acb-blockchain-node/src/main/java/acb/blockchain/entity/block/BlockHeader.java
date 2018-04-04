package acb.blockchain.entity.block;

/**
 * 区块头
 */
public class BlockHeader {
	 /**上一区块全部内容的hash，区块因它而成链*/
    private String ParentHash;

    /**本区块的ommers（所有叔块）列表的hash*/
    private String UncleHash;

    /**成功挖出本区块的矿工地址，用于接收矿工费*/
    private String Coinbase;

    /** 本区块所有交易的状态tree的根hash */
    private String Root;

    /**本区块所有交易tree的根hash*/
    private String TxHash;

    /**本区块所有交易的收据的tree的根hash **/
    private String ReceiptHash;

    /**交易收据日志组成的Bloom过滤器 **/
    private String Bloom;

    /**本区块难度级别 **/
    private long Difficulty  ;

    /**区块序号，从创世块0递增 **/
    private long Number;

    /**每个区块当前的gas limit **/
    private long GasLimit;

    /**本区块交易消耗的总gas **/
    private long GasUsed;

    /**本区块创建时的Unix时间戳 **/
    private long Time;

    /**区块附加数据，<=32字节 **/
    private byte[] Extra;

    /**256位的hash，与nonce组合证明出块执行了足够的计算 **/
    private String MixDigest;

    /**64位的hash，与MixDigest组合证明出块执行了足够的计算 **/
    private String Nonce;

    public String getParentHash() {
        return ParentHash;
    }

    public void setParentHash(String parentHash) {
        ParentHash = parentHash;
    }

    public String getUncleHash() {
        return UncleHash;
    }

    public void setUncleHash(String uncleHash) {
        UncleHash = uncleHash;
    }

    public String getCoinbase() {
        return Coinbase;
    }

    public void setCoinbase(String coinbase) {
        Coinbase = coinbase;
    }

    public String getRoot() {
        return Root;
    }

    public void setRoot(String root) {
        Root = root;
    }

    public String getTxHash() {
        return TxHash;
    }

    public void setTxHash(String txHash) {
        TxHash = txHash;
    }

    public String getReceiptHash() {
        return ReceiptHash;
    }

    public void setReceiptHash(String receiptHash) {
        ReceiptHash = receiptHash;
    }

    public String getBloom() {
        return Bloom;
    }

    public void setBloom(String bloom) {
        Bloom = bloom;
    }

    public long getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(long difficulty) {
        Difficulty = difficulty;
    }

    public long getNumber() {
        return Number;
    }

    public void setNumber(long number) {
        Number = number;
    }

    public long getGasLimit() {
        return GasLimit;
    }

    public void setGasLimit(long gasLimit) {
        GasLimit = gasLimit;
    }

    public long getGasUsed() {
        return GasUsed;
    }

    public void setGasUsed(long gasUsed) {
        GasUsed = gasUsed;
    }

    public long getTime() {
        return Time;
    }

    public void setTime(long time) {
        Time = time;
    }

    public byte[] getExtra() {
        return Extra;
    }

    public void setExtra(byte[] extra) {
        Extra = extra;
    }

    public String getMixDigest() {
        return MixDigest;
    }

    public void setMixDigest(String mixDigest) {
        MixDigest = mixDigest;
    }

    public String getNonce() {
        return Nonce;
    }

    public void setNonce(String nonce) {
        Nonce = nonce;
    }
}
