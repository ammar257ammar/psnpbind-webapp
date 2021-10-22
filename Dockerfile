FROM maven:3-jdk-8-alpine as maven

COPY pom.xml . 

RUN mvn verify clean -DskipTests=true --fail-never

COPY src/ ./src/

RUN mvn package -DskipTests=true


FROM openjdk:8-jre-alpine

LABEL maintainer "Ammar Ammar <ammar257ammar@gmail.com>"

RUN apk update && apk add bash

COPY --from=maven target/psnpbind-webapp-1.0-Stable.jar /app/psnpbind-webapp.jar

ENTRYPOINT ["java","-jar","/app/psnpbind-webapp.jar"]
CMD ["-h"]
