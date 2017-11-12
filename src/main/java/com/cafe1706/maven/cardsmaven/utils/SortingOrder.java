package com.cafe1706.maven.cardsmaven.utils;

import java.util.HashMap;
import java.util.Map;

public enum SortingOrder {
	DEFAULT ("default"),
	SUITE_RANK_ASC ("Rank"),
	SUITE_RANK_DESC ("RankDesc"),
	SUITE_NAME_ORDERED_ASC ("Suit"),
	SUITE_NAME_ORDERED_DESC ("SuitDesc"),
	RANDOM ("Random");
	
	private final String orderBy;
	private static Map<String, SortingOrder> sortingOrders = new HashMap<>();
	
	static {
		for(SortingOrder order : SortingOrder.values()) {
			sortingOrders.put(order.orderBy, order);
		}
	}
	
	public static SortingOrder orderBy(String sortOrder) {
		return sortingOrders.get(sortOrder);
	}
	
	private SortingOrder(String ordered) {
			this.orderBy = ordered;
	}
}
