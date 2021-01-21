package pageFactory;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageFactoryAllInclusive {
	private WebDriver driver;

	@FindBy(xpath = "//a[@href='?pwaLob=wizard-thirdPartyPackage-pwa']")
	private WebElement allInclusiveVacationsTab;

	@FindBy(xpath = "//button[@data-testid='submit-button']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[@data-testid='travelers-field']")
	private WebElement travelerAnchor;

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

	/**
	 * This button is in the calendar date selector panel. It allows the user to
	 * select a check in date.
	 */
	@FindBy(xpath = "//div[@class='uitk-flex uitk-flex-align-items-center uitk-toolbar uitk-new-date-picker-toolbar']/section/section/button[@type='button'][1]")
	private WebElement calendarCheckInButton;

	@FindBy(xpath = "//div[@class='uitk-flex uitk-flex-justify-content-space-between uitk-new-date-picker-menu-pagination-container']/button[1]")
	private WebElement calendarBackArrow;

	@FindBy(xpath = "//div[@class='uitk-flex uitk-flex-justify-content-space-between uitk-new-date-picker-menu-pagination-container']/button[2]")
	private WebElement calendarForwardArrow;

	@FindBy(xpath = "//button[@data-stid='apply-date-picker']")
	private WebElement calendarDoneButton;

	@FindBy(id = "d1-btn")
	private WebElement departingButton;

	@FindBy(xpath = "//a[@href='http://allinclusiveforgroups.expedia.ca/en-CA/LandGroup']")
	private WebElement bookFor10;

	/*
	 * Constructor for the page factory. Set this class's driver to the driver
	 * passed from the test class. Initiate the elements listed above for use in our
	 * methods
	 */
	public PageFactoryAllInclusive(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks on the "All-inclusive vacations" tab.
	 */
	public void clickAllInclusiveVacationsTab() {
		allInclusiveVacationsTab.click();
	}

	/**
	 * Clicks the traveler anchor tag so that the user may access the "Travellers"
	 * submenu.
	 */
	public void clickTraveller() {
		travelerAnchor.click();
	}

	/**
	 * Clicks the search button. Usable on all tabs, (stays, cars, flights, etc.)
	 */
	public void clickSearch() {
		searchButton.click();
	}

	/**
	 * Clicks on the check in date button in the calendar date picker panel so that
	 * the user can click a date on the calendar and set it as their check in date.
	 */
	public void clickCalendarCheckInDate() {
		calendarCheckInButton.click();
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
	 * Clicks the departing button so the user may select a check in date from the
	 * calendar date picker panel. Works for all tabs except for "Multi-city" in
	 * flights tab.
	 */
	public void clickDeparting() {
		departingButton.click();
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
	 * Finds the "Leaving from" drop down menu and returns it as a select.
	 * 
	 * @return "Leaving from" drop down as a select.
	 */
	private Select getLeavingFromSelect() {
		WebElement leavingFromSelect = driver.findElement(By.id("leaving-3pp"));
		Select sel = new Select(leavingFromSelect);
		return sel;

	}

	/**
	 * Selects an option from the "Leaving from" select.
	 * 
	 * @param option : The option you wish to select. Use visible text only.
	 */
	public void selectLeavingFrom(String option) {
		Select leavingFromSelect = getLeavingFromSelect();
		leavingFromSelect.selectByVisibleText(option);
	}

	/**
	 * Finds the "Going to" drop down menu and returns it as a select.
	 * 
	 * @return "Going to" drop down as a select.
	 */
	private Select getGoingToSelect() {
		WebElement goingToSelect = driver.findElement(By.id("going-3pp"));
		Select sel = new Select(goingToSelect);
		return sel;
	}

	/**
	 * Selects an option from the "Going to" select.
	 * 
	 * @param option : The option you wish to select. Use visible text only.
	 */
	public void selectGoingTo(String option) {
		Select goingToSelect = getGoingToSelect();
		goingToSelect.selectByVisibleText(option);

	}

	/**
	 * Finds the "Vacation length" drop down menu and returns it as a select.
	 * 
	 * @return "Vacation length" drop down as a select.
	 */
	private Select getVacationLengthSelect() {
		WebElement vacationLengthSelect = driver.findElement(By.id("threepp-duration-select"));
		Select sel = new Select(vacationLengthSelect);
		return sel;
	}

	/**
	 * Selects an option from the "Vacation length" select.
	 * 
	 * @param option : The option you wish to select. Use visible text only.
	 */
	public void selectVacationLength(String option) {
		Select vacationLengthSelect = getVacationLengthSelect();
		vacationLengthSelect.selectByVisibleText(option);
	}

	/**
	 * Finds the specified child age select element in the travellers panel.
	 *
	 * @param child The child number. Range: 1-6
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
	 * @param child The child number. Range: 1-6
	 * @param age   The age to be set. Range: 0-17, 0 being "Under-1".
	 */
	public void selectChildAge(int child, int age) {
		Select childAge = getChildAgeSelect(child);
		childAge.selectByIndex(age);
	}

	/**
	 * Clicks the "Book for 10+ people" hyperlink.
	 */
	public void clickBookFor10() {
		bookFor10.click();
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
