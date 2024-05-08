from .cliente import Cliente

class PessoaFisica(Cliente):
    def __init__(self, cpf, nome, data_nascimento):
        self.cpf = cpf
        self.nome = nome
        self.data_nascimento = data_nascimento