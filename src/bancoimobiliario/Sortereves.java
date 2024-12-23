package bancoimobiliario;

import java.util.Random;

public class Sortereves extends Posicao {

    private static final int GANHO_MAXIMO = 150; //o máximo possível a ganhar
    private static final int PERDA_MAXIMA = 80;  //o máximo possivel a perder

    public Sortereves() {
        super("Sorte ou Revés");
    }

    @Override
    protected boolean acao(Jogador jogador) {
        Random random = new Random();
        int sorte = random.nextInt(2);
        int valor;

        if (sorte == 1) {
            valor = random.nextInt(GANHO_MAXIMO) + 1;
            jogador.atualizaSaldo(valor);
            System.out.println(jogador.getNome() + " teve sorte! Ganhou R$ " + valor + ",00.");
            return true;
        } else { // Revés
            valor = random.nextInt(PERDA_MAXIMA) + 1;
            if(jogador.verificaSaldo(valor)){
                System.out.println(jogador.getNome() + " teve revés! Perdeu R$ " + valor + ",00.");
                jogador.atualizaSaldo(-valor);
                return true;
            }else{
                System.out.println(jogador.getNome() + " teve um reves e ficou sem saldo!");
                return false;
            }

        }

    }
}
