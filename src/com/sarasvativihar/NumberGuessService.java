package com.sarasvativihar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGuessService {
	private int tries = 10;
	List<Integer> numList = new ArrayList<>();

	public String selectActualHand() {		
		for (int i = 0; i < 10; i++) {
			numList.add(i);
		}

		Collections.shuffle(numList);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb.append(numList.get(i));
		}
		return sb.toString();
	}
	
	public boolean validateInput(String guess) {
		if(guess == null) return false;
		if(guess.length() != 4) return false;
		
		Set<Character> set = new HashSet<>();
		char[] chr = guess.toCharArray();
		for(int i = 0; i < chr.length; i++) {
			int a = chr[i] - '0';
			if(!numList.contains(a) || set.add(chr[i]) == false) return false;
		}
		tries -= 1;
		return true;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}
	
	
}
