package bancoimobiliario;

import java.util.Scanner;
// Classe abstrata Propriedade que herda de Posicao
public abstract class Propriedade extends Posicao{
    protected Jogador proprietario; //Proprietário da propriedade
    protected int indice; //Indice da propriedade no tabuleiro

    //Contrutor que indicia o indice e o nome
    public Propriedade(String nome, int indice) {
        super(nome);
        this.indice=indice;
    }

    //Método para obter o proprietario da propriedade
    public Jogador getProprietario() {

        return proprietario;
    }
    //Método para verificar se a propriedade tem proprietário
    public boolean temProprietario(){
        return this.proprietario != null;

    }
    //Metodo para remover um proprietário da propriedade
    public void removeProprietario(Jogador proprietario){
        if(this.proprietario.equals(proprietario)){
            this.proprietario=null;

    }

    }
    //Metodos abstratos que devem ser implementadodos nas subclasses
    protected abstract boolean compra(Jogador nome);
    protected abstract int valorAluguel(int dado);
    protected abstract void voceeProprietario(Jogador proprietario);
    protected abstract int getValor();


    //Método que define a ação realizada quando um jogador cai em uma propriedade(Lote
    @Override
    public boolean acao(Jogador nome, int dado){
        System.out.println(nome.getNome() + ", você caiu em " + super.getNome() + "\n");
        Scanner teclado = new Scanner(System.in);
        int res = 0;
        //Verifica se a propriedade não tem um proprietário
        if(!temProprietario()){
            do{
                //Exibe informações sobre a propriedade e o saldo do jogador
                System.out.println("Voce possui R$" + nome.getSaldo() + ",00\n");
                System.out.println("Essa propriedade custa R$" + getValor() + ",00\n");
                System.out.println("Voce gostaria de comprar essa propriedade?\n\nDigite 1 para SIM \nDigite 2 para NAO");
               //Captura a resposta da usuário com verificação

                    res = teclado.nextInt(); //resposta do usuario

                    if (res < 1 || res > 2) {
                        System.out.println("Vc digitou um número incorreto. Tente novamente!");

                    }

            }while(res<1 || res >2);
            //Processa a resposta do usuário
            switch(res){
                case 1:
                    // Tenta comprar uma propridade
                    if(!compra(nome)){
                        System.out.println("Voce não tem dinheiro suficiente!\n");
                        System.out.println("-------------------");
                        return true;

                    }else{
                        System.out.println("Imóvel comprado!\n");
                        System.out.println("Obrigado por comprar essa propriedade! Seu saldo é de: " + nome.getSaldo() + ",00");
                        System.out.println("-------------------");
                        return true;
                    }

                case 2:
                    System.out.println("Ok, então!");
                    return true;


            }
        }else{
            //Verifica se o jogador é o proprietário da propriedade
            if(this.proprietario.equals(nome)){
                //Método abstrato, impelementado nas subclasses, que fornece uma possível melhoria para a propriedade
                voceeProprietario(nome);
                //Caso a propriedade tenha um propietario que nao é o atual jogador
            }else if(this.proprietario!=null){
                //Jogador deve pagar o aluguel ao proprietario
                System.out.println(nome.getNome()+ ", este lote e de: " + this.proprietario.getNome() +"\n\nVoce deve pagar o valor de R$" + valorAluguel(dado) + ",00");
                //Método que verificará se o jogador tem condiçoes de pagar o aluguel
                if(nome.transferencia(valorAluguel(dado),this.proprietario)){
                    System.out.println("Aluguel pago com sucesso!\n");
                    System.out.println("-------------------");
                    return true;

                 }else{
                    System.out.println(nome.getNome()+ ", você está quebrado! Foi eliminado do jogo.");
                    return false;

                }
            }
        }
        return true;
    }

}
