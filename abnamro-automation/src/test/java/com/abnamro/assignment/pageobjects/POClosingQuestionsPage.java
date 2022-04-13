package com.abnamro.assignment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;
/**
 * Page objects for Closing Questions page
 * This contains WebElements and Methods for the page
 * @author priya
 *
 */
public class POClosingQuestionsPage {
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//*[@id='currentStep']/div/span[2]")
	private WebElement pageTitle;

	@FindBy(how = How.XPATH, using = "//input[@id='P388-C2-C0-C0-C2-F1-2']")
	private WebElement incomeRadioNotApplicable;

	@FindBy(how = How.XPATH, using = "//button[@id='P388-C2-C0-C0-C2-F4-1']")
	private WebElement ownerOrDirectorButtonNo;

	@FindBy(how = How.XPATH, using = "//button[@id='P388-C2-C0-C0-C2-F6-1']")
	private WebElement transferButtonNo;

	@FindBy(how = How.XPATH, using = "//button[@id='P388-C2-C0-C0-C2-F7-1']")
	private WebElement refusedButtonNo;

	@FindBy(how = How.XPATH, using = "//button[@id='P388-C2-C1-B1']")
	private WebElement overViewButton;

	public POClosingQuestionsPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Method to verify title of closing questions page
	 * @return String
	 * @throws InterruptedException
	 */
	public String getTitle() throws InterruptedException {
		Thread.sleep(3000);
		Reporter.log("Verify Closing questions Page");
		String title = pageTitle.getText();
		return title;
	}

	/**
	 * Complete closing questions for application
	 * @throws InterruptedException
	 */
	public void completeQuestions() throws InterruptedException {
		incomeRadioNotApplicable.click();
		Thread.sleep(2000);
		ownerOrDirectorButtonNo.click();
		Thread.sleep(2000);

		transferButtonNo.click();
		Thread.sleep(2000);

		refusedButtonNo.click();
		Thread.sleep(2000);

		overViewButton.click();
		Thread.sleep(3000);
	}

}
