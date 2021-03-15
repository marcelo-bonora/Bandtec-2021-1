public class exercicio_07 {

    public static void main(String[] args) {
        int[] vetor1 = {3, 8, 5, 9, 1};
        int[] vetor2 = {10, 6, 4, 2, 7};
        bubbleSort(vetor1);
        System.out.println("Vetor 1 ordenado: ");
        for(int numero : vetor1){
            System.out.println(numero);
        }
        bubbleSort(vetor2);
        System.out.println("Vetor 2 ordenado: ");
        for(int numero : vetor2){
            System.out.println(numero);
        }
        mergeSort(vetor1, vetor2);
    }

    public  static void bubbleSort(int[] vetor){
        int temp;
        for (int i = 0; i < vetor.length-1; i++){
            for(int j = 0; j < vetor.length;j++){
                if (vetor[j] > vetor[j+1]){
                    temp = vetor[j+1];
                    vetor[j+1] = vetor[j];
                    vetor[j] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] vetor1, int[] vetor2) {
        int v1 = 0;
        int v2 = 0;

        int v3 = 0;

        int[] mergeado = new int[vetor1.length + vetor2.length];

        while (v1 < vetor1.length && v2 < vetor2.length) {
            if (vetor1[v1] > vetor2[v2]) {
                mergeado[v3++] = vetor2[v2++];
            } else {
                mergeado[v3++] = vetor1[v1++];
            }
        }

        while (v1 < vetor1.length) {
            mergeado[v3++] = vetor1[v1++];
        }

        while (v2 < vetor2.length) {
            mergeado[v3++] = vetor2[v2++];
        }

        System.out.println("\nVetor3 ordenado:");
        for (int numero: mergeado) {
            System.out.println(numero);
        }
    }

}
