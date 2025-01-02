package bancoimobiliario;

//Calsse fixo que herda de Posição
public class Fixo extends Posicao{
    private int valor; //Valor associado a posição fixo

    //Costrutor que inicia valor e o nome da Posição fixo
    public Fixo(int valor, String nome) {
        super(nome);
        this.valor = valor;
    }


    //Método que define a ação relaizada pelo jogador quando cai em umapoisição fixo
    @Override
    protected boolean acao(Jogador nome, int dado) {
        //Verifica se a posição é uma "Parada Livre"
        if (super.getNome().equals("Parada Livre")){
            System.out.println("Você caiu na Parada Livre! Curta sua folga!\n");
            System.out.println("-------------------");
            return true;
        }
        //verifica se a poisiçao é o Início
        if (super.getNome().equals("Inicio")){
                System.out.println("Você caiu no início novamente e vai ganhar R$200,00!!!\n");
                System.out.println("-------------------");
                //atualiza o saldo do jogador com +200
                nome.atualizaSaldo(this.valor);
                return true;
                //verifica se a posição é Lucros ou Dividendos
        }else if (super.getNome().equals("Lucros ou Dividendos")){
            System.out.println("Você caiu em Lucros ou Dividendos e ganhou R$200,00!!!\n");
            System.out.println("-------------------");
            nome.atualizaSaldo(this.valor); //Atualiza o saldo do jogador com +200
            return true;
        }else{
            //Caso contrário assume q a posição é imposto de renda
            System.out.println("Você caiu no Imposto de Renda e perdeu R$200,00!!!\n");
            System.out.println("-------------------");
            //Verifica se o joagdor pode pagar
            if(nome.verificaSaldo(this.valor)){
                nome.atualizaSaldo(-this.valor);//Atualiza o saldo do jagador com -200
                return true;
            }else{
                //Caso contrário jogador é eliminado
                System.out.println("Você não tem dinheiro suficiente...");
                return false;
            }

        }

    }
}
