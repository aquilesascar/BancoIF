package bancoimobiliario;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogador{
    private String nome;
    private int saldo;
    private int posicao;
    private ArrayList<Integer> propriedades;
    private boolean preso;

    public Jogador(String nome) {
        this.nome = nome;
        this.saldo = 1500;
        this.posicao =0;
        this.propriedades = new ArrayList<>();
        this.preso = false;
    }

    public boolean isPreso() {
        return preso;
    }

    public void solta(){
        this.preso = false;
    }

    public void prende(){
        this.preso = true;
    }

    public ArrayList<Integer> getPropriedades() {
        return propriedades;
    }

    public void addPropriedade(int propriedade){
        this.propriedades.add(propriedade);
    }

    public void alteraPosicao(int somaDados){
        this.posicao += somaDados;
    }

    
    public boolean verificaSaldo(int valor){
        if(this.saldo >= valor){
            return true;
        }
        return false;
    }
    public boolean transferencia(int valor,Jogador beneficiario){
        if(this.verificaSaldo(valor)){
            this.atualizaSaldo(-valor);
            beneficiario.atualizaSaldo(valor);
            return true;
        }
        return false;
    }
    
    public void atualizaSaldo(int valor){
        this.saldo = this.saldo + valor;
        
    }

    public int getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public int getPosicao() {
        return posicao;
    }
}
