package p2p;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: liuyck
 * Date: 2018/4/4
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
public class P2Ptest {
    public static void main(String[] args) {
        Logger.getLogger("net.jxta").setLevel(Level.WARNING);
        HungryPeer hungryPeer = new HungryPeer();
        hungryPeer.start();
    }
}
