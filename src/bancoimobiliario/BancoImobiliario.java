
package bancoimobiliario;

public class BancoImobiliario {
//tire esse comentário
    public static void main(String[] args) {
       Tabuleiro tabuleiro = new Tabuleiro();
       Jogador estella = new Jogador("estella");
       Jogador aquiles = new Jogador("aquiles");

         tabuleiro.getPosicoes()[3].acao(estella);
         tabuleiro.getPosicoes()[3].acao(estella);
    }
    
}
