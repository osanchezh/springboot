FROM openjdk:18-oracle
ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} deparment-service.jar 
COPY target/deparment-service-0.0.1.jar app.jar
#ENTRYPOINT ["java","-jar","/deparment-service.jar"]

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#EXPOSE 9002