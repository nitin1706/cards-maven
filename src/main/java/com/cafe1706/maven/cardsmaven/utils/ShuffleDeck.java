package com.cafe1706.maven.cardsmaven.utils;

import java.util.ArrayList;

import com.cafe1706.maven.cardsmaven.model.Card;

public class ShuffleDeck {
	public static ArrayList<Card> shuffle(ArrayList<Card> originalDeck, ShuffleType type) {
		if(type == ShuffleType.COMPLEX)
			return complexShuffle(originalDeck);
		
		ArrayList<Card> shuffledDeck = new ArrayList<>();

        while (originalDeck.size() > 0) {
            int index = (int) (Math.random() * originalDeck.size());
            shuffledDeck.add(originalDeck.remove(index));
        }
        
        if(type == ShuffleType.SIMPLE)
        	return shuffledDeck;
        
        while (shuffledDeck.size() > 0) {
            int index = (int) (Math.random() * shuffledDeck.size());
            originalDeck.add(shuffledDeck.remove(index));
        }
        return originalDeck;
	}
	
	public static ArrayList<Card> complexShuffle(ArrayList<Card> originalDeck) {
		
		ArrayList<Card> firstHalf = new ArrayList<>(originalDeck.size() / 2);
		ArrayList<Card> SecondHalf = new ArrayList<>(originalDeck.size() / 2);
		
        while (originalDeck.size() > 0) {
            int index = (int) (Math.random() * originalDeck.size());
            if(index / 2 == 0)
            	firstHalf.add(originalDeck.remove(index));
            else
            	SecondHalf.add(originalDeck.remove(index));
        }
        
        ArrayList<Card> shuffledFirstHalf = shuffle(firstHalf, ShuffleType.SIMPLE);
        ArrayList<Card> shuffledSecondHalf = shuffle(SecondHalf, ShuffleType.DOUBLE);
        
        /*for(int front = 0, tail = shuffledFirstHalf.size() + shuffledSecondHalf.size() ; front < shuffledFirstHalf.size() ; front++ , tail--) {
        	originalDeck.add(shuffledFirstHalf.get(front));
        	if(shuffledSecondHalf.size() - front > 0)
        		originalDeck.add(tail, shuffledSecondHalf.get(shuffledSecondHalf.size() - front));
        }*/
        
        originalDeck.addAll(shuffledFirstHalf);
        originalDeck.addAll(shuffledSecondHalf);
        
        return originalDeck;
	}

}
