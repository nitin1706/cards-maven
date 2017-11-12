package com.cafe1706.maven.cardsmaven.utils;

import java.util.Comparator;

import com.cafe1706.maven.cardsmaven.model.Card;

public class SortingOrderComparator {
	
	public static Comparator<Card> defaultOrder() {
		return ascRankOrder();
	}

	public static Comparator<Card> ascRankOrder() {
		Comparator<Card> cardSorter = (Card card1, Card card2) -> card1.getRank().getCardRank() - (card2.getRank().getCardRank());
		return cardSorter;
	}
	
	public static Comparator<Card> descRankOrder() {
		Comparator<Card> cardSorter = (Card card1, Card card2) -> card2.getRank().getCardRank() - (card1.getRank().getCardRank());
		return cardSorter;
	}
	
	public static Comparator<Card> ascSuiteNameRankOrder() {
		// TODO -- for future enhancement
		return null;
	}
	
	public static Comparator<Card> descSuiteNameRankOrder() {
		// TODO -- for future enhancement
		return null;
	}
	
	
	public static Comparator<Card> getSortedBy(SortingOrder orderBy) {
		switch (orderBy) {
		case DEFAULT:
			return defaultOrder();
		
		case SUITE_RANK_ASC:
			return ascRankOrder();
		
		case SUITE_RANK_DESC:
			return descRankOrder();
		
		case SUITE_NAME_ORDERED_ASC:
			return defaultOrder();
		
		case SUITE_NAME_ORDERED_DESC:
			return defaultOrder();
		
		case RANDOM:
			return defaultOrder();
			
		default:
			return defaultOrder();
		}
	}

}
