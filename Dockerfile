FROM openjdk:17-alpine
EXPOSE 8080
ADD /target/lar-idosos-api-0.0.1-SNAPSHOT.jar lar-idosos-api.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "lar-idosos-api.jar"]
