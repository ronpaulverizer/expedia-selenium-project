package homePage;

import org.testng.annotations.Test;

import pageFactory.PageFactoryCruises;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Month;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class HomeCruises {
	private WebDriver driver;
	private String baseURL;
	private PageFactoryCruises f;

	@BeforeClass
	public void beforeClass() {
		baseURL = "https://www.expedia.ca/";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		f = new PageFactoryCruises(driver);
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
	public void cruisesDemo() throws InterruptedException {
		f.clickCruisesTab();
		f.selectCruiseDestination("Mexico");
		f.clickTravellersButton();
		for (int x = 0; x < 4; x++) {
			if (x < 3) {
				f.clickTravellersAdultsInc();
			}
			f.clickTravellersChildrenInc();
			f.selectChildAge(x + 1, x + 5);
		}
		for (int x = 0; x < 4; x++) {
			f.clickTravellersAdultsDec();
			f.clickTravellersChildrenDec();
		}
		f.clickTravellersDone();
		f.clickDepartsAsEarlyAs();
		f.clickCalendarCheckOutDate();
		f.clickCalendarCheckInDate();
		f.clickCalendarForwardArrow();
		f.clickCalendarBackArrow();
		f.clickCalendarDay(Month.JANUARY, 9, 2021);
		f.clickCalendarDone();
		f.clickDepartsAsLateAs();
		f.clickCalendarCheckInDate();
		f.clickCalendarCheckOutDate();
		f.clickCalendarForwardArrow();
		f.clickCalendarBackArrow();
		f.clickCalendarDay(Month.FEBRUARY, 24, 2021);
		f.clickCalendarDone();
	}
}
