package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Reports.LoginReport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends BaseTest {

    static ExtentReports extent;
    static ExtentTest test;

    @BeforeClass
    public static void setupReport() {
        extent = LoginReport.getReporter();  // Ensure you have a utility for this
        test = extent.createTest("Login Test", "Verifies login and dashboard load flow");
    }

    @Test
    public void testLoginFlow() {
        driver.get("https://staging--cf-grower.netlify.app/en/sign-in");
        test.log(Status.INFO, "Navigated to login page");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("coceho5934@exitbit.com", "RamsM@1234!");
        test.log(Status.INFO, "Entered login credentials and clicked sign in");

        By dashboardHeading = By.xpath("//p[contains(text(),'Dashboard') "); // look into this then fix
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeading));
            test.log(Status.PASS, "📌 Dashboard heading is visible.");
        } catch (TimeoutException e) {
            test.log(Status.FAIL, "❌ Timeout waiting for Dashboard heading.");
            throw e;
        }
    }

//    @AfterClass
//    public static void tearDownReport() {
//        extent.flush();  // writes everything to HTML report
//    }
}
