from tkinter import *
from tkinter import filedialog
import pyshorteners

class Encurtador:
    def shorten(self):
        if self.shorty.get():
            self.shorty.delete(0, END)
        
        if self.entry.get():
            #converte para tinyurl.com
            self.url = pyshorteners.Shortener().tinyurl.short(self.entry.get())
            #output GUI
            self.shorty.insert(END, self.url)


    def tkshort(self):
        self.window = Tk()
        self.window.title("Encurtador de link")
        self.window.geometry('520x500')

        self.label = Label(self.window, text='Link:', font=('Arial', 34))
        self.label.pack(pady=20)

        self.entry = Entry(self.window, font=('Arial', 22))
        self.entry.pack(pady=20)
        
        self.link_button = Button(self.window, text= 'Encurtar', command=self.shorten, font=('Arial', 24))
        self.link_button.pack(pady=20)

        self.curto = Label(self.window, text='Link encurtado:', font=('Arial', 14))
        self.curto.pack(pady=40)

        self.shorty = Entry(self.window, font=('Arial', 22), justify=CENTER, width= 30)
        self.shorty.pack(pady=10)
         

        self.window.mainloop()


simulador = Encurtador()
simulador.tkshort()