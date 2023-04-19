package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinBaseClass extends PageProperty {
	public static WebDriver driver;

// 1.Get Driver Launch in Chrome
public static WebDriver launch(String url,int time) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	return driver;
}

// 71.Driver Launch with Firefox
public static WebDriver getDriverFirefox() {
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	return driver;
}
// 72.Driver Launch with Internet Explorer

public static WebDriver getDriverIE() {
	WebDriverManager.iedriver().setup();
	driver = new InternetExplorerDriver();
	return driver;
}
// 73.Driver Launch with Edge

public static WebDriver getDriverEdge() {
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	return driver;
}

private String String;



// 2. Get Current URL
public String getCurrentUrl() {

	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
}

// 3. To load URL
//public void loadUrl(String url) {
//	driver.get(url);
//}

// 4.To get Text from website
public String getText(WebElement element) {
	String text = element.getText();
	return text;
}

// 5. To get Title
public String getTitle() {
	String title = driver.getTitle();
	return title;
}

// 6. Insert Value in TextBox
public void insertValue(WebElement element, String data) {
	element.sendKeys(data);

}

// 7.To click button
public void click(WebElement element) {
	element.click();

}

// 8. To click ok in alert
public Alert simpleAlert() {
	 Alert alert = driver.switchTo().alert();
	alert.accept();
	return alert;
}

// 9. To click Cancel in alert
public Alert confirmAlert() {
	Alert confirmAlert = driver.switchTo().alert();
	confirmAlert.dismiss();
	return confirmAlert;
}

// 10. To click prompt Alert
public Alert promptAlert(String data) {
	Alert alert = driver.switchTo().alert();
	alert.sendKeys(data);
	alert.accept();
	return alert;
}

// 11.To get text from ALert
public String getTextAlert() {
	Alert alert = driver.switchTo().alert();
	String text = alert.getText();
	return text;
}

// 12.To get page Source
public String getPageSource() {
	String pageSource = driver.getPageSource();
	return pageSource;
}

// 13. Find locator using ID
public WebElement findElementById(String attributeValue) {
	WebElement element = driver.findElement(By.id(attributeValue));
	return element;
}

// 14.Find locator using Name
public WebElement findElementByName(String attributeValue) {
	WebElement element = driver.findElement(By.name(attributeValue));
	return element;
}

// 15.Find locator Using ClassName
public WebElement findElementByClassName(String attributeValue) {
	WebElement element = driver.findElement(By.className(attributeValue));
	return element;

}

// 16.Find locator using Xpath
public WebElement findElementByXpath(String attributeValue) {
	WebElement element = driver.findElement(By.xpath(attributeValue));
	return element;
}

// 17. To get Parent Window
public String getParentWindow() {
	String parentWindow = driver.getWindowHandle();
	return parentWindow;

}

// 18. To get All Windows
public Set<String> getAllWindows() {
	Set<String> allWindows = driver.getWindowHandles();
	return allWindows;
}

// 19. To get child Window
public void getChildWindow() {
	String parentWindow = driver.getWindowHandle();
	Set<String> allWindows = driver.getWindowHandles();
	for (String childWindow : allWindows) {
		if (!parentWindow.equals(allWindows)) {
			driver.switchTo().window(childWindow);
		}

	}

}

// 20. Navigate to Url
public void navigateUrl(String url) {
	driver.navigate().to(url);

}

// 21.To clear the text box value
public void clearTextbox(WebElement element) {
	element.clear();
}

// 22. To get Colour/size/font of Particular WebElement

public String getAttributeValue(WebElement element) {

	String attribute = element.getAttribute("value");
	return attribute;

}

public String getAttributeValue2(String value) {
	WebElement element = driver.findElement(By.id(value));
	String attribute = element.getAttribute("value");
	return attribute;
}

// 23. To get TagName
public String getTagName(WebElement element) {
	String tagName = element.getTagName();
	return tagName;
}

// 24.To find multiple elements
public List<WebElement> findElementsByTagName(WebElement element, String tagValue) {
	List<WebElement> elements = element.findElements(By.tagName(tagValue));
	return elements;
}

// 25.To Find Multiple Elements by xpath
public List<WebElement> findElementsByXpath(WebElement element, String path) {
	List<WebElement> elements = element.findElements(By.xpath(path));
	return elements;
}

// 26. To check whether the Webelement is displayed or not
public boolean isWebElementDisplayed(WebElement element) {
	boolean displayed = element.isDisplayed();
	return displayed;
}

// 27. To check whether the text box is enabled to insert value
public boolean isTextBoxEnabled(WebElement element) {
	boolean enabled = element.isEnabled();
	return enabled;
}

// 28.To check whether the radion button or dropdown selected or not

public boolean isSelected(WebElement element) {
	boolean selected = element.isSelected();
	return selected;
}

// 29.To Select Dropdown by index

public static void selectOptionsByIndex(WebElement element, int index) {
	Select select = new Select(element);
	select.selectByIndex(index);

}

// 30. To Select Dropdown by value
public static void selectOptionsByValue(WebElement element, String attributeValue) {
	Select select = new Select(element);
	select.selectByValue(attributeValue);
}

// 31. To Select Dropdown by Text
public static void selectOptionsByVisibleText(WebElement element, String text) {
	Select select = new Select(element);
	select.selectByVisibleText(text);
}

// 32. To get All options from DropDown
public List<WebElement> toGetAllOptions(WebElement element) {
	Select select = new Select(element);
	List<WebElement> options = select.getOptions();
	return options;
}

// 33. To get All selected options from DropDown
public List<WebElement> toGetAllSelectedOptions(WebElement element) {
	Select select = new Select(element);
	List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
	return allSelectedOptions;

}

// 34. To get first Selected option
public WebElement getFirstSelectedOption(WebElement element) {
	Select select = new Select(element);
	WebElement firstSelectedOption = select.getFirstSelectedOption();
	return firstSelectedOption;

}

// 35. To check whether it is a single value drop down or Multivalue Dropdown
public boolean isDropDownMultiple(WebElement element) {
	Select select = new Select(element);
	boolean multiple = select.isMultiple();
	return multiple;
}

// 36. To Deselect Options by Value
public void deSelectOptionsByValue(WebElement element, String attributeValue) {
	Select select = new Select(element);
	select.deselectByValue(attributeValue);
}

// 37.To Deselect Dropdown by index

public void deselectOptionsByIndex(WebElement element, int index) {
	Select select = new Select(element);
	select.deselectByIndex(index);

}

// 38. To deSelect Dropdown by Text
public void deselectOptionsByVisibleText(WebElement element, String text) {
	Select select = new Select(element);
	select.deselectByVisibleText(text);
}

// 39. To deselect all dropdown list
public void deSelectAllOptions(WebElement element) {
	Select select = new Select(element);
	select.deselectAll();
}

// 40. Insert value Using Js
public void setAttributeWithJs(WebElement element, String attributeValue) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('value','" + attributeValue + "')", element);

}

// 41. Return Value using Js
public Object getAttributeWithJs(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Object script = js.executeScript("return arguments[0].getAttribute('value')", element);
	return script;

}

// 42.Click using Js
public void clickUsingJs(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", element);

}

// 43. ScrollDown using js
public void toScrollDown(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true)", element);
}

// 44. ScrollUp using js
public void toScrollUp(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(false)", element);
}

// 45.Right click using Action class
public void rightClick(WebElement element) {
	Actions actions = new Actions(driver);
	actions.contextClick(element).perform();
}

// 46.Double click using Action class
public void doubleClick(WebElement element) {
	Actions actions = new Actions(driver);
	actions.doubleClick(element).perform();
}

// 47.To insert values in caps using Actions class
public void toInsertAllInCaps(WebElement element, String value) {
	Actions actions = new Actions(driver);
	actions.keyDown(Keys.SHIFT).sendKeys(element, value).keyUp(Keys.SHIFT);
}

// 48. To take screenshot of the page
public File takeScreenShot() {
	TakesScreenshot tS = (TakesScreenshot) driver;
	File file = tS.getScreenshotAs(OutputType.FILE);
	return file;
}

// 49. To take Screen shot and Copy in particular place
public void takeScreenShotAndCopy(String location) throws IOException {
	TakesScreenshot tS = (TakesScreenshot) driver;
	File file = tS.getScreenshotAs(OutputType.FILE);
	File fileD = new File(location);
	FileUtils.copyFile(file, fileD);

}

// 50.Take ScreenShot for WebElement
public File takeScreenShotofWebElement(WebElement element) {
	File screenshotAs = element.getScreenshotAs(OutputType.FILE);
	return screenshotAs;

}

// 51.To switch into frames using Name or Id
public void switchFrameUsingName(String name) {
	driver.switchTo().frame(name);
}

// 52.To switch to frame using Int
public void switchFrameUsingInt(WebElement element, int index, String tagValue) {
	List<WebElement> elements = driver.findElements(By.tagName(tagValue));
	elements.size();
	driver.switchTo().frame(index);
}

// 53.To switch to frame using Webelement
public void switchFrameUsingWebElement(WebElement element) {
	driver.switchTo().frame(element);
}

// 54.To Achieve Mouse over Action
public void mouseOverAction(WebElement element) {
	Actions actions = new Actions(driver);
	actions.moveToElement(element);

}

// 55.To achieve drag and drop
public void dragAndDrop(WebElement element, WebElement element1) {
	Actions actions = new Actions(driver);
	actions.dragAndDrop(element, element1);

}

// 56.To Know whether the element are equals e
public boolean equalsMethod(WebElement element, WebElement element1) {
	boolean equals = element.equals(element1);
	return equals;
}

// 57.To change all object values into string
public String changeToString() {
	String string = driver.toString();
	return string;
}

// 58.To Know hashcode of the object
public int hashcode() {
	int hashCode = driver.hashCode();
	return hashCode;
}

// 59. To Quit the driver
public void quitDriver() {
	driver.quit();
}

// 60.To close the driver
public void closeDriver() {
	driver.close();
}

// 61.To Modify in sheet
public void modifyData(String sheetName, int rowNum, int cellNum, String newData, String oldData)
		throws IOException {
	File file = new File("C:\\Users\\andre\\eclipse-workspace\\Employee\\Sheet\\Book 1 Maven.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rowNum);
	Cell cell = row.getCell(cellNum);
	String text = cell.getStringCellValue();
	if (text.equals(oldData)) {
		cell.setCellValue(newData);
	}
	FileOutputStream out = new FileOutputStream(file);
	workbook.write(out);
}

// 62. To Write in sheet
public void insertData(String sheetName, int rowNum, int cellNum, String string) throws IOException {
	
	File file = new File(filePath);
	FileInputStream stream = new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rowNum);
	Cell cell = row.createCell(cellNum);
	cell.setCellValue(string);
	FileOutputStream out = new FileOutputStream(file);
	workbook.write(out);

}

// 63. To create sheet
public void createSheet(String sheetName, int rowNum, int cellNum, String newData, String oldData, String path) {
	File file = new File(filePath);
	Workbook workbook = new XSSFWorkbook();
	Sheet sheet = workbook.createSheet(sheetName);
	Row row = sheet.createRow(rowNum);
	Cell cell = row.createCell(cellNum);

}

// 64.to Read Sheet
public static String getData(String sheetName, int rowNum, int cellNum) throws IOException {
	//String data = null;
	//File file = new File(filePath);
	FileInputStream stream = new FileInputStream(filePath);
	Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet(sheetName);
	//Sheet sheet = workbook.getSheetAt(sheetName);
	Row row = sheet.getRow(rowNum);
	Cell cell = row.getCell(cellNum);
	return sheetName;
	
	
	
	
	
//	CellType type = cell.getCellType();
//	switch (type) {
//	case STRING:
//		data = cell.getStringCellValue();
//		break;
//	case NUMERIC:
//		if (DateUtil.isCellDateFormatted(cell)) {
//			Date dateCellValue = cell.getDateCellValue();
//			SimpleDateFormat dF = new SimpleDateFormat("dd/MM/yyyy");
//			data = dF.format(dateCellValue);
//		} else {
//			double numericCellValue = cell.getNumericCellValue();
//			BigDecimal bD = BigDecimal.valueOf(numericCellValue);
//			data = bD.toString();
//		}
//	default:
//		break;
//	}
//	return data;

}


// 65.Get Driver load Url
public static void getDriverLoadUrl(String url) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().window().maximize();
}

// 66.To Maximize
public void toMaximize() {
	driver.manage().window().maximize();
}

// 67.ImplicityWait
public void implicityWait() {
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
}

// 68.Quit
public static void closeWindows() {
	driver.quit();
}

// 69.close
public static void close() {
	driver.close();
}

// 70.Navigate Refresh
public void navigateRefresh() {
	driver.navigate().refresh();
}


}
