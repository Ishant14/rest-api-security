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

*multiple solutions exist to block malicious traffic and prevent attacks. Among the most common mitigation methods is to generate unique random tokens for every session request or ID. These are subsequently checked and verified by the server. Session requests having either duplicate tokens or missing values are blocked. Alternatively, a request that doesn’t match its session ID token is prevented from reaching an application.*

*Double submission of cookies is another well-known method to block CSRF. Similar to using unique tokens, random tokens are assigned to both a cookie and a request parameter. The server then verifies that the tokens match before granting access to the application.*




