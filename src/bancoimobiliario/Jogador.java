package bancoimobiliario;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogador{
    private String nome;//Nome do Jogador
    private int saldo; //Saldo do Jogador
    private int posicao; //Poisição do tabuleiro em que o Joagador está
    private ArrayList<Integer> propriedades; //propiredades que o Jogador adiquirir
    private boolean preso; //Variavel booleana que india se o jogador está na cadeia

    //Construtor que inicia todos os atributos de jaogador
    public Jogador(String nome) {
        this.nome = nome;
        this.saldo = 1500;
        this.posicao = 0;
        this.propriedades = new ArrayList<>();
        this.preso = false;
    }

    //Método que retorna a variavél preso
    public boolean isPreso() {
        return preso;
    }

    //Método que indica que o jogador está solto
    public void solta(){
        this.preso = false;
    }

    //Métdo que indica que o jogador está na cadeia
    public void prende(){
        this.preso = true;
    }

    public ArrayList<Integer> getPropriedades() {
        return propriedades;
    }

    //Método que adiciona propriedades adquiridas pelo jogador
    public void addPropriedade(int propriedade){
        this.propriedades.add(propriedade);
    }

    //Método que altera a posiçã do Jogador no tabuleiro
    public void alteraPosicao(int somaDados){
        this.posicao += somaDados;
    }

    //Método que verifica se o Jogador tem saldo suficiente
    public boolean verificaSaldo(int valor){
        if(this.saldo >= valor){
            return true;
        }
        return false;
    }
    //Método que faz tranferência de dinheiro para outro Jogador
    public boolean transferencia(int valor,Jogador beneficiario){
        if(this.verificaSaldo(valor)){
            this.atualizaSaldo(-valor);
            beneficiario.atualizaSaldo(valor);
            return true;
        }
        return false;
    }

    //Método que atualiza saldo do Jogador
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
