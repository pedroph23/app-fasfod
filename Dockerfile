FROM amazoncorretto:17-alpine-jdk

WORKDIR /app-fastfood
RUN rm -rf /app-fastfood/target/*
COPY ./app-fastfood /app-fastfood
RUN ./mvnw  dependency:purge-local-repository clean install
CMD ["sh", "-c", " java -jar /app-fastfood/target/*.jar"]
