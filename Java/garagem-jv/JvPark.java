package pack.jv;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class JvPark {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o limite do estacionameno");
        int parkLimit = sc.nextInt();
        Object[][] park = new Object[parkLimit][2];
        String outLog = "";
        String option;
        do {
            System.out.println("===========================================================================");
            System.out.println("Opções");
            System.out.println("\t 1 - Adicionar número da placa");
            System.out.println("\t 0 - Sair do programa");
            System.out.println("===========================================================================");
            option = sc.next();

            switch (option){
                case "1":
                    int parkIsFull = verify(park);
                    if(parkIsFull == -1){
                        System.err.println("estacionamento cheio");
                        printMatrix(park);
                    }
                    System.out.println("Informe placa do tipo XXX0000");
                    String plate = sc.next();

                    program(plate, park, outLog);
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Informe uma opção valida");
            }
        } while (!option.equals("0"));
    }

    public static void program(String plate, Object[][] park, String outLog){
        int freeScp = verify(park);

        if (freeScp == -1) {
            printMatrix(park);
            out(park, outLog, plate);
        } else {
            enter(plate, freeScp, park);
        }

    }

    public static int verify(Object[][] something){

        for (int i = 0; i < something.length; i++) {
            String hollow = (String) something[i][0];
            if (hollow == null) {
                return i;
            }
        }
        return -1;
    }

    public static void enter(String plate, int freeSpc, Object[][]park){
        System.out.println("entrou no metodo enter");
        LocalDateTime enterTime = LocalDateTime.now();

        park[freeSpc][0] = plate;
        park[freeSpc][1] = enterTime;

        String formattedDate = enterTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.printf("\tPlaca %s \t Hora de entrada: %s %n", plate, formattedDate);
        printMatrix(park);
    }

    public static void printMatrix(Object[][]another){
        for (int i = 0; i < another.length; i++) {
            System.out.println(((String) another[i][0]) + " | " + another[i][1]);
        }
    }

    public static void out(Object[][] park, String outLog, String plate){
        System.out.println("entrou no método out");
        int posit = verifyOut(park, plate);

        if (posit != -1) {
            String carPlate = ((String) park[posit][0]);
            LocalDateTime carEnter = (LocalDateTime) park[posit][1];
            LocalDateTime carOut = LocalDateTime.now();
            long mins = Duration.between(carEnter, carOut).toMinutes();
            double total = totalPaymnt(mins);


            System.out.printf("Saída do veículo placa %s. Tempo no estacionamento %s minutos. Valor a ser cobrado: %.2f %n",
                    carPlate, mins, total);

            //String para o log de saidas
            String historic = String.format("\tPlaca %s - tempo permanência: %d minutos - valor cobrado: %.2f %n",
                    carPlate, mins, total);

            outLog += historic;
            park[posit][0] = null;
            park[posit][1] = null;

            printMatrix(park);
            System.out.println("Relatorio de Saidas: ");
            System.out.printf("%s %n", outLog);
        }
    }

    public static int verifyOut(Object[][] anything, String str) {
        for (int y = 0; y < anything.length; y++) {
            if (Objects.equals(str, anything[y][0])) {
                return y;
            }
        }
        return -1;
    }

    public static double totalPaymnt(long mins){
//      • De 0 a 5 minutos: Sem cobrança de valor;  De 5 a 60 minutos: R$ 4,00;  Acima de 60 minutos: R$ 6,00/hora adicional.

        if (mins <= 5){
            return 0.0;
        }else if (mins <= 60 ){
            return 4.0;
        }else {
            double timeValue = 4.0;
            //Divide o tempo em minutos para saber o valor em horas, ex.:125/60 = 2.08, 2.08 horas no estac.
            double hours = (mins / 60.0);
            hours--;
            hours = Math.ceil(hours);
            timeValue = timeValue + (hours * 6.0);
            return timeValue;
        }
    }
}
