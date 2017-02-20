package test;

import main.Application;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestApplication {
    @Test
    public void testConnect() {
        Application app = new Application();
        app.createPhonePortInstance();
        boolean res = app.connect("hallo", "connect");
        assertEquals(true, res);
    }
    @Test
    public void testEncrypt() {
        Application app = new Application();
        app.createPhonePortInstance();
        String res = app.encrypt("hallo", "encrypt");
        assertEquals("104 97 108 108 111 ", res);   //leerzeichen nach letzter zahl!
    }
    @Test
    public void testDecrypt() {
        Application app = new Application();
        app.createPhonePortInstance();
        String res = app.decrypt("104 97 108 108 111", "decrypt");
        assertEquals("hallo", res);
    }
}