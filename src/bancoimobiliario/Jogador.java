package bancoimobiliario;

public class Jogador{
    private String nome;
    private int saldo;
    
    public boolean verificaSaldo(int valor){
        if(this.saldo >= valor){
            return true;
        }
        return false;
    }
    
    public void decrementaSaldo(int valor){
        this.saldo = this.saldo - valor;
        
    }
    
    public Jogador(String nome) {
        this.nome = nome;
        this.saldo = 1500;
    }

    public int getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }
    
}
