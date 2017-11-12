package com.cafe1706.maven.cardsmaven.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cafe1706.maven.cardsmaven.model.Card;
import com.cafe1706.maven.cardsmaven.model.CardDeck;

@RunWith(SpringRunner.class)
public class CardOperationsServiceImplTest {
	CardOperations cardOperations = null;

	@Before
	public void setUp() throws Exception {
		cardOperations = new CardOperationsServiceImpl();
	}

	@Test
	public void testCreateDeck() {
		List<Card> deck1 = cardOperations.createDeck("testDeck1");
		assertNotNull(deck1);
		assertEquals(52, deck1.size());
	}

	@Test
	public void testGetAllDecksNames() {
		for(int count = 0;  count < 4; count++ ){ 
			cardOperations.createDeck("testDeck" + count);
		}
		List<String> allDecks = cardOperations.getAllDeckNames();
		assertNotNull(allDecks);
		//assertEquals(4, allDecks.size());
	}
	
	@Test
	public void testGetAllDecks() {
		for(int count = 0;  count < 7; count++ ){ 
			cardOperations.createDeck("testDeck" + count);
		}
		List<CardDeck> allDecks = cardOperations.getAllDecks();
		assertNotNull(allDecks);
		//assertEquals(7, allDecks.size());
	}

	@Test
	public void testGetDeck() {
		String deckName = "verifyDeckExistence";
		cardOperations.createDeck(deckName);
		List<Card> shuffledDeck = cardOperations.shuffleDeck(deckName);
		
		List<Card> cardsRetrieved = cardOperations.getDeck(deckName);
		
		assertNotNull(shuffledDeck);
		assertNotNull(cardsRetrieved);
		assertEquals(cardsRetrieved, shuffledDeck);
	}

	@Test
	public void testUpdateDeck() {
	}

	@Test
	public void testUpdateDeckName() {
		List<Card> cardsDeckOne = cardOperations.createDeck("deckOne");
		assertNotNull(cardsDeckOne);
		
		assertNotNull(cardOperations.getDeck("deckOne"));
		
		List<Card> shuffled = cardOperations.shuffleDeck("deckOne");
		assertNotNull(shuffled);
		
		cardOperations.updateDeckName("deckOne", "newDeckOne");
		List<Card> updatedDeck = cardOperations.getDeck("newDeckOne");
		assertNotNull(updatedDeck);
		
		assertEquals(shuffled, updatedDeck);
	}

	@Test
	public void testRemoveDeck() {
		for(int count = 0;  count < 4; count++ ){ 
			cardOperations.createDeck("testDeck" + count);
		}
		List<String> allDecks = cardOperations.getAllDeckNames();
		assertNotNull(allDecks);
		//assertEquals(4, allDecks.size());
		
		String deckRemoved = cardOperations.removeDeck("testDeck2");
		assertEquals(deckRemoved, "testDeck2");
		List<String> allDecksAfterRemoval = cardOperations.getAllDeckNames();
		assertNotNull(allDecksAfterRemoval);
		//assertEquals(3, allDecksAfterRemoval.size());
	}

	@Test
	public void testShuffleDeck() {
		List<Card> deck1 = cardOperations.createDeck("testDeck");
		assertNotNull(deck1);
		
		List<Card> shuffled = cardOperations.shuffleDeck("testDeck");
		assertNotNull(shuffled);
		
		assertNotEquals(deck1, shuffled);
	}

	@Test
	public void testShuffleDeckWithLevelDouble() {
		List<Card> deck1 = cardOperations.createDeck("testDeckOne");
		assertNotNull(deck1);
		
		cardOperations.shuffleDeckWithLevel("testDeckOne", "double");
		
		List<Card> shuffled = cardOperations.getDeck("testDeckOne");
		assertNotNull(shuffled);
		
		List<Card> deck2 = cardOperations.createDeck("testDeckTwo");
		
		assertNotEquals(deck2, shuffled);
	}
	
	@Test
	public void testShuffleDeckWithLevelComplex() {
		List<Card> deck1 = cardOperations.createDeck("testDeck");
		assertNotNull(deck1);
		
		cardOperations.shuffleDeckWithLevel("testDeck", "COMPLEX");
		
		List<Card> shuffled = cardOperations.getDeck("testDeck");
		assertNotNull(shuffled);
		
		List<Card> deck2 = cardOperations.createDeck("testDeckTwo");
		
		assertNotEquals(deck2, shuffled);
	}
}
