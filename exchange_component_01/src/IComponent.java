public interface IComponent {

    boolean connect(String network);

    byte[] encrypt(String message);

    String decrypt(byte[] message);

}