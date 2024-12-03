package mentali;

import java.util.Random;
import java.util.Scanner;

public class NumeroSecreto extends JogoBase{
    //Atributos
    private int numeroSecreto;
    private int palpite;
    Scanner scan = new Scanner(System.in);
    
    //Métodos
    int gerarNumeroSecreto(){
        Random random = new Random();
        return random.nextInt(100)+1;
    }
    boolean verificaPalpite(){
            if(this.palpite == numeroSecreto){
                System.out.println("Parabens voce acertou\n");
                addPontos(10);
                return true;
            }else if(this.palpite < this.numeroSecreto){
                limparTela(11);
                removePontos(1);
                System.out.println("""
                                   O numero gerado eh maior do que seu palpite
                                   Escolha um novo numero""");
                this.palpite = scan.nextInt();
                return false;
            }else{
                limparTela(11);
                removePontos(1);
                System.out.println("""
                                   O numero gerado eh menor do que seu palpite
                                   Escolha um novo numero""");
                this.palpite = scan.nextInt();
                return false;
            }
    }
    @Override
    void jogar(){
        limparTela(7);
        
        this.numeroSecreto = gerarNumeroSecreto();
        boolean verif;
        
        System.out.println("Escolha um numero");
        this.palpite = scan.nextInt();
        
        do{
             verif = verificaPalpite();
        }while(!verif);
        setRodada(getRodada()+1);
    }
    @Override
    void introducao(){
        limparTela(2);
        System.out.println("""
                           Bem vindo ao jogo Numero Secreto
                           O jogo funciona da seguinte forma:
                           Voce escolhe um numero de 1 a 100 e voce deve advinhar o numero
                           A depender o seu palpite, eh dada uma dica se voce chutou um numero maior ou menor do que o escolhido
                           Se voce acertar ganha 10 pontos, mas a cada palpite errado sao descontados 1 ponto""");
    }
    void resultados(){
        System.out.println("Voce jogou " + getRodada() + " rodada(s) \n"
                + "E somou " + getPontuacao() + " Pontos");
        limparTela(2);
    }
}
