
//Simion Cartis
import java.util.Random;
import java.util.Scanner;
//import java.util.Scanner.*;
import java.io.*;

public class Homework01 {
	public static final String FILE = "./prizeList.txt";
	public static final String DELIM = "\t";
	public static final int SIZE = 5;
	public static int[] pPrize = new int[SIZE];
	public static String[] nPrize = new String[SIZE];

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean end = false;
		int wordcount = 0;
		try { // THIS CODE NEEDS TO BE IN A TRY AND A CATCH OR ELSE THE SYSTEM WILL NOT RUN.
				// also, wordcount needs to be
			wordcount = readFile(FILE); // initialized outside of the try/catch so the rest of the method can access it.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] list = makeList(wordcount, FILE); // all methods with returns MUST be initialized here.
		while (!end) { // this is because not doing so basically tells the system "call the method
						// to....?"
			String prize[] = chosePrize(list); // must define what the method DOES
			System.out.println("Welcome to the showcase showdown \nyour prizes are:\n");
			splitPrize(prize);

			System.out.println("\nEnter your guess");
			int guess = keyboard.nextInt();
			int price = 0;
			for (int i = 0; i < SIZE; i++) {
				price += pPrize[i];
			}
			if (guess <= price && guess >= price - 1300) {
				System.out.println("the actual price was " + price + ". You win");
			} else if (guess > price)
				System.out.println("the actual price was " + price + ". you went over");
			else
				System.out.println("The actual price was " + price + ". you are under ");

			boolean valid = false;
			keyboard.nextLine();
			while (!valid) {
				System.out.println();
				System.out.println("would you like to play again? \nIf so, type yes. \nIf not, type no");
				String choice = keyboard.nextLine();
				if (choice.equalsIgnoreCase("yes")) {
					valid = true;
				} else if (choice.equalsIgnoreCase("no")) {
					keyboard.close();
					end = true;
					valid = true;
					System.exit(0);
				} else {
					System.out.println("Invalid input;");
					valid = false;
					end = false;
				}
			}
		}

	}

	public static int readFile(String File) throws IOException {
		int wordCount = 0; // every method (except the main) does one thing. this is to compartmentalize
							// the code
		try { // and turn one big project into many small ones. If there is an error, it is
				// easier to find where it is
			Scanner fileScanner = new Scanner(new File(File));
			while (fileScanner.hasNextLine()) {
				fileScanner.nextLine();
				wordCount++;
			}

		} catch (IOException e) {
			System.out.println(e);
		}
		return wordCount;
	}

	public static String[] makeList(int wordCount, String File) {
		// wordCount = readFile(FILE);
		String[] list = new String[wordCount];
		try {
			Scanner fileScanner = new Scanner(new File(File));
			for (int i = 0; i < wordCount; i++) {
				list[i] = fileScanner.nextLine();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return list;
	}

	public static String[] chosePrize(String[] list) {
		// makeList();
		String[] prize = new String[SIZE];
		boolean[] chosen = new boolean[list.length];
		// String fileLine = fileScanner.nextLine();
		// String[] splitLine = Prize[1].split(DELIM);
		Random r = new Random();
		int count = 0;
		while (count < SIZE) { // this while loop goes until count is 5. count only increases when the if
								// statement is true
			int random = r.nextInt(list.length); // this ensures that there will always be 5 unique correctly formated
													// prizes
			String posPrize = list[random];
			String[] splitLine = posPrize.split(DELIM);
			if (splitLine.length == 2 && !chosen[random]) {
				prize[count] = posPrize;
				chosen[random] = true;
				count++;
			}
		}
		return prize;
	}

	public static void splitPrize(String[] prize) {// this method MUST return null. this is because
		for (int i = 0; i < SIZE; i++) { // both nPrize and pPrize must be filled via this array and a method can't have
											// two return types
			String[] splitLine = prize[i].split(DELIM);
			nPrize[i] = splitLine[0];
			pPrize[i] = Integer.parseInt(splitLine[1]);
			System.out.println(nPrize[i]);
		}
	}
}
