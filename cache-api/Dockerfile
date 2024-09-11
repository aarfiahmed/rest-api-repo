FROM openjdk:17-jdk

COPY /target/cache-api-1.0.jar cache-api.jar
EXPOSE 8080

RUN echo "building API project"

CMD ["java" , "-jar","cache-api.jar"]