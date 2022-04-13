package com.abnamro.assignment.dataprovider;

import java.io.File;

import org.testng.annotations.DataProvider;

import com.abnamro.assignment.utils.ExcelDataReader;
/**
 * Data provider class to create private bank account
 * @author priya
 *
 */
public class PrivateAccountDataProvider {

	private static final String SHEET_NAME = "Sheet1";

	private static final String ABN_DATA_SET_XLSX = "AbnDataSet.xlsx";

	/**
	 * Read excel and get data for 1st bank account page, here we are getting postal code and house number
	 * @return multidimensional array of object
	 * @throws Exception
	 */
	@DataProvider
	public Object[][] bankAccount() throws Exception {

		// Prepare the path of excel file

		String filePath = System.getProperty("user.dir") + File.separator + "data" + File.separator + ABN_DATA_SET_XLSX;

		// Call read file method of the class to read data

		return ExcelDataReader.readExcel(filePath, SHEET_NAME, 0, 1);

	}

	/**
	 * Read excel and get data for personal details
	 * @return multidimensional array of object
	 * @throws Exception
	 */
	@DataProvider
	public Object[][] personalDetails() throws Exception {

		// Prepare the path of excel file

		String filePath = System.getProperty("user.dir") + File.separator + "data" + File.separator + ABN_DATA_SET_XLSX;

		// Call read file method of the class to read data

		return ExcelDataReader.readExcel(filePath, SHEET_NAME, 2, 6);

	}

	/**
	 * Read excel and get data for Identifying page
	 * @return multidimensional array of object
	 * @throws Exception
	 */
	@DataProvider
	public Object[][] identification() throws Exception {

		// Prepare the path of excel file

		String filePath = System.getProperty("user.dir") + File.separator + "data" + File.separator + ABN_DATA_SET_XLSX;

		// Call read file method of the class to read data

		return ExcelDataReader.readExcel(filePath, SHEET_NAME, 7, 8);

	}

	/**
	 * Read excel and get data for confirmation page
	 * @return multidimensional array of object
	 * @throws Exception
	 */
	@DataProvider
	public Object[][] confirmation() throws Exception {
		// Prepare the path of excel file

		String filePath = System.getProperty("user.dir") + File.separator + "data" + File.separator + ABN_DATA_SET_XLSX;

		// Call read file method of the class to read data

		return ExcelDataReader.readExcel(filePath, SHEET_NAME, 0, 8);
	}

}
