import java.lang.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertNotEquals;


public class LoginProgramTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testIfLoginThrowsException2() throws LoginExceptions{
        thrown.expect(LoginExceptions.class);
        thrown.expectMessage("Wprowadź dane!");
        LoginProgram logProg = new LoginProgram();
        String login = "";
        String haslo = "";
        logProg.emptyString(login,haslo);

    }
    @Test
    public void testIfLoginThrowsException1() throws LoginExceptions{
        thrown.expect(LoginExceptions.class);
        thrown.expectMessage("Błędny login lub hasło!");

        String login = "aaa";
        String haslo = "bbb";

        assertNotEquals("ala",login);
        assertNotEquals("makota",haslo);

    }
}
