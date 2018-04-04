package p2p;

import net.jxta.peergroup.PeerGroup;

/**
 *  顾客
 */
public class HungryPeer {
    private PeerGroup restoNet;

    public void start() {
        restoNet = RestoNet.startJXTA();
        System.out.println("顾客");
        RestoNet.printAdv(restoNet.getPeerGroupAdvertisement());
    }
}