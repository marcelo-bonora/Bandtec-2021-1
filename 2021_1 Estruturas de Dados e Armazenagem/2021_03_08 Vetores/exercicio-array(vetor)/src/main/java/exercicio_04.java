import java.util.Scanner;

public class exercicio_04 {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        int[] vet = new int[10];
        Integer count = 0;
        String result = "";

        do{
            System.out.println("Digite 10 números inteiros:");
            for(int i = 0; i < vet.length; i++){
                vet[i] = leitor.nextInt();
            }
        }while (vet.length > 10 || vet.length < 0);

        System.out.println("Digite um número qualque:");
        Integer numero = leitor.nextInt();
        for (int i = 0; i < vet.length; i++){
            if (numero == vet[i]){
                count++;
                result = String.format("O número %d ocorre %d", numero, count);
            }
            if (count == 0){
                result = String.format("O número %d não ocorre nenhuma vez", numero);
            }
        }

        System.out.println(result);
    }
}
