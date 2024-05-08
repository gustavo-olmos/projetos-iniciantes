from abc import ABC, abstractmethod
from service.mainservice import *

def menu():
    print( """
        -------- SISTEMA BANCÁRIO --------

            [1]: Cadastrar usuário
            [2]: Criar conta
            [3]: Visualizar saldo
            [4]: Depositar
            [5]: Sacar
            [6]: Visualizar extrato
            [7]: Listar usuários
            [8]: Listar contas
            [0]: Sair

        ----------------------------------
    """ )

def main():
    saldo = 0
    saque = 1
    deposito = 1
    extrato = ""
    usuarios = []
    contas = []
    numero_conta = 1

    VALOR_LIMITE_SAQUE = 500
    QTD_LIMITE_SAQUE = 3
    AGENCIA = "0001"

    menu()

    while True:
        opcao = int(input("\n=> Digite o número referente a operação em que deseja realizar: "))

        if opcao == 1:
            criar_usuario(usuarios=usuarios)
        elif opcao == 2:
            numero_conta = criar_conta(usuarios, contas, numero_conta, AGENCIA=AGENCIA)
        elif opcao == 3:
            visualizar_saldo(saldo=saldo)
        elif opcao == 4:
            saldo, extrato, deposito = depositar(saldo,extrato,deposito)
        elif opcao == 5:
            saque, saldo, extrato = sacar(saque=saque,saldo=saldo,extrato=extrato,QTD_LIMITE_SAQUE=QTD_LIMITE_SAQUE,VALOR_LIMITE_SAQUE=VALOR_LIMITE_SAQUE)
        elif opcao == 6:
            visualizar_extrato(saldo, extrato=extrato)
        elif opcao == 7:
            print(usuarios) if usuarios else print("Sem registros de usuários.")
        elif opcao == 8:
            print(contas) if contas else print("Sem registros de contas.")
        elif opcao == 0:
            print("Obrigado por utilizar nosso sistema. Volte sempre!")
            break
        else:
            print("Opção inválida.")

main()