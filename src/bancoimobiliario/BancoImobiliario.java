
package bancoimobiliario;

public class BancoImobiliario {

    public static void main(String[] args) {
       Tabuleiro tabuleiro = new Tabuleiro();
       Jogador estella = new Jogador("estella");
       Jogador aquiles = new Jogador("estella");
       
       ((Lote) tabuleiro.posicoes[3]).acao(estella);
       ((Lote) tabuleiro.posicoes[3]).acao(aquiles);
    }
    
}
