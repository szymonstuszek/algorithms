import org.junit.Assert;
import org.junit.Test;

public class NumbersInPiTest {

    @Test
    public void testNumberInPi() {
        String pi = "314";
        String[] numbers = {"314", "3", "14", "1"};

        int expected = 0;
        int result = NumbersInPi.numbersInPi(pi, numbers);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testNumberInPi2() {
        String pi = "314";
        String[] numbers = {"543"};

        int expected = -1;
        int result = NumbersInPi.numbersInPi(pi, numbers);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testNumberInPi3() {
        String pi = "314";
        String[] numbers = {"314"};

        int expected = 0;
        int result = NumbersInPi.numbersInPi(pi, numbers);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testNumberInPi4() {
        String pi = "314";
        String[] numbers = {"3", "1", "4"};

        int expected = 0;
        int result = NumbersInPi.numbersInPi(pi, numbers);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testNumberInPi5() {
        String pi = "314";
        String[] numbers = {"3", "1", "4", "31"};

        int expected = 0;
        int result = NumbersInPi.numbersInPi(pi, numbers);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testNumberInPi6() {
        String pi = "314";
        String[] numbers = {"3", "14", "1"};

        int expected = 0;
        int result = NumbersInPi.numbersInPi(pi, numbers);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testNumberInPi7() {
        String pi = "31415";
        String[] numbers = {"314", "1", "3", "4", "5"};

        int expected = 0;
        int result = NumbersInPi.numbersInPi(pi, numbers);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testNumberInPi8() {
        String pi = "3141592";
        String[] numbers = {"3", "1", "14", "1592"};

        int expected = 2;
        int result = NumbersInPi.numbersInPi(pi, numbers);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testNumberInPi9() {
        String pi = "31415";
        String[] numbers = {"314", "15"};

        int expected = 1;
        int result = NumbersInPi.numbersInPi(pi, numbers);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testNumberInPi10() {
        String pi = "3141592";
        String[] numbers = {"31", "41", "5", "92"};

        int expected = 2;
        int result = NumbersInPi.numbersInPi(pi, numbers);

        Assert.assertEquals(expected, result);
    }

}
