package mentali;

public abstract class JogoBase {
    //Atributos
    private int rodada;
    private int pontuacao;
    
    //Getters
    public int getRodada() {
        return rodada;
    }
    public int getPontuacao() {
        return pontuacao;
    }
    
    //Setters
    public void setRodada(int rodada) {
        this.rodada = rodada;
    }
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    //Métodos
    void addPontos(int pontos){
        this.pontuacao += pontos;
    }
    void removePontos(int pontos){
        this.pontuacao -= pontos;
    }
    void limparTela(int linhas){
        for (int i = 0; i < linhas; i++) {
            System.out.println();
        }
    }
    abstract void jogar();
    abstract void introducao();
    abstract void resultados();
}
