import com.akobir.testing.Math;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {
    private Math math;

    @BeforeEach
    void setUp() {
        math = new Math();
    }

    @AfterAll
    static void tearDown() {
        System.out.println("All tests passed");
    }

    @Test
    @DisplayName("Test add method : correct result")
    void add() {
        assertEquals(5, math.add(2, 3));
        assertEquals(3, math.add(1, 2));
        assertEquals(0, math.add(0, 0));
    }

    @Test
    @DisplayName("Test add method : incorrect result")
    void addIncorrect() {
        assertNotEquals(6, math.add(2, 3));
        assertNotEquals(4, math.add(1, 2));
        assertNotEquals(1, math.add(0, 0));
    }


    @Test
    @DisplayName("Test subtract method : correct result")
    void subtract() {
        assertEquals(94, math.sub(234, 140));
        assertEquals(-1, math.sub(1, 2));
        assertEquals(0, math.sub(0, 0));
    }

    @Test
    @DisplayName("Test subtract method : incorrect result")
    void subtractIncorrect() {
        assertNotEquals(93, math.sub(234, 140));
        assertNotEquals(-2, math.sub(1, 2));
        assertNotEquals(1, math.sub(0, 0));
    }


    @Test
    @DisplayName("Test multiply method : correct result")
    void multiply() {
        assertEquals(6, math.mul(2, 3));
        assertEquals(2, math.mul(1, 2));
        assertEquals(0, math.mul(0, 0));
    }

    @Test
    @DisplayName("Test multiply method : incorrect result")
    void multiplyIncorrect() {
        assertNotEquals(5, math.mul(2, 3));
        assertNotEquals(3, math.mul(1, 2));
        assertNotEquals(1, math.mul(0, 0));
    }

    @ParameterizedTest(name = "{index} : {0} * {1} = {2}")
    @CsvFileSource(resources = "/multiply.csv", useHeadersInDisplayName = true, numLinesToSkip = 1)
    @DisplayName("Test multiply method : correct result")
    void multiplyCsvFileSource(int a, int b, int expected) {
        assertEquals(expected, math.mul(a, b));
    }


    @Test
    @DisplayName("Test divide method : correct result")
    void divide() {
        assertEquals(2, math.div(6, 3));
        assertEquals(0, math.div(1, 2));
    }

    @ParameterizedTest(name = "{displayName} => {index} : {arguments}")
    @CsvFileSource(resources = "/division.csv", useHeadersInDisplayName = true, numLinesToSkip = 1)
    @DisplayName("Test divide method : correct result")
    void divideCsvFileSource(int a, int b, int expected) {
        assertEquals(expected, math.div(a, b));
    }


    @Test
    @DisplayName("Test divide method : incorrect result")
    void divideIncorrect() {
        assertNotEquals(3, math.div(6, 3));
        assertNotEquals(2, math.div(1, 2));
    }

    @Test
    @DisplayName("Test divide method : divide by zero")
    void divideByZero() {
        assertThrows(IllegalArgumentException.class, () -> math.div(1, 0));
    }

    @Test
    @DisplayName("Test pow method : correct result")
    void pow() {
        assertEquals(8, math.pow(2, 3));
        assertEquals(1, math.pow(1, 1));
    }

    @Test
    @DisplayName("Test pow method : incorrect result")
    void powIncorrect() {
        assertNotEquals(7, math.pow(2, 3));
        assertNotEquals(0, math.pow(1, 1));
    }

    @Test
    void argsSum() {
        int[] args = {1, 2, 3};
        assertEquals(6, math.sum(args));
        assertEquals(0, math.sum());
    }

    @Test
    void argsException() {
        assertThrows(IllegalArgumentException.class, () -> math.sum(null));
    }
}
