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

//    static JTextField ipString;
    static JTextArea ipString;
    static JTextArea portString;
    static JTextArea initTimeout;
    static JTextArea timeoutDelay;
//    static JTextField midString;
    static JTextArea midString;
//    static JTextField serializedMidString;
    static JTextArea serializedMidString;
//    static JTextField midInputString;
    static JTextArea midInputString;
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
//        lblManualConnect.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblManualConnect.setAlignmentY(Component.TOP_ALIGNMENT);
        pnlCnctMain.add(lblManualConnect);

        // Connect Detail
        // ip and port text areas
        JPanel pnlCnctDtl = new JPanel();
        pnlCnctDtl.setLayout(new BoxLayout(pnlCnctDtl, BoxLayout.X_AXIS));
        pnlCnctDtl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel ipLbl = new JLabel("Host:      ");
//        ipLbl.setMaximumSize(new Dimension(75, 30));
//        ipLbl.setMinimumSize(new Dimension(50, 30));
        ipLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlCnctDtl.add(ipLbl);
//        JTextField ipString = new JTextField("127.0.0.1");
        ipString = new JTextArea("127.0.0.1");
//        ipString.setMaximumSize(new Dimension(200, 30));
//        ipString.setMinimumSize(new Dimension(75, 30));
        ipString.setToolTipText("Device/Controller IP Address required.");
        ipString.setAlignmentX(Component.LEFT_ALIGNMENT);
        ipString.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        pnlCnctDtl.add(ipString);

        JLabel portLbl = new JLabel("Port:    ");
//        portLbl.setMaximumSize(new Dimension(75, 30));
//        portLbl.setMinimumSize(new Dimension(50, 30));
        portLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        portLbl.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        pnlCnctDtl.add(portLbl);
//        JTextField portString = new JTextField("4545");
        portString = new JTextArea("4545");
//        portString.setMaximumSize(new Dimension(200, 30));
//        portString.setMinimumSize(new Dimension(75, 30));
        portString.setToolTipText("Device/Controller Port Id required.");
        portString.setAlignmentX(Component.LEFT_ALIGNMENT);
        portString.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        pnlCnctDtl.add(portString);

        pnlCnctMain.add(pnlCnctDtl);

        JPanel pnlDeviceDtl = new JPanel();
        pnlDeviceDtl.setLayout(new BoxLayout(pnlDeviceDtl, BoxLayout.X_AXIS));
        pnlDeviceDtl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JLabel lblCtrl = new JLabel("Device:    ");
//        lblCtrl.setMaximumSize(new Dimension(75, 30));
//        lblCtrl.setMinimumSize(new Dimension(50, 30));
        lblCtrl.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlDeviceDtl.add(lblCtrl);
//        JTextField ctrlName = new JTextField("deviceName");
        JTextArea ctrlName = new JTextArea("deviceName");
//        ctrlName.setMaximumSize(new Dimension(200, 30));
//        ctrlName.setMinimumSize(new Dimension(75, 30));
        ctrlName.setToolTipText("Device/Controller Name.");
        ctrlName.setAlignmentX(Component.LEFT_ALIGNMENT);
        ctrlName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        pnlDeviceDtl.add(ctrlName);

        pnlCnctMain.add(pnlDeviceDtl);

        return pnlCnctMain;
    }
    //
    static JPanel timePanel() {
        // Timing JPanels
        JPanel pnlTmMain = new JPanel();
        pnlTmMain.setMaximumSize(new Dimension(450, 350));
        pnlTmMain.setMinimumSize(new Dimension(250, 135));
        pnlTmMain.setLayout(new BoxLayout(pnlTmMain, BoxLayout.Y_AXIS));
        pnlTmMain.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Connection Header
        JLabel lblTime = new JLabel("Keep Alive");
        lblTime.setFont(new Font("Courier", Font.BOLD, 16));
//        lblTime.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblTime.setAlignmentY(Component.TOP_ALIGNMENT);
        pnlTmMain.add(lblTime);
        JTextField tmUnit = new JTextField("sec.");
        tmUnit.setEditable(false);

        // Timing Detail
        // delay and timeout text areas
        JPanel pnlTmDelay = new JPanel();
        pnlTmDelay.setLayout(new BoxLayout(pnlTmDelay, BoxLayout.X_AXIS));
        pnlTmDelay.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel lblInitDelay = new JLabel("Delay:        ");
//        lblInitDelay.setMaximumSize(new Dimension(75, 30));
//        lblInitDelay.setMinimumSize(new Dimension(50, 30));
        lblInitDelay.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlTmDelay.add(lblInitDelay);
//        JTextField initTimeout = new JTextField("75");
        initTimeout = new JTextArea("75");
//        initTimeout.setMaximumSize(new Dimension(100, 30));
//        initTimeout.setMinimumSize(new Dimension(35, 30));
        initTimeout.setToolTipText("Initial delay period before sending keep alive message.");
        initTimeout.setAlignmentX(Component.LEFT_ALIGNMENT);
        initTimeout.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        pnlTmDelay.add(initTimeout);

        pnlTmMain.add(pnlTmDelay);

        JPanel pnlTmPrd = new JPanel();
        pnlTmPrd.setLayout(new BoxLayout(pnlTmPrd, BoxLayout.X_AXIS));
        pnlTmPrd.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JLabel lblTimeoutPrd = new JLabel("Timeout:   ");
//        lblTimeoutPrd.setMaximumSize(new Dimension(75, 30));
//        lblTimeoutPrd.setMinimumSize(new Dimension(50, 30));
        lblTimeoutPrd.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlTmPrd.add(lblTimeoutPrd);
//        JTextField timeoutDelay = new JTextField("65");
        timeoutDelay = new JTextArea("65");
//        timeoutDelay.setMaximumSize(new Dimension(100, 30));
//        timeoutDelay.setMinimumSize(new Dimension(35, 30));
        timeoutDelay.setToolTipText("Period between sending keep alive message.");
        timeoutDelay.setAlignmentX(Component.LEFT_ALIGNMENT);
        timeoutDelay.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        pnlTmPrd.add(timeoutDelay);

        pnlTmMain.add(pnlTmPrd);

        return pnlTmMain;
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
        midString = new JTextArea();
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
        midInputString = new JTextArea();
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
    public static void createDialog() {
        hostClient hClient = new hostClient();
        openProtocolClientParserMIDClass oPCP = new openProtocolClientParserMIDClass();
        openProtocolClientSerializerMIDClass oPCS = new openProtocolClientSerializerMIDClass();
        // Host Frame
        JFrame frame = new JFrame("Host");
        frame.setMaximumSize(new Dimension(1600, 1100));
        frame.setMinimumSize(new Dimension(900, 600));
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                hostLogger.hostLog("exit", "abc", "info");
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

        JPanel pnlSubConatiner2 = new JPanel();
//        JPanel pnlSubConatiner2 = new JPanel(new GridBagLayout());
        pnlSubConatiner2.setMaximumSize(new Dimension(1400, 350));
        pnlSubConatiner2.setMinimumSize(new Dimension(750, 135));
        pnlSubConatiner1.setAlignmentY(Component.CENTER_ALIGNMENT);
        pnlSubConatiner2.setLayout(new BoxLayout(pnlSubConatiner2, BoxLayout.X_AXIS));
        pnlSubConatiner2.setBorder(BorderFactory.createEmptyBorder(5, 1, 10, 1));

        JPanel pnlSubConatiner3 = new JPanel();
//        JPanel pnlSubConatiner3 = new JPanel(new GridBagLayout());
        pnlSubConatiner3.setMaximumSize(new Dimension(1400, 650));
        pnlSubConatiner3.setMinimumSize(new Dimension(750, 300));
        pnlSubConatiner1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        pnlSubConatiner3.setLayout(new BoxLayout(pnlSubConatiner3, BoxLayout.X_AXIS));
        pnlSubConatiner3.setBorder(BorderFactory.createEmptyBorder(5, 1, 5, 1));

        //
        // ip/port JPanels
        pnlSubConatiner1.add(connectionPanel());

        //
        // Timing JPanels
        pnlSubConatiner1.add(timePanel());

        pnlMainContainer.add(pnlSubConatiner1);
//        pnlMainContainer.

        // button
        JPanel pnlCnctBtn = new JPanel();
//        pnlCnctBtn.setLayout(new FlowLayout(FlowLayout.LEFT));
//        pnlCnctBtn.setAlignmentX(Component.RIGHT_ALIGNMENT);
        pnlCnctBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pnlCnctBtn.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
//        pnlCnctBtn.setMaximumSize(new Dimension(300, 85));
//        pnlCnctBtn.setMinimumSize(new Dimension(200, 85));
        JButton btnConnect = new JButton("start connection");
        btnConnect.setAlignmentX(Component.LEFT_ALIGNMENT);
//        btnConnect.setLayout(new FlowLayout(FlowLayout.LEFT));
//        btnConnect.setMaximumSize(new Dimension(125, 35));
//        btnConnect.setMinimumSize(new Dimension(75, 35));
//        pnlCnctBtn.add(btnConnect);
//        pnlManualConnect.add(btnConnect);
//        pnlTm.add(btnConnect);
        pnlSubConatiner1.add(btnConnect);
//        pnlMainContainer.add(btnConnect);
//        pnlMainContainer.add(pnlCnctBtn);
//        pnlMainContainer.add(btnConnect);

//        pnlMainContainer.add(pnlManualConnect);
//        pnlMainContainer.add(pnlSubConatiner1);
        //
        // MID section
        // main mid container
        JButton btnSendMid = new JButton("Send");
        btnSendMid.setMaximumSize(new Dimension(50, 35));
        btnSendMid.setMinimumSize(new Dimension(25, 35));
        btnSendMid.setAlignmentY(Component.TOP_ALIGNMENT);
        btnSendMid.setAlignmentX(Component.RIGHT_ALIGNMENT);

        JButton btnSendSerializedMid = new JButton("Send");
        btnSendSerializedMid.setMaximumSize(new Dimension(50, 35));
        btnSendSerializedMid.setMinimumSize(new Dimension(25, 35));
        btnSendMid.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        btnSendSerializedMid.setAlignmentX(Component.RIGHT_ALIGNMENT);

//        pnlMidContainer.add(pnlSerializedMidCommand);
//        pnlSubConatiner2.add(pnlMidContainer);
        pnlSubConatiner2.add(midPanel());
        pnlSubConatiner2.add(btnSendMid);
        pnlSubConatiner2.add(btnSendSerializedMid);
        pnlMainContainer.add(pnlSubConatiner2);

        //
        // dialog box text area
        JTextArea dialogBox = new JTextArea();
//        dialogBox.setColumns(100);
//        dialogBox.setRows(10);
        dialogBox.setLineWrap(true);
        //
//        pnlMainContainer.add(pnlMidContainer);
        //
        // Dialog section
        // dialog container
        JPanel pnlDialogContainer = new JPanel();
        JScrollPane scrollDialogContainer = new JScrollPane(dialogBox);

        pnlDialogContainer.setLayout(new BoxLayout(pnlDialogContainer, BoxLayout.Y_AXIS));
//        pnlDialogContainer.setMinimumSize(new Dimension(100, 50));
        pnlDialogContainer.add("dialog", scrollDialogContainer);
        // pnlDialogContainer.setLayout(new BoxLayout(pnlDialogContainer, BoxLayout.Y_AXIS));
        // pnlDialogContainer.add("dialog", dialogBox);
        pnlMainContainer.add(pnlDialogContainer);
        //
        // Exit Section
        // Exit container
        JPanel pnlEnd = new JPanel();
        JButton exit = new JButton("Exit");
        pnlEnd.add(exit);
        pnlMainContainer.add(pnlEnd);
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
        exit.addActionListener(e -> {
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
