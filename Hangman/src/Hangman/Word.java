package Hangman;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Word {
	Word()
	{
		getWordList();
		assignWord();
		createNullWord();
		myWord = new StringBuilder(displayedResult);
	}
	private StringBuilder myWord;
	public String secretWord;
	public int counter =0;
	private String displayedResult="";
	public int truecounter =0;
	private ArrayList<String> WordList = new ArrayList<String>();
	private Scanner wordScanner = null;
	private ArrayList<Character> letterList = new ArrayList<Character>();
	private void createNullWord()
	{
		for(int i=0; i<secretWord.length(); i++)
		{
			displayedResult = displayedResult+"_";
		}
	}
	private void getWordList()
	{
		try
		{
			wordScanner = new Scanner(new File("C:\\Users\\Dogan\\workspace\\Hangman\\src\\Hangman\\Words.txt"));
			while(wordScanner.hasNextLine()) {
				String[] words = wordScanner.nextLine().split(",");
				for(int i=0;i<words.length;i++) 
				{
					String temp = words[i].trim();
					WordList.add(temp);
				}
			}	
		}
		catch(Exception e)
		{
			System.out.println("Your Error : " + e.getMessage());
		}
	}
  	private void assignWord()
	{
		Random random = new Random();
		int number =random.nextInt(WordList.size());
		secretWord = WordList.get(number);
	}
	public void addWord(String word){
		WordList.add(word);
	}
	private void displayWord(){
		int i = 0;
		for (String item : WordList) {
			System.out.println((i++)+" "+item);
		}
	}
	public void modifyWord(int Choose,String result){
		WordList.set(Choose, result);
	}
	public String searchLetter(char letter)
	{	
		if(letterList.size()!=0)
		{
			for(int k=0; k<letterList.size();k++)
			{
				if(letterList.get(k)==letter)
				{
					return myWord.toString();
				}
			}
		}
		int temp = truecounter;
		for(int i=0; i<secretWord.length(); i++)
		{
			if(letter==secretWord.charAt(i))
			{						
				myWord.setCharAt(i, letter);
				truecounter += 1;
				letterList.add(letter);
			}
		}
		if(temp == truecounter)
		{
			counter +=1;
			letterList.add(letter);
			switch(counter)
			{
				case 1: System.out.println("The head was cut!"); break;
				case 2: System.out.println("The body was cut!"); break;
				case 3: System.out.println("The right arm was cut!"); break;
				case 4: System.out.println("The left arm was cut!"); break;
				case 5: System.out.println("The legs were cut! GAME OVER !!!");break; 
			}
		}
		return myWord.toString();
	}
}
