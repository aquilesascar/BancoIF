
package bancoimobiliario;

public class BancoImobiliario {
//tire esse comentário
    public static void main(String[] args) {
       Tabuleiro tabuleiro = new Tabuleiro();
       Jogador estella = new Jogador("estella");
       Jogador aquiles = new Jogador("aquiles");

         tabuleiro.getPosicoes()[5].acao(estella, 3);
         tabuleiro.getPosicoes()[5].acao(aquiles, 2);
        tabuleiro.getPosicoes()[7].acao(aquiles, 1);
        tabuleiro.getPosicoes()[7].acao(estella, 9);
    }
    
}
