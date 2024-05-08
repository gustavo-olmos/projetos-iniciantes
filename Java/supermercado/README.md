# letscode-supermercado

descrição final -- programa:

Supermercado

FASE 1
________________________________________________________________________________________________________________________
PRODUTOS
 - O sistema deve permitir a compra/cadastro de produtos
 - Deve solicitar os seguintes dados
	Tipo
	Marca
	Identificador
	Nome
	Preco Custo
	Quantidade

`- O sistema deve verificar se o produto ja existe, se sim atualizar os dados, se não armazenar um novo produto

 - O cadastro de produto devera armazenar também os seguintes dados
	Data Compra
	Preco de venda
	Estoque

 - O preco de venda deve ser calculado a partir do preco de custo, usando o markup de cada tipo de produto

 - O estoque deve ser atualizado a cada compra.

 - Armazenar os produtos em uma matriz

 - Caractetriscas do produto:
	
	Tipo: (Enum) ALIMENTOS - markup 1.2 , BEBIDA - markup 2.3, HIGIENTE - markup 1.5
	Marca: (String)
	Identificador: (String)
	Nome: (String)
	Preco Custo: (Double)
	Quantidade: (int)
	Data Compra: (LocalDatetime)
	Preco: (Double) deve ser calculado a patir do preco de custo, markup cada tipo de produto tem o seu markup
	Estoque: (int) 

Criar um menu de acesso ao sistema 

1 - Cadastrar/Comprar produtos
2 - Imprimir estoque
3 - Listar os produto pelo Tipo

OBS: 	- Quatidade de protutos nao pode ser negativa, e os precos de custo também
		- Usar o redimensionamento...

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


FASE 2
________________________________________________________________________________________________________________________
TIPOS DE CLIENTES
 - Criar um enum para os tipos de clientes

	Tipo de Clientes: (Enum) PF, PJ, VIP
	Clientes PF: 0% desconto
		   PJ: 5% desconto
		   VIP: 15% desconto

________________________________________________________________________________________________________________________
VENDAS


- O sistema deve permitir a venda de produtos

- O sistema deve perguntar ao usuario se ele deseja inserir CPF ou não
	se sim, solicitar o CPF, se não a compra ira usar um CPF valido padrão para venda ao consumidor 000 000 001 91

- Se o CPF for digitado, o sistema deve pedir o tipo de cliente.

- O sistema deve solicitar os codigos dos produtos comprados e suas quantidades
	O sistema deve continuar solicitando os produtos e suas quantidades até que a palavra FIM seja digitada no lugar do codigo do produto

- ao final o sistema devera mostrar um resumo com os produtos comprados
	Codigo | Nome | Quantidade | Preco | ValorPagar

apos a exibiçao do resumo, mostrar o valor total a pagar Armazenar a venda em uma matriz mostrar e uma opçao para voltar ao menu principal

Vendas
	CPF Cliente
	Tipo Cliente
	Quantidade de produtos
	Valor total Pago


OBS, 	se um prodtuto informado não existir, mostra msg de produto invalido
	se a quantidade um produto não tiver estoque, mostrar a msg sem estoque suficiente e mostrar o estoque do produto
	
	Ao terminar de inseir os produtos, o sistema deve baixar o estoque de cada produto vendido no cadastro
	Deve ser aplicado o desconto no total do valor a pagar de acordo com o desconto de cada tipo de cliente


1 - Cadastrar/Comprar produtos
2 - Imprimir estoque
3 - Listar os produtos Por Tipo
4 - Pesquisar um produto pelo codigo
5 - Pesquisar um produto pelo nome usando like
6 - Vendas
7 - Relatorio de vendas analitico, todas as vendas
	CPF | Tipo Cliente | Quantidade de Produtos | Valor Pago
8 - Relatorios de vendas sintetico, consolidado por CPF
	CPF | Quantidade de Produtos | Valor Pago
