package com.abnamro.assignment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;
/**
 * Page objects for 1st private account opening page
 * This contains WebElements and Methods for the page
 * @author priya
 *
 */
public class POBasicBankAccountPage {

	private WebDriver driver = null;
	
	@FindBy(how =How.XPATH, using = "//button[@value='Prive']")
	private WebElement privateButton;
	
	@FindBy(how =How.XPATH, using = "//button[@value='Mezelf']")
	private WebElement mySelfButton;
	
	@FindBy(how =How.XPATH, using = "//button[@value='true']")
	private WebElement liveYesButtom;
	
	@FindBy(how =How.XPATH, using = "//input[@id='P391-C2-C1-C0-C0-C2-C0-C3-C0-C0-F0']")
	private WebElement postalCodeTextBox;
	
	@FindBy(how =How.XPATH, using = "//input[@id='P391-C2-C1-C0-C0-C2-C0-C3-C0-C1-F0']")
	private WebElement houseNoTextBox;
	
	@FindBy(how =How.XPATH, using = "//input[@id='P391-C2-C1-C0-C0-C2-C0-C3-C0-C2-F0']")
	private WebElement houseNoSuffixTextBox;
	
	@FindBy(how =How.XPATH, using = "//input[@id='P391-C2-C1-C0-C0-C2-C0-C3-C0-C3-F0']")
	private WebElement streetNameTextBox;
	
	@FindBy(how =How.XPATH, using = "//input[@id='P391-C2-C1-C0-C0-C2-C0-C3-C0-C4-F0']")
	private WebElement townTextBox;
	
	@FindBy(how =How.ID, using = "P391-C2-C2-B0")
	private WebElement nextPageButton;
	
	@FindBy(how=How.XPATH,using = "//*[@id='field-P391-C2-C1-C0-C0-C2-C0-C3-C0-C0-F0']")
	private WebElement postalCodeValidation;
	
	@FindBy(how=How.XPATH,using = "//*[@id='field-P391-C2-C1-C0-C0-C2-C0-C3-C0-C1-F0']")
	private WebElement houseNumberValidation;
	
	@FindBy(how=How.XPATH,using = "//*[@id='field-P391-C2-C1-C0-C0-C2-C0-C3-C0-C3-F0']")
	private WebElement streetNameValidation;

	@FindBy(how=How.XPATH,using = "//*[@id='field-P391-C2-C1-C0-C0-C2-C0-C3-C0-C4-F0']")
	private WebElement townValidation;
	
	
	
	public POBasicBankAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Method to accept cookies
	 */
	public void acceptcookies() {
		try {
		driver.findElement(By.id("aab-cookie-consent-agree")).click();
		}catch(NoSuchElementException e){
			Reporter.log("\nAccept Cookies button not found, Ingnoring and proceeding");
		}
	}
	
	/**
	 * Method to get page title
	 * @return String
	 */
	public String getPageTitle() {
		String actualTitle = driver.getTitle();
		return actualTitle;
	}
	/**
	 * Fill the details for self private account
	 * @param postcode
	 * @param houseNumber
	 * @throws InterruptedException
	 */
	public void completePrivateAccountFormForMySelf(String postcode, String houseNumber) throws InterruptedException {
		privateButton.click();
		Reporter.log("\nPrivate Account selected for account creation");
		
		mySelfButton.click();
		Reporter.log("\nFor myself selected");
		
		liveYesButtom.click();
		Reporter.log("\nStays in Netherlands clicked Yes");
		
		postalCodeTextBox.sendKeys(postcode);
		houseNoTextBox.click();

		Thread.sleep(3000);
		houseNoTextBox.sendKeys(houseNumber);
		
		houseNoSuffixTextBox.click();
		Thread.sleep(3000);
		
		nextPageButton.click();

		
	}
	
	/**
	 * Validation checks
	 * @throws InterruptedException
	 */
	public void validationCheckforChooseBankAccount() throws InterruptedException {
		Thread.sleep(2000);
		privateButton.click();
		Reporter.log("\nPrivate Account selected for account creation");
		
		mySelfButton.click();
		Reporter.log("\nFor myself selected");
		
		liveYesButtom.click();
		Reporter.log("\nStays in Netherlands clicked Yes");

		Thread.sleep(2000);		
		nextPageButton.click();
		
		Assert.assertTrue(postalCodeValidation.getText().contains("Fill in an answer to continue"));
		Reporter.log("Validation message is present for Postal code");
		
		Assert.assertTrue(houseNumberValidation.getText().contains("Fill in an answer to continue"));
		Reporter.log("Validation message is present for House Number");
		
		Assert.assertTrue(streetNameValidation.getText().contains("Fill in an answer to continue"));
		Reporter.log("Validation message is present for Street Name");
		
		Assert.assertTrue(townValidation.getText().contains("Fill in an answer to continue"));
		Reporter.log("Validation message is present for Town");
		
		Thread.sleep(3000);

		
	}
	
	
}
