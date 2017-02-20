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
            Class clazz = Class.forName("Calculator",true,urlClassLoader);
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

    public int execute(int a,int b,String operation) {
        int result = Integer.MAX_VALUE;

        try {
            Method method = port.getClass().getMethod(operation,int.class,int.class);
            result = (Integer)method.invoke(port,a,b);
        } catch (Exception e) {
            System.out.println("operation " + operation + " not supported.");
        }

        return result;
    }

    public boolean isPrime(String string) {
        boolean result = false;

        try {
            Method method = port.getClass().getMethod("isPrime",String.class);
            result = (Boolean)method.invoke(port,string);
        } catch (Exception e) {
            System.out.println("operation isPrime not supported.");
        }

        return result;
    }

    public static void main(String... args) {
        Application application = new Application();
        application.createPhonePortInstance();
        System.out.println("5 + 3     : " + application.execute(5,3,"add"));
        System.out.println("5 - 3     : " + application.execute(5,3,"subtract"));
        System.out.println("5 * 3     : " + application.execute(5,3,"multiply"));
        System.out.println("3 (prime) : " + application.isPrime("3"));
    }
}