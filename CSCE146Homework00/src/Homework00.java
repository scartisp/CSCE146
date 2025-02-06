
/*
 * Simion Cartis
 */
import java.util.Scanner;
import java.lang.Math;
public class Homework00 {
	public static final Scanner KEYBOARD = new Scanner(System.in);

	public static void main(String[] args) {
		boolean end = false;
		while (!end) {
			System.out.println("Enter 1 to add two vectors \nEnter 2 to subtract two vectors \nEnter 3 to "
					+ "find the magnitude of a vector\nEnter 9 to quit");
			int choice = KEYBOARD.nextInt();

			if (choice == 9)
				end = true;
			else if (choice == 1) {
				System.out.println("enter the size of the vectors: ");
				int size = KEYBOARD.nextInt();
				if (size >= 1) {
					System.out.println("Enter the values for vector 1");
					double vector1[] = array(size); // use one vectorCreate method, assign x amount of values to another array
					System.out.println("Enter the values for vector 2"); // that is created in the main method and calls on
					double vector2[] = array(size); // the array making method to do so. Repeatable because vectorCreate assigns indexes to num,
					arrayAdd(vector1, vector2, size); // those numbers are then placed into vector1/2, and vectorCreate indexes can be overwritten
				} else
					System.out.println("invalid input");
			} else if (choice == 2) {
				System.out.println("enter the size of the vectors: ");
				int size = KEYBOARD.nextInt();
				if (size >= 1) {
					System.out.println("Enter the values for vector 1");
					double vector1[] = array(size); // can reuse vector 1 and 2 because it refills the array/array size via new inputs
					System.out.println("Enter the values for vactor 2");
					double vector2[] = array(size);
					arraySub(vector1, vector2, size); // calls on and executes the arraySub method where the new vector is printed
				}else
					System.out.println("invalid input");
			} else if (choice == 3) {
				System.out.println("Enter the size for the vector");
				int size = KEYBOARD.nextInt();
				if (size >= 1) {
					double vector1[] = array(size);
					mag(vector1, size);
				} else //this ensures that even if the user puts in an invalid size, the program will still run correctly
					System.out.println("invalid input");
			} else
				System.out.println("invalid input"); //insures that program will always do something even if the user inserts a wrong input
		}
	}

	public static double[] array(int size) {
		double vectorCreate[] = new double[size];

		for (int i = 0; i < vectorCreate.length; i++) {
			System.out.println("enter value " + (i + 1));
			vectorCreate[i] = KEYBOARD.nextDouble();
		}
		return vectorCreate;
	}

	public static double[] arrayAdd(double[] vector1, double[] vector2, int size) {	
		// int size = vector1.length;
		double vectorAdd[] = new double[size];

		for (int i = 0; i < vectorAdd.length; i++) {
			vectorAdd[i] = vector1[i] + vector2[i];
			System.out.println(vectorAdd[i]);
		}
		return vectorAdd;

	}
	
	public static double[] arraySub(double[] vector1, double[] vector2, int size) {
		double vectorSub[] = new double[size];
		
		for(int i= 0; i< vectorSub.length;i++) {
			vectorSub[i] = vector1[i] - vector2[i];
			System.out.println(vectorSub[i]);
		}
		return vectorSub;
	}
	
	public static double mag(double[] vector1, int size) {
		double magnitude = 0; 
		for(int i=0; i<vector1.length; i++) {
			magnitude += vector1[i]*vector1[i];
		}
		magnitude = Math.sqrt(magnitude);
		System.out.println(magnitude);
		return magnitude;
		
	}
}