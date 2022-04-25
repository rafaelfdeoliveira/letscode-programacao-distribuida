## H2 no DBeaver

https://www.baeldung.com/spring-boot-h2-database

## Circuit Breaker

https://medium.com/bliblidotcom-techblog/resilience4j-circuit-breaker-implementation-on-spring-boot-9f8d195a49e0

## Testes das classes do Kafka

## Distribuição de mensagens

# Redis

Banco de dados NoSQL chave-valor, muito utilizado como cache.

Também serve para criar estrutura de dados (Lista, Fila e Pilha) que pode ser acessada por várias aplicações.

Outras funcionalidades, streaming e pub/sub.

## Instalação

https://redis.io/docs/getting-started/installation/

Usando o Docker: 

    docker run --name redis -p 6379:6379 -d redis
  
## redis-cli

Ferramenta para usar o Redis pela linha de comando, já está disponível na imagem docker.

Listar todas as chaves inseridas no Redis

    KEYS *
    
Criar uma nova chave

    SET key value
    
Mostrar o valor associado a uma chave

    GET key
    
Right PUSH em uma lista

    RPUSH mylist 2
    
Mostrar os dados de uma lista

    LRANGE mylist 0 4
    
Adicionar dados em um hash

    hset key field value
    
Mostrar dados de um hash

    hget key field 
    
Mostrar os dados de um Hash

    HGETALL key
    
Deletar uma chave
    
    DEL key

