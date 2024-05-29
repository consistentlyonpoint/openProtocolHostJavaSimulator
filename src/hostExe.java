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
    // initialized variables
    public static JTextField ipString;
    public static JTextField portString;
    public static JTextField initTimeout;
    public static JTextField timeoutDelay;
    public static JTextField ctrlName;
    public static JTextField midInputString;
    public static JTextField serializedMidString;
//    public static JComboBox<String> midCmdCB;
    public static JTextArea dialogBox;
    public static JButton btnConnect;
    public static JButton btnSendMid;
    public static JButton btnSendSerializedMid;
    public static hostClient hClient = new hostClient();
    public static openProtocolClientParserMIDClass oPCP = new openProtocolClientParserMIDClass();
    public static openProtocolClientSerializerMIDClass oPCS = new openProtocolClientSerializerMIDClass();
    // Host Frame
    public static JFrame hostFrame = new JFrame("Host");
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
//    public static JPanel connectPanel(JFrame hostFrame, JTextField ipString, JTextField portString, JTextField ctrlName
//            , double pnlWRatioH) {
    public static JPanel connectPanel(double pnlWRatio1)  {
        // Connection JPanels
        JPanel pnlCnctMain = new JPanel();
        pnlCnctMain.setLayout(new BoxLayout(pnlCnctMain, BoxLayout.Y_AXIS));
        pnlCnctMain.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlCnctMain.setAlignmentY(Component.CENTER_ALIGNMENT);
        // Connection Header
        JLabel lblManualConnect = new JLabel("Connection");
        lblManualConnect.setFont(new Font("Courier", Font.BOLD, 16));
//        lblManualConnect.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblManualConnect.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblManualConnect.setAlignmentY(Component.TOP_ALIGNMENT);
        lblManualConnect.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        pnlCnctMain.add(lblManualConnect);
        // Connect Detail
        JPanel pnlCnctDtl = new JPanel();
        pnlCnctDtl.setLayout(new BoxLayout(pnlCnctDtl, BoxLayout.X_AXIS));
//        pnlCnctDtl.setAlignmentX(Component.LEFT_ALIGNMENT);
        // labels
        JPanel pnlCnctLbls = new JPanel();
        pnlCnctLbls.setPreferredSize(new Dimension(85, 70));
//        pnlCnctLbls.setMaximumSize(new Dimension(85, 70));
//        pnlCnctLbls.setMinimumSize(new Dimension(50, 70));
        pnlCnctLbls.setMaximumSize(pnlCnctLbls.getPreferredSize());
//        pnlCnctLbls.setMinimumSize(pnlCnctLbls.getPreferredSize());
        pnlCnctLbls.setLayout(new BoxLayout(pnlCnctLbls, BoxLayout.Y_AXIS));
        pnlCnctLbls.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlCnctipLbl = new JPanel();
        pnlCnctipLbl.setMaximumSize(new Dimension(85, 30));
//        pnlCnctipLbl.setMinimumSize(new Dimension(50, 30));
        pnlCnctipLbl.setLayout(new BoxLayout(pnlCnctipLbl, BoxLayout.X_AXIS));
        JLabel ipLbl = new JLabel("Host:");
        ipLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlCnctipLbl.add(ipLbl);
        pnlCnctLbls.add(pnlCnctipLbl);
        JPanel pnlCnctLblpd = new JPanel();
        pnlCnctLblpd.setMaximumSize(new Dimension(85, 5));
        pnlCnctLblpd.setMinimumSize(new Dimension(50, 5));
        pnlCnctLbls.add(pnlCnctLblpd);
        JPanel pnlCnctlblCtrl = new JPanel();
        pnlCnctlblCtrl.setMaximumSize(new Dimension(85, 30));
        pnlCnctlblCtrl.setMinimumSize(new Dimension(50, 30));
        pnlCnctlblCtrl.setLayout(new BoxLayout(pnlCnctlblCtrl, BoxLayout.X_AXIS));
        JLabel lblCtrl = new JLabel("Device:");
        lblCtrl.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlCnctlblCtrl.add(lblCtrl);
        pnlCnctLbls.add(pnlCnctlblCtrl);
        pnlCnctDtl.add(pnlCnctLbls);
        // ip, port text areas (x) + device (y)
        JPanel pnlCnctDtlFlds = new JPanel();
//        pnlCnctDtlFlds.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioH), 70));
//        pnlCnctDtlFlds.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatio1), 70));
//        pnlCnctDtlFlds.setPreferredSize(new Dimension(pnlSubContainer1a.getWidth(), 70));
//        pnlCnctDtlFlds.setMaximumSize(pnlCnctDtlFlds.getPreferredSize());
//        pnlCnctDtlFlds.setMinimumSize(pnlCnctDtlFlds.getPreferredSize());
        pnlCnctDtlFlds.setLayout(new BoxLayout(pnlCnctDtlFlds, BoxLayout.Y_AXIS));
        pnlCnctDtlFlds.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlCnctDtlFlds.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlCnctDtlIpPortFlds = new JPanel();
//        pnlCnctDtlIpPortFlds.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioH), 30));
        pnlCnctDtlIpPortFlds.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatio1), 30));
        pnlCnctDtlIpPortFlds.setMaximumSize(pnlCnctDtlIpPortFlds.getPreferredSize());
//        pnlCnctDtlIpPortFlds.setMinimumSize(pnlCnctDtlIpPortFlds.getPreferredSize());
        pnlCnctDtlIpPortFlds.setLayout(new BoxLayout(pnlCnctDtlIpPortFlds, BoxLayout.X_AXIS));
        ipString = new JTextField("127.0.0.1");
        ipString.setToolTipText("Device/Controller IP Address required.");
        ipString.setAlignmentX(Component.LEFT_ALIGNMENT);
//        ipString.setAlignmentY(Component.TOP_ALIGNMENT);
//        ipString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        ipString.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pnlCnctDtlIpPortFlds.add(ipString);
        JPanel pnlCnctDtlPortFldsLbl = new JPanel();
        pnlCnctDtlPortFldsLbl.setPreferredSize(new Dimension(65, 30));
        pnlCnctDtlPortFldsLbl.setMaximumSize(pnlCnctDtlPortFldsLbl.getPreferredSize());
//        pnlCnctDtlPortFldsLbl.setMinimumSize(pnlCnctDtlPortFldsLbl.getPreferredSize());
        JLabel portLbl = new JLabel("Port: ");
        portLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
//        portLbl.setAlignmentY(Component.CENTER_ALIGNMENT);
//        portLbl.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 35));
        pnlCnctDtlPortFldsLbl.add(portLbl);
//        pnlCnctDtlIpPortFlds.add(portLbl);
        pnlCnctDtlIpPortFlds.add(pnlCnctDtlPortFldsLbl);
        portString = new JTextField("4545");
        portString.setToolTipText("Device/Controller Port Id required.");
        portString.setAlignmentX(Component.LEFT_ALIGNMENT);
//        portString.setAlignmentY(Component.TOP_ALIGNMENT);
//        portString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        portString.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pnlCnctDtlIpPortFlds.add(portString);
        pnlCnctDtlFlds.add(pnlCnctDtlIpPortFlds);
        JPanel pnlCnctDtlFldspd = new JPanel();
//        pnlCnctDtlFldspd.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioH), 5));
        pnlCnctDtlFldspd.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatio1), 5));
        pnlCnctDtlFldspd.setMaximumSize(pnlCnctDtlFldspd.getPreferredSize());
//        pnlCnctDtlFldspd.setMinimumSize(pnlCnctDtlFldspd.getPreferredSize());
        pnlCnctDtlFlds.add(pnlCnctDtlFldspd);
        JPanel pnlCnctDtlctrlNameFlds = new JPanel();
//        pnlCnctDtlctrlNameFlds.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioH), 30));
        pnlCnctDtlctrlNameFlds.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatio1), 30));
        pnlCnctDtlctrlNameFlds.setMaximumSize(pnlCnctDtlctrlNameFlds.getPreferredSize());
//        pnlCnctDtlctrlNameFlds.setMinimumSize(pnlCnctDtlctrlNameFlds.getPreferredSize());
        pnlCnctDtlctrlNameFlds.setLayout(new BoxLayout(pnlCnctDtlctrlNameFlds, BoxLayout.X_AXIS));
        ctrlName = new JTextField("deviceName");
        ctrlName.setToolTipText("Device/Controller Name.");
        ctrlName.setAlignmentX(Component.LEFT_ALIGNMENT);
//        ctrlName.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        ctrlName.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        ctrlName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pnlCnctDtlctrlNameFlds.add(ctrlName);
        pnlCnctDtlFlds.add(pnlCnctDtlctrlNameFlds);
        pnlCnctDtl.add(pnlCnctDtlFlds);
        pnlCnctMain.add(pnlCnctDtl);
        //
        return pnlCnctMain;
    }
    //
//    public static JPanel timingPanel(JFrame hostFrame, JTextField ipString, JTextField portString, JTextField ctrlName
//            , double pnlWRatioH) {
    public static JPanel timingPanel() {
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
        initTimeout = new JTextField("75.0");
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
        timeoutDelay = new JTextField("65.0");
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
        //
        return pnlTmMain;
    }
    //
//    public static JPanel midPanel(double pnlHRatioA, double pnlWRatioE, double pnlWRatioF, double pnlWRatioG
//            , double pnlWRatioH, String[] midCmdDd, JComboBox<String> midCmdCB) {
//    public static JPanel midPanel(double pnlHRatio1, double pnlWRatio1, double pnlWRatio2
//            , double pnlWRatio3, String[] midCmdDd, JComboBox<String> midCmdCB) {
    public static JPanel midPanel(double pnlWRatio2, String[] midCmdDd, JComboBox<String> midCmdCB) {
        // MID section
        JPanel pnlMidContainer = new JPanel();
        pnlMidContainer.setLayout(new BoxLayout(pnlMidContainer, BoxLayout.Y_AXIS));
        pnlMidContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
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
//        pnlMidCommand.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioF), (int) (hostFrame.getHeight() * pnlHRatioA)));
//        pnlMidCommand.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatio1), (int) (hostFrame.getHeight() * pnlHRatio1)));
//        pnlMidCommand.setMaximumSize(new Dimension(pnlMidCommand.getPreferredSize()));
        pnlMidCommand.setLayout(new BoxLayout(pnlMidCommand, BoxLayout.X_AXIS));
        pnlMidCommand.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnlMidCommand.setAlignmentY(Component.CENTER_ALIGNMENT);
//        pnlMidCommand.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,  (int) (hostFrame.getWidth() * pnlWRatioG)));
//        pnlMidCommand.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,  (int) (hostFrame.getWidth() * pnlWRatio3)));
        // labels
        JPanel pnlAllMIDLbls = new JPanel();
        pnlAllMIDLbls.setPreferredSize(new Dimension(150, 70));
//        pnlAllMIDLbls.setMaximumSize(new Dimension(200, 70));
        pnlAllMIDLbls.setMaximumSize(pnlAllMIDLbls.getPreferredSize());
        pnlAllMIDLbls.setMinimumSize(new Dimension(100, 70));
        pnlAllMIDLbls.setLayout(new BoxLayout(pnlAllMIDLbls, BoxLayout.Y_AXIS));
        pnlAllMIDLbls.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlMIDLbl = new JPanel();
        pnlMIDLbl.setMaximumSize(new Dimension(150, 30));
        pnlMIDLbl.setMinimumSize(new Dimension(100, 30));
        pnlMIDLbl.setLayout(new BoxLayout(pnlMIDLbl, BoxLayout.X_AXIS));
        JLabel lblMID = new JLabel("MID Command:");
        lblMID.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMIDLbl.add(lblMID);
        pnlAllMIDLbls.add(pnlMIDLbl);
        JPanel pnlAllMIDpd = new JPanel();
        pnlAllMIDpd.setMaximumSize(new Dimension(150, 5));
        pnlAllMIDpd.setMinimumSize(new Dimension(100, 5));
        pnlAllMIDLbls.add(pnlAllMIDpd);
        JPanel pnlSerializedMIDLbl = new JPanel();
        pnlSerializedMIDLbl.setMaximumSize(new Dimension(150, 30));
        pnlSerializedMIDLbl.setMinimumSize(new Dimension(100, 30));
        pnlSerializedMIDLbl.setLayout(new BoxLayout(pnlSerializedMIDLbl, BoxLayout.X_AXIS));
        JLabel lblSerialized = new JLabel("Serialized MID:");
        lblSerialized.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSerializedMIDLbl.add(lblSerialized);
        pnlAllMIDLbls.add(pnlSerializedMIDLbl);
        pnlMidCommand.add(pnlAllMIDLbls);
        // MID Command and input vals section
        JPanel pnlMIDDtlFlds = new JPanel();
//        pnlMIDDtlFlds.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatio2), 70));
//        pnlMIDDtlFlds.setMaximumSize(pnlMIDDtlFlds.getPreferredSize());
//        pnlMIDDtlFlds.setMinimumSize(pnlMIDDtlFlds.getPreferredSize());
        pnlMIDDtlFlds.setLayout(new BoxLayout(pnlMIDDtlFlds, BoxLayout.Y_AXIS));
//        pnlMIDDtlFlds.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMIDDtlFlds.setAlignmentY(Component.CENTER_ALIGNMENT);
        JPanel pnlMIDDtlCmdInVFlds = new JPanel();
        pnlMIDDtlCmdInVFlds.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatio2), 30));
        pnlMIDDtlCmdInVFlds.setMaximumSize(pnlMIDDtlCmdInVFlds.getPreferredSize());
//        pnlMIDDtlCmdInVFlds.setMinimumSize(pnlMIDDtlCmdInVFlds.getPreferredSize());
        pnlMIDDtlCmdInVFlds.setLayout(new BoxLayout(pnlMIDDtlCmdInVFlds, BoxLayout.X_AXIS));
        // call method to get list of commands as dropdown.
//        midCmdCB.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
//        midCmdCB.setBorder(BorderFactory.createLineBorder(Color.white, 1));
//        midCmdCB.setBorder(BorderFactory.createLineBorder(hostFrame.getBackground()));
//        UIManager.put("ComoboBox.border", BorderFactory.createEmptyBorder());
//        UIManager.put("ComboBox.border", new Insets(0, 0, 0, 0));
//        midCmdCB.setBorder(BorderFactory.createEmptyBorder());
        midCmdCB.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
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
//                else {
//                    for (String m : midCmdDd) {
//                        if (!filterMIDs.contains(m)) {
//                            filterMIDs.add(m);
//                        }
//                    }
//                }
            }
            midCmdCB.setModel(new DefaultComboBoxModel<>(filterMIDs.toArray(new String[0])));
        });
        pnlMIDDtlCmdInVFlds.add(midCmdCB);
        JPanel pnlMIDDtlInFlds = new JPanel();
        pnlMIDDtlInFlds.setPreferredSize(new Dimension(110, 30));
        pnlMIDDtlInFlds.setMaximumSize(pnlMIDDtlInFlds.getPreferredSize());
//        pnlMIDDtlInFlds.setMinimumSize(pnlMIDDtlInFlds.getPreferredSize());
//        pnlMIDDtlInFlds.setLayout(new BoxLayout(pnlMIDDtlInFlds, BoxLayout.X_AXIS));
//        pnlMIDDtlInFlds.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel lblVals = new JLabel("Input Values:");
        lblVals.setAlignmentX(Component.CENTER_ALIGNMENT);
//        pnlMIDDtlCmdInVFlds.add(lblVals);
        pnlMIDDtlInFlds.add(lblVals);
        pnlMIDDtlCmdInVFlds.add(pnlMIDDtlInFlds);
//        JTextField midInputString = new JTextField();
        midInputString = new JTextField();
        midInputString.setToolTipText("include MID command values if applicable.");
        midInputString.setAlignmentX(Component.LEFT_ALIGNMENT);
//        midInputString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        midInputString.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
//        midInputString.add(midCmdCB);
        pnlMIDDtlCmdInVFlds.add(midInputString);
        pnlMIDDtlFlds.add(pnlMIDDtlCmdInVFlds);
        JPanel pnlMIDDtlFldsPd = new JPanel();
        pnlMIDDtlFldsPd.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatio2), 5));
        pnlMIDDtlFldsPd.setMaximumSize(pnlMIDDtlFldsPd.getPreferredSize());
//        pnlMIDDtlFldsPd.setMinimumSize(pnlMIDDtlFldsPd.getPreferredSize());
//        pnlMIDDtlFldsPd.setPreferredSize(new Dimension(-1, 5));
        pnlMIDDtlFlds.add(pnlMIDDtlFldsPd);
        JPanel pnlMIDDtlSrlzdFlds = new JPanel();
        pnlMIDDtlSrlzdFlds.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatio2), 30));
        pnlMIDDtlSrlzdFlds.setMaximumSize(pnlMIDDtlSrlzdFlds.getPreferredSize());
//        pnlMIDDtlSrlzdFlds.setMinimumSize(pnlMIDDtlSrlzdFlds.getPreferredSize());
        pnlMIDDtlSrlzdFlds.setLayout(new BoxLayout(pnlMIDDtlSrlzdFlds, BoxLayout.X_AXIS));
//        JTextField serializedMidString = new JTextField();
        serializedMidString = new JTextField();
        serializedMidString.setToolTipText("include serialized MID message.");
        serializedMidString.setAlignmentX(Component.LEFT_ALIGNMENT);
//        serializedMidString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        serializedMidString.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pnlMIDDtlSrlzdFlds.add(serializedMidString);
        pnlMIDDtlFlds.add(pnlMIDDtlSrlzdFlds);
        pnlMidCommand.add(pnlMIDDtlFlds);
        pnlMidContainer.add(pnlMidCommand);
        //
        return pnlMidContainer;
    }
    //
    public static JPanel sendPanel() {
        // MID Send JPanels
        JPanel pnlSendMID = new JPanel();
        pnlSendMID.setLayout(new BoxLayout(pnlSendMID, BoxLayout.Y_AXIS));
//        pnlSendMID.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioE), 70));
//        pnlSendMID.setMaximumSize(pnlSendMID.getPreferredSize());
//        pnlSendMID.setMinimumSize(pnlSendMID.getPreferredSize());
        pnlSendMID.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnlSendMID.setAlignmentX(Component.RIGHT_ALIGNMENT);
        pnlSendMID.setAlignmentY(Component.CENTER_ALIGNMENT);
        // Connection Header
        JLabel blankLabel = new JLabel(" ");
        blankLabel.setFont(new Font("Courier", Font.BOLD, 14));
//        blankLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        blankLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        blankLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        blankLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        pnlSendMID.add(blankLabel);
        // main mid container
//        JButton btnSendMid = new JButton("Send");
        btnSendMid = new JButton("send");
//        btnSendMid.setAlignmentY(Component.TOP_ALIGNMENT);
//        btnSendMid.setAlignmentY(Component.CENTER_ALIGNMENT);
//        btnSendMid.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnSendMid.setPreferredSize(new Dimension(100, 30));
        btnSendMid.setMaximumSize(btnSendMid.getPreferredSize());
        btnSendMid.setMinimumSize(btnSendMid.getPreferredSize());
//        btnSendMid.setMaximumSize(new Dimension(125, 30));
//        btnSendMid.setMinimumSize(new Dimension(125, 30));
        btnSendMid.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSendMID.add(btnSendMid);
        JPanel pnlSendMIDPd = new JPanel();
        pnlSendMIDPd.setPreferredSize(new Dimension(100, 5));
//        pnlSendMIDPd.setMaximumSize(new Dimension(125, 5));
//        pnlSendMIDPd.setMinimumSize(new Dimension(125, 5));
        pnlSendMIDPd.setMaximumSize(pnlSendMIDPd.getPreferredSize());
        pnlSendMIDPd.setMinimumSize(pnlSendMIDPd.getPreferredSize());
//        pnlSendMIDPd.setPreferredSize(new Dimension(-1, 5));
        pnlSendMID.add(pnlSendMIDPd);
//        JButton btnSendSerializedMid = new JButton("Send");
        btnSendSerializedMid = new JButton("send");
//        btnSendSerializedMid.setAlignmentY(Component.TOP_ALIGNMENT);
//        btnSendSerializedMid.setAlignmentY(Component.CENTER_ALIGNMENT);
//        btnSendSerializedMid.setPreferredSize(new Dimension(pnlSendMID.getWidth(), 45));
        btnSendSerializedMid.setPreferredSize(new Dimension(100, 30));
        btnSendSerializedMid.setMaximumSize(btnSendSerializedMid.getPreferredSize());
        btnSendSerializedMid.setMinimumSize(btnSendSerializedMid.getPreferredSize());
        btnSendSerializedMid.setAlignmentX(Component.LEFT_ALIGNMENT);
//        btnSendSerializedMid.setMaximumSize(new Dimension(125, 30));
//        btnSendSerializedMid.setMinimumSize(new Dimension(125, 30));
//        btnSendSerializedMid.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 25));
//        btnSendSerializedMid.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        pnlSendMID.add(btnSendSerializedMid);
        //
        return pnlSendMID;
    }
    //
    public static JPanel dialogPanel(double pnlHRatio1, double pnlWRatio1) {
        // Dialog section
        JPanel pnlDialogContainer = new JPanel();
//        pnlDialogContainer.setMaximumSize(new Dimension(1300, 600));
//        pnlDialogContainer.setMinimumSize(new Dimension(750, 300));
//        pnlDialogContainer.setPreferredSize(pnlSubContainer4.getPreferredSize());
////        pnlDialogContainer.setMaximumSize(pnlMainContainer.getMaximumSize());
//        pnlDialogContainer.setMaximumSize(pnlSubContainer4.getMaximumSize());
//        pnlDialogContainer.setMinimumSize(pnlSubContainer4.getMaximumSize());
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
        pnldialogBox.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatio1), (int) (hostFrame.getHeight() * pnlHRatio1)));
//        pnldialogBox.setMaximumSize(pnldialogBox.getMaximumSize());
//        pnldialogBox.setMinimumSize(pnldialogBox.getMaximumSize());
        pnldialogBox.setLayout(new BoxLayout(pnldialogBox, BoxLayout.X_AXIS));
        pnldialogBox.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnldialogBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        JTextArea dialogBox = new JTextArea();
        dialogBox = new JTextArea();
//        dialogBox = new JTextArea();
        dialogBox.setLineWrap(true);
        dialogBox.setAlignmentX(Component.LEFT_ALIGNMENT);
//        dialogBox.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        dialogBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        JScrollPane scrollDialogContainer = new JScrollPane(dialogBox);
        pnldialogBox.add(scrollDialogContainer);
        pnlDialogContainer.add(pnldialogBox);
        return pnlDialogContainer;
    }
    //
//    public static void createDialog(JTextField ipString, JTextField portString, JTextField initTimeout
//            , JTextField timeoutDelay, JTextField ctrlName, JTextArea dialogBox, hostClient hClient
//            , openProtocolClientParserMIDClass oPCP, openProtocolClientSerializerMIDClass oPCS) {
    public static void createDialog() {
        // ScreenSize
        Dimension refScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int refFrameSizeW = (int) refScreenSize.getWidth();
        int refFrameSizeH = (int) refScreenSize.getHeight();
        // frame ratio
        double maxFramePercentageW = 0.80;
        double maxFramePercentageH = 0.80;
        double minFramePercentageW = 0.65;
        double minFramePercentageH = 0.65;
        int maxFrameSizeW = (int) (refFrameSizeW * maxFramePercentageW);
        int minFrameSizeW = (int) (refFrameSizeW * minFramePercentageW);
        int maxFrameSizeH = (int) (refFrameSizeH * maxFramePercentageH);
        int minFrameSizeH = (int) (refFrameSizeH * minFramePercentageH);
//        hostFrame.setPreferredSize(new Dimension(maxFrameSizeW, maxFrameSizeH));
//        hostFrame.setMaximumSize(hostFrame.getPreferredSize());
//        hostFrame.setMinimumSize(new Dimension(minFrameSizeW, minFrameSizeH));
        hostFrame.setPreferredSize(new Dimension(minFrameSizeW, minFrameSizeH));
        hostFrame.setMaximumSize(new Dimension(maxFrameSizeW, maxFrameSizeH));
//        hostFrame.setMaximumSize(hostFrame.getPreferredSize());
//        hostFrame.setMinimumSize(new Dimension(minFrameSizeW, minFrameSizeH));
        hostFrame.setMinimumSize(hostFrame.getPreferredSize());
//        hostFrame.setMinimumSize(new Dimension(minFrameSizeW, minFrameSizeH));
        hostFrame.addWindowListener(new java.awt.event.WindowAdapter() {
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
//        double pnlWRatioG = (double) 1/24;
        double pnlWRatioG = (double) 1/48;
        double pnlWRatioH = (double) 11/24;
        double pnlWRatioI = (double) 1/12;
        double pnlWRatioJ = (double) 1/4;
        // Text areas

        // main container
        JPanel pnlMainContainer = new JPanel();
        pnlMainContainer.setLayout(new BoxLayout(pnlMainContainer, BoxLayout.Y_AXIS));
//        pnlMainContainer.setBorder(BorderFactory.createEtchedBorder());
        pnlMainContainer.setPreferredSize(new Dimension(hostFrame.getWidth(), hostFrame.getHeight()));
        pnlMainContainer.setMaximumSize(hostFrame.getPreferredSize());
        pnlMainContainer.setMinimumSize(hostFrame.getPreferredSize());

        // JPanels containers
        JPanel pnlSubContainer1 = new JPanel();
        pnlSubContainer1.setLayout(new BoxLayout(pnlSubContainer1, BoxLayout.X_AXIS));
//        pnlSubContainer1.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubContainer1.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnlSubContainer1.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioA), (int) (hostFrame.getHeight() * pnlHRatioA)));
//        pnlSubContainer1.setMaximumSize(pnlSubContainer1.getPreferredSize());
//        pnlSubContainer1.setMinimumSize(pnlSubContainer1.getPreferredSize());
//        pnlSubContainer1.setBorder(BorderFactory.createEmptyBorder(0, (int) (hostFrame.getWidth() * pnlWRatioG)
//                , (int) (hostFrame.getHeight() * pnlHRatioD), (int) (hostFrame.getWidth() * pnlWRatioG)));
        pnlSubContainer1.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioA)
                , (int) (hostFrame.getHeight() * pnlHRatioA)));
//        pnlSubContainer1.setMaximumSize(pnlSubContainer1.getPreferredSize());
//        pnlSubContainer1.setMinimumSize(pnlSubContainer1.getPreferredSize());
//        pnlSubContainer1.setBorder(BorderFactory.createEmptyBorder(0, (int) (hostFrame.getWidth() * pnlWRatioG)
//                , (int) (hostFrame.getHeight() * pnlHRatioD)
//                , (int) (hostFrame.getWidth() * pnlWRatioG)));
        pnlSubContainer1.setBorder(BorderFactory.createEmptyBorder(0, (int) (hostFrame.getWidth() * pnlWRatioG)
                , 0, (int) (hostFrame.getWidth() * pnlWRatioG)));
        //
        JPanel pnlSubContainer1a = new JPanel();
//        pnlSubContainer1a.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioB), (int) (hostFrame.getHeight() * pnlHRatioA)));
//        pnlSubContainer1a.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioF), (int) (hostFrame.getHeight() * pnlHRatioA)));
//        pnlSubContainer1a.setMaximumSize(pnlSubContainer1a.getPreferredSize());
//        pnlSubContainer1a.setMinimumSize(pnlSubContainer1a.getPreferredSize());
        pnlSubContainer1a.setLayout(new BoxLayout(pnlSubContainer1a, BoxLayout.X_AXIS));
        pnlSubContainer1a.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubContainer1a.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSubContainer1a.setBorder(BorderFactory.createEmptyBorder(0, 0, 0
                ,  (int) (hostFrame.getWidth() * pnlWRatioG)));
        // Connection JPanels
//        JPanel pnlCnctMain = connectPanel(hostFrame, ipString, portString, ctrlName, pnlWRatioH);
//        JPanel pnlCnctMain = connectPanel(pnlWRatioH, pnlSubContainer1a);
//        JPanel pnlCnctMain = connectPanel(pnlWRatioH);
//        JPanel pnlCnctMain = connectPanel(pnlWRatioB);
        JPanel pnlCnctMain = connectPanel(pnlWRatioF);
        // ip/port JPanels
        pnlSubContainer1a.add(pnlCnctMain);
        pnlSubContainer1.add(pnlSubContainer1a);
        //
        JPanel pnlSubContainer1b = new JPanel();
//        pnlSubContainer1b.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioC), (int) (hostFrame.getHeight() * pnlHRatioA)));
//        pnlSubContainer1b.setMaximumSize(pnlSubContainer1b.getPreferredSize());
//        pnlSubContainer1b.setMinimumSize(pnlSubContainer1b.getPreferredSize());
        pnlSubContainer1b.setLayout(new BoxLayout(pnlSubContainer1b, BoxLayout.X_AXIS));
        pnlSubContainer1b.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubContainer1b.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnlSubContainer1b.setAlignmentX(Component.RIGHT_ALIGNMENT);
//        pnlSubContainer1b.setAlignmentX(Component.RIGHT_ALIGNMENT);
//        pnlSubContainer1b.setBorder(BorderFactory.createEmptyBorder(0, 0, 0
//                ,  (int) (hostFrame.getWidth() * pnlWRatioG)));
        pnlSubContainer1b.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        // Timing JPanels
        JPanel pnlTmMain = timingPanel();
//        pnlTmMain.setVisible(true);
        pnlSubContainer1b.add(pnlTmMain);
//        pnlSubContainer1.add(pnlSubContainer1a);
        pnlSubContainer1.add(pnlSubContainer1b);
//        pnlMainContainer.add(pnlSubContainer1a);
        pnlMainContainer.add(pnlSubContainer1);
        //
        // connection initiator
        JPanel pnlSubContainer2 = new JPanel();
        pnlSubContainer2.setLayout(new BoxLayout(pnlSubContainer2, BoxLayout.X_AXIS));
        pnlSubContainer2.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioA)
                , (int) (hostFrame.getHeight() * pnlHRatioB)));
        pnlSubContainer2.setMaximumSize(pnlSubContainer2.getPreferredSize());
        pnlSubContainer2.setMinimumSize(pnlSubContainer2.getPreferredSize());
//        pnlSubContainer2.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubContainer2.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnlSubContainer2.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioA)
//                , (int) (hostFrame.getHeight() * pnlHRatioB)));
//        pnlSubContainer2.setMaximumSize(pnlSubContainer2.getPreferredSize());
//        pnlSubContainer2.setMinimumSize(pnlSubContainer2.getPreferredSize());
        pnlSubContainer2.setBorder(BorderFactory.createEmptyBorder(0, (int) (hostFrame.getWidth() * pnlWRatioG)
//                , (int) (hostFrame.getHeight() * pnlHRatioD)
                , 0
                , (int) (hostFrame.getWidth() * pnlWRatioG)));
//                , hostFrame.getHeight() * 5
//        JPanel pnlbtnConnect = new JPanel();
//        pnlbtnConnect.setLayout(new BoxLayout(pnlbtnConnect, BoxLayout.X_AXIS));
//        pnlbtnConnect.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioD)
//                , (int) (hostFrame.getHeight() * pnlHRatioE)));
////                , (int) (hostFrame.getHeight() * pnlHRatioB)));
//        pnlbtnConnect.setMaximumSize(pnlbtnConnect.getPreferredSize());
//        pnlbtnConnect.setMinimumSize(pnlbtnConnect.getPreferredSize());
        // button
        btnConnect = new JButton("start connection");
        btnConnect.setAlignmentX(Component.LEFT_ALIGNMENT);
//        btnConnect.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioD), 35));
        btnConnect.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioD), 30));
        btnConnect.setMaximumSize(btnConnect.getPreferredSize());
        btnConnect.setMinimumSize(btnConnect.getPreferredSize());
//        pnlSubContainer2.add(btnConnect);
//        pnlbtnConnect.add(btnConnect);
//        pnlSubContainer2.add(pnlbtnConnect);
        pnlSubContainer2.add(btnConnect);
        //
//        JPanel pnlbtnConnectRem = new JPanel();
//        pnlbtnConnectRem.setLayout(new BoxLayout(pnlbtnConnectRem, BoxLayout.X_AXIS));
////        pnlbtnConnectRem.setAlignmentX(Component.RIGHT_ALIGNMENT);
//        pnlbtnConnectRem.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioB)
//                , (int) (hostFrame.getHeight() * pnlHRatioB)));
//        pnlbtnConnectRem.setMaximumSize(pnlbtnConnectRem.getPreferredSize());
//        pnlbtnConnectRem.setMinimumSize(pnlbtnConnectRem.getPreferredSize());
//        pnlSubContainer2.add(pnlbtnConnectRem);
//
        pnlMainContainer.add(pnlSubContainer2);
        //
        //
        JPanel pnlSubContainer3 = new JPanel();
        pnlSubContainer3.setLayout(new BoxLayout(pnlSubContainer3, BoxLayout.X_AXIS));
//        pnlSubContainer3.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubContainer3.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSubContainer3.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioA)
                , (int) (hostFrame.getHeight() * pnlHRatioA)));
//        pnlSubContainer3.setMaximumSize(pnlSubContainer3.getPreferredSize());
//        pnlSubContainer3.setMinimumSize(pnlSubContainer3.getPreferredSize());
        pnlSubContainer3.setBorder(BorderFactory.createEmptyBorder(0, (int) (hostFrame.getWidth() * pnlWRatioG)
                , 0, (int) (hostFrame.getWidth() * pnlWRatioG)));
//                , (int) (hostFrame.getHeight() * pnlHRatioD)
//                , (int) (hostFrame.getWidth() * pnlWRatioG)));
        JPanel pnlSubContainer3a = new JPanel();
        pnlSubContainer3a.setLayout(new BoxLayout(pnlSubContainer3a, BoxLayout.X_AXIS));
        pnlSubContainer3a.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubContainer3a.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSubContainer3a.setBorder(BorderFactory.createEmptyBorder(0, 0, 0
                ,  (int) (hostFrame.getWidth() * pnlWRatioG)));
        // MID section
        String[] midCmdDd = cmdList();
        JComboBox<String> midCmdCB = new JComboBox<>(midCmdDd);
//        JPanel pnlMidContainer = midPanel(pnlHRatioA, pnlWRatioE, pnlWRatioF, pnlWRatioG, pnlWRatioH
//                , midCmdDd, midCmdCB);
//        JPanel pnlMidContainer = midPanel(pnlHRatioA, pnlWRatioA, pnlWRatioB, pnlWRatioG
//                , midCmdDd, midCmdCB);
        JPanel pnlMidContainer = midPanel(pnlWRatioF, midCmdDd, midCmdCB);
        pnlSubContainer3a.add(pnlMidContainer);
        pnlSubContainer3.add(pnlSubContainer3a);
        //
        JPanel pnlSubContainer3b = new JPanel();
        pnlSubContainer3b.setLayout(new BoxLayout(pnlSubContainer3b, BoxLayout.X_AXIS));
        pnlSubContainer3b.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubContainer3b.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnlSubContainer3b.setAlignmentX(Component.RIGHT_ALIGNMENT);
        pnlSubContainer3b.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        // Timing JPanels
        JPanel pnlSend = sendPanel();
        pnlSubContainer3b.add(pnlSend);
        pnlSubContainer3.add(pnlSubContainer3b);
        pnlMainContainer.add(pnlSubContainer3);
        //
        //dialog panel
        JPanel pnlSubContainer4 = new JPanel();
        pnlSubContainer4.setLayout(new BoxLayout(pnlSubContainer4, BoxLayout.X_AXIS));
        pnlSubContainer4.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubContainer4.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSubContainer4.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioA), (int) (hostFrame.getHeight() * pnlHRatioC)));
//        pnlSubContainer4.setMaximumSize(pnlSubContainer4.getPreferredSize());
//        pnlSubContainer4.setMinimumSize(pnlSubContainer4.getPreferredSize());
        pnlSubContainer4.setBorder(BorderFactory.createEmptyBorder(0, (int) (hostFrame.getWidth() * pnlWRatioG)
                , (int) (hostFrame.getHeight() * pnlHRatioD)
                , (int) (hostFrame.getWidth() * pnlWRatioG)));
        // dialog box text area
        // Dialog section
        JPanel pnlDialogContainer = dialogPanel(pnlHRatioC, pnlWRatioA);
        pnlSubContainer4.add(pnlDialogContainer);
        pnlMainContainer.add(pnlSubContainer4);
        //
        // Exit Section
        JPanel pnlSubContainer5 = new JPanel();
        pnlSubContainer5.setLayout(new BoxLayout(pnlSubContainer5, BoxLayout.Y_AXIS));
        pnlSubContainer5.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubContainer5.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSubContainer5.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioA), (int) (hostFrame.getHeight() * pnlHRatioB)));
        pnlSubContainer5.setMaximumSize(pnlSubContainer5.getPreferredSize());
        pnlSubContainer5.setMinimumSize(pnlSubContainer5.getPreferredSize());
        pnlSubContainer5.setBorder(BorderFactory.createEmptyBorder(0, (int) (hostFrame.getWidth() * pnlWRatioG)
                , 0
                , (int) (hostFrame.getWidth() * pnlWRatioG)));
        JButton btnExit = new JButton("Exit");
        btnExit.setLayout(new BoxLayout(btnExit, BoxLayout.X_AXIS));
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.setAlignmentY(Component.CENTER_ALIGNMENT);
//        btnExit.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioI), (int) (hostFrame.getHeight() * pnlHRatioB)));
//        btnExit.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioI), 30));
        btnExit.setPreferredSize(new Dimension((int) (hostFrame.getWidth() * pnlWRatioE), 30));
        btnExit.setMaximumSize(btnExit.getPreferredSize());
        btnExit.setMinimumSize(btnExit.getPreferredSize());
//        pnlMainContainer.add(btnExit);
        pnlSubContainer5.add(btnExit);
        pnlMainContainer.add(pnlSubContainer5);
        //
        // complete main container
//        hostFrame.add(pnlMainContainer);
        hostFrame.setContentPane(pnlMainContainer);
//        hostFrame.getContentPane().add(pnlMainContainer);
        hostFrame.pack();

        hostFrame.setVisible(true);

        JTextField finalIpString = ipString;
        JTextField finalPortString = portString;
        JTextField finalInitTimeout = initTimeout;
        JTextField finalTimeoutDelay = timeoutDelay;
        btnConnect.addActionListener(a -> {
            //
            try {
                String inputIdAddress = finalIpString.getText();
                int inputPortId = Integer.parseInt(finalPortString.getText());
                int initDelay = (int) Float.parseFloat(finalInitTimeout.getText());
                int checkPeriod = (int) Float.parseFloat(finalTimeoutDelay.getText());
                //
                if ("start connection".equals(btnConnect.getText())) {

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

                    //update button press
                    btnConnect.setText("close connection");

                    String serverResponse = hClient.sendMessage(integratorMsg);
                    appendDialog(dialogBox, "controller message serialized: \n" + serverResponse);
                    hostLogger.hostLog("host2Controller", "controller message serialized: " + serverResponse, "info");

                    Object serverResponseParsed = oPCP.parseMessage(serverResponse);
                    appendDialog(dialogBox, "controller message parsed: \n" + serverResponseParsed);
                    hostLogger.hostLog("host2Controller", "controller message parsed: " + serverResponseParsed, "info");
                } else {
                    //if ("start connection".equals(btnConnect.getText())) {
                    //append & log the connection clsoing
                    appendDialog(dialogBox, "Closed connection to:\n" + inputIdAddress + ": " + inputPortId);
                    hostLogger.hostLog("host2Controller", "host closed connected to " + inputIdAddress + ": " + inputPortId, "info");
//                    System.out.println("checking errror");
//                    System.out.println("appended dialog & hostlogger run");
                    hClient.stopConnection();
//                    System.out.println("ran the stopConnection");

                    //update button press
                    btnConnect.setText("start connection");
                }

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


                // check last two characters
                int msgLength = serializedMidCommand.length();
                String lastTwoChars = serializedMidCommand.substring(Math.max(msgLength - 2, 0));
                System.out.println("last two chars were? " + lastTwoChars);
                if ("\0".equals(lastTwoChars)) {
                    String serverResponse = hClient.sendMessage(serializedMidCommand);
                    appendDialog(dialogBox, "controller message serialized: \n" + serverResponse);
                    hostLogger.hostLog("host2Controller", "controller message serialized: " + serverResponse, "info");

                    Object serverResponseParsed = oPCP.parseMessage(serverResponse);
                    appendDialog(dialogBox, "controller message parsed: \n" + serverResponseParsed);
                    hostLogger.hostLog("host2Controller", "controller message parsed: " + serverResponseParsed, "info");
                } else {
                    String serverResponse = hClient.sendMessage(serializedMidCommand + "\0");
                    appendDialog(dialogBox, "controller message serialized: \n" + serverResponse);
                    hostLogger.hostLog("host2Controller", "controller message serialized: " + serverResponse, "info");

                    Object serverResponseParsed = oPCP.parseMessage(serverResponse);
                    appendDialog(dialogBox, "controller message parsed: \n" + serverResponseParsed);
                    hostLogger.hostLog("host2Controller", "controller message parsed: " + serverResponseParsed, "info");
                }
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
//        createDialog(ipString, portString, initTimeout, timeoutDelay, ctrlName, dialogBox, hClient, oPCP, oPCS);
        createDialog();
    }
}
