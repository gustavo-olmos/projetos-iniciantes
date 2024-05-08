from abc import ABC, abstractmethod

class Transacao(ABC):
    @abstractmethod
    @property
    def valor(self):
        pass

    def registrar(self, conta):
        pass