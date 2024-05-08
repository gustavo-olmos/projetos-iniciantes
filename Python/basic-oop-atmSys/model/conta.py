from .historico import Historico


class Conta:
    def __init__(self, saldo, numero, agencia, cliente, historico):
        self.saldo = 0.00
        self.numero = 1
        self.agencia = "0001"
        self.cliente = cliente
        self.historico = Historico()

    @property
    def saldo(self, valor):
        return self._valor
    
    @property
    def nova_conta(self, cliente, numero):
        return 
    
    @property
    def sacar(self, valor):
        return 
    
    @property
    def depositar(self, valor):
        return 