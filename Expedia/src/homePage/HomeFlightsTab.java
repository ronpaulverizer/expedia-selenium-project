package homePage;

import org.testng.annotations.Test;

import pageFactory.PageFactoryFlights;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Month;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class HomeFlightsTab {

	private WebDriver driver;
	private PageFactoryFlights f;
	private String baseURL;

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseURL);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
	}

	@BeforeClass
	public void beforeClass() {
		baseURL = "https://www.expedia.ca/";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		f = new PageFactoryFlights(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test(enabled = false)
	public void flightsTabTest() {
		f.clickFlightsTab();
		f.clickLeavingFrom();
		f.sendKeysLeaving("Delhi");
		f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
		f.clickGoingTo();
		f.sendKeysGoing("Toronto");
		f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
		f.clickCalendarCheckIn();
		f.clickCalendarCheckInDate();
		f.clickCalendarDay(Month.JANUARY, 5, 2021);
		f.clickCalendarDone();
		f.clickCalendarCheckOut();
		f.clickCalendarCheckOutDate();
		f.clickCalendarForwardArrow();
		f.clickCalendarBackArrow();
		f.clickCalendarDay(Month.FEBRUARY, 9, 2021);
		f.clickCalendarDone();
		f.clickPreferredClass();
		f.clickPremiumEconomy();
		f.clickOneWay();
		f.clickLeavingFrom();
		f.sendKeysLeaving("Delhi");
		f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
		f.clickGoingTo();
		f.sendKeysGoing("Toronto");
		f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
		f.clickCalendarCheckIn();
		f.clickCalendarCheckInDate();
		f.clickCalendarDay(Month.JANUARY, 9, 2021);
		f.clickCalendarDone();
		f.clickPreferredClass();
		f.clickPremiumEconomy();
		f.clickTraveler();
		for (int x = 0; x < 5; x++) {
			f.clickTravellersChildrenInc();
		}
		f.selectChildAge(1, 2);
		f.selectChildAge(2, 3);
		f.selectChildAge(3, 10);
		f.selectChildAge(4, 9);
		f.selectChildAge(5, 7);
		for (int x = 0; x < 5; x++) {
			f.clickTravellersChildrenDec();
		}
		for (int x = 0; x < 5; x++) {
			f.clickTravellersInfantsInc();
		}
		f.selectInfantAge(1, 1);
		f.selectInfantAge(2, 1);
		f.selectInfantAge(3, 1);
		f.selectInfantAge(4, 1);
		f.selectInfantAge(5, 1);
		f.selectInfantAge(5, 0);
		f.clickTravellersInSeat();
		f.clickTravellersOnLap();
		f.clickAirlineAgeRules();
		f.clickTravellersDone();
	}

	@Test(enabled = true)
	public void mutliCityTest() {
		f.clickFlightsTab();
		f.clickMultiCity();
		for (int x = 0; x < 3; x++) {
			f.clickAddAnotherFlight();
		}
		f.clickMultiCityLeavingFrom(1);
		f.sendKeysMultiCityLeaving("Delhi", 1);
		f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
		f.clickMultiCityGoingTo(1);
		f.sendKeysMultiCityGoing("Toronto", 1);
		f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
		f.clickMultiCityDeparting(1);
		f.clickCalendarDay(Month.JANUARY, 8, 2021);
		f.clickCalendarDone();
		f.clickMultiCityLeavingFrom(2);
		f.sendKeysMultiCityLeaving("Delhi", 2);
		f.clickSearchResult("London (YXU - London Intl.)", "Near Delhi, Ontario, Canada");
		f.clickMultiCityGoingTo(2);
		f.sendKeysMultiCityGoing("Toronto", 2);
		f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
		f.clickMultiCityDeparting(2);
		f.clickCalendarDay(Month.JANUARY, 9, 2021);
		f.clickCalendarDone();
		f.clickMultiCityLeavingFrom(3);
		f.sendKeysMultiCityLeaving("Delhi", 3);
		f.clickSearchResult("London (YXU - London Intl.)", "Near Delhi, Ontario, Canada");
		f.clickMultiCityGoingTo(3);
		f.sendKeysMultiCityGoing("Toronto", 3);
		f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
		f.clickMultiCityDeparting(3);
		f.clickCalendarDay(Month.JANUARY, 10, 2021);
		f.clickCalendarDone();
		f.clickMultiCityLeavingFrom(4);
		f.sendKeysMultiCityLeaving("Delhi", 4);
		f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
		f.clickMultiCityGoingTo(4);
		f.sendKeysMultiCityGoing("Toronto", 4);
		f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
		f.clickMultiCityDeparting(4);
		f.clickCalendarDay(Month.JANUARY, 11, 2021);
		f.clickCalendarDone();
		f.clickMultiCityLeavingFrom(5);
		f.sendKeysMultiCityLeaving("Delhi", 5);
		f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
		f.clickMultiCityGoingTo(5);
		f.sendKeysMultiCityGoing("Toronto", 5);
		f.clickSearchResult("Toronto (YYZ - Pearson Intl.)", "Ontario, Canada");
		f.clickMultiCityDeparting(5);
		f.clickCalendarDay(Month.JANUARY, 12, 2021);
		f.clickCalendarDone();
	}
}
