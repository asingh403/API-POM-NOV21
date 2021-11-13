# API-POM-NOV21
I will develop as E2E framework along with Extent, Allure and PDF report. Which will include CI/CD Pipline also including Jenkins as well.

# Framework Location &#x1F4D8;
- [Framework Branch](https://github.com/asingh403/API-POM-NOV21/tree/master)
- [Excel Utility Read and Populated](https://github.com/asingh403/API-POM-NOV21/blob/master/src/main/java/com/qa/api/gorest/util/ExcelUtil.java)

## Token
- [Token Utility](https://github.com/asingh403/API-POM-NOV21/blob/master/src/main/java/com/qa/api/gorest/util/Token.java)
- [Token Passed in Test Case](https://github.com/asingh403/API-POM-NOV21/blob/master/src/test/java/com/qa/api/gorest/tests/GetImgurAPITest.java)

## Upload Images Or Files
- [Imgur API | Multipart Utility](https://github.com/asingh403/API-POM-NOV21/blob/master/src/main/java/com/qa/api/gorest/restclient/RestClient.java)
- [Imgur API | Upload - Test Case Method Name : uploadImagePostAPITest](https://github.com/asingh403/API-POM-NOV21/blob/master/src/test/java/com/qa/api/gorest/tests/GetImgurAPITest.java)

## Extent Report Added
- [Extent Report ExtentReportListener](https://github.com/asingh403/API-POM-NOV21/blob/master/src/main/java/com/qa/api/gorest/listeners/ExtentReportListener.java)
- [TestNg - Test Suite XML](https://github.com/asingh403/API-POM-NOV21/blob/master/src/test/resources/testrunners/testng.xml)
- [Post Execution --> HTML Report Location | Extent Report](https://github.com/asingh403/API-POM-NOV21/tree/master/build)


## Allure Report Added
- [Allure Report AllureReportListener](https://github.com/asingh403/API-POM-NOV21/blob/master/src/main/java/com/qa/api/gorest/listeners/ExtentReportListener.java)
- Allure Report JSON
  - Go to project location using -> 
    - 1. cd C:\Users\ASHUTOSH SINGH\eclipse-workspace-Java11\API-POM-NOV21
    - 2. Type command : allure serve allure-results
    - 3. The system will generate automatically HTML Report
- [Allure Report in JSON FIle](https://github.com/asingh403/API-POM-NOV21/tree/master/allure-results)
- [TestNg - Test Suite XML](https://github.com/asingh403/API-POM-NOV21/blob/master/src/test/resources/testrunners/testng.xml)

🔺 ***Note: In API Testing Framework we don't add Screenshot in HTML report (Eg. Extent/Allure) as it is not relavent.***
