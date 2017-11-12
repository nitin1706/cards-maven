package com.cafe1706.maven.cardsmaven.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum CardRank {
	
	ACE ("I", 1),
	TWO ("II", 2),
	THREE ("III", 3),
	FOUR ("IV", 4),
	FIVE ("V", 5),
	SIX ("VI", 6),
	SEVEN ("VII", 7),
	EIGHT ("VIII", 8),
	NINE ("IX", 9),
	TEN ("X", 10),
	JACK ("XI", 11),
	QUEEN ("XII", 12),
	KING ("XIII", 13);
	
	private final int rank;
	private final String rankDesc;
	private static Map<Integer, String> cardsMap;
	
	CardRank(String desc, int rank) {
		this.rank = rank;
		this.rankDesc = desc;
	}
	
	static {
		Map<Integer, String> cards = new HashMap<>();
		for(CardRank cardRank : CardRank.values()) {
			cards.put(cardRank.rank, cardRank.rankDesc);
		}
		cardsMap = Collections.unmodifiableMap(cards);
	}
	
	public int getCardRank() {
        return rank;
    }

    public String getCardRankDesc() {
        return rankDesc;
    }
	
	public String getCardRankDescription(int rank) {
		return cardsMap.get(rank);
	}

}
