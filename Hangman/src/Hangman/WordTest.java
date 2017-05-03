package Hangman;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

public class WordTest {
	Word test1 = new Word(1);
	@Test
	public void SecretWord() {
		assertNotEquals(null,test1.secretWord);
		}
	@Test
	public void Counter(){
		assertTrue((test1.counter>=0) & (test1.counter<=5));
	}
	@Test
	public void WordList()
	{
		assertNotNull(test1.WordList);
	}
	@Test
	public void SearchLetter()
	{
		// assertEquals('a', test1.searchLetter('a'));
	}
	@Test
	public void MyWord(){
		assertNotNull(test1.myWord);
	}
	@Test
	public void TrueCounter(){
		assertTrue(test1.truecounter <= test1.myWord.length());
	}
	@Test
	public void LetterList(){
		assertNotEquals(null,test1.letterList);
	}
	@Test
	public void modifyWord(){
		test1.modifyWord(1, "a");
		assertEquals("a", test1.WordList.get(1));
	}
 
}
