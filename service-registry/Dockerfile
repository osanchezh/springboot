FROM openjdk:18-oracle
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} service-registry.jar
#ENTRYPOINT ["java","-jar","/service-registry.jar"]
COPY target/service-registry-0.0.1.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#EXPOSE 8761