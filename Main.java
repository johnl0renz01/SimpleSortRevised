import java.io.IOException;
import java.lang.Thread;
import java.util.*;

public class Main {

	public static float[] numberArray;
	public static float[] sortedArray;

	public static void output(float arr[], int counter) { 
		for (int i = 0; i < counter; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	public static void header() throws IOException, InterruptedException {
		new ProcessBuilder("clear").inheritIO().start().waitFor();
		System.out.println("PL-M1: ACT2 - Sorting 2");
		System.out.println("DELA CRUZ, JOHN LORENZ N.\n");
	}

	public static void ascendingSort(float arr[], int counter) {  
		sortedArray = new float[counter];
		for (int i = 0; i < counter; i++) {
			sortedArray[i] = arr[i];
		}

		for (int i = 1; i < sortedArray.length; i++) {
			float key = sortedArray[i];
			int j = i - 1;
			while (j >= 0 && sortedArray[j] > key) {
				sortedArray[j + 1] = sortedArray[j];
				j = j - 1;
			}
			sortedArray[j + 1] = key;
		}
	}  

	public static void descendingSort(float arr[], int counter) {
		sortedArray = new float[counter];
		for (int i = 0; i < counter; i++) {
			sortedArray[i] = arr[i];
		}

		for (int i = 1; i < sortedArray.length; i++) {
			float key = sortedArray[i];
			int j = i - 1;
			while (j >= 0 && sortedArray[j] < key) {
				sortedArray[j + 1] = sortedArray[j];
				j = j - 1;
			}
			sortedArray[j + 1] = key;
		}
	}  

	public static void pressEnterToContinue() { 
		System.out.println("\nPress \'Enter\' key to continue...");
		try {
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
		} catch(Exception e){}
	}

	public static void main(String[] args) throws IOException, InterruptedException{

		header();

		int counter = 0;
		int n = 0;
		boolean isInteger = false;


		System.out.print("No. of numbers: ");

		do {
			try {
				do {
					Scanner input = new Scanner(System.in);
					n = input.nextInt();
					if (n <= 0) {
						System.out.println("Invalid input. Please enter a positive number.");
						Thread.sleep(1250);
						header();
						System.out.print("No. of numbers: ");
					}
				} while (n <= 0);
				isInteger = true;
			} catch(InputMismatchException ex) {
				isInteger = false;
				System.out.println("Invalid input. Please enter a valid number.");
				Thread.sleep(1250);
				header();
				System.out.print("No. of numbers: ");
			}
		} while (!isInteger);
		numberArray = new float[n];

		do {
			float number = 0;
			boolean isFloat = false;
			System.out.print("Input " + (counter + 1) + "/" + n + " number: ");

			do {
				try {
					Scanner input = new Scanner(System.in);
					number = input.nextFloat();
					isFloat = true;
				} catch(InputMismatchException ex) {
					isFloat = false;
					System.out.println("Invalid input. Please enter a valid number.");
					Thread.sleep(1250);
					header();
					if (counter == 0) {
						System.out.println("No. of numbers: " + n);
					}
					System.out.print("Input " + (counter + 1) + "/" + n + " number: ");
				}
			} while (!isFloat);

			numberArray[counter] = number;
			counter ++;


			ascendingSort(numberArray, counter);
			System.out.print("Ascending Array: ");
			output(sortedArray, counter);

			descendingSort(numberArray, counter);
			System.out.print("Descending Array: ");
			output(sortedArray, counter);

			if (counter < n){
				pressEnterToContinue();
				header();
			}
		} while (counter < n);
	}
}