package com.abnamro.assignment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;
/**
 * Page objects for Identifying page
 * This contains WebElements and Methods for the page
 * @author priya
 *
 */
public class POIdentifyingPage {

	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@id='currentStep']/div/span[2]")
	private WebElement pageTitle;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Paspoort']")
	private WebElement identityDocPassport;
	
	@FindBy(how = How.XPATH, using = "//input[@id='P389-C2-C0-C1-C1-C1-F0']")
	private WebElement emailTextBox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='P389-C2-C0-C1-C1-C2-F0']")
	private WebElement telephoneTextBox;
	
	@FindBy(how = How.NAME,using = "Next")
	private WebElement nextPageButton;
	
	public POIdentifyingPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Method to verify Identifying page title
	 * @return String
	 * @throws InterruptedException
	 */
	public String getTitle() throws InterruptedException {
		Thread.sleep(3000);
		Reporter.log("Verify Identifying Page");

		String title = pageTitle.getText();
		return title;
	}
	
	/**
	 * Method to fill details on Identifying page 
	 * @param email
	 * @param phone
	 * @throws InterruptedException
	 */
	public void fillIdentifyingPage(String email, String phone) throws InterruptedException {
		identityDocPassport.click();
		Thread.sleep(2000);
		
		emailTextBox.click();
		emailTextBox.sendKeys(email);
		Thread.sleep(2000);
		
		telephoneTextBox.click();
		Thread.sleep(2000);

		telephoneTextBox.sendKeys(0+phone);
		Thread.sleep(2000);
		
		nextPageButton.click();
		Thread.sleep(3000);
		
	}
}


