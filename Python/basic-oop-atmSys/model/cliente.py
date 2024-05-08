class Cliente:
    def __init__(self, endereco):
        self._endereco = endereco
        self._contas = []

    def realizar_transacao(self, conta, transacao):
        self.conta = conta
        self.transacao = transacao

    def adicionar_conta(self, conta):
        self.conta = conta