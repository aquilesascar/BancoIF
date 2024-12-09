package bancoimobiliario;

public class Companhia extends Propriedade{    
    private int valorCompanhia;
    private int aluguel;
    
    public Companhia(int valorCompanhia, String nome, int aluguel) {
        super(nome);
        this.valorCompanhia = valorCompanhia;
    } 
    
}
