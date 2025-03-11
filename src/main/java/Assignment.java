import java.util.*;

public class Assignment {

    // Configuration: length of secret code and number range
    static final int CODE_LENGTH = 4;
    static final int NUMBER_RANGE = 6; // Numbers from 1 to 6

    public static void main(String[] args) {
        int[] secretCode = generateSecretCode();
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Welcome to Mastermind!");
        System.out.println("Guess the secret " + CODE_LENGTH + "-digit code (numbers from 1 to " + NUMBER_RANGE + "):");

        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");
            String guessInput = scanner.nextLine();

            if (!isValidGuess(guessInput)) {
                System.out.println("Invalid guess. Make sure it has " + CODE_LENGTH + " digits, each between 1 and " + NUMBER_RANGE + ".");
                continue;
            }

            int[] guess = convertGuessToArray(guessInput);
            attempts++;

            int correctPositions = countCorrectPositions(secretCode, guess);
            int correctNumbers = countCorrectNumbers(secretCode, guess) - correctPositions;

            if (correctPositions == CODE_LENGTH) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the code in " + attempts + " attempts.");
            } else {
                System.out.println(correctPositions + " correct digit(s) in correct position.");
                System.out.println(correctNumbers + " correct digit(s) in wrong position.");
            }
        }

        scanner.close();
    }

    // Generates a random secret code
    static int[] generateSecretCode() {
        Random random = new Random();
        int[] code = new int[CODE_LENGTH];

        for (int i = 0; i < CODE_LENGTH; i++) {
            code[i] = random.nextInt(NUMBER_RANGE) + 1;
        }

        return code;
    }

    // Checks if guess is valid
    static boolean isValidGuess(String guess) {
        if (guess.length() != CODE_LENGTH) {
            return false;
        }

        for (char digit : guess.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false;
            }
            int value = Character.getNumericValue(digit);
            if (value < 1 || value >= NUMBER_RANGE) {
                return false;
            }
        }

        return true;
    }

    // Converts guess from String to int array
    static int[] convertGuessToArray(String guess) {
        int[] guessArray = new int[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            guessArray[i] = Character.getNumericValue(guess.charAt(i));
        }
        return guessArray;
    }

    // Counts how many digits are correct and in the correct positions
    static int countCorrectPositions(int[] code, int[] guess) {
        int count = 0;
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (code[i] == guess[i]) {
                count++;
            }
        }
        return count;
    }

    // Counts how many digits are correct, regardless of position
    static int countCorrectNumbers(int[] code, int[] guess) {
        int count = 0;
        int[] codeFreq = new int[NUMBER_RANGE + 1];
        int[] guessFreq = new int[NUMBER_RANGE + 1];

        for (int i = 0; i < CODE_LENGTH; i++) {
            codeFreq[code[i]]++;
            guessFreq[guess[i]]++;
        }

        for (int i = 0; i <= NUMBER_RANGE; i++) {
            count += Math.min(codeFreq[i], guessFreq[i]);
        }

        return count;
    }
}
