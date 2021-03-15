import java.util.Scanner;

public class exercicio_05 {

    public static void main(String[] args) {

        Scanner modelo = new Scanner(System.in);
        Scanner valor = new Scanner(System.in);
        String[] carro = new String[5];
        Double[] consumo = new Double[5];


        System.out.println("Digite o 5 modelos de carros:");
        for (int i = 0; i < carro.length; i++){
            carro[i] = modelo.next();
        }

        System.out.println("Digite o consumo de cada carro:");
        for (int i = 0; i < consumo.length; i++){
            consumo[i] = valor.nextDouble();
        }

        Double economico = consumo[0];
        String result = String.format("O %s é o mais econômico, com %.2f de consumo", carro[0], consumo[0]);
        System.out.println("O modelo mais economico:");
        for (int i = 0; i < consumo.length; i++){
            if (consumo[i] < economico){
                result = String.format("O %s é o mais econômico, com %.2f de consumo", carro[i], consumo[i]);
            }
        }
        System.out.println(result);
    }
}
