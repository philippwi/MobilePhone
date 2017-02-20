import java.lang.reflect.Method;

public class Band {

    private static Band instance = new Band();
    public Port port;

    private Band() {
        port = new Port();
    }

    public static Band getInstance() {
        return instance;
    }

    public class Port implements IMobilePhone {
        private Method[] methods = getClass().getMethods();

        public String getVersion() {return innerMethodGetVersion();}

        public boolean connect(String a) {
            return innerMethodConnect(a);
        }

        public String encrypt(String a) {
            return innerMethodEncrypt(a);
        }

        public String decrypt(String a) {return innerMethodDecrypt(a);}

        public void listMethods() {
            System.out.println("--- public methods for " + getClass().getName());
            for (int i = 0; i < methods.length; i++)
                if (!methods[i].toString().contains("Object") && !methods[i].toString().contains("list"))
                    System.out.println(methods[i]);
            System.out.println("---");
        }
    }

    public String innerMethodGetVersion(){return "Single Band";}

    public boolean innerMethodConnect(String network) {

        return true;

    }

    public String innerMethodEncrypt(String message) {

        //string als rückgabetyp, da String.getBytes() nur die Adresse zurückliefert
        byte[] byteArray= message.getBytes();
        String byteMsg = "";

        for(byte b:byteArray) byteMsg+=Byte.toString(b)+" ";

        return byteMsg;
    }

    public String innerMethodDecrypt(String message) {

        String stringMsg ="";

        String[] splitStr = message.split("\\s+");

        for(int i=0; i<splitStr.length; i++) {
            stringMsg+=Character.toString((char)Integer.parseInt(splitStr[i]));
        }

        return stringMsg;

    }
}