FROM openjdk:17-alpine
EXPOSE 8080
ADD /target/lar-idosos-api-0.0.1-SNAPSHOT.jar lar-idosos-api.jar
ARG SPRING_DATASOURCE
RUN echo "SPRING_DATASOURCE: ${SPRING_DATASOURCE}"
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-Dspring.datasource.url=${SPRING_DATASOURCE}", "-jar", "lar-idosos-api.jar"]
