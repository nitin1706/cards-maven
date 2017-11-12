package com.cafe1706.maven.cardsmaven.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cafe1706.maven.cardsmaven.model.Card;
import com.cafe1706.maven.cardsmaven.model.CardDeck;

public class CardsMockDB {
	private static Map<String, CardDeck> decks = new HashMap<>();
	
	public static List<Card> getDeck(String name) {
		if(decks == null) return null;
		CardDeck deckFound = decks.get(name);
		return deckFound != null ? deckFound.getCards() : null;
	}
	
	public static List<String> getAllDeckNames() {
		if(decks == null) return null;
		
		List<String> deckNames = new ArrayList<>();
		for(CardDeck deck : decks.values()) {
			deckNames.add(deck.getDeckName());
		}
		return deckNames;
	}
	
	public static List<CardDeck> getAllDecks() {
		if(decks == null) return null;
		
		List<CardDeck> cardDecks = new ArrayList<>();
		for(String deckNames : decks.keySet()) {
			cardDecks.add(decks.get(deckNames));
		}
		return cardDecks;
	}
	
	public static CardDeck removeDeck(String deckName) {
		return decks.remove(deckName);
	}
	
	public static CardDeck addDeck(String deckName, CardDeck deck) {
		return decks.put(deckName, deck);
	}
	
	public static CardDeck updateDeck(String deckName, CardDeck deck) {
		return decks.put(deckName, deck);
	}
	
	public static CardDeck updateCardsInDeck(String deckName, ArrayList<Card> cards) {
		if(decks == null) return null;
		CardDeck deckFound = decks.get(deckName);
		deckFound.setCards(cards);
		return decks.put(deckName, deckFound);
	}

}
