package mentali;
import java.util.Scanner;

public class Mentali {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int resp, op;
        do{
            System.out.println("""
                               Bem-vindo a Mentali Games
                               
                               Aqui voce encontra o jogo Numero Secreto
                               E
                               Palavra Sinuosa
                               
                               Escolha qual deseja jogar
                               1-Numero Secreto
                               2-Palavra Sinuosa
                               3-Sair""");
            op= scan.nextInt();
            switch (op) {
                case 1 -> {
                    NumeroSecreto numeroSecreto = new NumeroSecreto();
                    numeroSecreto.introducao();
                    numeroSecreto.jogar();
                    System.out.println("""
                                       Deseja jogar novamente ?
                                       1-Sim
                                       2-Nao""");
                    resp = scan.nextInt();
                    numeroSecreto.limparTela(2);
                    while(resp==1){
                        numeroSecreto.jogar();
                        numeroSecreto.limparTela(6);
                        System.out.println("""
                                           Deseja jogar novamente ?
                                           1-Sim
                                           2-Nao""");
                        resp = scan.nextInt();
                    }
                    numeroSecreto.resultados();
                }
                case 2 -> {
                    PalavraSinuosa palavrasinuosa = new PalavraSinuosa();
                    palavrasinuosa.introducao();
                    palavrasinuosa.jogar();
                }
                default -> op=3;
            }
        }while(op != 3);
    }
}
