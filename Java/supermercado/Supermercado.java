package vendinha;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Supermercado {
    private static int linhas = 1;
    private static int colunas = 9;
    private static int linhasRelatorioAnalitico = 1;
    private static int linhasRelatorioSintetico = 1;
    private static int addAnalitico = 0;
    private static int addSintetico = 0;
    private static Object[][] productInfo = new Object[linhas][colunas];
    private static Object[][] carrinho = new Object[1][5];
    private static Object[][] relatorioAnalitico = new Object[linhasRelatorioAnalitico][4];
    private static Object[][] relatorioSintetico = new Object[linhasRelatorioSintetico][4];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index;
        do {
            index = menu(sc);
            switch (index) {
                case 1:
                    cadastrarComprar(sc);
                    break;
                case 2:
                    for (int i = 0; i < productInfo.length; i++) {
                        imprimir(i);
                    }
                    break;
                case 3:
                    listar(sc);
                    break;
                case 4:
                    pesquisarCodigo(sc);
                    break;
                case 5:
                    pesquisarNome(sc);
                    break;
                case 6:
                    vendas(sc);
                    break;
                case 7:
                    imprimirRelatorioAnalitico();
                    break;
                case 8:
                    imprimirRelatorioSintetico();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Valor digitado incorretamente");
            }
        } while (index != 0);
    }

    public static int menu(Scanner sc) {

        do {
            System.out.println("----------------------------------------");
            System.out.println("1 - Cadastrar/Comprar produto: ");
            System.out.println("2 - Imprimir Estoque ");
            System.out.println("3 - Listar os produtos pelo tipo ");
            System.out.println("4 - Pesquisar um produto pelo código ");
            System.out.println("5 - Pesquisar um produto pelo nome usando like ");
            System.out.println("6 - Vendas ");
            System.out.println("7 - Relatório de vendas analítico, todas as vendas ");
            System.out.println("8 - Relatório de vendas sintético, consolidado por CPF ");
            System.out.println("0 - Sair");
            System.out.println("----------------------------------------");

            int validacao = sc.nextInt();
            String aux = sc.nextLine();

            if (validacao >= 0 && validacao <= 8) {
                return validacao;
            } else {
                System.out.println("Digite as opções corretamente");
            }
        } while (true);
    }

    public static void verificaMatriz() {

        Object[][] newMatriz = new Object[productInfo.length + 1][colunas];
        for (int k = 0; k < productInfo.length; k++) {
            for (int j = 0; j < colunas; j++) {
                newMatriz[k][j] = productInfo[k][j];
            }
        }
        productInfo = newMatriz;
    }

    public static void cadastrarComprar(Scanner sc) {

        System.out.println("Digite o identificador: ");
        String identifier = sc.nextLine();
        for (int i = 0; i < productInfo.length; i++) {
            if (identifier.equals(productInfo[i][0])) {
                comprar(sc, i);
                break;
            }
            if (productInfo[i][0] == null) {
                cadastrar(sc, identifier, i);
                break;
            }
        }
    }

    public static void comprar(Scanner sc, int i) {

        do {
            System.out.println("Custo: ");
            try {
                productInfo[i][4] = sc.nextDouble();
            } catch (InputMismatchException ignored) {
                productInfo[i][4] = 0.0;
            }
            sc.nextLine();

        } while (((Double) productInfo[i][4]) <= 0);

        do {
            System.out.println("Quantidade:");
            try {
                int add = sc.nextInt();

                int addAux = (int) productInfo[i][5];
                productInfo[i][5] = add + addAux;

            } catch (InputMismatchException ignored) {
                productInfo[i][5] = 0;
            }

            sc.nextLine();

        } while (((int) productInfo[i][5]) <= 0);

        do {
            System.out.println("Nome: ");
            productInfo[i][3] = sc.nextLine();

        } while (productInfo[i][3] == null);

        Tipo tipoProduto = (Tipo) productInfo[i][1];

        double precoCusto = (double) productInfo[i][4];

        productInfo[i][6] = Tipo.calcularVenda(tipoProduto, precoCusto);

        productInfo[i][7] = LocalDateTime.now();

        productInfo[i][8] = productInfo[i][5];

    }

    public static void cadastrar(Scanner sc, String identifier, int i) {

        verificaMatriz();

        productInfo[i][0] = identifier;

        do {
            System.out.println("Tipo do produto: 1 - Alimento, 2 - Higiene, 3 Bebida.");

            try {

                int tipo = sc.nextInt();

                if (tipo == 1) {
                    productInfo[i][1] = Tipo.ALIMENTO;
                } else if (tipo == 2) {
                    productInfo[i][1] = Tipo.HIGIENE;
                } else if (tipo == 3) {
                    productInfo[i][1] = Tipo.BEBIDA;
                }
            } catch (InputMismatchException ignored) {

            }
            sc.nextLine();

        } while ((productInfo[i][1]) == null);

        do {
            System.out.println("Marca:");

            productInfo[i][2] = sc.nextLine();

        } while (productInfo[i][2] == null);

        do {
            System.out.println("Nome: ");
            productInfo[i][3] = sc.nextLine();

        } while (productInfo[i][3] == null);

        do {
            System.out.println("Custo: ");
            try {
                productInfo[i][4] = sc.nextDouble();
            } catch (InputMismatchException ignored) {
                productInfo[i][4] = 0.0;
            }
            sc.nextLine();

        } while (((Double) productInfo[i][4]) <= 0);

        do {
            System.out.println("Quantidade:");
            try {
                productInfo[i][5] = sc.nextInt();

            } catch (InputMismatchException ignored) {
                productInfo[i][5] = 0;
            }
            sc.nextLine();

        } while (((int) productInfo[i][5]) <= 0);

        //
        Tipo tipoProduto = (Tipo) productInfo[i][1];

        double precoCusto = (double) productInfo[i][4];

        productInfo[i][6] = Tipo.calcularVenda(tipoProduto, precoCusto);

        productInfo[i][7] = LocalDateTime.now();

        productInfo[i][8] = productInfo[i][5];

    }

    public static void imprimir(int i) {

        if (productInfo[i][0] == null) {
            return;

        } else {

            LocalDateTime dataHoraEntrada = (LocalDateTime) productInfo[i][7];
            String dataFormatada = dataHoraEntrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            System.out.println("Identificador: " + productInfo[i][0]);
            System.out.println("Tipo: " + productInfo[i][1]);
            System.out.println("Marca: " + productInfo[i][2]);
            System.out.println("Nome: " + productInfo[i][3]);
            System.out.println("Custo: " + productInfo[i][4]);
            System.out.println("Quantidade: " + productInfo[i][5]);
            System.out.println("Preço de venda: " + productInfo[i][6]);
            System.out.println("Data de compra: " + dataFormatada);
            System.out.println("Estoque: " + productInfo[i][8]);

        }

    }
    public static void listar(Scanner sc) {

        Tipo valida = null;

        do {
            System.out.println("Qual o tipo do produto (1 - Alimento, 2 - Higiene, 3 Bebida)? ");

            String tipo = sc.nextLine();

            if (tipo.equals("1")) {

                valida = Tipo.ALIMENTO;

            } else if (tipo.equals("2")) {

                valida = Tipo.HIGIENE;

            } else if (tipo.equals("3")) {

                valida = Tipo.BEBIDA;
            }

        } while (valida == null);

        for (int i = 0; i < productInfo.length; i++) {
            if (productInfo[i][1] == valida) {

                imprimir(i);
            }

        }

    }

    public static void pesquisarCodigo(Scanner sc) {

        do {
            System.out.println("Digite o código do produto pesquisado: ");

            try {
                String codigo = sc.nextLine();


                for (int i = 0; i < productInfo.length; i++) {

                    if (productInfo[i][0].equals(codigo)) {
                        imprimir(i);

                        return;
                    }

                }

                //}
            } catch (NullPointerException ignored) {
                System.out.println("O código digitado não foi encontrado");
            }


        } while (true);

    }

    public static void pesquisarNome(Scanner sc) {
        String codigo;

        do {
            System.out.println("Digite o nome do produto pesquisado: ");
            codigo = sc.nextLine();

            if (codigo.length() >= 3) {
                codigo.toLowerCase();

                for (int i = 0; i < productInfo.length; i++) {
                    if (productInfo[i][0] == null) {
                        System.out.println("Palavra não encontrada");
                        return;
                    }
                    String comp = ((String) productInfo[i][3]);
                    if (comp.contains(codigo)) {
                        imprimir(i);
                        return;
                    }
                }
                System.out.println("Palavra não encontrada");
            } else {
                System.out.println("Por favor, digite uma palavra com pelo menos 3 caracteres");
            }
        } while (true);
    }

    public static void vendas(Scanner sc) {

        String cpf;
        String adiciona;
        String cod;
        TipoCliente tipoCliente = TipoCliente.PF;
        String cliente = "";
        int quantidade;
        int pos = 0;

        do {

            System.out.println("Deseja adicionar o CPF na sua compra?");
            System.out.println("Digite S para sim e N para não: ");
            adiciona = sc.nextLine();

        } while (adiciona.equalsIgnoreCase("S") && adiciona.equalsIgnoreCase("N"));

        boolean valida = false;

        do {
            if (adiciona.equalsIgnoreCase("S")) {
                System.out.println("Digite seu CPF sem pontos e sem traço");
                cpf = sc.nextLine();
                valida = validaCpf(cpf);
            } else {
                cpf = "00000000191";
                valida = validaCpf(cpf);
            }
        } while (!valida);

        valida = false;

        do {
            if (cpf.equals("00000000191")) {
                tipoCliente = TipoCliente.PF;
                valida = true;
            } else {
                System.out.println("Por favor, digite o tipo de cliente");
                cliente = sc.nextLine();
                if (cliente.equalsIgnoreCase("PJ")) {
                    tipoCliente = TipoCliente.PJ;
                    valida = true;
                } else if (cliente.equalsIgnoreCase("VIP")) {
                    tipoCliente = TipoCliente.VIP;
                    valida = true;
                } else if (cliente.equalsIgnoreCase("PF")) {
                    tipoCliente = TipoCliente.PF;
                    valida = true;
                } else {
                    System.out.println("Tipo de cliente inválido");
                }
            }
        } while (!valida);

        valida = false;
        int posCarrinho = 0;

        do {
            do {
                System.out.println("Digite o código do produto que deseja comprar: ");
                cod = sc.nextLine();

                for (int i = 0; i < productInfo.length; i++) {

                    if (productInfo[i][0] == null) {
                        System.out.println("Produto não encontrado no sistema");
                        break;
                    }

                    if (((String) productInfo[i][0]).equalsIgnoreCase(cod)) {
                        pos = i;
                        valida = true;
                        break;

                    }
                }

            } while (!valida);

            valida = false;

            do {

                System.out.println("Digite a quantidade que deseja comprar: ");
                try {
                    quantidade = sc.nextInt();
                    String aux = sc.nextLine();

                    if (quantidade <= 0) {
                        System.out.println("Digite uma quantidade maior do que zero");
                    } else if (((int) productInfo[pos][5]) >= quantidade) {
                        productInfo[pos][5] = ((int) productInfo[pos][5]) - quantidade;


                        carrinho[posCarrinho][0] = productInfo[pos][0];
                        carrinho[posCarrinho][1] = productInfo[pos][3];
                        carrinho[posCarrinho][2] = quantidade;
                        carrinho[posCarrinho][3] = productInfo[pos][4];
                        carrinho[posCarrinho][4] = arredondar(TipoCliente.calcularDesconto(tipoCliente, (((double) productInfo[pos][6]) * quantidade)));
                        System.out.println(carrinho[posCarrinho][4]);

                        valida = true;


                    } else {
                        System.out.println("Não temos essa quantidade no estoque");
                        System.out.println("O estoque atual é :" + productInfo[pos][5]);
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Digite um número");
                }

            } while (!valida);

            System.out.println("n = sair, s = continuar comprando");
            String resposta = sc.nextLine();

            if (resposta.equalsIgnoreCase("n")) {
                break;
            }
            verificaMatrizCarrinho();
            posCarrinho += 1;

        }while(true);

        double valorTotal = 0.0;
        int quantidadeTotal = 0;

        for (int i = 0; i < carrinho.length; i++) {
            if (carrinho[i][0] != null){
                imprimirCarrinho(i);
            }

            valorTotal = valorTotal + ((double) carrinho[i][4]);
            quantidadeTotal = quantidadeTotal + ((int) carrinho[i][2]);
        }
        System.out.println("Valor Total:" + valorTotal);
        System.out.println();

        preencherRelatorioAnalitico(cpf, tipoCliente, quantidadeTotal, valorTotal);

        preencherRelatorioSintetico(cpf, quantidadeTotal, valorTotal);
        zerarCarrinho();
    }

    public static boolean validaCpf(String cpf) {

        boolean valida;
        char[] cpfArray;
        cpfArray = cpf.toCharArray();

        valida = validaIsString(cpfArray);
        if (!valida) {
            System.out.println("Por favor, digite apenas números");
            return false;
        } else if (cpfArray.length != 11) {
            System.out.println("CPF com quantidade de dígitos errada");
            return false;
        }

        valida = calculoCPF(cpfArray);

        if (!valida) {
            System.out.println("CPF inválido");
            return false;
        }
        return true;



    }

    public static boolean calculoCPF(char[] cpfArray) {


        int[] cpfNum = new int[cpfArray.length];

        for (int i = 0; i < cpfArray.length; i++) {
            cpfNum[i] = Integer.parseInt(String.valueOf(cpfArray[i]));
        }

        int soma = 0;
        int primeiroDigito;
        int segundoDigito;

        soma = soma + (cpfNum[0] * 10);
        soma = soma + (cpfNum[1] * 9);
        soma = soma + (cpfNum[2] * 8);
        soma = soma + (cpfNum[3] * 7);
        soma = soma + (cpfNum[4] * 6);
        soma = soma + (cpfNum[5] * 5);
        soma = soma + (cpfNum[6] * 4);
        soma = soma + (cpfNum[7] * 3);
        soma = soma + (cpfNum[8] * 2);

        primeiroDigito = (soma * 10) % 11;

        if (primeiroDigito == 10) {
            primeiroDigito = 0;
        }

        if (primeiroDigito != cpfNum[9]) {
            return false;
        }

        soma = 0;

        soma = soma + (cpfNum[0] * 11);
        soma = soma + (cpfNum[1] * 10);
        soma = soma + (cpfNum[2] * 9);
        soma = soma + (cpfNum[3] * 8);
        soma = soma + (cpfNum[4] * 7);
        soma = soma + (cpfNum[5] * 6);
        soma = soma + (cpfNum[6] * 5);
        soma = soma + (cpfNum[7] * 4);
        soma = soma + (cpfNum[8] * 3);
        soma = soma + (cpfNum[9] * 2);

        segundoDigito = (soma * 10) % 11;

        if (segundoDigito == 10) {
            segundoDigito = 0;
        }

        if (segundoDigito != cpfNum[10]) {
            return false;
        }

        return true;
    }

    public static boolean validaIsString(char[] cpfArray) {

        for (int i = 0; i < cpfArray.length; i++) {
            if (cpfArray[i] == '0' || cpfArray[i] == '1' || cpfArray[i] == '2' || cpfArray[i] == '3' ||
                    cpfArray[i] == '4' || cpfArray[i] == '5' || cpfArray[i] == '6' || cpfArray[i] == '7' ||
                    cpfArray[i] == '8' || cpfArray[i] == '9') {

            } else {
                return false;
            }
        }
        return true;
    }

    public static void verificaMatrizCarrinho() {

        Object[][] newMatriz = new Object[carrinho.length + 1][5];
        for (int k = 0; k < carrinho.length; k++) {
            for (int j = 0; j < carrinho[k].length; j++) {
                newMatriz[k][j] = carrinho[k][j];
            }
        }
        carrinho = newMatriz;
    }

    public static void imprimirCarrinho(int i) {

        System.out.println("----------------------------------------");

        System.out.println("Produto " + (i+1) + ": ");
        System.out.println("Código: " + carrinho[i][0]);
        System.out.println("Nome: " + carrinho[i][1]);
        System.out.println("Quantidade: " + carrinho[i][2]);
        System.out.println("Preço: " + carrinho[i][3]);
        System.out.printf("Valor a Pagar: %.2f", ((double) carrinho[i][4]));
        System.out.println();
        System.out.println("----------------------------------------");
    }

    private static double arredondar(double num) {
        return Math.round(num * 100.0)/100.0;
    }

    public static void verificaMatrizRelatorioAnalitico() {

        Object[][] newMatriz = new Object[relatorioAnalitico.length + 1][4];
        for (int k = 0; k < relatorioAnalitico.length; k++) {
            for (int j = 0; j < relatorioAnalitico[k].length; j++) {
                newMatriz[k][j] = relatorioAnalitico[k][j];
            }
        }
        relatorioAnalitico = newMatriz;
    }

    public static void verificaMatrizRelatorioSintetico() {

        Object[][] newMatriz = new Object[relatorioSintetico.length + 1][4];
        for (int k = 0; k < relatorioSintetico.length; k++) {
            for (int j = 0; j < relatorioSintetico[k].length; j++) {
                newMatriz[k][j] = relatorioSintetico[k][j];
            }
        }
        relatorioSintetico = newMatriz;
    }

    public static void preencherRelatorioAnalitico(String cpf, TipoCliente tipoCliente, int quantidade, double valorTotal){

        relatorioAnalitico[addAnalitico][0] = cpf;
        relatorioAnalitico[addAnalitico][1] = tipoCliente;
        relatorioAnalitico[addAnalitico][2] = quantidade;
        relatorioAnalitico[addAnalitico][3] = valorTotal;

        addAnalitico += 1;
        verificaMatrizRelatorioAnalitico();

    }

    public static void preencherRelatorioSintetico(String cpf, int quantidade, double valorTotal){


        for (int i = 0; i < relatorioSintetico.length; i++) {
            if(cpf.equals(((String) relatorioSintetico[i][0]))){
                relatorioSintetico[i][1] = quantidade + ((int) relatorioSintetico[i][1]);
                relatorioSintetico[i][2] = valorTotal + ((double) relatorioSintetico[i][2]);
                return;
            }
        }

        relatorioSintetico[addSintetico][0] = cpf;
        relatorioSintetico[addSintetico][1] = quantidade;
        relatorioSintetico[addSintetico][2] = valorTotal;

        addSintetico += 1;

        verificaMatrizRelatorioSintetico();
    }

    public static void imprimirRelatorioAnalitico() {

        for (int i = 0; i < relatorioAnalitico.length; i++) {
            if (relatorioAnalitico[i][0] == null) {
                System.out.println("---Fim do Relatório---");
                return;
            }
            System.out.printf("%s | %s | %d |  %.2f |", relatorioAnalitico[i][0], relatorioAnalitico[i][1], relatorioAnalitico[i][2], relatorioAnalitico[i][3]);
            System.out.println();
        }
    }
    public static void imprimirRelatorioSintetico() {

        for (int i = 0; i < relatorioSintetico.length; i++) {
            if (relatorioSintetico[i][0] == null) {
                System.out.println("---Fim do Relatório---");
                return;
            }
            System.out.println(relatorioSintetico[i][0] +" | "+ relatorioSintetico[i][1] +" | "+ relatorioSintetico[i][2]);
        }
    }
    public static void zerarCarrinho() {

        Object[][] newMatriz = new Object[1][5];
        carrinho = newMatriz;
    }
}
