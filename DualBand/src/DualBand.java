public class DualBand implements IMobilePhone {

    public boolean connect(String network) {

        return true;

    }

    public byte[] encrypt(String message) {

        byte[] byteMsg = message.getBytes();

        for (int i = 0; i < byteMsg.length; i++) {
            byte swap1;
            byte swap2;

            swap1 = byteMsg[i];
            swap2 = byteMsg[byteMsg.length - 1 - i];

            byteMsg[i] = swap2;
            byteMsg[byteMsg.length - 1 - i] = swap1;
        }
        return byteMsg;
    }

    public String decrypt(byte[] message) {

        String[] stringMsg = message.toString().split("");

        for (int i = 0; i < stringMsg.length; i++) {
            String swap1;
            String swap2;

            swap1 = stringMsg[i];
            swap2 = stringMsg[stringMsg.length - 1 - i];

            stringMsg[i] = swap2;
            stringMsg[stringMsg.length - 1 - i] = swap1;
        }
        return stringMsg.toString();

    }
}