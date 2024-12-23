
package bancoimobiliario;

public class BancoImobiliario {
//tire esse comentário
    public static void main(String[] args) {
       Tabuleiro tabuleiro = new Tabuleiro();
       Jogador estella = new Jogador("estella");
       Jogador aquiles = new Jogador("aquiles");

         tabuleiro.getPosicoes()[2].acao(estella);
         tabuleiro.getPosicoes()[2].acao(aquiles);
        tabuleiro.getPosicoes()[3].acao(aquiles);
        tabuleiro.getPosicoes()[4].acao(estella);
    }
    
}
