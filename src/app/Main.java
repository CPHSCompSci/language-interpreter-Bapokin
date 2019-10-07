package app;

//import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // This is a test comment
    Lexicon lex = new Lexicon();

		/*
		 * String newWord = lex.translate("hhhhhhhhh"); System.out.println(newWord);
		 */
    
    //dkjasfljiejuy
    
    for(int i = 0; i < 16; i++)
    {
    	System.out.println(decodeMessage(lex.list[i]));
    }
    
    
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
//	  String newWord = "";
	  
	  
	  
//		  newWord = word.replaceAll("ingy", ""); 
//		  newWord = newWord.replaceAll("ent", ""); 
//		  return newWord;
		
		  String newWord = ""; 
		  int vowelcount = 0; 
		  int firstvowel = 0; 
		  int firstvowelcount = - 1;
		  
		  for(int i = 0; i < word.length(); i++) { if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i'|| word.charAt(i) == 'o' ||word.charAt(i) == 'u') { firstvowelcount++; } } 
		  if(firstvowelcount <= 2) 
		  {
			  newWord = word.substring(0, word.length()-4); 
		  } 
		  else { 
			  newWord = word;
			  }
		  
		  for(int i = 0; i < newWord.length(); i++) { if(word.charAt(i) == 'a' ||word.charAt(i) == 'e' || word.charAt(i) == 'i'|| word.charAt(i) == 'o' ||word.charAt(i) == 'u') 
		  {
			 vowelcount++; 
		  if(vowelcount == 1) 
		  { firstvowel = i;
		  } 
		  } 
		  }
		  
		  String newnewstring = "";
		  
		  for(int x = 0; x <= firstvowel; x++) 
		  { 
			  newnewstring += newWord.charAt(x);
		  
		  }
		  
		  int skip = firstvowel+4;
		  
		  for(int y = skip; y < newWord.length(); y++) 
		  { 
			  newnewstring += newWord.charAt(y); }
		  
		  
//		 vowelcount = 0; 
//		 firstvowel = 0; 
		 return newnewstring;
		 
	  
  }

  /**
   * This method should not have code copy/pasted from the decode method.
   * 
   * @param message The sentence (multiple words) to be decoded.
   */
  public static String decodeMessage(String message)
  {
	  
		/*
		 * ArrayList<String> words = new ArrayList<String>(); ArrayList<Integer> space =
		 * new ArrayList<Integer>();
		 * 
		 * for(int i = 0; i < message.length(); i++) { if(message.charAt(i) == ' ') {
		 * space.add(i); } }
		 * 
		 * String finalString = "";
		 * 
		 * for(int i = 0; i < space.size(); i++) {
		 * words.add(decode(message.substring(0,space.get(i)))); finalString +=
		 * words.get(i); }
		 */
	  
	  
	 
	  
	  return decode(message);
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