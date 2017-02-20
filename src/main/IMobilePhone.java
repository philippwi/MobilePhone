package main;

public interface IMobilePhone {
    
    boolean connect(String network);

    byte[] encrypt(String message);

    String decrypt(byte[] message);

}
