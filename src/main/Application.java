package main;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Application {
    private Object port;

    @SuppressWarnings({"rawtypes","unchecked"})
    public void createPhonePortInstance() {
        Object instance = null;

        try {
            System.out.println("pathToJar : " + Configuration.instance.pathToJar);
            URL[] urls = {new File(Configuration.instance.pathToJar).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls,Application.class.getClassLoader());
            Class clazz = Class.forName("Band",true,urlClassLoader);
            System.out.println("clazz     : " + clazz.toString());

            instance = clazz.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            port = clazz.getDeclaredField("port").get(instance);
            System.out.println("port      : " + port.hashCode());

            Method getVersion = port.getClass().getMethod("getVersion");
            String version = (String)getVersion.invoke(port);
            System.out.println("version   : " + version);
        } catch (Exception e) {
            System.out.println("--- exception");
            System.out.println(e.getMessage());
        }
    }

    public boolean connect(String a, String operation) {
        boolean result=false;

        try {
            Method method = port.getClass().getMethod(operation,String.class);
            result = (boolean)method.invoke(port,a);
        } catch (Exception e) {
            System.out.println("operation " + operation + " not supported.");
        }

        return result;
    }
    public String encrypt(String a, String operation) {
        String result=null;

        try {
            Method method = port.getClass().getMethod(operation,String.class);
            result = (String)method.invoke(port,a);
        } catch (Exception e) {
            System.out.println("operation " + operation + " not supported.");
        }

        return result;
    }

    public String decrypt(String a, String operation) {
        String result=null;

        try {
            Method method = port.getClass().getMethod(operation,String.class);
            result = (String)method.invoke(port,a);
        } catch (Exception e) {
            System.out.println("operation " + operation + " not supported.");
        }

        return result;
    }


    public static void main(String... args) {
        Application application = new Application();
        application.createPhonePortInstance();

        System.out.println("Connected : " + application.connect("Vodafone", "connect"));

        System.out.println("Encrypt   : " + application.encrypt("Guten Tag", "encrypt"));

        System.out.println("Decrypt   : " + application.decrypt("71 117 116 101 110 32 84 97 103", "decrypt"));

    }
}