# cards-maven

#Sample RESTful API with Jetty server


Cards Deck's RESTful API. 
The server used for this sample project is Jetty Server. (refer pom.xml for the configuration)

Use the following commands to clone, build and run the cards-maven project:
1. git clone https://github.com/nitin1706/cards-maven.git
2. cd cards-maven
3. mvn clean install
4. java -jar target/cards-maven-0.0.1-SNAPSHOT.jar

Note: By default server starts at port 8080. To start the server on a different port, use this command:
java -jar -Dserver.port=<PORT> target/cards-maven-0.0.1-SNAPSHOT.jar

