import java.util.Scanner;

public class exercicio_06 {

    public static void main(String[] args) {

        int qtdDiaMeses[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner leitor = new Scanner(System.in);
        int dia;
        int mes;
        int diaDoAno = 0;

        System.out.print("Digite o dia: ");
        dia = leitor.nextInt();
        System.out.print("Digite o mês: ");
        mes = leitor.nextInt();

        for(int i = 0; i < mes - 1; i++){
            diaDoAno += qtdDiaMeses[i];
        }

        diaDoAno += dia;

        System.out.println("O dia " + dia + "/" + mes +
                " corresponde ao dia " + diaDoAno + " do ano!");
    }
}
