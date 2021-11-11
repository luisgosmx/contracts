# contracts

## Configuration
Before you start working you needed:
- git client
- maven 
- jdk 1.8
- A Java IDE of your choice (not mandatory)
- chromedriver
- Selenium

## The tests were run in the following environment

- Hardware: MacBook Pro (2.6 Ghz Intel Core I7, 16GB DDR3).
- SO: Mac OS Big Sur
- Google Chrome 96
- Safari 15.1

_execution times could change_

## Setup
In order to get the code:

- Create a folder (Windows): 
```
md d:\Contracts
cd d:\Contracts
git clone https://github.com/luisgosmx/contracts.git
cd contracts
```
- Compile everything
```
mvn clean install
```
## Run the harvest

## NEWS

 **command**
 
 `java -jar harvester.jar -newsharvest -namesource XXXX -output XXXX`
 

**Ways to get information**
 - **RSS** (Really Simple Syndication) XML format to distribute content on the web.

**newspapers available**

- Reforma (México)  https://www.reforma.com   **_RSS_**            `-namesource reforma`
- - El Universal (México) https://www.eluniversal.com.mx   **_Web scraping_**       `-namesource eluniversal`

## DEFAULTER

**command**
 
 `java -jar harvester.jar -defaulterharvest -name "XXXX" -namesource XXXX -os XXXX -output XXXX`
