# MongoDB


## Comandos

Definir o banco de dados a ser utilizado:

    use cliente
    
Inserir um documento em uma coleção

    db.cliente.insertOne({
      "teste": "teste"
    })
    
Fazer uma busca
    
    db.cliente.find()
    
Fazer uma busca com filtro    
    
    db.cliente.find({teste:'teste'})
    
Fazer uma busca em subcampo
    
    bd.cliente.find({ "_id": "oranges", "qty": { "in stock": 8, "ordered": 12 } })
    
Funções

    db.collection.find( { qty: { $gt: 4 } } )

    
Executar uma função

    db.cliente.find().forEach(x => console.log(x))

Busca de range de data

    db.cliente.find( { nascimento: { $gt: new Date('1940-01-01'), $lt: new Date('1960-01-01') } } )

