package homePage;

import org.testng.annotations.Test;

import pageFactory.PageFactoryThingsToDo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Month;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class HomeThingsToDo {
	private WebDriver driver;
	private String baseURL;
	private PageFactoryThingsToDo f;

	@BeforeClass
	public void beforeClass() {
		baseURL = "https://www.expedia.ca/";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		f = new PageFactoryThingsToDo(driver);
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

	@Test
	public void thingsToDoDemo(){
		f.clickThingsToDoTab();
		f.clickThingsToDoIn();
		f.sendKeysThingsToDoIn("Toronto");
		f.clickSearchResult("Toronto", "Ontario, Canada");
		f.clickFromButton();
		f.clickCalendarForwardArrow();
		f.clickCalendarForwardArrow();
		f.clickCalendarCheckOutDate();
		f.clickCalendarCheckInDate();
		f.clickCalendarBackArrow();
		f.clickCalendarBackArrow();
		f.clickCalendarDay(Month.JANUARY,18, 2021);
		f.clickCalendarDone();
		f.clickToButton();
		f.clickCalendarForwardArrow();
		f.clickCalendarForwardArrow();
		f.clickCalendarCheckInDate();
		f.clickCalendarCheckOutDate();
		f.clickCalendarBackArrow();
		f.clickCalendarDay(Month.FEBRUARY, 1, 2021);
		f.clickCalendarDone();
		f.clickSearchButton();
	}
}
