package com.cafe1706.maven.cardsmaven.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cafe1706.maven.cardsmaven.config.CardsInitializer;
import com.cafe1706.maven.cardsmaven.utils.SortingOrder;
import com.cafe1706.maven.cardsmaven.utils.SortingOrderComparator;

public class CardDeck {
	private String deckName;
	private final String deckId;  // -- kept for future use; in case data needs to be stored in DB.
	private List<Card> cards = new ArrayList<>();
	private SortingOrder sortedBy;
	
	public CardDeck(String deckName) {
		this(deckName, SortingOrder.DEFAULT);
	}
	
	public CardDeck(String deckName, SortingOrder order) {
		this.deckName = deckName;
		this.deckId = "UniqueId";
		for(Card card : CardsInitializer.getCards()) {
			this.cards.add(card);
		}
		this.sortedBy = order;
		Collections.sort(this.cards, SortingOrderComparator.getSortedBy(order));
	}
	
	public String getDeckName() {
		return deckName;
	}
	
	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}

	public String getDeckId() {
		return deckId;
	}
	
	public SortingOrder getSortedBy() {
		return sortedBy;
	}

	public void setSortedBy(SortingOrder sortedBy) {
		this.sortedBy = sortedBy;
	}
	
	public boolean isSorted() {
		if(this.sortedBy == null) return false;
		return true;
	}
	
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		if(cards.size() < 52) {
			throw new RuntimeException("Cards in a Deck cannot be less than 52");
		}
		this.cards = cards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deckId == null) ? 0 : deckId.hashCode());
		result = prime * result + ((deckName == null) ? 0 : deckName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardDeck other = (CardDeck) obj;
		if (deckId == null) {
			if (other.deckId != null)
				return false;
		} else if (!deckId.equals(other.deckId))
			return false;
		if (deckName == null) {
			if (other.deckName != null)
				return false;
		} else if (!deckName.equals(other.deckName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CardDeck [deckName=" + deckName + ", deckId=" + deckId + "]";
	}
}
