package bancoimobiliario;

public class Tabuleiro {

    protected Posicao posicoes[];

    public void iniciarJogo() {
        //ainda a implementar
    }

    public Tabuleiro() {
        this.posicoes = new Posicao[40];

        this.posicoes[0] = new Fixo(200, "Inicio");
        this.posicoes[1] = new Lote(80, "Leblon", 8, 24, 240);
        //this.posicoes[2] = new Sortereves();
        this.posicoes[3] = new Lote(80, "Av. Presidente Vargas", 6, 18, 180);
        this.posicoes[4] = new Lote(80, "Av. Nossa Senhora de Copacabana", 7, 21, 210);
        this.posicoes[5] = new Companhia(200, "Companhia Ferroviaria", 50);
        this.posicoes[6] = new Lote(110, "Av. Brigadeiro Faria Lima", 13, 39, 390);
        this.posicoes[7] = new Companhia(200, "Companhia de Viacao", 40);
        this.posicoes[8] = new Lote(110, "Av. Reboucas", 11, 33, 330);
        this.posicoes[9] = new Lote(110, "Av. 9 de Julho", 12, 36, 360);
        this.posicoes[10] = new Posicao("Cadeia");
        this.posicoes[11] = new Lote(100, "Av. Europa", 10, 30, 300);
        //this.posicoes[12] = new Sortereves();
        this.posicoes[13] = new Lote(100, "Rua Augusta", 9, 27, 270);
        this.posicoes[14] = new Lote(100, "Avenida Pacaembu", 10, 30, 300);
        this.posicoes[15] = new Companhia(200, "Companhia de Taxi", 40);
        //this.posicoes[16] = new Sortereves();
        this.posicoes[17] = new Lote(250, "Interlagos", 35, 105, 1050);
        this.posicoes[18] = new Fixo(200, "Lucros ou Dividendos");
        this.posicoes[19] = new Lote(250, "Morumbi", 50, 150, 1500);
        this.posicoes[20] = new Posicao("Parada Livre");
        this.posicoes[21] = new Lote(100, "Bangu", 11, 33, 330);
        //this.posicoes[22] = new Sortereves();
        this.posicoes[23] = new Lote(100, "Botafogo", 10, 30, 300);
        this.posicoes[24] = new Fixo(-200, "Imposto de Renda");
        this.posicoes[25] = new Companhia(200, "Companhia de Navegacao", 40);
        this.posicoes[26] = new Lote(110, "Av. Brasil", 13, 39, 390);
        //this.posicoes[27] = new Sortereves();
        this.posicoes[28] = new Lote(110, "Av. Paulista", 15, 45, 450);
        this.posicoes[29] = new Lote(110, "Jardim Europa", 12, 36, 360);
        this.posicoes[30] = new Posicao("Va para a prisao");
        this.posicoes[31] = new Lote(170, "Copacabana", 21, 63, 630);
        this.posicoes[32] = new Companhia(200, "Companhia de Aviacao", 50);
        this.posicoes[33] = new Lote(170, "Av. Vieira Souto", 23, 69, 690);
        this.posicoes[34] = new Lote(170, "Av. Atlantica", 23, 69, 690);
        this.posicoes[35] = new Companhia(200, "Companhia de Taxi Aereo", 50);
        this.posicoes[36] = new Lote(170, "Ipanema", 22, 66, 660);
        //this.posicoes[37] = new Sortereves();
        this.posicoes[38] = new Lote(190, "Jardim Paulista", 28, 84, 840);
        this.posicoes[39] = new Lote(190, "Brooklin", 22, 66, 660);

    }

}
