package Hangman;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		int resultAgain=0;
		Scanner scnlg = new Scanner(System.in);
		Scanner scn = new Scanner(System.in);
		do
		{
		System.out.println("Select Directory Language :");
		System.out.println("1- English Directory :");
		System.out.println("2- Turkish Directory :");
		
		Word searchWord;
		int result = scnlg.nextInt();
		
		if(result==1)
		{
			searchWord = new Word(1);
		}
		else if(result==2)
		{
			searchWord = new Word(2);
		}
		else
		{
			searchWord = new Word(1);
		}
		
		
		String visibleWord = searchWord.secretWord;
		System.out.println(" ");
		System.out.println("Your secret word's length is " + visibleWord.length());
		
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

		System.out.println("Do you wanna1 play again ?");
		System.out.println("1 - Yes");
		System.out.println("2- No");
		resultAgain = scnlg.nextInt();
		

		
		}while(resultAgain==1);
		scn.close();
		scnlg.close();	
	}

}
