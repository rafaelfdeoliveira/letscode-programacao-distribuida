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
