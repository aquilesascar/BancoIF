package bancoimobiliario;

public class Cadeia extends Posicao {

    // Construtor da classe Cadeia. Recebe o nome da posição
    public Cadeia(String nome) {
        // Chama o construtor da classe pai (Posicao) para definir o nome da posição
        super(nome);
    }

    // Método que define a ação que acontece quando um jogador cai nesta posição
    @Override
    protected boolean acao(Jogador nome, int dado) {
        // Verifica se o jogador caiu na casa que manda para a cadeia
        if(nome.getPosicao()==30){
            // Se sim, imprime uma mensagem informando que ele vai para a cadeia e volta 20 casas
            System.out.println("\nParabéns! Além de você ter q voltar 20 casas, ainda ganhará uma estadia na Cadeia por uma rodada");
            // Altera a posição do jogador, voltando 20 casas
            nome.alteraPosicao(-20);

        }else {
            // Se o jogador já estava na cadeia (caiu diretamente na casa da cadeia), imprime uma mensagem de "boas vindas"
            System.out.println("\nParabéns! Você ganhou uma estadia VIP na Cadeia por uma rodada. Aproveite a vista das grades!");
        }
        // Define o jogador como preso (a variável "preso" do jogador passa a ser true)
        nome.prende();
        // Retorna true para indicar que a ação foi realizada com sucesso
        return true;
    }
}