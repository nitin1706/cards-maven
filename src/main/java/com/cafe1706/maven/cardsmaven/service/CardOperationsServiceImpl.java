package com.cafe1706.maven.cardsmaven.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cafe1706.maven.cardsmaven.config.CardsMockDB;
import com.cafe1706.maven.cardsmaven.model.Card;
import com.cafe1706.maven.cardsmaven.model.CardDeck;
import com.cafe1706.maven.cardsmaven.utils.ShuffleDeck;
import com.cafe1706.maven.cardsmaven.utils.ShuffleType;

@Service(value = "cardOperations")
public class CardOperationsServiceImpl implements CardOperations {
	
	@Override
	public List<Card> createDeck(String deckName) {
		CardDeck deck = new CardDeck(deckName);
		CardsMockDB.addDeck(deckName, deck);
		return deck.getCards();
	}
	
	@Override
	public List<String> getAllDeckNames() {
		return CardsMockDB.getAllDeckNames();
	}
	
	@Override
	public List<CardDeck> getAllDecks() {
		return CardsMockDB.getAllDecks();
	}

	@Override
	public List<Card> getDeck(String name) {
		if(name==null || name.equals(""))
			return null;
		return CardsMockDB.getDeck(name);
	}

	@Override
	public List<Card> updateDeck(CardDeck deck) {
		CardDeck deckupdated = CardsMockDB.updateCardsInDeck(deck.getDeckName(), (ArrayList<Card>) deck.getCards());
		return deckupdated != null ? deckupdated.getCards() : null;
	}
	
	@Override
	public List<Card> updateDeckName(String oldName, String newName) {
		ArrayList<Card> deckFound = (ArrayList<Card>) CardsMockDB.getDeck(oldName);
		if(deckFound == null) {
			return null;
		}
		
		CardsMockDB.addDeck(newName, CardsMockDB.removeDeck(oldName));
		return CardsMockDB.getDeck(newName);
	}

	@Override
	public String removeDeck(String deckName) {
		CardDeck deckRemoved = this.deleteDeck(deckName);
		return deckRemoved != null ? deckRemoved.getDeckName() : null;
	}
	
	private CardDeck deleteDeck(String deckName) {
		return CardsMockDB.removeDeck(deckName);
	}

	@Override
	public List<Card> shuffleDeck(String deckName) {
		return shuffleDeckWithLevel(deckName, ShuffleType.SIMPLE);
	}
	
	@Override
	public List<Card> shuffleDeckWithLevel(String deckName, String shuffleType) {
		if(shuffleType.equalsIgnoreCase("DOUBLE")) {
			return shuffleDeckWithLevel(deckName, ShuffleType.DOUBLE); 
		}
		else if(shuffleType.equalsIgnoreCase("COMPLEX")) {
			return shuffleDeckWithLevel(deckName, ShuffleType.COMPLEX);
		}
		return shuffleDeckWithLevel(deckName, ShuffleType.SIMPLE);
	}
	
	private List<Card> shuffleDeckWithLevel(String deckName, ShuffleType shuffleType) {
		ArrayList<Card> deckFound = (ArrayList<Card>) CardsMockDB.getDeck(deckName);
		if(deckFound == null) {
			return null;
		}
		
		ArrayList<Card> shuffledDeck = ShuffleDeck.shuffle(deckFound, shuffleType);
		
		CardsMockDB.updateCardsInDeck(deckName, shuffledDeck);
        return shuffledDeck;
	}
}
