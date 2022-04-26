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
    
Executar uma função

    db.cliente.find().forEach(x => console.log(x))

Busca de range de data

    db.cliente.find( { nascimento: { $gt: new Date('1940-01-01'), $lt: new Date('1960-01-01') } } )

