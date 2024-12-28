package bancoimobiliario;

import java.util.Scanner;

public class Lote extends Propriedade {
    private int valor; //Valor inicial de compra do lote
    private int aluguel; //Valor base do aluguel do lote
    private int melhoria; //Nível de melhoria do lote
    private int indice; //Posição do lote no tabuleiro

    public Lote(int valor, String nome, int aluguel, int indice) {
        super(nome, indice); //Chama o construtor da classe pai para inicializar nome e índice
        this.valor = valor; //Define o valor inicial para compra do lote
        this.aluguel = aluguel; //Define o valor base do aluguel
        this.melhoria = 3; //Inicializa o nível de melhoria (pode ser ajustado)
        this.indice = indice; //Define a posição do lote no tabuleiro
    }

    @Override
    public boolean compra(Jogador comprador) {
        //Verifica se o jogador tem saldo suficiente para comprar o lote
        if (comprador.verificaSaldo(this.valor)) {
            //Atualiza o saldo do jogador, define o proprietário e adiciona o lote às propriedades do jogador
            comprador.atualizaSaldo(-this.valor);
            this.proprietario = comprador;
            comprador.addPropriedade(super.indice);
            return true; //Compra realizada com sucesso
        }
        return false; //Compra não realizada
    }

    @Override
    protected int valorAluguel(int dado) {
        //Para lotes, o valor do aluguel é fixo e não depende do valor do dado
        return this.aluguel;
    }

    //Método para realizar melhorias no lote
    public boolean fazMelhoria(Jogador nome) {
        if (this.melhoria > 10) {
            //Verifica se o lote já atingiu o nível máximo de melhoria (hotel)
            System.out.println("Esta propriedade já é um hotel. Não pode mais ser melhorada.");
            return false;
        }

        //Verifica se o jogador tem saldo suficiente para a melhoria
        if (nome.verificaSaldo(this.aluguel)) {
            //Atualiza o valor do aluguel e o nível de melhoria do lote
            this.aluguel *= this.melhoria; //Multiplica o aluguel pelo nível de melhoria
            this.melhoria += 7; //Aumenta o nível de melhoria (pode ser ajustado)
            System.out.println("Melhoria feita. Agora seu aluguel é R$" + this.aluguel + ",00\n");
            return true;
        }
        return false;
    }

    @Override
    protected void voceeProprietario(Jogador proprietario) {
        Scanner teclado = new Scanner(System.in);
        int upgrade;
        do {
            // Oferece ao proprietário a opção de fazer uma melhoria
            System.out.println("Você é o dono desta propriedade.");
            System.out.println("Você gostaria de fazer uma melhoria?\n Digite 1 para SIM \n 2 para NÃO?");
            upgrade = teclado.nextInt();
            switch (upgrade) {
                case 1:
                    fazMelhoria(proprietario);
                    break;
                case 2:
                    System.out.println("Eita! Tá bom então, né?!");
                    break;
                default:
                    System.out.println("Você digitou um número errado. Tente novamente!");
            }
        } while (upgrade < 1 || upgrade > 2);
    }

    @Override
    protected int getValor() {
        return this.valor; //Retorna o valor inicial de compra do lote
    }
}