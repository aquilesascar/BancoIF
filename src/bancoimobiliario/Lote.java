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
    //função faz melhoria
    //verifica se a propriedadea já é um hotel e faz a conta
    //ex:valorAluguel = valorAluguel * melhoria


    @Override
    public boolean fazMelhoria(Jogador nome, int dado){
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
    protected int getValor() {
        return this.valor;    }




    @Override
    protected int getAluguel() {
        return this.aluguel;
    }


}
