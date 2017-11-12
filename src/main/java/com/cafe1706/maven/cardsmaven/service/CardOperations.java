package com.cafe1706.maven.cardsmaven.service;

import java.util.List;
import java.util.Set;

import com.cafe1706.maven.cardsmaven.config.CardsInitializer;
import com.cafe1706.maven.cardsmaven.model.Card;
import com.cafe1706.maven.cardsmaven.model.CardDeck;
import com.cafe1706.maven.cardsmaven.model.CardRank;
import com.cafe1706.maven.cardsmaven.model.CardSuite;

public interface CardOperations {
	
	default Set<Card> getAllCards() {
		return CardsInitializer.getCards();
	}
	
	default List<CardRank> getCardRanks() {
		return CardsInitializer.getCardRanks();
	}
	
	default List<CardSuite> getCardSuites() {
		return CardsInitializer.getCarsSuites();
	}
	
	List<Card> createDeck(String deckName);
	
	List<String> getAllDeckNames();
	List<CardDeck> getAllDecks();
	List<Card> getDeck(String name);
	
	List<Card> updateDeck(CardDeck deck);
	List<Card> updateDeckName(String oldName, String newName);
	
	String removeDeck(String deckName);
	
	List<Card> shuffleDeck(String deckName);
	List<Card> shuffleDeckWithLevel(String deckName, String shuffleType);
}
