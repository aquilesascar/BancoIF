package bancoimobiliario;

import java.util.Scanner;

public class Lote extends Propriedade{
    private int valor;
    private int aluguel;
    private int melhoria;

    public boolean temProprietario(){
        if(super.proprietario == null){
            return false;
        }
        return true;
    }
    
    public boolean compra(Jogador comprador){
        if(comprador.verificaSaldo(this.valor)){
            comprador.atualizaSaldo(-this.valor);
            this.proprietario = comprador;
            return true;
        }
        return false;
    }
    //função faz melhoria
    //verifica se a propriedadea já é um hotel e faz a conta
    //ex:valorAluguel = valorAluguel * melhoria
    public boolean fazMelhoria(Jogador nome){
        if(this.melhoria>10){
            System.out.println("Esta propridade já é um hotel. Não pode mais ser melhorada.");
            return false;
        }
        //verifica se o jogador tem saldo
        if (nome.verificaSaldo(this.aluguel)){
            this.aluguel=this.aluguel*this.melhoria;
            this.melhoria+=7;
            System.out.println("Melhoria feita. Agora seu aluguel é R$" + this.aluguel + ",00");
            return true;

        }
        return false;
    }
    
    
    public void acao(Jogador nome){
        Scanner teclado = new Scanner(System.in);
        int res = 0;
        if(!temProprietario()){
            do{
            System.out.println(nome.getNome() + " voce possui R$" + nome.getSaldo() + ",00");
            System.out.println("Essa propriedade custa R$" + valor);
            System.out.println("Voce gostaria de comprar essa propriedade?\nDigite 1 para SIM \n2 para NAO");

            res = teclado.nextInt(); //resposta do usuario
            if(res<1 || res >2){
                System.out.println("Vc digitou um numero incorreto. Tente novamente!");
            }
            }while(res<1 || res >2);
            switch(res){
                case 1: 
                    // funcao compra
                    if(!compra(nome)){
                        System.out.println("Voce não tem dinheiro suficiente!");
                    }else{
                        System.out.println("Imovel comprado!");
                    }
                    break;
                case 2:
                    System.out.println("Ok, então!");
                    break;
                    //é isso
            }
        }else{
            if(this.proprietario.equals(nome)){
                int upgrade;
                do {
                    System.out.println("Voce gostaria de fazer uma melhoria?\n Digite 1 para SIM \n 2 para NAO?");
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
            }
            System.out.println("Este lote e de: " + this.proprietario.getNome() +"\nVoce deve pagar o valor de R$" + this.aluguel);
            if(nome.verificaSaldo(this.aluguel)){
                nome.atualizaSaldo(-this.aluguel);
                System.out.println(nome.getNome() + ", seu novo saldo é R$" + nome.getSaldo());
            }
        }
    }

    public Lote(int valor, String nome, int aluguel) {
        super(nome);
        this.valor = valor;
        this.aluguel = aluguel;
        this.melhoria= 3;
    }
    
}
