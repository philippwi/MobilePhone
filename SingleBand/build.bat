"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\IMobilePhone.java
"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\SingleBand.java

cd build
"%JAVA%\bin\jar" -cvf SingleBand.jar IMobilePhone.class
"%JAVA%\bin\jar" -uvf SingleBand.jar SingleBand.class
"%JAVA%\bin\jar" -uvf SingleBand.jar SingleBand$Port.class

move SingleBand.jar ..\SingleBand.jar

pause