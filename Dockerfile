FROM openjdk:17.0

COPY demo-*.jar demo.jar

CMD ["java", "-jar", "/demo.jar"]