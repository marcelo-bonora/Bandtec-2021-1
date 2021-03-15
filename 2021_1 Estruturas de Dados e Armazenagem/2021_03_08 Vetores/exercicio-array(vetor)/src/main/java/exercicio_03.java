import java.util.Scanner;

public class exercicio_03 {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        int[] vet = new int[10];
        Integer soma = 0;
        Double media = 0.0;

        for (int i = 0; i < vet.length; i++){
            System.out.println("Digite um número:");
            vet[i] = leitor.nextInt();
            soma += vet[i];
            media = soma / Double.parseDouble(String.valueOf(vet.length));
        }

        System.out.println("Números que estão acima da média:");
        for (int i = 0; i < vet.length; i++){
            if (vet[i] > media){
                System.out.println(vet[i]);
            }
        }
    }
}
