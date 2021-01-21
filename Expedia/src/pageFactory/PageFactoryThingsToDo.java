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
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactoryThingsToDo {

	private WebDriver driver;

	@FindBy(xpath = "//a[@href='?pwaLob=wizard-lx-pwa']")
	private WebElement thingsToDoTab;

	@FindBy(xpath = "//button[@data-stid='location-field-location-menu-trigger']")
	private WebElement thingsToDoInButton;

	@FindBy(id = "location-field-location")
	private WebElement thingsToDoInInput;

	@FindBy(xpath = "//button[@data-testid='submit-button']")
	private WebElement searchButton;

	/**
	 * This button opens the calendar to select a check in date.
	 */
	@FindBy(id = "d1-btn")
	private WebElement fromButton;

	/**
	 * This button opens the calendar to select a check out date.
	 */
	@FindBy(id = "d2-btn")
	private WebElement toButton;

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

	/*
	 * Constructor for the page factory. Set this class's driver to the driver
	 * passed from the test class. Initiate the elements listed above for use in our
	 * methods
	 */
	public PageFactoryThingsToDo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on the "Things to do" tab.
	 */
	public void clickThingsToDoTab() {
		thingsToDoTab.click();
	}

	/**
	 * Clicks the "Things to do in" button so that we may send keys to the input.
	 */
	public void clickThingsToDoIn() {
		thingsToDoInButton.click();
	}

	/**
	 * Sends keys to the "Things to do in" input so that we may select a location.
	 * 
	 * @param keysToSend The location you wish to search.
	 */
	public void sendKeysThingsToDoIn(String keysToSend) {
		thingsToDoInInput.sendKeys(keysToSend);
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
	 * Clicks the blue "Search" button so that we may submit our information.
	 */
	public void clickSearchButton() {
		searchButton.click();
	}

	/**
	 * Clicks the "From" button so that we may open the calendar date picker and
	 * select our first date.
	 */
	public void clickFromButton() {
		fromButton.click();
	}

	/**
	 * Clicks the "From" button so that we may open the calendar date picker and
	 * select our second date.
	 */
	public void clickToButton() {
		toButton.click();
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
