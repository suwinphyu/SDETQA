### Project Name - SDETQA
### version - 1.0.0 RELEASE


#### Test automation framework based on:
- Selenium WebDriver (v 4.14.1)
- TestNG (v 6.14.2)
- Maven (v 3.10.1)
- ExtentReports (v 5.0.8)
- Log4j2 (v 2.20.0)
- Java (Oracle Open JDK version 11.0.2)


#### Pre-setup Configuration
1. \src\test\resources\URLConfig.properties => Configure base URL
2. \src\test\resources\TestData.json => All test data and login credentials data are presetup in this json file.
3. \src\test\resources\TestCases.csv => All test cases are registered in this csv file. if not configure or execute=false, program will not run for that testcase.



#### Run Steps
1. To start project, please run this file - \testng.xml
2. Able to change browser value in <parameter name="browser"  value="firefox"> of testng.xml
3. To check report - \extent-reports
4. To check screenshot for FAILED case in \screenshots



#### Web Driver Version
- chrome-driverVersion - 118.0.5993.70
- gecko-driverVersion  - 0.33.0
- edge-driverVersion   - 118.0.2088.57

#### Project Structure


#### Test Scenarios
As a user, I want to log in to with valid user's credential and add the product to the shopping cart and then proceed to checkout successfully.

#### Test Cases
1.Verify tested webpage is launched successfully
2.Verify login with valid credentials case is success
3.Verify sorting with price from high to low case is correct
4.Verify 2 items which has $15.99 price are added to shopping cart successfully
5.Verify checkout process is success with order summary
6.Able to proceed checkout process by filling valid payment info
7.Verify order is completed with valid payment information and amount
8.Verify logout from application is success
9.Unable to login with locked_out_user

#### Sample Test Result

