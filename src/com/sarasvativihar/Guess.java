package com.sarasvativihar;

public class Guess {
	String actualHand;
	String currentGuess;
	Integer numGuess = 0;
	Integer posGuess = 0;
	boolean correctGuess;

	public Guess(String actualHand, String guess) {
		super();
		this.actualHand = actualHand;
		this.currentGuess = guess;
		calculateNumGuess();
		calculatePosGuess();
		isCorrectGuess();
	}

	public void calculateNumGuess() {
		char[] chr = currentGuess.toCharArray();
		for(char c : chr) {
			if(actualHand.contains(String.valueOf(c))) {
				this.numGuess += 1;
			}
		}
	}
	
	public void calculatePosGuess() {
		char[] chr = currentGuess.toCharArray();
		for(int i = 0; i < chr.length; i++) {
			if(actualHand.contains(String.valueOf(chr[i])) && chr[i] == actualHand.charAt(i)) {
				this.posGuess += 1;
			}
		}
	}
	
	public void isCorrectGuess() {
		this.correctGuess = actualHand.equals(currentGuess);
	}

	public String getActualHand() {
		return actualHand;
	}

	public void setActualHand(String actualHand) {
		this.actualHand = actualHand;
	}

	public String getGuess() {
		return currentGuess;
	}

	public void setGuess(String guess) {
		this.currentGuess = guess;
	}

	public Integer getNumGuess() {
		return numGuess;
	}

	public void setNumGuess(Integer numGuess) {
		this.numGuess = numGuess;
	}

	public Integer getPosGuess() {
		return posGuess;
	}

	public void setPosGuess(Integer posGuess) {
		this.posGuess = posGuess;
	}
	
	

	public String getCurrentGuess() {
		return currentGuess;
	}

	public void setCurrentGuess(String currentGuess) {
		this.currentGuess = currentGuess;
	}

	public boolean getCorrectGuess() {
		return correctGuess;
	}

	public void setCorrectGuess(boolean correctGuess) {
		this.correctGuess = correctGuess;
	}

	@Override
	public String toString() {
		return "currentGuess=" + currentGuess + ", cow=" + numGuess + ", bull=" + posGuess;
	}

}
