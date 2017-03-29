import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by usmannoor on 8/03/2017.
 */
public class lab4Test {
    @Test
    public void testReservation() {
        System.out.println("Reservation Test");
        lab4 instance = new lab4();
        int result1 = instance.reserve(10, 1500);
        int result2 = instance.reserve(10, 1000);
        assertEquals(result1, 1);
        assertEquals(result2, 0);

    }
}