package bancoimobiliario;

public class Cadeia extends Posicao {

    public Cadeia(String nome) {
        super(nome);
    }

    @Override
    protected boolean acao(Jogador nome, int dado) {
        //Caso o jagador tenha caido numa casa que manda para a cadeia
        if(nome.getPosicao()==30){
            System.out.println("Parabéns! Além de você ter q voltar 20 casas, ainda ganhárá uma estadia na Cadeia por uma rodada");
            nome.alteraPosicao(-20);

        }else {
            // se o jogador caiu na cadeia
            System.out.println("Parabéns! Você ganhou uma estadia VIP na Cadeia por uma rodada. Aproveite a vista das grades!");
        }
        //mudando a variavel preso do jogador para true
        nome.prende();
        return true;
    }
}
