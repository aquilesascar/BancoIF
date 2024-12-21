package bancoimobiliario;

import java.util.Scanner;
//estelaaaaa

public class Lote extends Propriedade{
    private int valor;
    private int aluguel;
    private int pousada;
    private int hotel;
    
    public boolean temProprietario(){
        if(super.proprietario == null){
            return false;
        }
        return true;
    }
    
    public boolean compra(Jogador comprador){
        if(comprador.verificaSaldo(this.valor)){
            comprador.decrementaSaldo(this.valor);
            this.proprietario = comprador;
            return true;
        }
        return false;
    }
    
    
    
    public void acao(Jogador nome){
        Scanner teclado = new Scanner(System.in);
        int res = 0;
        if(!temProprietario() ){
            do{
            System.out.println(nome.getNome()+" voce gostaria de comprar essa propriedade?\nDigite 1 para SIM \n2 para NAO");
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
            }
        }else{
            System.out.println("Este lote e de: " + this.proprietario.getNome() +"\nVoce deve pagar o valor de R$" + this.aluguel);
            if(nome.verificaSaldo(this.aluguel)){
                nome.decrementaSaldo(this.aluguel);
                System.out.println(nome.getNome() + ", seu novo saldo é R$" + nome.getSaldo());
            }
        }
    }
    

    public Lote(int valor, String nome, int aluguel, int pousada, int hotel) {
        super(nome);
        this.valor = valor;
        this.aluguel = aluguel;
        this.pousada = pousada;
        this.hotel = hotel;
    }
    
}
