<h1 align="center"> Twitter UI tests </h1>

<h6 align="center"> This is a sample project demonstrating how to test Twitter UI </h6>

### Build with:
- [JUnit5](https://junit.org/junit5/)
- [Selenide](https://selenide.org/)
- [Allure](http://allure.qatools.ru/)
- [AssertJ](https://joel-costigliola.github.io/assertj/)
- [Selenoid](https://aerokube.com/selenoid/)


### Getting Started
Project default parameters:
```
<browser>chrome</browser>
<browser.version>79</browser.version>
<baseUrl>https://twitter.com/</baseUrl>
<runType>local</runType>
```
You can either change them in `pom.xml` or explicitly set parameters in terminal  

### There are 2 ways to run tests in this Project:

#### 1. Run tests in local machine browser

*Note:* There is no need in supporting browser drivers anymore, `Selenide` takes care about dowloading browser drivers binaries(chrome\geckodriver and etc).
By default tests are running in chrome
  
Run command in terminal:
```sh
$ mvn clean test
```

If you want to run tests in Firefox (or other browsers) just add parameter `-Dbrowser`

```sh
$ mvn clean test -Dbrowser=firefox
```

#### 2. Run test in docker container
Prerequisites:
Install and run selenoid hub and ui - 
[Seelenoid Quick Start Guide][selenoid_quick_start_guide]


Run command to check if Selenoid is up and running:
```
$ docker ps -a
```
You should see two selenoid containers in the list:
![Seelenoid started][selenoid_start]


Run command in terminal to invoke tests
```sh
$ mvn clean test -DrunType=docker
```
If you want to specify browser or browser version adjust command with parameters `-Dbrowser`, `-Dbrowser.version`
```sh
$ mvn clean test -DrunType=docker -Dbrowser=firefox -Dbrowser.version=72 
```

Selenoid UI is available on `http://localhost:8080/`

VNC allows to see and interact with browser while log will reflect all driver actions:
![selenoid-ui][selenoid-ui]

### Reporting

Prerequisites:
Install Allure command line - [Allure Installation Guide][install-allure]

After build is finished Allure results will appear in target/allure-results folder. 
To generate html report and automatically open it in a web browser, run the following command:
```sh
$ allure serve target/allure-results
```

Allure report example:
![allure-report][allure-report]


<!-- MARKDOWN LINKS & IMAGES -->
[selenoid_quick_start_guide]: https://github.com/aerokube/selenoid/blob/master/docs/quick-start-guide.adoc#quick-start-guide
[selenoid_start]: images/selenoid_started.png
[install-allure]: https://docs.qameta.io/allure/#_installing_a_commandline
[allure-report]: images/allure_report.png
[selenoid-ui]: images/selenoid_ui.png