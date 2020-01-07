FROM hirokimatsumoto/alpine-openjdk-11

VOLUME /tmp

EXPOSE 80

COPY target/*.jar rating-service-ms.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/user-service-ms.jar"]
