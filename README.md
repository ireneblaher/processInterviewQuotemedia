# processInterviewQuotemedia

## Instructions for execute

Everything is configurated.
Steps for the execution:  

* 1: Run -> QuoteAplication.java
* 2: Then execute the nexts URLs, is a example pair:

In aplication.properties was configurated in port 8082,
if you have any problem you can change in this file (aplication.properties)

* Examples of endpoints:

-The second for  obtain ask,bid and status by symbol (3 different cases)
1. Response 202 ok (valid data and result)
http://localhost:8082/getquotebysymbol/FB 

2. Response 404 not found (Valid data, but any result)
http://localhost:8082/getsymbolmostaskbyday/NSTGM

3. Response 400 bad request (Invalid data)
http://localhost:8082/getsymbolmostaskbyday/N

-The first for get the symbol by day whith most ask (3 different cases)
1. Response 202 ok (valid data and result)
http://localhost:8082/getsymbolmostaskbyday/2020-01-01

2. Response 404 not found (Valid data, but any result)
http://localhost:8082/getsymbolmostaskbyday/2025-02-15

3. Response 400 bad request (Invalid data)
http://localhost:8082/getsymbolmostaskbyday/hello

* How execute the Mockito Test

There are located in the package src/test/java
for execute them its only necessary to select
 1.Run -> QuoteControllerTest.java
 2.Run -> QuoteRepositoryTest.java
 3.Run -> QuoteServiceTest.java

