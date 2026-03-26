import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for HelloApp class.
 * Tests the personalized greeting functionality with command-line arguments.
 * 
 * @author java-upgrade
 * @version 1.0
 */
@DisplayName("HelloApp Tests")
class HelloAppTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Set up test environment - capture System.out for verification
     */
    @BeforeEach
    void setUp() {
        // Redirect System.out to capture console output
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Clean up test environment - restore System.out
     */
    @AfterEach
    void tearDown() {
        // Restore original System.out
        System.setOut(originalOut);
    }

    /**
     * Test: Verify main method handles a single valid name argument correctly
     * Arrange: Provide "Chandramouli" as command-line argument
     * Act: Call main method
     * Assert: Output should be "Hello, Chandramouli!"
     */
    @Test
    @DisplayName("Should greet user with provided name")
    void testMainWithValidName() {
        // Arrange
        String[] args = {"Chandramouli"};
        String expectedOutput = "Hello, Chandramouli!";

        // Act
        HelloApp.main(args);

        // Assert
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim(),
                "Output should contain personalized greeting with the provided name");
    }

    /**
     * Test: Verify main method handles simple single-word names
     * Arrange: Provide "Alice" as command-line argument
     * Act: Call main method
     * Assert: Output should be "Hello, Alice!"
     */
    @Test
    @DisplayName("Should greet user with single word name")
    void testMainWithSingleWordName() {
        // Arrange
        String[] args = {"Alice"};
        String expectedOutput = "Hello, Alice!";

        // Act
        HelloApp.main(args);

        // Assert
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim(),
                "Output should correctly format greeting for single word name");
    }

    /**
     * Test: Verify main method concatenates multiple arguments with commas
     * Arrange: Provide multiple arguments: "John", "Doe", "Jr"
     * Act: Call main method
     * Assert: Output should concatenate all arguments: "Hello, John, Doe, Jr!"
     */
    @Test
    @DisplayName("Should concatenate multiple arguments with commas")
    void testMainWithMultipleArguments() {
        // Arrange
        String[] args = {"John", "Doe", "Jr"};
        String expectedOutput = "Hello, John, Doe, Jr!";

        // Act
        HelloApp.main(args);

        // Assert
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim(),
                "Output should concatenate all arguments with commas");
    }

    /**
     * Test: Verify main method concatenates two arguments correctly
     * Arrange: Provide two arguments: "John", "Doe"
     * Act: Call main method
     * Assert: Output should be "Hello, John, Doe!"
     */
    @Test
    @DisplayName("Should concatenate two arguments with comma")
    void testMainWithTwoArguments() {
        // Arrange
        String[] args = {"John", "Doe"};
        String expectedOutput = "Hello, John, Doe!";

        // Act
        HelloApp.main(args);

        // Assert
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim(),
                "Output should concatenate two arguments with a comma");
    }

    /**
     * Test: Verify main method handles empty string argument
     * Arrange: Provide empty string as argument
     * Act: Call main method
     * Assert: Output should be "Hello, !" (greeting with empty name)
     */
    @Test
    @DisplayName("Should handle empty string argument")
    void testMainWithEmptyString() {
        // Arrange
        String[] args = {""};
        String expectedOutput = "Hello, !";

        // Act
        HelloApp.main(args);

        // Assert
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim(),
                "Output should handle empty string gracefully");
    }

    /**
     * Test: Verify main method handles names with special characters
     * Arrange: Provide name with special characters "José-María"
     * Act: Call main method
     * Assert: Output should correctly include special characters
     */
    @Test
    @DisplayName("Should handle names with special characters")
    void testMainWithSpecialCharacters() {
        // Arrange
        String[] args = {"José-María"};
        String expectedOutput = "Hello, José-María!";

        // Act
        HelloApp.main(args);

        // Assert
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim(),
                "Output should correctly handle special characters in names");
    }

    /**
     * Test: Verify main method handles names with numbers
     * Arrange: Provide name with numbers "User123"
     * Act: Call main method
     * Assert: Output should correctly include numbers
     */
    @Test
    @DisplayName("Should handle names with numbers")
    void testMainWithNumbers() {
        // Arrange
        String[] args = {"User123"};
        String expectedOutput = "Hello, User123!";

        // Act
        HelloApp.main(args);

        // Assert
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim(),
                "Output should correctly handle numbers in names");
    }

    /**
     * Test: Verify main method handles whitespace in name
     * Arrange: Provide name with spaces "John Doe"
     * Act: Call main method
     * Assert: Output should preserve whitespace
     */
    @Test
    @DisplayName("Should handle names with whitespace")
    void testMainWithWhitespace() {
        // Arrange
        String[] args = {"John Doe"};
        String expectedOutput = "Hello, John Doe!";

        // Act
        HelloApp.main(args);

        // Assert
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim(),
                "Output should preserve whitespace in names");
    }

    /**
     * Test: Verify main method handles no arguments (empty name)
     * Arrange: Provide empty args array
     * Act: Call main method
     * Assert: Output should be "Hello, !" (empty name)
     */
    @Test
    @DisplayName("Should output empty name when no arguments provided")
    void testMainWithNoArguments() {
        // Arrange
        String[] args = {};
        String expectedOutput = "Hello, !";

        // Act
        HelloApp.main(args);

        // Assert
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim(),
                "Output should be 'Hello, !' when no arguments are provided");
    }

    /**
     * Test: Verify main method handles very long names
     * Arrange: Provide a very long name string
     * Act: Call main method
     * Assert: Output should correctly format the long name
     */
    @Test
    @DisplayName("Should handle very long names")
    void testMainWithLongName() {
        // Arrange
        String longName = "Chandramouli".repeat(10); // 120 characters
        String[] args = {longName};
        String expectedOutput = "Hello, " + longName + "!";

        // Act
        HelloApp.main(args);

        // Assert
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim(),
                "Output should correctly handle very long names");
    }

    /**
     * Test: Verify main method output format is consistent
     * Arrange: Provide "TestUser" as argument
     * Act: Call main method
     * Assert: Output should follow pattern "Hello, {name}!"
     */
    @Test
    @DisplayName("Should follow consistent output format")
    void testOutputFormatConsistency() {
        // Arrange
        String[] args = {"TestUser"};
        String output;

        // Act
        HelloApp.main(args);
        output = outputStreamCaptor.toString().trim();

        // Assert
        assertTrue(output.startsWith("Hello, "),
                "Output should start with 'Hello, '");
        assertTrue(output.endsWith("!"),
                "Output should end with '!'");
        assertTrue(output.contains("TestUser"),
                "Output should contain the provided name");
    }
}
