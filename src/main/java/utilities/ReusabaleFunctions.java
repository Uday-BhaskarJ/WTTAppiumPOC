package utilities;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class ReusabaleFunctions extends ReadData {

	
	
	//Function for Print the steps in allure report
		@Step("{0}")
		public static void logStep(String stepName ){

		}

		@Step("{0}")
		public static void logStepWithScreenshot(String stepName ){
			attachScreen(stepName);
		}
		
		//Function for take the screen shot in allure report
		@Attachment("Screenshot")
		public static byte[] attachScreen(String Exception ) {
			//logStep(Exception);
			return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		}

	public static  boolean waitForVisible(WebElement ele) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			//wait.until(ExpectedConditions.visibilityOfElementLocated((By) locator));
			wait.until(ExpectedConditions.visibilityOf(ele));
			//wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		}catch(Exception e) {
			return false;
		}

	}

	public static void clickOnelement(WebElement ele) throws Exception {
		try {
			waitForVisible(ele);
			ele.click();
		} catch (Exception e) {

			System.out.println(ele + " not present on the page");
		}
	}

	//Wait for Page Load
	public static void waitTillPageLoaded()  {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//Scroll to Web Element
	public static void scrolltoElement(WebElement Elenent) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Elenent);

	}

	public static void EnterText(WebElement ele,String enterText) {
		try {
			waitForVisible(ele);
			//ele.click();
			ele.clear();
			ele.sendKeys(enterText);
		} catch (Exception e) {

			System.err.println(ele +" - is not available on the screen to enter Text ");
		}

	}

	public static void selectOption(WebElement Elenent,String optionValue) {
		try {
			waitForVisible(Elenent);
			Select dropdown = new Select(Elenent);  
			Elenent.click();
			//Select Option based on provided Index value
			dropdown.selectByVisibleText(optionValue);
			System.out.println("Provided Term Option "+optionValue+" is Selected ");
		}catch(Exception e) {
			System.err.println("Provided Term Option "+optionValue+" is not valid ");
		}
	}

	public static String getResult(WebElement Elenent) {

		String resultValue =Elenent.getText();
		return resultValue;

	}

	public static void createFolderName() {
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy_HH-mm");  
	LocalDateTime now = LocalDateTime.now();  
	System.out.println(dtf.format(now));  
	FolderName="Mydata_"+dtf.format(now);
	
	}

}
