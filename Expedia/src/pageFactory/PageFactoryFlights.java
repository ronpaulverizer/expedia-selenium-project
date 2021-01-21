package pageFactory;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactoryFlights {
	private WebDriver driver;

	@FindBy(xpath = "//button[@data-testid='submit-button']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[@href='?pwaLob=wizard-flight-pwa']")
	private WebElement flightsTab;

	@FindBy(xpath = "//a[@href='?flightType=roundtrip']")
	private WebElement flightsRoundtrip;

	@FindBy(xpath = "//a[@href='?flightType=oneway']")
	private WebElement flightsOneWay;

	@FindBy(xpath = "//a[@href='?flightType=multicity']")
	private WebElement flightsMultiCity;

	@FindBy(xpath = "//button[@data-stid='location-field-leg1-origin-menu-trigger']")
	private WebElement flightsLeavingFromButton;

	@FindBy(xpath = "//button[@data-stid='location-field-leg1-destination-menu-trigger']")
	private WebElement flightsGoingTo;

	@FindBy(xpath = "//a[@data-testid='travelers-field']")
	private WebElement flightsTravelerAnchor;

	@FindBy(id = "preferred-class-input-trigger")
	private WebElement flightsClassAnchor;

	@FindBy(xpath = "//div[@role='menu']/a[text()='Economy']")
	private WebElement flightsEconomy;

	@FindBy(xpath = "//a[text()='Premium economy']")
	private WebElement flightsPremiumEconomy;

	@FindBy(xpath = "//a[text()='Business class']")
	private WebElement flightsBusinessClass;

	@FindBy(xpath = "//a[text()='First class']")
	private WebElement flightsFirstClass;

	@FindBy(id = "location-field-leg1-origin")
	private WebElement flightsLeavingFromInput;

	@FindBy(id = "location-field-leg1-destination")
	private WebElement flightsGoingToInput;

	@FindBy(xpath = "//button[@data-testid='guests-done-button']")
	private WebElement travellersDone;

	@FindBy(xpath = "//div[contains(@class,'adultStepInput')]/div/button[1]")
	private WebElement flightsTravellersAdultDec;

	@FindBy(xpath = "//div[contains(@class,'adultStepInput')]/div/button[2]")
	private WebElement flightsTravellersAdultInc;

	@FindBy(xpath = "//div[contains(@class,'childStepInput')][1]/div/button[1]")
	private WebElement flightsTravellersChildDec;

	@FindBy(xpath = "//div[contains(@class,'childStepInput')][1]/div/button[2]")
	private WebElement flightsTravellersChildInc;

	@FindBy(xpath = "//div[contains(@class,'childStepInput')][2]/div/button[1]")
	private WebElement flightsTravellersInfantsDec;

	@FindBy(xpath = "//div[contains(@class,'childStepInput')][2]/div/button[2]")
	private WebElement flightsTravellersInfantsInc;

	@FindBy(id = "ChildOnLap")
	private WebElement travellersChildOnLap;

	@FindBy(id = "ChildInSeat")
	private WebElement travellersChildInSeat;

	@FindBy(xpath = "//button[text()='Add another flight']")
	private WebElement addAnotherFlight;

	@FindBy(xpath = "//fieldset[1]//button[@data-stid='location-field-leg1-destination-menu-trigger']")
	private WebElement multiCityFlight1Going;

	@FindBy(xpath = "//fieldset[1]//button[@id='d1-btn']")
	private WebElement multiCityFlight1OpenCalendar;

	/**
	 * This button opens the calendar to select a check in date.
	 */
	@FindBy(id = "d1-btn")
	private WebElement checkInButton;

	/**
	 * This button opens the calendar to select a check out date.
	 */
	@FindBy(id = "d2-btn")
	private WebElement checkOutButton;

	/**
	 * This button is in the calendar date selector panel. It allows the user to
	 * select a check in date.
	 */
	@FindBy(xpath = "//div[@class='uitk-flex uitk-flex-align-items-center uitk-toolbar uitk-new-date-picker-toolbar']/section/section/button[@type='button'][1]")
	private WebElement calendarCheckInButton;

	/**
	 * This button is in the calendar date selector panel. It allows the user to
	 * select a check out date.
	 */
	@FindBy(xpath = "//div[@class='uitk-flex uitk-flex-align-items-center uitk-toolbar uitk-new-date-picker-toolbar']/section/section/button[@type='button'][2]")
	private WebElement calendarCheckOutButton;

	@FindBy(xpath = "//div[@class='uitk-flex uitk-flex-justify-content-space-between uitk-new-date-picker-menu-pagination-container']/button[1]")
	private WebElement calendarBackArrow;

	@FindBy(xpath = "//div[@class='uitk-flex uitk-flex-justify-content-space-between uitk-new-date-picker-menu-pagination-container']/button[2]")
	private WebElement calendarForwardArrow;

	@FindBy(xpath = "//button[@data-stid='apply-date-picker']")
	private WebElement calendarDoneButton;

	@FindBy(id = "airline-age-rules")
	private WebElement airlineAgeRules;

	/*
	 * Constructor for the page factory. Set this class's driver to the driver
	 * passed from the test class. Initiate the elements listed above for use in our
	 * methods
	 */
	public PageFactoryFlights(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks the "Roundtrip" anchor tag in the Flights tab.
	 */
	public void clickRoundtrip() {
		flightsRoundtrip.click();
	}

	/**
	 * Clicks the "One-way" anchor tag in the Flights tab.
	 */
	public void clickOneWay() {
		flightsOneWay.click();
	}

	/**
	 * Clicks the "Multi-city" anchor tag in the Flights tab.
	 */
	public void clickMultiCity() {
		flightsMultiCity.click();
	}

	/**
	 * Clicks the "Leaving from" button in the Flights tab so that we may send keys
	 * to the input.
	 */
	public void clickLeavingFrom() {
		flightsLeavingFromButton.click();
	}

	/**
	 * Clicks the "Going to" button in the Flights tab so that we may send keys to
	 * the input.
	 */
	public void clickGoingTo() {
		flightsGoingTo.click();
	}

	/**
	 * Clicks the traveler anchor tag so that the user may access the "Travellers"
	 * submenu.
	 */
	public void clickTraveler() {
		flightsTravelerAnchor.click();
	}

	/**
	 * Clicks the preferred class anchor tag in the "Flights" tab so that the user
	 * may select which class of fight they wish to book. (Default "Economy")
	 */
	public void clickPreferredClass() {
		flightsClassAnchor.click();
	}

	/**
	 * Clicks the "Economy" menu option in the preferred class drop down menu in the
	 * "Flights" tab.
	 */
	public void clickEconomy() {
		flightsEconomy.click();
	}

	/**
	 * Clicks the "Premium economy" menu option in the preferred class drop down
	 * menu in the "Flights" tab.
	 */
	public void clickPremiumEconomy() {
		flightsPremiumEconomy.click();
	}

	/**
	 * Clicks the "Business class" menu option in the preferred class drop down menu
	 * in the "Flights" tab.
	 */
	public void clickBusinessClass() {
		flightsBusinessClass.click();
	}

	/**
	 * Clicks the "First class" menu option in the preferred class drop down menu in
	 * the "Flights" tab.
	 */
	public void clickFirstClass() {
		flightsFirstClass.click();
	}

	/**
	 * Clears and sends keys to the "Leaving from" input in the flights tab.
	 * Requires clicking the input first. (Use clickFlightsLeavingFrom())
	 * 
	 * @param keys Keys that will be entered.
	 */
	public void sendKeysLeaving(String keys) {
		flightsLeavingFromInput.clear();
		flightsLeavingFromInput.sendKeys(keys);
	}

	/**
	 * Clears and sends keys to the "Going to" input in the flights tab. Requires
	 * clicking the input first. (Use clickFlightsGoingTo())
	 * 
	 * @param keys Keys that will be entered.
	 */
	public void sendKeysGoing(String keys) {
		flightsGoingToInput.clear();
		flightsGoingToInput.sendKeys(keys);
	}

	/**
	 * Clicks the "Done" button in the "Travellers" panel.
	 */
	public void clickTravellersDone() {
		travellersDone.click();
	}

	/**
	 * Clicks on the decrease button for adults in the travellers panel.
	 */
	public void clickTravellersAdultsDec() {
		flightsTravellersAdultDec.click();
	}

	/**
	 * Clicks on the increase button for adults in the travellers panel.
	 */
	public void clickTravellersAdultsInc() {
		flightsTravellersAdultInc.click();
	}

	/**
	 * Clicks on the decrease button for children in the travellers panel.
	 */
	public void clickTravellersChildrenDec() {
		flightsTravellersChildDec.click();
	}

	/**
	 * Clicks on the increase button for children in the travellers panel.
	 */
	public void clickTravellersChildrenInc() {
		flightsTravellersChildInc.click();
	}

	/**
	 * Clicks on the decrease button for infants in the travellers panel.
	 */
	public void clickTravellersInfantsDec() {
		flightsTravellersInfantsDec.click();
	}

	/**
	 * Clicks on the increase button for infants in the travellers panel.
	 */
	public void clickTravellersInfantsInc() {
		flightsTravellersInfantsInc.click();
	}

	/**
	 * Clicks the "On lap" radio button in the travellers panel.
	 */
	public void clickTravellersOnLap() {
		travellersChildOnLap.click();
	}

	/**
	 * Clicks the "In seat" radio button in the travellers panel.
	 */
	public void clickTravellersInSeat() {
		travellersChildInSeat.click();
	}

	/**
	 * Clicks "Add another flight" in the "Multi-city" subtab in the "Flights" tab.
	 */
	public void clickAddAnotherFlight() {
		addAnotherFlight.click();
	}

	/**
	 * Clicks on the "Flights" tab.
	 */
	public void clickFlightsTab() {
		flightsTab.click();
	}

	/**
	 * Clicks a search result generated after typing in a location in one of the
	 * search fields, (Leaving from, Going to, etc)
	 * 
	 * @param city   - This parameter is the top bolded text that appears in one of
	 *               the search results. (e.g., New York (JFK - John F. Kennedy
	 *               Intl.)
	 * @param region - This parameter is the bottom text that appears in one of the
	 *               search results. (e.g., New York, United States of America)
	 */

	public void clickSearchResult(String city, String region) {
		String xpath = "//button[normalize-space()='" + city + region
				+ "' and not(ancestor-or-self::div[@aria-hidden='true'])]";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		searchResult.click();
	}

	/**
	 * Clicks on the check in date button in the calendar date picker panel so that
	 * the user can click a date on the calendar and set it as their check in date.
	 */
	public void clickCalendarCheckInDate() {
		calendarCheckInButton.click();
	}

	/**
	 * Clicks on the check out date button in the calendar date picker panel so that
	 * the user can click a date on the calendar and set it as their check out date.
	 */
	public void clickCalendarCheckOutDate() {
		calendarCheckOutButton.click();
	}

	/**
	 * Clicks on the back arrow button in the calendar date picker panel.
	 */
	public void clickCalendarBackArrow() {
		calendarBackArrow.click();
	}

	/**
	 * Clicks on the forward arrow button in the calendar date picker panel.
	 */
	public void clickCalendarForwardArrow() {
		calendarForwardArrow.click();
	}

	/**
	 * Clicks on the done button in the calendar date picker panel.
	 */
	public void clickCalendarDone() {
		calendarDoneButton.click();
	}

	/**
	 * Clicks the check in date button so the user may select a check in date from
	 * the calendar date picker panel. Works for all tabs except for "Multi-city" in
	 * flights tab.
	 */
	public void clickCalendarCheckIn() {
		checkInButton.click();
	}

	/**
	 * Clicks the check out date button so the user may select a check out date from
	 * the calendar date picker panel. Works for all tabs except for "Multi-city" in
	 * flights tab.
	 */
	public void clickCalendarCheckOut() {
		checkOutButton.click();
	}

	/**
	 * Sets the age for the specified infant in the travellers panel.
	 * 
	 * @param infant Which infant you'd like to edit. Range: 1-6
	 * @param age    The age you'd like to set it to. Range: 0-1, 0 being "Under 1".
	 */

	public void selectInfantAge(int infant, int age) {
		Select childAge = getInfantsAgeSelect(infant);
		childAge.selectByIndex(age);
	}

	/**
	 * Finds the specified infant age select element in the travellers panel.
	 *
	 * @param infant The infant number for the select element you wish to find.
	 *               Range: 1-6
	 * @return The age select element for the specified infant.
	 */
	private Select getInfantsAgeSelect(int infant) {
		WebElement element = driver.findElement(By.id("infant-age-input-0-" + (infant - 1)));
		Select childAge = new Select(element);
		return childAge;
	}

	/**
	 * Finds the specified child age select element in the travellers panel.
	 * 
	 * @param room  The room number in which the element is located. Range: 1-8
	 * @param child The child number. Range: 1-6
	 * @return The age select element for the specified child.
	 */
	private Select getChildAgeSelect(int room, int child) {
		WebElement element = driver.findElement(By.id("child-age-input-" + (room - 1) + "-" + (child - 1)));
		Select childAge = new Select(element);
		return childAge;
	}

	/**
	 * Sets the value of the Child Age drop down menu in the travellers panel.
	 * 
	 * @param child The child number. Range: 1-6
	 * @param age   The age to be set. Range: 2-17
	 */
	public void selectChildAge(int child, int age) {
		Select childAge = getChildAgeSelect(1, child);
		childAge.selectByIndex(age - 2);
	}

	/**
	 * Finds the "Remove" button for a specified flight in the "Multi-city" subtab
	 * in the "Flights" tab.
	 * 
	 * @param flight Which flight you'd like to remove. Range (3-5)
	 * @return The "Remove" button as a WebElement.
	 */
	private WebElement getRemoveButton(int flight) {
		WebElement element = driver.findElement(By.xpath("//fieldset[" + flight + "]//button[@id='removeFlightLeg']"));
		return element;
	}

	/**
	 * Clicks the "Remove" button for a specified flight in the "Multi-city" subtab
	 * in the "Flights" tab.
	 * 
	 * @param flight Which flight you'd like to remove. Range (3-5). Note that it's
	 *               not necessary, for example, to click the remove button under
	 *               Flight 5 to remove Flight 5. You may click the remove button
	 *               under Flight 3 or Flight 4 and remove Flight 5.
	 * @return
	 */

	public void clickRemove(int flight) {
		WebElement element = getRemoveButton(flight);
		element.click();
	}

	/**
	 * Finds the specified "Leaving from" button in the "Multi-city" subtab in the
	 * "Flights" tab.
	 * 
	 * @param flight The corresponding flight for the "Leaving from" button we are
	 *               looking for. Range (1-5)
	 * @return The "Leaving from" button.
	 */
	private WebElement getMultiCityLeavingFromButton(int flight) {
		// Declare the WebElement that we will be returning.
		WebElement element = null;

		/*
		 * If we are looking for the "Leaving from" button for flights 1 or 2, our xpath
		 * must specify which fieldset we are looking under, because the "Leaving from"
		 * buttons for flights 1 & 2 share the exact same "data-stid" property that we
		 * use to identify these elements.
		 */

		if (flight == 1 || flight == 2) {
			element = driver.findElement(By
					.xpath("//fieldset[" + flight + "]//button[@data-stid='location-field-leg1-origin-menu-trigger']"));
		}
		/*
		 * Else, use a parameterized form of this xpath:
		 * //button[@data-stid='location-field-leg<<flight-1>>-origin-menu-trigger']
		 */
		else if (flight > 2 && flight < 6) {
			element = driver.findElement(
					By.xpath("//button[@data-stid='location-field-leg" + (flight - 1) + "-origin-menu-trigger']"));
		}
		return element;
	}

	/**
	 * Clicks the specified "Leaving from" button in the "Multi-city" subtab in the
	 * "Flights" tab.
	 * 
	 * @param flight The corresponding flight for the "Leaving from" button we want
	 *               to click. Range (1-5)
	 */
	public void clickMultiCityLeavingFrom(int flight) {
		WebElement element = getMultiCityLeavingFromButton(flight);
		element.click();
	}

	/**
	 * Finds the specified "Going to" button in the "Multi-city" subtab in the
	 * "Flights" tab.
	 * 
	 * @param flight The corresponding flight for the "Going to" button we are
	 *               looking for. Range (1-5)
	 * @return The "Going to" button.
	 */
	private WebElement getMultiCityGoingToButton(int flight) {
		// Declare the WebElement that we will be returning.
		WebElement element = null;

		/*
		 * If we are looking for the "Going to" button for flights 1 or 2, our xpath
		 * must specify which fieldset we are looking under, because the "Going to"
		 * buttons for flights 1 & 2 share the exact same "data-stid" property that we
		 * use to identify these elements.
		 */

		if (flight == 1 || flight == 2) {
			element = driver.findElement(By.xpath(
					"//fieldset[" + flight + "]//button[@data-stid='location-field-leg1-destination-menu-trigger']"));
		}
		/*
		 * Else, use the paramterized form of this xpath:
		 * //button[@data-stid='location-field-leg<<flight-1>>-destination-menu-trigger'
		 * ]
		 */
		else if (flight > 2 && flight < 6) {
			element = driver.findElement(
					By.xpath("//button[@data-stid='location-field-leg" + (flight - 1) + "-destination-menu-trigger']"));
		}
		return element;
	}

	/**
	 * Clicks the specified "Going to" button in the "Multi-city" subtab in the
	 * "Flights" tab.
	 * 
	 * @param flight The corresponding flight for the "Going to" button we want to
	 *               click. Range (1-5)
	 */
	public void clickMultiCityGoingTo(int flight) {
		WebElement element = getMultiCityGoingToButton(flight);
		element.click();
	}

	private WebElement getMultiCityOpenCalendarButton(int flight) {
		// Declare the element we will be returning
		WebElement element = null;

		/*
		 * Find the element by using a parameterized form of this xpath:
		 * //fieldset[flight]//button[@id='d1-btn']
		 */
		element = driver.findElement(By.xpath("//fieldset[" + flight + "]//button[@id='d1-btn']"));
		return element;
	}

	public void clickMultiCityDeparting(int flight) {
		WebElement element = getMultiCityOpenCalendarButton(flight);
		element.click();
	}

	/**
	 * Finds the specified "Leaving from" input in the "Multi-city" subtab in the
	 * "Flights" tab.
	 * 
	 * @param flight The corresponding flight for the "Leaving from" input we are
	 *               looking for. Range (1-5)
	 * @return The "Leaving from" input.
	 */
	private WebElement getMultiCityLeavingFromInput(int flight) {
		// Declare the WebElement that we will be returning.
		WebElement element = null;

		/*
		 * If we are looking for the "Leaving from" input for flights 1 or 2, our xpath
		 * must specify which fieldset we are looking under, because the "Leaving from"
		 * inputs for flights 1 & 2 share the exact same "data-stid" property that we
		 * use to identify these elements.
		 */

		if (flight == 1 || flight == 2) {
			element = driver
					.findElement(By.xpath("//fieldset[" + flight + "]//input[@id='location-field-leg1-origin']"));
		}
		/*
		 * Else, use a parameterized form of this xpath:
		 * //input[@id='location-field-leg<<flight-1>>-origin']
		 */
		else if (flight > 2 && flight < 6) {
			element = driver.findElement(By.xpath("//input[@id='location-field-leg" + (flight - 1) + "-origin']"));
		}
		return element;
	}

	/**
	 * Sends keys to the specified "Leaving from" input field in the "Multi-city"
	 * subtab in the "Flights" tab.
	 * 
	 * @param keys   Keys to be typed in the input.
	 * @param flight The flight number corresponding to the input. Range: (1-5)
	 */
	public void sendKeysMultiCityLeaving(String keys, int flight) {
		WebElement element = getMultiCityLeavingFromInput(flight);
		element.clear();
		element.sendKeys(keys);
	}

	/**
	 * Finds the specified "Going to" input in the "Multi-city" subtab in the
	 * "Flights" tab.
	 * 
	 * @param flight The corresponding flight for the "Going to" input we are
	 *               looking for. Range (1-5)
	 * @return The "Going to" input.
	 */
	private WebElement getMultiCityGoingToInput(int flight) {
		// Declare the WebElement that we will be returning.
		WebElement element = null;

		/*
		 * If we are looking for the "Going to" input for flights 1 or 2, our xpath must
		 * specify which fieldset we are looking under, because the "Going to" inputs
		 * for flights 1 & 2 share the exact same "data-stid" property that we use to
		 * identify these elements.
		 */

		if (flight == 1 || flight == 2) {
			element = driver
					.findElement(By.xpath("//fieldset[" + flight + "]//input[@id='location-field-leg1-destination']"));
		}
		/*
		 * Else, use a parameterized form of this xpath:
		 * //input[@id='location-field-leg<<flight-1>>-destination']
		 */
		else if (flight > 2 && flight < 6) {
			element = driver.findElement(By.xpath("//input[@id='location-field-leg" + (flight - 1) + "-destination']"));
		}
		return element;
	}

	/**
	 * Sends keys to the specified "Going to" input in the "multi-city" subtab in
	 * the "Flights" tab.
	 * 
	 * @param keys   The keys you want to type into the input.
	 * @param flight The corresponding flight of the input.
	 */
	public void sendKeysMultiCityGoing(String keys, int flight) {
		WebElement element = getMultiCityGoingToInput(flight);
		element.clear();
		element.sendKeys(keys);
	}

	/**
	 * Clicks the "Airline age rules" hyperlink in the travellers panel.
	 */
	public void clickAirlineAgeRules() {
		airlineAgeRules.click();
	}

	/**
	 * Clicks the blue "Search" button so that we may submit our information.
	 */
	public void clickSearchButton() {
		searchButton.click();
	}

	/**
	 * Clicks on the specified day button in the calendar date picker panel.
	 * 
	 * @param month    The month for the date we are selecting. E.g.,
	 *                 "Month.FEBRUARY"
	 * @param date     The day number for the date we are selecting.
	 * @param calendar The year for the date we are selecting.
	 */
	public void clickCalendarDay(Month month, int date, int year) {
		WebElement calendarDay = driver.findElement(By.xpath("//button[@aria-label='"
				+ month.getDisplayName(TextStyle.SHORT, Locale.US) + " " + date + ", " + year + "']"));
		calendarDay.click();
	}
}
