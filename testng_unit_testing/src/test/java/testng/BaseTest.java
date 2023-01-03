package testng;

import com.epam.tat.module4.Calculator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends Calculator {
    public Calculator calculator;
    public Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
    }
}