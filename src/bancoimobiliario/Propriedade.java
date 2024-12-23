package bancoimobiliario;

import java.util.Scanner;

public abstract class Propriedade extends Posicao{
    protected Jogador proprietario;
    protected int indice;

    public Propriedade(String nome, int indice) {
        super(nome);
        this.indice=indice;
    }

    public Jogador getProprietario() {
        return proprietario;
    }
    public boolean temProprietario(){
        return this.proprietario != null;

    }



    protected abstract boolean compra(Jogador nome);
    protected abstract boolean fazMelhoria(Jogador nome);
    protected abstract int getValor();

    protected abstract int getAluguel();

    @Override
    public void acao(Jogador nome){
        Scanner teclado = new Scanner(System.in);
        int res = 0;
        if(!temProprietario()){
            do{
                System.out.println(nome.getNome() + " voce possui R$" + nome.getSaldo() + ",00");
                System.out.println("Essa propriedade custa R$" + getValor());
                System.out.println("Voce gostaria de comprar essa propriedade?\nDigite 1 para SIM \n2 para NAO");

                res = teclado.nextInt(); //resposta do usuario
                if(res<1 || res >2){
                    System.out.println("Vc digitou um número incorreto. Tente novamente!");
                }
            }while(res<1 || res >2);
            switch(res){
                case 1:
                    // funcao compra
                    if(!compra(nome)){
                        System.out.println("Voce não tem dinheiro suficiente!");
                    }else{
                        System.out.println("Imóvel comprado!");
                    }
                    break;
                case 2:
                    System.out.println("Ok, então!");
                    break;
                //é isso
            }
        }else{
            if(this.proprietario== nome){
                int upgrade;
                do {
                    System.out.println("Você é o dono desta propiriedade.");
                    System.out.println("Voce gostaria de fazer uma melhoria?\n Digite 1 para SIM \n 2 para NÂO?");
                    upgrade = teclado.nextInt();
                    switch (upgrade) {
                        case 1:
                            fazMelhoria(nome);
                            break;
                        case 2:
                            System.out.println("Eita! Ta bom, ne?!");
                            break;
                        default:
                            System.out.println("Voce digitou um numero errado. Tente novamente!");
                    }
                }while(upgrade <1 || upgrade >2);
            }else if(this.proprietario!=null){
                System.out.println(nome.getNome()+ ", este lote e de: " + this.proprietario.getNome() +"\nVoce deve pagar o valor de R$" + getAluguel());
                if(nome.transferencia(getValor(),this.proprietario)){
                    System.out.println("Aluguel pago com sucesso!");

                 }else{
                    System.out.println(nome.getNome()+ ", você está quebrado! Foi eliminado do jogo.");
                    //implementar função que deleta jogador
                }
            }
        }
    }

}
