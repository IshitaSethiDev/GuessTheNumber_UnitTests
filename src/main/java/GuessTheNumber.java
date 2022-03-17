import java.util.Scanner;

public class GuessTheNumber {
    static final int firstNumber = 1;
    static final int secondNumber = 20;
    static final String setBold = "\033[0;1m";
    static final String setPlain = "\033[0;0m";
    static final String correctGuess = "yes";

    public static void main(String[] args) {
        boolean playAgain = true;

        GuessTheNumber guessObj = new GuessTheNumber();
        Scanner scannerObj = new Scanner(System.in);

        String name = guessObj.getName(scannerObj);

        while (playAgain) {
            System.out.println("......................");
            System.out.println("Well, " + setBold + name + setPlain + ", I am thinking of a number between 1 and 20. Take a guess. You have 6 tries. Enjoy!" + "\n");

            int systemGuessNum = guessObj.randomNum(secondNumber, firstNumber);

            for (int i = 1; i <= 6; i++) {
                try {
                    int playerGuessNum = guessObj.getPlayerNumber(scannerObj);
                    String outputMessage = guessObj.checkUserInput(systemGuessNum, playerGuessNum);

                    if (outputMessage.equals(correctGuess)) {
                        System.out.println("You guessed my number in " + i + " guesses!" + "\n");
                        break;
                    }
                    System.out.println(outputMessage);

                    if (i == 6 && !outputMessage.equals(correctGuess)) {
                        System.out.println("You couldn't guess my number this time...Better luck next time..........!!!" + "\n");
                    }
                }
                catch(Exception e){
                    System.out.println("Please input number between 1 and 20" + "\n");
                }
            }
            playAgain = guessObj.playAgain(scannerObj);
        }
    }


    /**
     * Logic for calculating system generated random number
     */
    public int randomNum(int secondNum, int firstNum) {
        int storeVal = (secondNum - firstNum) + 2;
        double randomNumDouble = Math.floor((Math.random()) * storeVal);
        int systemGuessNum = (int) randomNumDouble;
        return systemGuessNum;
    }

    /**
     * Logic to check if the user input is the same as system generated random number
     */
    public String checkUserInput(int systemGuessNum, int guessInput) {
        String output = "";
        if (guessInput == systemGuessNum) {
            output= correctGuess;
        }
        else if (guessInput > 20 || guessInput < 1) {
            output = "Please enter a number between 1 and 20";
        }
        else if (guessInput > systemGuessNum) {
            output = setBold + guessInput + setPlain + " is higher than the number of my choice." + "\n";
        }
        else {
            output = setBold + guessInput + setPlain + " is lower than the number of my choice" + "\n";
        }
        return output;
    }

    /**
     * If the user doesn't wish to continue playing the playAgain is set to false hence exiting the while loop.
     */
    public boolean playAgain( Scanner input){
        System.out.println("Would you like to play again?" + setBold + "(y or n)" + setPlain);
        String playAgainAnswer = input.next();
        if (!playAgainAnswer.equals("y")) {
            return false;
        }
        return true;
    }

    /**
     * Get Name of User from terminal using Scanner
     */
    public String getName(Scanner input){
        System.out.println("What is your Name?");
        String nameInput = input.next();
        return nameInput;
    }

    /**
     * Get player choice number using Scanner
     */
    public int getPlayerNumber(Scanner input){
        String guessInputString = input.next();
        int guessInput = Integer.parseInt(guessInputString);
        return guessInput;
    }
}