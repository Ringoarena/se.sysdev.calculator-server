FROM amazoncorretto:17-alpine
EXPOSE 8080
ADD target/calculator.jar calculator.jar
ENTRYPOINT ["java", "-jar", "/calculator.jar"]