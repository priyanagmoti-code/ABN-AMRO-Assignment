#ABN-Amro Test assignment (QA)

This automation project to demonstrate Create Private Bank Account application for self.

 This project is built using maven.
 
 TestNG framework is used along with Selenuim and java for automating test cases.
 
 Page Object Design pattern is used. As well as it uses PageFactory to create instances of Page Objects.  
 
 All required dependencies are added in pom.xml
 
 In this project Apache POI is used for feeding data to Data Providers
 
 This project contains testNG.xml which is a starting point of test execution.
 TestNG.xml contains 2 test cases.
 	- First is for end to end happy flow for submitting self private bank account application.
 	- Second is for verifying the validation messages.
 	
 All page objects are in package com.abnamro.assignment.pageobjects
 
 All test cases are in package com.abnamro.assignment.testcases
 
Steps to clone and execute test cases 
git clone https://github.com/priyanagmoti-code/ABN-AmroAssignment.git
cd abnamro-automation
mvn clean test	


#
TestNG is used because of below reasons -
1)It can run multiple script at a time.
2)It provides inbuilt reporting.
3)It can feed data using data provider .
4)Can prioritize the tests, like which needs to execute first and which next.
5)We have option to set pre and post condition ( what needs to happen before and after the execution of scripts )

Maven building tool is used because of below reasons -
1)It can required dependencies automatically, no need to maintain jars in project. 
2)Easy to run testng xml with mvn test command
