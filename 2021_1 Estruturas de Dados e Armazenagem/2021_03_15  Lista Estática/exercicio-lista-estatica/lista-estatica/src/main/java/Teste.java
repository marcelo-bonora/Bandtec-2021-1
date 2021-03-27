public class Teste {

    public static void main(String[] args) {
        // Cria objeto da classe ListaEstatica, com tamanho máximo 5
        ListaEstatica lista = new ListaEstatica(5);

        // Adiciona os valores 10, 20, 30
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        // Exibe a lista
        lista.exibe();

        // Adiciona os valores 40, 50, 60 (não vai conseguir inserir o 60)
        lista.adiciona(40);
        lista.adiciona(50);
        lista.adiciona(60);
        // Exibe a lista
        lista.exibe();

        // Procura na lista o valor 25
        System.out.println("\nBuscando valor 25...");
        int indRetornado = lista.busca(25);
        if (indRetornado == -1) {
            System.out.println("Valor 25 não encontrado na lista");
        }
        else {
            System.out.println("Valor 25 encontrado no índice " + indRetornado);
        }

        // Procura na lista o valor 30
        System.out.println("\nBuscando valor 30...");
        indRetornado = lista.busca(30);
        if (indRetornado == -1) {
            System.out.println("Valor 30 não encontrado na lista");
        }
        else {
            System.out.println("Valor 30 encontrado no índice " + indRetornado);
        }

        // Remove o valor que está no índice 2 da lista e exibe a lista
        System.out.println("\nRemovendo valor do índice 2...");
        lista.removePeloIndice(2);
        lista.exibe();

        // Remove o valor 20 da lista e exibe a lista
        System.out.println("\nRemovendo valor 20...");
        lista.removeElemento(20);
        lista.exibe();

        // Adiciona o valor 60 e exibe a lista
        System.out.println("\nAdicionando valor 60...");
        lista.adiciona(60);
        lista.exibe();

        // Substituindo o valor 50
        System.out.println("\nSubstituindo o valor 50...");
        lista.substituirElemento(50, 70);
        lista.exibe();

        // Contando quantas vezes a ocorrencia de valor 70 aparece..
        System.out.println("\nQuantindade de vezes que o valor 70 aparece..");
        lista.contarOcorrencias(70);


        // Adicionando um novo elemento a lista, sendo ele o primeiro elemento dessa lista
        System.out.println("\nAdicionaod o valor 80, sendo ele o primeiro elemento");
        lista.adicionaNoInicio(80);
        lista.exibe();
    }
}
