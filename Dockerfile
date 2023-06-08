FROM amazoncorretto:17-alpine-jdk

WORKDIR /app-fastfood

CMD ["./mvnw","clean", "install"]

# COPY target/app-fastfood-0.0.1-SNAPSHOT.jar app-fastfood-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/app-fastfood/target/app-fastfood-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
