package bancoimobiliario;

public class Companhia extends Propriedade{    
    private int valorCompanhia;

    public Companhia(int valorCompanhia, String nome) {
        super(nome);
        this.valorCompanhia = valorCompanhia;
    } 
    
}
