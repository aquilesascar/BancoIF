package bancoimobiliario;

import java.util.Random;

public class Sortereves extends Posicao {

    private int GANHO_MAXIMO;
    private int PERDA_MAXIMA;

    public Sortereves() {
        super("Sorte ou Revés");
        this.GANHO_MAXIMO = 150; //o máximo possível a ganhar
        this.PERDA_MAXIMA = 80; //o máximo possivel a perder
    }

    @Override
    protected boolean acao(Jogador jogador, int dado) {
        Random random = new Random();
        int sorte = random.nextInt(2);
        int valor;

        if (sorte == 1) {
            valor = random.nextInt( GANHO_MAXIMO) + 1;
            jogador.atualizaSaldo(valor);
            System.out.println(jogador.getNome() + " teve sorte! Ganhou R$ " + valor + ",00.\n");
            return true;
        } else { // Revés
            valor = random.nextInt( PERDA_MAXIMA) + 1;
            if(jogador.verificaSaldo(valor)){
                System.out.println(jogador.getNome() + " teve revés! Perdeu R$ " + valor + ",00.\n");
                jogador.atualizaSaldo(-valor);
                return true;
            }else{
                System.out.println(jogador.getNome() + " teve um reves e ficou sem saldo!\n");
                return false;
            }

        }

    }
}
