package bancoimobiliario;

public class Fixo extends Posicao{
    private int valor;

    public Fixo(int valor, String nome) {
        super(nome);
        this.valor = valor;
    }


    @Override
    protected boolean acao(Jogador nome, int dado) {
        if (super.getNome().equals("Inicio")){
            if(dado!=0) {
                System.out.println("Você caiu no início novamente e vai ganhar R$200,00!!!");
                nome.atualizaSaldo(this.valor);
                return true;
            }else{
                System.out.println("Ops! O jogo ainda não começou para você. Tente de novo na próxima rodada.");
                return true;
            }
        }else if (super.getNome().equals("Lucros ou Dividendos")){
            System.out.println("Você caiu em Lucros ou Dividendos e ganhou R$200,00!!!");
            nome.atualizaSaldo(this.valor);
            return true;
        }else{
            System.out.println("Você caiu no Imposto de Renda e perdeu R$200,00!!!");
            if(nome.verificaSaldo(this.valor)){
                nome.atualizaSaldo(-this.valor);
                return true;
            }else{
                System.out.println("Você não tem dinheiro suficiente...");
                return false;
            }

        }

    }
}
