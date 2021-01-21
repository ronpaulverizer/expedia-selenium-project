package homePage;

import org.testng.annotations.Test;

import pageFactory.PageFactoryVacation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Month;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class HomeVacationTab {
	private String baseURL;
	private WebDriver driver;
	private PageFactoryVacation f;

	@BeforeClass
	public void beforeClass() {
		baseURL = "https://www.expedia.ca/";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		f = new PageFactoryVacation(driver);
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
	public void vacationTabDemo() {
		f.clickVacationPackagesTab();
		f.clickFlightsSubTab();
		f.clickStaysSubTab();
		f.clickCarsSubTab();
		f.clickFlightsSubTab();
		f.clickStaysSubTab();
		f.clickLeavingFrom();
		f.sendKeysLeavingFrom("Delhi");
		f.clickSearchResult("Delhi (DEL - Indira Gandhi Intl.)", "India");
		f.clickGoingTo();
		f.sendKeysGoingTo("Toronto");
		f.clickSearchResult("Toronto", "Ontario, Canada");
		f.clickAccommodationsCheckbox();
		f.clickDepartingButton();
		f.clickCalendarDay(Month.JANUARY, 20,2021);
		f.clickCalendarDone();
		f.clickReturningButton();
		f.clickCalendarDay(Month.JANUARY, 25,2021);
		f.clickCalendarDone();
		f.clickCheckIn();
		f.clickCalendarDay(Month.JANUARY, 26,2021);
		f.clickCalendarDone();
		f.clickCheckOut();
		f.clickCalendarDay(Month.JANUARY, 27,2021);
		f.clickCalendarDone();
		f.clickPreferredClass();
		f.clickFirstClass();
		f.clickPreferredClass();
		f.clickBusinessClass();
		f.clickPreferredClass();
		f.clickPremiumEconomy();
		f.clickPreferredClass();
		f.clickEconomy();
	}

	@Test(enabled = false)
	public void travellerTest() {
		f.clickVacationPackagesTab();
		f.clickTraveler();
		// Add 5 rooms
		for (int x = 0; x < 5; x++) {
			f.clickTravellersAddRoom();
		}
		// Set the number of adults, children and infants to 6 in all the rooms.
		for (int room = 1; room < 7; room++) {
			while (f.getTravellerAdultCount(room) != 6) {
				f.clickTravellersAdultsInc(room);
			}
			while (f.getTravellerChildCount(room) != 6) {
				f.clickTravellersChildrenInc(room);
			}
			while (f.getTravellerInfantCount(room) != 6) {
				f.clickTravellersInfantsInc(room);
			}
		}

		// Set the age of the children in each room from 5-10. (Child 1 = 5, Child 2 =
		// 6, Child 3 = 7, etc.)
		// Set the age of every 2nd infant in each room to 1, else set it to under 1.
		for (int room = 1; room < 7; room++) {
			for (int x = 1; x < 7; x++) {
				f.selectChildAge(room, x, Integer.toString(x + 4));
				if (x % 2 == 0) {
					f.selectInfantAge(room, x, 1);
				} else {
					f.selectInfantAge(room, x, 0);
				}
			}
		}
		// Set the number of adults to 1.
		// Set the number of children and infants to 0.
		for (int room = 6; room > 0; room--) {
			while (f.getTravellerAdultCount(room) != 1) {
				f.clickTravellersAdultsDec(room);
			}
			while (f.getTravellerChildCount(room) != 0) {
				f.clickTravellersChildrenDec(room);
			}
			while (f.getTravellerInfantCount(room) != 0) {
				f.clickTravellersInfantsDec(room);
			}
		}
		// Remove all the rooms
		for (int room = 6; room > 1; room--) {
			f.clickTravellersRemoveRoom(room);
		}
		f.clickTravellersInfantsInc(1);
		f.clickChildInSeat();
		f.clickChildOnLap();
		f.clickTravellersDone();
		f.clickTraveler();
		f.clickAirlineAgeRules();
	}
}
