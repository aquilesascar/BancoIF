package bancoimobiliario;

public abstract class Posicao {
    private String nome;//Nome da Posição

    //Construtor que inicializa o nome
    public Posicao(String nome) {
        this.nome = nome;
    }

    /* Método abstrato que define a ação feita pelo Jpgador quando ele cai em uma Posição
    que será implementado nas subclasses */
    protected abstract boolean acao(Jogador nome, int dado);


    //Método para obter o nome da Posição
    public String getNome() {
        return nome;
    }
}
