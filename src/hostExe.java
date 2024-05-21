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
    public static void createDialog() {
        hostClient hClient = new hostClient();
        openProtocolClientParserMIDClass oPCP = new openProtocolClientParserMIDClass();
        openProtocolClientSerializerMIDClass oPCS = new openProtocolClientSerializerMIDClass();
        // Host Frame
        JFrame frame = new JFrame("Host");
////        frame.setMaximumSize(new Dimension(1600, 1100));
//        frame.setMinimumSize(new Dimension(900, 600));
        frame.setPreferredSize(new Dimension(1200, 960));
        frame.setMaximumSize(new Dimension(1600, 1100));
        frame.setMinimumSize(frame.getPreferredSize());
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
//        pnlMainContainer.setMaximumSize(new Dimension(1600, 900));
//        pnlMainContainer.setMinimumSize(new Dimension(900, 600));
//        pnlMainContainer.setPreferredSize(new Dimension(1100, 600));
//        pnlMainContainer.setMaximumSize(pnlMainContainer.getPreferredSize());
//        pnlMainContainer.setMinimumSize(pnlMainContainer.getPreferredSize());
        // JPanels containers
        Dimension cnctDim = new Dimension(1200, 125);
        JPanel pnlSubConatiner1 = new JPanel();
        pnlSubConatiner1.setLayout(new BoxLayout(pnlSubConatiner1, BoxLayout.Y_AXIS));
        pnlSubConatiner1.setAlignmentY(Component.CENTER_ALIGNMENT);
        //
        JPanel pnlSubConatiner1a = new JPanel();
        pnlSubConatiner1a.setPreferredSize(cnctDim);
        pnlSubConatiner1a.setMaximumSize(new Dimension(1600, 250));
        pnlSubConatiner1a.setMinimumSize(pnlSubConatiner1a.getPreferredSize());
//        pnlSubConatiner1.setMaximumSize(new Dimension(1400, 150));
//        pnlSubConatiner1.setMinimumSize(new Dimension(750, 90));
        pnlSubConatiner1a.setLayout(new BoxLayout(pnlSubConatiner1a, BoxLayout.X_AXIS));
        pnlSubConatiner1a.setAlignmentY(Component.CENTER_ALIGNMENT);
//        pnlSubConatiner1.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSubConatiner1a.setBorder(BorderFactory.createEmptyBorder(5, 1, 10, 1));

        // Connection JPanels
        JPanel pnlCnctMain = new JPanel();
        pnlCnctMain.setLayout(new BoxLayout(pnlCnctMain, BoxLayout.Y_AXIS));
        pnlCnctMain.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlCnctMain.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        // Connection Header
        JLabel lblManualConnect = new JLabel("Connection");
        lblManualConnect.setFont(new Font("Courier", Font.BOLD, 16));
        lblManualConnect.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblManualConnect.setAlignmentY(Component.TOP_ALIGNMENT);
        lblManualConnect.setBorder(BorderFactory.createEmptyBorder(0, 10, 15, 0));
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
        pnlCnctDtlFlds.setPreferredSize(new Dimension(415, 70));
        pnlCnctDtlFlds.setMaximumSize(new Dimension(1100, 70));
        pnlCnctDtlFlds.setMinimumSize(pnlCnctDtlFlds.getPreferredSize());
        pnlCnctDtlFlds.setLayout(new BoxLayout(pnlCnctDtlFlds, BoxLayout.Y_AXIS));
//        pnlCnctDtlFlds.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlCnctDtlFlds.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlCnctDtlIpPortFlds = new JPanel();
        pnlCnctDtlIpPortFlds.setPreferredSize(new Dimension(415, 30));
        pnlCnctDtlIpPortFlds.setMaximumSize(new Dimension(1100, 30));
        pnlCnctDtlIpPortFlds.setMinimumSize(pnlCnctDtlIpPortFlds.getPreferredSize());
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
        pnlCnctDtlFldspd.setPreferredSize(new Dimension(415, 5));
        pnlCnctDtlFldspd.setMaximumSize(new Dimension(1100, 5));
        pnlCnctDtlFldspd.setMinimumSize(pnlCnctDtlFldspd.getPreferredSize());
        pnlCnctDtlFlds.add(pnlCnctDtlFldspd);
        JPanel pnlCnctDtlctrlNameFlds = new JPanel();
        pnlCnctDtlctrlNameFlds.setPreferredSize(new Dimension(415, 30));
        pnlCnctDtlctrlNameFlds.setMaximumSize(new Dimension(1100, 30));
        pnlCnctDtlctrlNameFlds.setMinimumSize(pnlCnctDtlctrlNameFlds.getPreferredSize());
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
        pnlSubConatiner1a.add(pnlCnctMain);

        // Timing JPanels
        JPanel pnlTmMain = new JPanel();
        pnlTmMain.setLayout(new BoxLayout(pnlTmMain, BoxLayout.Y_AXIS));
        pnlTmMain.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlTmMain.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        // Connection Header
        JLabel lblTime = new JLabel("Keep Alive");
        lblTime.setFont(new Font("Courier", Font.BOLD, 16));
        lblTime.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTime.setAlignmentY(Component.TOP_ALIGNMENT);
        lblTime.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        pnlTmMain.add(lblTime);
        // Timing Detail
        JPanel pnlTmDtl = new JPanel();
//        pnlTmDtl.setMaximumSize(new Dimension(200, 70));
//        pnlTmDtl.setMinimumSize(new Dimension(125, 70));
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

//        pnlSubConatiner1.add(timePanel());
        pnlSubConatiner1a.add(pnlTmMain);
        pnlSubConatiner1.add(pnlSubConatiner1a);

//        pnlMainContainer.add(pnlSubConatiner1a);

        Dimension cnctnDim = new Dimension(1100, 50);
        //
        JPanel pnlSubConatiner2 = new JPanel();
        pnlSubConatiner2.setLayout(new BoxLayout(pnlSubConatiner2, BoxLayout.X_AXIS));
//        pnlSubConatiner2.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubConatiner2.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSubConatiner2.setPreferredSize(cnctnDim);
        pnlSubConatiner2.setMaximumSize(new Dimension(1600, 50));
        pnlSubConatiner2.setMinimumSize(pnlSubConatiner2.getPreferredSize());
        pnlSubConatiner2.setBorder(BorderFactory.createEmptyBorder(5, 1, 10, 1));
        // button
//        JPanel pnlbtnConnect = new JPanel();
//        pnlbtnConnect.setMaximumSize(new Dimension(200, 350));
//        pnlbtnConnect.setMinimumSize(new Dimension(200, 135));
//        pnlbtnConnect.setMaximumSize(new Dimension(900, 150));
//        pnlbtnConnect.setMinimumSize(new Dimension(600, 90));
//        pnlbtnConnect.setLayout(new BoxLayout(pnlbtnConnect, BoxLayout.X_AXIS));
//        pnlbtnConnect.setLayout(new BoxLayout(pnlbtnConnect, BoxLayout.Y_AXIS));
//        pnlbtnConnect.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnlbtnConnect.setAlignmentY(Component.CENTER_ALIGNMENT);
        JButton btnConnect = new JButton("start connection");
//        btnConnect.setLayout(new BoxLayout(btnConnect, BoxLayout.Y_AXIS));
//        btnConnect.setLayout(new BoxLayout(btnConnect, BoxLayout.X_AXIS));
//        btnConnect.setSize(new Dimension(350, 85));
        btnConnect.setPreferredSize(new Dimension(400, 50));
//        btnConnect.setMaximumSize(new Dimension(850, 55));
//        btnConnect.setMinimumSize(new Dimension(550, 55));
        btnConnect.setMaximumSize(btnConnect.getPreferredSize());
        btnConnect.setMinimumSize(btnConnect.getPreferredSize());
        btnConnect.setAlignmentX(Component.LEFT_ALIGNMENT);
//        btnConnect.setAlignmentY(Component.CENTER_ALIGNMENT);
//        pnlbtnConnect.add(btnConnect);
//        pnlSubConatiner2.add(pnlbtnConnect);
        pnlSubConatiner2.add(btnConnect);
////        pnlSubConatiner1.add(btnConnect);
//
//        pnlMainContainer.add(pnlSubConatiner2);
////        pnlMainContainer.add(btnConnect);

//        pnlSubConatiner1.add(btnConnect);
        pnlSubConatiner1.add(pnlSubConatiner2);
        pnlMainContainer.add(pnlSubConatiner1);
        //
        Dimension midDim = new Dimension(1100, 125);
        JPanel pnlSubConatiner3 = new JPanel();
        pnlSubConatiner3.setPreferredSize(midDim);
        pnlSubConatiner3.setMaximumSize(new Dimension(1600, 250));
//        pnlSubConatiner3.setMaximumSize(new Dimension(-1, 350));
//        pnlSubConatiner3.setMinimumSize(new Dimension(-1, 135));
//        pnlSubConatiner3.setPreferredSize(new Dimension(-1, 200));
//        pnlSubConatiner3.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubConatiner3.setLayout(new BoxLayout(pnlSubConatiner3, BoxLayout.X_AXIS));
        pnlSubConatiner3.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubConatiner3.setBorder(BorderFactory.createEmptyBorder(5, 1, 10, 1));

        //
        // MID section
        JPanel pnlMidContainer = new JPanel();
//        pnlMidContainer.setMaximumSize(new Dimension(1200, 350));
//        pnlMidContainer.setMinimumSize(new Dimension(700, 135));
//        pnlMidContainer.setMaximumSize(new Dimension(-1, 350));
//        pnlMidContainer.setMinimumSize(new Dimension(-1, 135));
//        pnlMidContainer.setPreferredSize(new Dimension(-1, 200));
        pnlMidContainer.setLayout(new BoxLayout(pnlMidContainer, BoxLayout.Y_AXIS));
//        pnlMidContainer.setLayout(new BoxLayout(pnlMidContainer, BoxLayout.X_AXIS));
        pnlMidContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlMidContainer.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        // MID Header
        JLabel lblMessages = new JLabel("MID Messages");
//        lblMessages.setHorizontalTextPosition(-100);
        lblMessages.setFont(new Font("Courier", Font.BOLD, 14));
        lblMessages.setLayout(new BoxLayout(lblMessages, BoxLayout.X_AXIS));
        lblMessages.setAlignmentY(Component.TOP_ALIGNMENT);
        lblMessages.setAlignmentX(Component.LEFT_ALIGNMENT);
//        lblMessages.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 125));
        lblMessages.setBorder(BorderFactory.createEmptyBorder(0, 10, 15, 0));
//        lblMessages.setLabelFor(pnlMidContainer);
//        lblMessages.setLabelFor(pnllblMessages);
//        lblMessages.setAlignmentY(Component.TOP_ALIGNMENT);
//        pnllblMessages.add(lblMessages);
//        pnlMidContainer.add(pnllblMessages);
        pnlMidContainer.add(lblMessages);
//        pnlMidContainer.add(pnlRightMessages);
        // mid command container
        JPanel pnlMidCommand = new JPanel();
//        pnlMidCommand.setMaximumSize(new Dimension(1200, 150));
//        pnlMidCommand.setMinimumSize(new Dimension(700, 80));
        pnlMidCommand.setLayout(new BoxLayout(pnlMidCommand, BoxLayout.X_AXIS));
        // labels
        JPanel pnlAllMIDLbls = new JPanel();
        pnlAllMIDLbls.setMaximumSize(new Dimension(125, 150));
        pnlAllMIDLbls.setMinimumSize(new Dimension(100, 80));
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
        pnlMIDDtlFlds.setMaximumSize(new Dimension(1000, 150));
        pnlMIDDtlFlds.setMinimumSize(new Dimension(600, 80));
//        pnlMIDDtlFlds.setMaximumSize(new Dimension(-1, 150));
//        pnlMIDDtlFlds.setMinimumSize(new Dimension(-1, 80));
//        pnlMIDDtlFlds.setPreferredSize(new Dimension(-1, 150));
        pnlMIDDtlFlds.setLayout(new BoxLayout(pnlMIDDtlFlds, BoxLayout.Y_AXIS));
        pnlMIDDtlFlds.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel pnlMIDDtlCmdInVFlds = new JPanel();
        pnlMIDDtlCmdInVFlds.setMaximumSize(new Dimension(1000, 30));
        pnlMIDDtlCmdInVFlds.setMinimumSize(new Dimension(600, 30));
//        pnlMIDDtlCmdInVFlds.setMaximumSize(new Dimension(-1, 30));
//        pnlMIDDtlCmdInVFlds.setMinimumSize(new Dimension(-1, 25));
//        pnlMIDDtlCmdInVFlds.setPreferredSize(new Dimension(-1, 30));
        pnlMIDDtlCmdInVFlds.setLayout(new BoxLayout(pnlMIDDtlCmdInVFlds, BoxLayout.X_AXIS));
//        JPanel pnlMIDStringDd = new JPanel();
//        JTextField midString = new JTextField();
//        midString.setToolTipText("'MID' Command");
//        midString.setAlignmentX(Component.LEFT_ALIGNMENT);
//        midString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        //dropdown selection
        String[] midCmdDd = {"       ",
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
        JComboBox<String> midCmdCB = new JComboBox<>(midCmdDd);
//        midCmdCB.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
//        midCmdCB.setBorder(BorderFactory.createLineBorder(Color.white, 1));
//        midCmdCB.setBorder(BorderFactory.createLineBorder(frame.getBackground()));
//        UIManager.put("ComoboBox.border", BorderFactory.createEmptyBorder());
//        UIManager.put("ComboBox.border", new Insets(0, 0, 0, 0));
//        midCmdCB.setBorder(BorderFactory.createEmptyBorder());
        midCmdCB.setBorder(null);
        midCmdCB.setAlignmentX(Component.LEFT_ALIGNMENT);
        midCmdCB.setToolTipText("'MID' Command");
        midCmdCB.setEditable(true);
        midCmdCB.setBackground(Color.white);
//        midCmdCB.setVisible(false);
//        midString.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                updateMIDCB();
//            }
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                updateMIDCB();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                updateMIDCB();
//            }
//            private void updateMIDCB() {
//                String text = midString.getText().toLowerCase(); // Perform filtering (optional)
//                midCmdCB.getPopupMenuListeners();
////                midCmdCB.getPopup().getListSelectionModel().clearSelection(); // Clear selection
//                // Filter options based on user input (optional)
//                boolean showDropdown = false;
//                for (String option : midCmdDd) {
//                    if (option.toLowerCase().contains(text)) {
//                        midCmdCB.addItem(option); // Add matching options to dropdown (dynamically)
//                        showDropdown = true;
//                    } else {
//                        midCmdCB.removeItem(option); // Remove non-matching options
//                    }
//                }
//
//                // Show/hide dropdown based on matching options
//                midCmdCB.setVisible(showDropdown);
//            }
//        });
//        pnlMIDDtlCmdInVFlds.add(midString);
        midCmdCB.addActionListener(e -> {
            midCmdCB.setVisible(true);
//                midCmdCB.setPopupVisible(true);
            String midString = midCmdCB.getEditor().getItem().toString();
            ArrayList<String> filterMIDs = new ArrayList<>();
            for (String mid : midCmdDd) {
                if (mid.toLowerCase().contains(midString.toLowerCase())) {
                    filterMIDs.add(mid);
                }
            }
            midCmdCB.setModel(new DefaultComboBoxModel<>(filterMIDs.toArray(new String[0])));
        });
        pnlMIDDtlCmdInVFlds.add(midCmdCB);
//        pnlMIDDtlCmdInVFlds.add(midString);
//        pnlMIDDtlCmdInVFlds.add(pnlMIDStringDd);
//        pnlMIDDtlCmdInVFlds.add(midString);
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
//        pnlMIDDtlFldsPd.setPreferredSize(new Dimension(-1, 5));
        pnlMIDDtlFlds.add(pnlMIDDtlFldsPd);
        JPanel pnlMIDDtlSrlzdFlds = new JPanel();
        pnlMIDDtlSrlzdFlds.setMaximumSize(new Dimension(1000, 30));
        pnlMIDDtlSrlzdFlds.setMinimumSize(new Dimension(600, 30));
//        pnlMIDDtlSrlzdFlds.setMaximumSize(new Dimension(-1, 30));
//        pnlMIDDtlSrlzdFlds.setMinimumSize(new Dimension(-1, 25));
//        pnlMIDDtlSrlzdFlds.setPreferredSize(new Dimension(-1, 30));
        pnlMIDDtlSrlzdFlds.setLayout(new BoxLayout(pnlMIDDtlSrlzdFlds, BoxLayout.X_AXIS));
        JTextField serializedMidString = new JTextField();
        serializedMidString.setToolTipText("include serialized MID message.");
        serializedMidString.setAlignmentX(Component.LEFT_ALIGNMENT);
        serializedMidString.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 10));
        pnlMIDDtlSrlzdFlds.add(serializedMidString);
        pnlMIDDtlFlds.add(pnlMIDDtlSrlzdFlds);
        pnlMidCommand.add(pnlMIDDtlFlds);
        // MID Send JPanels
        JPanel pnlSendMID = new JPanel();
        pnlSendMID.setMaximumSize(new Dimension(185, 150));
        pnlSendMID.setMinimumSize(new Dimension(185, 80));
        pnlSendMID.setLayout(new BoxLayout(pnlSendMID, BoxLayout.Y_AXIS));
//        pnlSendMID.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSendMID.setAlignmentY(Component.CENTER_ALIGNMENT);
//        pnlSendMID.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
//        pnlSendMID.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 25));
        // main mid container
        JButton btnSendMid = new JButton("Send");
//        btnSendMid.setPreferredSize(new Dimension(155, 30));
//        btnSendMid.setPreferredSize(new Dimension(185, 30));
        btnSendMid.setMaximumSize(new Dimension(125, 30));
        btnSendMid.setMinimumSize(new Dimension(125, 30));
//        btnSendMid.setMaximumSize(new Dimension(125, 35));
        btnSendMid.setMaximumSize(btnSendMid.getMaximumSize());
        btnSendMid.setMinimumSize(btnSendMid.getMinimumSize());
//        btnSendMid.setAlignmentY(Component.TOP_ALIGNMENT);
        btnSendMid.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnSendMid.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSendMID.add(btnSendMid);
        JPanel pnlSendMIDPd = new JPanel();
//        pnlSendMIDPd.setPreferredSize(new Dimension(185, 30));
        pnlSendMIDPd.setMaximumSize(new Dimension(125, 5));
        pnlSendMIDPd.setMinimumSize(new Dimension(125, 5));
//        pnlSendMIDPd.setMaximumSize(btnSendMid.getMaximumSize());
//        pnlSendMIDPd.setMinimumSize(btnSendMid.getMinimumSize());
//        pnlSendMIDPd.setPreferredSize(new Dimension(-1, 5));
        pnlSendMID.add(pnlSendMIDPd);
        JButton btnSendSerializedMid = new JButton("Send");
        btnSendSerializedMid.setMaximumSize(new Dimension(125, 30));
        btnSendSerializedMid.setMinimumSize(new Dimension(125, 30));
//        btnSendSerializedMid.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 25));
//        btnSendSerializedMid.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        btnSendSerializedMid.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnSendSerializedMid.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlSendMID.add(btnSendSerializedMid);
        pnlMidCommand.add(pnlSendMID);
        pnlMidContainer.add(pnlMidCommand);

//        pnlSubConatiner2.add(midPanel());
        pnlSubConatiner3.add(pnlMidContainer);

        pnlMainContainer.add(pnlSubConatiner3);

        //
        //dialog panel
        JPanel pnlSubConatiner4 = new JPanel();
//        pnlSubConatiner4.setMaximumSize(new Dimension(1400, 650));
//        pnlSubConatiner4.setMinimumSize(new Dimension(750, 300));
//        pnlSubConatiner4.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        pnlSubConatiner4.setMaximumSize(pnlMainContainer.getMaximumSize());
        pnlSubConatiner4.setMinimumSize(pnlMainContainer.getMinimumSize());
        pnlSubConatiner4.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubConatiner4.setLayout(new BoxLayout(pnlSubConatiner4, BoxLayout.X_AXIS));
//        pnlSubConatiner3.setLayout(new BoxLayout(pnlSubConatiner3, BoxLayout.X_AXIS));
        pnlSubConatiner4.setBorder(BorderFactory.createEmptyBorder(5, 1, 5, 1));
        // dialog box text area
        // Dialog section
        JPanel pnlDialogContainer = new JPanel();
//        pnlDialogContainer.setMaximumSize(new Dimension(1300, 600));
//        pnlDialogContainer.setMinimumSize(new Dimension(750, 300));
        pnlDialogContainer.setPreferredSize(new Dimension(1100, 250));
//        pnlDialogContainer.setMaximumSize(pnlMainContainer.getMaximumSize());
        pnlDialogContainer.setMaximumSize(new Dimension(1100, 550));
        pnlDialogContainer.setMinimumSize(pnlDialogContainer.getMinimumSize());
        pnlDialogContainer.setLayout(new BoxLayout(pnlDialogContainer, BoxLayout.Y_AXIS));
//        pnlDialogContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
//        pnlDialogContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlDialogContainer.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        // Dialog Header
        JLabel lblDialog = new JLabel("Communication Log");
        lblDialog.setFont(new Font("Courier", Font.BOLD, 14));
//        lblDialog.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblDialog.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlDialogContainer.add(lblDialog);
        // mid command container
        JPanel pnldialogBox = new JPanel();
        pnldialogBox.setLayout(new BoxLayout(pnldialogBox, BoxLayout.X_AXIS));
//        pnldialogBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        JTextArea dialogBox = new JTextArea();
        JTextArea dialogBox = new JTextArea();
        dialogBox.setLineWrap(true);
        dialogBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        dialogBox.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        dialogBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        JScrollPane scrollDialogContainer = new JScrollPane(dialogBox);
        pnldialogBox.add(scrollDialogContainer);
        pnlDialogContainer.add(pnldialogBox);
        pnlSubConatiner4.add(pnlDialogContainer);

        pnlMainContainer.add(pnlSubConatiner4);
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
//                String midCommand = midString.getText();
                String midCommand = midCmdCB.toString();
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
