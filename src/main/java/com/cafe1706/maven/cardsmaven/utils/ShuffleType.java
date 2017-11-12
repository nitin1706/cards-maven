package com.cafe1706.maven.cardsmaven.utils;

public enum ShuffleType {
	SIMPLE(1, 3, "default"), 
	DOUBLE(3, 7, "simple"), 
	COMPLEX(8, 10, "complex");

	private int minLevel = 0;
	private int maxLevel = 10;
	private String shuffleType = "";

	private ShuffleType() {
		this(1, 3, "default");
	}
	
	private ShuffleType(int minLevel, int maxLevel, String desc) {
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
	}

	public int getShufflingLevelRange() {
		return ((this.minLevel + this.maxLevel) / 2);
	}
	
	public String getShuffleType() {
		return this.shuffleType;
	}
}
