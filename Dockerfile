FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8095
ADD /target/spring-boot-jpa-jwt.jar spring-boot-jpa-jwt.jar
ENTRYPOINT ["java","-jar","spring-boot-jpa-jwt.jar"]