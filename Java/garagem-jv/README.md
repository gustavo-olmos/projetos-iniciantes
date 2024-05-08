# garagem-jv

<h2>sistema para controlar a entrada e saida dos veículos e controlar o valor a pagar conforme o tempo de permanência</h2>

Capacidade do estacionamento é variável e deve ser enviada na inncialização da aplicção

Para um carro entrar ou sair no estabelecimento, a sua placa deverá ser fornecida ao sistema,
caso não houver nenhuma outra entrada em aberto para aquela placa deverá ser exibida a mensagem:
>> Entrada do veículo de placa: XXX

Caso contrário deverá ser exibida a mensagem:
>> Saída do veículo de placa: XXX. Tempo no estabelecimento: X minutos. Valor a ser cobrado: XX

 O valor a ser cobrado é definido pela seguinte forma:

• De 0 a 5 minutos. Sem cobrança de valor
• De 5 a 60 minutos. R$ 4,00
• Acima de 60 minutos é cobrado um valor de R$ 6,00 por hora adicional.
    Ex.: 1 hora e 4 minutos de permanecia, deverá ser cobrado:
    4 reais da primeira hora e 6 reais dos 4 minutos que compoe a hora adicional. Total 10 reais.

Ao realizar a entrada ou saída de veículos do estabelecimento o sistema deverá
imprimir um relatório das entradas e saídas já realizadas, bem como o tempo que
cada veículo que já saiu ficou no estabelecimento.
