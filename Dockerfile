FROM openjdk:17
COPY ./target/web_mvc_cas-0.0.1-SNAPSHOT.jar web_mvc_cas.jar
ENTRYPOINT ["java","-jar","web_mvc_cas.jar"]
EXPOSE 8081