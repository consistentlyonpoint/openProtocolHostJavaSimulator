import java.util.HashMap;
import java.util.List;


public class MID0018 {
    //
    String replyMID(String answer) {
        if (answer.equalsIgnoreCase("acknowledge")) {
            return "MID0005";
        } else if (answer.equalsIgnoreCase("accept")) {
            return "MID0005";
        } else if (answer.equalsIgnoreCase("error")) {
            return "MID0004";
        } else {
            return "MID0004";
        }
    }
    //
    // MID 0018 Select Parameter set
    String integratorString(String midCommandValue, List<Object> dataFieldValue) {
        //
        String midLengthString = "0023";
        String midRevision = "001";
        String midAckFlag = "0";
        String midStationID = "00";
        String midSpindleID = "00";
        String midSpare = "0000";
        //
        StringBuilder midAscii = new StringBuilder();
        int midLength = Integer.parseInt(midLengthString);
        // Length
        midAscii.append(midLengthString);
        // MID
        midAscii.append(midCommandValue);
        // Revision
        midAscii.append(midRevision);
        // No Ack flag
        midAscii.append(midAckFlag);
        // StationID flag
        midAscii.append(midStationID);
        // SpindleID flag
        midAscii.append(midSpindleID);
        // Spare
        midAscii.append(midSpare);
        //
        // Data Field
        if (!dataFieldValue.isEmpty()) {
            opUtilityMethods opM = new opUtilityMethods();
            for (Object s : dataFieldValue) {
                if (opM.isNumeric(s)) {
                    //if (s instanceof Integer) {
                    //
                    // midAscii.append(String.format("%03d", s));
                    midAscii.append(String.format("%03d", Integer.parseInt(s.toString())));
                } else {
                    midAscii.append(s);
                }
            }
        }
        // padding
        if (midAscii.length() >= midLength) {
            return (midAscii + "\0");
        }
        else {
            return (new opUtilityMethods(midAscii.toString(), midLength, "right").padZeroes() + "\0");
        }
    }
    //
    HashMap<String, HashMap<String, Object>> controllerString(String controllerMsg, String midCommand, String midLengthString, String midRevision) {
        //
        HashMap<String, HashMap<String, Object>> midControllerHash = new HashMap<String, HashMap<String, Object>>();
        HashMap<String, Object> controllerHash = new HashMap<String, Object>();
        // Datafield-1
        int[] controllerParameterSetIdIdxByteRange = {20, 23};
        //
        controllerHash.put("PARAMETER_SET_ID", controllerMsg.substring(controllerParameterSetIdIdxByteRange[0], controllerParameterSetIdIdxByteRange[1]));
        //
        midControllerHash.put(midCommand, controllerHash);
        return midControllerHash;
    }
}
