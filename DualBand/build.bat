"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\IMobilePhone.java
"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\DualBand.java

cd build
"%JAVA%\bin\jar" -cvf DualBand.jar IMobilePhone.class
"%JAVA%\bin\jar" -uvf DualBand.jar DualBand.class
"%JAVA%\bin\jar" -uvf DualBand.jar DualBand$Port.class

move DualBand.jar ..\DualBand.jar

pause