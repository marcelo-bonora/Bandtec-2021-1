public class Teste {

    public static void main(String[] args) {
        // Funcionario f = new Engenheiro("111111", "Teste", 20000.0);

        // Criação dos objetos das classes Engenheiro, Vendedor e Horista
        Engenheiro e = new Engenheiro("123456", "Fulano", 15000.0);
        Vendedor v = new Vendedor("345678", "Mickey", 30000.0, 0.20);
        Horista h = new Horista("456789", "Pateta", 100, 50.0);

        // Exibição dos dados dos objetos criados
        System.out.println(e);
        System.out.println(v);
        System.out.println(h);

        // Criação do objeto da classe Empresa
        Empresa bandtec = new Empresa();

        // Adiciona os objetos de Engenheiro, Vendedor e Horista à lista de funcionários
        // do objeto bandtec
        bandtec.adicionaFunc(e);
        bandtec.adicionaFunc(v);
        bandtec.adicionaFunc(h);

        // Exibe todos os funcionários da bandtec
        bandtec.exibeTodos();

        // Exibe o total gasto com salário pela bandtec
        bandtec.exibeTotalSalario();

        // Exibe apenas os funcionários horistas
        bandtec.exibeHoristas();

    }
}
