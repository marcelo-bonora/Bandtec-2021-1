import java.util.Scanner;

public class TestaCarrinho {

    public static void main(String[] args) {

        Carrinho carrinho = new Carrinho();

        Boolean bol = true;

        while (bol) {

            System.out.println("\nMenu, escolha umas das opções:" +
                    "\n 1. Adicionar Livro" +
                    "\n 2. Adicionar DVD" +
                    "\n 3. Adiiconar Serviço" +
                    "\n 4. Exibir Itens do Carrinho" +
                    "\n 5. Exibir Total de Vendas" +
                    "\n 6. Fim ");

            Scanner input = new Scanner(System.in);
            Integer num = input.nextInt();

            switch (num) {
                case 1:
                    System.out.println("\n - Adicionar Livro -");

                    System.out.println("\n Digite Cod: ");
                    Integer codLivro = input.nextInt();

                    input = new Scanner(System.in);
                    System.out.println("\n Digite o preço: ");
                    Double precoLivro = input.nextDouble();

                    input = new Scanner(System.in);
                    System.out.println("\n Digite o nome: ");
                    String nomeLivro = input.nextLine();

                    System.out.println("\n Digite o autor: ");
                    String autor = input.nextLine();

                    System.out.println("\n Digite o isbn: ");
                    String isbn = input.nextLine();

                    Livro livro = new Livro(codLivro, precoLivro, nomeLivro, autor, isbn);
                    carrinho.adicionaVendavel(livro);

                    break;

                case 2:
                    System.out.println("\n - Adicionar DVD -");
                    System.out.println("\n Digite Cod: ");
                    Integer codDVD = input.nextInt();

                    input = new Scanner(System.in);
                    System.out.println("\n Digite o preço: ");
                    Double precoDVD = input.nextDouble();

                    input = new Scanner(System.in);
                    System.out.println("\n Digite o nome: ");
                    String nomeDVD = input.nextLine();

                    System.out.println("\n Digite a gravadora: ");
                    String gravadora = input.nextLine();

                    DVD dvd = new DVD(codDVD, precoDVD, nomeDVD, gravadora);
                    carrinho.adicionaVendavel(dvd);

                    break;


                case 3:
                    System.out.println("\n - Adicionar Serviço -");
                    System.out.println("\n Descrição: ");
                    String descricao = input.nextLine();

                    input = new Scanner(System.in);
                    System.out.println("\n  Digite o cod: ");
                    Integer codServico = input.nextInt();

                    input = new Scanner(System.in);
                    System.out.println("\n Digite a quantidade de horas: ");
                    Integer quantHoras = input.nextInt();

                    System.out.println("\n Digite o valor hora: ");
                    Double valorHora = input.nextDouble();

                    Servico servico = new Servico(descricao, codServico, quantHoras, valorHora);
                    carrinho.adicionaVendavel(servico);

                    break;

                case 4:
                    System.out.println("\n - Itens que contém no carrinho - ");
                    carrinho.exibirItensCarrinho();
                    break;

                case 5:
                    System.out.println("\n - Valor total de venda dos itens -");
                    System.out.println("\n Valor Total: " + carrinho.calculaTotalVenda());
                    break;

                case 6:
                    System.out.println("\n - Finalizar -");
                    bol = false;
                    break;
            }
        }
    }
}
