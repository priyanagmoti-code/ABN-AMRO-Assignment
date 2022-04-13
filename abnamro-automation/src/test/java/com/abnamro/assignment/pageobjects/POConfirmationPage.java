package com.abnamro.assignment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;
/**
 * Page objects for confirmation page
 * This contains WebElements and Methods for the page
 * @author priya
 *
 */
public class POConfirmationPage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//*[@id='currentStep']/div/span[2]")
	private WebElement pageTitle;

	@FindBy(how = How.XPATH, using = "//*[@id='P580-C2-C0-TI5']/span/p/table/tbody/tr[3]/td")
	private WebElement yourName;

	@FindBy(how = How.XPATH, using = "//*[@id='P580-C2-C0-TI5']/span/p/table/tbody/tr[6]/td")
	private WebElement address;

	@FindBy(how = How.XPATH, using = "//*[@id='P580-C2-C0-TI5']/span/p/table/tbody/tr[9]/td")
	private WebElement dob;

	@FindBy(how = How.XPATH, using = "//*[@id='P580-C2-C0-TI5']/span/p/table/tbody/tr[12]/td")
	private WebElement phoneNo;

	@FindBy(how = How.XPATH, using = "//*[@id='P580-C2-C0-TI5']/span/p/table/tbody/tr[15]/td")
	private WebElement emailAddress;
	
	@FindBy(how = How.XPATH, using = "//button[@id='P580-C2-C1-B1']")
	private WebElement applyButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='P872-C1-C0-TI2']/p/h3[1]")
	private WebElement thankYouMessage;
	
	
	

	public POConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Verifying title for confirmation page
	 * @return String
	 * @throws InterruptedException
	 */
	public String getTitle() throws InterruptedException {
		Thread.sleep(3000);
		Reporter.log("Verifying Confirm Page");

		String title = pageTitle.getText();
		return title;
	}

	/**
	 * Method to verify Confirmation details
	 * @param initials
	 * @param firstName
	 * @param lastName
	 * @param houseNo
	 * @param postalCode
	 * @param birthDate
	 * @param email
	 * @param phoneNo
	 */
	public void verifyPersonalDetails(String initials, String firstName, String lastName, String houseNo,
			String postalCode, String birthDate, String email, String phoneNo) {
		Reporter.log("Verifying details on overview Page");

		Assert.assertTrue(yourName.getText().replace(".","").contains(initials));
		Assert.assertTrue(yourName.getText().contains(firstName));
		Assert.assertTrue(yourName.getText().contains(lastName));
		Assert.assertTrue(address.getText().contains(houseNo));
		Assert.assertTrue(address.getText().contains(postalCode));
		
		Assert.assertTrue(dob.getText().contains(birthDate));
		Assert.assertTrue(emailAddress.getText().contains(email));
		Assert.assertTrue(this.phoneNo.getText().contains(phoneNo));
	}
	/**
	 * Method to submit application and verify after submit message
	 * @throws InterruptedException
	 */
	public void clickAppyButtonAndVerify() throws InterruptedException {
		applyButton.click();
		Reporter.log("Bank account application submitted");
		Thread.sleep(3000);
		
		Assert.assertTrue(thankYouMessage.getText().contains("Thank you for choosing ABN AMRO"));
		
		Reporter.log("Thank you for choosing ABN AMRO Verified");

	}

}
