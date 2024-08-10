package stepDefinitions;

import Driver.driverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {

    @Before
    public void setUp() {
        driverSetup.getDriver();
    }

    @After
    public void tearDown() {
        try {

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driverSetup.quitDriver();
    }
}
