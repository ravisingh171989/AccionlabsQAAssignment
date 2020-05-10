# AccionlabsQAAssignment

Steps to Run the framework: This framework works best when Chromedriver & Firefox drivers are in PATH. For that you need to: Windows: Add driver location in PATH of environment variables. Mac: Place drivers in /usr/local/bin

Features: This framework is based out of Selenium Webdriver Java,POM, TestNG & Allure. Testcases can run on multiple browsers(chrome & safari & firefox). This framework follow POM structure.

Getting Started: Download or clone the project from: https://github.com/ravisingh171989/AccionlabsQAAssignment || git@github.com:ravisingh171989/AccionlabsQAAssignment.git

Navigate to location where the project was cloned or downloaded. Now righ-click on testVagarantDemoJava/src/test/resources/testng.xml

By editing testng.xml you can change the platform.

For reporting once the testcases are completely run, run this command withing project location: allure serve target/allure-results

