import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EulerTest {

    // 1.
    @Test
    void sumMultiples() {
        int expected = 233168;
        int result = Euler.sumMultiples();

        assertEquals(expected, result);
    }


    // 2.
    @Test
    void sumEvenFibonacci() {
        int expected = 4613732;
        int result = Euler.sumEvenFibonacci();

        assertEquals(expected, result);
    }


    // 3.
    @Test
    void largestPrime() {
        long expected = 6857;
        long result = Euler.largestPrime(600851475143L);

        assertEquals(expected, result);
    }


    // 4.
    @Test
    void largestPalindrome() {
        long expected = 906609;
        long result = Euler.largestPalindrome();

        assertEquals(expected, result);
    }


    // 5.
    @Test
    void smallestMultiple() {
        long expected = 232792560;
        long result = Euler.smallestMultiple();

        assertEquals(expected, result);

    }


    // 6.
    @Test
    void sumSquareDifference() {
        long expected = 25164150;
        long result = Euler.sumSquareDifference(100);

        assertEquals(expected, result);
    }


    // 7.
    @Test
    void nthPrime() {
        long expected = 104743;
        long result = Euler.nthPrime(10001);

        assertEquals(expected, result);
    }


    // 8.
    @Test
    void largestProduct() {
        long expected = 23514624000L;
        long result = Euler.largestProduct();

        assertEquals(expected, result);

    }


    // 9.
    @Test
    void productABC() {
        double expected = 3.1875E7;
        double result = Euler.productABC();

        assertEquals(expected, result);
    }


    // 10.
    @Test
    void sumOfPrimes() {
        long expected = 142913828922L;
        long result = Euler.sumOfPrimes();

        assertEquals(expected, result);

    }


    // 11.
    @Test
    void largestProductGrid() {
        long expected = 70600674;
        long result = Euler.largestProductGrid();

        assertEquals(expected, result);
    }


    // 12.
    @Test
    void triangle() {
        long expected = 76576500;
        long result = Euler.triangle();

        assertEquals(expected, result);
    }


    // 13.
    @Test
    void largeSum() {
        String expected = "5537376230";
        String result = Euler.largeSum();

        assertEquals(expected, result);
    }


    // 14.
    @Test
    void collatzSequence() {
        long expected = 525;
        long result = Euler.longestCollatzSequence();

        assertEquals(expected, result);
    }


    // 15.
    @Test
    void latticePaths() {
        long expected = 137846528820L;
        long result = Euler.latticePaths();

        assertEquals(expected, result);
    }


    // 16. (note: solution is 1366 using BigInteger instead of long)
    @Test
    void sumPowerDigit() {
        long expected = 88;
        long result = Euler.sumPowerDigit();

        assertEquals(expected, result);
    }


    // 18. (note: didn't consider adjacent numbers --- applied it to full rows)
    @Test
    void maximumPath() {
        int expected = 1313;
        int result = Euler.maximumPath();

        assertEquals(expected, result);
    }


    // 19.
    @Test
    void countSundays() {
        int expected = 171;
        int result = Euler.countSundays();

        assertEquals(expected, result);
    }


    // 20. considered factorial of 10 instead of 100
    @Test
    void factorial() {
        long expected = 27;
        long result = Euler.factorialDigitSum();

        assertEquals(expected, result);
    }


    // 21.
    @Test
    void sumAmicable() {
        long expected = 14211;
        long result = Euler.sumAmicableNumbers();

        assertEquals(expected, result);
    }


    // 23.
    @Test
    void solution() {
        long expected = 4179871L;
        long result = Euler.solution();

        assertEquals(expected, result);

    }


    // 24.
    @Test
    void getAnswer() throws Exception {
        String expected = "2783915460";
        String result = Euler.getAnswer();

        assertEquals(expected, result);

    }


    // 25.
    @Test
    void fibonnaci() {
        long expected = 1597;
        long result = Euler.fibonacci(17);

        assertEquals(expected, result);
    }


    // 26.
    @Test
    void reciprocal() {
        int expected = 983;
        int result = Euler.reciprocalCycle();

        assertEquals(expected, result);
    }


    // 27.
    @Test
    void productCoefficients() {
        long expected = -59231;
        long result = Euler.productCoefficients();

        assertEquals(expected, result);
    }


    // 28.
    @Test
    void sumDiagonal() {
        long expected = 669171001;
        long result = Euler.sumDiagonal();

        assertEquals(expected, result);
    }


    // 29.
    @Test
    void distinctPower() {
        int expected = 9183;
        int result = Euler.distinctPowers();

        assertEquals(expected, result);
    }


    // 30.
    @Test
    void sumFifthPowers() {
        long expected = 443839;
        long result = Euler.sumFifthPowers();

        assertEquals(expected, result);
    }

    // 31.
    @Test
    void differentWays() {
        int expected = 73682;
        int result = Euler.differentWays();

        assertEquals(expected, result);
    }


    // 32.
    @Test
    void pandigital() {
        String expected = "45228";
        String result = Euler.pandigitalProduct();

        assertEquals(expected, result);
    }


    // 33.
    @Test
    void fraction() {
        String expected = "100";
        String result = Euler.fraction();

        assertEquals(expected, result);
    }


    // 34.
    @Test
    void sumFactorials() {
        long expected = 40730;
        long result = Euler.sumFactorials();

        assertEquals(expected, result);
    }


    // 35.
    @Test
    void countCirularPrimes() {
        int expected = 55;
        int result = Euler.countCircularPrimes();

        assertEquals(expected, result);
    }


}