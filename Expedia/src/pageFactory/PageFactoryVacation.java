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

public class PageFactoryVacation {
	private WebDriver driver;

	@FindBy(xpath = "//a[@href='?pwaLob=wizard-package-pwa']")
	private WebElement vacationPackagesTab;

	@FindBy(xpath = "//label[@for='package-pills-hotels']")
	private WebElement staysSubTab;

	@FindBy(xpath = "//label[@for='package-pills-flights']")
	private WebElement flightsSubTab;

	@FindBy(xpath = "//label[@for='package-pills-cars']")
	private WebElement carsSubTab;

	@FindBy(xpath = "//button[@data-stid='location-field-origin-menu-trigger']")
	private WebElement leavingFromButton;

	@FindBy(id = "location-field-origin")
	private WebElement leavingFromInput;

	@FindBy(xpath = "//button[@data-stid='location-field-destination-menu-trigger']")
	private WebElement goingToButton;

	@FindBy(id = "location-field-destination")
	private WebElement goingToInput;

	@FindBy(xpath = "//button[@id='d1-btn' and contains(@aria-label,'Departing')]")
	private WebElement departingButton;

	@FindBy(xpath = "//button[@id='d2-btn' and contains(@aria-label,'Returning')]")
	private WebElement returningButton;

	@FindBy(xpath = "//button[@id='d1-btn' and contains(@aria-label,'Check-in')]")
	private WebElement checkInButton;

	@FindBy(xpath = "//button[@id='d2-btn' and contains(@aria-label,'Check-out')]")
	private WebElement checkOutButton;

	@FindBy(id = "package-partial-stay")
	private WebElement partAccommodations;

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

	@FindBy(id = "preferred-class-input-trigger")
	private WebElement classAnchor;

	@FindBy(xpath = "//div[@role='menu']/a[text()='Economy']")
	private WebElement economy;

	@FindBy(xpath = "//a[text()='Premium economy']")
	private WebElement premiumEconomy;

	@FindBy(xpath = "//a[text()='Business class']")
	private WebElement businessClass;

	@FindBy(xpath = "//a[text()='First class']")
	private WebElement firstClass;

	@FindBy(xpath = "//a[@data-testid='travelers-field']")
	private WebElement travelerAnchor;

	@FindBy(xpath = "//button[@data-testid='add-room-button']")
	private WebElement travellersAddAnotherRoom;

	@FindBy(id = "ChildInSeat")
	private WebElement childInSeat;

	@FindBy(id = "ChildOnLap")
	private WebElement childOnLap;

	@FindBy(id = "airline-age-rules")
	private WebElement airlineAgeRules;

	@FindBy(xpath = "//button[@data-testid='submit-button']")
	private WebElement searchButton;

	@FindBy(xpath = "//button[@data-testid='guests-done-button']")
	private WebElement travellersDone;

	/*
	 * Constructor for the page factory. Set this class's driver to the driver
	 * passed from the test class. Initiate the elements listed above for use in our
	 * methods
	 */
	public PageFactoryVacation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on the "Vacation packages" tab.
	 */
	public void clickVacationPackagesTab() {
		vacationPackagesTab.click();
	}

	/**
	 * Clicks the "Stays" pill subtab.
	 */
	public void clickStaysSubTab() {
		staysSubTab.click();
	}

	/**
	 * Clicks the "Flights" pill subtab.
	 */
	public void clickFlightsSubTab() {
		flightsSubTab.click();
	}

	/**
	 * Clicks the "Cars" pill subtab.
	 */
	public void clickCarsSubTab() {
		carsSubTab.click();
	}

	/**
	 * Clicks the "Leaving from" button so that we may send keys to its input.
	 */
	public void clickLeavingFrom() {
		leavingFromButton.click();
	}

	/**
	 * Sends keys to the "Leaving from" input. Requires clicking the "Leaving from"
	 * button first, (use <b>clickLeavingFrom()</b>)
	 */
	public void sendKeysLeavingFrom(String keysToSend) {
		leavingFromInput.clear();
		leavingFromInput.sendKeys(keysToSend);
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
	 * Clicks the "Going to" button so that we may send keys to its input.
	 */
	public void clickGoingTo() {
		goingToButton.click();
	}

	/**
	 * Sends keys to the "Going to" input. Requires clicking the "Going to" button
	 * first, (use <b>clickGoingTo()</b>)
	 */
	public void sendKeysGoingTo(String keysToSend) {
		goingToInput.clear();
		goingToInput.sendKeys(keysToSend);
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
	 * Clicks the preferred class anchor tag in the "Vacation packages" tab so that
	 * the user may select which class of fight they wish to book. (Default
	 * "Economy")
	 */
	public void clickPreferredClass() {
		classAnchor.click();
	}

	/**
	 * Clicks the "Economy" menu option in the preferred class drop down menu in the
	 * "Vacation packages" tab.
	 */
	public void clickEconomy() {
		economy.click();
	}

	/**
	 * Clicks the "Premium economy" menu option in the preferred class drop down
	 * menu in the "Vacation packages" tab.
	 */
	public void clickPremiumEconomy() {
		premiumEconomy.click();
	}

	/**
	 * Clicks the "Business class" menu option in the preferred class drop down menu
	 * in the "Vacation packages" tab.
	 */
	public void clickBusinessClass() {
		businessClass.click();
	}

	/**
	 * Clicks the "First class" menu option in the preferred class drop down menu in
	 * the "Vacation packages" tab.
	 */
	public void clickFirstClass() {
		firstClass.click();
	}

	/**
	 * Clicks the traveler anchor tag so that the user may access the "Travellers"
	 * submenu.
	 */
	public void clickTraveler() {
		travelerAnchor.click();
	}

	/**
	 * Finds the decrease button for adults in the Travellers panel.
	 * 
	 * @param room The room number of the element. Range: 1-6
	 * @return Returns the adults decrease button.
	 */
	private WebElement getTravellersAdultsDec(int room) {
		WebElement element = driver.findElement(By
				.xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'adultStepInput')]/div/button[1]"));
		return element;
	}

	/**
	 * Finds the increase button for adults in the Travellers panel.
	 * 
	 * @param room The room number of the element. Range: 1-6
	 * @return Returns the adults increase button.
	 */
	private WebElement getTravellersAdultsInc(int room) {
		WebElement element = driver.findElement(By
				.xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'adultStepInput')]/div/button[2]"));
		return element;
	}

	/**
	 * Finds the decrease button for children in the Travellers panel.
	 * 
	 * @param room The room number of the element. Range: 1-6
	 * @return Returns the children decrease button.
	 */
	private WebElement getTravellersChildrenDec(int room) {
		WebElement element = driver.findElement(By.xpath("//div[@data-testid='room-" + room
				+ "']/div[descendant::label[@for='child-input-" + (room - 1) + "']]/div/button[1]"));
		return element;
	}

	/**
	 * Finds the decrease button for children in the Travellers panel.
	 * 
	 * @param room The room number of the element. Range: 1-6
	 * @return Returns the children increase button.
	 */
	private WebElement getTravellersChildrenInc(int room) {
		WebElement element = driver.findElement(By.xpath("//div[@data-testid='room-" + room
				+ "']/div[descendant::label[@for='child-input-" + (room - 1) + "']]/div/button[2]"));
		return element;
	}

	/**
	 * Finds the decrease button for infants in the Travellers panel.
	 * 
	 * @param room The room number of the element. Range: 1-6
	 * @return Returns the infants decrease button.
	 */
	private WebElement getTravellersInfantsDec(int room) {
		WebElement element = driver.findElement(By.xpath("//div[@data-testid='room-" + room
				+ "']/div[descendant::label[@for='infant-input-" + (room - 1) + "']]/div/button[1]"));
		return element;
	}

	/**
	 * Finds the decrease button for infants in the Travellers panel.
	 * 
	 * @param room The room number of the element. Range: 1-6
	 * @return Returns the infants increase button.
	 */
	private WebElement getTravellersInfantsInc(int room) {
		WebElement element = driver.findElement(By.xpath("//div[@data-testid='room-" + room
				+ "']/div[descendant::label[@for='infant-input-" + (room - 1) + "']]/div/button[2]"));
		return element;
	}

	/**
	 * Finds the remove room button for a specified room in the Travellers panel.
	 * 
	 * @param room The room number of the element. Range: 2-6
	 * @return Returns the remove room button.
	 */
	private WebElement getTravellersRemoveRoom(int room) {
		WebElement element = driver.findElement(By.xpath("//div[@data-testid='room-" + room
				+ "']/div[@class='removeRoomButton uitk-type-right all-t-padding-four']/button"));
		return element;
	}

	/**
	 * Clicks the add another room button. You may only have a maximum of 6 rooms.
	 */
	public void clickTravellersAddRoom() {
		travellersAddAnotherRoom.click();
	}

	/**
	 * Clicks the remove room button. There must be at least 2 rooms available on
	 * the travellers panel.
	 * 
	 * @param room The room number of the element. Range: 2-6
	 */
	public void clickTravellersRemoveRoom(int room) {
		getTravellersRemoveRoom(room).click();
	}

	/**
	 * Clicks on the decrease button for adults in the travellers panel.
	 * 
	 * @param room The room number in which the element is located. Range: 1-6
	 */
	public void clickTravellersAdultsDec(int room) {
		getTravellersAdultsDec(room).click();
	}

	/**
	 * Clicks on the increase button for adults in the travellers panel.
	 * 
	 * @param room The room number in which the element is located. Range: 1-6
	 */
	public void clickTravellersAdultsInc(int room) {
		getTravellersAdultsInc(room).click();
	}

	/**
	 * Clicks on the decrease button for children in the travellers panel.
	 * 
	 * @param room The room number in which the element is located. Range: 1-6
	 */
	public void clickTravellersChildrenDec(int room) {
		getTravellersChildrenDec(room).click();
	}

	/**
	 * Clicks on the increase button for children in the travellers panel.
	 * 
	 * @param room The room number in which the element is located. Range: 1-6
	 */
	public void clickTravellersChildrenInc(int room) {
		getTravellersChildrenInc(room).click();
	}

	/**
	 * Clicks on the decrease button for infants in the travellers panel.
	 * 
	 * @param room The room number in which the element is located. Range: 1-6
	 */
	public void clickTravellersInfantsDec(int room) {
		getTravellersInfantsDec(room).click();
	}

	/**
	 * Clicks on the increase button for infants in the travellers panel.
	 * 
	 * @param room The room number in which the element is located. Range: 1-6
	 */
	public void clickTravellersInfantsInc(int room) {
		getTravellersInfantsInc(room).click();
	}

	/**
	 * Finds the specified child age select element in the travellers panel.
	 * 
	 * @param room  The room number in which the element is located. Range: 1-6
	 * @param child The child number. Range: 1-6
	 * @return The age select element for the specified child.
	 */
	private Select getChildAgeSelect(int room, int child) {
		WebElement element = driver.findElement(By.id("child-age-input-" + (room - 1) + "-" + (child - 1)));
		Select childAge = new Select(element);
		return childAge;
	}

	/**
	 * Finds the specified infant age select element in the travellers panel.
	 * 
	 * @param room   The room number in which the element is located. Range: 1-6
	 * @param infant The infant number. Range: 1-6
	 * @return The age select element for the specified infant.
	 */
	private Select getInfantAgeSelect(int room, int infant) {
		WebElement element = driver.findElement(By.id("infant-age-input-" + (room - 1) + "-" + (infant - 1)));
		Select infantAge = new Select(element);
		return infantAge;
	}

	/**
	 * Sets the value of the Child Age select in the travellers panel.
	 * 
	 * @param room  The room number in which the element is located. Range: 1-6
	 * @param child The child number. Range: 1-6
	 * @param age   The age to be set. Range: 2-17.
	 */
	public void selectChildAge(int room, int child, String age) {
		Select childAge = getChildAgeSelect(room, child);
		childAge.selectByValue(age);
	}

	/**
	 * Sets the value of the Infant Age select in the travellers panel.
	 * 
	 * @param room   The room number in which the element is located. Range: 1-6
	 * @param infant The child number. Range: 1-6
	 * @param age    The age to be set. Range: 0-1, 0 being "Under 1"
	 */
	public void selectInfantAge(int room, int infant, int age) {
		Select infantAge = getInfantAgeSelect(room, infant);
		infantAge.selectByIndex(age);
	}

	/**
	 * Clicks the "Airline age rules" hyperlink in the travellers panel.
	 */
	public void clickAirlineAgeRules() {
		airlineAgeRules.click();
	}

	/**
	 * Clicks the "I only need accommodations for part of my trip" checkbox.
	 */
	public void clickAccommodationsCheckbox() {
		partAccommodations.click();
	}

	/**
	 * Clicks the "Departing" button so the user can access the calendar date picker
	 * panel.
	 */
	public void clickDepartingButton() {
		departingButton.click();
	}

	/**
	 * Clicks the "Returning" button so the user can access the calendar date picker
	 * panel.
	 */
	public void clickReturningButton() {
		returningButton.click();
	}

	/**
	 * Clicks the "Check-in" button so the user can access the calendar date picker
	 * panel.
	 */
	public void clickCheckIn() {
		checkInButton.click();

	}

	/**
	 * Clicks the "Check-out" button so the user can access the calendar date picker
	 * panel.
	 */
	public void clickCheckOut() {
		checkOutButton.click();
	}

	/**
	 * Clicks the search button. Usable on all tabs, (stays, cars, flights, etc.)
	 */
	public void clickSearch() {
		searchButton.click();
	}

	/**
	 * Gets the count for Adults in the "Travellers" panel for the specified room.
	 * 
	 * @param room The respective room the counter is located in. Range: (1-6)
	 * @return The count for Adults as an integer.
	 */
	public int getTravellerAdultCount(int room) {
		int count = 0;
		WebElement adultCount = driver.findElement(By.id("adult-input-" + (room - 1)));
		count = Integer.parseInt(adultCount.getAttribute("value"));
		return count;
	}

	/**
	 * Gets the count for Children in the "Travellers" panel for the specified room.
	 * 
	 * @param room The respective room the counter is located in. Range: (1-6)
	 * @return The count for Children as an integer.
	 */
	public int getTravellerChildCount(int room) {
		int count = 0;
		WebElement childCount = driver.findElement(By.id("child-input-" + (room - 1)));
		count = Integer.parseInt(childCount.getAttribute("value"));
		return count;
	}

	/**
	 * Gets the count for Infants in the "Travellers" panel for the specified room.
	 * 
	 * @param room The respective room the counter is located in. Range: (1-6)
	 * @return The count for Infants as an integer.
	 */
	public int getTravellerInfantCount(int room) {
		int count = 0;
		WebElement childCount = driver.findElement(By.id("infant-input-" + (room - 1)));
		count = Integer.parseInt(childCount.getAttribute("value"));
		return count;
	}

	/**
	 * Clicks the "On lap" radio button in the "Travellers" panel.
	 */
	public void clickChildOnLap() {
		childOnLap.click();
	}

	/**
	 * Clicks the "In seat" radio button in the "Travellers" panel.
	 */
	public void clickChildInSeat() {
		childInSeat.click();
	}

	/**
	 * Clicks the "Done" button in the "Travellers" panel.
	 */
	public void clickTravellersDone() {
		travellersDone.click();
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
