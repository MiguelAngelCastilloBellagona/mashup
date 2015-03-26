                   ********** Mashup v3.0.0 **********

           Alberto Pan <apan@udc.es>, Jose Losada <jlosada@udc.es>
          Department of Information and Communications Technologies
                          University Of A Coruña
         https://campusvirtual.udc.es/moodle/course/view.php?id=45133

Contents
--------

1. Software requirements
2. Environment variables
3. Building from the source code
4. Execution from Jetty
5. Execution from Tomcat

1. Software requirements
   ---------------------

   * Operating system. It should be possible to compile and execute this
     distribution in Unix-like and MS-Windows operating systems.
     
     Most of the instructions given in this file assume a Unix-like operating
     system, but they are similar for MS-Windows operating systems with
     minor modifications (e.g. "\" instead of "/", %ENVIRONMENT_VARIABLE%
     instead of $ENVIRONMENT_VARIABLE, ".bat" instead of ".sh", etc.).
     
   * An implementation of JDK 1.6.0 or higher.
   
   * Maven 2.2.0 or higher.
   
   * Apache Tomcat 6.0.20 (or any other Java EE Web Application server).
   
   * WS-JavaExamples 2.0.1's Util library. This library will be in the Maven
     local repository if WS-JavaExamples was built with "mvn install".
   
2. Environment variables
   ---------------------
   
   This is an example of a "~/.bashrc" file. Adapt to your environment.
   
# -----------------------------------------------------------------------------
# Programming Tools.
# -----------------------------------------------------------------------------

# J2SE
# NOTE: This step is not necessary for Mac OS X 10.5.X (Java 1.5 is already in
# the PATH).
JAVA_HOME=/opt/jdk1.6.0_18
export JAVA_HOME
# For convenience.
PATH=$JAVA_HOME/bin:$PATH

# Maven
# NOTE: This step is not necessary for Mac OS X 10.5.X (Maven 2.0.6 is already
# in the PATH)
MAVEN_HOME=/opt/apache-maven-2.2.1
export MAVEN_HOME
PATH=$MAVEN_HOME/bin:$PATH

# -----------------------------------------------------------------------------
# Mashup.
# -----------------------------------------------------------------------------
  
In MS-Windows similar environment variables must be defined by using the
control panel (System). For example:
  
JAVA_HOME=C:\java\jdk1.6.0_18

MAVEN_HOME=C:\java\apache-maven-2.2.1

PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%

3. Building from the source code
   -----------------------------
   
   + Unpack mashup-src-<version>.tar.gz

   + Before compiling, you may need/want to adapt the following files:

   * "ui/src/main/resources/ConfigurationParameters.properties". The class 
     implementing the VirtualCRMService interface is specified in 
     "VirtualCRMServiceFactory/className" property. This distribution includes a 
     mock implementation to test three typical cases (returning results, 
     throwing a runtime exception, and returning an empty list of results)
     in cyclic order.

   + mvn install

4. Execution from Jetty
   --------------------

   + cd ui

   + mvn jetty:run

   + Access: http://localhost:8080/mashup-ui/es.udc.mashup.ui.Application/Application.html

5. Execution from Tomcat
   ---------------------

   + cd ui
   
   + cp target/mashup.war TOMCAT_HOME/webapps

   + TOMCAT_HOME/bin/startup.sh

   + Access: http://localhost:8080/mashup


