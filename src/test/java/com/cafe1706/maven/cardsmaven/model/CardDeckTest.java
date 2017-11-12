package com.cafe1706.maven.cardsmaven.model;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cafe1706.maven.cardsmaven.utils.SortingOrder;

@RunWith(SpringRunner.class)
public class CardDeckTest {
	
	@Test
	public void createCardDeck() {
		CardDeck deck = new CardDeck("testDeck");
		assertNotNull(deck);
		assertNotNull(deck.getCards());
		assertEquals(52, deck.getCards().size());
		assertEquals("testDeck", deck.getDeckName());
	}
	
	@Test
	public void isSorted() {
		CardDeck deck = new CardDeck("testDeck", SortingOrder.SUITE_NAME_ORDERED_ASC);
		assertNotNull(deck);
		assertNotNull(deck.getCards());
		assertEquals(52, deck.getCards().size());
		assertEquals("testDeck", deck.getDeckName());
		assertTrue(deck.isSorted());
	}
	
	@Test
	public void equalDecks() {
		CardDeck deck1 = new CardDeck("testDeck", SortingOrder.SUITE_NAME_ORDERED_ASC);
		CardDeck deck2 = new CardDeck("testDeck", SortingOrder.SUITE_NAME_ORDERED_ASC);
		assertNotNull(deck1);
		assertNotNull(deck2);
		assertNotNull(deck1.getCards());
		assertNotNull(deck2.getCards());
		
		assertTrue(deck1.equals(deck2));
	}

}
