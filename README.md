Produtos Microsservice
Microserviço responsável pela gestão produtos.

Para rodar este projeto é necessário ter o Docker instalado na máquina e ele precisa estar rodando 

A porta 5432 precisa estar livre para a configuração do banco 
A porta 8080 precisa estar livre para o sistema back-end 

O projeto utiliza uma biblioteca docker-compose onde só é necessário executar o projeto que ele irá criar o container para a execução do projeto

dentro do postman é possível executar as seguintes rotas

Inserir produto
Rota do tipo POST: localhost:8080/api/produtos

Body da requisição:
{
    "nomeProduto": "NOME DO PRODUTO",
    "descricaoProduto" : "DESCRIÇÃO DO PRODUTO ",
    "precoProduto" : 70, //PREÇO
    "ativo": true //STATUS DO PRODUTO
}

Ler todos os produtos 
Rota do tipo GET: localhost:8080/api/produtos

Retornar produto por ID
Rota do tipo GET: localhost:8080/api/produtos/{idProduto}

Atualizar Produto 
Rota do tipo PUT: localhost:8080/api/produtos?idProduto={idProduto}


Body da requisição:
{
    "nomeProduto": "NOME DO PRODUTO",
    "descricaoProduto" : "DESCRIÇÃO DO PRODUTO ",
    "precoProduto" : 70, //PREÇO
    "ativo": true //STATUS DO PRODUTO
}

Rota do tipo DELETE: localhost:8080/api/produtos?idProduto={idProduto}
