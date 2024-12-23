package bancoimobiliario;

public class Companhia extends Propriedade{    
    private int valorCompanhia;
    private int aluguel;
    
    public Companhia(int valorCompanhia, String nome, int aluguel, int indice) {
        super(nome, indice);
        this.valorCompanhia = valorCompanhia;
    }

    @Override
    protected boolean compra(Jogador nome) {
        return false;
    }

    @Override
    protected boolean fazMelhoria(Jogador nome) {
        return false;
    }

    @Override
    protected int getValor() {
        return 0;
    }

    @Override
    protected int getAluguel() {
        return 0;
    }
}
