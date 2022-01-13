# MIW3 LeenmanBank Eindproject

This repo contains two folders.  
Each folder is a seperate project that can be openend in IntelliJ IDEA.
  
The Java Spring project is for the web interface of the bank application.   
The JavaFX project is for the pin terminal.

## MySQL connection setup
When you run the LeenmanBank Java Spring application it will try to connect to your local MySQL database (`localhost:3306`) and automatically create a database schema and tables.

See the `application.properties` file for configuration details.

To connect to your local MySQL datasource, you need to add a `.properties` file with your corresponding MySQL username and password. See steps below:

### Step 1  
In directory:  
`IntelliJProjectLeenmanBankSpring/src/main/resources/ `  
create new file:  
`local-mysql-connection.properties`
```
IntelliJProjectLeenmanBankSpring
└───src
│   └───main
│       └───resources
│       │   application.properties
│       │   local-mysql-connection.properties   <- create this file here
│       │   ...

```


### Step 2  
Edit your created `local-mysql-connection.properties` file and add these two lines to the file:
```
spring.datasource.username = root
spring.datasource.password = rootroot
```
Note: replace the username and password with your own and save the file.

## Team Roles
Scrummaster: Jeroen\
Trello: Ralf\
Gitmaster: ?

## Team agreements
Language: ENG (coding/for user (in app)) & NL (for user (in app))
JDK:
Fond type:
Style:

###D.o.D. 
What do we accept as a team? + Which tools are we going to use?
* SIG1 Write short units of code (functie <= 15 regels):
* SIG2 Write short units of code (ontwikkelpaden (nested code) <= 4):
* SIG3 Write code once:
* SIG4 Keep unit interfaces small:
* SIG5 Separate concerns in modules:
* SIG6 Couple architecture components loosely:
* SIG7 Keep architecture components balanced:
* SIG8 Keep your code base small:
* SIG9 Automate tests:
* SIG10 Write clean code:

Tools for testing software quality:
* Better Code Hub - begin/end of sprint -> Total of 60% of code will be accepted + 10 out of 10 green V
* TestCherry - Unit/UAT -> FRIDAY! 
* CodeMetrics - SIG2
* IntelliJ - SIG3
* EmBold
* SonarQuebe - lokaal installeren (server component)

Review:
* 2 members have reviewed your code before moving it to done in Trello
* Give feedback to original owner of user story + write comment + update by app/teams...
* Changes with big impact (f.e. change folder/class name) done by one person and inform whole group (rebase)