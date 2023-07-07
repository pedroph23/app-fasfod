# Aplicação Fast Food

Seja bem vindo(a)!

## Desenvolvedores
 
 - [Caike Burgos](https://github.com/caikeburgos)
 - [Pedro Ramalho](https://github.com/pedroph23)
 - [Marcos Gomes](https://github.com/mvgv)
 - [Maria Eulina Melo](https://github.com/xLinaMeloox)
 - [Filipe Fernandes](https://github.com/LipeDev1/LipeDev1)

 
## Ferramentas

A aplicação esta recheada de ferramentas, como:
- Java 17
- Spring Boot
- Docker
- Maven
- Postgres
- Swagger
    

Para iniciarmos, precisamos de algumas ferramentas para poder incializar a aplicação.
## Ferramentas Obrigatórias
- Docker 
- Git
- Docker Compose


Para poder estar instalando essas ferramentas, siga o link de instalação.

- **Windows**
   - https://docs.docker.com/desktop/install/windows-install/ [Docker & Docker Composer]
   - https://git-scm.com/download/win [Git]
 - **Linux**
   - https://docs.docker.com/desktop/install/linux-install/ [Docker]
   - https://git-scm.com/book/pt-br/v2/Come%C3%A7ando-Instalando-o-Git [Git]
   - https://docs.docker.com/compose/install/linux/ [Docker Compose]
 - **Mac**
   - https://docs.docker.com/desktop/install/mac-install/ [Docker & Docker Composer]
   - https://git-scm.com/download/mac [Git]

Logo após de ter instalado as ferramentas, agora podemos inicializar a nossa aplicação rodando o container docker, utilizando o docker compose.

## Inicializando a aplicação com o container Docker


> ⚠️ **Atenção!**
>  Verifique se as variáveis de ambiente estão em mãos para poder inicializar corretamente a aplicação para cada ambiente. Certifique de inserir o arquivo .env dentro da **/infra/prod** !


- Build dev. :

    Esse comando compila o código java, executa o jar do monolito e gera uma imagem nova, usem quando forem testar alteracoes do codigo:

    ```sh
    docker-compose -f ./infra/dev/docker-compose.yaml up 
    ```
- Build prod. :

    Builda a imagem com o jar compilado:

    ```sh
    docker build -f ./infra/prod/Dockerfile . -t mvgv/appfastfood:LATEST
    ```
    
    
- Imagem da aplicação no Docker Hub:
    
   Publica a imagem no Docker Hub:
    ```sh
    docker build -f ./infra/prod/Dockerfile . -t mvgv/appfastfood:LATEST
    ```
    Executa o nosso projeto a partir da imagem disponibilizada no Docker Hub:
    ```sh
    docker-compose -f ./infra/prod/docker-compose.yaml up
    ```
    
## Inicializando a aplicação sem o container

Para poder estar rodando em maquina local sem o container docker e sem o Postgres, pois estará utiliza o banco H2. Deve realizar a instalação das seguintes ferramentas:

- Amazon Corretto 17 JDK
- Maven
- Lombok

#### Baixando as dependência
Comando para baixar as dependências do Maven:
```sh
mvn clean install 
```

Após o sucesso a da instalação, poderá inicializar a aplicação!
