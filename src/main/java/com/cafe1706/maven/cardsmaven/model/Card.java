package com.cafe1706.maven.cardsmaven.model;

public class Card {
	
	private CardRank rank;
	private CardSuite suite;
	
	public Card(CardSuite suite, CardRank rank) {
		this.suite = suite;
		this.rank = rank;
	}

	public CardRank getRank() {
		return rank;
	}

	public CardSuite getSuite() {
		return suite;
	}

	@Override
	public String toString() {
		return "Card [suite =" + suite + ", rank =" + rank + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suite == null) ? 0 : suite.hashCode());
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
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suite != other.suite)
			return false;
		return true;
	}

}
