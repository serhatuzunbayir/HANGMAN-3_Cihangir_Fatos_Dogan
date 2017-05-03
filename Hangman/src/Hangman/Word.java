package Hangman;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Word {
	Word(int lg)
	{
		getWordList(lg);
		assignWord();
		createNullWord();
		myWord = new StringBuilder(createNullWord());
	}
	protected StringBuilder myWord;
	public String secretWord;
	public int counter =0;
	public int truecounter =0;
	protected ArrayList<String> WordList = new ArrayList<String>();
	protected Scanner wordScanner = null;
	protected ArrayList<Character> letterList = new ArrayList<Character>();
	protected String createNullWord()
	{
		String displayedResult = "";
		for(int i=0; i<secretWord.length(); i++)
		{
			displayedResult = displayedResult+"_";
		}
		return displayedResult;
	}
	protected void getWordList(int lg)
	{
		try
		{
			switch(lg)
			{
			case 1: wordScanner = new Scanner(new File("C:\\Users\\Dogan\\Desktop\\SE318\\HANGMAN-3_Cihangir_Fatos_Dogan\\Hangman\\src\\Hangman\\Words.txt"));
			break;
			case 2: wordScanner = new Scanner(new File("C:\\Users\\Dogan\\Desktop\\SE318\\HANGMAN-3_Cihangir_Fatos_Dogan\\Hangman\\src\\Hangman\\WordsTR.txt"));
			break;
			default : wordScanner = new Scanner(new File("C:\\Users\\Dogan\\Desktop\\SE318\\HANGMAN-3_Cihangir_Fatos_Dogan\\Hangman\\src\\Hangman\\Words.txt"));
			break;
			}
				
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
	protected void assignWord()
	{
		Random random = new Random();
		int number =random.nextInt(WordList.size());
		secretWord = WordList.get(number);
	}
	public void addWord(String word){
		WordList.add(word);
	}
	protected void displayWord(){
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
