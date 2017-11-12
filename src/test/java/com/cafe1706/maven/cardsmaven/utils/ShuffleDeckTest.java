package com.cafe1706.maven.cardsmaven.utils;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cafe1706.maven.cardsmaven.model.Card;
import com.cafe1706.maven.cardsmaven.model.CardDeck;

@RunWith(SpringRunner.class)
public class ShuffleDeckTest {
	
	@Test
	public void testShuffle() {
		CardDeck deck = new CardDeck("testDeck");
		ArrayList<Card> cards = (ArrayList<Card>) deck.getCards();
		
		Assert.assertEquals(52, cards.size());
		
		ArrayList<Card> shuffledDeck = ShuffleDeck.shuffle(cards, ShuffleType.SIMPLE);
		CardDeck verifyingDeck = new CardDeck("checkDeck");
		ArrayList<Card> verifyingCards = (ArrayList<Card>) verifyingDeck.getCards();
		
		Assert.assertNotNull(shuffledDeck);
		Assert.assertEquals(52, shuffledDeck.size());
		Assert.assertNotEquals(shuffledDeck, verifyingCards);
	}
	
	
	@Test
	public void testComplexShuffle() {
		CardDeck deck = new CardDeck("testDeck");
		ArrayList<Card> cards = (ArrayList<Card>) deck.getCards();
		
		Assert.assertEquals(52, cards.size());
		
		ArrayList<Card> shuffledDeck = ShuffleDeck.shuffle(cards, ShuffleType.COMPLEX);
		CardDeck verifyingDeck = new CardDeck("checkDeck");
		ArrayList<Card> verifyingCards = (ArrayList<Card>) verifyingDeck.getCards();
		
		Assert.assertNotNull(shuffledDeck);
		Assert.assertEquals(52, shuffledDeck.size());
		Assert.assertNotEquals(shuffledDeck, verifyingCards);
	}
}
