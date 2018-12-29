import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class LoginProgramTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testIfThrowsLoginExceptionWithEmptyData() throws LoginExceptions{
        thrown.expect(LoginExceptions.class);
        thrown.expectMessage("Wprowadź dane!");

        LoginProgram logProg = new LoginProgram();
        String login = "";
        String haslo = "";
        logProg.checkData(login, haslo);
    }
    @Test
    public void testIfThrowsLoginExceptionWithInvalidData() throws LoginExceptions{
        thrown.expect(LoginExceptions.class);
        thrown.expectMessage("Błędny login lub hasło!");

        LoginProgram logProg = new LoginProgram();
        String login = "aaa";
        String haslo = "bbb";
        logProg.checkData(login, haslo);
    }
    @Test
    public void testIfPrintsOKWhenDataIsCorrect() throws LoginExceptions {
        LoginProgram logProg = new LoginProgram();
        String expectedMessage = "Podano poprawne dane! Logowanie przebiegło pomyślnie!";
        String login = "ala";
        String haslo = "makota";

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        logProg.checkData(login, haslo);
        assertEquals(expectedMessage, outContent.toString());
    }
}
