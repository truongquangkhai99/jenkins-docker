FROM openjdk:8-jdk-alpine
VOLUME /data/spring-boot-app
EXPOSE 8095
ADD /target/spring-boot-jpa-jwt.jar spring-boot-jpa-jwt.jar
ENTRYPOINT ["java","-jar","spring-boot-jpa-jwt.jar"]