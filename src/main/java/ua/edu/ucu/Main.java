package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import static org.junit.Assert.*;

public class Main {
    public static void main(String[] args) {
        IntStream intStream;

        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);

        System.out.println("streamOperations");
        int expResult1 = 42;
        int result1 = StreamApp.streamOperations(intStream);
        assertEquals(expResult1, result1);

        System.out.println("streamToArray");
        int[] expResult2 = {-1, 0, 1, 2, 3};
        int[] result2 = StreamApp.streamToArray(intStream);
        assertArrayEquals(expResult2, result2);

        System.out.println("streamForEach");
        String expResult3 = "-10123";
        String result3 = StreamApp.streamForEach(intStream);
        assertEquals(expResult3, result3);

    }
}
