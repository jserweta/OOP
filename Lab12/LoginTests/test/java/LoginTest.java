import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    @Test
    public void checkTestIfTrue(){
        String log="ala";
        String password="makota";
        Login login = new Login(log, password);
        boolean returnValue = login.check(log,password);
        assertTrue(returnValue);
    }
    @Test
    public void checkTestIfFalse(){
        String log="";
        String password="";
        Login login = new Login(log, password);
        boolean returnValue = login.check(log,password);
        assertTrue(returnValue);
    }
}
