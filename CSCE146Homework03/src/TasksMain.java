
//Simion Cartis
import java.util.*;
import java.io.*;

public class TasksMain {
	public static Scanner keyboard = new Scanner(System.in);

	public static TaskLL[] taskLists = new TaskLL[5]; // this initializes the array of LL
	public static TaskItems t;// I later fill in the array in the main method using a for loop

	public static String DELIM = "\t";
	public static int AMT = 2;

	public static void main(String[] args) {
		for (int i = 0; i < taskLists.length; i++)
			taskLists[i] = new TaskLL(); // need to fill in the array here so that I can add things to the
// linked lists without needing to read from a file
		System.out.println("Welcome to the task organizer\n");

		boolean end = false;
		while (!end) {
			System.out.println("Enter 1 to add a task\n" + "enter 2 to remove a task\n"
					+ "enter 3 to print tasks to the console\n" + "enter 4 to read from a task file\n"
					+ "enter 5 to write to a task file\n" + "enter 9 to quit");
			int choice = keyboard.nextInt();
			switch (choice) {
			case 1:
				addT();
				break;
			case 2:
				removeT();
				break;
			case 3:
				for (int i = 0; i < taskLists.length; i++) {
					taskLists[i].print();
				}
				taskLists[1].reset();
				keyboard.nextLine();
				break;
			case 4:
				readFile();
				break;
			case 5:
				print2File();
				break;
			case 9:
				end = true;
				System.exit(0);
			default:
				System.out.println("invalid input\n");
			}
		}
	}

	public static void readFile() {

		keyboard.nextLine();
		System.out.println("Enter the file name");
		String fileName = keyboard.nextLine();
		try {
			Scanner FileScanner = new Scanner(new File(fileName));
			while (FileScanner.hasNextLine()) {
				String fileLine = FileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if (splitLines.length == AMT) {
					int taskP = Integer.parseInt(splitLines[0]);
					String taskN = splitLines[1];
					t = new TaskItems(taskP, taskN);

					boolean correctP = false;
					while (!correctP) {
						for (int i = 0; i < taskLists.length; i++) {// checks to see if priority matches
							if (taskP == i) { // with the array value of a given linked list
								taskLists[i].add(t);
								correctP = true;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void addT() {
		enterT();
		boolean correctP = false;
		while (!correctP) {
			for (int i = 0; i < taskLists.length; i++) {
				if (t.getPriority() == i) {
					if (taskLists[i].containsInList(t)) {
						System.out.println("task already exists in list and will not be added");
						correctP = true;
						break;
					}
					taskLists[i].add(t);
					correctP = true;
				}
			}
		}
	}

	public static void removeT() {
		enterT();
		boolean correctP = false;
		while (!correctP) {
			for (int i = 0; i < taskLists.length; i++) {
				if (t.getPriority() == i) {
					taskLists[i].reset();
					while (taskLists[i].hasNext() && !taskLists[i].contains(t)) {// moves through list
						taskLists[i].gotoNext();// until it finds the correct task or it reaches the end
					}
					if (!taskLists[i].hasNext() && !taskLists[i].contains(t)) {
						System.out.println("Item cannot be found in list");
						correctP = true;
					} else {
						System.out.println("removing " + taskLists[i].getCurrent().getName());
						taskLists[i].removeCurrent();
						correctP = true;
					}
				}
			}
		}
	}

	public static void print2File() {
		keyboard.nextLine();
		System.out.println("Enter the file name");
		String newFName = keyboard.nextLine();

		try {
			PrintWriter writer = new PrintWriter(new FileWriter(newFName));
			for (int i = 0; i < taskLists.length; i++) {
				taskLists[i].reset();
				if (taskLists[i].getSize() == 0)// ensures that java does't try to get the size of something
					System.out.println("list " + i + " is empty");// that does not exist
				else {
					for (int j = 0; j < taskLists[i].getSize(); j++) {
						writer.println(taskLists[i].getCurrent().toString());
						taskLists[i].gotoNext();
					}
				}
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static TaskItems enterT() {
		System.out.println("enter the task's priority");
		int newP = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("Enter the task's name");
		String newN = keyboard.nextLine();
		t = new TaskItems(newP, newN);
		return t;
	}
}