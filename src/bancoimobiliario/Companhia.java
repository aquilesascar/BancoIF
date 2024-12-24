package bancoimobiliario;

public class Companhia extends Propriedade{    
    private int valorCompanhia;
    private int aluguel;
    private int indice;

    public Companhia(int valorCompanhia, String nome, int aluguel, int indice) {
        super(nome, indice);
        this.valorCompanhia = valorCompanhia;
        this.indice = indice;
        this.aluguel = aluguel;
    }

    @Override
    protected boolean compra(Jogador nome) {
        if(nome.verificaSaldo(this.valorCompanhia)){
            nome.atualizaSaldo(-this.valorCompanhia);
            this.proprietario = nome;
            nome.addPropriedade(super.indice);
            return true;
        }
        return false;
    }

    @Override
    protected int valorAluguel(int dado) {
        int novoAluguel =this.aluguel*dado;
        return novoAluguel;
    }


    @Override
    protected int getValor() {
        return this.valorCompanhia;
    }

    @Override
    protected void voceeProprietario(Jogador proprietario) {
        System.out.println("Você é o proprirtário! Não é necessário pagar o aluguel.");
    }


}
