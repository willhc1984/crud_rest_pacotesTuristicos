FROM openjdk
WORKDIR /app

COPY xtur.jar /app/xtur.jar

ENTRYPOINT ["java", "-jar", "xtur.jar"]