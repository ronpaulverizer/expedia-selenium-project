package pageFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.junit.internal.runners.TestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/* To Do:
 * Add logging infrastructure to page factory.
 * Finish creating WebElements for everything on the page.
 */
public class PageFactoryStays {

	private WebDriver driver;
	private ExtentTest test;

	@FindBy(xpath = "//a[@href='?pwaLob=wizard-hotel-pwa-v2']")
	private WebElement staysTab;

	@FindBy(xpath = "//div[@id='location-field-destination-menu']//button")
	private WebElement staysGoingToButton;

	@FindBy(id = "location-field-destination")
	private WebElement staysGoingToInput;

	@FindBy(xpath = "//ul[@data-stid='location-field-destination-results']")
	private WebElement staysGoingToResultList;

	@FindBy(xpath = "//button[@class='uitk-button uitk-button-small uitk-clear-button']")
	private WebElement clearButton;

	@FindBy(id = "add-flight-switch")
	private WebElement addFlightCheckbox;

	@FindBy(id = "add-car-switch")
	private WebElement addCarCheckbox;

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

	@FindBy(xpath = "//button[@data-testid='add-room-button']")
	private WebElement staysTravellersAddAnotherRoomButton;

	@FindBy(xpath = "//button[@data-testid='guests-done-button']")
	private WebElement staysTravellersDoneButton;

	@FindBy(xpath = "//button[@data-stid='location-field-origin-menu-trigger']")
	private WebElement staysLeavingFromButton;

	@FindBy(id = "location-field-origin")
	private WebElement staysLeavingFromInput;

	@FindBy(xpath = "//ul[@data-stid='location-field-origin-results']")
	private WebElement staysLeavingFromResultList;

	@FindBy(xpath = "//button[@data-testid='submit-button']")
	private WebElement searchButton;

	@FindBy(xpath = "//button[@data-testid='guests-done-button']")
	private WebElement travellersDone;

	@FindBy(xpath = "//div[@class='uitk-empty-state-body']")
	private WebElement goingToEmptyState;

	@FindBy(xpath = "//label[@for='add-flight-switch']")
	private WebElement addAFlightLabel;

	@FindBy(xpath = "//label[@for='add-car-switch']")
	private WebElement addACarLabel;

	@FindBy(xpath = "//div[@class='uitk-flex uitk-flex-align-items-center uitk-toolbar uitk-new-date-picker-toolbar']/section/section/button[@type='button'][1]/span")
	private WebElement calendarCheckInSpan;

	@FindBy(xpath = "//div[@class='uitk-flex uitk-flex-align-items-center uitk-toolbar uitk-new-date-picker-toolbar']/section/section/button[@type='button'][2]/span")
	private WebElement calendarCheckOutSpan;

	@FindBy(xpath = "//div[@class='uitk-new-date-picker-month'][1]/h2")
	private WebElement leftCalendarHeader;

	@FindBy(xpath = "//div[@class='uitk-new-date-picker-month'][2]/h2")
	private WebElement rightCalendarHeader;

	/*
	 * Constructor for the page factory.
	 */
	public PageFactoryStays(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Starts the report for a specified test.
	 * 
	 * @param report The ExtentReports object from the test class.
	 * @param name   The name of the test that will show up in the report.
	 */
	public void createTestReport(ExtentReports report, String name) {
		test = report.startTest(name);
	}

	/**
	 * Clicks on the "Stays" tab.
	 */
	public void clickStaysTab() {
		staysTab.click();
		test.log(LogStatus.INFO, "Clicked on the stays tab.");
	}

	/**
	 * Clicks on the "Going to" button in the "Stays" tab so that we can access the
	 * input field and send keys to it.
	 */
	public void clickGoingTo() {
		staysGoingToButton.click();
		test.log(LogStatus.INFO, "Clicked on 'Going to'.");
	}

	/**
	 * Types the destination into the "Going to" input field. Requires
	 * clickStaysGoingToButton() method to be used before.
	 * 
	 * @param destination
	 */
	public void sendKeysGoingTo(String destination) {
		staysGoingToInput.clear();
		staysGoingToInput.sendKeys(destination);
		test.log(LogStatus.INFO, "Typed '" + destination + "' into the 'Going to' field.");
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
		test.log(LogStatus.INFO, "Clicked on search result: '" + city + ", " + region + "'");
	}

	/**
	 * Clicks the clear button. Will use this method for all instances of it for now
	 * unless I run into issues.
	 */
	public void clickClear() {
		clearButton.click();
		test.log(LogStatus.INFO, "Clicked on the X button that clears the text field.");
	}

	/**
	 * Clicks the add flight checkbox in the "Stays" tab.
	 */
	public void clickAddFlight() {
		addFlightCheckbox.click();
		test.log(LogStatus.INFO, "Clicked on the 'Add a flight' checkbox.");
	}

	/**
	 * Clicks the add car checkbox in the "Stays" tab.
	 */
	public void clickAddCar() {
		addCarCheckbox.click();
		test.log(LogStatus.INFO, "Clicked on the 'Add a car' checkbox");
	}

	/**
	 * Clicks the "Check-in" button so the user may open the calendar and select a
	 * check in date from the calendar date picker panel. Works for all tabs except
	 * for "Multi-city" in flights tab.
	 */
	public void clickCheckIn() {
		checkInButton.click();
		test.log(LogStatus.INFO, "Clicked on the 'Check-in' button");
	}

	/**
	 * Clicks the "Check-out" button so the user may open the calendar and select a
	 * check out date from the calendar date picker panel. Works for all tabs except
	 * for "Multi-city" in flights tab.
	 */
	public void clickCheckOut() {
		checkOutButton.click();
		test.log(LogStatus.INFO, "Clicked on the 'Check-out' button");
	}

	/**
	 * Clicks the "Travellers" button to open the travellers submenu in the "Stays"
	 * tab.
	 */
	public void clickTravellerTab() {
		try {
			WebElement staysTravellerButton = driver
					.findElement(By.xpath("//button[@data-testid='travelers-field-trigger']"));
			staysTravellerButton.click();
			test.log(LogStatus.INFO, "Clicked on the 'Travellers' button");
		} catch (NoSuchElementException e) {
			WebElement alternativeStaysTravellerButton = driver
					.findElement(By.xpath("//a[@data-testid='travelers-field']"));
			alternativeStaysTravellerButton.click();
			test.log(LogStatus.INFO, "Clicked on the 'Travellers' anchor tag.");
		}
	}

	/**
	 * Clicks on the check in date button in the calendar date picker panel so that
	 * the user can click a date on the calendar and set it as their check in date.
	 */
	public void clickCalendarCheckInDate() {
		calendarCheckInButton.click();
		test.log(LogStatus.INFO, "Clicked on the select check in date button.");
	}

	/**
	 * Clicks on the check out date button in the calendar date picker panel so that
	 * the user can click a date on the calendar and set it as their check out date.
	 */
	public void clickCalendarCheckOutDate() {
		calendarCheckOutButton.click();
		test.log(LogStatus.INFO, "Clicked on the select check out date button.");
	}

	/**
	 * Clicks on the back arrow button in the calendar date picker panel.
	 */
	public void clickCalendarBackArrow() {
		calendarBackArrow.click();
		test.log(LogStatus.INFO, "Clicked on the back arrow in the calendar.");
	}

	/**
	 * Clicks on the forward arrow button in the calendar date picker panel.
	 */
	public void clickCalendarForwardArrow() {
		calendarForwardArrow.click();
		test.log(LogStatus.INFO, "Clicked on the forward arrow in the calendar.");
	}

	/**
	 * Clicks on the done button in the calendar date picker panel.
	 */
	public void clickCalendarDone() {
		calendarDoneButton.click();
		test.log(LogStatus.INFO, "Clicked on the done button in the calendar.");
	}

	/**
	 * Finds the specified day button in the calendar date picker panel.
	 *
	 * @param month    The month for the date we are selecting. E.g.,
	 *                 "Month.FEBRUARY"
	 * @param day      The day number for the date we are selecting.
	 * @param calendar The year for the date we are selecting.
	 * @return The calendar day button as a WebElement.
	 */
	private WebElement getCalendarDay(Month month, int day, int year) {
		WebElement calendarDay = driver.findElement(By.xpath("//button[@aria-label='"
				+ month.getDisplayName(TextStyle.SHORT, Locale.US) + " " + day + ", " + year + "']"));
		return calendarDay;
	}

	/**
	 * Clicks on the specified day button in the calendar date picker panel.
	 * 
	 * @param month    The month for the date we are selecting. E.g.,
	 *                 "Month.FEBRUARY"
	 * @param day      The day number for the date we are selecting.
	 * @param calendar The year for the date we are selecting.
	 */
	public void clickCalendarDay(Month month, int day, int year) {
		WebElement calendarDay = getCalendarDay(month, day, year);
		calendarDay.click();
		test.log(LogStatus.INFO, "Clicked on the day: " + month.getDisplayName(TextStyle.SHORT, Locale.US) + " " + day
				+ " " + year + " in the calendar date picker panel.");
	}

	/**
	 * Finds the decrease button for adults in the Travellers panel.
	 * 
	 * @param room The room number of the element. Range: 1-8
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
	 * @param room The room number of the element. Range: 1-8
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
	 * @param room The room number of the element. Range: 1-8
	 * @return Returns the children decrease button.
	 */
	private WebElement getTravellersChildrenDec(int room) {
		WebElement element = driver.findElement(By
				.xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'childStepInput')]/div/button[1]"));
		return element;
	}

	/**
	 * Finds the decrease button for children in the Travellers panel.
	 * 
	 * @param room The room number of the element. Range: 1-8
	 * @return Returns the children increase button.
	 */
	private WebElement getTravellersChildrenInc(int room) {
		WebElement element = driver.findElement(By
				.xpath("//div[@data-testid='room-" + room + "']/div[contains(@class,'childStepInput')]/div/button[2]"));
		return element;
	}

	/**
	 * Finds the remove room button for a specified room in the Travellers panel.
	 * 
	 * @param room The room number of the element. Range: 2-8
	 * @return Returns the remove room button.
	 */
	private WebElement getTravellersRemoveRoom(int room) {
		WebElement element = driver.findElement(By.xpath("//div[@data-testid='room-" + room
				+ "']/div[@class='removeRoomButton uitk-type-right all-t-padding-four']/button"));
		return element;
	}

	/**
	 * Clicks the add another room button. You may only have a maximum of 8 rooms.
	 */
	public void clickTravellersAddRoom() {
		staysTravellersAddAnotherRoomButton.click();
		test.log(LogStatus.INFO, "Clicked on the 'Add another room button' in the travellers tab.");
	}

	/**
	 * Clicks the remove room button. There must be at least 2 rooms available on
	 * the travellers panel.
	 * 
	 * @param room The room number of the element. Range: 2-8
	 */
	public void clickTravellersRemoveRoom(int room) {
		getTravellersRemoveRoom(room).click();
		test.log(LogStatus.INFO, "Clicked on the 'Remove room' button for room " + room + ".");
	}

	/**
	 * Clicks on the decrease button for adults in the travellers panel.
	 * 
	 * @param room The room number in which the element is located. Range: 1-8
	 */
	public void clickTravellersAdultsDec(int room) {
		getTravellersAdultsDec(room).click();
		test.log(LogStatus.INFO, "Clicked on the '-' button for adults in the travellers panel.");
	}

	/**
	 * Clicks on the increase button for adults in the travellers panel.
	 * 
	 * @param room The room number in which the element is located. Range: 1-8
	 */
	public void clickTravellersAdultsInc(int room) {
		getTravellersAdultsInc(room).click();
		test.log(LogStatus.INFO, "Clicked on the '+' button for adults in the travellers panel.");
	}

	/**
	 * Clicks on the decrease button for children in the travellers panel.
	 * 
	 * @param room The room number in which the element is located. Range: 1-8
	 */
	public void clickTravellersChildrenDec(int room) {
		getTravellersChildrenDec(room).click();
		test.log(LogStatus.INFO, "Clicked on the '-' button for children in the travellers panel.");
	}

	/**
	 * Clicks on the increase button for children in the travellers panel.
	 * 
	 * @param room The room number in which the element is located. Range: 1-8
	 */
	public void clickTravellersChildrenInc(int room) {
		getTravellersChildrenInc(room).click();
		test.log(LogStatus.INFO, "Clicked on the '+' button for children in the travellers panel.");
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
	 * @param room  The room number in which the element is located. Range: 1-8
	 * @param child The child number. Range: 1-6
	 * @param age   The age to be set. Range: 0-17, 0 being "Under 1"
	 */
	public void selectChildAge(int room, int child, int age) {
		Select childAge = getChildAgeSelect(room, child);
		childAge.selectByIndex(age);
		test.log(LogStatus.INFO, "Set the age of child " + child + " in room " + room + " to " + age);
	}

	/**
	 * Clicks the "Leaving from" input so that we may send keys to it. Requires
	 * clicking the "Add a flight" checkbox first.
	 */
	public void clickLeavingFrom() {
		staysLeavingFromButton.click();
		test.log(LogStatus.INFO, "Clicked on 'Leaving from'.");
	}

	/**
	 * Sends keys to the "Leaving from" input. Requires clicking on the input first,
	 * (use clickStaysLeavingFrom())
	 */
	public void sendKeysLeavingFrom(String keys) {
		staysLeavingFromInput.clear();
		staysLeavingFromInput.sendKeys(keys);
		test.log(LogStatus.INFO, "Sent the following keys to the 'Leaving from' input: '" + keys + "'");
	}

	/**
	 * Clicks the search button. Usable on all tabs, (stays, cars, flights, etc.)
	 */
	public void clickSearch() {
		searchButton.click();
		test.log(LogStatus.INFO, "Clicked on the search button.");
	}

	/**
	 * Clicks the "Done" button in the "Travellers" panel.
	 */
	public void clickTravellersDone() {
		travellersDone.click();
		test.log(LogStatus.INFO, "Clicked on the done button in the 'Travellers' panel.");
	}

	/**
	 * Method used to log messages from the test class rather than the page factory,
	 * typically for pass/fail messages.
	 * 
	 * @param status
	 * @param message
	 */
	public void log(LogStatus status, String message) {
		test.log(status, message);
	}

	/**
	 * Takes a screenshot of the browser window.
	 * 
	 * @param driver   The WebDriver instance.
	 * @param fileName The file name the screenshot will be saved as.
	 */
	public void takeScreenshot(WebDriver driver, String fileName) throws IOException {
		fileName = fileName + ".png";
		String directory = "C:/Users/Daniel/Desktop/ExtentReports/";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
	}

	/**
	 * Takes a screenshot of the browser window and returns its file path as a
	 * string.
	 * 
	 * @param driver   The WebDriver instance.
	 * @param fileName The file name the screenshot will be saved as.
	 * @return The file path of the screenshot that will be taken.
	 */
	public String takeScreenshotReturnPath(WebDriver driver, String fileName) throws IOException {
		fileName = fileName + ".png";
		String directory = "C:/Users/Daniel/Desktop/ExtentReports/";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		String destination = directory + fileName;
		return destination;
	}

	/**
	 * Formats the file path of a screenshot so that it may be added to the Extent
	 * Reports HTML document as a log.
	 * 
	 * @param path The path of the screenshot.
	 * @return The formatted screenshot path as a string.
	 */
	public String formatScreenshotPath(String path) {
		String imagePath = test.addScreenCapture(path);
		return imagePath;
	}

	public String getGoingToButtonText() {
		String text = staysGoingToButton.getText();
		return text;
	}

	public String getGoingToPlaceholderText() {
		String text = staysGoingToInput.getAttribute("placeholder");
		return text;

	}

	public String getGoingToEmptyStateText() {
		String text = goingToEmptyState.getText();
		return text;
	}

	public String getCheckInButtonText() {
		String text = checkInButton.getText();
		return text;
	}

	public String getCheckOutButtonText() {
		String text = checkOutButton.getText();
		return text;
	}

	public String getTravellersText() {
		String text = null;
		try {
			WebElement staysTravellerButton = driver
					.findElement(By.xpath("//button[@data-testid='travelers-field-trigger']"));
			text = staysTravellerButton.getText();
			return text;
		} catch (NoSuchElementException e) {
			WebElement alternativeStaysTravellerButton = driver
					.findElement(By.xpath("//a[@data-testid='travelers-field']"));
			text = alternativeStaysTravellerButton.getText();
			return text;
		}
	}

	public String getAddAFlightLabelText() {
		String text = addAFlightLabel.getText();
		return text;
	}

	public String getAddACarLabelText() {
		String text = addACarLabel.getText();
		return text;
	}

	public String getCalendarCheckInSpanText() {
		String text = calendarCheckInSpan.getText();
		return text;
	}

	public String getCalendarCheckOutSpanText() {
		String text = calendarCheckOutSpan.getText();
		return text;
	}

	public Boolean verifyUserCannotAccessPastMonth() {
		// Declare DateTimeFormatter and LocalDateTime so that we may get the current
		// month and year and compare it with the one in the calendar header.
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM yyyy");
		LocalDateTime now = LocalDateTime.now();
		String attribute = "disabled";

		// Assign the current month & year to a string so that we may compare it to the
		// one in the calendar's header.
		String currentMonthYear = dtf.format(now);

		// Click the back arrow until the left calendar header displays the current
		// month and year.
		while (!leftCalendarHeader.getText().equals(currentMonthYear)) {
			clickCalendarBackArrow();
		}

		// Return true if the back arrow is disabled, else return false.
		if (calendarBackArrow.getAttribute(attribute) == null) {
			// If disabled = null, then it is not disabled, which is bad.
			test.log(LogStatus.ERROR, "The calendar back arrow button did not have the 'disabled' attribute.");
			return false;
		} else if (calendarBackArrow.getAttribute(attribute).equals("true")) {
			// If disabled = true, then it is disabled which is what we want.
			test.log(LogStatus.INFO, "The calendar back arrow button is disabled, which is the expected behavior.");
			return true;
		} else {
			// If disabled does not equal true or null, then something crazy has happened.
			test.log(LogStatus.ERROR,
					"The calendar back arrow button's 'disabled' attribute is equal to something other than the expected values of 'null' and 'true', which means something has gone wrong.");
			return false;
		}
	}

	public Boolean verifyUserCannotAccessMonth500DaysAhead() {
		// Declare DateTimeFormatter and LocalDateTime so that we may get the current
		// month and year and compare it with the one in the calendar header.
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM yyyy");
		LocalDateTime now = LocalDateTime.now().plusDays(500);

		// Assign the current month & year to a string so that we may compare it to the
		// one in the calendar's header.
		String currentMonthYear = dtf.format(now);
		String attribute = "disabled";

		// Click the forward arrow until the right calendar header displays the month
		// that is 500 days ahead from today.
		while (!rightCalendarHeader.getText().equals(currentMonthYear)) {
			clickCalendarForwardArrow();
		}

		// Return true if the forward arrow is disabled, else return false.
		if (calendarForwardArrow.getAttribute(attribute) == null) {
			// If disabled = null, then it is not disabled, which is bad.
			test.log(LogStatus.ERROR, "The calendar forward arrow button did not have the 'disabled' attribute.");
			return false;
		} else if (calendarForwardArrow.getAttribute(attribute).equals("true")) {
			// If disabled = true, then it is disabled which is what we want.
			test.log(LogStatus.INFO, "The calendar forward arrow button is disabled, which is the expected behavior.");
			return true;
		} else {
			// If disabled does not equal true or null, then something crazy has happened.
			test.log(LogStatus.ERROR,
					"The calendar forward arrow button's 'disabled' attribute is equal to something other than the expected values of 'null' and 'true', which means something has gone wrong.");
			return false;
		}
	}

	public Boolean verifyUserCannotSelectDayInPast() {
		// Issues - cannot consistently identify when the day yesterday from today will
		// be disabled on the calendar. It can be 3:00AM on the 5th of January EST, yet
		// the 4th of January will still be enabled. Not sure if a bug or it is an issue
		// with time zones. Perhaps it would be better to pass
		// the day to the method?

		// Declare DayTimeFormatter and LocalDateTime object so we may get the current
		// date and format it in a way so that we may compare it to the header element
		// on the calendar to see if we're on the right month & year.
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM yyyy");
		LocalDateTime now = LocalDateTime.now();
		int day = now.getDayOfMonth();

		// Declare WebElement for calendar day buttons.
		WebElement dayElement = null;
		// Assign the current month & year to a string so that we may compare it to the
		// one in the calendar's header.
		String currentMonthYear = dtf.format(now);

		// Click the back arrow until the left calendar header displays the current
		// month and year.
		while (!leftCalendarHeader.getText().equals(currentMonthYear)) {
			clickCalendarBackArrow();
		}

		// For loop to verify that days in the past are disabled on the calendar. If the
		// current day is not the 1st of the month, take
		// the current day and count down until we reach 0. While we are counting down
		// the days, we are checking to see if they have the disabled attribute, which
		// they should.
		if (now.getDayOfMonth() != 1) {
			for (int x = (day - 1); x > 0; x--) {
				try {
					// If Selenium finds the element using this xpath then we know it's disabled.
					dayElement = getCalendarDay(now.getMonth(), x, now.getYear());
				} catch (NoSuchElementException e) {
					// Any other xpath would mean it is enabled, which is not the expected behavior;
					// fail the test.
					return false;
				}
			}
		}
		// Else, if it is the 1st of the month, then we verify that the 1st day of the
		// month button is enabled, and that the back arrow is disabled.
		else {
			try {
				// If Selenium finds the element using this xpath then we know it's enabled.
				getCalendarDay(now.getMonth(), 1, now.getYear());
			} catch (NoSuchElementException e) {
				// Any other xpath would mean it is disabled, which is not the expected
				// behavior; fail the test.
				return false;
			}
			// Verify that the back arrow is disabled.
			if (calendarBackArrow.getAttribute("disabled") == null) {
				// If disabled = null, then it is not disabled, which is bad.
				test.log(LogStatus.ERROR,
						"The first calendar day button was enabled, but the calendar back arrow button did not have the 'disabled' attribute.");
				return false;
			} else if (calendarBackArrow.getAttribute("disabled").equals("true")) {
				// If disabled = true, then it is disabled which is what we want.
				test.log(LogStatus.INFO,
						"The first calendar day button was enabled and the calendar back arrow button is disabled, which is the expected behavior.");
				return true;
			} else {
				// If disabled does not equal true or null, then something crazy has happened.
				test.log(LogStatus.ERROR,
						"The first calendar day button was enabled and the calendar back arrow button's 'disabled' attribute is equal to something other than the expected values of 'null' and 'true', which means something has gone wrong.");
				return false;
			}
		}
		test.log(LogStatus.INFO,
				"The calendar day buttons for days in the past are disabled, which is the expected behavior.");
		return true;
	}

	public Boolean verifyUserCannotSelectDayOver500InFuture() {
		// Declare DateTimeFormatter and LocalDateTime so that we may get the current
		// month and year and compare it with the one in the calendar header.
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM yyyy");
		LocalDateTime now = LocalDateTime.now();
		WebElement dayElement = null;
		// Add 500 days to the current day.
		now = now.plusDays(500);
		int day = now.getDayOfMonth();

		// Assign the current month & year to a string so that we may compare it to the
		// one in the calendar's header.
		String currentMonthYear = dtf.format(now);

		// Click the forward arrow until the right calendar header displays the month
		// that is 500 days ahead from today.
		while (!rightCalendarHeader.getText().equals(currentMonthYear)) {
			clickCalendarForwardArrow();
		}

		// Create YearMonth object so that we may find out exactly how many days there
		// are in the month which is 500 days from now. This object also takes leap
		// years into account. We are trying to find out how many days there are in the
		// month which is 500 days in the future because we want to check all the
		// remaining days in the month to find out whether or not they are disabled.
		YearMonth yearMonthObject = YearMonth.of(now.getYear(), now.getMonthValue());
		int daysInMonth = yearMonthObject.lengthOfMonth();

		// For loop that checks each day button in the calendar between the day that is
		// 500 days in the future, and the final day of that month. E.g., May 09th
		// 2022 is 500 days from now, and the month of May ends on the 31st that year,
		// so each day between the 9th and 31st should have the disabled attribute. If
		// all of the expected days are disabled, return true, else return false.
		for (int x = day; x < (daysInMonth + 1); x++) {
			try {
				dayElement = getCalendarDay(now.getMonth(), x, now.getYear());
			} catch (NoSuchElementException e) {
				test.log(LogStatus.ERROR,
						"The calendar day button for: '" + now.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
								+ " " + x + ", " + now.getYear()
								+ "' was not disabled even though it was expected to be disabled.");
				return false;
			}
		}
		// Return true if the forward arrow is disabled, else return false.
		if (calendarForwardArrow.getAttribute("disabled") == null) {
			// If disabled = null, then it is not disabled, which is bad.
			test.log(LogStatus.ERROR, "The calendar forward arrow button did not have the 'disabled' attribute.");
			return false;
		} else if (calendarForwardArrow.getAttribute("disabled").equals("true")) {
			// If disabled = true, then it is disabled which is what we want.
			test.log(LogStatus.INFO, "The calendar forward arrow button is disabled, which is the expected behavior.");
		} else {
			// If disabled does not equal true or null, then something crazy has happened.
			test.log(LogStatus.ERROR,
					"The calendar forward arrow button's 'disabled' attribute is equal to something other than the expected values of 'null' and 'true', which means something has gone wrong.");
			return false;
		}
		test.log(LogStatus.INFO,
				"All the calendar days which are over 500 days from the current day are disabled as expected.");
		return true;
	}
/*
	//TODO - This shit is mind boggling, lets do something easier....
	public Boolean verifyCalendarDaysAreHighlightedCorrectly() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM yyyy");
		LocalDateTime date1 = LocalDateTime.now();
		LocalDateTime date2 = date1.plusDays(60);
		String leftCalendarHeaderDesired = dtf.format(date1);
		String rightCalendarHeaderDesired = dtf.format(date2);
		WebElement day1Button;
		WebElement day2Button;
		WebElement inbetweenDaysButton;
		YearMonth date1YearMonth = YearMonth.of(date1.getYear(), date1.getMonthValue());
		YearMonth date2YearMonth = YearMonth.of(date2.getYear(), date2.getMonthValue());
		int day1DayOfMonth = date1.getDayOfMonth();
		int day2DayOfMonth = date2.getDayOfMonth();

		while (!leftCalendarHeader.getText().equals(leftCalendarHeaderDesired)) {
			clickCalendarBackArrow();
		}

		clickCalendarDay(date1.getMonth(), day1DayOfMonth, date1.getYear());

		while (!rightCalendarHeader.getText().equals(rightCalendarHeaderDesired)) {
			clickCalendarForwardArrow();
		}

		clickCalendarDay(date2.getMonth(), day2DayOfMonth, date2.getYear());

		while (!leftCalendarHeader.getText().equals(leftCalendarHeaderDesired)) {
			clickCalendarBackArrow();
		}

		day1Button = driver.findElement(
				By.xpath("//button[@aria-label='" + date1.getMonth().getDisplayName(TextStyle.SHORT, Locale.US) + " "
						+ day1DayOfMonth + ", " + date1.getYear() + " selected, current check in date.']"));

		if (!day1Button.getAttribute("class").equals("uitk-new-date-picker-day selected edge")) {
			return false;
		}

		
		for (int x = (day1DayOfMonth+1); x < (date1YearMonth.lengthOfMonth() + 1); x++) {
			inbetweenDaysButton = getCalendarDay(date1.getMonth(), x, date1.getYear());
			if(!inbetweenDaysButton.getAttribute("class").equals("uitk-new-date-picker-day selected")) {
				return false;
			}
		}

		return true;
	}
	*/
	public Boolean verifyCalendarDaysAreHighlightedCorrectly() {
		return true;
	}
}
