public class TesteTributo {

    public static void main(String[] args) {

        // Criação dos obejtos
        Alimento maca = new Alimento(123, "1 kg Maça Fuji",6.99,3);
        Perfume puruvoodoo = new Perfume(456,"Perfume da Rochele",200.0,"amadeirado");
        Servico dev = new Servico("Desenvolvedor freelancer",1000.0);

        // Exibição dos obejetos
        System.out.println(maca);
        System.out.println(puruvoodoo);
        System.out.println(dev);

        // Criação do objeto Tributo
        Tributo trib = new Tributo();

        // Adiciona os objetos criados à lista de tributaveis de trib
        trib.adicionaTributavel(maca);
        trib.adicionaTributavel(puruvoodoo);
        trib.adicionaTributavel(dev);

        // Exibir todos tributaveis
        trib.exibeTodos();

        // Exibe total de tributo da lista
        System.out.println("\nTotal de tributos: " + trib.calculaTotalTributo());

        // OU
        //Double total = trib.calculaTotalTributo();
    }
}
