# BudgetHelper

## Application installation
Project sources are locate into BudgetHelper directory. This application based on Java 1.8 version.

Applications have to be installed:
* _Maven_ http://maven.apache.org/download.cgi
* _Tomcat_ https://tomcat.apache.org/download-90.cgi (Binary Distributions)
* _Git_ https://git-scm.com/downloads
* _SonarQube_ https://www.sonarqube.org/downloads/
* _NodeJS (stable version - LTS)_ https://nodejs.org/en/download/
* _PostgreSQL_ https://www.postgresql.org/download/

Intellij IDEA plugins have to be installed:
* _Lombok plugin_- required
* _SonarLint_ - optional

## Required Windows environment variables
* _CATALINA_HOME_ - base Tomcat dir, not /bin directory
* _JAVA_HOME_ - base Java dir
* _M2_HOME_ - base Maven dir

All this variables /bin directories have to be added into PATH variable.

## Run project
1. Create _**budgethelper**_ database in PostgreSQL
2. Check in _**src/main/.../resources/hibernate.properties**_ local database configurations
3. When the NodeJS will be installed execute next command in console: _**npm i -g @angular/cli**_
4. Open _**src/main/angular**_ directory and install _node_modules_ executing command: _**npm i**_
5. For Intellij IDEA:
    * open Run -> Edit Configurations...
    * press `+` and select Tomcat Server -> local
    * `Server` tab -> _**http://localhost:8080/budgethelper/**_ url
    * Build `budgethelper:war exploaded` artifact
    * `Deployment` tab -> Application context -> _**/budgethelper**_
    * NOTE: two similar Tomcat configurations should be created:
        1. In the bottom of `Server` tab in `Build` window there is only one row with `budgethelper:war exploaded` artifact
        2. Like above but the first line have to be added -> press `+` -> `Run Maven Goal` -> enter `generate-sources`. 
        Run this configuration only if Angular project was updated or `angular` package is absent into `webapp` directory.

### How to work with SonarQube
1. Run SonarQube server executing StartSonar.bat file from sonarqube/bin/{OS_version}/StartSonar.bat
2. Execute command - **mvn clean install -Psonarqb**
3. Optionally, when ServerQube server is running SonarLint plugin available
    * SonarLint configuration on Intellij IDEA
        * File -> Settings -> Other Settings -> SonarLint General Settings -> Add SonarQube server (+) 
        -> Select SonarQube server -> Enter server domain and port (http://localhost:9000 - by default)
        * Check in File -> Settings -> Other Settings -> SonarLint Project Settings is SonarQube server was bind
        
