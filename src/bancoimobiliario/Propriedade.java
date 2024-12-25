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
    public void removeProprietario(Jogador proprietario){
        if(this.proprietario.equals(proprietario)){
            this.proprietario=null;

    }

    }

    protected abstract boolean compra(Jogador nome);

    protected abstract int valorAluguel(int dado);
    protected abstract void voceeProprietario(Jogador proprietario);
    protected abstract int getValor();



    @Override
    public boolean acao(Jogador nome, int dado){
        System.out.println(nome.getNome() + ", você caiu em " + super.getNome() + "\n");
        Scanner teclado = new Scanner(System.in);
        int res = 0;
        if(!temProprietario()){
            do{
                System.out.println("Voce possui R$" + nome.getSaldo() + ",00\n");
                System.out.println("Essa propriedade custa R$" + getValor() + ",00\n");
                System.out.println("Voce gostaria de comprar essa propriedade?\n\nDigite 1 para SIM \nDigite 2 para NAO");
               //Captura a resposta da usuário com verificação

                    res = teclado.nextInt(); //resposta do usuario

                    if (res < 1 || res > 2) {
                        System.out.println("Vc digitou um número incorreto. Tente novamente!");

                    }

            }while(res<1 || res >2);
            switch(res){
                case 1:
                    // funcao compra
                    if(!compra(nome)){
                        System.out.println("Voce não tem dinheiro suficiente!");

                    }else{
                        System.out.println("Imóvel comprado!\n");
                        System.out.println("Obrigado por comprar essa propriedade! Seu saldo é de: " + nome.getSaldo() + ",00");

                    }

                    return true;
                case 2:
                    System.out.println("Ok, então!");
                    return true;

                //é isso
            }
        }else{
            if(this.proprietario.equals(nome)){
                voceeProprietario(nome);
            }else if(this.proprietario!=null){
                System.out.println(nome.getNome()+ ", este lote e de: " + this.proprietario.getNome() +"\n\nVoce deve pagar o valor de R$" + valorAluguel(dado) + ",00");
                if(nome.transferencia(valorAluguel(dado),this.proprietario)){
                    System.out.println("Aluguel pago com sucesso!");
                    return true;

                 }else{
                    System.out.println(nome.getNome()+ ", você está quebrado! Foi eliminado do jogo.");
                    return false;
                    //implementar função que deleta jogador
                }
            }
        }
        return true;
    }

}
