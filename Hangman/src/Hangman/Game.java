package Hangman;

import java.util.Scanner;   // import scanner library for scanner use 

public class Game {

	public static void main(String[] args) {
		int resultAgain=0;                     //Define resultAgain
		Scanner scnlg = new Scanner(System.in);	 // Create scnlg from scanner for multilanguage. 
		Scanner scn = new Scanner(System.in);	 // Create  scn from scanner for letters.
		do
		{
		System.out.println("Select Directory Language :"); // Multiple language option
		System.out.println("1- English Directory :");
		System.out.println("2- Turkish Directory :");
		
		Word searchWord;
		int result = scnlg.nextInt();  //The user's dictionary selection is taken and put into the result
		
		if(result==1)
		{
			searchWord = new Word(1);  //English dictionary dictionary income
		}
		else if(result==2)
		{
			searchWord = new Word(2);  //Turkish dictionary dictionary income
		}
		else
		{
			searchWord = new Word(1);  // English dictionary dictionary income as default
		}
		
		
		String visibleWord = searchWord.secretWord;   
		System.out.println(" ");
		System.out.println("Your secret word's length is " + visibleWord.length()); //Secret word of length is printed on the screen as number 
		
		while(searchWord.counter<=4)  //while runs until searchword counter is 4
		{
			System.out.println("Please enter a letter");
			char newLetter = scn.next().charAt(0);   
			System.out.println(searchWord.searchLetter(newLetter));
			if (searchWord.truecounter == visibleWord.length()) 
			{
				System.out.println("WIN");  // if truecounter is equal to visible word of length user is win
				break;
			}
		}		

		System.out.println("Do you wanna play again ?"); //Ask the user
		System.out.println("1 - Yes");
		System.out.println("2- No");
		resultAgain = scnlg.nextInt(); //Resultagain is taken income number
		

		
		}while(resultAgain==1); 
		scn.close();
		scnlg.close();	
	}

}
