FROM amazoncorretto:17
MAINTAINER driptaroop
RUN mkdir /opt/app
COPY build/libs/app.jar /opt/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]