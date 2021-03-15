import java.util.Scanner;

public class ExemploVetor {

    public static void exibeVetor(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.println("v[" + i + "]= " + v[i]);
        }
    }


    public static void main(String[] args) {

        // Declaração do objeto leitor
        Scanner leitor = new Scanner(System.in);

        // Declaração do 1o vetor vet1
        // Esse vetor será do tipo int e terá tamanho 10
        int[] vet1 = new int[10];

        // Declaração do 2o vetor vet2
        // Esse vetor será inicializado no momento da sua criação
        int[] vet2 = { 100, 200, 300, 400, 500 };

        // Declaração do 3o vetor vet3
        // Esse vetor será do tipo String e terá tamanho 4
        String[] vet3 = new String[4];

        // Declaração do 4o vetor diaDaSemana
        // Esse vetor será do tipo String e será inicializado com os dias da semana
        String[] diaDaSemana = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta",
                                "Sexta", "Sábado"};

        // Declaração do 5o vetor vet5
        // Esse vetor será do tipo int e será criado com o tamanho digitado
        // pelo usuário
        int[] vet5;

        Integer escolhaDia, soma = 0, contaPares = 0;
        Integer tamanho;

        // Preencher o vetor vet1 com valores
        for (int i = 0; i < vet1.length; i++) {
            vet1[i] = i * 10;
        }

        // Exibição do vetor vet1
        System.out.println("Exibição do vetor vet1:");
        exibeVetor(vet1);

        // Exibição do vetor vet2
        System.out.println("\nExibição do vetor vet2:");
        exibeVetor(vet2);

        // Embora o vetor vet2 tenha "nascido" com os valores fixos,
        // esses valores podem ser alterados conforme a necessidade
        // Por exemplo:
        vet2[3] = vet2[2] * vet2[1];
        // No exemplo acima, vemos tb que é possível utilizar os elementos
        // de um vetor como se fossem variáveis normais

        // Exibição do vetor vet2
        System.out.println("\nExibição do vetor vet2:");
        exibeVetor(vet2);

        // Solicitar que o usuário digite os valores do vetor vet3
        for (int i = 0; i < vet3.length; i++) {
            System.out.println("Digite o valor de vet3[" + i + "]:");
            vet3[i] = leitor.next();
        }

        // Exibição do vetor vet3
        System.out.println("\nExibição do vetor vet3:");
        for (String s : vet3) {
            System.out.print(s + "\t");
        }
        System.out.println();

        // Criar um vetor de String inicializado com os nomes dos dias da semana
        // Solicitar para o usuário digitar um valor inteiro de 1 a 7
        // Ficar num loop enquanto o usuário não digitar um valor válido
        // Exibir o nome do dia da semana correspondente
        // Se for 1, exibir Domingo. Se for 2, exibir Segunda, etc.
        // Não é para usar switch - case e sim, é para usar o vetor
        do {
            System.out.println("Digite um valor de 1 a 7");
            escolhaDia = leitor.nextInt();
        } while (escolhaDia < 1 || escolhaDia > 7);

        // Exibir o dia da semana correspondente
        System.out.println("O dia da semana correspondente é " +
                            diaDaSemana[escolhaDia - 1]);

        // Exibir a soma dos valores dos elementos de vet1
        for (int num : vet1) {
            soma += num;
        }
        System.out.println("A soma dos elementos de vet1 é " + soma);

        // Exibir a quantidade de elementos pares de vet1
        for (int i = 0; i < vet1.length; i++) {
            if (vet1[i] % 2 == 0) {
                contaPares++;
            }
        }
        System.out.println("A quantidade de elementos pares de vet1 é " +
                           contaPares);

        // Solicita que o usuário digite o valor do tamanho do vetor vet5
        // Esse tamanho deve ser maior ou igual a 3
        // Ficar num loop enquanto o tamanho for inválido
        System.out.println("Digite um valor inteiro maior ou igual a 3");
        tamanho = leitor.nextInt();

        while (tamanho < 3) {
            System.out.println("Valor inválido. Digite novamente");
            tamanho = leitor.nextInt();
        }

        // Criação do vetor vet5 com o tamanho digitado pelo usuário
        vet5 = new int[tamanho];

        // Solicitar que o usuário digite os valores do vetor vet5
        for (int i = 0; i < vet5.length; i++) {
            System.out.println("Digite o valor de vet5[" + i + "]:");
            vet5[i] = leitor.nextInt();
        }

        // Exibição do vetor vet5
        System.out.println("\nExibição do vetor vet5:");
        exibeVetor(vet5);

    }
}
