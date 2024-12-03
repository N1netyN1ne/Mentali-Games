package mentali;

import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PalavraSinuosa extends JogoBase {
    // Atributos
    private Path caminho;
    private String palpite;
    private final Scanner scan = new Scanner(System.in);

    // Métodos  
    @Override
    void jogar() {
        int opcao;
        do {
            limparTela(2);
            System.out.println("Escolha que tipo de palavras quer advinhar:\n"
                    + "1 - Frutas\n"
                    + "2 - Objetos\n"
                    + "3 - Marcas de carro\n"
                    + "4 - Sair");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1 -> {
                    frutas();
                    resultados();
                }
                case 2 -> {
                    objetos();
                    resultados();
                }
                case 3 -> {
                    marcas();
                    resultados();
                }
                case 4 -> System.out.println("Saindo do jogo...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);
    }

    @Override
    void introducao() {
        System.out.println("Bem-vindo ao jogo Palavra Sinuosa!\n"
                + "Regras do jogo:\n"
                + "1. O sistema embaralha as palavras e voce deve adivinhar qual e.\n"
                + "2. Cada acerto vale 20 pontos.\n"
                + "3. Cada erro desconta 2 pontos.\n");
    }

    private void frutas() {
        caminho = Paths.get("palavras/frutas.txt");
        jogarComArquivo(caminho);
    }

    private void objetos() {
        caminho = Paths.get("palavras/objetos.txt");
        jogarComArquivo(caminho);
    }

    private void marcas() {
        caminho = Paths.get("palavras/marcas.txt");
        jogarComArquivo(caminho);
    }

    private void jogarComArquivo(Path caminhoArquivo) {
        try {
            List<String> palavras = Files.readAllLines(caminhoArquivo);
            setRodada(0);
            setPontuacao(0);
            for (String palavra : palavras) {
                boolean acertou = false;

                while (!acertou) {
                    limparTela(5);
                    String palavraEmbaralhada = embaralharPalavra(palavra);
                    System.out.println("Palavra embaralhada: " + palavraEmbaralhada);
                    System.out.print("Digite seu palpite: ");
                    palpite = scan.next();

                    if(palpite.equalsIgnoreCase(palavra)){
                        System.out.println("Parabens, voce acertou!");
                        addPontos(20);
                        acertou = true;
                        setRodada(getRodada()+1);
                    }else{
                        System.out.println("""
                                           Voce errou! Deseja tentar novamente? 
                                           1-Sim
                                           2-Nao""");
                        int opcao = scan.nextInt();
                        if(opcao == 2){
                            break;
                        }
                        removePontos(2);
                        setRodada(getRodada()+1);
                    }
                }
            }
            limparTela(5);
            System.out.println("Voce concluiu todas as palavras dessa categoria!");
            
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private String embaralharPalavra(String palavra) {
        List<Character> caracteres = new ArrayList<>();
        for (char c : palavra.toCharArray()) {
            caracteres.add(c);
        }
        Collections.shuffle(caracteres);

        StringBuilder palavraEmbaralhada = new StringBuilder();
        for (char c : caracteres) {
            palavraEmbaralhada.append(c);
        }
        return palavraEmbaralhada.toString();
    }
    
    @Override
    public void resultados(){
        System.out.println("Voce jogou " + getRodada() + " rodada(s) \n"
                + "E somou " + getPontuacao() + " Pontos");
        limparTela(2);
    }
}
