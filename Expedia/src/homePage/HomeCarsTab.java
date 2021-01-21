package homePage;

import org.testng.annotations.Test;

import pageFactory.PageFactoryCars;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Month;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class HomeCarsTab {
	private WebDriver driver;
	private String baseURL;
	private PageFactoryCars f;

	@BeforeClass
	public void beforeClass() {
		baseURL = "https://www.expedia.ca/";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		f = new PageFactoryCars(driver);
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
	public void carsTest() {
		f.clickCarsTab();
		f.clickAirportTab();
		f.clickRentalTab();
		f.clickPickUp();
		f.sendKeysPickUp("Toronto");
		f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
		f.clickSameAsPickup();
		f.sendKeysSameAsPickUp("Delhi");
		f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
		f.clickCalendarCheckIn();
		f.clickCalendarForwardArrow();
		f.clickCalendarDay(Month.FEBRUARY, 19, 2021);
		f.clickCalendarDone();
		f.clickCalendarCheckOut();
		f.clickCalendarForwardArrow();
		f.clickCalendarDay(Month.MARCH, 9, 2021);
		f.clickCalendarDone();
		f.selectPickUpTime("15:00");
		f.selectDropOffTime("22:15");
		f.clickIHaveADiscountCode();
		f.clickIHaveADiscountCode();
		f.clickIHaveADiscountCode();
		f.selectRentalCarCompany("Thrifty Car Rental");
		f.selectDiscountType("Special or advertised");
		f.sendKeysCouponInput1("Test1");
		f.sendKeysCouponInput2("Test2");
		f.sendKeysCouponInput3("Test3");
		f.clickAirportTab();
		f.clickAirportButton();
		f.sendKeysAirportInput("Delhi");
		f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
		f.clickHotelNameButton();
		f.sendKeysHotelNameInput("Toronto");
		f.clickSearchResult("Hotel Toronto", "New Delhi, National Capital Territory of Delhi, India");
		f.clickCalendarCheckIn();
		f.clickCalendarDay(Month.FEBRUARY, 20, 2021);
		f.clickCalendarDone();
		f.selectFlightArrivalTime("16:30");
		f.clickBookRoundtrip();
		f.clickCalendarCheckOut();
		f.clickCalendarDay(Month.FEBRUARY, 25, 2021);
		f.clickCalendarDone();
		f.selectFlightDepratureTime("19:30");
		f.clickTraveller();
		f.clickTravellersAdultsInc();
		f.clickTravellersAdultsInc();
		f.clickTravellersChildrenInc();
		f.clickTravellersChildrenInc();
		f.clickTravellersInfantsInc();
		f.clickTravellersInfantsInc();
		f.clickTravellersAdultsDec();
		f.clickTravellersChildrenDec();
		f.clickTravellersInfantsDec();
		f.clickTravellersDone();
		f.clickSwapAirportHotel();
	}
}
