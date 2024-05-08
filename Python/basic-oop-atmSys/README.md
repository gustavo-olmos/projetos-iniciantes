1° ETAPA

    OBJETIVO GERAL:

        - Criar um sistema bancário com as operações: sacar, depositar e visualizar extrato

    DESAFIO:

        - Fomos contratados por um grande banco para desenvolver o seu novo sistema. Esse banco deseja modernizar
        suas operações e para isso escolheu a linguagem Python. Para a primeira versão do sistema devemos implementar 
        apenas 3 operações: depósito, saque e extrato.
        
    OPERAÇÃO DE SAQUE: 

        - O sistema deve permitir realizar 3 saques diários com limite máximo de R$ 500,00 por saque. Caso o usuário
        não tenha saldo em conta, o sistema deve exibir uma mensagem informando que não será possível sacar o dinheiro
        por falta de saldo. Todos os saques devem ser armazenados em uma variável e exibidos na operação de extrato.

    OPERAÇÃO DE DEPÓSITO:

        - Deve ser possível depositar valores positivos para a minha conta bancária. A v1 do projeto trabalha apenas
        com 1 usuário, dessa forma não precisamos nos preocupar em identificar qual é o número da agência e conta 
        bancária. Todos os depósitos devem ser armazenados em uma variável e exibidos na operação de extrato.

    OPERAÇÃO DE EXTRATO:

        - Essa operação deve listar todos os depósitos e saques realizados na conta. No fim da listagem, deve ser exibido
        o saldo atual da conta. 

        - Os valores devem ser exibidos utilizando o formato R$ XXX.XX, exemplo: R$ 1500.45

2° ETAPA 

    OBJETIVO GERAL:

        - Separar as funções existentes de saque, depósito e extrato em funções. Criar duas novas funções: cadastrar usuário
        (cliente) e cadastrar conta bancária

    DESAFIO:

        - Precisamos deixar nosso código mais modularizado, para isso vamos criar funções para as operações existentes: sacar,
        depositar e visualizar extrato. Além disso, para a versão 2 do nosso sistema precisamos criar duas novas funções: criar
        usuário (cliente do banco) e criar conta corrente (vincular com usuário).

    SEPARAÇÃO EM FUNÇÕES:

        - Devemos criar funções para todas as operações do sistema. Para exercitar tudo o que aprendemos neste módulo, cada fun-
        ção vai ter uma regra na passagem de argumentos. O retorno e a forma como serão chamadas, pode ser definida por você da
        forma que achar melhor

        SAQUE:

            - Argumentos: apenas por nome (keyword)

        DEPÓSITO:

            - Argumentos: apenas por posição (positional)
        
        EXTRATO:

            - Argumentos: por posição e nome (positional, keyword)

    NOVAS FUNÇÕES:

        - Precisamos criar duas novas funções: criar usuário e criar conta corrente. Fique a vontade para adicionar mais funções, 
        exemplo: listar contas

        CRIAR USUÁRIO (CLIENTE):
            
            - O programa deve armazenar os usuários em uma lista, um usuário é composto por: nome, data de nascimento, cpf e ende-
            reço. O endereço é uma string com o formato: logradouro, n° - bairro - cidade/sigla estado. Deve ser armazenado somente
            os números do CPF. Não podemos cadastras 2 usuários com o mesmo CPF.

        CRIAR CONTA CORRENTE:

            - O programa deve armazenar contas em uma lista, uma conta é composta por: agência, número da conta e usuário. O número
            da conta é sequencial, iniciando em 1. O número da agência é fixo: "0001". O usuário pode ter mais de uma conta, mas uma
            conta pertence a somente um usuário.

        DICA: 

            - Para vincular um usuário a uma conta, filtre a lista de usuários buscando o número do CPF informado para cada usuário
            da lista.

3° ETAPA

    OBJETIVO GERAL:
        
        - Iniciar a modelagem do sistema bancária em POO. Adicionar classes para cliente e as operações bancárias: depósito e saque

    DESAFIO:

        - Atualizar a implementação do sistema bancário, para armazenar os dados de clientes e contas bancárias em objetos ao invés
        de dicionários. O código deve seguir o modelo de classes UML abordado em aula.

    DESAFIO EXTRA:

        - Após concluir a modelagem das classes e a criação dos métodos. Atualizar os métodos que tratam as opções do menu, para
        funcionarem com as classes modeladas.