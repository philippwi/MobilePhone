"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\IMobilePhone.java
"%JAVA%\bin\javac" -Xlint:all -g:none -classpath build -d build src\Band.java

cd build
"%JAVA%\bin\jar" -cvf Band.jar IMobilePhone.class
"%JAVA%\bin\jar" -uvf Band.jar Band.class
"%JAVA%\bin\jar" -uvf Band.jar Band$Port.class

move Band.jar ..\Band.jar

pause