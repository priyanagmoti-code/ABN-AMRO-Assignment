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
import com.abnamro.assignment.pageobjects.POClosingQuestionsPage;
import com.abnamro.assignment.pageobjects.POConfirmationPage;
import com.abnamro.assignment.pageobjects.POIdentifyingPage;
import com.abnamro.assignment.pageobjects.POPersonalDetailsPage;
import com.abnamro.assignment.utils.BrowserBase;

/**
 * End to end positive Test step covered for private account opening for self.
 * This Test case is getting called from testNG.xml
 * @author priya
 *
 */
public class TCOpenOwnAccount extends PrivateAccountDataProvider {
	private WebDriver driver;
	private POBasicBankAccountPage chooseBA;
	private POPersonalDetailsPage personalDetailsPage;
	private POIdentifyingPage identifyingPage;
	private POClosingQuestionsPage closingQuestionPage;
	private POConfirmationPage confirmPage;

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

		identifyingPage = PageFactory.initElements(driver, POIdentifyingPage.class);

		closingQuestionPage = PageFactory.initElements(driver, POClosingQuestionsPage.class);

		confirmPage = PageFactory.initElements(driver, POConfirmationPage.class);

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
	 * accepting cookies here.
	 */
	@Test(priority = 1)
	public void acceptCockies() {
		chooseBA.acceptcookies();
	}

	/**
	 * Test step to fill basic information on 1st page 
	 * Loading data from bankAccount data provider
	 * @param postcode
	 * @param houseNumber
	 * @throws InterruptedException
	 */
	@Test(priority = 2, dataProvider = "bankAccount")
	public void completeFormForMySelf(String postcode, String houseNumber) throws InterruptedException {

		chooseBA.completePrivateAccountFormForMySelf(postcode,houseNumber);
	}

	/**
	 * Test step to verify 2nd page(Your details) title
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void verifyTitleYourDetailsPage() throws InterruptedException {
		Assert.assertEquals("Your details", personalDetailsPage.getTitle());
		Reporter.log("Your details page is opened");
	}

	/**
	 * Test step to fill personal details on Your details page
	 * Loading data from personalDetails data provider
	 * @param initials
	 * @param firstName
	 * @param sirName
	 * @param dateOfBirth
	 * @param dutchId
	 * @throws InterruptedException
	 */
	@Test(priority = 4, dataProvider = "personalDetails")
	public void fillPersonalDetails(String initials, String firstName, String sirName, String dateOfBirth,String dutchId)
			throws InterruptedException {
		
		personalDetailsPage.fillPersonalDetails(initials,firstName,sirName,dateOfBirth,dutchId);
		Reporter.log("Personal details entered");
	}

	/**
	 * Test step to verify 3rd page(Identifying) title
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void verifyTitleIdentifyingPage() throws InterruptedException {
		Assert.assertEquals("Identifying", identifyingPage.getTitle());
		Reporter.log("Identifying page is opened");
	}

	/**
	 * Test step to fill identifying details
	 * Loading data from identification data provider
	 * @param email
	 * @param phone
	 * @throws InterruptedException
	 */
	@Test(priority = 6,dataProvider = "identification")
	public void fillIdentifyingPage( String email, String phone) throws InterruptedException {
		
		identifyingPage.fillIdentifyingPage(email,phone);
		Reporter.log("Identifying details filled and clicked on next page");
	}
	
	/**
	 * Test step to verify 4th page(Closing Questions) title
	 * @throws InterruptedException
	 */
	@Test(priority = 7)
	public void verifyTitleClosingQuestionPage() throws InterruptedException {
		Assert.assertEquals("Closing questions", closingQuestionPage.getTitle());
		Reporter.log("Closing questions page is opened");
	}

	/**
	 * Test step to fill closing questions information
	 * @throws InterruptedException
	 */
	@Test(priority = 8)
	public void completeClosingQuestionPage() throws InterruptedException {
		closingQuestionPage.completeQuestions();
		Reporter.log("Closing Questions filled and clicked on next page");
	}

	/**
	 * Test step to verify confirmation page title
	 * @throws InterruptedException
	 */
	@Test(priority = 9)
	public void verifyTitleConfirmPage() throws InterruptedException {
		
		Assert.assertEquals("Confirm", confirmPage.getTitle());
	}
	/**
	 * Test step to confirm application details
	 * Loading data from confirmation data provider
	 * @param postalCode
	 * @param houseNo
	 * @param initials
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param dutchId
	 * @param email
	 * @param phoneNo
	 */
	@Test(priority = 10, dataProvider = "confirmation" )
	public void confirmDetails(String postalCode, String houseNo, String initials, String firstName, String lastName,
			String birthDate, String dutchId, String email, String phoneNo) {
		confirmPage.verifyPersonalDetails(initials,firstName,lastName,houseNo,postalCode,birthDate,email,phoneNo);
	}

	/**
	 * Test step to submit account opening application and check after submit message
	 * @throws InterruptedException
	 */
	@Test(priority = 11)
	public void submitApplication() throws InterruptedException {
		confirmPage.clickAppyButtonAndVerify();
		
	}
	
	/**
	 * closing browser
	 */
	@AfterTest
	public void cleanUp() {
		driver.close();
	}

}
