import javax.swing.*;
import javax.swing.plaf.TextUI;
import javax.swing.text.JTextComponent;
//import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class hostExe {

    //
    public static void createDialog() {
        hostClient hClient = new hostClient();
        openProtocolClientParserMIDClass oPCP = new openProtocolClientParserMIDClass();
        openProtocolClientSerializerMIDClass oPCS = new openProtocolClientSerializerMIDClass();
        // Host Frame
        JFrame frame = new JFrame("Host");
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
//        pnlMainContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        // JPanels containers
        JPanel pnlSubConatiner1 = new JPanel(new BorderLayout());
//        pnlSubConatiner1.setAlignmentY(14.0F);
        pnlSubConatiner1.setLayout(new BoxLayout(pnlSubConatiner1, BoxLayout.X_AXIS));
        pnlSubConatiner1.setBorder(BorderFactory.createEmptyBorder(5, 1, 10, 1));
//        pnlSubConatiner1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pnlSubConatiner1.setMaximumSize(new Dimension(1400, 250));
        pnlSubConatiner1.setMinimumSize(new Dimension(750, 135));

        JPanel pnlSubConatiner2 = new JPanel(new BorderLayout());
        pnlSubConatiner2.setLayout(new BoxLayout(pnlSubConatiner2, BoxLayout.X_AXIS));
        pnlSubConatiner2.setBorder(BorderFactory.createEmptyBorder(5, 1, 10, 1));
        pnlSubConatiner2.setMaximumSize(new Dimension(1400, 100));
        pnlSubConatiner2.setMinimumSize(new Dimension(750, 85));

        JPanel pnlSubConatiner3 = new JPanel(new BorderLayout());
        pnlSubConatiner3.setLayout(new BoxLayout(pnlSubConatiner3, BoxLayout.X_AXIS));
        pnlSubConatiner3.setBorder(BorderFactory.createEmptyBorder(5, 1, 5, 1));
        pnlSubConatiner3.setMaximumSize(new Dimension(1400, 750));
        pnlSubConatiner3.setMinimumSize(new Dimension(750, 350));

        // Connection JPanels
        JPanel pnlCnct = new JPanel();
        pnlCnct.setLayout(new BoxLayout(pnlCnct, BoxLayout.Y_AXIS));
        pnlCnct.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        pnlCnct.setMaximumSize(new Dimension(860, 75));
        pnlCnct.setMinimumSize(new Dimension(225, 50));

        // Connection Header
//        JPanel pnlCnctHdr = new JPanel();
//        pnlCnctHdr.setLayout(new BoxLayout(pnlCnctHdr, BoxLayout.X_AXIS));
        JLabel lblManualConnect = new JLabel("Connection");
        lblManualConnect.setFont(new Font("Courier", Font.BOLD, 16));
//        lblManualConnect.setMaximumSize(new Dimension(75, 50));
//        lblManualConnect.setMinimumSize(new Dimension(75, 35));
        lblManualConnect.setLayout(new FlowLayout(FlowLayout.CENTER));
//        lblManualConnect.setMinimumSize(new Dimension(50, 15));
//        lblManualConnect.setHorizontalAlignment(0);
//        pnlCnctHdr.add(lblManualConnect);
        pnlCnct.add(lblManualConnect);
//        lblManualConnect.setPreferredSize(new Dimension(50, 15));

//        JLabel lblCtrl = new JLabel("Device: ");
//        lblCtrl.setLayout(new FlowLayout(FlowLayout.TRAILING));
//        pnlCnctHdr.add(lblCtrl);
//
//        JTextField ctrlName = new JTextField(55);
//        ctrlName.setMinimumSize(new Dimension(45, 15));
//        ctrlName.setToolTipText("Device/Controller Name.");
//        ctrlName.setText("deviceName");
//        ctrlName.setLayout(new FlowLayout(FlowLayout.TRAILING));
//        pnlCnctHdr.add(ctrlName);

//        pnlCnct.add(pnlCnctHdr);

        // Connect Detail
        // ip and port text areas
        JPanel pnlCnctDtl = new JPanel();
        pnlCnctDtl.setLayout(new BoxLayout(pnlCnctDtl, BoxLayout.X_AXIS));
//        pnlCnctDtl.setMaximumSize(new Dimension(860, 35));
//        pnlCnctDtl.setMinimumSize(new Dimension(225, 35));

        JLabel lblCtrl = new JLabel("Device:    ");
        lblCtrl.setMaximumSize(new Dimension(75, 30));
        lblCtrl.setMinimumSize(new Dimension(50, 30));
        lblCtrl.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlCnctDtl.add(lblCtrl);
        JTextField ctrlName = new JTextField("deviceName");
        ctrlName.setMaximumSize(new Dimension(200, 30));
        ctrlName.setMinimumSize(new Dimension(75, 30));
        ctrlName.setToolTipText("Device/Controller Name.");
//        ctrlName.setText("deviceName");
        ctrlName.setLayout(new FlowLayout(FlowLayout.TRAILING));
        ctrlName.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 10));
        pnlCnctDtl.add(ctrlName);

        JLabel ipLbl = new JLabel("Host:    ");
        ipLbl.setLayout(new FlowLayout(FlowLayout.TRAILING));
        ipLbl.setMaximumSize(new Dimension(75, 30));
        ipLbl.setMinimumSize(new Dimension(50, 30));
        pnlCnctDtl.add(ipLbl);
//        JPanel pnlIp = new JPanel(new BorderLayout());
        JTextField ipString = new JTextField("127.0.0.1");
        ipString.setMaximumSize(new Dimension(200, 30));
        ipString.setMinimumSize(new Dimension(75, 30));
        ipString.setToolTipText("Device/Controller IP Address required.");
        ipString.setLayout(new FlowLayout(FlowLayout.TRAILING));
        ipString.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 10));
        pnlCnctDtl.add(ipString);
//        pnlIp.add(ipString);
//        System.out.println("check ip height: " + pnlIp.getHeight());
//        pnlCnctDtl.add(pnlIp);

        JLabel portLbl = new JLabel("Port:    ");
        portLbl.setLayout(new FlowLayout(FlowLayout.TRAILING));
        portLbl.setMaximumSize(new Dimension(75, 30));
        portLbl.setMinimumSize(new Dimension(50, 30));
        pnlCnctDtl.add(portLbl);
        JTextField portString = new JTextField("4545");
        portString.setMaximumSize(new Dimension(200, 30));
        portString.setMinimumSize(new Dimension(75, 30));
//        portString.setToolTipText("Device/Controller Port Id required.");
        portString.setLayout(new FlowLayout(FlowLayout.TRAILING));
        portString.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        pnlCnctDtl.add(portString);
//        pnlPort.add(portString);
//        pnlCnctDtl.add(pnlPort);

        pnlCnct.add(pnlCnctDtl);
        pnlSubConatiner1.add(pnlCnct);
        //
        // Ip address and Port section
        // connection container
//        JPanel pnlManualConnect = new JPanel();
//        pnlManualConnect.add(lblManualConnect);
//        //
////        JPanel pnlIp = new JPanel(new BorderLayout());
////        JLabel ipLbl = new JLabel("Host: ");
////        pnlIp.add(ipLbl);
//////        pnlIp.add("ip", ipString);
////        pnlIp.add(ipString);
//////        pnlIp.setBorder(BorderFactory.createEtchedBorder());
////        JPanel pnlPort = new JPanel(new BorderLayout());
////        JLabel portLbl = new JLabel("Port: ");
////        pnlPort.add(portLbl);
//////        pnlPort.add("port", portString);
////        pnlPort.add(portString);
//////        pnlPort.setBorder(BorderFactory.createEtchedBorder());
//        //
////        pnlManualConnect.setLayout(new BoxLayout(pnlManualConnect, BoxLayout.X_AXIS));
//        BoxLayout ippBox = new BoxLayout(pnlManualConnect, BoxLayout.X_AXIS);
////        pnlManualConnect.setLayout(new BorderLayout());
//        pnlManualConnect.setLayout(ippBox);
//        // pnlManualConnect.setBorder(BorderFactory.createEtchedBorder());
////        pnlManualConnect.add("ip", ipString);
////        pnlManualConnect.add("port", portString);
////        pnlManualConnect.add(ipString, BorderLayout.WEST);
////        pnlManualConnect.add("port", portString);
////        pnlManualConnect.add(portString, BorderLayout.EAST);
//        pnlManualConnect.setBorder(BorderFactory.createEtchedBorder());
//        pnlManualConnect.add("ip", pnlIp);
//        pnlManualConnect.add("port", pnlPort);
        //
        // Timing JPanels

        JPanel pnlTm = new JPanel();
        pnlTm.setLayout(new BoxLayout(pnlTm, BoxLayout.Y_AXIS));
        pnlTm.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        pnlTm.setMaximumSize(new Dimension(400, 75));
        pnlTm.setMinimumSize(new Dimension(215, 50));

        JLabel lblTime = new JLabel("Keep Alive");
        lblTime.setFont(new Font("Courier", Font.BOLD, 16));
        lblTime.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlTm.add(lblTime);
//        JLabel lblTime = new JLabel("Keep Alive");
//        pnlTm.add(lblTime);
        // Timer Detail
//        JPanel pnlTmDtl = new JPanel();
//        pnlTmDtl.setLayout(new BoxLayout(pnlTmDtl, BoxLayout.Y_AXIS));

        JTextField tmUnit = new JTextField("sec.");
        tmUnit.setEditable(false);

        JPanel pnlTmDelay = new JPanel();
        pnlTmDelay.setLayout(new BoxLayout(pnlTmDelay, BoxLayout.X_AXIS));
//        pnlTmDelay.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblInitDelay = new JLabel("Delay:      ");
        lblInitDelay.setLayout(new FlowLayout(FlowLayout.LEFT));
        lblInitDelay.setMaximumSize(new Dimension(75, 30));
        lblInitDelay.setMinimumSize(new Dimension(50, 30));
//        pnlTm.add(lblInitDelay);
        pnlTmDelay.add(lblInitDelay);
        JTextField initTimeout = new JTextField("75");
        initTimeout.setMaximumSize(new Dimension(100, 30));
        initTimeout.setMinimumSize(new Dimension(45, 30));
//        portString.setToolTipText("Device/Controller Port Id required.");
        initTimeout.setLayout(new FlowLayout(FlowLayout.TRAILING));
//        initTimeout.setText("75");
        initTimeout.setToolTipText("Initial delay period before sending keep alive message");
        //initTimeout.add(tmUnit);
//        pnlTmDtl.add(initTimeout);
//        pnlTm.add(initTimeout);
        pnlTmDelay.add(initTimeout);
//        pnlTmDelay.add(tmUnit);
        pnlTm.add(pnlTmDelay);

        JPanel pnlTmPrd = new JPanel();
        pnlTmPrd.setLayout(new BoxLayout(pnlTmPrd, BoxLayout.X_AXIS));
        pnlTmPrd.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblTimeoutPrd = new JLabel("Timeout:    ");
        lblInitDelay.setMaximumSize(new Dimension(75, 30));
        lblInitDelay.setMinimumSize(new Dimension(50, 30));
//        pnlTmDtl.add(lblTimeoutPrd);
//        pnlTm.add(lblTimeoutPrd);
        pnlTmPrd.add(lblTimeoutPrd);
        JTextField timeoutDelay = new JTextField("65");
        timeoutDelay.setMaximumSize(new Dimension(100, 30));
        timeoutDelay.setMinimumSize(new Dimension(45, 30));
//        timeoutDelay.setText("65");
        timeoutDelay.setToolTipText("Period between keep alive messages");
//        timeoutDelay.add(tmUnit);
//        pnlTmDtl.add(timeoutDelay);
        pnlTmPrd.add(timeoutDelay);
//        pnlTmPrd.add(tmUnit);
        pnlTm.add(pnlTmPrd);
//        pnlTm.add(pnlTmDtl);

//        JPanel pnlTime = new JPanel();
//        BoxLayout timeBox = new BoxLayout(pnlTime, BoxLayout.Y_AXIS);
//        pnlTime.setLayout(timeBox);;
//        pnlTime.add(initTimeout);
//        pnlTime.add(timeoutDelay);
////        pnlManualConnect.
//        pnlManualConnect.add(pnlTime);
        pnlSubConatiner1.add(pnlTm);
//        pnlMainContainer.add(pnlSubConatiner1);
//        pnlMainContainer.

        // button
        JButton btnConnect = new JButton("start connection");
        btnConnect.setMaximumSize(new Dimension(125, 35));
        btnConnect.setMinimumSize(new Dimension(75, 35));
//        pnlManualConnect.add(btnConnect);
//        pnlTm.add(btnConnect);
        pnlSubConatiner1.add(btnConnect);

//        pnlMainContainer.add(pnlManualConnect);
        pnlMainContainer.add(pnlSubConatiner1);
        //
        // MID section
        // main mid container
        JPanel pnlMidContainer = new JPanel();
        pnlMidContainer.setLayout(new BoxLayout(pnlMidContainer, BoxLayout.Y_AXIS));
        pnlMidContainer.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        pnlMidContainer.setMaximumSize(new Dimension(1000, 75));
        pnlMidContainer.setMinimumSize(new Dimension(600, 50));

        JLabel lblMessages = new JLabel("MID Messages");
        lblMessages.setFont(new Font("Courier", Font.BOLD, 14));
        lblMessages.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlMidContainer.add(lblMessages);

        // mid container
        JPanel pnlMidCommand = new JPanel();
        pnlMidCommand.setLayout(new BoxLayout(pnlMidCommand, BoxLayout.X_AXIS));

        JLabel lblMID = new JLabel("MID:    ");
        lblCtrl.setMaximumSize(new Dimension(75, 30));
        lblCtrl.setMinimumSize(new Dimension(50, 30));
        lblMID.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlMidCommand.add(lblMID);
        // MID Command and input vals section
        JTextField midString = new JTextField();
        midString.setMaximumSize(new Dimension(250, 30));
        midString.setMinimumSize(new Dimension(100, 30));
        midString.setToolTipText("MID Command");
        midString.setLayout(new FlowLayout(FlowLayout.TRAILING));
        midString.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 10));
        pnlMidCommand.add(midString);

        JLabel lblVals = new JLabel("Inp. Vals:    ");
        lblVals.setLayout(new FlowLayout(FlowLayout.TRAILING));
        lblVals.setMaximumSize(new Dimension(75, 30));
        lblVals.setMinimumSize(new Dimension(50, 30));
//        lblVals.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlMidCommand.add(lblVals);
        JTextField midInputString = new JTextField();
        ipString.setMaximumSize(new Dimension(250, 30));
        ipString.setMinimumSize(new Dimension(100, 30));
        midInputString.setToolTipText("include MID command values\nif applicable.");
        midInputString.setLayout(new FlowLayout(FlowLayout.TRAILING));
        midInputString.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnlMidCommand.add(midInputString);

        JButton btnSendMid = new JButton("Send");
        btnConnect.setMaximumSize(new Dimension(50, 35));
        btnConnect.setMinimumSize(new Dimension(25, 35));

        pnlMidCommand.add(btnSendMid);
        pnlMidContainer.add(pnlMidCommand);

        // MID Command text areas
//        JTextArea midString = new JTextArea();
//        JTextArea midInputString = new JTextArea();
//        JTextField midInputString = new JTextField(70);
//        midString.setColumns(50);
//        midString.setRows(10);
//        midInputString.setColumns(50);
//        midInputString.setRows(10);

//        JTextArea serializedMidString = new JTextArea();
        // serialized mid container
        JPanel pnlSerializedMidCommand = new JPanel();
        // manually Serialized MID command
        pnlSerializedMidCommand.setLayout(new BoxLayout(pnlSerializedMidCommand, BoxLayout.X_AXIS));

        JLabel lblSerialized = new JLabel("Serialized \nMID:    ");
        lblSerialized.setMaximumSize(new Dimension(115, 45));
        lblSerialized.setMinimumSize(new Dimension(75, 45));
        lblSerialized.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlSerializedMidCommand.add(lblSerialized);
        JTextField serializedMidString = new JTextField();
        serializedMidString.setMaximumSize(new Dimension(575, 30));
        serializedMidString.setMinimumSize(new Dimension(250, 30));
        serializedMidString.setToolTipText("include serialized MID message.");
        serializedMidString.setLayout(new FlowLayout(FlowLayout.TRAILING));
        serializedMidString.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnlSerializedMidCommand.add(serializedMidString);

        JButton btnSendSerializedMid = new JButton("Send");
        btnSendSerializedMid.setMaximumSize(new Dimension(50, 35));
        btnSendSerializedMid.setMinimumSize(new Dimension(25, 35));
        btnSendSerializedMid.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pnlSerializedMidCommand.add(btnSendSerializedMid);

        pnlMidContainer.add(pnlSerializedMidCommand);
        pnlSubConatiner2.add(pnlMidContainer);
        pnlMainContainer.add(pnlSubConatiner2);

        //
        // dialog box text area
        JTextArea dialogBox = new JTextArea();
        dialogBox.setColumns(100);
        dialogBox.setRows(10);
        dialogBox.setLineWrap(true);
        //

        //
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
        frame.add(pnlMainContainer);
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
