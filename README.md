# cards-maven  - Sample RESTful API with Jetty server
cards-maven is a RESTful API with capabilities of creating card deck, getting all the decks, shuffling card deck and deleting a deck.


Cards Deck's RESTful API. 
The server used for this sample project is Jetty Server. (refer pom.xml for the configuration)

This project can be run simply by using command-prompt(cmd) in Windows or using Terminal on MacOS/linux.

Use the following commands to clone, build and run the cards-maven project:
1. Clone Repository: `git clone https://github.com/nitin1706/cards-maven.git`
2. Go to root of Cloned code: `cd cards-maven`
3. Build: `mvn install`
4. Run API (port 8080):  `java -jar target/cards-maven-0.0.1-SNAPSHOT.jar`

Note: By default server starts at port 8080. To start the server on a different port, use this command:
`java -jar -Dserver.port=<PORT> target/cards-maven-0.0.1-SNAPSHOT.jar`



Alternatively, this code can be run by importing the code in an IDE of choice (IntelliJ or Eclipse or STS), and running class `CardsMavenApplication.java` as java application.


# Following are the capabilities provided by API

Cards related capabilities:
1. GET /cards/
2. GET /cards/count 
3. GET /cards/suits
4. GET /cards/ranks

Deck of Cards related Capabilities:
1. PUT /cards/decks/{deckName}
2. GET /cards/decks/{deckName}
3. GET /cards/decks/
4. POST /cards/decks/shuffle/{deckName}
5. POST /cards/decks/shuffle/{deckName}/{shuffleType}
6. DELETE /cards/decks/{deckName}


All the capabilities with uri `/cards/` are related to cards. We can GET all the cards in deck, its number, Ranks and suits. These are general method to understand the naming used for cards of different suits and ranks.

Capabilities that include `/decks/` in the uri are pertaining to Card decks. We can GET all decks present, create a new deck using PUT `/decks/{deckName}` with default order (by default arranged by increasing ranks), or shuffle a deck or even delete a deck. 

Shuffling of cards in a deck (#4 and #5 in Deck Capabilities) is done using the simple shuffle by default, however, if shuffle type can be specified in Opertaion #5 options for which are : `double` and `complex`. Shuffling card deck with `double` option will just re-shuffle the shuffled deck, and if mentioned `complex`, it will split the deck in half and then shuffle the halves before merging back.


Response for all these operations can be expected as text/html and/or json. Response status codes for these operations are:
1. 200 - OK
2. 404 - Not found
3. 405 - Method not allowed
4. 500 - Error

One can use various tools to test this API, however, I used POSTMAN to test these capabilities.
