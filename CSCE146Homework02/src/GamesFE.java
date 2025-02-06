
//Simion Cartis
import java.util.*;	
import java.io.*;

public class GamesFE {
	public static Scanner keyboard = new Scanner(System.in);
	public static Scanner FileScanner;
	public static GamesList gList;
	public static GamesList results = new GamesList(); //have to make two seperate lists
	public static final String DELIM = "\t"; //as you're reading from the original list and printing to the new one
	public static final int AMT = 2;
	public static GameItems g;

	public static void main(String[] args) {
		boolean end = false;
		while (!end) {
			System.out.println("Enter 1 to load the videogame database \nEnter 2 to search the Database"
					+ " \nEnter 3 to print current results to the console\nEnter 4 to print current results to a file"
					+ "\nEnter 9 to quit");
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			switch (choice) {
			case 1:
				loadDatabase();
				break;
			case 2:
				search();
				break;
			case 3:
				results.print();
				break;
			case 4:
				printToFile();
				break;
			case 9:
				end = true;
				System.exit(0);
			default:
				System.out.println("invalid input");
			}
		}
	}

	public static void loadDatabase() {
		gList = new GamesList();
		System.out.println("Enter the file name");
		String fileName = keyboard.nextLine();
		try {
			FileScanner = new Scanner(new File(fileName));
			while (FileScanner.hasNextLine()) {
				System.out.println("file is being read");
				String fileLine = FileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if (splitLines.length == AMT) {
					String gameN = splitLines[0];
					String consoleN = splitLines[1];
					g = new GameItems(gameN, consoleN);//can use the GameItems class to make instance variables
					gList.add(g); //which are then stored in the LIST
				}
			}
			gList.print();
			FileScanner.close();;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void search() {

		System.out.println("Enter the name of the game (or '*' for all)");
		String game = keyboard.next();
		System.out.println("Enter the name of the console (or '*' for all)");
		String console = keyboard.next();

		results.clear(); //have to clear the results list so that it won't just add to anything that was previously there
		gList.reset(); //have to reset the gList in order to read from the top
		for (int i = 0; i < gList.getSize(); i++) {
			GameItems currentGame = gList.getCurrent(); // have to use .getName and .getConsole to check ONLY the game/console's name
			boolean matchGame = (game.equals("*") || currentGame.getName().toString().toLowerCase().contains(game.toLowerCase()));
			boolean matchConsole = (console.equals("*")
					|| currentGame.getConsole().toString().toLowerCase().contains(console.toLowerCase()));

			if (matchGame && matchConsole) {
				results.add(currentGame);
			}
			gList.gotoNext();
		}
		results.print();
	}

	public static void printToFile() {
		boolean appendV = false;
		System.out.println("What would you like to name the file?");
		String NewFileName = keyboard.nextLine();
		while (!appendV) {
			System.out.println("would you like to append? yes or no");
			String append = keyboard.nextLine();
			if (append.equalsIgnoreCase("yes")) {
				try {
					PrintWriter writerAppend = new PrintWriter(new FileWriter(NewFileName, true));
					results.reset();
					for (int i = 0; i < results.getSize(); i++) {
						writerAppend.println(results.getCurrent().toString());
						results.gotoNext();
					}
					writerAppend.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				appendV = true;
			} else if (append.equalsIgnoreCase("no")) {
				try {
					PrintWriter writer = new PrintWriter(new FileWriter(NewFileName));
					results.reset();
					for (int i = 0; i < results.getSize(); i++) {
						writer.println(results.getCurrent().toString());
						results.gotoNext();
					}
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				appendV = true;
			} else
				System.out.println("Invalid input");
		}
	}
}
