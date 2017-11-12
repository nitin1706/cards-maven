# cards-maven

#Sample RESTful API with Jetty server


Cards Deck's RESTful API. 
The server used for this sample project is Jetty Server. (refer pom.xml for the configuration)

This project can be run simply by using command-prompt(cmd) in Windows or using Terminal on MacOS/linux.

Use the following commands to clone, build and run the cards-maven project:
1. Clone Repository: 'git clone https://github.com/nitin1706/cards-maven.git'
2. Go to root of Cloned code: 'cd cards-maven'
3. Build: 'mvn install'
4. Run API (port 8080):  'java -jar target/cards-maven-0.0.1-SNAPSHOT.jar'

Note: By default server starts at port 8080. To start the server on a different port, use this command:
'java -jar -Dserver.port=<PORT> target/cards-maven-0.0.1-SNAPSHOT.jar'

