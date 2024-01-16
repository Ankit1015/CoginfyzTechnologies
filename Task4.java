import java.security.SecureRandom;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the desired length of the password:");
        int passwordLength = scanner.nextInt();

        if (passwordLength <= 0) {
            System.out.println("Invalid password length. Please enter a positive integer.");
            return;
        }

        System.out.println("Include numbers? (y/n):");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");

        System.out.println("Include lowercase letters? (y/n):");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("y");

        System.out.println("Include uppercase letters? (y/n):");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.println("Include special characters? (y/n):");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("y");

        String password = generateRandomPassword(passwordLength, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);

        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    public static String generateRandomPassword(int length, boolean includeNumbers, boolean includeLowercase,
                                                boolean includeUppercase, boolean includeSpecialChars) {
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";

        StringBuilder validChars = new StringBuilder();

        if (includeLowercase) {
            validChars.append(lowercaseChars);
        }
        if (includeUppercase) {
            validChars.append(uppercaseChars);
        }
        if (includeNumbers) {
            validChars.append(numberChars);
        }
        if (includeSpecialChars) {
            validChars.append(specialChars);
        }

        if (validChars.length() == 0) {
            System.out.println("You must include at least one type of character.");
            System.exit(0);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }
}