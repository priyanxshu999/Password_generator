import java.util.Random;
import java.util.Scanner;

public class passwdgen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the password: ");
        int length = sc.nextInt();
        String password = generatePassword(length);
        System.out.println("Your random password is: " + password);
        sc.close(); // Close the scanner to avoid resource leak
    }

    public static String generatePassword(int length) {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*_=+-/";
        String combinedChars = upperCaseLetters + lowerCaseLetters + numbers + specialCharacters;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length()));
        password[2] = numbers.charAt(random.nextInt(numbers.length()));
        password[3] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));

        for(int i = 4; i < length; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return String.valueOf(password);
    }
}
