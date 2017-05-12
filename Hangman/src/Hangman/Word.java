package Hangman;

import java.io.File;         //import input-output library for 
import java.util.ArrayList; //import ArrayList library
import java.util.Random;   //import Random library for random selection
import java.util.Scanner; //import Scanner library for scanner use

public class Word {
	Word(int lg) 
	{
		getWordList(lg);
		assignWord();  // Random word assign
		createNullWord(); //Define null word
		myWord = new StringBuilder(createNullWord()); // Defined null word is put with stringbuilder
	}
	//--Define classes--//
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
		for(int i=0; i<secretWord.length(); i++) // For loop runs until the length of the secret word
		{
			displayedResult = displayedResult+"_";  //The secret word is written as '-' on the screen.
		}
		return displayedResult;
	}
	protected void getWordList(int lg)  // getwordList class is taken int parameter(option)
	{
		try
		{
			//--Swtich reads the file to according the incoming lg result --//
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
				String[] words = wordScanner.nextLine().split(",");  //Separated by comma
				for(int i=0;i<words.length;i++)                     //For loop runs until the length of the word
				{
					String temp = words[i].trim();       //Trim is used to get rid of spaces and put into temp
					WordList.add(temp);                 // added to wordlist
				}
			}	
		}
		catch(Exception e)
		{
			System.out.println("Your Error : " + e.getMessage()); //Message is given in case of exception
		}
	}
	protected void assignWord()
	{
		Random random = new Random();  //Random is created.
		int number =random.nextInt(WordList.size());  //Wordlist of length is taken as randomly and put to number
		secretWord = WordList.get(number);	     // The secret word is taken from the wordlist with the incoming number
	}
	public void addWord(String word){
		WordList.add(word);  //Added word to wordlist
	}
	protected void displayWord(){    //Display word on the screen 
		int i = 0;
		for (String item : WordList) {         
			System.out.println((i++)+" "+item);   
		}
	}
	public void modifyWord(int Choose,String result){   // Modifyword is taken 2 parameter
		WordList.set(Choose, result);         //Set the Wordlist
	}
	public String searchLetter(char letter)  //take parameter(leter)
	{	
		if(letterList.size()!=0)               //letterlist size is not equal zero
		{
			for(int k=0; k<letterList.size();k++)   // for loop runs until letterlist of size
			{
				if(letterList.get(k)==letter)  //letterlist's k is equal to incoming parameter(letter)
				{
					System.out.println("This letter has already been entered. Please enter a new letter.");
					return myWord.toString();  //The myword is converted to string and return
				}
			}
		}
		int temp = truecounter;        //keep true answers to temp
		for(int i=0; i<secretWord.length(); i++)    //for loop runs until secretword of length
		{
			if(letter==secretWord.charAt(i))   //letter is equal secretword's character
			{						
				myWord.setCharAt(i, letter); //Myword is set 
				truecounter += 1;
				letterList.add(letter);	   //letter is added to letterlist
			}
		}
		if(temp == truecounter) 
		{
			counter +=1;
			letterList.add(letter); //letter is added to letterlist
			//--The message is given to the screen in every wrong answer according to the incoming counter
			switch(counter)
			{
				case 1: System.out.println("The head was cut!"); break;
				case 2: System.out.println("The body was cut!"); break;
				case 3: System.out.println("The right arm was cut!"); break;
				case 4: System.out.println("The left arm was cut!"); break;
				case 5: System.out.println("The legs were cut! GAME OVER !!!");break; 
			}
		}
		return myWord.toString(); // return myword
	}
}
