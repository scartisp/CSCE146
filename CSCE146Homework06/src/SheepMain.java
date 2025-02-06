
//Simion Cartis
import java.util.*;
import java.io.*;

public class SheepMain {
	public static Scanner keyboard = new Scanner(System.in);
	public static Scanner fileScanner;
	public static String delim = "\t";
	public static final int SIZE = 3;
	public static SheepScheduler scheduler = new SheepScheduler();

	public static void main(String[] args) {
		boolean end = false;
		while (!end) {
			System.out.println("Welcome to the sheep shearing scheduler");
			Sheep[] validSheep = readFile();
			quickSort(validSheep);

			int count = 0;
			int currSheep = 0;
			while (true) {
				System.out.println("MINUTE " + count);// there are sheep that arrive at the same time, meaning this
														// needs to continue for as long as count is the same as a
														// sheep's arrival time
				while (currSheep < validSheep.length && count == validSheep[currSheep].getaTime()) {
					System.out.println("-----------------------------ADDING SHEEP-----------------------------\n"
							+ validSheep[currSheep]);
					scheduler.addSheep(validSheep[currSheep]);
					currSheep++;
				}
				if (scheduler.isDone()) {
					System.out.println("\nALL SHEEP HAVE BEEN SHEARED");
					break;
				}
				System.out.println("Currently sheering: " + scheduler.getCurrentSheep() + "\n");
				scheduler.advanceOneMin();
				count++;
			}

			System.out.println("END OF SIMULATION. \nWould you like to go again?");
			while (true) {
				String choice = keyboard.nextLine();
				if (choice.equalsIgnoreCase("yes")) {
					end = false;
					break;
				} else if (choice.equalsIgnoreCase("no")) {
					end = true;
					System.exit(0);
				} else {
					System.out.println("invalid input");
				}
			}
		}
	}

	public static Sheep[] readFile() {
		System.out.println("enter the desired file's name: ");
		String fileN = keyboard.nextLine();
		int valid = 0;
		try {
			fileScanner = new Scanner(new File(fileN));
			while (fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(delim);
				if (splitLines.length == SIZE) {
					valid++;// get the needed size of the array, then add items to the array after.
				}
			}
			fileScanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Sheep[] validSheep = new Sheep[valid];
		int count = 0;
		try {
			fileScanner = new Scanner(new File(fileN));
			while (fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(delim);
				if (splitLines.length == SIZE) {
					String sheepN = splitLines[0];
					int shearT = Integer.parseInt(splitLines[1]);
					int arrivalT = Integer.parseInt(splitLines[2]);
					Sheep s = new Sheep(sheepN, shearT, arrivalT);
					validSheep[count] = s;//needs to then add to an array, whose elements will be gradually addded to 
				}//the heap.
				count++;
			}
			fileScanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validSheep;
	}

	public static void quickSort(Sheep[] validSheep) {//need to organize array by ARRIVAL TIME
		quickSort(validSheep, 0, validSheep.length - 1);
	}

	public static void quickSort(Sheep[] validSheep, int start, int end) {
		if (start >= end)
			return;
		int pivot = partition(validSheep, start, end);
		quickSort(validSheep, start, pivot - 1);
		quickSort(validSheep, pivot + 1, end);
	}

	public static int partition(Sheep[] validSheep, int start, int end) {
		int pivot = validSheep[end].getaTime();
		int i = start;
		for (int j = start; j <= end; j++) {
			if (validSheep[j].getaTime() < pivot) {
				Sheep temp = validSheep[i];
				validSheep[i] = validSheep[j];
				validSheep[j] = temp;
				i++;
			}
		}
		Sheep temp = validSheep[i];
		validSheep[i] = validSheep[end];
		validSheep[end] = temp;
		return i;
	}
}
