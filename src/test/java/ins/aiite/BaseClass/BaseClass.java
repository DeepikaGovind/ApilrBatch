package ins.aiite.BaseClass;

	import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.io.FileHandler;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	public class BaseClass {
		public static WebDriver driver;
		public static WebElement element;
		public static Select s;
		public static Actions ac;
		public static Alert alert;
		public static TakesScreenshot ts;
		public static WebDriver selectingBrowser(String browser_name){
			if(browser_name == "chrome") {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\soldier\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				return driver;
			}
			else if(browser_name == "gecko") {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\soldier\\Downloads\\geckodriver-v0.32.2-win32\\geckdriver.exe");
				driver = new FirefoxDriver();
				return driver;
				}
			else if(browser_name == "edge") {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\soldier\\Downloads\\edgedriver_win64\\edgedriver.exe");
				driver = new EdgeDriver();
				return driver;
			}
			else {
				return driver;
			}
		}
			
			public static String launching(String url) {
				driver.get(url);
				String currentUrl = driver.getCurrentUrl();
				if(currentUrl==url) {
					System.out.println("URL launched Succesfully");
					return "passed";
				}
				else {
					System.out.println("URL not launched");
					return "failed";
				}
				
			}
			public static void resizing() {
				driver.manage().window().maximize();
			}
			

			public static WebElement findElementbyId(String id) {
				try {
				WebElement element = driver.findElement(By.id(id));
				return element;
				}catch(Exception e) {
					System.out.println("Error :"+e);
				}
		         return element;
			}

			public static WebElement findElementbyName(String name) {
				try {
				WebElement element = driver.findElement(By.name(name));
				return element;
				}catch(Exception e) {
					System.out.println("Error :"+e);
				}
				return element;
				}

			public static WebElement findElementbyClassName(String classname) {
				try {
				WebElement element = driver.findElement(By.className(classname));
				return element;
				}catch(Exception e) {
					System.out.println("Error :"+e);
				}
				return element;
			}

			public static WebElement findElementbyXpath(String xpath) {
				try {
				WebElement element = driver.findElement(By.xpath(xpath));
				return element;
				}catch(Exception e) {
					System.out.println("Error :"+e);
				}
				return element;
			}

			public static WebElement findElementbyLinktext(String linktext) {
				try {
				WebElement element = driver.findElement(By.linkText(linktext));
				return element;
				}catch(Exception e) {
					System.out.println("Error :"+e);
				}
				return element;
			}

			public static WebElement findElementbyPartillinktext(String partiallinktext) {
				try {
				WebElement element = driver.findElement(By.partialLinkText(partiallinktext));
				return element;
				}catch(Exception e) {
					System.out.println("Error :"+e);
				}
				return element;
			
			}
			public static WebElement byCssSelector(String cssselector) {
				try {
					WebElement element = driver.findElement(By.cssSelector(cssselector));
					return element;
				}
				catch(Exception e) {
					System.out.println("Error :"+e);
				}
				return element;
			}

			public static void send_keys(WebElement element,String valueofkeys) {
				element.sendKeys(valueofkeys);

			}

			public static void clickbutton(WebElement element) {
				element.click();
			}

			public static void close_Window() {
				driver.close();
			}
			public static void screenshot() {
				ts = (TakesScreenshot)driver;
			}
			public static void TakingScreenShot(String pathname) throws IOException {
				File f = ts.getScreenshotAs(OutputType.FILE);
				File path = new File(pathname);
				FileHandler.copy(f, path);
			}
			public static Select dropDownoptions(WebElement element) {
				s = new Select(element);
				return s;

			}

			public static void selectByvisibletext(String text) {
				s.selectByVisibleText(text);
			}

			public static void selectByvalue(String value) {
				s.selectByValue(value);

			}

			public static void selectByindex(int index) {
				s.selectByIndex(index);
			}

			public static Actions actionEvent(WebDriver driver) {

				Actions ac = new Actions(driver);
				return ac;

			}

			public static void doubleClick(WebElement element) {
				ac.doubleClick(element);

			}

			public static void clickandHold() {
				ac.clickAndHold();

			}

			public static void perform() {
				ac.perform();

			}

			public static void dragDrop(WebElement drag,WebElement drop) {
				ac.dragAndDrop(drag, drop);
			}

			public static void rightClick(WebElement element) {
				ac.contextClick(element);

			}

			public static void moveToelement(WebElement element) {
				ac.moveToElement(element);

			}
			public static Alert handlingAlert() {
				try {
				alert = driver.switchTo().alert();
				}
				catch(Exception e) {
					System.out.println("Error"+e);
				}
				return alert;
			}
			public static void acceptingAlert() {
				alert.accept();
			}
			
			public static void dismissingAlert() {
				alert.dismiss();
			}
			public static WebElement keyboard_Enter(WebElement element) {
				element.sendKeys(Keys.ENTER);
				return element;
			}
			public static void frameHandlingByIndex(int index) {
				driver.switchTo().frame(index);
			}
			public static void frameHandlingByValue(String value) {
				driver.switchTo().frame(value);
			}
			public static void frameHandlingByWebElemennt(WebElement element) {
				driver.switchTo().frame(element);
			}
			public static void defaultFrameHandling() {
				driver.switchTo().defaultContent();
			}
			public static void implicitWait(int secs) {
				Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(secs, TimeUnit.MILLISECONDS);
			}

			public static void explicitWait(Duration secs) {
				WebDriverWait wait = new WebDriverWait(driver, secs);
				wait.until(ExpectedConditions.elementToBeClickable(element));

			}
		public static void executeScriptMethod(String attributeValue,WebElement element)
					{
						try {
						JavascriptExecutor js =(JavascriptExecutor) driver;
						js.executeScript(attributeValue, element);
						}
						catch(Exception e)
						{
							System.out.println("Error"+ e);
						}
					}
		public static void sleepThread(long mseconds) throws InterruptedException {
						try {
							Thread.sleep(mseconds);	
						}
						catch(Exception e)
						{
							System.out.println("e.getmessage");

						}
					}
		
		public static void propRead(String key,String path) {
			try {
				FileReader read = new FileReader("C:\\Users\\Deepika Govind\\eclipse-workspace\\ApilrlBatch3\\src\\test\\java\\loginDetails.properties");
				Properties prop = new Properties();
				prop.load(read);			
				String username = prop.getProperty(key);
				System.out.println(username);			
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}



}
