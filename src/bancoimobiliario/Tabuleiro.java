package bancoimobiliario;
import java.util.Scanner;

public class Tabuleiro {
    // Guarda a lista de jogadores
    private Jogador[] jogadores;
    // Guarda as casas do tabuleiro
    private Posicao posicoes[];
    // Diz quantos jogadores tem na partida
    private int numJogadores;

    //método para pegar a lista de jogadores
    public Jogador[] getJogadores() {
        return jogadores;
    }

    // Método para pegar a lista de casas
    public Posicao[] getPosicoes() {
        return posicoes;
    }

    // Método para adicionar jogadores
    public void addJogador() {
        Scanner sc = new Scanner(System.in);

        // Pede o número de jogadores até ser um número bom (entre 2 e 6)
        do {
            System.out.println("Digite o número de jogadores de 2 a 6: ");
            this.numJogadores= sc.nextInt();
            if (this.numJogadores < 2 || this.numJogadores > 6) {
                System.out.println("O mínimo de jogadores é 2 e máximo 6!");
            }
        }while(this.numJogadores<2 || this.numJogadores>6);

        // Cria um espaço para guardar os jogadores
        this.jogadores = new Jogador[this.numJogadores];
        System.out.println("Digite o nome dos Jogadores");
        sc.nextLine(); // Limpa o "enter" que ficou da linha de cima
        // Pede o nome de cada jogador e cria um novo jogador para ele
        for (int i = 0; i < this.numJogadores; i++) {
            this.jogadores[i]= new Jogador(sc.nextLine());
        }
    }

    // Método para tirar um jogador do jogo
    public void removeJogador(Jogador j) {
        // Olha as propriedades do jogador que vai sair
        for(int i: j.getPropriedades()){
            // Se a casa for uma propriedade (lote ou companhia)
            if(this.posicoes[i] instanceof Propriedade){
                // Tira o jogador da lista de donos daquela propriedade
                ((Propriedade) this.posicoes[i]).removeProprietario(j);
            }
        }
        // Procura o jogador na lista e tira ele de lá
        for(int i=0;i<this.jogadores.length;i++){
            if(this.jogadores[i]!=null && this.jogadores[i].equals(j)){
                this.jogadores[i]=null; // Tira o jogador
                this.numJogadores--; // Diminui o número de jogadores
            }
        }
    }

    // Método para saber quantos jogadores tem
    public int getNumJogadores() {
        return numJogadores;
    }

    // Método que cria o tabuleiro quando o jogo começa
    public  Tabuleiro() {
        this.numJogadores=0; // Começa com zero jogadores
        this.posicoes = new Posicao[40]; // Cria 40 espaços para as casas

        // Cria as casas do tabuleiro (Lotes, Companhias, etc)
        this.posicoes[0] = new Fixo(200, "Inicio");
        this.posicoes[1] = new Lote(80, "Leblon", 8,1);
        this.posicoes[2] = new Sortereves();
        this.posicoes[3] = new Lote(80, "Av. Presidente Vargas", 6,3);
        this.posicoes[4] = new Lote(80, "Av. Nossa Senhora de Copacabana", 7,4);
        this.posicoes[5] = new Companhia(200, "Companhia Ferroviaria", 50,5);
        this.posicoes[6] = new Lote(110, "Av. Brigadeiro Faria Lima", 13,6);
        this.posicoes[7] = new Companhia(200, "Companhia de Viacao", 40,7);
        this.posicoes[8] = new Lote(110, "Av. Reboucas", 11,8);
        this.posicoes[9] = new Lote(110, "Av. 9 de Julho", 12,9);
        this.posicoes[10] = new Cadeia("Cadeia");
        this.posicoes[11] = new Lote(100, "Av. Europa", 10,11);
        this.posicoes[12] = new Sortereves();
        this.posicoes[13] = new Lote(100, "Rua Augusta", 9,13);
        this.posicoes[14] = new Lote(100, "Avenida Pacaembu", 10,14);
        this.posicoes[15] = new Companhia(200, "Companhia de Taxi", 40,15);
        this.posicoes[16] = new Sortereves();
        this.posicoes[17] = new Lote(250, "Interlagos", 35,17);
        this.posicoes[18] = new Fixo(200, "Lucros ou Dividendos");
        this.posicoes[19] = new Lote(250, "Morumbi", 50,19);
        this.posicoes[20] = new Fixo(0,"Parada Livre");
        this.posicoes[21] = new Lote(100, "Bangu", 11,21);
        this.posicoes[22] = new Sortereves();
        this.posicoes[23] = new Lote(100, "Botafogo", 10,23);
        this.posicoes[24] = new Fixo(200, "Imposto de Renda");
        this.posicoes[25] = new Companhia(200, "Companhia de Navegacao", 40,25);
        this.posicoes[26] = new Lote(110, "Av. Brasil", 13,26);
        this.posicoes[27] = new Sortereves();
        this.posicoes[28] = new Lote(110, "Av. Paulista", 15,28);
        this.posicoes[29] = new Lote(110, "Jardim Europa", 12,29);
        this.posicoes[30] = new Cadeia("Va para a prisao");
        this.posicoes[31] = new Lote(170, "Copacabana", 21,31);
        this.posicoes[32] = new Companhia(200, "Companhia de Aviacao", 50,32);
        this.posicoes[33] = new Lote(170, "Av. Vieira Souto", 23,33);
        this.posicoes[34] = new Lote(170, "Av. Atlantica", 23,34);
        this.posicoes[35] = new Companhia(200, "Companhia de Taxi Aereo", 50,35);
        this.posicoes[36] = new Lote(170, "Ipanema", 22,36);
        this.posicoes[37] = new Sortereves();
        this.posicoes[38] = new Lote(190, "Jardim Paulista", 28,38);
        this.posicoes[39] = new Lote(190, "Brooklin", 22,39);
    }

}
