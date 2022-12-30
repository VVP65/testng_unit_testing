package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.AssertJUnit.assertEquals;

public class MultiplicationCalculatorTest extends BaseTest {

    @Test(dataProvider = "multDataProviderFirstIteration", groups = "first")
    public void miltFirstIteration(long firstArgument, long secondArgument, long expected) {
        long result = calculator.mult(firstArgument, secondArgument);
        assertEquals(result, expected);
        logger.info(String.format("Current Thread no: %s - Current time: %s", Thread.currentThread().getId(), new Date(System.currentTimeMillis())));
    }

    @DataProvider(name = "multDataProviderFirstIteration")
    public Object[][] multDataProviderFirstIteration() {
        return new Object[][]{
                {2, 3, 6},
                {-2, -6, 12},
                {-5, 5, -25}
        };
    }

    @Test(dataProvider = "multDataProviderSecondIteration", groups = "second")
    public void multSecondIteration(long firstArgument, long secondArgument, long expected) {
        long result = calculator.mult(firstArgument, secondArgument);
        assertEquals(result, expected);
        logger.info(String.format("Current Thread no: %s - Current time: %s", Thread.currentThread().getId(), new Date(System.currentTimeMillis())));
    }

    @DataProvider(name = "multDataProviderSecondIteration")
    public Object[][] nultDataProviderSecondIteration() {
        return new Object[][]{
                {-2, 4, -8},
                {-2, 7, -14},
                {-5, -6, 30}
        };
    }
}