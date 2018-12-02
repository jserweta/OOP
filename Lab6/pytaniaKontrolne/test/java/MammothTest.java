import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MammothTest {
    @Before
    public void CreateAFile() throws IOException {
        File file = new File("./test_file.txt");
        if(file.createNewFile()) System.out.println("File is created!");
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testIfMeatThrowsException() throws InadequateFoodException {

        thrown.expect(InadequateFoodException.class);
        thrown.expectMessage("I don't like meat");
        Mammoth m = new Mammoth();
        m.eat(new Meat());
    }
    @After
    public void DeleteAFile() throws IOException {
        if(Files.deleteIfExists(Paths.get("test_file.txt"))) System.out.println("File is deleted!");
    }
}