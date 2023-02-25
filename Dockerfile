#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM eclipse-temurin:17-jdk-focal
COPY --from=build /home/app/target/backend-0.0.1-SNAPSHOT.jar /usr/local/lib/backend-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/backend-0.0.1-SNAPSHOT.jar"]
