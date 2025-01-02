package bancoimobiliario;

import java.util.Random;

public class Sortereves extends Posicao {

    private int GANHO_MAXIMO; //Valor máximo que um jogador pode ganhar ao cair nesta casa
    private int PERDA_MAXIMA; //Valor máximo que um jogador pode perder ao cair nesta casa

    public Sortereves() {
        super("Sorte ou Revés"); //Chama o construtor da classe pai para definir o nome da casa
        this.GANHO_MAXIMO = 150; //Define o valor máximo de ganho
        this.PERDA_MAXIMA = 80;  //Define o valor máximo de perda
    }

    @Override
    protected boolean acao(Jogador jogador, int dado) {
        Random random = new Random(); //Cria um objeto para gerar números aleatórios
        int sorte = random.nextInt(2); //Gera um número aleatório (0 ou 1) para determinar se é sorte ou revés

        if (sorte == 1) { //Se o número for 1, o jogador tem sorte
            int valor = random.nextInt(GANHO_MAXIMO) + 1; //Gera um valor aleatório de ganho
            jogador.atualizaSaldo(valor); //Adiciona o valor ao saldo do jogador
            System.out.println(jogador.getNome() + " teve sorte! Ganhou R$ " + valor + ",00.\n");
            System.out.println("-------------------");
            return true;
        } else { // Se não, o jogador tem revés
            int valor = random.nextInt(PERDA_MAXIMA) + 1; //Gera um valor aleatório de perda
            if (jogador.verificaSaldo(valor)) { //Verifica se o jogador tem saldo suficiente para perder
                System.out.println(jogador.getNome() + " teve revés! Perdeu R$ " + valor + ",00.\n");
                System.out.println("-------------------");
                jogador.atualizaSaldo(-valor); //Subtrai o valor do saldo do jogador
                return true;
            } else {
                System.out.println(jogador.getNome() + " teve um reves e ficou sem saldo!\n");
                return false; //Indica que o jogador foi à falência
            }
        }
    }
}