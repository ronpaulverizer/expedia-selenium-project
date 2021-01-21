package pageFactory;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageFactoryCruises {
	private WebDriver driver;

	@FindBy(xpath = "//a[@href='?pwaLob=wizard-cruise-pwa']")
	private WebElement cruisesTab;

	@FindBy(id = "cruise-destination")
	private WebElement goingTo;

	@FindBy(xpath = "//button[@data-testid='submit-button']")
	private WebElement searchButton;

	/**
	 * This button opens the calendar to select a check in date.
	 */
	@FindBy(id = "d1-btn")
	private WebElement departsAsEarlyAsButton;

	/**
	 * This button opens the calendar to select a check out date.
	 */
	@FindBy(id = "d2-btn")
	private WebElement departsAsLateAsButton;

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

	@FindBy(xpath = "//button[@data-testid='guests-done-button']")
	private WebElement travellersDone;

	@FindBy(xpath = "//div[contains(@class,'adultStepInput')]/div/button[1]")
	private WebElement travellersAdultDec;

	@FindBy(xpath = "//div[contains(@class,'adultStepInput')]/div/button[2]")
	private WebElement travellersAdultInc;

	@FindBy(xpath = "//div[contains(@class,'childStepInput')][1]/div/button[1]")
	private WebElement travellersChildDec;

	@FindBy(xpath = "//div[contains(@class,'childStepInput')][1]/div/button[2]")
	private WebElement travellersChildInc;

	/*
	 * Constructor for the page factory. Set this class's driver to the driver
	 * passed from the test class. Initiate the elements listed above for use in our
	 * methods
	 */
	public PageFactoryCruises(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Selects a cruise destination from the "Going to" select.
	 * 
	 * @param destination : The destination you wish to select. Use the exact text
	 *                    for the option you wish to select.
	 */
	public void selectCruiseDestination(String destination) {
		Select sel = new Select(goingTo);
		sel.selectByVisibleText(destination);
	}

	/**
	 * Clicks on the "Cruises" tab.
	 */
	public void clickCruisesTab() {
		cruisesTab.click();
	}

	/**
	 * Clicks the blue "Search" button so that we may submit our information.
	 */
	public void clickSearchButton() {
		searchButton.click();
	}

	/**
	 * Clicks the "Departs as early as" button so that we may open the calendar date
	 * picker and select our first date.
	 */
	public void clickDepartsAsEarlyAs() {
		departsAsEarlyAsButton.click();
	}

	/**
	 * Clicks the "Departs as late as" button so that we may open the calendar date
	 * picker and select our second date.
	 */
	public void clickDepartsAsLateAs() {
		departsAsLateAsButton.click();
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
	 * Clicks the "Done" button in the "Travellers" panel.
	 */
	public void clickTravellersDone() {
		travellersDone.click();
	}

	/**
	 * Clicks on the decrease button for adults in the travellers panel.
	 */
	public void clickTravellersAdultsDec() {
		travellersAdultDec.click();
	}

	/**
	 * Clicks on the increase button for adults in the travellers panel.
	 */
	public void clickTravellersAdultsInc() {
		travellersAdultInc.click();
	}

	/**
	 * Clicks on the decrease button for children in the travellers panel.
	 */
	public void clickTravellersChildrenDec() {
		travellersChildDec.click();
	}

	/**
	 * Clicks on the increase button for children in the travellers panel.
	 */
	public void clickTravellersChildrenInc() {
		travellersChildInc.click();
	}

	/**
	 * Clicks the "Travellers" button/hyperlink to open the travellers submenu.
	 */
	public void clickTravellersButton() {
		try {
			WebElement travellerButton = driver
					.findElement(By.xpath("//button[@data-testid='travelers-field-trigger']"));
			travellerButton.click();
		} catch (NoSuchElementException e) {
			WebElement alternativeTravellerButton = driver.findElement(By.xpath("//a[@data-testid='travelers-field']"));
			alternativeTravellerButton.click();
		}
	}

	/**
	 * Finds the specified child age select element in the travellers panel.
	 *
	 * @param child The child number. Range: 1-4
	 * @return The age select element for the specified child.
	 */
	private Select getChildAgeSelect(int child) {
		WebElement element = driver.findElement(By.id("child-age-input-0-" + (child - 1)));
		Select childAge = new Select(element);
		return childAge;
	}

	/**
	 * Sets the value of the Child Age drop down menu in the travellers panel.
	 * 
	 * @param child The child number. Range: 1-4
	 * @param age   The age to be set. Range: 0-17
	 */
	public void selectChildAge(int child, int age) {
		Select childAge = getChildAgeSelect(child);
		childAge.selectByIndex(age);
	}

	/**
	 * Clicks on the specified day button in the calendar date picker panel.
	 * 
	 * @param month    The month for the date we are selecting. E.g., "Month.FEBRUARY"
	 * @param date     The day number for the date we are selecting.
	 * @param calendar The year for the date we are selecting.
	 */
	public void clickCalendarDay(Month month, int date, int year) {
		WebElement calendarDay = driver
				.findElement(By.xpath("//button[@aria-label='" + month.getDisplayName(TextStyle.SHORT, Locale.US) + " " + date + ", " + year + "']"));
		calendarDay.click();
	}
}
