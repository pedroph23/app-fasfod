FROM amazoncorretto:17-alpine-jdk

WORKDIR /app
RUN rm -rf /app/target/*
COPY ./app /app
ARG AMBIENTE
RUN if [ "$AMBIENTE" = "DEV" ]; then /bin/sh ./mvnw dependency:purge-local-repository clean install; fi
RUN mv /app/target/*.jar /app/app-fastfood.jar
CMD ["sh", "-c", " java -jar /app/app-fastfood.jar"]
