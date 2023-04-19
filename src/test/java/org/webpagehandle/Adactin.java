package org.webpagehandle;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.Assertion;

public class Adactin {
public static void main(String[] args) throws IOException, AWTException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Admin\\OneDrive\\Desktop\\ecplise\\SeleniumProjects\\NewDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebElement user = driver.findElement(By.id("username"));
	user.sendKeys("Andrew07");
	WebElement passkey = driver.findElement(By.id("password"));
	passkey.sendKeys("UN45LL");
	WebElement clk = driver.findElement(By.id("login"));
	clk.click();
	WebElement location = driver.findElement(By.xpath("//*[@name='location']"));
	Select one=new Select(location);
	one.selectByIndex(3);
	WebElement hotel = driver.findElement(By.xpath("//*[@name='hotels']"));
	Select two=new Select(hotel);
	two.selectByVisibleText("Hotel Sunshine");
	WebElement roomType  = driver.findElement(By.xpath("//*[@name='room_type']"));
	Select three=new Select(roomType);
	WebElement checkIn  = driver.findElement(By.xpath("//*[@name='datepick_in']"));
	checkIn.sendKeys("08/04/2023");
	WebElement checkOut  = driver.findElement(By.xpath("//*[@name='datepick_out']"));
	checkOut.sendKeys("09/04/2023");
	WebElement adults = driver.findElement(By.xpath("//*[@name='adult_room']"));
	Select four=new Select(adults);
	four.selectByIndex(3);
	WebElement child  = driver.findElement(By.xpath("//*[@name='child_room']"));
	Select five=new Select(child);
	five.selectByIndex(2);
	WebElement click = driver.findElement(By.xpath("//*[@type='submit']"));
	click.click();
	WebElement confirm = driver.findElement(By.xpath("//*[@name='radiobutton_2']"));
	confirm.click();
	WebElement continu = driver.findElement(By.xpath("//*[@name='continue']"));
	if(continu.isDisplayed() && continu.isEnabled()) {
	continu.click();
	}
	else {
		System.out.println("not enabled");
	}
	Assertion assertion = new Assertion();
	WebElement crossCheck = driver.findElement(By.xpath("//td[contains(text(),'Book A Hotel')]"));
	String actual = crossCheck.getText();
	String expected="Book A Hotel";
	assertion.assertEquals(actual, expected);
	
	
	FileInputStream file = new FileInputStream("C:\\Users\\Admin\\OneDrive\\Documents\\adactin booKing.xlsx");
	XSSFWorkbook workBook = new XSSFWorkbook(file);
	//XSSFSheet sheet =workBook.getSheet("Sheet1");
	XSSFSheet sheet =workBook.getSheetAt(0);
	int lastRowNum = sheet.getLastRowNum();
	System.out.println(lastRowNum);
	
	for (int i = 1; i <=lastRowNum; i++) {
		for (int j = i+1; j <=lastRowNum; j++) {
			
		XSSFRow row = sheet.getRow(i);
	String name = row.getCell(0).getStringCellValue();
	String lstName = row.getCell(1).getStringCellValue();
	String address= row.getCell(2).getStringCellValue();
	String cardNo = row.getCell(3).getRawValue();
 double cv = row.getCell(4).getNumericCellValue();
 
   WebElement namee = driver.findElement(By.xpath("//*[@name='first_name']"));
	namee.sendKeys(name);
	WebElement Lasname = driver.findElement(By.xpath("//*[@name='last_name']"));
	Lasname.sendKeys(lstName);
	WebElement addrs = driver.findElement(By.xpath("//*[@name='address']"));
	addrs.sendKeys(address);
	WebElement cardNum = driver.findElement(By.xpath("//*[@name='cc_num']"));
	cardNum.sendKeys(cardNo);
	//valueOf method
	WebElement cvv = driver.findElement(By.xpath("//*[@name='cc_cvv']"));
	//cvv.sendKeys(String.valueOf(cv));
	cvv.sendKeys(Double.toString(cv));
	Actions action = new Actions(driver);
	WebElement type = driver.findElement(By.xpath("//*[@name='cc_type']"));
	WebElement cardName = driver.findElement(By.xpath("//*[@value='VISA']"));
	action.click(type).perform();
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_DOWN);
    robot.keyRelease(KeyEvent.VK_DOWN);
    robot.keyPress(KeyEvent.VK_DOWN);
    robot.keyRelease(KeyEvent.VK_DOWN);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    WebElement month = driver.findElement(By.xpath("//select[@name='cc_exp_month']"));
	Select nine= new Select(month);
	nine.selectByIndex(2);
	 WebElement year = driver.findElement(By.xpath("//select[@name='cc_exp_year']"));
	 Select ten= new Select(year);
	 ten.selectByIndex(2);
	WebElement bookNow = driver.findElement(By.xpath("//input[@value='Book Now']"));
	bookNow.click();
	
	WebElement odrNum = driver.findElement(By.xpath("//input[@name='order_no']")); 
	String attribute = odrNum.getAttribute("value");
	System.out.println(attribute);
	//XSSFRow row = sheet.getRow(1);
	XSSFCell createCell = row.createCell(5);
	createCell.setCellValue(attribute);
	FileOutputStream out = new FileOutputStream("C:\\Users\\Admin\\OneDrive\\Documents\\adactin booKing.xlsx");
	workBook.write(out);
}
}}}
