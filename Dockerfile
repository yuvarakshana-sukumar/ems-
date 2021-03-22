FROM openjdk:8
EXPOSE 8085
ADD Api/target/Api-0.0.1-SNAPSHOT.jar Api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Api-0.0.1-SNAPSHOT.jar"]