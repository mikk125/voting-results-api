FROM openjdk:11
COPY build/libs/voting-results-api-0.0.1-SNAPSHOT.jar voting-results.jar
ENTRYPOINT ["java", "-jar", "voting-results.jar"]
EXPOSE 8080
