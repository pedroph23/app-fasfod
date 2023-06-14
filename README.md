# app-fastfood
BUILD DE DEV: 
docker-compose -f ./infra/docker-dev-compose.yaml --env-file ./infra/dev.env up --build
Esse comando compila o código java, executa o jar do monolito e gera uma imagem nova, usem quando forem testar alteracoes do codigo
Mantenham a pratica de alterar a versao da imagem no arquivo dev.env

BUILD DE PROD:
docker-compose -f ./infra/docker-prod-compose.yaml --env-file ./infra/prod.env up
Esse comando apenas executa o jar do monolito previamente gerado em uma imagem.
