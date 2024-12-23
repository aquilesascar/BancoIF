package bancoimobiliario;

public class Fixo extends Posicao{
    private int valor;

    public Fixo(int valor, String nome) {
        super(nome);
        this.valor = valor;
    }


    @Override
    protected boolean acao(Jogador nome, int dado) {
        return true;
    }
}
