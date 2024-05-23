import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class hostClient {
    Socket clientSocket;
    DataOutputStream dataOut;
    BufferedReader readerIn;
    BufferedWriter buffWriter;
    //
    InputStreamReader inputStrRdr;
    ScheduledExecutorService scheduler;

    //
    void startConnection(String ip, int port, JTextArea dbox, int delay, int timePeriod) {
        try {
            clientSocket = new Socket(ip, port);
            clientSocket.setKeepAlive(true);
            dataOut = new DataOutputStream(clientSocket.getOutputStream());
            inputStrRdr = new InputStreamReader(clientSocket.getInputStream());

            // midCommands.MID9999 keep alive msg
            scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(() -> {
                // if controller replies to midCommands.MID9999, use sendMessage.
                String autoReplyMessage = sendMessage("00209999001000000000" + "\0");
                //
                hostExe.appendDialog(dbox, "keep alive: " + "00209999001000000000" + "\0");
                hostLogger.hostLog("startConnection", "host keep alive ", "info");

                // if controller does not reply to midCommands.MID9999, use sendNoReplyMessage.
//                sendNoReplyMessage("00209999001000000000" + "\0");
                System.out.println("MID9999 : " + "00209999001000000000");
            }, delay, timePeriod, TimeUnit.SECONDS);

        } catch (IOException e) {
            System.out.println("Something went wrong in startConnection Or keepAlive\n" + e.getMessage());
            e.printStackTrace();
            //        }
        }
    }

    String sendMessage(String msg) {
        try {
            dataOut.write(msgBytes(msg));
            dataOut.flush();
            String inputStreamReaderReturn = readFully(inputStrRdr);
            System.out.println("the InputStreamReader Method: " + inputStreamReaderReturn);
            return inputStreamReaderReturn;
        } catch (IOException e) {
            System.out.println("IO Exception in sendMessage\n" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    //
    void sendNoReplyMessage(String msg) {
        try {
            dataOut.write(msgBytes(msg));
            dataOut.flush();
            //
        } catch (IOException e) {
            System.out.println("IO Exception in sendNoReplyMessage\n" + e.getMessage());
            e.printStackTrace();
        }
    }
    //
    String readFully(InputStreamReader in) throws IOException {

        // String returnString = null;
        String returnString;
        int n = 0;
        int maxStr = 9999;
        int[] bS = new int[maxStr];
        //boolean cont = true;
        // while (cont && n < maxStr) {
        while (n < maxStr) {
            int b = in.read();
            if (b == 0) {
                // cont = false;
                break;
            } else if (b != -1) {
                bS[n] = b;
            } else {
                // cont = false;
                break;
            }
            n += 1;
        }
        returnString = new String(bS, 0, n);
        System.out.println("returnString\n" + returnString);
        return returnString;
    }
    //
    byte[] msgBytes(String serializedMsg) {
//        byte[] bytes = serializedMsg.getBytes(StandardCharsets.US_ASCII);
//        return bytes;
        return serializedMsg.getBytes(StandardCharsets.US_ASCII);
    }
    //
    void stopConnection() {
        try {
            scheduler.shutdownNow();
            buffWriter.close();
            readerIn.close();
            clientSocket.close();

        } catch (IOException e) {
            System.out.println("Something went wrong in Stop Connection\n" + e.getMessage());
            e.printStackTrace();
            //        }
        }
    }
}
