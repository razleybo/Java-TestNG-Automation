# Todo MVC Automation
This is a sample of a selenium project ruuning with Java,TestNG.
It is wiritten using page object modal and actions (DSL).
Also creating [allure report](http://allure.qatools.ru). 
It execute some simple tests on the http://todomvc.com/ site on the React example.
It can be run on a hub (remotely) or on a local machine , using Chrome or Firefox. 
## Running Info
This Project is Build with Maven , Run with TestNG , Using Selenuim.

It can be run on a local stend alone server , or using a remote hub, using the profile Remote and overring system property :
```
-Dselenium.hub.host="myAwesomeHubMachine:4444" 
```
or
```
-Dselenium.hub.url = "http://myAwesomeHubMachine:4444/wd/hub"
```
Using the profile Chrome ,or Firefox , will allow executiong on each browser .
### Run localy 
defult execution runs with Chrom broeser 
```
mvn clean test 
```
in order to run with Firefx you need to add the Firefox profile 
```
mvn clean test -P Firefox
```
### Run with hub
in oreder to run with a hub , you need to add the Remote profile 
by defult the hub is configured to localhost:4444 this configuration can be changed by overriding properties :
```
-Dselenium.hub.host="myAwesomeHubMachine:4444" 
```
or
```
-Dselenium.hub.url = "http://myAwesomeHubMachine:4444/wd/hub"
```
execution example will be :
```
mvn clean test -P Firefox,Remote -Dselenium.hub.host="myAwesomeHubMachine:4444" 
```
### Reporting  
Allure report 2.0 is integated and can be shouwed by running :
```
mvn allure:serve
```

## Author

* **Raz Leybowitch** - *:-)* 

