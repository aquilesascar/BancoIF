package bancoimobiliario;

public class Tabuleiro{
    private Posicao posicoes[];

    public Tabuleiro() {
        this.posicoes = new Posicao[40];
        
        this.posicoes[0] = new Fixo(200, "Inicio");
        this.posicoes[1] = new Lote(80,"Leblon");
        //this.posicoes[2] = new Sortereves();
        this.posicoes[3] = new Lote(80, "Av. Presidente Vargas");
        this.posicoes[4] = new Lote(80, "Av. Nossa Senhora de Copacabana");
        this.posicoes[5] = new Companhia(200, "Companhia Ferroviaria");
        this.posicoes[6] = new Lote(110, "Av. Brigadeiro Faria Lima");
        this.posicoes[7] = new Companhia(200, "Companhia de Viacao");
        this.posicoes[8] = new Lote(110, "Av. Reboucas");
        this.posicoes[9] = new Lote(110, "Av. 9 de Julho");
        this.posicoes[10] = new Posicao("Cadeia");
        this.posicoes[11] = new Lote(100, "Av. Europa");
        //this.posicoes[12] = new Sortereves();
        this.posicoes[13] = new Lote(100, "Rua Augusta");
        this.posicoes[14] = new Lote(100, "Avenida Pacaembu");
        this.posicoes[15] = new Companhia(200, "Companhia de Taxi");
        //this.posicoes[16] = new Sortereves();
        this.posicoes[17] = new Lote(250, "Interlagos");
        this.posicoes[18] = new Fixo(200, "Lucros ou Dividendos");
        this.posicoes[19] = new Lote(250, "Morumbi");
        this.posicoes[20] = new Posicao("Parada Livre");
        this.posicoes[21] = new Lote(100, "Bangu");
        //this.posicoes[22] = new Sortereves();
        this.posicoes[23] = new Lote(100, "Botafogo");
        this.posicoes[24] = new Fixo(-200, "Imposto de Renda");
        this.posicoes[25] = new Companhia(200, "Companhia de Navegacao");
        this.posicoes[26] = new Lote(110, "Av. Brasil");
        //this.posicoes[27] = new Sortereves();
        this.posicoes[28] = new Lote(110, "Av. Paulista");
        this.posicoes[29] = new Lote(110, "Jardim Europa");
        this.posicoes[30] = new Posicao("Va para a prisao");
        this.posicoes[31] = new Lote(170, "Copacabana");
        this.posicoes[32] = new Companhia(200, "Companhia de Aviacao");
        this.posicoes[33] = new Lote(170, "Av. Vieira Souto");
        this.posicoes[34] = new Lote(170, "Av. Atlantica");
        this.posicoes[35] = new Companhia(200, "Companhia de Taxi Aereo");
        this.posicoes[36] = new Lote(170, "Ipanema ");
        //this.posicoes[37] = new Sortereves();
        this.posicoes[38] = new Lote(190, "Jardim Paulista");
        this.posicoes[39] = new Lote(190, "Brooklin");
        
    }
    
}
