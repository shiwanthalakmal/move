# vendesilk-api-automation

### Prerequisites:
> - Java 1.8
> - Maven
> - Git

### Execute vendesilk-api-automation via Commandline:
> - Clone the vendesilk-api-automation from git. 
> - Command: ```git clone ssh://git-codecommit.us-east-2.amazonaws.com/v1/repos/vendesilk-api-automation```
> - Move to vendesilk-api-automation root directory. ```cd vendesilk-api-automation```
> - Simply trigger the execution using ```mvn clean verify``` command

#### Additional Information:
> - User friendly output will be generated on the console during the execution
> - A comprehensive html report will be generated under: ```vendesilk-api-automation\target\site\cucumber-reports\cucumber-html-reports```. Note: You can open the report by clicking on "overview-features.html"

### Third Party Library Usage
- ```Unit test runner - junit 4.12```
- ```Testing and validating REST services -rest-assured 3.0.0```
- ```Easily create matchers - org.hamcrest 2.0.0.0```
- ```BDD support - info.cukes 1.2.5```
- ```JSON extraction - com.google.code.gson 2.8.5```
- ```Generate comprehensive html test report - net.masterthought 3.20.0```
