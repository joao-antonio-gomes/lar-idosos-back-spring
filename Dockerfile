FROM openjdk:17-alpine
EXPOSE 8080
ADD /target/lar-idosos-api-0.0.1-SNAPSHOT.jar lar-idosos-api.jar
ARG SPRING_DATASOURCE
ENV SPRING_DATASOURCE_ENV=$SPRING_DATASOURCE
ENTRYPOINT ["java", "-Dspring.datasource.url=${SPRING_DATASOURCE_ENV}", "-Dspring.profiles.active=prod", "-jar", "lar-idosos-api.jar"]
