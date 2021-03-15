import java.util.Scanner;

public class exercicio_02 {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        String[] vet = new String[10];

        for (int i = 0; i < vet.length; i++){
            System.out.println("Digite o valor de vet3[" + i + "]:");
            vet[i] = leitor.next();
        }

        System.out.println("Digite qualquer nome:");
        String nome = leitor.next();
        String result = "";
        for (int i = 0; i < vet.length; i++){
            if (vet[i].equals(nome)){
                result = "Nome encontrado no índice " + i;
                break;
            }
            else {
                result = "Nome não encontrado";
            }
        }
        System.out.println(result);
    }
}
