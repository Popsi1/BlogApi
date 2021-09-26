# define base docker image
FROM openjdk:11
LABEL maintainer="javaguides.net"
ADD target/Blogger-0.0.1-SNAPSHOT.jar blogger.jar
ENTRYPOINT ["java", "-jar", "blogger.jar"]