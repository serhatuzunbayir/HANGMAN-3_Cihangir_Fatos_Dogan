package Hangman;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Word searchWord = new Word();
		String visibleWord = searchWord.secretWord;
		System.out.println(" ");
		System.out.println("Your secret word's length is " + visibleWord.length());
		Scanner scn = new Scanner(System.in);
		while(searchWord.counter<=4)
		{
			System.out.println("Please enter a letter");
			char newLetter = scn.next().charAt(0);
			System.out.println(searchWord.searchLetter(newLetter));
			if (searchWord.truecounter == visibleWord.length()) 
			{
				System.out.println("WIN");
				break;
			}
		}		
		scn.close();
	}

}
