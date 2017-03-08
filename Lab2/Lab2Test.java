import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by usmannoor on 22/02/2017.
 */
public class Lab2Test {
    @Test
    public void testStressen() {
        System.out.println("Strassen");
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        Lab2 instance = new Lab2();
        int[][] expResult = {{19, 22}, {43, 50}};
        int[][] result = instance.multiply(A, B);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testMatrixMultiply() {
        System.out.println("Iterative");
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int w = 2;
        int x = 2;
        int y = 2;
        int z = 2;
        int[][] expResult = {{19, 22}, {43, 50}};
        int[][] result = Lab2.matrixMultiply(a, b, w, x, y, z);
        assertArrayEquals(expResult, result);
    }

}