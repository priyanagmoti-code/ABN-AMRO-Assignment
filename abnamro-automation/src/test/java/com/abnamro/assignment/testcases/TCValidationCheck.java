package com.abnamro.assignment.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.abnamro.assignment.dataprovider.PrivateAccountDataProvider;
import com.abnamro.assignment.pageobjects.POBasicBankAccountPage;
import com.abnamro.assignment.pageobjects.POPersonalDetailsPage;
import com.abnamro.assignment.utils.BrowserBase;

/**
 * Test Case for validation message checks 
 * This Test case is getting called from testNG.xml
 * @author priya
 *
 */
public class TCValidationCheck extends PrivateAccountDataProvider{
	
	private WebDriver driver;
	private POBasicBankAccountPage chooseBA;
	private POPersonalDetailsPage personalDetailsPage;

	
	/**
	 * Loading initial driver setup and creating page objects.
	 * For creating page objects we are using Page Factory.
	 * @param url
	 * @param browser
	 */
	@BeforeTest
	@Parameters({ "url", "browser" })
	public void setUp(String url, String browser) {
		driver = BrowserBase.getDriver(url, browser);
		chooseBA = PageFactory.initElements(driver, POBasicBankAccountPage.class);
		personalDetailsPage = PageFactory.initElements(driver, POPersonalDetailsPage.class);
		chooseBA.acceptcookies();
	}
	/**
	 * Verifying page title after loading account opening URL.
	 */
	@Test(priority = 0)
	public void checkPageTitle() {

		String actualTitle = chooseBA.getPageTitle();
		String expectedTitle = "Open your own bank account - ABN AMRO";
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("\nPage title validated, title is " + expectedTitle);
	}
	/**
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void validationCheckforChooseBankAccount() throws InterruptedException {
		chooseBA.validationCheckforChooseBankAccount();
		
	}
	/**
	 * Test step to fill basic information on 1st page 
	 * Loading data from bankAccount data provider
	 * @param postcode
	 * @param houseNumber
	 * @throws InterruptedException
	 */
	@Test(priority = 2 , dataProvider =  "bankAccount")
	public void completeFormForMySelf(String postcode, String houseNumber) throws InterruptedException {

		chooseBA.completePrivateAccountFormForMySelf(postcode,houseNumber);
	}
	
	/**
	 * Check validations on personal page
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void validationCheckforPersonalDetailsPage() throws InterruptedException {
		personalDetailsPage.validationCheckforPersonalDetailsPage();
		
	}
	
	/**
	 * closing browser
	 */
	@AfterTest
	public void cleanUp() {
		driver.close();
	}


}
