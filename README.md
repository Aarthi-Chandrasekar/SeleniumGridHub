**SeleniumGridHub**

**About:**

SeleniumGridHub is a Selenium Grid automation framework for running tests across various browsers and platforms. It supports parallel execution, offers configurable options, integrates Allure reporting, and facilitates Cucumber BDD testing.

**Getting Started:**

1. **Download Selenium Grid:** Download the Selenium Grid java jar from https://www.selenium.dev/downloads/.

2. **Set Up Grid:** Navigate to the downloaded folder and execute and execute each of the following commands in individual command prompts:

   java -jar selenium-server-4.12.1.jar event-bus
   java -jar selenium-server-4.12.1.jar sessions
   java -jar selenium-server-4.12.1.jar sessionqueue
   Java -jar selenium-server-4.12.1.jar distributor --sessions http://localhost:5556 --sessionqueue http://localhost:5559 --bind-bus false
   java -jar selenium-server-4.12.1.jar router --sessions http://localhost:5556 --distributor http://localhost:5553 --sessionqueue http://localhost:5559 --port 4444
   java -jar selenium-server-4.12.1.jar node --detect-drivers true

3. **WebDriver Initialization:** Initialize WebDriver instances using the provided Environment class.

4. **Allure Setup:** Follow instructions from Allure's official site (https://docs.qameta.io/allure/)

4. **Write Tests:** Create your tests in Cucumber BDD format or run the sample tests included in the framework using the command mvn clean install.

5. **View Test Results:** To view test results, run the following command in the terminal: allure serve allure-results.

