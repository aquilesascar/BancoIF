package bancoimobiliario;

import java.util.Random;


public class  Jogo {
    public static void iniciaJogo(){
        Random random = new Random();

        System.out.println("Iniciando o jogo...");
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.addJogador();
        int soma = 0;
        //O jogo acaba quando restar apenas um jogador
        while (tabuleiro.getNumJogadores()>1) {
            //cada for é uma rodada de jgadores
            for (int i = 0; i < tabuleiro.getJogadores().length; i++) {
                //Verificando se o jogador não foi removido ou se está preo em cadeia
                if (tabuleiro.getJogadores()[i] != null && !tabuleiro.getJogadores()[i].isPreso()) {
                    //Sorteando os dados
                    int dado = random.nextInt(6) + 1;
                    int dado2 = random.nextInt(6) + 1;
                    soma = dado + dado2;
                    System.out.println(tabuleiro.getJogadores()[i].getNome() + " tirou " + dado + " e " + dado2 + ". \nA soma é: " + soma);
                    //alterando a posição do jogador
                    tabuleiro.getJogadores()[i].alteraPosicao(soma);
                    // Verificando se a posição do jogador excede as posições do tabuleiro
                    if(tabuleiro.getJogadores()[i].getPosicao()>39){
                        // reajustando a posição
                        tabuleiro.getJogadores()[i].alteraPosicao(-40);
                        if(tabuleiro.getJogadores()[i].getPosicao()>0){
                            System.out.println("Você passou pelo Início navamente e Ganhou R$200.00");
                            tabuleiro.getJogadores()[i].atualizaSaldo(200);
                        }
                    }
                    System.out.println("Posição: " + tabuleiro.getJogadores()[i].getPosicao());
                    if (!tabuleiro.getPosicoes()[tabuleiro.getJogadores()[i].getPosicao()].acao(tabuleiro.getJogadores()[i], soma)) {
                        // se a função acao retornar falso o jogador perde e será removido do jogo
                        tabuleiro.removeJogador(tabuleiro.getJogadores()[i]);
                        System.out.println("Que pena!Você foi eliminado!\n");
                    }
                    //se o jogador estiver preso ele é solto para jogar só na proxima rodada
                }else if(tabuleiro.getJogadores()[i] != null && tabuleiro.getJogadores()[i].isPreso()){
                    System.out.println(tabuleiro.getJogadores()[i].getNome()+" Ops! Você está de castigo nesta rodada por estar preso." +
                            " Mas não se preocupe, na próxima rodada você já estará livre para jogar de novo! " +
                            "Aproveite o descanso forçado");
                    tabuleiro.getJogadores()[i].solta();
                }
            }
        }
        System.out.println("Parabéns!!! O jogador vencedor foi:");
        for (int i = 0; i < tabuleiro.getJogadores().length; i++) {
            if (tabuleiro.getJogadores()[i] != null) {
                System.out.println(tabuleiro.getJogadores()[i].getNome());
            }
        }
    }
}
