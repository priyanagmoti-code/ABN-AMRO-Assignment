package com.abnamro.assignment.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
/**
 * Page objects for Personal details page
 * This contains WebElements and Methods for the page
 * @author priya
 *
 */
public class POPersonalDetailsPage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//*[@id='currentStep']/div/span[2]")
	private WebElement pageTitle;

	@FindBy(how = How.XPATH, using = "//button[@value='f']")
	private WebElement salutationMrs;

	@FindBy(how = How.XPATH, using = "//input[@id='P390-C2-C0-C1-C3-F0']")
	private WebElement initialTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='P390-C2-C0-C1-C4-F0']")
	private WebElement nameTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='P390-C2-C0-C1-C6-C0-F0']")
	private WebElement surnameTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='P390-C2-C0-C1-C8-F0']")
	private WebElement birthDate;

	@FindBy(how = How.XPATH, using = "//button[@id='P390-C2-C0-C1-F9-1']")
	private WebElement usBornButtonNo;

	@FindBy(how = How.XPATH, using = "//input[@id='P390-C2-C0-C4-C3-F0']")
	private WebElement personalNumberTextBox;

	@FindBy(how = How.XPATH, using = "//button[@id='P390-C2-C0-C4-F5-0']")
	private WebElement taxPayButtonYes;

	@FindBy(how = How.NAME, using = "Next")
	private WebElement nextPageButton;
	
	@FindBy(how = How.XPATH , using = "//*[@id='field-P390-C2-C0-C1-C2-F0']")
	private WebElement validationSalutation;
	
	@FindBy(how = How.XPATH , using = "//*[@id='field-P390-C2-C0-C1-C3-F0']")
	private WebElement validationInitials;

	@FindBy(how = How.XPATH , using = "//*[@id='field-P390-C2-C0-C1-C4-F0']")
	private WebElement validationFirstName;
	
	
	
	public POPersonalDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Method to verify Your details page title
	 * @return String 
	 * @throws InterruptedException
	 */
	public String getTitle() throws InterruptedException {
		Thread.sleep(3000);
		Reporter.log("Verify Your details Page");
		String title = pageTitle.getText();
		return title;

	}
	/**
	 * Method to fill personal details on Your details page
	 * @param initials
	 * @param firstName
	 * @param sirName
	 * @param dateOfBirth
	 * @param dutchId
	 * @throws InterruptedException
	 */
	public void fillPersonalDetails(String initials, String firstName, String sirName, String dateOfBirth, String dutchId) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(salutationMrs));
		
		salutationMrs.click();
		Thread.sleep(2000);

		initialTextBox.click();
		initialTextBox.sendKeys(initials);
		Thread.sleep(2000);
		
		nameTextBox.click();
		Thread.sleep(2000);

		nameTextBox.sendKeys(firstName);
		Thread.sleep(2000);
		
		surnameTextBox.click();
		surnameTextBox.sendKeys(sirName);
		Thread.sleep(2000);
		
		birthDate.click();
		birthDate.sendKeys(dateOfBirth);
		Thread.sleep(2000);
		
		usBornButtonNo.click();
		Thread.sleep(2000);

		personalNumberTextBox.click();
		Thread.sleep(2000);

		personalNumberTextBox.sendKeys(dutchId);
		
		taxPayButtonYes.click();
		Thread.sleep(2000);

		nextPageButton.click();
		Thread.sleep(3000);
		
		
	}

	/**
	 * Validations checks
	 * @throws InterruptedException
	 */
	public void validationCheckforPersonalDetailsPage() throws InterruptedException {
		Thread.sleep(2000);
		nextPageButton.click();
		Thread.sleep(2000);
		
		Assert.assertTrue(validationFirstName.getText().contains("Fill in an answer to continue"));
		Reporter.log("Validation message is present for FirstName");
		
		Assert.assertTrue(validationInitials.getText().contains("Fill in an answer to continue"));
		Reporter.log("Validation message is present for Initials");
		
		
		Assert.assertTrue(validationSalutation.getText().contains("Please select an option in order to proceed."));
		Reporter.log("Validation message is present for Salutation");
	
		Thread.sleep(2000);

	}

}
