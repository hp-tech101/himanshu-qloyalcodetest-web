package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver _driver = null;
	private WebDriverWait wait = null;
	
	//locators
	private By lnkTourLocator = By.xpath("//body/nav//div[@id='collapse']/ul/li/a[@href='https://www.phptravels.net/tours']");

	
	//constructor
	public HomePage(WebDriver driver) {
		this._driver = driver;
		wait = new WebDriverWait(this._driver, 40);
	}
	
	public ToursPage goToToursPage() {
		try {
			_driver.findElement(lnkTourLocator).click();
		} catch(Exception e) {
			System.out.println("click on tour link failed. attempting again");
			wait.until(ExpectedConditions.elementToBeClickable(lnkTourLocator));
			_driver.findElement(lnkTourLocator).click();
		}
		
		
		return new ToursPage(_driver);
	}
}
