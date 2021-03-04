

/*
 * CIS 2122
 * 02/09/2020
 * Jeremy L. Shepherd
 * Array Calculator
 * A menu driven console program that takes in user input to 
 * calculate basic math functions of 2 arrays of numbers and return a calculation.
 * Also generate a random number array based on a range of numbers.
 * Using methods to present cleaner code.
 */

import java.util.Arrays;
import java.util.Scanner;

public class ShepherdJeremyArrayCalculator  {
	
	static Scanner input = new Scanner(System.in);
	
	
	//Display menu
	public static void displayMenu() {
		System.out.println("Calculator Menu");
		System.out.println("1. Add");
		System.out.println("2. Subtract");
		System.out.println("3. Multiply");
		System.out.println("4. Divide");
		System.out.println("5. Dot Product");
		System.out.println("6. Generate Random Number");
		System.out.println("7. Quit");
		System.out.print("What would you like to do? ");
	}
	
	//Get menu method
	public static int getMenuOption() {
		int choice;
		
		displayMenu();
		choice = input.nextInt();
		while(choice < 1 || choice > 7)
		{
			System.out.println("I'm sorry, " + choice + " wasn't one of the options");
			System.out.print("Please select a valid option: ");
			choice = input.nextInt();
		}
		
		return choice;
	}
	
	//Get Operand method
	public static double getOperand(String message) {		
		double num;
		
		System.out.print(message);
		num = input.nextDouble();
		return num;
	}
	
	//Overloaded Get Operand method
	public static double[] getOperand(String message, int size) {		
		double[] nums = new double[size];
		
		System.out.print(message);
		for(int i = 0; i < size; i++) {
			nums[i] = input.nextDouble();
		}
		return nums;
	}
	
	//Addition method
	public static double[] add(double[] operand1, double[] operand2) {
		double[] result = new double[operand1.length];
		for(int i = 0; i < operand1.length; i++) {
			result[i] = operand1[i] + operand2[i];
		}
		return result;
	}
	
	//Subtraction method
	public static double[] subtract(double[] operand1, double[] operand2) {
		double[] result = new double[operand1.length];
		for(int i = 0; i < operand1.length; i++) {
			result[i] = operand1[i] - operand2[i];
		}
		return result;
	}
	
	//Multiplication method
	public static double[] multiply(double[] operand1, double[] operand2) {
		double[] result = new double[operand1.length];
		for(int i = 0; i < operand1.length; i++) {
			result[i] = operand1[i] * operand2[i];
		}
		return result;
	}
	
	//Division method
	public static double[] divide(double[] operand1, double[] operand2) {
		double[] result = new double[operand1.length];
		double val;
		for(int i = 0; i < operand1.length; i++) {
			val = operand2[i] == 0.0 ? Double.NaN: operand1[i] / operand2[i];
			result[i] = val;
		}
		return result;
	}
	
	//Random number generation method
	public static double[] random(double lowerLimit, double upperLimit, int size) {		
		double[] result = new double[size];
		for(int i = 0 ; i < size; i++) {
			double randomVal = Math.random();
			result[i] = randomVal * upperLimit + lowerLimit;
		}
		return result;
	}	
	
	//Dot Product
	public static double[] dotProduct(double[] operand1, double[] operand2) {		
		double[] result = new double[1];
		for(int i = 0; i < operand1.length; i++) {
			result[0] += operand1[i] * operand2[i];
		}
		return result;
	}
		
	//Primary function
	public static void main(String[] args) {
		
		double num1 = 0, num2 = 0;
		double[] nums1, nums2, result;
		int size;
		int menuChoice;
		
		menuChoice = getMenuOption();
		
		while(menuChoice != 7) {
			
			if(menuChoice == 6) {
				System.out.print("How many values should be in random array? ");
			} else {
				System.out.print("How many values are in the arrays? ");
			}
			size = input.nextInt();
			
			//Initialize to prevent compiler errors
			nums1 = new double[size];
			nums2 = new double[size];
			result = new double[size];
			
			//Eliminated repeated calls to getNum by employing ternary for different input message
			String message1 = menuChoice == 6 ? "What is the lower limit? " : "Enter the values in the first array, separated by spaces: ";
			String message2 = menuChoice == 6 ? "What is the upper limit? " : "Enter the values in the second array, separated by spaces: ";
			
			//Only get input if needed
			if(menuChoice >= 1 && menuChoice <= 5) {
				nums1 = getOperand(message1, size);
				nums2 = getOperand(message2, size);
			}
			
			if(menuChoice == 6) {
				num1 = getOperand(message1);
				num2 = getOperand(message2);
			}
			
			switch(menuChoice) {
				case 1:
					result = add(nums1, nums2);
					break;
				case 2:
					result = subtract(nums1, nums2);
					break;
				case 3:
					result = multiply(nums1, nums2);
					break;
				case 4:
					result = divide(nums1, nums2);
					break;
				case 5:
					result = dotProduct(nums1, nums2);	
					break;
				case 6:
					result = random(num1, num2, size);
			}
			
			//refactored answer output to single line
			if(menuChoice == 5) {
				System.out.println("The result is: " + result[0]);
			} else {
				System.out.println("The result is: " + Arrays.toString(result));
			}
			System.out.println("");
			menuChoice = getMenuOption();
		}			
		
		input.close();
		System.out.println("Thank you for using Shepherd's Calculator!");
		System.out.println("Goodbye!");
	}
}

