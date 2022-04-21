## Projeto

O projeto do módulo de programação distribuída será a utilização do Kafka no projeto desenvolvido no módulo anterior. 

(https://github.com/ezambomsantana/letscode-banco-de-dados/blob/main/projeto.md)

A alteração deve ser feita no rota POST /compra, essa rota deve apenas receber o produto e o colocar em uma fila Kafka. Outra aplicação deve receber 
a mensagem do Kafka e fazer as validações da compra. 

Os dados da compra podem ser salvos no banco de dados tanto na rota /compra quanto no serviço que faz a validação das rotas, porém a rota GET /compra deve 
continuar funcionando normalmente.
