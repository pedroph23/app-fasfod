FROM amazoncorretto:17-alpine-jdk

WORKDIR /app
RUN rm -rf /app/target/*
COPY ./app /app
ARG AMBIENTE
RUN if ["$AMBIENTE" = "DEV"]; then ./mvnw  dependency:purge-local-repository clean install
CMD ["sh", "-c", " java -jar /app/target/*.jar"]
