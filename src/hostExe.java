import javax.swing.*;
//import java.awt.*;
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
//        hostPyLogger hLogger = new hostPyLogger();
//        hostLogger hlogger = new hostLogger();
        openProtocolClientParserMIDClass oPCP = new openProtocolClientParserMIDClass();
        openProtocolClientSerializerMIDClass oPCS = new openProtocolClientSerializerMIDClass();

        // Host Frame
        JFrame frame = new JFrame("Host");
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
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
        // ip and port text areas
        JTextArea ipString = new JTextArea();
        JTextArea portString = new JTextArea();
        ipString.setColumns(75);
        ipString.setRows(5);
        portString.setColumns(25);
        portString.setRows(5);
        //
        // MID Command text areas
        JTextArea midString = new JTextArea();
        JTextArea midInputString = new JTextArea();
        midString.setColumns(50);
        midString.setRows(5);
        midInputString.setColumns(50);
        midInputString.setRows(5);

        JTextArea serializedMidString = new JTextArea();
        serializedMidString.setColumns(100);
        serializedMidString.setRows(5);
        //
        // dialog box text area
        JTextArea dialogBox = new JTextArea();
        dialogBox.setColumns(100);
        dialogBox.setRows(50);
        dialogBox.setLineWrap(true);
        //
        // JPanels containers
        // main container
        JPanel pnlMainContainer = new JPanel();
        pnlMainContainer.setLayout(new BoxLayout(pnlMainContainer, BoxLayout.Y_AXIS));

        // Ip address and Port section
        // connection container
        JPanel pnlManualConnect = new JPanel();
        pnlManualConnect.setLayout(new BoxLayout(pnlManualConnect, BoxLayout.X_AXIS));
        // pnlManualConnect.setBorder(BorderFactory.createEtchedBorder());
        pnlManualConnect.add("ip", ipString);
        pnlManualConnect.add("port", portString);

        // button
        JButton btnConnect = new JButton("Connect");
        pnlManualConnect.add(btnConnect);
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                //
                try {

                    String inputIdAddress = ipString.getText();
                    int inputPortId = Integer.parseInt(portString.getText());

                    hClient.startConnection(inputIdAddress, inputPortId);
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

                    String serverResponse = hClient.sendMessage(startMid);
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
            }
        });

        pnlMainContainer.add(pnlManualConnect);
        //
        // MID section
        // main mid container
        JPanel pnlMidContainer = new JPanel();
        pnlMidContainer.setLayout(new BoxLayout(pnlMidContainer, BoxLayout.Y_AXIS));
        // mid container
        JPanel pnlMidCommand = new JPanel();
        // MID Command and input vals section
        pnlMidCommand.setLayout(new BoxLayout(pnlMidCommand, BoxLayout.X_AXIS));
        pnlMidCommand.add("MID", midString);
        pnlMidCommand.add("values", midInputString);

        JButton btnSendMid = new JButton("Send");
        pnlMidCommand.add(btnSendMid);
        btnSendMid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent b) {
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
            }
        });
        pnlMidContainer.add(pnlMidCommand);
        //
        // serialized mid container
        JPanel pnlSerializedMidCommand = new JPanel();
        // manually Serialized MID command
        pnlSerializedMidCommand.setLayout(new BoxLayout(pnlSerializedMidCommand, BoxLayout.X_AXIS));
        pnlSerializedMidCommand.add("serializedMid", serializedMidString);

        JButton btnSendSerializedMid = new JButton("Send");
        pnlSerializedMidCommand.add(btnSendSerializedMid);
        btnSendSerializedMid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent c) {
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
            }
        });
        pnlSerializedMidCommand.add(btnSendSerializedMid);
        pnlMidContainer.add(pnlSerializedMidCommand);

        pnlMainContainer.add(pnlMidContainer);
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
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    hostLogger.hostLog("exit", "exit button", "info");
                    hClient.stopConnection();
                } catch (Throwable b) {
//                    System.out.println("Exit Window, can't stop connection\n" + b.getMessage());
                    hostLogger.hostLog("exit", "Exit Window, can't stop connection\n" + b.getMessage(), "error");
//                    b.printStackTrace();
                }
                System.exit(0);
            }
        });
        pnlMainContainer.add(pnlEnd);
        //
        // complete main container
        frame.add(pnlMainContainer);
        frame.pack();

        frame.setVisible(true);
    }
    //
    static void appendDialog(JTextArea tArea, String dialog){
        tArea.append(dialog);
        tArea.append("\n");
    }
    public static void main(String[] args) {
        // 1.a. create dialog
        createDialog();
    }
}
