package bancoimobiliario;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogador{
    private String nome;
    private int saldo;
    private int posicao;
    private ArrayList<Integer> propriedades;

    public Jogador(String nome) {
        this.nome = nome;
        this.saldo = 1500;
        this.posicao =0;
        this.propriedades = new ArrayList<>();
    }

    public ArrayList<Integer> getPropriedades() {
        return propriedades;
    }

    public void addPropriedade(int propriedade){
        this.propriedades.add(propriedade);
    }



    public String cadastrarJogador(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do jogador: ");
        return  nome = sc.nextLine();
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
    
}
