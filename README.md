An Application Programming Interface (API) is a software intermediary that allows your applications to communicate with one another. It provides routines, protocols, and tools for developers building software applications, while enabling the extraction and sharing of data in an accessible manner.

Web APIs connect between applications and other services or platforms, such as social networks, games, databases and devices.

Additionally, Internet of Things (IoT) applications and devices use APIs to gather data, or even control other devices. For example, a power company may use an API to adjust the temperature on a thermostat to save power.


***REST (or REpresentational State Transfer)*** is an architectural style that evolved as Fielding wrote the HTTP/1.1 and URI specs and has proven to be well-suited for developing distributed hypermedia applications. While REST is more widely applicable, it is most commonly used within the context of communicating with services via HTTP.  


## API SECURITY THREATS

APIs often self-document information, such as their implementation and internal structure, which can be used as intelligence for a cyber-attack. Additional vulnerabilities, such as weak authentication, lack of encryption, business logic flaws and insecure endpoints make APIs vulnerable to the attacks outlined below.

1. Data Protection
3. MITM (Man in the middle)
4. Anti farming 
5. DOS attack 
6. API INJECTIONS (XSS AND SQLI) 
7. CSRF attack


### DATA PROTECTION 

A RESTful API is the way in which a given service can present value to the world. As a result, protection of the data provided via RESTful endpoints should always be a high priority. You have to define clear access rights, especially for methods like DELETE (deletes a resource) and PUT (updates a resource). Those methods must be accessed by authenticated users only, and for each such call, an audit must be saved.

**Prevention:** Authentication and Authorisaion are the first basic step to be taken to prevent data.

- ```Authentication``` is used to identify the end user reliably.
- ```Authorization``` is used to identify resources that an authenticated user can access

### MAN IN THE MIDDLE (MITM)

A man in the middle (MITM) attack involves an attacker secretly relaying, intercepting or altering communications, including API messages, between two parties to obtain sensitive information.

For example, a perpetrator can act as a man in the middle between an API issuing a session token in an HTTP header and a user’s browser. Intercepting that session token would grant access to the user’s account, which might include personal details, such as credit card information and login credentials

**Prevention :** Encryption and Signatures

```Encryption``` is generally used to avoid unauthorized access to information from those not authorized to view it. Often SSL is used on the internet to encrypt HTTP messages received by browsers or API clients. But SSL only protects requests on the transport layer, and we also require protection data on other layers. In order to further strengthen data security, signatures are used, which ensures that an API request and response is not tampered with in transit. However, a message can be unencrypted but on arrival must be intact (i.e., protected against modification).

Often, encryption and signatures are used in combination; signatures can be encrypted so that only authorized parties can validate them, or the encrypted message can be signed to ensure that data is neither seen nor modified by unwanted parties.

Transport Layer Security (TLS) and its predecessor, Secure Sockets Layer (SSL), are cryptographic protocols that provide communications security over a computer network. 

When secured by TLS, connections between a client and a server have one or more of the following properties: 

- The connection is private (or secure) because symmetric cryptography is used to encrypt the data transmitted. 
- The keys for this symmetric encryption are generated uniquely for each connection and are based on a shared secret negotiated at the start of the session. 
- The identity of the communicating parties can be authenticated using public-key cryptography. 
- The connection ensures integrity because each message transmitted includes a message integrity check using a message authentication code to prevent undetected loss or alteration of the data during transmission.


### DOS ATTACKS :

In a Denial of Service (DOS) attack, the attacker usually sends excessive messages asking the network or server to authenticate requests that have invalid return addresses. DOS attacks can render a RESTful API into a non-functional state if the right security measures are not taken.

Today, even if your API is not exposed to the public, it still might be accessible by others. This means that REST API security is getting more and more valuable and important. Consider that someone succeeds in making a DOS attack- it means that all the connected clients (partners, apps, mobile devices, and more) will not be able to access your API.

**Prevention :** 

A ***web application firewall (WAF)*** applies a set of rules to an HTTP/S conversations between applications. WAFs are commonly used to secure API platforms, as they are able to prevent misuse and exploitation and helps mitigate application-layer DDoS attacks.

In addition, WAFs use a list of regularly-patched, strict signatures and SSL/TLS encryption to block injection attacks and prevent the interception of site traffic in MITM attacks.


### API INJECTIONS (XSS AND SQLI) 

In a code injection attack, malicious code is inserted into a vulnerable software program to stage an attack, such as cross site scripting (XSS) and SQL injection (SQLi).

For example, a perpetrator can inject a malicious script into a vulnerable API, i.e., one that fails to perform proper filter input, escape output (FIEO), to launch an XSS attack targeting end users’ browsers. *Additionally, malicious commands could be inserted into an API message, such as an SQL command that deletes tables from a database.*

Any web API requiring parsers or processers is vulnerable to attack. For example, a code generator that includes parsing for JSON code, and doesn’t sanitize input properly, is susceptible to the injection of executable code that runs in the development environment.

**Prevention :** A web application firewall (WAF) is the most commonly used solution for protection from XSS and web application attacks.

WAFs employ different methods to counter attack vectors. In the case of XSS, most will rely on signature based filtering to identify and block malicious requests.

### CSRF attack

Cross site request forgery (CSRF), also known as XSRF, Sea Surf or Session Riding, is an attack vector that tricks a web browser into executing an unwanted action in an application to which a user is logged in.

A successful CSRF attack can be devastating for both the business and user. It can result in damaged client relationships, unauthorized fund transfers, changed passwords and data theft—including stolen session cookies.

CSRFs are typically conducted using malicious social engineering, such as an email or link that tricks the victim into sending a forged request to a server. As the unsuspecting user is authenticated by their application at the time of the attack, it’s impossible to distinguish a legitimate request from a forged one.


**Preventipon :**

- Logging off web applications when not in use
- Securing usernames and passwords
- Not allowing browsers to remember passwords
- Avoiding simultaneously browsing while logged into an application

*Multiple solutions exist to block malicious traffic and prevent attacks. Among the most common mitigation methods is to generate unique random tokens for every session request or ID. These are subsequently checked and verified by the server. Session requests having either duplicate tokens or missing values are blocked. Alternatively, a request that doesn’t match its session ID token is prevented from reaching an application.*

*Double submission of cookies is another well-known method to block CSRF. Similar to using unique tokens, random tokens are assigned to both a cookie and a request parameter. The server then verifies that the tokens match before granting access to the application.*


## API SECURITY BEST PRACTICES

### :+1: 1.Authentication and Authorization

Determining the identity of an end user. In case your API does not have an Authorization/Authentication mechanism, it might lead to misuse of your API, loading the servers and the API itself, making it less responsive to others.

- **Protect HTTP methods** RESTful API often use GET (read), POST (create), PUT (replace/update) and DELETE (to delete a record). Not all of these are valid choices for every single resource collection, user, or action. Make sure the incoming HTTP method is valid for the session token/API key and associated resource collection, action, and record.

For example, if you have an RESTful API for a library, it's not okay to allow anonymous users to DELETE book catalog entries, but it's fine for them to GET a book catalog entry. On the other hand, for the librarian, both of these are valid uses.


- **Implement CORS**

Cross-origin resource sharing (CORS) is a mechanism that allows restricted resources on a web page to be requested from another domain outside the domain from which the first resource was served.[1] A web page may freely embed cross-origin images, stylesheets, scripts, iframes, and videos.[2] Certain "cross-domain" requests, notably Ajax requests, are forbidden by default by the same-origin security policy.

CORS defines a way in which a browser and server can interact to determine whether or not it is safe to allow the cross-origin request.[3] It allows for more freedom and functionality than purely same-origin requests, but is more secure than simply allowing all cross-origin requests.

- **Whitelist allowable methods**

It is common with RESTful services to allow multiple methods for a given URL for different operations on that entity.

For example, a GET request might read the entity while PUT would update an existing entity, POST would create a new entity, and DELETE would delete an existing entity.

It is important for the service to properly restrict the allowable verbs such that only the allowed verbs would work, while all others would return a proper response code (for example, a 403 Forbidden).

- ** Protect privileged actions and sensitive resource collections**

Not every user has a right to every web service. This is vital, as you don't want administrative web services to be misused:

```https://example.com/admin/exportAllData```

The session token or API key should be sent along as a cookie or body parameter to ensure that privileged collections or actions are properly protected from unauthorized use.

- **Protect against cross-site request forgery**

For resources exposed by RESTful web services, it's important to make sure any PUT, POST, and DELETE request is protected from Cross Site Request Forgery. Typically one would use a token-based approach.

CSRF is easily achieved even using random tokens if any XSS exists within your application, so please make sure you understand how to prevent XSS.


### :+1: 2. Input Validation

Validating the end user-supplied data before processing is important, as this can lead to different problems. Validation comes under different categories:

- **Secure Parsing** – Input messages should be parsed securely and need to ensure that the parser is not vulnerable to attacks such as XEE (XML External Entity) if parsing XML, or any similar attacks.

- **Strong Typing** – If the allowed list of values are of strong type (e.g., number, boolean, etc.), then it is difficult to perform most of the attacks.

- **Validate Incoming Content Types** – When the client submits data, either with POST or PUT, it adds a Content-Type header (e.g., application/xml or application/json). The server should verify whether the incoming data and Content-Type header are of the same type. If either of these are not of the same type, lack a Content-Type header, or have an unexpected header, then the content should be rejected with a 406 (Not Acceptable) response.

- **Validate Response Types** – While making a request to the REST API, the client adds the Accept header, which holds the preferred order of acceptable content types as a response from the API. The server should reject the request with a 406 (Not Acceptable) response, if the Accept header does not contain allowable content types.

- **XML Input Validation** – APIs based on XML should ensure that they are protected against attacks such as XEE (XML External Entity), XML signature wrapping, etc., by using secure XML parsing.

- **URL Validations** – APIs use input from HTTP requests to determine the response. Attackers can attack any part of an HTTP request (e.g.,  URL, Query String, headers, etc.), and HTTP requests should be validated against any tampering.


### :+1: 3.  Output Encoding

- **Security headers** : - To make sure the content of a given resources is interpreted correctly by the browser, the server should always send the Content-Type header with the correct Content-Type, and preferably the Content-Type header should include a charset.

The server should also send an ```X-Content-Type-Options: nosniff``` to make sure the browser does not try to detect a different Content-Type than what is actually sent (can lead to XSS).

Additionally the client should send an ```X-Frame-Options: deny``` to protect against drag'n drop clickjacking attacks in older browsers


- **JSON encoding** :- 
A key concern with JSON encoders is preventing arbitrary JavaScript remote code execution within the browser... or, if you're using node.js, on the server. It's vital that you use a proper JSON serializer to encode user-supplied data properly to prevent the execution of user-supplied input on the browser.

*When inserting values into the browser DOM, strongly consider using .value/.innerText/.textContent rather than .innerHTML updates, as this protects against simple DOM XSS attacks.*

- **XML encoding** :- 
XML should never be built by string concatenation. It should always be constructed using an XML serializer. This ensures that the XML content sent to the browser is parseable and does not contain XML injection. For more information, please see the Web Service Security Cheat Sheet.

### :+1: Cryptography

**Data in transit**

Unless the public information is completely read-only, the use of TLS should be mandated, particularly where credentials, updates, deletions, and any value transactions are performed. The overhead of TLS is negligible on modern hardware, with a minor latency increase that is more than compensated by safety for the end user.

Consider the use of mutually authenticated client-side certificates to provide additional protection for highly privileged web services.

**Data in storage**

Leading practices are recommended as per any web application when it comes to correctly handling stored sensitive or regulated data. For more information, please see OWASP Top 10 2010 - A7 Insecure Cryptographic Storage.

**Message Integrity**

In addition to HTTPS/TLS, JSON Web Token (JWT) is an open standard (RFC 7519) that defines a compact and self-contained way for securely transmitting information between parties as a JSON object.

JWT can not only be used to ensure the message integrity but also authentication of both message sender/receiver.
The JWT includes the digital signature hash value of the message body to ensure the message integrity during the 
transmition.

### :+1: HTTP Status Codes

HTTP defines status code. When design REST API, don't just use 200 for success or 404 for error.

Here are some guideline to consider for each REST API status return code. Proper error handle may help to validate the incoming requests and better identify the potential security risks. 


- **200 OK** - Response to a successful REST API action. The HTTP method can be GET, POST, PUT, PATCH or DELETE.
- **400 Bad Request** - The request is malformed, such as message body format error.
- **401 Unauthorized** - Wrong or no authencation ID/password provided.
- **403 Forbidden** - It's used when the authentication succeeded but authenticated user doesn't have permission to the request resource.
- **404 Not Found** - When a non-existent resource is requested.
- **405 Method Not Allowed** - The error checking for unexpected HTTP method. For example, the RestAPI is expecting HTTP GET, but HTTP PUT is used.
- **429 Too Many Requests** - The error is used when there may be DOS attack detected or the request is rejected due to rate limiting

**401 vs 403**

- 401 “Unauthorized” really means Unauthenticated, “You need valid credentials for me to respond to this request”.
- 403 “Forbidden” really means Unauthorized, “I understood your credentials, but so sorry, you’re not allowed!”


In a REST API, there are many ways to implement the Authentication and Authorisation. 

1) Basic Authentication
2) API Key
3) SECURITY ASSESSMENT MARKUP LANGUAGE (SAML)
4) OAuth 2 (Open Authorisation)
5) JWT Token

### 2. Encryption and Signature 




