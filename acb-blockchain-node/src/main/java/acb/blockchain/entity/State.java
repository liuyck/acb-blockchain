package acb.blockchain.entity;

public class State {
	/** 序号  */
	private String nonce;
	
	/** 余额  */
	private String balance;
	
	/** Merkle Root  */
	private String storageRoot;
	
	/** 账户hash  */
	private String codeHash;

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getStorageRoot() {
		return storageRoot;
	}

	public void setStorageRoot(String storageRoot) {
		this.storageRoot = storageRoot;
	}

	public String getCodeHash() {
		return codeHash;
	}

	public void setCodeHash(String codeHash) {
		this.codeHash = codeHash;
	}
}
