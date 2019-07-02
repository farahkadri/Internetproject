This the Selenium automation project framework using TestNG. Below are the details of the project structure.

src/test/java- You will find all the testcases written in testng format
src/main/java/configurations- You will testng.xml, where you add test suites to be executed.And run TestNG Testsuite
test-output- You will find the test outputs after the execution is completed.
test-output/old/index.html- You can open this in any browser to view the reports.
Pom.xml- This is a maven project where you can add dependencies directly into pom.xml. You can also refer https://mvnrepository.com/

Below are the steps to run the testcase:-
1.Go to src/test/java
2.Right Click on the testcase
3.Run as TestNG

OR
For Test Suites
1.Go to src/main/java/configurations.
2.Right Click on testng.xml
3.Run as TestNG

You can check the test outputs in the index.html or test-output folder.
