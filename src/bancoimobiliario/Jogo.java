package bancoimobiliario;

import java.util.Random;

public class Jogo {
    public static void iniciaJogo(){
        System.out.println("Iniciando o jogo...");
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.addJogador();
        int soma = 0;
        while ()
        for (int i = 0; i < tabuleiro.getJogadores().length; i++) {
            Random random = new Random();
            int dado = random.nextInt(6) + 1;
            int dado2 = random.nextInt(6) + 1;
            soma = dado + dado2;
            System.out.println(tabuleiro.getJogadores()[i].getNome() + " tirou " + dado + " e " + dado2 + ". \nA soma é: " + soma);
            tabuleiro.getJogadores()[i].alteraPosicao(soma);
            if (!tabuleiro.getPosicoes()[tabuleiro.getJogadores()[i].getPosicao()].acao(tabuleiro.getJogadores()[i], soma)){
                tabuleiro.removeJogador(tabuleiro.getJogadores()[i]);
            }

        }
    }
}
