package bancoimobiliario;

public abstract class Posicao {
    private Jogador jogadores[];
    private String nome;

    public Posicao(String nome) {
        this.nome = nome;
    }

    protected abstract boolean acao(Jogador nome, int dado);


    
}
