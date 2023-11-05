FROM amazoncorretto:17-alpine-jdk

WORKDIR /app

# Copie o arquivo JAR do diretório local para o diretório de trabalho no contêiner
COPY ./app-fastfood.jar .

CMD ["sh", "-c", "java -jar app-fastfood.jar"]