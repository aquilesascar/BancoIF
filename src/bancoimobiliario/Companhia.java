package bancoimobiliario;

public class Companhia extends Propriedade {
    //Valor inicial da companhia para compra
    private int valorCompanhia;
    //Valor base do aluguel
    private int aluguel;
    //Índice da companhia no tabuleiro
    private int indice;

    public Companhia(int valorCompanhia, String nome, int aluguel, int indice) {
        super(nome, indice); //Chama o construtor da classe pai para inicializar nome e índice
        this.valorCompanhia = valorCompanhia; //Define o valor inicial da companhia
        this.indice = indice; //Define o índice da companhia no tabuleiro
        this.aluguel = aluguel; //Define o valor base do aluguel
    }

    @Override
    protected boolean compra(Jogador nome) {
        //Verifica se o jogador tem saldo suficiente para comprar a companhia
        if (nome.verificaSaldo(this.valorCompanhia)) {
            //Se tiver, atualiza o saldo do jogador, define o proprietário e adiciona a companhia às propriedades do jogador
            nome.atualizaSaldo(-this.valorCompanhia);
            this.proprietario = nome;
            nome.addPropriedade(super.indice);
            return true; //Compra realizada com sucesso
        }
        return false; //Compra não realizada
    }

    @Override
    protected int valorAluguel(int dado) {
        //Calcula o valor do aluguel multiplicando o valor base pelo valor do dado
        int novoAluguel = this.aluguel * dado;
        return novoAluguel;
    }

    @Override
    protected int getValor() {
        //Retorna o valor da companhia para compra
        return this.valorCompanhia;
    }

    @Override
    protected void voceeProprietario(Jogador proprietario) {
        //Mensagem para o jogador que é o proprietário da companhia
        System.out.println("Você é o proprietário! Não é necessário pagar o aluguel. Uhuuuuu!\n");
        System.out.println("-------------------");
    }
}