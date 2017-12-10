# BudgetHelper

## Application installation
Project sources are locate into BudgetHelper directory. This application based on Java 1.8 version.

Check in __src/main/**/resources/hibernate.properties__ and __src/test/**/resources/hibernate.properties__ local database configurations.

Applications have to be installed:
* _Maven_ http://maven.apache.org/download.cgi
* _Git_ https://git-scm.com/downloads
* _SonarQube_ https://www.sonarqube.org/downloads/

Intellij IDEA plugins have to be installed:
* _Lombok plugin_- required
* _SonarLint_ - optional

## Required Windows environment variables
* _CATALINA_HOME_ - base Tomcat dir, not /bin. It uses in pom.xml

### How to work with SonarQube
1. Run SonarQube server executing StartSonar.bat file from sonarqube/bin/{OS_version}/StartSonar.bat
2. Execute command - **mvn clean install -Psonarqb**
3. Optionally, when ServerQube server is running SonarLint plugin available.
    * SonarLint configuration on Intellij IDEA
        * File -> Settings -> Other Settings -> SonarLint General Settings -> Add SonarQube server (+) 
        -> Select SonarQube server -> Enter server domain and port (http://localhost:9000 - by default)
        * Check in File -> Settings -> Other Settings -> SonarLint Project Settings is SonarQube server was bind
        
