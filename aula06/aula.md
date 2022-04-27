# MongoDB


## Comandos

Definir o banco de dados a ser utilizado:

    use cliente
    
Inserir um documento em uma coleção

    db.cliente.insertOne({
      "_id": 1,
      "nome": "Eduardo",
      "idade": 36,
      "dataNascimento": new Date(1986-01-01),
      "telefone": {
        "ddd": "16",
        "numero": "12345678"
      }
    })
    
Fazer uma busca
    
    db.cliente.find()
    
Fazer uma busca com filtro    
    
    db.cliente.find({nome: "Eduardo"})
    
Fazer uma busca em subcampo, duas formas de fazer:

    db.cliente.find({ "telefone.ddd": "16"} })

Apenas matches exatos
    
    db.cliente.find({ "telefone": { "ddd": "16", numero:'12345678'} })
    
Funções

    db.cliente.find( { idade: { $gt: 18 } } )

    db.cliente.find(
       { _id: { $in: [ 1,2,3 ] } }
    )
    

Busca de range de data

    db.cliente.find( { dataNascimento: { $gt: new Date('1940-01-01'), $lt: new Date('1990-01-01') } } )
    
Executar uma função

    db.cliente.find().forEach(x => console.log(x))



## Exercícios

Vamos criar um banco de dados com três coleções, clientes, produtos e compras. 

Os clientes devem possuir id, cpf, nome, idade, data de nascimento, telefone e endereço.

Os produtos devem possuir id, nome, codigo, descricao e preço.

As compras devem possuir id, id do cliente que fez a compra, data da compra, lista de produtos com o código e a quanttidade do produto comprada e o valor total da compra.

Vamos cadastrar pelo menos 3 objetos em cada coleção.

Vamos implementar as seguintes consultas:

- Todos os clientes que moram em São Paulo.
- Todos os clientes que tenham mais de 20 anos.
- Todos os produtos que custam mais de 1000 reais.
- Todas as compras feitas no ano de 2020.
- Todas as compras que tenham custado mais de 5000 reais.


        db.compras.insertOne({
          "_id": 1,
          "nome": "Eduardo",
          "idade": 36,
          "dataNascimento": new Date(1986-01-01),
          "produtos": [
            {
                "codigo": "1",
                "quantidade": 5
            },
                    {
                "codigo": "2",
                "quantidade": 5
            }
          ]
        })
        
        db.compras.find( { produtos: { $size: 2 } } );
        
        
        db.compras.find( { produtos: { "codigo": "1", "quantidade": 5 } } );

