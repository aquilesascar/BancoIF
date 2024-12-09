package bancoimobiliario;

public class Propriedade extends Posicao{
    Jogador proprietario;

    public Propriedade(String nome) {
        super(nome);
    }

    public Jogador getProprietario() {
        return proprietario;
    }

}
