FROM maven:3.6.0-jdk-11-slim AS build
COPY src /src
COPY pom.xml /
USER root
RUN --mount=type=cache,target=/.m2 mvn -f /pom.xml clean package

FROM openjdk:11
COPY --from=build /target/hastecloud.jar /usr/local/lib/hastecloud.jar
EXPOSE 8080
RUN apk add ttf-dejavu
ENTRYPOINT ["java", "-jar", "/usr/local/lib/hastecloud.jar"]