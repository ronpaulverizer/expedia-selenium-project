package homePage;

import org.testng.annotations.Test;

import pageFactory.PageFactoryAllInclusive;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Month;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class HomeAllInclusive {

	private WebDriver driver;
	private String baseURL;
	private PageFactoryAllInclusive f;

	@BeforeClass
	public void beforeClass() {
		baseURL = "https://www.expedia.ca/";
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		f = new PageFactoryAllInclusive(driver);
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
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
	}

	@Test(enabled = true)
	public void allInclusiveTest() throws InterruptedException {
		f.clickAllInclusiveVacationsTab();
		f.selectLeavingFrom("Toronto");
		f.selectGoingTo("Bermuda");
		f.clickDeparting();
		f.clickCalendarCheckInDate();
		f.clickCalendarForwardArrow();
		f.clickCalendarForwardArrow();
		f.clickCalendarBackArrow();
		f.clickCalendarDay(Month.FEBRUARY, 24, 2021);
		f.clickCalendarDone();
		f.selectVacationLength("7 days");
		f.clickTraveller();
		for (int x = 0; x < 12; x++) {
			f.clickTravellersAdultsInc();
			if (x < 6) {
				f.clickTravellersChildrenInc();
				f.selectChildAge(x + 1, x + 1);
			}
		}
		for (int x = 0; x < 13; x++) {
			f.clickTravellersAdultsDec();
			if (x < 6) {
				f.clickTravellersChildrenDec();
			}
		}
		f.clickTravellersDone();
		f.clickBookFor10();
	}
}
