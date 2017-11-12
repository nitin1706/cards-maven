package com.cafe1706.maven.cardsmaven.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cafe1706.maven.cardsmaven.model.Card;
import com.cafe1706.maven.cardsmaven.model.CardRank;
import com.cafe1706.maven.cardsmaven.model.CardSuite;

public class CardsInitializer {
	
	private static Set<Card> cards = new HashSet<>();
	
	static {
		for(CardSuite suite : CardSuite.values()) {
			for(CardRank rank : CardRank.values()) {
				cards.add(new Card(suite, rank));
			}
		}
	}
	
	public static Set<Card> getCards() {
		return cards;
	}
	
	public static List<CardSuite> getCarsSuites() {
		return Arrays.asList(CardSuite.values());
	}
	
	public static List<CardRank> getCardRanks() {
		return Arrays.asList(CardRank.values());
	}

}
