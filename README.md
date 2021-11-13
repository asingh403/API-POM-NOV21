# API-POM-NOV21
I will develop as E2E framework along with Extent, Allure and PDF report. Which will include CI/CD Pipline also including Jenkins as well.

# Framework Location &#x1F4D8;
- [Framework Branch](https://github.com/asingh403/API-POM-NOV21/tree/master)
- [Excel Utility Read and Populated](https://github.com/asingh403/API-POM-NOV21/blob/master/src/main/java/com/qa/api/gorest/util/ExcelUtil.java)

## Token Handling
- [Token Utility](https://github.com/asingh403/API-POM-NOV21/blob/master/src/main/java/com/qa/api/gorest/util/Token.java)
- [Token Passed in Test Case](https://github.com/asingh403/API-POM-NOV21/blob/master/src/test/java/com/qa/api/gorest/tests/GetImgurAPITest.java)

## Upload Images Or Files
- [Imgur API | Multipart Utility](https://github.com/asingh403/API-POM-NOV21/blob/master/src/main/java/com/qa/api/gorest/restclient/RestClient.java)
- [Imgur API | Upload - Test Case Method Name : uploadImagePostAPITest](https://github.com/asingh403/API-POM-NOV21/blob/master/src/test/java/com/qa/api/gorest/tests/GetImgurAPITest.java)

## Extent Report Added
- [Extent Report ExtentReportListener](https://github.com/asingh403/API-POM-NOV21/blob/master/src/main/java/com/qa/api/gorest/listeners/ExtentReportListener.java)
- [TestNg - Test Suite XML](https://github.com/asingh403/API-POM-NOV21/blob/master/src/test/resources/testrunners/testng.xml)
- [Post Execution → HTML Report Location | Extent Report](https://github.com/asingh403/API-POM-NOV21/tree/master/build)👈


## Allure Report Added
- [Allure Report AllureReportListener](https://github.com/asingh403/API-POM-NOV21/blob/master/src/main/java/com/qa/api/gorest/listeners/ExtentReportListener.java)
- [Allure Report JSON](https://github.com/asingh403/API-POM-NOV21/tree/master/allure-results)
- Step to produce JSON in HTML Allure Report
    - Go to project location using :-  
      - cd C:\Users\ASHUTOSH SINGH\eclipse-workspace-Java11\API-POM-NOV21
      - Type command in CMD : _**allure serve allure-results**_
      - The system will generate automatically HTML Report
- [TestNg - Test Suite XML](https://github.com/asingh403/API-POM-NOV21/blob/master/src/test/resources/testrunners/testng.xml)

🔺 ***Note: In API Testing Framework we don't add Screenshot in HTML report (Eg. Extent/Allure) as it is not relavent.***

- Response JSON after running TestNg.XML :
  - [RESPONSE-JSON](https://gist.github.com/asingh403/7b34f26b664b850a74983ca782c82599)
- After Executing Testng.XML, screenshot of **Allure HTML Report**
  ![ALLURE-REPORT](https://user-images.githubusercontent.com/36822064/141653551-db521629-13d6-4022-b879-c51a0a0cda70.JPG)
