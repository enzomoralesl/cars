# tokio
Teste Spring Boot

## Using h2 database with JPA

post(/topicos) json de teste
{
    "titulo":"Dúvida Postman2",
        "mensagem":"Como fazer um Post",
        "nomeUser":"Enzo Morales"
}

get(/topicos)

resultado: todos os topicos com seus respectivos usuários

resultado usando "?titulo=titulo a ser pesquisado": apenas o titulo achado no banco



script sql para criar dados de user e topicos já estão pre configurados pro h2 subir com eles, facilitando o teste das APIs
