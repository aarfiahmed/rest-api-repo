# pagination-h2-api

# About the Project
* This project demonstrate the pagination functionality.When application starts, it first save the user details into H2 DB.<br>
This application provide two endpoints-
1. **api/v1/users**  <br> this endpoint uses the spring PagingAndSortingRepository to get Page object.
2. **api/v1/users/native** <br> this endpoint uses native query to build the Page object.

# Endpoints
1. http://localhost:8080/api/v1/users/native?page=0&size=2
2. http://localhost:8080/api/v1/users?page=0&size=2


# H2 Database
### Config 
    ````
    spring:
     datasource:
      url: "jdbc:h2:mem:testdb"
      driverClassName: org.h2.Driver
      username: sa
      password:
     jpa:
      database-platform: org.hibernate.dialect.H2Dialect
     h2:
      console:
        enabled: true
        path: /h2-console

### Console
* we can access the H2 database console from below url <br>
 http://localhost:8080/h2-console

# Author
Aarfi Siddique
