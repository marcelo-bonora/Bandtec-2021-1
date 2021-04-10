import java.util.Scanner;

public class ExemploMatriz {

    // Método exibeMatriz - recebe uma matriz de inteiros
    // Exibe a matriz no formato de matriz
    public static void exibeMatriz(int[][] m) {
        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length; coluna++) {
                System.out.print(m[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }

    // Método exibeMatrizTransposta - recebe uma matriz de inteiros
    // Exibe a matriz transposta da matriz recebida como argumento,
    // ou seja, exibe as colunas como se fosse linhas e as linhas como se fossem colunas
    public static void exibeMatrizTransposta(int[][] m) {
        for (int coluna = 0; coluna < m[0].length; coluna++) {
            for (int linha = 0; linha < m.length; linha++) {
                System.out.print(m[linha][coluna] + "\t");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // Criação de vetor (apenas para ver as semelhanças e diferenças com a criação da matriz)
        int[] vetor = new int[10];

        // Criação de matriz de inteiros com 3 linhas e 4 colunas
        int[][] matriz = new int[3][4];

        // Criação de matriz de inteiros com inicializadores
        int[][] matriz2 = { {1,2}, {3,4}, {5,6}, {7,8} };

        // Cria uma matriz toda irregular com número de colunas
        // diferente em cada linha
        int[][] matrizLoka = { {1}, {2,3,4,5}, {6,7}, {8,9,10} };

        // Como criar uma matriz irregular sem os inicializadores
        int[][] m2 = new int[3][];
        m2[0] = new int[3];
        m2[1] = new int[5];
        m2[2] = new int[1];

        // Preencher a matriz com valores digitados pelo usuário
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.println("Digite o valor de matriz[" + linha+ "]" +
                                   "[" + coluna + "]");
                matriz[linha][coluna] = leitor.nextInt();
            }
        }

        // Exibir a matriz no formato de matriz
        exibeMatriz(matriz);

        System.out.println();

        // Exibir a matriz2 no formato de matriz
        exibeMatriz(matriz2);

        System.out.println();
        // Exibir a matrizLoka no formato de matriz
        exibeMatriz(matrizLoka);

        System.out.println();
        // Exibe a matriz transposta de matriz
        exibeMatrizTransposta(matriz);

        System.out.println();
        // Exibe a matriz transposta de matriz2
        exibeMatrizTransposta(matriz2);


    }
}
