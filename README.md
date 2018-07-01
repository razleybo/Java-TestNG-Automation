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
Download a [selenium stand alone binery](https://docs.seleniumhq.org/download/) and a [Chrome driver](https://sites.google.com/a/chromium.org/chromedriver/downloads) and Run the stand alone Server.
```
java -jar selenium-server-standalone-<version>.jar
```
### Run with remote hub
All binaries are beeing automaticly downloaded 
so only hub configurations is needed :
```
-Dselenium.hub.host="myAwesomeHubMachine:4444" 
```
or
```
-Dselenium.hub.url = "http://myAwesomeHubMachine:4444/wd/hub"
```

### Executing 
Executing with Maven :
* local selenium 
```
mvn test
```
* remote hub 
```
mvn test -Dselenium.hub.host="myAwesomeHubMachine:4444"
```

## Next Implimitations 
This section describe the next things I would like to implement

### Running Log
We are missing a log reflecting on runtime , what is beeing performed 

### Readable report
since we are using surefire plugin , we have automatic report under target/surefire-reports
this can be improved 


## Authors

* **Raz Leybowitch** - *:-)* 

