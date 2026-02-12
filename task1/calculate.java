import java.util.InputMismatchException;
import java.util.Scanner;

public class calculate {

	public static double add(double a, double b) {
		return a + b;
	}

	public static double subtract(double a, double b) {
		return a - b;
	}

	public static double multiply(double a, double b) {
		return a * b;
	}

	public static double divide(double a, double b) {
		return a / b;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nBasic Calculator");
			System.out.println("1) Addition");
			System.out.println("2) Subtraction");
			System.out.println("3) Multiplication");
			System.out.println("4) Division");
			System.out.println("5) Exit");
			System.out.print("Choose an option (1-5): ");

			int choice;
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number between 1 and 5.");
				scanner.nextLine();
				continue;
			}

			if (choice == 5) {
				System.out.println("Exiting. Goodbye!");
				break;
			}

			if (choice < 1 || choice > 5) {
				System.out.println("Please choose a valid option (1-5).");
				continue;
			}

			double x, y;
			try {
				System.out.print("Enter first number: ");
				x = scanner.nextDouble();
				System.out.print("Enter second number: ");
				y = scanner.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Invalid number. Please try again.");
				scanner.nextLine();
				continue;
			}

			double result = 0;
			boolean validOperation = true;

			switch (choice) {
				case 1:
					result = add(x, y);
					break;
				case 2:
					result = subtract(x, y);
					break;
				case 3:
					result = multiply(x, y);
					break;
				case 4:
					if (y == 0) {
						System.out.println("Error: Division by zero is not allowed.");
						validOperation = false;
					} else {
						result = divide(x, y);
					}
					break;
				default:
					validOperation = false;
					System.out.println("Unknown operation.");
			}

			if (validOperation) {
				System.out.printf("Result: %.6f\n", result);
			}
		}

		scanner.close();
	}
}

