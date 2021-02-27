import java.util.Scanner;

public class ExemploSwitchCase {

    public static void main(String[] args) {

        // Objeto Scanner para ler next(), nextDouble(), nextInt()
        Scanner leitor = new Scanner(System.in);

        // Criação de outro objeto Scanner somente para ler nextLine()
        // Pois o nextLine() "consome" o <ENTER> da leitura anterior
        Scanner leitorNL = new Scanner(System.in);

        Integer diaDaSemana, posicao;
        Integer num1, num2, num3;

        // Exemplo de digitação de 3 números numa mesma linha,
        // separados por espaço
        // O Scanner consegue ler cada número separadamente
        System.out.println("Digite 3 números na mesma linha");
        num1 = leitor.nextInt();
        num2 = leitor.nextInt();
        num3 = leitor.nextInt();
        System.out.println(String.format("num1=%d\nnum2=%d\nnum3=%d",
                                         num1, num2, num3));

        // Lógica para explicação do switch case
        System.out.println("Digite o dia da semana (1 a 7)");
        diaDaSemana = leitor.nextInt();

        // Lógica é: se o usuário digitou 1, o programa exibirá "Domingo"
        // Se o usuário digitou 2, o programa exibirá "Segunda-feira"
        // E assim por diante

        // Primeiramente, como seria usando if else
        if (diaDaSemana == 1) {
            System.out.println("Domingo");
        }
        else if (diaDaSemana == 2) {
            System.out.println("Segunda-feira");
        }
        else if (diaDaSemana == 3) {
            System.out.println("Terça-feira");
        } // e assim por diante....

        // Implementando a mesma lógica, usando switch case
        switch (diaDaSemana) {
            case 1:  // diaDaSemana é igual a 1
                System.out.println("Domingo");
                break;

            case 2: // diaDaSemana é igual a 2
                System.out.println("Segunda-feira");
                break;

            case 3: // diaDaSemana é igual a 3
                System.out.println("Terça-feira");
                break;

            case 4: // diaDaSemana é igual a 4
                System.out.println("Quarta-feira");
                break;

            case 5: // diaDaSemana é igual a 5
                System.out.println("Quinta-feira");
                break;

            case 6: // diaDaSemana é igual a 6
                System.out.println("Sexta-feira");
                break;

            case 7: // diaDaSemana é igual a 7
                System.out.println("Sábado");
                break;

            default: // diaDaSemana é diferente dos anteriores (1 a 7)
                System.out.println("Dia da semana inválido");
                break;
        }

        // Exemplo de switch case em que é útil não colocar o break
        // Concurso, no qual o 1o lugar ganha um iPhone, um iPad e um iPod
        // 2o lugar ganha um iPad e um iPod
        // 3o lugar ganha apenas um iPod

        System.out.println("Digite qual foi a sua posição no concurso");
        posicao = leitor.nextInt();

        System.out.print("Você ganhou ");
        switch (posicao) {
            case 1:
                System.out.print("um iPhone, ");
            case 2:
                System.out.print("um iPad e ");
            case 3:
                System.out.println("um iPod.");
                break;
            default:
                System.out.println("experiência! Mais sorte da próxima vez!");
                break;
        }

        // Exemplo de como pode ser o código do main do exercício de Interface
        // do Carrinho
        Boolean fim = false;
        Integer opcao;

        // Criar objeto da classe Carrinho (exemplo: cart)
        // Criar variáveis para cada atributo das classes Livro, DVD, Servico
        Integer codigo;
        Double precoCusto;
        String nome, autor, isbn;

        while (!fim) {   // enquanto não for fim (enquanto usuário não escolheu opção 6)
            // Exibição do menu
            System.out.println("Escolha uma das opções a seguir:");
            System.out.println("1- Adicionar Livro");
            System.out.println("2- Adicionar DVD");
            System.out.println("3- Adicionar Serviço");
            // etc
            // Lê a opção digitada pelo usuário
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1: // Adicionar um livro
                    // Solicitar que o usuário digite os valores dos atributos do livro
                    // Ler cada atributo digitado pelo usuário
                    System.out.println("Digite o código do livro");
                    codigo = leitor.nextInt();
                    System.out.println("Digite o preço de custo do livro");
                    precoCusto = leitor.nextDouble();
                    System.out.println("Digite o nome do livro");
                    nome = leitorNL.nextLine();
                    System.out.println("Digite o nome do autor");
                    autor = leitorNL.nextLine();
                    // Criar um objeto da classe Livro
                    //Livro book = new Livro(codigo,precoCusto,nome,autor,isbn);
                    // Adicionar esse objeto livro à lista do objeto Carrinho
                    //cart.adicionaVendavel(book);
                    break;

                case 2: // Adicionar um DVD
                    // Semelhante ao case 1, mas lendo os atributos de DVD
                    // Criar um objeto DVD
                    // Adicionar esse objeto ao carrinho
                    break;

                case 3: // Idem, mas para Servico
                    break;

                case 4: // Chamar o método exibirItensCarrinho do objeto carrinho
                    break;

                case 5: // Chamar o método calculaTotalVenda do objeto carrinho
                    // E exibir o valor retornado
                    break;

                case 6:
                    fim = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }   // fim do switch case
        }  // fim do while



    }
}
