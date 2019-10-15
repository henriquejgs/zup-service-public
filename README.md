# zup-service

Permissão dois níveis BasicAuth
USER >> GET POST
SUPERUSER >> GET, POST, PUT, DELETE
USER > usuário: zupUser, senha: zupuser
SUPERUSER > usuário: zupAdmin, senha: zupadmin

localhost:9092/clients ou /{id}
localhost:9092/address ou /{id}

Para importar a  aplicação no Intellij você precisará de um pluggin do lombok, https://projectlombok.org/

Para carregar a imagem do postgres execute o docker-compose up

JSON for insert
{"name":"Denise","cpf":"001.100.001-11","birthDay":"1895-12-25","address":{"street":"Rua","zipCode":"13025-400","region":"MG","country":"EUA"}}


JSON for update
{"id": <PUT ID HERE >,"name":"Mariana","cpf":"001.100.001-12","birthDay":"1895-12-25","address":{"street":"Rua","zipCode":"13025-400","region":"MG","country":"Malasia"}}






