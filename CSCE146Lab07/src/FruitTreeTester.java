
//Simion Cartis
import java.util.*;
import java.io.*;

public class FruitTreeTester {

	public static Scanner fileScanner;
	public static Scanner keyboard = new Scanner(System.in);
	public static String delim = "\t";
	public static int amt = 2;

	public static LinkedBST<Fruit> fruitBST = new LinkedBST<Fruit>();
	public static Fruit f;

	public static void main(String[] args) {
		System.out.println("Welcome to the fruit tree! \nPlease enter a file name.");
		String fileN = keyboard.nextLine();
		System.out.println("populating fruit tree");
		readF(fileN);

		System.out.println("Printing the in-order traversal:\n");
		fruitBST.printInOrder();
		System.out.println("\n Printing the pre-order traversal:\n");
		fruitBST.printPreOrder();
		System.out.println("\n Printing the post-order traversal:\n");
		fruitBST.printPostOrder();

		Fruit removeF = new Fruit("Apple", 0.4859853412170728);
		System.out.println("\n deleting " + removeF.toString());
		fruitBST.remove(removeF);
		System.out.println("\n Printing the in-order traversal:\n");
		fruitBST.printInOrder();
	}

	public static void readF(String fileN) {
		try {
			fileScanner = new Scanner(new File(fileN));
			while (fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();
				String[] splitLine = fileLine.split(delim);
				if (splitLine.length == amt) {
					String fruitT = splitLine[0];
					double fruitW = Double.parseDouble(splitLine[1]);
					f = new Fruit(fruitT, fruitW);
					fruitBST.add(f);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
