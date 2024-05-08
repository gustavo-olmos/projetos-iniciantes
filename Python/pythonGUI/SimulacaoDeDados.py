# projetos-iniciantes-em-python
#Simular um dado de valor de aleatorio entre 1 e 6

import random
import PySimpleGUI as sg

class SimuladorDeDado:
    def __init__(self):
        self.valor_minimo = 1
        self.valor_maximo = 6
        self.mensagem = "Gostaria de gerar um novo valor para o dado?"
        self.layout = [
            [sg.Text('Jogar o Dado?')],
            [sg.Button('sim'),sg.Button('não')]
        ]
        
    def Iniciar(self):
        self.janela = sg.Window('Simulador de Dado', layout =self.layout)
        self.eventos, self.valores = self.janela.Read()
        try:
            if self.eventos == 'sim' or self.eventos == "s":
                self.GerarValorDoDado()
            elif self.eventos == "não" or self.eventos == "n":
                print('Simulação encerrada')
            else:
                print("Digitar sim ou não")
        except:
            print('Houve um erro ao receber sua resposta')
        
    def GerarValorDoDado(self):
        print(random.randint(self.valor_minimo,self.valor_maximo))

simulador = SimuladorDeDado()
simulador.Iniciar()
