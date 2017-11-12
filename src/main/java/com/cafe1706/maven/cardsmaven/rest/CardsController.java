package com.cafe1706.maven.cardsmaven.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe1706.maven.cardsmaven.model.Card;
import com.cafe1706.maven.cardsmaven.model.CardDeck;
import com.cafe1706.maven.cardsmaven.model.CardRank;
import com.cafe1706.maven.cardsmaven.model.CardSuite;
import com.cafe1706.maven.cardsmaven.service.CardOperations;

@RestController
@RequestMapping(value="/cards")
public class CardsController {
	
	@Autowired
	CardOperations cardOperations;
	
	@RequestMapping(value="/", method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getCards() {
		return ResponseEntity.status(HttpStatus.OK).body(cardOperations.getAllCards().toString());
	}
	
	@RequestMapping(value="/count", method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> getCardsCount() {
		return ResponseEntity.status(HttpStatus.OK).body(cardOperations.getAllCards().size());
	}
	
	@RequestMapping(value="/suits", method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CardSuite>> getCardsSuites() {
		return ResponseEntity.status(HttpStatus.OK).body(cardOperations.getCardSuites());
	}
	
	@RequestMapping(value="/ranks", method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CardRank>> getCardsRanks() {
		return ResponseEntity.status(HttpStatus.OK).body(cardOperations.getCardRanks());
	}
	
	@RequestMapping(value="/decks/{deckName}", method = PUT, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Card>> createDeck(@PathVariable("deckName") String deckName) {
		return ResponseEntity.status(HttpStatus.OK).body(cardOperations.createDeck(deckName));
	}
	
	@RequestMapping(value="/decks/{deckName}", method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Card>> getDeck(@PathVariable("deckName") String deckName) {
		List<Card> cardsInDeck = cardOperations.getDeck(deckName);
		if(cardsInDeck == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(cardsInDeck);
	}
	
	@RequestMapping(value="/decks/", method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CardDeck>> getDecks() {
		return ResponseEntity.status(HttpStatus.OK).body(cardOperations.getAllDecks());
	}
	
	@RequestMapping(value="/decks/shuffle/{deckName}", method = POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Card>> shuffleDeck(@PathVariable("deckName") String deckNName) {
		List<Card> deckShuffled = cardOperations.shuffleDeck(deckNName);
		if(deckShuffled == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(deckShuffled);
	}
	
	@RequestMapping(value="/decks/{deckName}", method = DELETE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeDeck(@PathVariable("deckName") String deckName) {
		String deckRemoved = cardOperations.removeDeck(deckName);
		if(deckRemoved == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find the deck named " + deckName);
		}
		return ResponseEntity.status(HttpStatus.OK).body(deckRemoved);
	}

}
