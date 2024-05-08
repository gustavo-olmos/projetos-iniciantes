def visualizar_saldo(saldo):
    print(f"Saldo disponível: R${saldo:.2f}")

def depositar(saldo, extrato, deposito):
    valor_deposito = int(input('Qual valor (R$) deseja depositar em sua conta? Digite apenas números: '))
    extrato += f"\nDepósito {deposito}: R${valor_deposito:.2f}"
    saldo += valor_deposito
    deposito += 1
    
    print("Depósito concluído com sucesso.")
    return saldo, extrato, deposito

def sacar(saque, saldo, extrato, QTD_LIMITE_SAQUE, VALOR_LIMITE_SAQUE):
    if saque <= QTD_LIMITE_SAQUE:
        valor_saque = int(input('Qual valor (R$) deseja sacar de sua conta? Digite apenas números: '))

        if valor_saque <= saldo and valor_saque <= VALOR_LIMITE_SAQUE:
            saldo -= valor_saque
            extrato += f"\nSaque {saque}: R${valor_saque:.2f}"
            saque += 1
            print("Saque concluído com sucesso. Retire seu dinheiro na boca do caixa.")
            return saque, saldo, extrato
        elif valor_saque > saldo:
            print("Saldo insuficiente. Não foi possível realizar a operação.")
            return saque, saldo, extrato
        elif valor_saque > VALOR_LIMITE_SAQUE:
            print(f"Não foi possível realizar a operação. O valor limite para saque é {VALOR_LIMITE_SAQUE}")
            return saque, saldo, extrato
    else:
        print("Limite diário de saques atingido. Tente novamente após 24 horas.")
        return saque, saldo, extrato

def visualizar_extrato(saldo, extrato):
    print( f"""
    --------- EXTRATO ---------
        {extrato}

    ---------------------------
    Saldo da conta: R${saldo:.2f}
    ---------------------------
    """ )
    
def criar_usuario(usuarios):
    nome = input("Seu nome (completo): ")
    cpf = input("CPF (Somente números): ")
    data_nascimento = input("Data de nascimento (dd/mm/aaaa): ")
    logradouro = input("Rua: ")
    numero = input("Número: ")
    bairro = input("Bairro: ")
    cidade = input("Cidade: ")
    sigla_estado = input("Sigla do estado: ")
    endereco = f"{logradouro}, {numero} - {bairro} - {cidade}/{sigla_estado}"

    usuario = {
        "nome": nome,
        "cpf": cpf,
        "data_nascimento": data_nascimento,
        "endereco": endereco
    }

    if usuarios:
        cpf_filtrado = []
        for u in usuarios:
            cpf_filtrado.append(u["cpf"])
            
        if usuario["cpf"] not in cpf_filtrado:
            print("Checando CPF...")
            usuarios.append(usuario)
            print("CPF Disponível. Usuário cadastrado")
        else:
            print("Falha ao cadastrar. CPF indisponível!")
    else:
        print("Checando CPF...")
        print("CPF Disponível. Usuário cadastrado")
        usuarios.append(usuario)

def criar_conta(usuarios, contas, numero_conta, AGENCIA):
    cpf = input("A qual CPF você deseja atrelar sua conta? ")

    for usuario in usuarios:
        if usuario["cpf"] == cpf:
            usuario.setdefault("contas", [])
            usuario["contas"].append({"agencia": AGENCIA, "numero_conta": numero_conta})
            print("Conta criada com sucesso!")
            
            contas.append({"agencia": AGENCIA, "numero_conta": numero_conta, "cpf_usuario": cpf})
            numero_conta += 1
            break
        else:
            print("Não existe um usuário atrelado a esse CPF.")
            
    return numero_conta