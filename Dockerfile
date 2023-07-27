FROM openjdk:17.0.2-jdk

WORKDIR /app

COPY ./target .

CMD ["java", "-jar", "./planningroutime.api-0.0.1-SNAPSHOT.jar", "-DDB_HOST=${DB_HOST}"]
