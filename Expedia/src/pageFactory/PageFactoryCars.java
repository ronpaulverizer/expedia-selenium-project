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

public class PageFactoryCars {
	private WebDriver driver;

	@FindBy(xpath = "//button[@data-testid='submit-button']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[@href='?pwaLob=wizard-car-pwa']")
	private WebElement carsTab;

	@FindBy(xpath = "//a[@href='carsForm']")
	private WebElement carsRentalTab;

	@FindBy(xpath = "//a[@href='gtForm']")
	private WebElement carsAirportTab;

	@FindBy(xpath = "//button[@data-stid='location-field-locn-menu-trigger']")
	private WebElement carsPickUpButton;

	@FindBy(xpath = "//button[@data-stid='location-field-loc2-menu-trigger']")
	private WebElement carsSamePickupButton;

	@FindBy(xpath = "//select[@aria-label='Pick-up time']")
	private WebElement carsPickUpTime;

	@FindBy(xpath = "//select[@aria-label='Drop-off time']")
	private WebElement carsDropOffTime;

	@FindBy(id = "location-field-locn")
	private WebElement carsPickUpInput;

	@FindBy(xpath = "//ul[@data-stid='location-field-locn-results']")
	private WebElement carsPickUpUl;

	@FindBy(xpath = "//ul[@data-stid='location-field-loc2-results']")
	private WebElement carsSameAsPickUpUl;

	@FindBy(xpath = "//span[text()='I have a discount code' and not(@class='is-visually-hidden')]")
	private WebElement carsIHaveADiscountCode;

	@FindBy(id = "location-field-loc2")
	private WebElement carsSameAsPickUpInput;

	@FindBy(xpath = "//select[@aria-label='Preferred brand']")
	private WebElement carsRentalCarCompanySelect;

	@FindBy(xpath = "//select[@aria-label='Discount type']")
	private WebElement carsDiscountTypeSelect;

	@FindBy(id = "coupon-code-0")
	private WebElement carsCouponInput1;

	@FindBy(id = "coupon-code-1")
	private WebElement carsCouponInput2;

	@FindBy(id = "coupon-code-2")
	private WebElement carsCouponInput3;

	@FindBy(xpath = "//button[@data-stid='location-field-location-menu-trigger']")
	private WebElement carsAirportButton;

	@FindBy(id = "location-field-location")
	private WebElement carsAirportInput;

	@FindBy(xpath = "//ul[@data-stid='location-field-location-results']")
	private WebElement carsAirportUl;

	@FindBy(xpath = "//button[@data-stid='location-field-hotelName-menu-trigger']")
	private WebElement carsHotelNameButton;

	@FindBy(id = "location-field-hotelName")
	private WebElement carsHotelNameInput;

	@FindBy(xpath = "//ul[@data-stid='location-field-hotelName-results']")
	private WebElement carsHotelNameUl;

	@FindBy(xpath = "//select[@aria-label='Flight arrival time']")
	private WebElement carsFlightArrivalTimeSelect;

	@FindBy(id = "book-roundtrip-toggle")
	private WebElement carsBookRoundtrip;

	@FindBy(xpath = "//select[@aria-label='Flight departure time']")
	private WebElement carsFlightDepartureTimeSelect;

	@FindBy(xpath = "//button[@data-testid='swap_horiz']")
	private WebElement carsSwapAirportHotel;

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

	@FindBy(xpath = "//div[contains(@class,'childStepInput')][2]/div/button[1]")
	private WebElement travellersInfantsDec;

	@FindBy(xpath = "//div[contains(@class,'childStepInput')][2]/div/button[2]")
	private WebElement travellersInfantsInc;

	/*
	 * Constructor for the page factory. Set this class's driver to the driver
	 * passed from the test class. Initiate the elements listed above for use in our
	 * methods
	 */
	public PageFactoryCars(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	 * Clicks on the decrease button for infants in the travellers panel.
	 */
	public void clickTravellersInfantsDec() {
		travellersInfantsDec.click();
	}

	/**
	 * Clicks on the increase button for infants in the travellers panel.
	 */
	public void clickTravellersInfantsInc() {
		travellersInfantsInc.click();
	}

	/**
	 * Clicks on the "Cars" tab.
	 */
	public void clickCarsTab() {
		carsTab.click();
	}

	/**
	 * Clicks the "Rental cars" subtab in the "Cars" tab.
	 */
	public void clickRentalTab() {
		carsRentalTab.click();
	}

	/**
	 * Clicks the "Airport transportation" subtab in the "Cars" tab.
	 */
	public void clickAirportTab() {
		carsAirportTab.click();
	}

	/**
	 * Clicks the "Pick-up" button so that we may access the input.
	 */
	public void clickPickUp() {
		carsPickUpButton.click();
	}

	/**
	 * Clicks the "Same as pick-up" button so that we may access the input.
	 */
	public void clickSameAsPickup() {
		carsSamePickupButton.click();
	}

	/**
	 * Sets the value of the "Pick-up time" select in the "Rental cars" subtab in
	 * the "Cars" tab.
	 * 
	 * @param time : The time value you'd like to set it to. Use the visible text in
	 *             the select menu as the parameter. E.g., "00:00" for 12AM.
	 */
	public void selectPickUpTime(String time) {
		Select sel = new Select(carsPickUpTime);
		sel.selectByVisibleText(time);
	}

	/**
	 * Sets the value of the "Drop-off time" select in the "Rental cars" subtab in
	 * the "Cars" tab.
	 * 
	 * @param time : The time value you'd like to set it to. Use the visible text in
	 *             the select menu as the parameter. E.g., "00:00" for 12AM.
	 */
	public void selectDropOffTime(String time) {
		Select sel = new Select(carsDropOffTime);
		sel.selectByVisibleText(time);
	}

	/**
	 * Sends keys to the "Pick-up" input in the "Rental cars" subtab in the "Cars"
	 * tab.
	 * 
	 * @param keys : The keys you wish to type into the input.
	 */
	public void sendKeysPickUp(String keys) {
		carsPickUpInput.clear();
		carsPickUpInput.sendKeys(keys);
	}

	/**
	 * Sends keys to the "Same as pick-up" input field in the "Rental cars" subtab
	 * in the "Cars" tab.
	 * 
	 * @param keys : The keys you wish to send to the input.
	 */
	public void sendKeysSameAsPickUp(String keys) {
		carsSameAsPickUpInput.clear();
		carsSameAsPickUpInput.sendKeys(keys);
	}

	/**
	 * Clicks the "I have a discount code" span in the "Rental cars" sub tab in the
	 * "Cars" tab.
	 */
	public void clickIHaveADiscountCode() {
		carsIHaveADiscountCode.click();
	}

	/**
	 * Selects a rental car company from the "Preferred brand" select in the "Rental
	 * cars" subtab in the "Cars" tab.
	 * 
	 * @param company : The company you'd wish to select. Use the visible text from
	 *                the select as a parameter. E.g., "Enterprise" or "Hertz".
	 */
	public void selectRentalCarCompany(String company) {
		Select sel = new Select(carsRentalCarCompanySelect);
		sel.selectByVisibleText(company);
	}

	/**
	 * Selects a coupon type from the "Discount type" select in the "Rental cars"
	 * subtab in the "Cars" tab.
	 * 
	 * @param couponType : The coupon you'd wish to select. Use the visible text
	 *                   from the select as a parameter. E.g., "I don't have a
	 *                   code".
	 */
	public void selectDiscountType(String couponType) {
		Select sel = new Select(carsDiscountTypeSelect);
		sel.selectByVisibleText(couponType);
	}

	/**
	 * Sends keys to the first discount code input in the "Rental cars" subtab in
	 * the "Cars" tab.
	 * 
	 * @param keys : The keys you'd wish to type into the input.
	 */
	public void sendKeysCouponInput1(String keys) {
		carsCouponInput1.clear();
		carsCouponInput1.sendKeys(keys);
	}

	/**
	 * Sends keys to the second discount code input in the "Rental cars" subtab in
	 * the "Cars" tab.
	 * 
	 * @param keys : The keys you'd wish to type into the input.
	 */
	public void sendKeysCouponInput2(String keys) {
		carsCouponInput2.clear();
		carsCouponInput2.sendKeys(keys);
	}

	/**
	 * Sends keys to the third discount code input in the "Rental cars" subtab in
	 * the "Cars" tab.
	 * 
	 * @param keys : The keys you'd wish to type into the input.
	 */
	public void sendKeysCouponInput3(String keys) {
		carsCouponInput3.clear();
		carsCouponInput3.sendKeys(keys);
	}

	/**
	 * Clicks the "Airport" button so that we may send keys to its input.
	 */
	public void clickAirportButton() {
		carsAirportButton.click();
	}

	/**
	 * Sends keys to the "Airport" input field in the "Airport transportation"
	 * subtab in the "Cars" tab.
	 * 
	 * @param keysToSend The keys you wish to send to the input.
	 */
	public void sendKeysAirportInput(String keysToSend) {
		carsAirportInput.sendKeys(keysToSend);
	}

	/**
	 * Clicks the "Hotel name" button so that we may send keys to its input.
	 */
	public void clickHotelNameButton() {
		carsHotelNameButton.click();
	}

	/**
	 * Sends keys to the "Hotel name" input field in the "Airport transportation"
	 * subtab in the "Cars" tab.
	 * 
	 * @param keysToSend The keys you wish to send to the input.
	 */
	public void sendKeysHotelNameInput(String keysToSend) {
		carsHotelNameInput.clear();
		carsHotelNameInput.sendKeys(keysToSend);
	}

	/**
	 * Selects a time from the "Flight arrival time" select in the "Airport
	 * transportation" subtab in the "Cars" tab.
	 * 
	 * @param time : The time you wish to select. Use visible text from the select
	 *             as the parameter. E.g., "00:00" for 12AM, "14:15" for 2:15PM,
	 *             etc.
	 */
	public void selectFlightArrivalTime(String time) {
		Select sel = new Select(carsFlightArrivalTimeSelect);
		sel.selectByVisibleText(time);
	}

	/**
	 * Clicks the "Book roundtrip" checkbox in the "Airport transportation" subtab
	 * in the "Cars" tab.
	 */
	public void clickBookRoundtrip() {
		carsBookRoundtrip.click();
	}

	/**
	 * Selects a time from the "Flight departure time" select in the "Airport
	 * transportation" subtab in the "Cars" tab.
	 * 
	 * @param time : The time you wish to select. Use visible text from the select
	 *             as the parameter. E.g., "00:00" for 12AM, "14:15" for 2:15PM,
	 *             etc.
	 */
	public void selectFlightDepratureTime(String time) {
		Select sel = new Select(carsFlightDepartureTimeSelect);
		sel.selectByVisibleText(time);
	}

	public void clickSwapAirportHotel() {
		carsSwapAirportHotel.click();
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
