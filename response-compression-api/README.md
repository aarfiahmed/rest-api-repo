# response-compression-api

# Description
* This project uses the gzip to compress the response.

# Why Use Gzip Compression in Your Spring Boot REST API?

* **Faster Data Transfer:** The primary benefit of using Gzip compression in your Spring Boot REST API is the significant boost in data transfer speed. Smaller data payloads lead to quicker transmission times, which is especially valuable for users on slow or mobile connections.
* **Reduced Bandwidth Usage:** Gzip compression considerably reduces the amount of bandwidth your API consumes. This can lead to cost savings, especially if you are charged based on the amount of data transferred.
* **Enhanced Latency:** Smaller payloads and faster data transfer times can help reduce API latency. This results in a more responsive and efficient application, which is a big win in the eyes of your users.
* **Improved User Experience:** Today’s users have high expectations for application responsiveness. Gzip compression ensures that your API loads faster, providing a smoother user experience and higher overall satisfaction

# How to Implement Gzip Compression in Your Spring Boot REST API
* **Add Gzip Dependency**  
    ```
    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
    </dependency>

* **Enable Gzip Compression**
   ```
   server.compression.enabled=true
   server.compression.min-response-size=2048
   server.compression.mime-types=text/html,text/xml,text/plain,text/css,application/json

# Author
* Aarfi Siddique