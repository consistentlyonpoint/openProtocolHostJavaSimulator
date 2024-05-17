import javax.swing.*;
import java.awt.*;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class hostExe {
    static JTextField ipString;
    static JTextField portString;
    static JTextField initTimeout;
    static JTextField timeoutDelay;

//    static JTextArea midString;
    static JTextField midString;

//    static JTextField serializedMidString;
    static JTextArea serializedMidString;

    static JTextField midInputString;
//    static JTextArea midInputString;
    static JTextArea dialogBox;
    //
    static JPanel connectionPanel() {

        // Connection JPanels
        JPanel pnlCnctMain = new JPanel();
        pnlCnctMain.setMaximumSize(new Dimension(920, 350));
        pnlCnctMain.setMinimumSize(new Dimension(500, 135));
        pnlCnctMain.setLayout(new BoxLayout(pnlCnctMain, BoxLayout.Y_AXIS));
        pnlCnctMain.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlCnctMain.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        // Connection Header
        JLabel lblManualConnect = new JLabel("Connection");
        lblManualConnect.setFont(new Font("Courier", Font.BOLD, 16));
        lblManualConnect.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblManualConnect.setAlignmentY(Component.TOP_ALIGNMENT);
        pnlCnctMain.add(lblManualConnect);
        // Connect Detail
        JPanel pnlCnctDtl = new JPanel();
        pnlCnctDtl.setMaximumSize(new Dimension(920, 150));
        pnlCnctDtl.setMinimumSize(new Dimension(500, 80));
        pnlCnctDtl.setLayout(new BoxLayout(pnlCnctDtl, BoxLayout.X_AXIS));
//        pnlCnctDtl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        // labels
        JPanel pnlCnctLbls = new JPanel();
        pnlCnctLbls.setMaximumSize(new Dimension(85, 150));
        pnlCnctLbls.setMinimumSize(new Dimension(55, 80));
        pnlCnctLbls.setLayout(new BoxLayout(pnlCnctLbls, BoxLayout.Y_AXIS));
        pnlCnctLbls.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlCnctipLbl = new JPanel();
        pnlCnctipLbl.setMaximumSize(new Dimension(85, 30));
        pnlCnctipLbl.setMinimumSize(new Dimension(55, 25));
        pnlCnctipLbl.setLayout(new BoxLayout(pnlCnctipLbl, BoxLayout.X_AXIS));
        JLabel ipLbl = new JLabel("Host:");
        ipLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
//        ipLbl.setAlignmentY(Component.TOP_ALIGNMENT);
//        ipLbl.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlCnctipLbl.add(ipLbl);
        pnlCnctLbls.add(pnlCnctipLbl);
        JPanel pnlCnctLblpd = new JPanel();
        pnlCnctLblpd.setMaximumSize(new Dimension(85, 5));
        pnlCnctLblpd.setMinimumSize(new Dimension(55, 5));
        pnlCnctLbls.add(pnlCnctLblpd);
        JPanel pnlCnctlblCtrl = new JPanel();
        pnlCnctlblCtrl.setMaximumSize(new Dimension(85, 30));
        pnlCnctlblCtrl.setMinimumSize(new Dimension(55, 25));
        pnlCnctlblCtrl.setLayout(new BoxLayout(pnlCnctlblCtrl, BoxLayout.X_AXIS));
        JLabel lblCtrl = new JLabel("Device:");
        lblCtrl.setAlignmentX(Component.LEFT_ALIGNMENT);
//        lblCtrl.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        lblCtrl.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlCnctlblCtrl.add(lblCtrl);
        pnlCnctLbls.add(pnlCnctlblCtrl);
        pnlCnctDtl.add(pnlCnctLbls);
        // ip, port text areas (x) + device (y)
        JPanel pnlCnctDtlFlds = new JPanel();
        pnlCnctDtlFlds.setMaximumSize(new Dimension(795, 150));
        pnlCnctDtlFlds.setMinimumSize(new Dimension(415, 80));
        pnlCnctDtlFlds.setLayout(new BoxLayout(pnlCnctDtlFlds, BoxLayout.Y_AXIS));
//        pnlCnctDtlFlds.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlCnctDtlFlds.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlCnctDtlIpPortFlds = new JPanel();
        pnlCnctDtlIpPortFlds.setMaximumSize(new Dimension(795, 30));
        pnlCnctDtlIpPortFlds.setMinimumSize(new Dimension(415, 25));
        pnlCnctDtlIpPortFlds.setLayout(new BoxLayout(pnlCnctDtlIpPortFlds, BoxLayout.X_AXIS));
        JTextField ipString = new JTextField("127.0.0.1");
        ipString.setToolTipText("Device/Controller IP Address required.");
        ipString.setAlignmentX(Component.LEFT_ALIGNMENT);
//        ipString.setAlignmentY(Component.TOP_ALIGNMENT);
        ipString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlCnctDtlIpPortFlds.add(ipString);
        JLabel portLbl = new JLabel("Port:");
        portLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
//        portLbl.setAlignmentY(Component.CENTER_ALIGNMENT);
        portLbl.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 35));
        pnlCnctDtlIpPortFlds.add(portLbl);
        JTextField portString = new JTextField("4545");
        portString.setToolTipText("Device/Controller Port Id required.");
        portString.setAlignmentX(Component.LEFT_ALIGNMENT);
//        portString.setAlignmentY(Component.TOP_ALIGNMENT);
        portString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlCnctDtlIpPortFlds.add(portString);
        pnlCnctDtlFlds.add(pnlCnctDtlIpPortFlds);
        JPanel pnlCnctDtlFldspd = new JPanel();
        pnlCnctDtlFldspd.setMaximumSize(new Dimension(795, 5));
        pnlCnctDtlFldspd.setMinimumSize(new Dimension(415, 5));
        pnlCnctDtlFlds.add(pnlCnctDtlFldspd);
        JPanel pnlCnctDtlctrlNameFlds = new JPanel();
        pnlCnctDtlctrlNameFlds.setMaximumSize(new Dimension(795, 30));
        pnlCnctDtlctrlNameFlds.setMinimumSize(new Dimension(415, 25));
        pnlCnctDtlctrlNameFlds.setLayout(new BoxLayout(pnlCnctDtlctrlNameFlds, BoxLayout.X_AXIS));
        JTextField ctrlName = new JTextField("deviceName");
        ctrlName.setToolTipText("Device/Controller Name.");
        ctrlName.setAlignmentX(Component.LEFT_ALIGNMENT);
//        ctrlName.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        ctrlName.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlCnctDtlctrlNameFlds.add(ctrlName);
        pnlCnctDtlFlds.add(pnlCnctDtlctrlNameFlds);
        pnlCnctDtl.add(pnlCnctDtlFlds);
        pnlCnctMain.add(pnlCnctDtl);

        // ip/port JPanels
//        pnlSubConatiner1.add(pnlCnctMain);

        return pnlCnctMain;
    }
    //
    static JPanel midPanel() {
        // Timing JPanels
        JPanel pnlMidContainer = new JPanel();
        pnlMidContainer.setMaximumSize(new Dimension(1100, 350));
        pnlMidContainer.setMinimumSize(new Dimension(600, 135));
        pnlMidContainer.setLayout(new BoxLayout(pnlMidContainer, BoxLayout.Y_AXIS));
        pnlMidContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMidContainer.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // MID Header
        JLabel lblMessages = new JLabel("MID Messages");
        lblMessages.setFont(new Font("Courier", Font.BOLD, 14));
//        lblTime.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblMessages.setAlignmentY(Component.TOP_ALIGNMENT);
        pnlMidContainer.add(lblMessages);

        // mid command container
        JPanel pnlMidCommand = new JPanel();
        pnlMidCommand.setLayout(new BoxLayout(pnlMidCommand, BoxLayout.X_AXIS));
        pnlMidCommand.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel lblMID = new JLabel("MID Command:       ");
//        lblMID.setMaximumSize(new Dimension(75, 30));
//        lblMID.setMinimumSize(new Dimension(50, 30));
        lblMID.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMidCommand.add(lblMID);
        // MID Command and input vals section
//        JTextField midString = new JTextField();
        midString = new JTextField();
//        midString.setMaximumSize(new Dimension(250, 30));
//        midString.setMinimumSize(new Dimension(100, 30));
        midString.setToolTipText("'MID' Command");
        midString.setAlignmentX(Component.LEFT_ALIGNMENT);
        midString.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        pnlMidCommand.add(midString);

        JLabel lblVals = new JLabel("Input Values:    ");
//        lblVals.setMaximumSize(new Dimension(75, 30));
//        lblVals.setMinimumSize(new Dimension(50, 30));
        lblVals.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblVals.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        pnlMidCommand.add(lblVals);
//        JTextField timeoutDelay = new JTextField("65");
//        JTextField midInputString = new JTextField();
        midInputString = new JTextField();
//        midInputString.setMaximumSize(new Dimension(250, 30));
//        midInputString.setMinimumSize(new Dimension(100, 30));
        midInputString.setToolTipText("include MID command values if applicable.");
        midInputString.setAlignmentX(Component.LEFT_ALIGNMENT);
        midInputString.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        pnlMidCommand.add(midInputString);

        pnlMidContainer.add(pnlMidCommand);

        // mid command container
        JPanel pnlSerializedMidCommand = new JPanel();
        pnlSerializedMidCommand.setLayout(new BoxLayout(pnlSerializedMidCommand, BoxLayout.X_AXIS));
        pnlSerializedMidCommand.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel lblSerialized = new JLabel("Serialized MID:    ");
//        lblSerialized.setMaximumSize(new Dimension(115, 45));
//        lblSerialized.setMinimumSize(new Dimension(75, 45));
        lblSerialized.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSerializedMidCommand.add(lblSerialized);
//        JTextField serializedMidString = new JTextField();
        serializedMidString = new JTextArea();
//        serializedMidString.setMaximumSize(new Dimension(575, 30));
//        serializedMidString.setMinimumSize(new Dimension(250, 30));
        serializedMidString.setToolTipText("include serialized MID message.");
        serializedMidString.setAlignmentX(Component.LEFT_ALIGNMENT);
        serializedMidString.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        pnlSerializedMidCommand.add(serializedMidString);

        pnlMidContainer.add(pnlSerializedMidCommand);

        return pnlMidContainer;
    }
    //
    static JPanel dialogPanel() {
        // Dialog section
        JPanel pnlDialogContainer = new JPanel();
        pnlDialogContainer.setMaximumSize(new Dimension(1300, 600));
        pnlDialogContainer.setMinimumSize(new Dimension(750, 300));
        pnlDialogContainer.setLayout(new BoxLayout(pnlDialogContainer, BoxLayout.Y_AXIS));
//        pnlDialogContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
//        pnlDialogContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlDialogContainer.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JPanel pnlLblDialog = new JPanel();
        pnlLblDialog.setLayout(new BoxLayout(pnlLblDialog, BoxLayout.X_AXIS));
//        pnlLblDialog.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlLblDialog.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        // Dialog Header
        JLabel lblDialog = new JLabel("Communication Log                ");
        lblDialog.setFont(new Font("Courier", Font.BOLD, 14));
        lblDialog.setAlignmentX(Component.RIGHT_ALIGNMENT);
        pnlLblDialog.add(lblDialog);

        pnlDialogContainer.add(pnlLblDialog);

        // mid command container
        JPanel pnldialogBox = new JPanel();
        pnldialogBox.setLayout(new BoxLayout(pnldialogBox, BoxLayout.X_AXIS));
        pnldialogBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

//        JTextArea dialogBox = new JTextArea();
        dialogBox = new JTextArea();
        dialogBox.setLineWrap(true);
        dialogBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        dialogBox.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        dialogBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
//        pnldialogBox.add(dialogBox);

        JScrollPane scrollDialogContainer = new JScrollPane(dialogBox);
//        JScrollPane scrollDialogContainer = new JScrollPane(pnldialogBox);
//        pnlDialogContainer.add(scrollDialogContainer);
        pnldialogBox.add(scrollDialogContainer);

//        pnlDialogContainer.add(dialogBox);

        pnlDialogContainer.add(pnldialogBox);

        //pnlDialogContainer.add(dialogBox);

        return pnlDialogContainer;
    }
    //
    public static void createDialog() {
        hostClient hClient = new hostClient();
        openProtocolClientParserMIDClass oPCP = new openProtocolClientParserMIDClass();
        openProtocolClientSerializerMIDClass oPCS = new openProtocolClientSerializerMIDClass();
        // Host Frame
        JFrame frame = new JFrame("Host");
////        frame.setMaximumSize(new Dimension(1600, 1100));
//        frame.setMinimumSize(new Dimension(900, 600));
////        frame.setSize(new Dimension(1200, 800));
//        frame.setSize(new Dimension(1600, 1100));

//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);

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
        // Text areas

        // main container
        JPanel pnlMainContainer = new JPanel();
        pnlMainContainer.setLayout(new BoxLayout(pnlMainContainer, BoxLayout.Y_AXIS));
        pnlMainContainer.setBorder(BorderFactory.createEtchedBorder());
//        pnlMainContainer.setMaximumSize(new Dimension(1600, 1100));
//        pnlMainContainer.setMinimumSize(new Dimension(900, 600));
//        pnlMainContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        // JPanels containers
//        JPanel pnlSubConatiner1 = new JPanel(new BorderLayout());
//        JPanel pnlSubConatiner1 = new JPanel(new GridBagLayout());
        JPanel pnlSubConatiner1 = new JPanel();
        pnlSubConatiner1.setMaximumSize(new Dimension(1400, 350));
        pnlSubConatiner1.setMinimumSize(new Dimension(750, 135));
        pnlSubConatiner1.setAlignmentY(Component.TOP_ALIGNMENT);
//        pnlSubConatiner1.setAlignmentY(14.0F);
        pnlSubConatiner1.setLayout(new BoxLayout(pnlSubConatiner1, BoxLayout.X_AXIS));
        pnlSubConatiner1.setBorder(BorderFactory.createEmptyBorder(5, 1, 10, 1));
////        pnlSubConatiner1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
//        pnlSubConatiner1.setMaximumSize(new Dimension(1400, 250));
//        pnlSubConatiner1.setMinimumSize(new Dimension(750, 135));

        // Connection JPanels
        JPanel pnlCnctMain = new JPanel();
        pnlCnctMain.setMaximumSize(new Dimension(920, 350));
        pnlCnctMain.setMinimumSize(new Dimension(500, 135));
        pnlCnctMain.setLayout(new BoxLayout(pnlCnctMain, BoxLayout.Y_AXIS));
        pnlCnctMain.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlCnctMain.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        // Connection Header
        JLabel lblManualConnect = new JLabel("Connection");
        lblManualConnect.setFont(new Font("Courier", Font.BOLD, 16));
        lblManualConnect.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblManualConnect.setAlignmentY(Component.TOP_ALIGNMENT);
        pnlCnctMain.add(lblManualConnect);
        // Connect Detail
        JPanel pnlCnctDtl = new JPanel();
        pnlCnctDtl.setMaximumSize(new Dimension(920, 150));
        pnlCnctDtl.setMinimumSize(new Dimension(500, 80));
        pnlCnctDtl.setLayout(new BoxLayout(pnlCnctDtl, BoxLayout.X_AXIS));
//        pnlCnctDtl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        // labels
        JPanel pnlCnctLbls = new JPanel();
        pnlCnctLbls.setMaximumSize(new Dimension(85, 150));
        pnlCnctLbls.setMinimumSize(new Dimension(55, 80));
        pnlCnctLbls.setLayout(new BoxLayout(pnlCnctLbls, BoxLayout.Y_AXIS));
        pnlCnctLbls.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlCnctipLbl = new JPanel();
        pnlCnctipLbl.setMaximumSize(new Dimension(85, 30));
        pnlCnctipLbl.setMinimumSize(new Dimension(55, 25));
        pnlCnctipLbl.setLayout(new BoxLayout(pnlCnctipLbl, BoxLayout.X_AXIS));
        JLabel ipLbl = new JLabel("Host:");
        ipLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
//        ipLbl.setAlignmentY(Component.TOP_ALIGNMENT);
//        ipLbl.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlCnctipLbl.add(ipLbl);
        pnlCnctLbls.add(pnlCnctipLbl);
        JPanel pnlCnctLblpd = new JPanel();
        pnlCnctLblpd.setMaximumSize(new Dimension(85, 5));
        pnlCnctLblpd.setMinimumSize(new Dimension(55, 5));
        pnlCnctLbls.add(pnlCnctLblpd);
        JPanel pnlCnctlblCtrl = new JPanel();
        pnlCnctlblCtrl.setMaximumSize(new Dimension(85, 30));
        pnlCnctlblCtrl.setMinimumSize(new Dimension(55, 25));
        pnlCnctlblCtrl.setLayout(new BoxLayout(pnlCnctlblCtrl, BoxLayout.X_AXIS));
        JLabel lblCtrl = new JLabel("Device:");
        lblCtrl.setAlignmentX(Component.LEFT_ALIGNMENT);
//        lblCtrl.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        lblCtrl.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlCnctlblCtrl.add(lblCtrl);
        pnlCnctLbls.add(pnlCnctlblCtrl);
        pnlCnctDtl.add(pnlCnctLbls);
        // ip, port text areas (x) + device (y)
        JPanel pnlCnctDtlFlds = new JPanel();
        pnlCnctDtlFlds.setMaximumSize(new Dimension(795, 150));
        pnlCnctDtlFlds.setMinimumSize(new Dimension(415, 80));
        pnlCnctDtlFlds.setLayout(new BoxLayout(pnlCnctDtlFlds, BoxLayout.Y_AXIS));
//        pnlCnctDtlFlds.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlCnctDtlFlds.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlCnctDtlIpPortFlds = new JPanel();
        pnlCnctDtlIpPortFlds.setMaximumSize(new Dimension(795, 30));
        pnlCnctDtlIpPortFlds.setMinimumSize(new Dimension(415, 25));
        pnlCnctDtlIpPortFlds.setLayout(new BoxLayout(pnlCnctDtlIpPortFlds, BoxLayout.X_AXIS));
        JTextField ipString = new JTextField("127.0.0.1");
        ipString.setToolTipText("Device/Controller IP Address required.");
        ipString.setAlignmentX(Component.LEFT_ALIGNMENT);
//        ipString.setAlignmentY(Component.TOP_ALIGNMENT);
        ipString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlCnctDtlIpPortFlds.add(ipString);
        JLabel portLbl = new JLabel("Port:");
        portLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
//        portLbl.setAlignmentY(Component.CENTER_ALIGNMENT);
        portLbl.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 35));
        pnlCnctDtlIpPortFlds.add(portLbl);
        JTextField portString = new JTextField("4545");
        portString.setToolTipText("Device/Controller Port Id required.");
        portString.setAlignmentX(Component.LEFT_ALIGNMENT);
//        portString.setAlignmentY(Component.TOP_ALIGNMENT);
        portString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlCnctDtlIpPortFlds.add(portString);
        pnlCnctDtlFlds.add(pnlCnctDtlIpPortFlds);
        JPanel pnlCnctDtlFldspd = new JPanel();
        pnlCnctDtlFldspd.setMaximumSize(new Dimension(795, 5));
        pnlCnctDtlFldspd.setMinimumSize(new Dimension(415, 5));
        pnlCnctDtlFlds.add(pnlCnctDtlFldspd);
        JPanel pnlCnctDtlctrlNameFlds = new JPanel();
        pnlCnctDtlctrlNameFlds.setMaximumSize(new Dimension(795, 30));
        pnlCnctDtlctrlNameFlds.setMinimumSize(new Dimension(415, 25));
        pnlCnctDtlctrlNameFlds.setLayout(new BoxLayout(pnlCnctDtlctrlNameFlds, BoxLayout.X_AXIS));
        JTextField ctrlName = new JTextField("deviceName");
        ctrlName.setToolTipText("Device/Controller Name.");
        ctrlName.setAlignmentX(Component.LEFT_ALIGNMENT);
//        ctrlName.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        ctrlName.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlCnctDtlctrlNameFlds.add(ctrlName);
        pnlCnctDtlFlds.add(pnlCnctDtlctrlNameFlds);
        pnlCnctDtl.add(pnlCnctDtlFlds);
        pnlCnctMain.add(pnlCnctDtl);

        // ip/port JPanels
        pnlSubConatiner1.add(pnlCnctMain);

        //
        // Timing JPanels
        JPanel pnlTmMain = new JPanel();
        pnlTmMain.setMaximumSize(new Dimension(250, 350));
        pnlTmMain.setMinimumSize(new Dimension(185, 135));
        pnlTmMain.setLayout(new BoxLayout(pnlTmMain, BoxLayout.Y_AXIS));
        pnlTmMain.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlTmMain.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        // Connection Header
        JLabel lblTime = new JLabel("Keep Alive");
        lblTime.setFont(new Font("Courier", Font.BOLD, 16));
        lblTime.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTime.setAlignmentY(Component.TOP_ALIGNMENT);
        pnlTmMain.add(lblTime);
        // Timing Detail
        JPanel pnlTmDtl = new JPanel();
        pnlTmDtl.setMaximumSize(new Dimension(200, 150));
        pnlTmDtl.setMinimumSize(new Dimension(125, 80));
        pnlTmDtl.setLayout(new BoxLayout(pnlTmDtl, BoxLayout.X_AXIS));
        // labels
        JPanel pnlTmLbls = new JPanel();
        pnlTmLbls.setMaximumSize(new Dimension(85, 150));
        pnlTmLbls.setMinimumSize(new Dimension(55, 80));
        pnlTmLbls.setLayout(new BoxLayout(pnlTmLbls, BoxLayout.Y_AXIS));
        pnlTmLbls.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlTmDelay = new JPanel();
        pnlTmDelay.setMaximumSize(new Dimension(85, 30));
        pnlTmDelay.setMinimumSize(new Dimension(55, 25));
        pnlTmDelay.setLayout(new BoxLayout(pnlTmDelay, BoxLayout.X_AXIS));
        JLabel lblInitDelay = new JLabel("Delay:");
        lblInitDelay.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlTmDelay.add(lblInitDelay);
        pnlTmLbls.add(pnlTmDelay);
        JPanel pnlTmLblpd = new JPanel();
        pnlTmLblpd.setMaximumSize(new Dimension(85, 5));
        pnlTmLblpd.setMinimumSize(new Dimension(55, 5));
        pnlTmLbls.add(pnlTmLblpd);
        JPanel pnlTmPrd = new JPanel();
        pnlTmPrd.setMaximumSize(new Dimension(85, 30));
        pnlTmPrd.setMinimumSize(new Dimension(55, 25));
        pnlTmPrd.setLayout(new BoxLayout(pnlTmPrd, BoxLayout.X_AXIS));
        JLabel lblTimeoutPrd = new JLabel("Timeout:");
        lblTimeoutPrd.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlTmPrd.add(lblTimeoutPrd);
        pnlTmLbls.add(pnlTmPrd);
        pnlTmDtl.add(pnlTmLbls);
        // delay and timeout text areas
        JPanel pnlTmDtlFlds = new JPanel();
        pnlTmDtlFlds.setMaximumSize(new Dimension(85, 150));
        pnlTmDtlFlds.setMinimumSize(new Dimension(65, 80));
        pnlTmDtlFlds.setLayout(new BoxLayout(pnlTmDtlFlds, BoxLayout.Y_AXIS));
        pnlTmDtlFlds.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlTmDtlInitTmFlds = new JPanel();
        pnlTmDtlInitTmFlds.setMaximumSize(new Dimension(85, 30));
        pnlTmDtlInitTmFlds.setMinimumSize(new Dimension(65, 25));
        pnlTmDtlInitTmFlds.setLayout(new BoxLayout(pnlTmDtlInitTmFlds, BoxLayout.X_AXIS));
        JTextField initTimeout = new JTextField("75.0");
        initTimeout.setMaximumSize(new Dimension(30, 30));
        initTimeout.setMinimumSize(new Dimension(30, 25));
        initTimeout.setLayout(new BoxLayout(initTimeout, BoxLayout.X_AXIS));
        initTimeout.setToolTipText("Initial delay period before sending keep alive message.");
        initTimeout.setAlignmentX(Component.LEFT_ALIGNMENT);
        initTimeout.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 0));
        pnlTmDtlInitTmFlds.add(initTimeout);
        JTextField InitTmUnit = new JTextField("sec.");
        InitTmUnit.setMaximumSize(new Dimension(50, 30));
        InitTmUnit.setMinimumSize(new Dimension(30, 25));
        InitTmUnit.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        InitTmUnit.setBackground(Color.white);
        InitTmUnit.setLayout(new BoxLayout(InitTmUnit, BoxLayout.X_AXIS));
        InitTmUnit.setAlignmentX(Component.CENTER_ALIGNMENT);
        InitTmUnit.setEditable(false);
        pnlTmDtlInitTmFlds.add(InitTmUnit);
        pnlTmDtlFlds.add(pnlTmDtlInitTmFlds);
        JPanel pnlTmDtlFldsPd = new JPanel();
        pnlTmDtlFldsPd.setMaximumSize(new Dimension(85, 5));
        pnlTmDtlFldsPd.setMinimumSize(new Dimension(65, 5));
        pnlTmDtlFlds.add(pnlTmDtlFldsPd);
        JPanel pnlTmDtlTmDlyFlds = new JPanel();
        pnlTmDtlTmDlyFlds.setMaximumSize(new Dimension(85, 30));
        pnlTmDtlTmDlyFlds.setMinimumSize(new Dimension(65, 25));
        pnlTmDtlTmDlyFlds.setLayout(new BoxLayout(pnlTmDtlTmDlyFlds, BoxLayout.X_AXIS));
        JTextField timeoutDelay = new JTextField("65.0");
        timeoutDelay.setMaximumSize(new Dimension(30, 30));
        timeoutDelay.setMinimumSize(new Dimension(30, 25));
        timeoutDelay.setLayout(new BoxLayout(timeoutDelay, BoxLayout.X_AXIS));
        timeoutDelay.setToolTipText("Period between sending keep alive message.");
        timeoutDelay.setAlignmentX(Component.LEFT_ALIGNMENT);
        timeoutDelay.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 1));
        pnlTmDtlTmDlyFlds.add(timeoutDelay);
        JTextField TmDlyUnit = new JTextField("sec.");
        TmDlyUnit.setMaximumSize(new Dimension(50, 30));
        TmDlyUnit.setMinimumSize(new Dimension(30, 25));
        TmDlyUnit.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        TmDlyUnit.setBackground(Color.white);
        TmDlyUnit.setLayout(new BoxLayout(TmDlyUnit, BoxLayout.X_AXIS));
        TmDlyUnit.setAlignmentX(Component.CENTER_ALIGNMENT);
        TmDlyUnit.setEditable(false);
        pnlTmDtlTmDlyFlds.add(TmDlyUnit);
        pnlTmDtlFlds.add(pnlTmDtlTmDlyFlds);
        pnlTmDtl.add(pnlTmDtlFlds);

        pnlTmMain.add(pnlTmDtl);

//        pnlSubConatiner1.add(timePanel());
        pnlSubConatiner1.add(pnlTmMain);
        // button
        JPanel pnlbtnConnect = new JPanel();
        pnlbtnConnect.setMaximumSize(new Dimension(200, 350));
        pnlbtnConnect.setMinimumSize(new Dimension(200, 135));
//        pnlbtnConnect.setLayout(new BoxLayout(pnlbtnConnect, BoxLayout.X_AXIS));
        pnlbtnConnect.setLayout(new BoxLayout(pnlbtnConnect, BoxLayout.Y_AXIS));
        pnlbtnConnect.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnlbtnConnect.setAlignmentY(Component.CENTER_ALIGNMENT);
        JButton btnConnect = new JButton("start connection");
        btnConnect.setLayout(new BoxLayout(btnConnect, BoxLayout.Y_AXIS));
//        btnConnect.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnConnect.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlbtnConnect.add(btnConnect);
        pnlSubConatiner1.add(pnlbtnConnect);
//        pnlSubConatiner1.add(btnConnect);

        pnlMainContainer.add(pnlSubConatiner1);
//        pnlMainContainer.add(btnConnect);

        //
        JPanel pnlSubConatiner2 = new JPanel();
        pnlSubConatiner2.setMaximumSize(new Dimension(1400, 350));
        pnlSubConatiner2.setMinimumSize(new Dimension(850, 135));
        pnlSubConatiner2.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubConatiner2.setLayout(new BoxLayout(pnlSubConatiner2, BoxLayout.X_AXIS));
        pnlSubConatiner2.setBorder(BorderFactory.createEmptyBorder(5, 1, 10, 1));

        //
        // MID section
        JPanel pnlMidContainer = new JPanel();
        pnlMidContainer.setMaximumSize(new Dimension(1200, 350));
        pnlMidContainer.setMinimumSize(new Dimension(700, 135));
        pnlMidContainer.setLayout(new BoxLayout(pnlMidContainer, BoxLayout.Y_AXIS));
        pnlMidContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMidContainer.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        // MID Header
        JPanel pnllblMessages = new JPanel();
        pnllblMessages.setLayout(new BoxLayout(pnllblMessages, BoxLayout.X_AXIS));
        pnllblMessages.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel lblMessages = new JLabel("MID Messages");
        lblMessages.setFont(new Font("Courier", Font.BOLD, 14));
        lblMessages.setLayout(new BoxLayout(lblMessages, BoxLayout.X_AXIS));
//        lblMessages.setAlignmentY(Component.CENTER_ALIGNMENT);
        lblMessages.setAlignmentX(Component.LEFT_ALIGNMENT);
//        lblMessages.setAlignmentY(Component.TOP_ALIGNMENT);
        pnllblMessages.add(lblMessages);
        pnlMidContainer.add(pnllblMessages);
        // mid command container
        JPanel pnlMidCommand = new JPanel();
        pnlMidCommand.setMaximumSize(new Dimension(1200, 150));
        pnlMidCommand.setMinimumSize(new Dimension(700, 80));
        pnlMidCommand.setLayout(new BoxLayout(pnlMidCommand, BoxLayout.X_AXIS));
        // labels
        JPanel pnlAllMIDLbls = new JPanel();
        pnlAllMIDLbls.setMaximumSize(new Dimension(85, 150));
        pnlAllMIDLbls.setMinimumSize(new Dimension(55, 80));
        pnlAllMIDLbls.setLayout(new BoxLayout(pnlAllMIDLbls, BoxLayout.Y_AXIS));
        pnlAllMIDLbls.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlMIDLbl = new JPanel();
        pnlMIDLbl.setMaximumSize(new Dimension(85, 30));
        pnlMIDLbl.setMinimumSize(new Dimension(55, 25));
        pnlMIDLbl.setLayout(new BoxLayout(pnlMIDLbl, BoxLayout.X_AXIS));
        JLabel lblMID = new JLabel("MID Command:");
        lblMID.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMIDLbl.add(lblMID);
        pnlAllMIDLbls.add(pnlMIDLbl);
        JPanel pnlSerializedMIDLbl = new JPanel();
        pnlSerializedMIDLbl.setMaximumSize(new Dimension(85, 30));
        pnlSerializedMIDLbl.setMinimumSize(new Dimension(55, 25));
        pnlSerializedMIDLbl.setLayout(new BoxLayout(pnlSerializedMIDLbl, BoxLayout.X_AXIS));
        JLabel lblSerialized = new JLabel("Serialized MID:");
        lblSerialized.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSerializedMIDLbl.add(lblSerialized);
        pnlAllMIDLbls.add(pnlSerializedMIDLbl);
        pnlMidCommand.add(pnlAllMIDLbls);
        // MID Command and input vals section
        JPanel pnlMIDDtlFlds = new JPanel();
        pnlMIDDtlFlds.setMaximumSize(new Dimension(1000, 150));
        pnlMIDDtlFlds.setMinimumSize(new Dimension(600, 80));
        pnlMIDDtlFlds.setLayout(new BoxLayout(pnlMIDDtlFlds, BoxLayout.Y_AXIS));
        pnlMIDDtlFlds.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlMIDDtlCmdInVFlds = new JPanel();
        pnlMIDDtlCmdInVFlds.setMaximumSize(new Dimension(1000, 30));
        pnlMIDDtlCmdInVFlds.setMinimumSize(new Dimension(600, 25));
        pnlMIDDtlCmdInVFlds.setLayout(new BoxLayout(pnlMIDDtlCmdInVFlds, BoxLayout.X_AXIS));
        JTextField midString = new JTextField();
        midString.setToolTipText("'MID' Command");
        midString.setAlignmentX(Component.LEFT_ALIGNMENT);
        midString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlMIDDtlCmdInVFlds.add(midString);
        JLabel lblVals = new JLabel("Input Values:");
        lblVals.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblVals.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 35));
        pnlMIDDtlCmdInVFlds.add(lblVals);
        JTextField midInputString = new JTextField();
        midInputString.setToolTipText("include MID command values if applicable.");
        midInputString.setAlignmentX(Component.LEFT_ALIGNMENT);
        midInputString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlMIDDtlCmdInVFlds.add(midInputString);
        pnlMIDDtlFlds.add(pnlMIDDtlCmdInVFlds);
        JPanel pnlMIDDtlFldsPd = new JPanel();
        pnlMIDDtlFldsPd.setMaximumSize(new Dimension(1000, 5));
        pnlMIDDtlFldsPd.setMinimumSize(new Dimension(600, 5));
        pnlMIDDtlFlds.add(pnlMIDDtlFldsPd);
        JPanel pnlMIDDtlSrlzdFlds = new JPanel();
        pnlMIDDtlSrlzdFlds.setMaximumSize(new Dimension(1000, 30));
        pnlMIDDtlSrlzdFlds.setMinimumSize(new Dimension(600, 25));
        pnlMIDDtlSrlzdFlds.setLayout(new BoxLayout(pnlMIDDtlSrlzdFlds, BoxLayout.X_AXIS));
        JTextField serializedMidString = new JTextField();
        serializedMidString.setToolTipText("include serialized MID message.");
        serializedMidString.setAlignmentX(Component.LEFT_ALIGNMENT);
        serializedMidString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlMIDDtlSrlzdFlds.add(serializedMidString);
        pnlMIDDtlFlds.add(pnlMIDDtlSrlzdFlds);
        pnlMidCommand.add(pnlMIDDtlFlds);
        pnlMidContainer.add(pnlMidCommand);

//        pnlSubConatiner2.add(midPanel());
        pnlSubConatiner2.add(pnlMidContainer);


        // main mid container
        JButton btnSendMid = new JButton("Send");
//        btnSendMid.setMaximumSize(new Dimension(50, 35));
//        btnSendMid.setMinimumSize(new Dimension(25, 35));
        btnSendMid.setAlignmentY(Component.TOP_ALIGNMENT);
        btnSendMid.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSubConatiner2.add(btnSendMid);

        JButton btnSendSerializedMid = new JButton("Send");
//        btnSendSerializedMid.setMaximumSize(new Dimension(50, 35));
//        btnSendSerializedMid.setMinimumSize(new Dimension(25, 35));
        btnSendSerializedMid.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        btnSendSerializedMid.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSubConatiner2.add(btnSendSerializedMid);

        pnlMainContainer.add(pnlSubConatiner2);


        JPanel pnlSubConatiner3 = new JPanel();
//        JPanel pnlSubConatiner3 = new JPanel(new GridBagLayout());
        pnlSubConatiner3.setMaximumSize(new Dimension(1400, 650));
        pnlSubConatiner3.setMinimumSize(new Dimension(750, 300));
        pnlSubConatiner3.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        pnlSubConatiner3.setLayout(new BoxLayout(pnlSubConatiner3, BoxLayout.X_AXIS));
//        pnlSubConatiner3.setLayout(new BoxLayout(pnlSubConatiner3, BoxLayout.X_AXIS));
        pnlSubConatiner3.setBorder(BorderFactory.createEmptyBorder(5, 1, 5, 1));

        //

        //
        // dialog box text area
        pnlSubConatiner3.add(dialogPanel());
//        pnlSubConatiner3.set(dialogPanel());
        pnlMainContainer.add(pnlSubConatiner3);
        //
        // Exit Section
        JButton btnExit = new JButton("Exit");
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        pnlMainContainer.add(btnExit);

        //
        // complete main container
//        frame.add(pnlMainContainer);
        frame.setContentPane(pnlMainContainer);
        frame.pack();

        frame.setVisible(true);

        btnConnect.addActionListener(a -> {
            //
            try {
                String inputIdAddress = ipString.getText();
                int inputPortId = Integer.parseInt(portString.getText());

                hClient.startConnection(inputIdAddress, inputPortId, dialogBox, Integer.parseInt(initTimeout.getText()), Integer.parseInt(timeoutDelay.getText()));
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
                String midCommand = midString.getText();
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
