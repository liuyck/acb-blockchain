package acb.blockchain.util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import acb.blockchain.entity.block.Block;
import acb.blockchain.tcp.TCPServer;

public class BlockUtils {
	private static final Logger logger = LoggerFactory.getLogger(TCPServer.class);

	private static final int difficulty = 2;

	/**
	 * 计算给定的数据的 SHA256 散列值
	 *
	 * @param block
	 * @return
	 */
	public static String calculateHash(Block block) {
//		String record = (block.getIndex()) + block.getTimestamp() + (block.getVac()) + block.getPrevHash();
//		MessageDigest messageDigest = DigestUtils.getSha256Digest();
//		byte[] hash = messageDigest.digest(StringUtils.getBytesUtf8(record));
//		return Hex.encodeHexString(hash);
		return null;
	}

//	/**
//	 * 生成一个新的块
//	 *
//	 * @param oldBlock
//	 * @param vac
//	 * @return
//	 */
//	public static Block generateBlock(Block oldBlock, int vac) {
//
//		Block newBlock = new Block();
//
//		newBlock.setIndex(oldBlock.getIndex() + 1);
//
//		newBlock.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//
//		newBlock.setVac(vac);
//
//		newBlock.setPrevHash(oldBlock.getHash());
//
//		newBlock.setHash(calculateHash(newBlock));
//
//		return newBlock;
//
//	}

	public static Block generateBlock(Block oldBlock, int vac) {
        Block newBlock = new Block();

//        newBlock.setIndex(oldBlock.getIndex() + 1);
//        newBlock.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        newBlock.setVac(vac);
//        newBlock.setPrevHash(oldBlock.getHash());
//        newBlock.setDifficulty(difficulty);

        /*
         * 这里的 for 循环很重要： 获得 i 的十六进制表示 ，将 Nonce 设置为这个值，并传入 calculateHash 计算哈希值。
         * 之后通过上面的 isHashValid 函数判断是否满足难度要求，如果不满足就重复尝试。 这个计算过程会一直持续，直到求得了满足要求的
         * Nonce 值，之后通过 handleWriteBlock 函数将新块加入到链上。
         */
//        for (int i = 0;; i++) {
//            String hex = String.format("%x", i);
//            newBlock.setNonce(hex);
//            if (!isHashValid(calculateHash(newBlock), newBlock.getDifficulty())) {
//                System.out.printf("%s do more work!\n", calculateHash(newBlock));
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                	logger.error("error:", e);
//                }
//                continue;
//            } else {
//                System.out.printf("%s work done!\n", calculateHash(newBlock));
//                newBlock.setHash(calculateHash(newBlock));
//                break;
//            }
//        }
        return newBlock;
    }

	/**
	 * 校验块的有效性
	 *
	 * @param newBlock
	 * @param oldBlock
	 * @return
	 */
	public static boolean isBlockValid(Block newBlock, Block oldBlock) {

//		if (oldBlock.getIndex() + 1 != newBlock.getIndex()) {
//
//			return false;
//
//		}
//
//		if (!oldBlock.getHash().equals(newBlock.getPrevHash())) {
//
//			return false;
//
//		}
//
//		if (!calculateHash(newBlock).equals(newBlock.getHash())) {
//
//			return false;
//
//		}

		return true;

	}

	/**
     * 校验HASH的合法性
     *
     * @param hash
     * @param difficulty
     * @return
     */
    public static boolean isHashValid(String hash, int difficulty) {
        String prefix = repeat("0", difficulty);
        return hash.startsWith(prefix);
    }

    private static String repeat(String str, int repeat) {
        final StringBuilder buf = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            buf.append(str);
        }
        return buf.toString();
    }
}
