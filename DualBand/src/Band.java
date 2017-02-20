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

        public byte[] encrypt(String a) {
            return innerMethodEncrypt(a);
        }

        public String decrypt(byte[] a) {return innerMethodDecrypt(a);}

        public void listMethods() {
            System.out.println("--- public methods for " + getClass().getName());
            for (int i = 0; i < methods.length; i++)
                if (!methods[i].toString().contains("Object") && !methods[i].toString().contains("list"))
                    System.out.println(methods[i]);
            System.out.println("---");
        }
    }

    public String innerMethodGetVersion(){return "Dual Band";}

    public boolean innerMethodConnect(String network) {

        return true;

    }

    public byte[] innerMethodEncrypt(String message) {

        byte[] byteMsg = message.getBytes();

        return byteMsg;
    }

    public String innerMethodDecrypt(byte[] message) {

        String stringMsg = message.toString();

        return stringMsg;

    }
}