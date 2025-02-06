
//Simion Cartis
import java.util.Scanner;

public class SortMain {
	public static Scanner keyboard = new Scanner(System.in);
	public static SortLL sList = new SortLL();

	public static void main(String[] args) {
		boolean end = false;
		while (!end) {
			sList.clear();
			System.out.println("Enter any number of strings and I will sort by the number of "
					+ "\"sorts\" found in them.\nWhen finished, enter \"quit\" ");
			Sort userN = new Sort(keyboard.nextLine());
			while (!userN.equals("quit")) {
				sList.add(userN);
				userN = new Sort(keyboard.nextLine());
			}
			Sort[] sortA = new Sort[sList.getSize()];// creates an array from the linked list as I want random
			for (int i = 0; i < sortA.length; i++) {// access while also not needing to specify initial size
				sortA[i] = sList.getCurrent();
				sList.gotoNext();
			}
			quickSort(sortA);// I am sorting the array instead of the LL because the array gives me random access
			for (int i = 0; i < sortA.length; i++) {
				System.out.println(sortA[i]);
			}
			boolean valid = false;
			while (!valid) {
				System.out.println("would you like to play again?");
				String choice = keyboard.nextLine();
				if (choice.equalsIgnoreCase("yes")) {
					valid = true;
				} else if (choice.equalsIgnoreCase("no")) {
					valid = true;
					System.exit(0);
				} else
					System.out.println("invalid answer");
			}
		}

	}

	public static void quickSort(Sort[] sortA) {
		quickSort(sortA, 0, sortA.length - 1);
	}

	public static void quickSort(Sort[] sortA, int start, int end) {
		if (start >= end)
			return;
		int pivot = partition(sortA, start, end);
		quickSort(sortA, start, pivot - 1);
		quickSort(sortA, pivot + 1, end);
	}

	public static int partition(Sort[] sortA, int start, int end) {
		int pivot = sortA[end].numOfSort();
		int i = start;
		for (int j = start; j <= end; j++) {
			if (sortA[j].numOfSort() < pivot) {// needs to sort by number of times "sort" is found
				Sort temp = sortA[i];// meaning need to check the return value for numofSort
				sortA[i] = sortA[j];
				sortA[j] = temp;
				i++;
			}
		}
		Sort temp = sortA[i];
		sortA[i] = sortA[end];
		sortA[end] = temp;
		return i;
	}
}
