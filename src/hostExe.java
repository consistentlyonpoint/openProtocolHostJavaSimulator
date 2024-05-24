import javax.swing.*;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
import java.awt.*;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.time.ZoneId;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.lang.reflect.Array;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class hostExe {
    //
    public static String[] cmdList() {
        return new String[]{"       ",
                "MID0003", "MID0010", "MID0012", "MID0014", "MID0016", "MID0017", "MID0018", "MID0019",
                "MID0020", "MID0030", "MID0032", "MID0034", "MID0036", "MID0037", "MID0038", "MID0039",
                "MID0040", "MID0042", "MID0043", "MID0044", "MID0045", "MID0050", "MID0051", "MID0053",
                "MID0054", "MID0060", "MID0062", "MID0063", "MID0064", "MID0070", "MID0072", "MID0073",
                "MID0075", "MID0077", "MID0078", "MID0080", "MID0082", "MID0090", "MID0092", "MID0093",
                "MID0100", "MID0102", "MID0103", "MID0105", "MID0108", "MID0109", "MID0110", "MID0111",
                "MID0113", "MID0120", "MID0125", "MID0126", "MID0127", "MID0128", "MID0129", "MID0130",
                "MID0131", "MID0132", "MID0133", "MID0140", "MID0150", "MID0151", "MID0153", "MID0154",
                "MID0155", "MID0156", "MID0157", "MID0200", "MID0210", "MID0212", "MID0213", "MID0214",
                "MID0216", "MID0218", "MID0219", "MID0220", "MID0222", "MID0223", "MID0224", "MID0225",
                "MID0240", "MID0241", "MID0243", "MID0244", "MID0250", "MID0252", "MID0253", "MID0254",
                "MID0255", "MID0300", "MID0400", "MID0402", "MID0403", "MID0410", "MID0420", "MID0422",
                "MID0423", "MID9999"
        };

    }
    //
    public static void createDialog() {
        hostClient hClient = new hostClient();
        openProtocolClientParserMIDClass oPCP = new openProtocolClientParserMIDClass();
        openProtocolClientSerializerMIDClass oPCS = new openProtocolClientSerializerMIDClass();
        // ScreenSize
        Dimension refScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int refFrameSizeW = (int) refScreenSize.getWidth();
        int refFrameSizeH = (int) refScreenSize.getHeight();
        // Host Frame
        JFrame frame = new JFrame("Host");
        // frame ratio
        double maxFramePercentageW = 0.80;
        double maxFramePercentageH = 0.80;
        double minFramePercentageW = 0.65;
        double minFramePercentageH = 0.65;
        int maxFrameSizeW = (int) (refFrameSizeW * maxFramePercentageW);
        int minFrameSizeW = (int) (refFrameSizeW * minFramePercentageW);
        int maxFrameSizeH = (int) (refFrameSizeH * maxFramePercentageH);
        int minFrameSizeH = (int) (refFrameSizeH * minFramePercentageH);
        frame.setPreferredSize(new Dimension(maxFrameSizeW, maxFrameSizeH));
        frame.setMaximumSize(frame.getPreferredSize());
        frame.setMinimumSize(new Dimension(minFrameSizeW, minFrameSizeH));
//        frame.setMinimumSize(new Dimension(minframeSizeW, minframeSizeH));
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                hostLogger.hostLog("exit", "closing window", "info");
                try {
                    hostLogger.hostLog("exit", "closing window", "info");
                    hClient.stopConnection();
                } catch (Throwable a) {
                    hostLogger.hostLog("exit", a.getMessage(), "error");
//                    System.out.println("Closing Window, can't stop connection\n" + a.getMessage());
//                    a.printStackTrace();
                }
                System.exit(0);
            }
        });
        // panel ratios
        double pnlHRatioA = (double) 2/9;
        double pnlHRatioB = (double) 1/18;
//        double pnlHRatioB = (double) 1/9;
        double pnlHRatioC = (double) 1/3;
        double pnlHRatioD = (double) 1/36;
        double pnlHRatioE = (double) 1/9;

        double pnlWRatioA = (double) 11/12;
        double pnlWRatioB = (double) 2/3;
        double pnlWRatioC = (double) 5/24;
        double pnlWRatioD = (double) 1/3;
        double pnlWRatioE = (double) 1/8;
        double pnlWRatioF = (double) 3/4;
        double pnlWRatioG = (double) 1/24;
        double pnlWRatioH = (double) 11/24;
        double pnlWRatioI = (double) 1/12;
        // Text areas

        // main container
        JPanel pnlMainContainer = new JPanel();
        pnlMainContainer.setLayout(new BoxLayout(pnlMainContainer, BoxLayout.Y_AXIS));
//        pnlMainContainer.setBorder(BorderFactory.createEtchedBorder());

        // JPanels containers
        JPanel pnlSubConatiner1 = new JPanel();
        pnlSubConatiner1.setLayout(new BoxLayout(pnlSubConatiner1, BoxLayout.X_AXIS));
//        pnlSubConatiner1.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubConatiner1.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnlSubConatiner1.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioA), (int) (frame.getHeight() * pnlHRatioA)));
//        pnlSubConatiner1.setMaximumSize(pnlSubConatiner1.getPreferredSize());
//        pnlSubConatiner1.setMinimumSize(pnlSubConatiner1.getPreferredSize());
        pnlSubConatiner1.setBorder(BorderFactory.createEmptyBorder(0, (int) (frame.getWidth() * pnlWRatioG)
                , (int) (frame.getHeight() * pnlHRatioD), (int) (frame.getWidth() * pnlWRatioG)));
        //
        JPanel pnlSubConatiner1a = new JPanel();
        pnlSubConatiner1a.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioB), (int) (frame.getHeight() * pnlHRatioA)));
        pnlSubConatiner1a.setMaximumSize(pnlSubConatiner1a.getPreferredSize());
        pnlSubConatiner1a.setMinimumSize(pnlSubConatiner1a.getPreferredSize());
        pnlSubConatiner1a.setLayout(new BoxLayout(pnlSubConatiner1a, BoxLayout.X_AXIS));
//        pnlSubConatiner1a.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubConatiner1a.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSubConatiner1a.setBorder(BorderFactory.createEmptyBorder(0, 0, 0
                ,  (int) (frame.getWidth() * pnlWRatioG)));
        // Connection JPanels
        JPanel pnlCnctMain = new JPanel();
        pnlCnctMain.setLayout(new BoxLayout(pnlCnctMain, BoxLayout.Y_AXIS));
//        pnlCnctMain.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlCnctMain.setAlignmentY(Component.CENTER_ALIGNMENT);
        // Connection Header
        JLabel lblManualConnect = new JLabel("Connection");
        lblManualConnect.setFont(new Font("Courier", Font.BOLD, 16));
        lblManualConnect.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblManualConnect.setAlignmentY(Component.TOP_ALIGNMENT);
        lblManualConnect.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        pnlCnctMain.add(lblManualConnect);
        // Connect Detail
        JPanel pnlCnctDtl = new JPanel();
        pnlCnctDtl.setLayout(new BoxLayout(pnlCnctDtl, BoxLayout.X_AXIS));
        // labels
        JPanel pnlCnctLbls = new JPanel();
        pnlCnctLbls.setMaximumSize(new Dimension(85, 70));
        pnlCnctLbls.setMinimumSize(new Dimension(55, 70));
        pnlCnctLbls.setLayout(new BoxLayout(pnlCnctLbls, BoxLayout.Y_AXIS));
        pnlCnctLbls.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlCnctipLbl = new JPanel();
        pnlCnctipLbl.setMaximumSize(new Dimension(85, 30));
        pnlCnctipLbl.setMinimumSize(new Dimension(55, 30));
        pnlCnctipLbl.setLayout(new BoxLayout(pnlCnctipLbl, BoxLayout.X_AXIS));
        JLabel ipLbl = new JLabel("Host:");
        ipLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlCnctipLbl.add(ipLbl);
        pnlCnctLbls.add(pnlCnctipLbl);
        JPanel pnlCnctLblpd = new JPanel();
        pnlCnctLblpd.setMaximumSize(new Dimension(85, 5));
        pnlCnctLblpd.setMinimumSize(new Dimension(55, 5));
        pnlCnctLbls.add(pnlCnctLblpd);
        JPanel pnlCnctlblCtrl = new JPanel();
        pnlCnctlblCtrl.setMaximumSize(new Dimension(85, 30));
        pnlCnctlblCtrl.setMinimumSize(new Dimension(55, 30));
        pnlCnctlblCtrl.setLayout(new BoxLayout(pnlCnctlblCtrl, BoxLayout.X_AXIS));
        JLabel lblCtrl = new JLabel("Device:");
        lblCtrl.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlCnctlblCtrl.add(lblCtrl);
        pnlCnctLbls.add(pnlCnctlblCtrl);
        pnlCnctDtl.add(pnlCnctLbls);
        // ip, port text areas (x) + device (y)
        JPanel pnlCnctDtlFlds = new JPanel();
        pnlCnctDtlFlds.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioH), 70));
        pnlCnctDtlFlds.setMaximumSize(pnlCnctDtlFlds.getPreferredSize());
        pnlCnctDtlFlds.setMinimumSize(pnlCnctDtlFlds.getPreferredSize());
        pnlCnctDtlFlds.setLayout(new BoxLayout(pnlCnctDtlFlds, BoxLayout.Y_AXIS));
        pnlCnctDtlFlds.setAlignmentY(Component.CENTER_ALIGNMENT);
//        pnlCnctDtlFlds.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlCnctDtlIpPortFlds = new JPanel();
        pnlCnctDtlIpPortFlds.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioH), 30));
        pnlCnctDtlIpPortFlds.setMaximumSize(pnlCnctDtlIpPortFlds.getPreferredSize());
        pnlCnctDtlIpPortFlds.setMinimumSize(pnlCnctDtlIpPortFlds.getPreferredSize());
        pnlCnctDtlIpPortFlds.setLayout(new BoxLayout(pnlCnctDtlIpPortFlds, BoxLayout.X_AXIS));
        JTextField ipString = new JTextField("127.0.0.1");
        ipString.setToolTipText("Device/Controller IP Address required.");
        ipString.setAlignmentX(Component.LEFT_ALIGNMENT);
//        ipString.setAlignmentY(Component.TOP_ALIGNMENT);
//        ipString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlCnctDtlIpPortFlds.add(ipString);
        JPanel pnlCnctDtlPortFldsLbl = new JPanel();
        pnlCnctDtlPortFldsLbl.setPreferredSize(new Dimension(65, 30));
        pnlCnctDtlPortFldsLbl.setMaximumSize(pnlCnctDtlPortFldsLbl.getPreferredSize());
        pnlCnctDtlPortFldsLbl.setMinimumSize(pnlCnctDtlPortFldsLbl.getPreferredSize());
        JLabel portLbl = new JLabel("Port: ");
        portLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
//        portLbl.setAlignmentY(Component.CENTER_ALIGNMENT);
//        portLbl.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 35));
        pnlCnctDtlPortFldsLbl.add(portLbl);
//        pnlCnctDtlIpPortFlds.add(portLbl);
        pnlCnctDtlIpPortFlds.add(pnlCnctDtlPortFldsLbl);
        JTextField portString = new JTextField("4545");
        portString.setToolTipText("Device/Controller Port Id required.");
        portString.setAlignmentX(Component.LEFT_ALIGNMENT);
//        portString.setAlignmentY(Component.TOP_ALIGNMENT);
//        portString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlCnctDtlIpPortFlds.add(portString);
        pnlCnctDtlFlds.add(pnlCnctDtlIpPortFlds);
        JPanel pnlCnctDtlFldspd = new JPanel();
        pnlCnctDtlFldspd.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioH), 5));
        pnlCnctDtlFldspd.setMaximumSize(pnlCnctDtlFldspd.getPreferredSize());
        pnlCnctDtlFldspd.setMinimumSize(pnlCnctDtlFldspd.getPreferredSize());
        pnlCnctDtlFlds.add(pnlCnctDtlFldspd);
        JPanel pnlCnctDtlctrlNameFlds = new JPanel();
        pnlCnctDtlctrlNameFlds.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioH), 30));
        pnlCnctDtlctrlNameFlds.setMaximumSize(pnlCnctDtlctrlNameFlds.getPreferredSize());
        pnlCnctDtlctrlNameFlds.setMinimumSize(pnlCnctDtlctrlNameFlds.getPreferredSize());
        pnlCnctDtlctrlNameFlds.setLayout(new BoxLayout(pnlCnctDtlctrlNameFlds, BoxLayout.X_AXIS));
        JTextField ctrlName = new JTextField("deviceName");
        ctrlName.setToolTipText("Device/Controller Name.");
        ctrlName.setAlignmentX(Component.LEFT_ALIGNMENT);
//        ctrlName.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        ctrlName.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlCnctDtlctrlNameFlds.add(ctrlName);
        pnlCnctDtlFlds.add(pnlCnctDtlctrlNameFlds);
        pnlCnctDtl.add(pnlCnctDtlFlds);
        pnlCnctMain.add(pnlCnctDtl);
        // ip/port JPanels
        pnlSubConatiner1a.add(pnlCnctMain);
        pnlSubConatiner1.add(pnlSubConatiner1a);

        //
        JPanel pnlSubConatiner1b = new JPanel();
        pnlSubConatiner1b.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioC), (int) (frame.getHeight() * pnlHRatioA)));
        pnlSubConatiner1b.setMaximumSize(pnlSubConatiner1b.getPreferredSize());
        pnlSubConatiner1b.setMinimumSize(pnlSubConatiner1b.getPreferredSize());
        pnlSubConatiner1b.setLayout(new BoxLayout(pnlSubConatiner1b, BoxLayout.X_AXIS));
        pnlSubConatiner1b.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubConatiner1b.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnlSubConatiner1b.setAlignmentX(Component.RIGHT_ALIGNMENT);
        pnlSubConatiner1b.setBorder(BorderFactory.createEmptyBorder(0, 0, 0
                ,  (int) (frame.getWidth() * pnlWRatioG)));
        // Timing JPanels
        JPanel pnlTmMain = new JPanel();
        pnlTmMain.setLayout(new BoxLayout(pnlTmMain, BoxLayout.Y_AXIS));
        pnlTmMain.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlTmMain.setAlignmentY(Component.CENTER_ALIGNMENT);
//        pnlTmMain.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        // Connection Header
        JLabel lblTime = new JLabel("Keep Alive");
        lblTime.setFont(new Font("Courier", Font.BOLD, 16));
        lblTime.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTime.setAlignmentY(Component.TOP_ALIGNMENT);
        lblTime.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        pnlTmMain.add(lblTime);
        // Timing Detail
        JPanel pnlTmDtl = new JPanel();
        pnlTmDtl.setLayout(new BoxLayout(pnlTmDtl, BoxLayout.X_AXIS));
        // labels
        JPanel pnlTmLbls = new JPanel();
        pnlTmLbls.setPreferredSize(new Dimension(85, 70));
        pnlTmLbls.setMaximumSize(pnlTmLbls.getPreferredSize());
        pnlTmLbls.setMinimumSize(pnlTmLbls.getPreferredSize());
        pnlTmLbls.setLayout(new BoxLayout(pnlTmLbls, BoxLayout.Y_AXIS));
        pnlTmLbls.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlTmDelay = new JPanel();
        pnlTmDelay.setPreferredSize(new Dimension(85, 30));
        pnlTmDelay.setMaximumSize(pnlTmDelay.getPreferredSize());
        pnlTmDelay.setMinimumSize(pnlTmDelay.getPreferredSize());
        pnlTmDelay.setLayout(new BoxLayout(pnlTmDelay, BoxLayout.X_AXIS));
        JLabel lblInitDelay = new JLabel("Delay:");
        lblInitDelay.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlTmDelay.add(lblInitDelay);
        pnlTmLbls.add(pnlTmDelay);
        JPanel pnlTmLblpd = new JPanel();
        pnlTmLblpd.setPreferredSize(new Dimension(85, 5));
        pnlTmLblpd.setMaximumSize(pnlTmLblpd.getPreferredSize());
        pnlTmLblpd.setMinimumSize(pnlTmLblpd.getPreferredSize());
        pnlTmLbls.add(pnlTmLblpd);
        JPanel pnlTmPrd = new JPanel();
        pnlTmPrd.setPreferredSize(new Dimension(85, 30));
        pnlTmPrd.setMaximumSize(pnlTmPrd.getPreferredSize());
        pnlTmPrd.setMinimumSize(pnlTmPrd.getPreferredSize());
        pnlTmPrd.setLayout(new BoxLayout(pnlTmPrd, BoxLayout.X_AXIS));
        JLabel lblTimeoutPrd = new JLabel("Timeout:");
        lblTimeoutPrd.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlTmPrd.add(lblTimeoutPrd);
        pnlTmLbls.add(pnlTmPrd);
        pnlTmDtl.add(pnlTmLbls);
        // delay and timeout text areas
        JPanel pnlTmDtlFlds = new JPanel();
        pnlTmDtlFlds.setPreferredSize(new Dimension(85, 70));
        pnlTmDtlFlds.setMaximumSize(pnlTmDtlFlds.getPreferredSize());
        pnlTmDtlFlds.setMinimumSize(pnlTmDtlFlds.getPreferredSize());
        pnlTmDtlFlds.setLayout(new BoxLayout(pnlTmDtlFlds, BoxLayout.Y_AXIS));
        pnlTmDtlFlds.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlTmDtlInitTmFlds = new JPanel();
        pnlTmDtlInitTmFlds.setPreferredSize(new Dimension(85, 30));
        pnlTmDtlInitTmFlds.setMaximumSize(pnlTmDtlInitTmFlds.getPreferredSize());
        pnlTmDtlInitTmFlds.setMinimumSize(pnlTmDtlInitTmFlds.getPreferredSize());
        pnlTmDtlInitTmFlds.setLayout(new BoxLayout(pnlTmDtlInitTmFlds, BoxLayout.X_AXIS));
        JTextField initTimeout = new JTextField("75.0");
        initTimeout.setPreferredSize(new Dimension(30, 30));
        initTimeout.setMaximumSize(initTimeout.getPreferredSize());
        initTimeout.setMinimumSize(initTimeout.getPreferredSize());
        initTimeout.setLayout(new BoxLayout(initTimeout, BoxLayout.X_AXIS));
        initTimeout.setToolTipText("Initial delay period before sending keep alive message.");
        initTimeout.setAlignmentX(Component.LEFT_ALIGNMENT);
        initTimeout.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 0));
        pnlTmDtlInitTmFlds.add(initTimeout);
        JTextField InitTmUnit = new JTextField("sec.");
        InitTmUnit.setPreferredSize(new Dimension(50, 30));
        InitTmUnit.setMaximumSize(InitTmUnit.getPreferredSize());
        InitTmUnit.setMinimumSize(InitTmUnit.getPreferredSize());
        InitTmUnit.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        InitTmUnit.setBackground(Color.white);
        InitTmUnit.setLayout(new BoxLayout(InitTmUnit, BoxLayout.X_AXIS));
        InitTmUnit.setAlignmentX(Component.CENTER_ALIGNMENT);
        InitTmUnit.setEditable(false);
        pnlTmDtlInitTmFlds.add(InitTmUnit);
        pnlTmDtlFlds.add(pnlTmDtlInitTmFlds);
        JPanel pnlTmDtlFldsPd = new JPanel();
        pnlTmDtlFldsPd.setPreferredSize(new Dimension(85, 5));
        pnlTmDtlFldsPd.setMaximumSize(pnlTmDtlFldsPd.getPreferredSize());
        pnlTmDtlFldsPd.setMinimumSize(pnlTmDtlFldsPd.getPreferredSize());
        pnlTmDtlFlds.add(pnlTmDtlFldsPd);
        JPanel pnlTmDtlTmDlyFlds = new JPanel();
        pnlTmDtlTmDlyFlds.setPreferredSize(new Dimension(85, 30));
        pnlTmDtlTmDlyFlds.setMaximumSize(pnlTmDtlTmDlyFlds.getPreferredSize());
        pnlTmDtlTmDlyFlds.setMinimumSize(pnlTmDtlTmDlyFlds.getPreferredSize());
        pnlTmDtlTmDlyFlds.setLayout(new BoxLayout(pnlTmDtlTmDlyFlds, BoxLayout.X_AXIS));
        JTextField timeoutDelay = new JTextField("65.0");
        timeoutDelay.setPreferredSize(new Dimension(30, 30));
        timeoutDelay.setMaximumSize(timeoutDelay.getPreferredSize());
        timeoutDelay.setMinimumSize(timeoutDelay.getPreferredSize());
        timeoutDelay.setLayout(new BoxLayout(timeoutDelay, BoxLayout.X_AXIS));
        timeoutDelay.setToolTipText("Period between sending keep alive message.");
        timeoutDelay.setAlignmentX(Component.LEFT_ALIGNMENT);
        timeoutDelay.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 1));
        pnlTmDtlTmDlyFlds.add(timeoutDelay);
        JTextField TmDlyUnit = new JTextField("sec.");
        TmDlyUnit.setPreferredSize(new Dimension(50, 30));
        TmDlyUnit.setMaximumSize(TmDlyUnit.getPreferredSize());
        TmDlyUnit.setMinimumSize(TmDlyUnit.getPreferredSize());
        TmDlyUnit.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        TmDlyUnit.setBackground(Color.white);
        TmDlyUnit.setLayout(new BoxLayout(TmDlyUnit, BoxLayout.X_AXIS));
        TmDlyUnit.setAlignmentX(Component.CENTER_ALIGNMENT);
        TmDlyUnit.setEditable(false);
        pnlTmDtlTmDlyFlds.add(TmDlyUnit);
        pnlTmDtlFlds.add(pnlTmDtlTmDlyFlds);
        pnlTmDtl.add(pnlTmDtlFlds);
        pnlTmMain.add(pnlTmDtl);

//        pnlSubConatiner1a.add(pnlTmMain);
        pnlSubConatiner1b.add(pnlTmMain);
//        pnlSubConatiner1.add(pnlSubConatiner1a);
        pnlSubConatiner1.add(pnlSubConatiner1b);
//        pnlMainContainer.add(pnlSubConatiner1a);
        pnlMainContainer.add(pnlSubConatiner1);
        //
        JPanel pnlSubConatiner2 = new JPanel();
        pnlSubConatiner2.setLayout(new BoxLayout(pnlSubConatiner2, BoxLayout.X_AXIS));
//        pnlSubConatiner2.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubConatiner2.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnlSubConatiner2.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioA)
//                , (int) (frame.getHeight() * pnlHRatioB)));
//        pnlSubConatiner2.setMaximumSize(pnlSubConatiner2.getPreferredSize());
//        pnlSubConatiner2.setMinimumSize(pnlSubConatiner2.getPreferredSize());
        pnlSubConatiner2.setBorder(BorderFactory.createEmptyBorder(0, (int) (frame.getWidth() * pnlWRatioG)
                , (int) (frame.getHeight() * pnlHRatioD)
                , (int) (frame.getWidth() * pnlWRatioG)));
        JPanel pnlbtnConnect = new JPanel();
        pnlbtnConnect.setLayout(new BoxLayout(pnlbtnConnect, BoxLayout.X_AXIS));
        pnlbtnConnect.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioD)
                , (int) (frame.getHeight() * pnlHRatioB)));
        pnlbtnConnect.setMaximumSize(pnlbtnConnect.getPreferredSize());
        pnlbtnConnect.setMinimumSize(pnlbtnConnect.getPreferredSize());
        // button
        JButton btnConnect = new JButton("start connection");
        btnConnect.setAlignmentX(Component.LEFT_ALIGNMENT);
//        btnConnect.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioD), 50));
//        btnConnect.setMaximumSize(btnConnect.getPreferredSize());
//        btnConnect.setMinimumSize(btnConnect.getPreferredSize());
//        pnlSubConatiner2.add(btnConnect);
        pnlbtnConnect.add(btnConnect);
        pnlSubConatiner2.add(pnlbtnConnect);
        //
        JPanel pnlbtnConnectRem = new JPanel();
        pnlbtnConnectRem.setLayout(new BoxLayout(pnlbtnConnectRem, BoxLayout.X_AXIS));
//        pnlbtnConnectRem.setAlignmentX(Component.RIGHT_ALIGNMENT);
        pnlbtnConnectRem.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioB)
                , (int) (frame.getHeight() * pnlHRatioB)));
        pnlbtnConnectRem.setMaximumSize(pnlbtnConnectRem.getPreferredSize());
        pnlbtnConnectRem.setMinimumSize(pnlbtnConnectRem.getPreferredSize());
        pnlSubConatiner2.add(pnlbtnConnectRem);

        pnlMainContainer.add(pnlSubConatiner2);
        //
//        //
//        JPanel pnlSubConatiner3 = new JPanel();
//        pnlSubConatiner3.setLayout(new BoxLayout(pnlSubConatiner3, BoxLayout.X_AXIS));
//        pnlSubConatiner3.setAlignmentY(Component.CENTER_ALIGNMENT);
//        pnlSubConatiner3.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioA), (int) (frame.getHeight() * pnlHRatioB)));
//        pnlSubConatiner3.setBorder(BorderFactory.createEmptyBorder(0, (int) (frame.getWidth() * pnlWRatioG), 0,  (int) (frame.getWidth() * pnlWRatioG)));
//        pnlMainContainer.add(pnlSubConatiner3);

        //
        JPanel pnlSubConatiner3 = new JPanel();
        pnlSubConatiner3.setLayout(new BoxLayout(pnlSubConatiner3, BoxLayout.X_AXIS));
        pnlSubConatiner3.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubConatiner3.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSubConatiner3.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioA), (int) (frame.getHeight() * pnlHRatioA)));
        pnlSubConatiner3.setBorder(BorderFactory.createEmptyBorder(0, (int) (frame.getWidth() * pnlWRatioG)
                , (int) (frame.getHeight() * pnlHRatioD)
                , (int) (frame.getWidth() * pnlWRatioG)));
        //
//        JPanel pnlSubConatiner3a = new JPanel();
//        pnlSubConatiner3a.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioF), (int) (frame.getHeight() * pnlHRatioA)));
//        pnlSubConatiner3a.setLayout(new BoxLayout(pnlSubConatiner1a, BoxLayout.X_AXIS));
//        pnlSubConatiner3a.setAlignmentX(Component.LEFT_ALIGNMENT);
        //pnlSubConatiner3a.setBorder(BorderFactory.createEmptyBorder(0, (int) (frame.getWidth() * pnlWRatioG), 0,  (int) (frame.getWidth() * pnlWRatioG)));
        //
        // MID section
        JPanel pnlMidContainer = new JPanel();
        pnlMidContainer.setLayout(new BoxLayout(pnlMidContainer, BoxLayout.Y_AXIS));
//        pnlMidContainer.setLayout(new BoxLayout(pnlMidContainer, BoxLayout.X_AXIS));
//        pnlMidContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMidContainer.setAlignmentY(Component.CENTER_ALIGNMENT);
        // MID Header
        JLabel lblMessages = new JLabel("MID Messages");
        lblMessages.setFont(new Font("Courier", Font.BOLD, 14));
//        lblMessages.setLayout(new BoxLayout(lblMessages, BoxLayout.X_AXIS));
        lblMessages.setAlignmentY(Component.TOP_ALIGNMENT);
        lblMessages.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblMessages.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        pnlMidContainer.add(lblMessages);
        // mid command container
        JPanel pnlMidCommand = new JPanel();
        pnlMidCommand.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioF), (int) (frame.getHeight() * pnlHRatioA)));
        pnlMidCommand.setLayout(new BoxLayout(pnlMidCommand, BoxLayout.X_AXIS));
        pnlMidCommand.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMidCommand.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,  (int) (frame.getWidth() * pnlWRatioG)));
        // labels
        JPanel pnlAllMIDLbls = new JPanel();
        pnlAllMIDLbls.setMaximumSize(new Dimension(125, 70));
        pnlAllMIDLbls.setMinimumSize(new Dimension(100, 70));
        pnlAllMIDLbls.setLayout(new BoxLayout(pnlAllMIDLbls, BoxLayout.Y_AXIS));
        pnlAllMIDLbls.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlMIDLbl = new JPanel();
        pnlMIDLbl.setMaximumSize(new Dimension(125, 30));
        pnlMIDLbl.setMinimumSize(new Dimension(100, 30));
        pnlMIDLbl.setLayout(new BoxLayout(pnlMIDLbl, BoxLayout.X_AXIS));
        JLabel lblMID = new JLabel("MID Command:");
        lblMID.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMIDLbl.add(lblMID);
        pnlAllMIDLbls.add(pnlMIDLbl);
        JPanel pnlAllMIDpd = new JPanel();
        pnlAllMIDpd.setMaximumSize(new Dimension(125, 5));
        pnlAllMIDpd.setMinimumSize(new Dimension(100, 5));
        pnlAllMIDLbls.add(pnlAllMIDpd);
        JPanel pnlSerializedMIDLbl = new JPanel();
        pnlSerializedMIDLbl.setMaximumSize(new Dimension(125, 30));
        pnlSerializedMIDLbl.setMinimumSize(new Dimension(100, 30));
        pnlSerializedMIDLbl.setLayout(new BoxLayout(pnlSerializedMIDLbl, BoxLayout.X_AXIS));
        JLabel lblSerialized = new JLabel("Serialized MID:");
        lblSerialized.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSerializedMIDLbl.add(lblSerialized);
        pnlAllMIDLbls.add(pnlSerializedMIDLbl);
        pnlMidCommand.add(pnlAllMIDLbls);
        // MID Command and input vals section
        JPanel pnlMIDDtlFlds = new JPanel();
        pnlMIDDtlFlds.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioH), 70));
        pnlMIDDtlFlds.setMaximumSize(pnlMIDDtlFlds.getPreferredSize());
        pnlMIDDtlFlds.setMinimumSize(pnlMIDDtlFlds.getPreferredSize());
        pnlMIDDtlFlds.setLayout(new BoxLayout(pnlMIDDtlFlds, BoxLayout.Y_AXIS));
//        pnlMIDDtlFlds.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMIDDtlFlds.setAlignmentY(Component.CENTER_ALIGNMENT);
        JPanel pnlMIDDtlCmdInVFlds = new JPanel();
        pnlMIDDtlCmdInVFlds.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioH), 30));
        pnlMIDDtlCmdInVFlds.setMaximumSize(pnlMIDDtlCmdInVFlds.getPreferredSize());
        pnlMIDDtlCmdInVFlds.setMinimumSize(pnlMIDDtlCmdInVFlds.getPreferredSize());
        pnlMIDDtlCmdInVFlds.setLayout(new BoxLayout(pnlMIDDtlCmdInVFlds, BoxLayout.X_AXIS));
        // call method to get list of commands as dropdown.
        String[] midCmdDd = cmdList();
        JComboBox<String> midCmdCB = new JComboBox<>(midCmdDd);
//        midCmdCB.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
//        midCmdCB.setBorder(BorderFactory.createLineBorder(Color.white, 1));
//        midCmdCB.setBorder(BorderFactory.createLineBorder(frame.getBackground()));
//        UIManager.put("ComoboBox.border", BorderFactory.createEmptyBorder());
//        UIManager.put("ComboBox.border", new Insets(0, 0, 0, 0));
        midCmdCB.setBorder(BorderFactory.createEmptyBorder());
        midCmdCB.setBorder(null);
        midCmdCB.setAlignmentX(Component.LEFT_ALIGNMENT);
        midCmdCB.setToolTipText("'MID' Command");
        midCmdCB.setEditable(true);
        midCmdCB.setBackground(Color.white);
        midCmdCB.addActionListener(e -> {
            midCmdCB.setVisible(true);
            midCmdCB.setPopupVisible(true);
            String midString = midCmdCB.getEditor().getItem().toString();
            ArrayList<String> filterMIDs = new ArrayList<>();
            for (String mid : midCmdDd) {
                if (mid.toLowerCase().contains(midString.toLowerCase())) {
                    filterMIDs.add(mid);
                }
                else {
                    for (String m : midCmdDd) {
                        if (!filterMIDs.contains(m)) {
                            filterMIDs.add(m);
                        }
                    }
                }
            }
            midCmdCB.setModel(new DefaultComboBoxModel<>(filterMIDs.toArray(new String[0])));
        });
        pnlMIDDtlCmdInVFlds.add(midCmdCB);
        JPanel pnlMIDDtlInFlds = new JPanel();
        pnlMIDDtlInFlds.setPreferredSize(new Dimension(110, 30));
        pnlMIDDtlInFlds.setMaximumSize(pnlMIDDtlInFlds.getPreferredSize());
        pnlMIDDtlInFlds.setMinimumSize(pnlMIDDtlInFlds.getPreferredSize());
//        pnlMIDDtlInFlds.setLayout(new BoxLayout(pnlMIDDtlInFlds, BoxLayout.X_AXIS));
//        pnlMIDDtlInFlds.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel lblVals = new JLabel("Input Values:");
        lblVals.setAlignmentX(Component.CENTER_ALIGNMENT);
//        pnlMIDDtlCmdInVFlds.add(lblVals);
        pnlMIDDtlInFlds.add(lblVals);
        pnlMIDDtlCmdInVFlds.add(pnlMIDDtlInFlds);
        JTextField midInputString = new JTextField();
        midInputString.setToolTipText("include MID command values if applicable.");
        midInputString.setAlignmentX(Component.LEFT_ALIGNMENT);
//        midInputString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlMIDDtlCmdInVFlds.add(midInputString);
        pnlMIDDtlFlds.add(pnlMIDDtlCmdInVFlds);
        JPanel pnlMIDDtlFldsPd = new JPanel();
        pnlMIDDtlFldsPd.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioH), 5));
        pnlMIDDtlFldsPd.setMaximumSize(pnlMIDDtlFldsPd.getPreferredSize());
        pnlMIDDtlFldsPd.setMinimumSize(pnlMIDDtlFldsPd.getPreferredSize());
//        pnlMIDDtlFldsPd.setPreferredSize(new Dimension(-1, 5));
        pnlMIDDtlFlds.add(pnlMIDDtlFldsPd);
        JPanel pnlMIDDtlSrlzdFlds = new JPanel();
        pnlMIDDtlSrlzdFlds.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioH), 30));
        pnlMIDDtlSrlzdFlds.setMaximumSize(pnlMIDDtlSrlzdFlds.getPreferredSize());
        pnlMIDDtlSrlzdFlds.setMinimumSize(pnlMIDDtlSrlzdFlds.getPreferredSize());
        pnlMIDDtlSrlzdFlds.setLayout(new BoxLayout(pnlMIDDtlSrlzdFlds, BoxLayout.X_AXIS));
        JTextField serializedMidString = new JTextField();
        serializedMidString.setToolTipText("include serialized MID message.");
        serializedMidString.setAlignmentX(Component.LEFT_ALIGNMENT);
//        serializedMidString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlMIDDtlSrlzdFlds.add(serializedMidString);
        pnlMIDDtlFlds.add(pnlMIDDtlSrlzdFlds);
        pnlMidCommand.add(pnlMIDDtlFlds);
        // MID Send JPanels
        JPanel pnlSendMID = new JPanel();
        pnlSendMID.setLayout(new BoxLayout(pnlSendMID, BoxLayout.Y_AXIS));
        pnlSendMID.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioE), 70));
        pnlSendMID.setMaximumSize(pnlSendMID.getPreferredSize());
        pnlSendMID.setMinimumSize(pnlSendMID.getPreferredSize());
        pnlSendMID.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnlSendMID.setAlignmentX(Component.RIGHT_ALIGNMENT);
        pnlSendMID.setAlignmentY(Component.CENTER_ALIGNMENT);
        // main mid container
        JButton btnSendMid = new JButton("Send");
        btnSendMid.setAlignmentY(Component.TOP_ALIGNMENT);
//        btnSendMid.setAlignmentY(Component.CENTER_ALIGNMENT);
//        btnSendMid.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnSendMid.setPreferredSize(new Dimension(100, 30));
        btnSendMid.setMaximumSize(btnSendMid.getPreferredSize());
        btnSendMid.setMinimumSize(btnSendMid.getPreferredSize());
//        btnSendMid.setMaximumSize(new Dimension(125, 30));
//        btnSendMid.setMinimumSize(new Dimension(125, 30));
        pnlSendMID.add(btnSendMid);
        JPanel pnlSendMIDPd = new JPanel();
        pnlSendMIDPd.setPreferredSize(new Dimension(100, 5));
//        pnlSendMIDPd.setMaximumSize(new Dimension(125, 5));
//        pnlSendMIDPd.setMinimumSize(new Dimension(125, 5));
        pnlSendMIDPd.setMaximumSize(pnlSendMIDPd.getPreferredSize());
        pnlSendMIDPd.setMinimumSize(pnlSendMIDPd.getPreferredSize());
//        pnlSendMIDPd.setPreferredSize(new Dimension(-1, 5));
        pnlSendMID.add(pnlSendMIDPd);
        JButton btnSendSerializedMid = new JButton("Send");
        btnSendSerializedMid.setAlignmentY(Component.TOP_ALIGNMENT);
        btnSendSerializedMid.setAlignmentY(Component.CENTER_ALIGNMENT);
//        btnSendSerializedMid.setPreferredSize(new Dimension(pnlSendMID.getWidth(), 45));
        btnSendSerializedMid.setPreferredSize(new Dimension(100, 30));
        btnSendSerializedMid.setMaximumSize(btnSendSerializedMid.getPreferredSize());
        btnSendSerializedMid.setMinimumSize(btnSendSerializedMid.getPreferredSize());
//        btnSendSerializedMid.setAlignmentX(Component.LEFT_ALIGNMENT);
//        btnSendSerializedMid.setMaximumSize(new Dimension(125, 30));
//        btnSendSerializedMid.setMinimumSize(new Dimension(125, 30));
//        btnSendSerializedMid.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 25));
//        btnSendSerializedMid.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        pnlSendMID.add(btnSendSerializedMid);
        pnlMidCommand.add(pnlSendMID);
        pnlMidContainer.add(pnlMidCommand);

        pnlSubConatiner3.add(pnlMidContainer);
        pnlMainContainer.add(pnlSubConatiner3);
        //
        //dialog panel
        JPanel pnlSubConatiner4 = new JPanel();
        pnlSubConatiner4.setLayout(new BoxLayout(pnlSubConatiner4, BoxLayout.X_AXIS));
        pnlSubConatiner4.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubConatiner4.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSubConatiner4.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioA), (int) (frame.getHeight() * pnlHRatioC)));
//        pnlSubConatiner4.setMaximumSize(pnlSubConatiner4.getPreferredSize());
//        pnlSubConatiner4.setMinimumSize(pnlSubConatiner4.getPreferredSize());
        pnlSubConatiner4.setBorder(BorderFactory.createEmptyBorder(0, (int) (frame.getWidth() * pnlWRatioG)
                , (int) (frame.getHeight() * pnlHRatioD)
                , (int) (frame.getWidth() * pnlWRatioG)));
        // dialog box text area
        // Dialog section
        JPanel pnlDialogContainer = new JPanel();
//        pnlDialogContainer.setMaximumSize(new Dimension(1300, 600));
//        pnlDialogContainer.setMinimumSize(new Dimension(750, 300));
//        pnlDialogContainer.setPreferredSize(pnlSubConatiner4.getPreferredSize());
////        pnlDialogContainer.setMaximumSize(pnlMainContainer.getMaximumSize());
//        pnlDialogContainer.setMaximumSize(pnlSubConatiner4.getMaximumSize());
//        pnlDialogContainer.setMinimumSize(pnlSubConatiner4.getMaximumSize());
        pnlDialogContainer.setLayout(new BoxLayout(pnlDialogContainer, BoxLayout.Y_AXIS));
        pnlDialogContainer.setAlignmentY(Component.CENTER_ALIGNMENT);
        // Dialog Header
        JLabel lblDialog = new JLabel("Communication Log");
        lblDialog.setFont(new Font("Courier", Font.BOLD, 14));
//        lblDialog.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblDialog.setAlignmentY(Component.TOP_ALIGNMENT);
        lblDialog.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblDialog.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        pnlDialogContainer.add(lblDialog);
        // mid command container
        JPanel pnldialogBox = new JPanel();
        pnldialogBox.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioF), (int) (frame.getHeight() * pnlHRatioC)));
        pnldialogBox.setLayout(new BoxLayout(pnldialogBox, BoxLayout.X_AXIS));
        pnldialogBox.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnldialogBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        JTextArea dialogBox = new JTextArea();
        JTextArea dialogBox = new JTextArea();
        dialogBox.setLineWrap(true);
        dialogBox.setAlignmentX(Component.LEFT_ALIGNMENT);
//        dialogBox.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        dialogBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        JScrollPane scrollDialogContainer = new JScrollPane(dialogBox);
        pnldialogBox.add(scrollDialogContainer);
        pnlDialogContainer.add(pnldialogBox);
        pnlSubConatiner4.add(pnlDialogContainer);

        pnlMainContainer.add(pnlSubConatiner4);
        //
        // Exit Section
        JPanel pnlSubConatiner5 = new JPanel();
        pnlSubConatiner5.setLayout(new BoxLayout(pnlSubConatiner5, BoxLayout.Y_AXIS));
        pnlSubConatiner5.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubConatiner5.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSubConatiner5.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioA), (int) (frame.getHeight() * pnlHRatioB)));
        pnlSubConatiner5.setMaximumSize(pnlSubConatiner5.getPreferredSize());
        pnlSubConatiner5.setMinimumSize(pnlSubConatiner5.getPreferredSize());
        JButton btnExit = new JButton("Exit");
        btnExit.setLayout(new BoxLayout(btnExit, BoxLayout.X_AXIS));
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.setAlignmentY(Component.CENTER_ALIGNMENT);
//        btnExit.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioI), (int) (frame.getHeight() * pnlHRatioB)));
        btnExit.setPreferredSize(new Dimension((int) (frame.getWidth() * pnlWRatioI), 30));
        btnExit.setMaximumSize(btnExit.getPreferredSize());
        btnExit.setMinimumSize(btnExit.getPreferredSize());
//        pnlMainContainer.add(btnExit);
        pnlSubConatiner5.add(btnExit);
        pnlMainContainer.add(pnlSubConatiner5);

        //
        // complete main container
//        frame.add(pnlMainContainer);
        frame.setContentPane(pnlMainContainer);
//        frame.getContentPane().add(pnlMainContainer);
        frame.pack();

        frame.setVisible(true);

        btnConnect.addActionListener(a -> {
            //
            try {
                String inputIdAddress = ipString.getText();
                int inputPortId = Integer.parseInt(portString.getText());

                int initDelay = (int) Float.parseFloat(initTimeout.getText());
                int checkPeriod = (int) Float.parseFloat(timeoutDelay.getText());

                hClient.startConnection(inputIdAddress, inputPortId, dialogBox, initDelay, checkPeriod);
                //append & log the connection
                appendDialog(dialogBox, "Connect to:\n" + inputIdAddress + ": " + inputPortId);
                hostLogger.hostLog("host2Controller", "host connected to " + inputIdAddress + ": " + inputPortId, "info");

                //
                String startMid = "MID0001";
                //append & log the input
                appendDialog(dialogBox, "host message: \n" + startMid);
                hostLogger.hostLog("host2Controller", "host message: " + startMid, "info");

                //append & log the input
                String integratorMsg = oPCS.integratorString(startMid);
                appendDialog(dialogBox, "host message serialized: \n" + integratorMsg);
                hostLogger.hostLog("host2Controller", "host message serialized: " + integratorMsg, "info");

                String serverResponse = hClient.sendMessage(integratorMsg);
                appendDialog(dialogBox, "controller message serialized: \n" + serverResponse);
                hostLogger.hostLog("host2Controller", "controller message serialized: " + serverResponse, "info");

                Object serverResponseParsed = oPCP.parseMessage(serverResponse);
                appendDialog(dialogBox, "controller message parsed: \n" + serverResponseParsed);
                hostLogger.hostLog("host2Controller", "controller message parsed: " + serverResponseParsed, "info");

            } catch (Throwable o) {
                ZonedDateTime zonedDateTime = ZonedDateTime.now();
                //
                String jsonTimestamp = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSxxx"));
//                    System.out.println("IO Exception in connection button\n" + o.getMessage() + "\n @ " + jsonTimestamp);
                hostLogger.hostLog("host2Controller", "IO Exception in connection button\n" + o.getMessage() + "\n @ " + jsonTimestamp, "error");
//                    o.printStackTrace();
            }
        });
        btnSendMid.addActionListener(b -> {
            //
            try {
//                System.out.println("attempting to get the combo box value");
//                try {
//                    System.out.println("get action cmd: " + midCmdCB.getActionCommand());
//                    System.out.println("get action: " + midCmdCB.getAction());
//                    System.out.println("getPrototypeDisplayValue: " + midCmdCB.getPrototypeDisplayValue());
//                    System.out.println("getItemAt: " + midCmdCB.getItemAt(0));
//                } catch (Throwable j) {
//                    System.out.println("no luck with combobox: " + j.getMessage());
//                }
//                String midCommand = midString.getText();
//                String midCommand = midCmdCB.toString();
                String midCommand = midCmdCB.getItemAt(0);
                System.out.println("the combobox input was : " + midCommand);
                String midValues = midInputString.getText();
                //append & log the input
                appendDialog(dialogBox, "host message: \n" + midCommand + " " + midValues);
                hostLogger.hostLog("host2Controller", "host message: " + midCommand + " " + midValues, "info");

                //append & log the input
                String integratorMsg = oPCS.integratorString(midCommand + " " + midValues);
                appendDialog(dialogBox, "host message serialized: \n" + integratorMsg);
                hostLogger.hostLog("host2Controller", "host message serialized: " + integratorMsg, "info");

                String serverResponse = hClient.sendMessage(integratorMsg);
                appendDialog(dialogBox, "controller message serialized: \n" + serverResponse);
                hostLogger.hostLog("host2Controller", "controller message serialized: " + serverResponse, "info");

                Object serverResponseParsed = oPCP.parseMessage(serverResponse);
                appendDialog(dialogBox, "controller message parsed: \n" + serverResponseParsed);
                hostLogger.hostLog("host2Controller", "controller message parsed: " + serverResponseParsed, "info");

            } catch (Throwable o) {
                ZonedDateTime zonedDateTime = ZonedDateTime.now();
                //
                String jsonTimestamp = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSxxx"));
//                    System.out.println("IO Exception in mid send button\n" + o.getMessage() + "\n @ " + jsonTimestamp);
                hostLogger.hostLog("host2Controller", "IO Exception in mid send button\n" + o.getMessage() + "\n @ " + jsonTimestamp, "error");
//                    o.printStackTrace();
            }
        });
        btnSendSerializedMid.addActionListener(c -> {
            //
            try {
                String serializedMidCommand = serializedMidString.getText();
                //append & log the input
                appendDialog(dialogBox, "host message: \n" + serializedMidCommand);
                hostLogger.hostLog("host2Controller", "host message: " + serializedMidCommand, "info");

                String serverResponse = hClient.sendMessage(serializedMidCommand);
                appendDialog(dialogBox, "controller message serialized: \n" + serverResponse);
                hostLogger.hostLog("host2Controller", "controller message serialized: " + serverResponse, "info");

                Object serverResponseParsed = oPCP.parseMessage(serverResponse);
                appendDialog(dialogBox, "controller message parsed: \n" + serverResponseParsed);
                hostLogger.hostLog("host2Controller", "controller message parsed: " + serverResponseParsed, "info");

            } catch (Throwable o) {
                ZonedDateTime zonedDateTime = ZonedDateTime.now();
                //
                String jsonTimestamp = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSxxx"));
//                    System.out.println("IO Exception in serialized mid send button\n" + o.getMessage() + "\n @ " + jsonTimestamp);
                hostLogger.hostLog("host2Controller", "IO Exception in serialized mid send button\n" + o.getMessage() + "\n @ " + jsonTimestamp, "error");
//                    o.printStackTrace();
            }
        });
        btnExit.addActionListener(e -> {
            try {
                hostLogger.hostLog("exit", "exit button", "info");
                hClient.stopConnection();
            } catch (Throwable b) {
//                    System.out.println("Exit Window, can't stop connection\n" + b.getMessage());
                hostLogger.hostLog("exit", "Exit Window, can't stop connection\n" + b.getMessage(), "error");
//                    b.printStackTrace();
            }
            System.exit(0);
        });
    }
    //
    static void appendDialog(JTextArea tArea, String dialog){
        tArea.append(dialog);
        tArea.append("\n\n");
    }
    public static void main(String[] args) {
        // 1.a. create dialog
        createDialog();
    }
}
