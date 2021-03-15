public class exercicio_01 {

    public static void exibeVetor(int[] v) {
        System.out.println("Vetor na ordem ao qual os números foram inseridos:");
        for (int i = 0; i < v.length; ++i) {
            System.out.println("v[" + i + "]= " + v[i]);
        }

        System.out.println("\nVetor na ordem inversa ao qual os números foram inseridos:");
        for (int i = v.length - 1; i >= 0; --i) {
            System.out.println("v[" + i + "]= " + v[i]);
        }
    }

    public static void main(String[] args) {
        int[] vet = new int[]{10, 20, 30, 40, 50, 60, 70};
        exibeVetor(vet);
    }
}

