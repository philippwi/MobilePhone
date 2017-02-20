
public interface IMobilePhone {

    public boolean connect(String network);

    public byte[] encrypt(String message);

    public String decrypt(byte[] message);

}