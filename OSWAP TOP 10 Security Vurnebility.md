# 10 Most Common Web Security Vulnerabilities

OWASP or Open Web Security Project is a non-profit charitable organization focused on improving the security of software 
and web applications.The organization publishes a list of top web security vulnerabilities based on the data from 
various security organizations.

The web security vulnerabilities are prioritized depending on exploitability, detectability and impact on software.


1. SQL Injection
2. Cross Site Scripting
3. Broken Authentication and Session Management
4. Insecure Direct Object References
5. Cross Site Request Forgery
6. Security Misconfiguration
7. Insecure Cryptographic Storage
8. Failure to restrict URL Access
9. Insufficient Transport Layer Protection
10. Unvalidated Redirects and Forwards


## SQL Injection

SQL injection, also known as SQLI, is a common attack vector that uses malicious SQL code for backend database 
manipulation to access information that was not intended to be displayed. This information may include any number of items, 
including sensitive company data, user lists or private customer details.

**Impact :** The impact SQL injection can have on a business is far reaching. A successful attack may result in the unauthorized 
viewing of user lists, the deletion of entire tables and, in certain cases, the attacker gaining administrative rights 
to a database, all of which are highly detrimental to a business.

When calculating the potential cost of a SQLI, it’s important to consider the loss of customer trust should personal 
information such as phone numbers, addresses and credit card details be stole.

**Example :**

An attacker wishing to execute SQL injection manipulates a standard SQL query to exploit non-validated input 
vulnerabilities in a database. There are many ways that this attack vector can be executed, several of which will 
be shown here to provide you with a general idea about how SQLI works.

For example, the above-mentioned input, which pulls information for a specific product, can be altered to read 
`http://www.estore.com/items/items.asp?itemid=999 or 1=1.`

As a result, the corresponding SQL query looks like this:

`SELECT ItemName, ItemDescription
FROM Items
WHERE ItemNumber = 999 OR 1=1`

*And since the statement 1 = 1 is always true, the query returns all of the product names and descriptions in 
the database, even those thay you may not be eligible to access.*

Attackers are also able to take advantage of incorrectly filtered characters to alter SQL commands, including using 
a semicolon to separate two fields.

For example, this input `http://www.estore.com/items/iteams.asp?itemid=999; DROP TABLE Users` would generate the following 
SQL query:

`SELECT ItemName, ItemDescription
FROM Items
WHERE ItemNumber = 999; DROP TABLE USERS`

As a result, the entire user database could be deleted.

**How to prevent SQL Injection**

1) **Prepared Statements (with Parameterized Queries)**

The use of prepared statements with variable binding (aka parameterized queries) is how all developers should first 
be taught how to write database queries. They are simple to write, and easier to understand than dynamic queries. 
Parameterized queries force the developer to first define all the SQL code,and then pass in each parameter to the
query later. This coding style allows the database to distinguish between code and data, regardless of what user 
input is supplied.

Prepared statements ensure that an attacker is not able to change the intent of a query, even if SQL commands are
inserted by an attacker. In the safe example below, if an attacker were to enter the userID of tom' or '1'='1, the 
parameterized query would not be vulnerable and would instead look for a username which literally matched the entire 
string tom' or '1'='1.


Language specific recommendations:

1) Java EE – use PreparedStatement() with bind variables
2) Hibernate - use createQuery() with bind variables (called named parameters in Hibernate)

**Safe Java Prepared Statement Example**

The following code example uses a PreparedStatement, Java's implementation of a parameterized query, to execute the 
same database query.

```SQL String custname = request.getParameter("customerName"); // This should REALLY be validated too
 // perform input validation to detect attacks
 String query = "SELECT account_balance FROM user_data WHERE user_name = ? ";
 
 PreparedStatement pstmt = connection.prepareStatement( query );
 pstmt.setString( 1, custname); 
 ResultSet results = pstmt.executeQuery( );```

Hibernate Query Language (HQL) Prepared Statement (Named Parameters) Examples

```First is an unsafe HQL Statement
 
 Query unsafeHQLQuery = session.createQuery("from Inventory where productID='"+userSuppliedParameter+"'");
 
 Here is a safe version of the same query using named parameters
 
 Query safeHQLQuery = session.createQuery("from Inventory where productID=:productid");
 safeHQLQuery.setParameter("productid", userSuppliedParameter);
 ```
 
 2) Stored Procedure
 3) Validate Inputs 
 
 
 More Details : https://www.owasp.org/index.php/SQL_Injection_Prevention_Cheat_Sheet
 
 
## Cross Site Scripting

Cross Site Scripting is also shortly known as XSS.

XSS vulnerabilities target scripts embedded in a page that are executed on the client side i.e. user browser rather then
at the server side. These flaws can occur when the application takes untrusted data and send it to the web browser without 
proper validation.

Attackers can use XSS to execute malicious scripts on the users in this case victim browsers. Since the browser cannot
know if the script is trusty or not, the script will be executed, and the attacker can hijack session cookies, deface 
websites, or redirect the user to an unwanted and malicious websites.

XSS is an attack which allows the attacker to execute the scripts on the victim's browser.

**Implication:**

Making the use of this security vulnerability, an attacker can inject scripts into the application, 
can steal session cookies, deface websites, and can run malware on the victim's machines.

**Vulnerable Objects**

- Input Fields
- URLs

**Examples**

- http://www.vulnerablesite.com/home?"<script>alert("xss")</script>

The above script when run on a browser, a message box will be displayed if the site is vulnerable to XSS.

*The more serious attack can be done if the attacker wants to display or store session cookie.*
 

