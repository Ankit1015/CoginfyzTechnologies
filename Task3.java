import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of grades:");
        int numberOfGrades = scanner.nextInt();

        if (numberOfGrades <= 0) {
            System.out.println("Invalid number of grades. Please enter a positive integer.");
            return;
        }

        double sum = 0;

        for (int i = 1; i <= numberOfGrades; i++) {
            System.out.println("Enter grade " + i + ":");
            double grade = scanner.nextDouble();

            // Add the grade to the sum
            sum += grade;
        }

        // Calculate the average
        double average = sum / numberOfGrades;

        System.out.println("The average grade is: " + average);

        scanner.close();
    }
}
