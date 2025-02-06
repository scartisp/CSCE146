
//Simion Cartis
import java.util.*;
import java.io.*;

public class RobotMain {

	public static Scanner keyboard = new Scanner(System.in);
	public static Scanner fileScanner;
	public static char[][] board;
	public static RobotQueueImplement RobotQueue = new RobotQueueImplement();

	public static final char ROBOT = 'O';
	public static final char SPACE = '_';
	public static final int BOARD_SIZE = 10;// all boards are 10*10

	public static void main(String[] args) {

		System.out.println("welcome to the robot simulator");
		boolean end = false;
		while (!end) {
			RobotQueue.clear();
			System.out.println("enter the board file");
			String boardName = keyboard.nextLine();
			System.out.println("enter the command file");
			String commandName = keyboard.nextLine();
			makeBoard(boardName);
			readCommand(commandName, RobotQueue);
			
			boolean valid = false;
			while (!valid) {
				System.out.println("Would you like to play again?");
				String choice = keyboard.nextLine();
				if (choice.equalsIgnoreCase("no")) {
					System.exit(0);
					valid = true;
				}
				else if (choice.equals("yes")) {
					valid =true;
				}
				else {
					System.out.println("invalid answer");
				}
			}
		}
	}

	public static void makeBoard(String boardName) {
		int num1 = 0;
		int num2 = 0;
		try {
			fileScanner = new Scanner(new File(boardName));
			int yAxis = 0;
			while (fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();
				num1++;
				num2 = fileLine.length();
			}
			fileScanner.close();
			board = new char[num1][num2];
			fileScanner = new Scanner(new File(boardName));
			int row = 0;
			while (fileScanner.hasNext()) {
				String fileLine = fileScanner.nextLine();
				for (int i = 0; i < num2; i++) {
					board[row][i] = fileLine.charAt(i);
				}
				row++;
			}
			fileScanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readCommand(String commandName, RobotQueueImplement RobotQueue) {
		try {
			fileScanner = new Scanner(new File(commandName));
			while (fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();
				Moves m = new Moves(fileLine);
				if (fileLine.equalsIgnoreCase("move up") || fileLine.equalsIgnoreCase("move down")
						|| fileLine.equalsIgnoreCase("move left") || fileLine.equalsIgnoreCase("move right")) {
					RobotQueue.addMove(m);
				}
			}
			fileScanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		moveR();
	}

	public static void moveR() {
		board[0][0] = ROBOT;
		int x = 0;
		int y = 0;
		int rep = 0;
		while (!end(x, y) || !finishLine(x, y)) {
			if (rep == 0)
				showBoard(board);

			int newX = x;
			int newY = y;
			RobotQueue.runNext();
			Moves currentM = RobotQueue.getCurrentM();

			if (currentM.toString().equalsIgnoreCase("Move Up")) {
				newY--;// update a place holder instead of the actual y and x, that way, you can make the original
			} else if (currentM.toString().equalsIgnoreCase("Move Down")) {//spot a space, THEN update y and x
				newY++; //with the placeholder values, THEN place robot on new spot
			} else if (currentM.toString().equalsIgnoreCase("Move Right")) {
				newX++;
			} else if (currentM.toString().equalsIgnoreCase("Move Left")) {
				newX--;
			}
			
			System.out.println("command " + rep);
			if (end(newX, newY)) {
				System.out.println("CRASH.\nyou lost");
				break;
			} else if (finishLine(newX, newY)) {
				board[y][x] = SPACE;
				x = newX;
				y = newY;
				board[y][x] = ROBOT;// flip the x and y's as the first dimension is vertical values
				showBoard(board);
				System.out.println("you've reached the end!");
				break;
			}
			board[y][x] = SPACE;
			x = newX;
			y = newY;
			board[y][x] = ROBOT;
			showBoard(board);
			rep++;
		}
	}

	public static boolean end(int x, int y) {
		if (board[y][x] == 'X' || x >= 10 || x < 0 || y >= 10 || y < 0) {
			return true;
		} else
			return false;
	}
	//a different method needs to be written for if there are no commands left, as that is the desired outcome
	public static boolean finishLine(int x, int y) {
		if (RobotQueue.showFirst() == null)
			return true;
		return false;
	}
	
	public static void showBoard(char[][] board) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
