# Micros Serviços

## O que são Micros Serviços?

Arquitetura de software na qual a aplicação é divididade em diversos serviços independentes.

### Principais Características

- Propósito Único: Cada microserviço deve ter uma única responsabilidade.
- Baixo Acomplamento: Os serviços tem que ser o mais independentes possível um dos outros. O deploy de cada um obrigatóriamente tem que ser independente. Banco de dados únicos para cada serviço.
- Alta Coesão: Ligado também a ideia do propósito único, o código em um micro serviço deve ser bastante coeso.

### Exemplo

Vamos analisar a arquitetura de um e-commerce implementado em uma arquitetura monolítica comparando com um implementado na arquitetura de microsserviços.

### Vantagens

- Desenvolvimento mais rápido
- Manutenção mais fácil
- Paralelização de trabalho
- Equipe especializadas
- Escalabilidade de serviços específicos
- Reutilização dos serviços
- Utilização de tecnologias diferentes

### Desvantagens

- Deploy muito mais complexo
- Debug de problemas muito mais complexo
- Desempenho pode ser pior por causa de comunicação
- Gerenciamento mais complexo
- Custos podem ser maiores
- Equipes que não conhecem a aplicação toda

## Tecnologias Relacionadas

- Conteinerização (Docker)
- Execução e Orquestração de Microsserviços (docker-compose, Kubernetes)
- Comunicação entre serviços (Assíncrona e Síncrona)
- CI/CD
- Cache
- Balanceamento de carga
- Gateway
- Circuit Breaker
