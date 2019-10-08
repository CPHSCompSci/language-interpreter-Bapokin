package app;

//import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    // This is a test comment
    Lexicon lex = new Lexicon();

		/*
		 * String newWord = lex.translate("hhhhhhhhh"); System.out.println(newWord);
		 */
    
    //dkjasfljiejuy
    
//    for(int i = 0; i < 16; i++)
//    {
//    	System.out.println(decodeMessage(lex.list[i]));
//    }
    
    
    System.out.println(lex.translate("I rent bananas"));
    System.out.println(decode(lex.translate("I rent bananas")));
    
    //System.out.println(decode(lex.translate("Hello")));
    
    encodeInput();
    decodeInput();
    

  }

  /**
   * This method decodes a single word.
   * 
   * @param word The single word to be decoded.
   */
  public static String decode(String word)
  {
	  String newWord = "";
	  char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
	  
	  if(word.endsWith("ingy"))
	  {
		  String word2 = word.substring(0, word.length()-4);
		  boolean consonant = true;
		  for (char v : vowels) 
		  {
			  if (word2.charAt(word2.length() - 1) == v) 
	          {
	                consonant = false;    
	          }	      
	      }
		  if(consonant && !word2.endsWith("s"))
		  {
			  newWord = word2;
		  }		  
	  }
	  int firstVowel = 0;
	  for(int i = newWord.length()-1; i > 0; i--)
	  {
		  for(char v: vowels)
		  {
			  if(newWord.charAt(i) == v)
			  {
				  firstVowel = i;
			  }
		  }
	  }
	  if(newWord.length() >= 3)
	  {
		  if(newWord.substring(firstVowel+1, firstVowel+4).equals("ent"))
		  {
			  newWord = newWord.replaceAll("ent", "");
		  }
	  }
		  
	  return newWord;
	  
		 
	  
  }

  /**
   * This method should not have code copy/pasted from the decode method.
   * 
   * @param message The sentence (multiple words) to be decoded.
   */
  public static String decodeMessage(String message)
  {
	  

	  ArrayList<String> words = new ArrayList<String>();
	  ArrayList<Integer> space = new ArrayList<Integer>();
	  String newMessage = message + " ";
	  for(int i = message.length()-1; i >= 0; i--)
	  {
		  if(message.charAt(i) == ' ')
		  {
			  space.add(i);
			  words.add(message.substring(0,i));
		  }
	  }
	  for(int i = 0; i < space.size(); i++)
	  {
		  words.add(message.substring(i,i+1));
	  }
	  for(int i = 0; i < words.size(); i++)
	  {
		 newMessage += decode(words.get(i));
	  }

	  return newMessage;
	  
	 
  }
  
  public static void encodeInput()
  {
	  System.out.println("What word/message would you like to encode?");
	  Scanner input = new Scanner(System.in);
	  String word = input.nextLine();
	  Lexicon lex = new Lexicon();
	  System.out.println(lex.translate(word));
  }
  
  public static void decodeInput()
  {
	  System.out.println("What word/message would you like to decode?");
	  Scanner input = new Scanner(System.in);
	  String word = input.nextLine();
	  System.out.println(decodeMessage(word));
  }
}