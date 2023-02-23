FROM openjdk:17-alpine
ENV SPRING_DATASOURCE=${SPRING_DATASOURCE}
EXPOSE 8080
ADD /target/lar-idosos-api-0.0.1-SNAPSHOT.jar lar-idosos-api.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-Dspring.datasource.url=${SPRING_DATASOURCE}", "-jar", "lar-idosos-api.jar"]
