package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.AssertJUnit.assertEquals;

public class DivisionCalculatorTest extends BaseTest {

    @Test(dataProvider = "divDataProviderFirstIteration", groups = "first")
    public void divFirstIteration(long firstArgument, long secondArgument, long expected) {
        long actualResult = calculator.div(firstArgument, secondArgument);
        assertEquals(actualResult, expected);
        logger.info(String.format("Current Thread no: %s - Current time: %s", Thread.currentThread().getId(), new Date(System.currentTimeMillis())));
    }

    @DataProvider(name = "divDataProviderFirstIteration")
    public Object[][] divDataProviderFirstIteration() {
        return new Object[][]{
                {6, 2, 3},
                {-6, -2, 3},
                {8, -4, -2}
        };
    }

    @Test(dataProvider = "divDataProviderSecondIteration", groups = "second")
    public void divSecondIteration(long firstArgument, long secondArgument, long expected) {
        long result = calculator.div(firstArgument, secondArgument);
        assertEquals(result, expected);
        logger.info(String.format("Current Thread no: %s - Current time: %s", Thread.currentThread().getId(), new Date(System.currentTimeMillis())));
    }

    @DataProvider(name = "divDataProviderSecondIteration")
    public Object[][] divDataProviderSecondIteration() {
        return new Object[][]{
                {6, 2, 3},
                {-6, -3, 2},
                {8, -2, -4}
        };
    }

    @Test(expectedExceptions = NumberFormatException.class, groups = "first")
    public void checkDivisionByZeroThrowsException() {
        long result = calculator.div(3L, 0L);
    }
}