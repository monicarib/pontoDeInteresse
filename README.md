# Ponto de Interesse - XY Inc.

Ponto de Interesse é uma plataforma inovadora que auxilia pessoas na localização de Pontos de Interesse (POIs). Este projeto, baseado em serviços REST, fornece toda a inteligência à plataforma.

## Tecnologia

A API RESTful foi desenvolvida com Spring Boot, utilizando os recursos do JUnit e do Mockito para testes unitários e de integração. Além disso, o banco não-relacional MongoDB foi escolhido para armazenar os dados.

## Pré-requisistos para execução do projeto
### 1. Dependências
- [Maven](https://maven.apache.org/install.html)
- [Docker](https://docs.docker.com/install/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- Java JDK

### 2. Gerar Artefato
Uma vez que as dependências acima foram instaladas, no terminal de comandos, acesse o diretório do projeto e execute o comando:
```
mvn clean install
``` 
### 3. Gerar as imagens do Docker
Ainda no mesmo diretório, execute a seguinte instrução:
```
docker-compose build
``` 

## Execução do Projeto
No diretório do projeto, execute:
```
docker-compose up -d
``` 
Com isso, a aplicação estará executando em background. A API estará acessíve em: http://localhost:8182/api/pontoDeInteresse.

## Documentação
A documetação da API foi feita utilizando [Swagger](https://swagger.io/). Para acessá-la, entre: http://localhost:8182/swagger-ui.html#/