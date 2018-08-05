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
6. Harming the data on the network(Transport Layer) 
7. API INJECTIONS (XSS AND SQLI) 


### DATA PROTECTION 

A RESTful API is the way in which a given service can present value to the world. As a result, protection of the data provided via RESTful endpoints should always be a high priority. You have to define clear access rights, especially for methods like DELETE (deletes a resource) and PUT (updates a resource). Those methods must be accessed by authenticated users only, and for each such call, an audit must be saved.

**Prevention:** Authentication and Authorisaion are the first basic step to be taken to prevent data.

- ```Authentication``` is used to identify the end user reliably.
- ```Authorization``` is used to identify resources that an authenticated user can access

**MAN IN THE MIDDLE (MITM)**

A man in the middle (MITM) attack involves an attacker secretly relaying, intercepting or altering communications, including API messages, between two parties to obtain sensitive information.

For example, a perpetrator can act as a man in the middle between an API issuing a session token in an HTTP header and a user’s browser. Intercepting that session token would grant access to the user’s account, which might include personal details, such as credit card information and login credentials



