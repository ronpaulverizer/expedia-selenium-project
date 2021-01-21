package pageFactory;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportsConfig {
	public static ExtentReports getInstance() {
		String path = "C:\\Users\\Daniel\\Desktop\\ExtentReports\\stays_tab.html";
		boolean overwriteReport = true;
		ExtentReports extent = new ExtentReports(path, overwriteReport);
		extent.addSystemInfo("Selenium Version", "3.141.59")
		.addSystemInfo("OS","Windows 10");
		
		return extent;
	}
}
