import com.microsoft.demo.Demo;
import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpOutput() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void test_demo_covered() {
        // Arrange
        Demo d = new Demo();
        boolean testFlag = true;
        String expected = "I am covered\r\n";

        // Act
        d.DoSomething(testFlag);

        // Assert
        assertNotNull(outputStreamCaptor);
        assertFalse(outputStreamCaptor.toString().isEmpty());
        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void test_demo_not_covered() {
        // Arrange
        Demo d = new Demo();
        boolean testFlag = false;
        String expected = "I am not covered\r\n";

        // Act
        d.DoSomething(testFlag);

        // Assert
        assertNotNull(outputStreamCaptor);
        assertFalse(outputStreamCaptor.toString().isEmpty());
        assertEquals(expected, outputStreamCaptor.toString());
    }

    @AfterEach
    public void restoreSystemOutput() {
        System.setOut(standardOut);
    }
}