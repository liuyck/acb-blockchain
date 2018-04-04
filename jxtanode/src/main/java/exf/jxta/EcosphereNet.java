package exf.jxta;

import net.jxta.discovery.DiscoveryService;
import net.jxta.document.MimeMediaType;
import net.jxta.document.StructuredTextDocument;
import net.jxta.exception.PeerGroupException;
import net.jxta.id.IDFactory;
import net.jxta.peergroup.NetPeerGroupFactory;
import net.jxta.peergroup.PeerGroup;
import net.jxta.peergroup.PeerGroupID;
import net.jxta.protocol.ModuleImplAdvertisement;
import net.jxta.protocol.PeerGroupAdvertisement;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: liuyck
 * Date: 2018/4/4
 * Time: 17:05
 * To change this template use File | Settings | File Templates.
 */
public class EcosphereNet {
    private static String brand = "Chez JXTA";
    public static int timeout = 3000;
    private static String groupUrl = "urn:jxta:uuid-CA2F68F6F7D6436288F0C72BDC8B82C602";

    /**
     * 启动JXTA，获取PeerGroup
     */
    public static PeerGroup startJXTA() {
        PeerGroup netpg = null;
        try {
            // 创建并加入默认的 PeerGroup(netPeerGroup)
            netpg = new NetPeerGroupFactory().getInterface();
        } catch (PeerGroupException e) {
            // 输出netPeerGroup初始化失败的信息并且退出
            System.out.println("fatal error : group creation failure");
            e.printStackTrace();
            System.exit(1);
        }

        //输出相关的PeerGroup 以及Peer 的信息
        System.out.println("Hello JXTA!  :)");
        System.out.println(" Group name = " +
                netpg.getPeerGroupName());
        System.out.println(" Group ID = " +
                netpg.getPeerGroupID().toString());
        System.out.println(" Peer name = " +
                netpg.getPeerName());
        System.out.println(" Peer ID = " +
                netpg.getPeerID().toString());

        return joinRestoNet(netpg);
    }

    private static PeerGroup joinRestoNet(PeerGroup netpg){
        PeerGroup restoNet = null;

        int count = 3;
        System.out.println("开始寻找RestoNet");
        DiscoveryService worldDS = netpg.getDiscoveryService();
        Enumeration ae = null;

        while (count-- > 0){
            try {
                ae = worldDS.getLocalAdvertisements(DiscoveryService.GROUP,"Name","RestoPeer");

                if (ae != null && ae.hasMoreElements())
                    break;

                worldDS.getRemoteAdvertisements(null,DiscoveryService.GROUP
                        ,"Name","RestoNet",1,null);

                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        PeerGroupAdvertisement restoNetAdv = null;

        if (ae == null || !ae.hasMoreElements()){
            System.out.println("没有找到RestoNet");

            try {
                ModuleImplAdvertisement implAdv = netpg.getAllPurposePeerGroupImplAdvertisement();

                restoNet = netpg.newGroup(mkGroupId(groupUrl),implAdv,"RestoNet","RestoNet, Inc.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            restoNetAdv = (PeerGroupAdvertisement) ae.nextElement();
            try {
                restoNet = netpg.newGroup(restoNetAdv);
                System.out.println("找到RestoNet并加入");
            } catch (PeerGroupException e) {
                e.printStackTrace();
            }
        }

        System.out.println("RestoNet Restrant (" + brand + ") is on-line");
        printAdv(restoNet.getPeerGroupAdvertisement());

        return restoNet;
    }

    private static PeerGroupID mkGroupId(String groupUrl) throws URISyntaxException {
        return (PeerGroupID) IDFactory.fromURI(URI.create(groupUrl));
//        return (PeerGroupID) IDFactory.newPeerGroupID();
    }

    public static void printAdv(PeerGroupAdvertisement advertisement){
        MimeMediaType mimeMediaType = new MimeMediaType("text/plain");
        StructuredTextDocument doc = (StructuredTextDocument) advertisement.getDocument(mimeMediaType);
        StringWriter out = new StringWriter();
        try {
            doc.sendToWriter(out);
            System.out.println(out.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
