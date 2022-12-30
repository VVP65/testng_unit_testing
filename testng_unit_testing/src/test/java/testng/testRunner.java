package testng;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();

        XmlSuite suite = new XmlSuite();
        suite.setSuiteFiles(Collections.singletonList("src/test/resources/testng.xml"));

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        testNG.setXmlSuites(suites);
        testNG.run();
    }
}