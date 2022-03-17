import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class GuessTheNumberTest {
    static final String setBold = "\033[0;1m";
    static final String setPlain = "\033[0;0m";
    GuessTheNumber guessObj = new GuessTheNumber();

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Firing up unit tests");
    }

    @BeforeEach
    void nextTest() {
        System.out.println("Running Next Unit test........");
    }

    @Test
    void checkUserInputTest(){
        assertAll("Test Props",
                () -> assertEquals("yes", guessObj.checkUserInput(1, 1), "Output Matching the System Guessed Number"),
                () -> assertEquals("yes", guessObj.checkUserInput(20, 20), "Output Matching the System Guessed Number"),
                () ->assertEquals("Please enter a number between 1 and 20", guessObj.checkUserInput(20, 30), "User entered wrong Number One"),
                () ->assertEquals("Please enter a number between 1 and 20", guessObj.checkUserInput(15, 0), "User entered wrong Number Two"),
                () ->assertEquals("Please enter a number between 1 and 20", guessObj.checkUserInput(10, -5), "User entered wrong Number Three"),
                () ->assertEquals(setBold + 15 + setPlain + " is higher than the number of my choice." + "\n", guessObj.checkUserInput(10, 15),  "Guess Input number One is higher than System generated Number"),
                () ->assertEquals(setBold + 5 + setPlain + " is lower than the number of my choice" + "\n", guessObj.checkUserInput(15, 5),  "Guess Input number One is lower than System generated Number")
                );
    }

    @AfterEach
    void afterTest() {
        System.out.println("This test is completed");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are completed.");
    }
}