public class Teste {

    public static void main(String[] args) {

        /* Cria objeto pilha, com capacidade 5 */
        Pilha pilha = new Pilha(5);

        /* Empilha valores */
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        pilha.push(50);
        pilha.push(60);

        /* Exibe a pilha */
        pilha.exibe();

        /* Desempilha e exibe um valor */
        System.out.println("Desempilhou: " + pilha.pop());
        System.out.println();

        /* Exibe a pilha novamente */
        pilha.exibe();
        System.out.println();

        /* Exibe o elemento do topo da pilha, sem desempilhar */
        System.out.println("Topo da pilha: " +pilha.peek());
        System.out.println();

        /* Exibe a pilha novamente */
        pilha.exibe();
        System.out.println();

        /* Enquanto a pilha não estiver vazia,
         * desempilha e exibe um valor da pilha
         */
        while (!pilha.isEmpty()) {
            System.out.println("Desempilhando: " + pilha.pop());
        }




    }

}
