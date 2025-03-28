/*
SubClasse de RoboTerrestre- RoboBlindado
Objetivo: definir propriedas de RoboBlindado e consultar vida atual
*/

import java.util.List;

public class RoboBlindado extends Robo {
    private int pontosVida; // o quanto de dano o robo ainda pode receber
    private int vidaMax;
    

    public RoboBlindado(String nome, int x, int y, String d, int vidaMax) {
        super(nome, x, y, d);
        this.inimigosDerrotados = 0;
        this.pontosVida = vidaMax;
        this.vidaMax =vidaMax;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public int setPontosVida(int cura) {
        pontosVida+=cura;
        return pontosVida;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void consultarVida(){
        System.out.println("Vida restante" + pontosVida);
    }
}
