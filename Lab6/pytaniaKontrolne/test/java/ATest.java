import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class ATest {

    @Test
    public void check1ReturnsPierwszy() {
        A a = new A();

        assertEquals(a.met(1), "pierwszy");
    }

    @Test
    public void check2ReturnsDrugi() {
        A a = new A();

        assertEquals(a.met(2), "drugi");
    }

    @Test
    public void checkOtherReturnsInny() {
        A a = new A();

        assertEquals(a.met(3), "inny");
    }
}