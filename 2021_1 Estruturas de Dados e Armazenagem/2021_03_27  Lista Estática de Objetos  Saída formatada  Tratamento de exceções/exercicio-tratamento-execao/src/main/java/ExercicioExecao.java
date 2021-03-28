import sun.plugin2.message.JavaObjectOpMessage;

import javax.swing.*;

public class ExercicioExecao {

    public static void main(String[] args) {
        boolean continua = true;

    do{
        try{
            String salario = JOptionPane.showInputDialog("Digite o valor do sálario:");
            if (salario == null){
                System.exit(0);
            }
            String reajuste  = JOptionPane.showInputDialog("Digite o valor do reajuste (0 a 100)");
            if (reajuste == null){
                System.exit(0);
            }
            int salariouNum = Integer.parseInt(salario);
            double reajusteNum = Integer.parseInt(reajuste);

            if (salariouNum < 0){
                throw new Exception("O valor do sálario não deve ser menor que zero");
            }

            if ((reajusteNum < 0) || (reajusteNum > 100)){
                throw new Exception("O valor do fora dos limites permitidos (entre 0 e 100)");
            }

            double result = salariouNum * (1 + (reajusteNum / 100));
            JOptionPane.showMessageDialog(null,"Reajuste sálarial = R$" + result);
            continua = false;

        }
        catch (NumberFormatException erro){
            JOptionPane.showMessageDialog(null,"Digite apenas números inteiros!\n" +
                    erro.toString(), "Erro",JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception erro){
            JOptionPane.showMessageDialog(null,erro);
        }

    }while (continua);

    }

}
