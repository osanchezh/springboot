FROM openjdk:18-oracle
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} user-service.jar
COPY target/user-service.jar-0.0.1 app.jar
#ENTRYPOINT ["java","-jar","/user-service.jar"]
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#EXPOSE 9003