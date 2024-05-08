from interface.transacao import Transacao

class Sacar(Transacao):
    @property
    def valor(self):
        pass

    def registrar(self, conta):
        pass