package bancoimobiliario;

import java.util.Scanner;

public class Lote extends Propriedade{
    private int valor;
    private int aluguel;
    private int melhoria;
    private int indice;

    public Lote(int valor, String nome, int aluguel, int indice) {
        super(nome, indice);
        this.valor = valor;
        this.aluguel = aluguel;
        this.melhoria= 3;
        this.indice = indice;
    }


    @Override
    public boolean compra(Jogador comprador){
        if(comprador.verificaSaldo(this.valor)){
            comprador.atualizaSaldo(-this.valor);
            this.proprietario = comprador;
            comprador.addPropriedade(super.indice);
            return true;
        }
        return false;
    }

    @Override
    protected int valorAluguel(int dado) {
        return this.aluguel;
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



    @Override
    protected void voceeProprietario(Jogador proprietario) {
        Scanner teclado = new Scanner(System.in);
        int upgrade;
        do {
            System.out.println("Você é o dono desta propiriedade.");
            System.out.println("Voce gostaria de fazer uma melhoria?\n Digite 1 para SIM \n 2 para NÂO?");
            upgrade = teclado.nextInt();
            switch (upgrade) {
                case 1:
                    fazMelhoria(proprietario);

                case 2:
                    System.out.println("Eita! Ta bom, ne?!");

                default:
                    System.out.println("Voce digitou um numero errado. Tente novamente!");
            }
        }while(upgrade <1 || upgrade >2);
    }

    @Override
    protected int getValor() {
        return this.valor;
    }


}
