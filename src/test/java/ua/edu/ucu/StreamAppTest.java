package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author andrii
 */
public class StreamAppTest {
    
    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }
    
    @Test
    public void testStreamOperations() {
        System.out.println("streamOperations");
        int expResult = 42;
        int result = StreamApp.streamOperations(intStream);
        assertEquals(expResult, result);        
    }

    @Test
    public void testStreamToArray() {
        System.out.println("streamToArray");
        int[] expResult = {-1, 0, 1, 2, 3};
        int[] result = StreamApp.streamToArray(intStream);
        assertArrayEquals(expResult, result);        
    }

    @Test
    public void testStreamForEach() {
        System.out.println("streamForEach");
        String expResult = "-10123";
        String result = StreamApp.streamForEach(intStream);
        assertEquals(expResult, result);        
    }

    @Test
    public void testStreamAverage() throws IllegalAccessException {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);

        System.out.println("streamAverage");
        String expResult = "1.0";
        String result = String.valueOf(StreamApp.streamAverage(intStream));
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamMin() throws IllegalAccessException {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);

        System.out.println("streamMax");
        int expResult = -1;
        int result = StreamApp.streamMin(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamMax() throws IllegalAccessException {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);

        System.out.println("streamMax");
        int expResult = 3;
        int result = StreamApp.streamMax(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamCount() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);

        System.out.println("streamCount");
        long expResult = 5;
        long result = StreamApp.streamCount(intStream);
        assertEquals(expResult, result);
    }
    
}
