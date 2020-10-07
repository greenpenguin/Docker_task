FROM maven

COPY target/DevOpsSpringHelloWorld-1.0-SNAPSHOT.jar /main.jar

EXPOSE 8080
ENTRYPOINT ["java",  "-jar", "/main.jar"]
