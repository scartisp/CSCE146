
/*
 * Simion Cartis	
 */
import java.util.*;
import java.io.*;

public class WordHelper {
	public static final String FILE_NAME = "./randomWords.txt";
	// public static final Scanner FILE_SCANNER = new Scanner(new File(FILE_NAME));

	public static String[] sortByVowels(String[] words) {
		// int wordLength = countWords(FILE_NAME);
		// String wordsV[] = new String[wordLength];
		String[] vowels = words.clone(); //this is just a built in cloning method for strings. needed so as to not accidently mess up previous variations of the orginal array
		for (int i = 0; i < vowels.length; i++) {
			// wordsV[i] = words[i];
			for (int j = 0; j < vowels[i].length(); j++) {
				boolean hasSwappedV = true;
				while (hasSwappedV) {
					hasSwappedV = false;
					for (int s = 0; s < vowels.length - 1; s++) { 
						if (cVowel(vowels[s]) > cVowel(vowels[s + 1])) { //this calls on the cVowel method for the word at index s of the array vowels
							String temp = vowels[s];
							vowels[s] = vowels[s + 1];
							vowels[s + 1] = temp;
							hasSwappedV = true;
						}
					}
				}
			}
		}
		return vowels;
	}

	public static String[] sortByConsonants(String[] words) {
		String[] cons = words.clone();
		for (int i = 0; i < cons.length; i++) {
			for (int j = 0; j < cons[i].length(); j++) { //this makes sure it iterates for every letter of a given word
				boolean hasSwappedC = true;
				while (hasSwappedC) {
					hasSwappedC = false;
					for (int s = 0; s < cons.length - 1; s++) { //this technically presents a new sorted list every time
						if (cCons(cons[s]) > cCons(cons[s + 1])) { //but because it only stops running once i (not s) reaches the length of the cons array
							String temp = cons[s]; //it only prints out shows the final variation.
							cons[s] = cons[s + 1];
							cons[s + 1] = temp;
							hasSwappedC = true;
						}
					}
				}
			}
		}
		return cons;
	}
	public static String[] sortByLength(String[] words) {
		String[] leng = words.clone();
		for (int i =0; i<leng.length;i++) {
			for(int j =0;j<leng[i].length();j++) {
				boolean hasSwapped = true;
				while (hasSwapped) {
					hasSwapped =false;
					for(int s =0; s<leng.length-1;s++) {
						if(leng[s].length() > leng[s+1].length()) {
							String temp = leng[s];
							leng[s] = leng[s + 1];
							leng[s + 1] = temp;
							hasSwapped = true;
						}
					}
				}
			}
		}
		return leng;
	}

	public static int cVowel(String vowels) {
		int vCount = 0;
		for (int i = 0; i < vowels.length(); i++) {
			if (vowels.charAt(i) == 'a' || vowels.charAt(i) == 'e' || vowels.charAt(i) == 'i' || vowels.charAt(i) == 'o'
					|| vowels.charAt(i) == 'u' || vowels.charAt(i) == 'y')
				vCount++;
		}
		return vCount;
	}

	public static int cCons(String cons) {
		int cCount = 0;
		for (int i = 0; i < cons.length(); i++) {
			if (cons.charAt(i) != 'a' || cons.charAt(i) != 'e' || cons.charAt(i) != 'i' || cons.charAt(i) != 'o'
					|| cons.charAt(i) != 'u' || cons.charAt(i) != 'y') // this method is called based in the bubble sort 
				cCount++; //method. it calls on this at index i, meaning it only checks the characters in a given string which corresponds to i, and then i+1
		} //until the bubble sort is complete.
		return cCount;
	}

	public static int countWords(String FILE_NAME) {
		try {
			Scanner fileScanner = new Scanner(new File(FILE_NAME));
			int wordCount = 0;
			while (fileScanner.hasNextLine()) {
				fileScanner.nextLine();
				wordCount++;
			}
			// Creates the return array, resets the file scanner, and populates the array
			return wordCount;
		} catch (IOException e) {
			System.out.println(e);
		}
		return 0;
	}
}
