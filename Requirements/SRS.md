# Requirements Document

## 1 Introduction

"CurrencyRateMonitor" is a web application designed for tracking currency exchange rates in the Republic of Belarus, including rates from the National Bank and bank rates. It offers the capability to convert currencies relative to a selected bank. Additionally, it provides the ability to view Currency Charts for each bank in the Republic of Belarus.
## 2 User Requirements

### 2.1 System interfaces

- Target OS: Windows, Linux, MacOS;
- Tech stack: Java, Spring framework, JavaScript;
- Additional development tools: git.

### 2.2 User interface

The main page provides the opportunity for currency conversion and links to all other resource pages

<img src="https://github.com/MiklashMark/CurrencyRateMonitor/blob/master/UI/%D0%9A%D0%BE%D0%BD%D0%B2%D0%B5%D1%80%D1%82%D0%B5%D1%80.png" height=200 width=400>

The page offering the capability to view currency charts for each bank.

<img src="https://github.com/MiklashMark/CurrencyRateMonitor/blob/master/UI/%D0%93%D1%80%D0%B0%D1%84%D0%B8%D0%BA%D0%B8%20%D0%B2%D0%B0%D0%BB%D1%8E%D1%82.png" height=200 width=400> 

The page for currency exchange rates from the National Bank of the Republic of Belarus.

<img src="https://github.com/MiklashMark/CurrencyRateMonitor/blob/master/UI/%D0%9A%D1%83%D1%80%D1%81%20%D0%B2%D0%B0%D0%BB%D1%8E%D1%82%20%D0%BF%D0%BE%20%D0%9D%D0%91%20%D0%A0%D0%91.png" height=200 width=400> 

The page for viewing currency exchange rates of banks in Belarus.

<img src="https://github.com/MiklashMark/CurrencyRateMonitor/blob/master/UI/%D0%9A%D1%83%D1%80%D1%81%D1%8B%20%D0%B2%D0%B0%D0%BB%D1%8E%D1%82%20%D0%B2%20%D0%9C%D0%B8%D0%BD%D1%81%D0%BA%D0%B5.png" height=200 width=400>



### 2.3 Users Characteristics

The typical user of this application is someone interested in monitoring and managing currency exchange rates in Belarus. They may be a traveler, international business professional, or a local resident who needs to stay informed about currency fluctuations. This user values the convenience of real-time rate updates, currency conversion capabilities, and access to currency charts to make informed financial decisions.

### 2.4 Assumptions and Dependencies

To use this web application, the user needs an internet connection and a certain level of bandwidth.

## 3 System requirements

### 3.1 Functional requirements


Certainly, here is a list of functional requirements for this application:

1. Currency Rate Updates: The application must provide real-time updates of currency exchange rates, including rates from the National Bank of the Republic of Belarus and various banks.

2. Currency Conversion: Users should be able to perform currency conversion operations, specifying the source currency, target currency, and amount to convert.

3. Bank Selection: Users must have the option to select a specific bank for currency rate information and conversion, with a list of supported banks.

4. Currency Charts: The application should offer interactive currency charts for each bank, allowing users to visualize historical exchange rate trends.

### 3.2 Quality requirements(Non-functional)

The key quality attributes for this system are reliability, security, and performance. Reliability is vital to provide consistent access to currency information, security is essential for protecting sensitive financial data, and performance ensures timely updates and responsive user interactions. These attributes can be measured through uptime monitoring, security audits, and performance testing.
