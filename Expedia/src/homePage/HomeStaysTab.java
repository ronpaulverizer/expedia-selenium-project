package homePage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageFactory.ExtentReportsConfig;
import pageFactory.PageFactoryStays;

public class HomeStaysTab {

	private WebDriver driver;
	private String baseURL = null;
	private PageFactoryStays f;
	private ExtentReports report;
	private ExtentTest test;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		report = ExtentReportsConfig.getInstance();
		baseURL = "https://www.expedia.ca/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		f = new PageFactoryStays(driver, test);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseURL);
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws IOException {
		// After each test, determine whether or not it passed with ITestResult.
		if (testResult.getStatus() == ITestResult.FAILURE) {
			//Declare DateTimeFormatter and LocalDateTime so that we may append the current date and time to our screenshots.
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_dd_MMM-HH_mm_ss");
			LocalDateTime now = LocalDateTime.now();
			// If it failed, take a screenshot at the moment of failure and return the path
			// of said screenshot with f.takeScreenshotReturnPath().
			String path = f.takeScreenshotReturnPath(driver, testResult.getMethod().getMethodName() + "-failure-"+dtf.format(now));
			// Format the path of the screenshot so that it may be attached to an Extent
			// Reports HTML document for review.
			String imagePath = f.formatScreenshotPath(path);
			// Log the failure message and the screenshot.
			f.log(LogStatus.FAIL, testResult.getMethod().getMethodName() + " has failed.");
			f.log(LogStatus.FAIL, imagePath);
		} else if (testResult.getStatus() == ITestResult.SUCCESS) {
			//Log pass message on success.
			f.log(LogStatus.PASS, testResult.getMethod().getMethodName() + " has passed.");
		}
		//Stop reporting for the test and flush it so that the report document will be updated with the test results.
		report.endTest(test);
		report.flush();
	}

	@Test(enabled = false)
	public void basicTest() {
		f.createTestReport(report, "Basic Test");
		f.clickStaysTab();
		f.clickGoingTo();
		f.sendKeysGoingTo("Delhi");
		f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");

		f.clickCheckIn();
		f.clickCalendarCheckInDate();
		f.clickCalendarDay(Month.JANUARY, 29, 2021);
		f.clickCalendarCheckOutDate();
		f.clickCalendarDay(Month.FEBRUARY, 24, 2021);
		f.clickCalendarDone();
		f.clickTravellerTab();
		f.clickTravellersAddRoom();
		f.clickTravellersAddRoom();
		f.clickTravellersChildrenInc(3);
		f.clickTravellersChildrenInc(3);
		f.clickTravellersChildrenInc(3);
		f.clickTravellersChildrenInc(3);
		f.clickTravellersChildrenInc(3);
		f.clickTravellersChildrenInc(3);
		f.selectChildAge(3, 1, 15);
		f.selectChildAge(3, 2, 17);
		f.selectChildAge(3, 3, 4);
		f.selectChildAge(3, 4, 9);
		f.selectChildAge(3, 5, 4);
		f.selectChildAge(3, 6, 10);
	}

	@Test(enabled = false)
	public void leavingFromTest() {
		f.createTestReport(report, "Leaving From Test");
		f.clickStaysTab();
		f.clickAddFlight();
		f.clickLeavingFrom();
		f.sendKeysLeavingFrom("Delhi");
		f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
		f.clickAddCar();
	}
	
	@Test(enabled = true)
	public void bigAssAssertionTest() {
		f.createTestReport(report, "Big Ass Assertion Test");
		f.clickCheckIn();
		for(int x=0;x<5;x++) {
			f.clickCalendarForwardArrow();
		}
		System.out.println("Testing branching");
		//Assert.assertTrue(f.verifyCalendarDaysAreHighlightedCorrectly());
		//Assert.assertTrue(f.verifyUserCannotSelectDayOver500InFuture());
		//Assert.assertTrue(f.verifyUserCannotSelectDayInPast());
//		Assert.assertTrue(f.verifyUserCannotAccessPastMonth());
//		Assert.assertTrue(f.verifyUserCannotAccessMonth500DaysAhead());
	}
}
