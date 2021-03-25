Credentials <username:password>
===============================
Customer: 114:cust1
Employee: 1611:emp1
Admin: adminEC:admin

Important notes:
================
- Start running the server by executing the login.jsp, all the other pages will not be authorized without the specific roles been assigned through the login authentication process.
- to import the sql file use psql
	eg: \i <directory path>/classicmodels_dataset.sql
!! remember to import the sql dataset first, as the login credentials are added into it. without that the login part would not work.


Each Student Task Managed:
==========================
Leong Wai Chun		: login, authorization checking, order modules, Customer View Product Pagination
Ng Miao Xuan		: profile, payment modules, interface designing
Kenneth Foong Kok Chun	: product modules
Alfred Teh Hao Xian	: employee modules
