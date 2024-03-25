# Olá!

## Requisitos:
 
Node - 20.11.1

Java -  19 Coretto

Docker

O banco de dados está embarcado no Docker

## Como rodar com Docker:

### Linux / Mac:

``make up-back``

Em outro terminal: 
``make up-front``

### Windows:

``docker compose up``

Em outro terminal:

 ``cd ng-totvs-frontend && ng serve -o``

## Como rodar na IDE

``make up-db`` -> levanta somente o Banco

Em outro terminal: 

``make up-front``
