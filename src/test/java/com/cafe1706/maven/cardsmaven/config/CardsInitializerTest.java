package com.cafe1706.maven.cardsmaven.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cafe1706.maven.cardsmaven.model.Card;
import com.cafe1706.maven.cardsmaven.model.CardRank;
import com.cafe1706.maven.cardsmaven.model.CardSuite;


@RunWith(SpringRunner.class)
public class CardsInitializerTest {
	
	@Test
	public void getCards() {
		Set<Card> cards = CardsInitializer.getCards();
		assertNotNull(cards);
		assertEquals(52, cards.size());
	}
	
	@Test
	public void getCardSuites() {
		List<CardSuite> cardSuites = CardsInitializer.getCarsSuites();
		assertNotNull(cardSuites);
		assertEquals(4, cardSuites.size());
	}
	
	@Test
	public void getCardRanks() {
		List<CardRank> cardRanks = CardsInitializer.getCardRanks();
		assertNotNull(cardRanks);
		assertEquals(13, cardRanks.size());
	}

}
