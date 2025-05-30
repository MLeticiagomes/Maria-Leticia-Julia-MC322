/*
SubClasse de RoboTerrestre- RoboBlindado
Objetivo: definir propriedas de RoboBlindado e consultar vida atual
*/

import java.util.List;

public class RoboBlindado extends RoboTerrestre {
   private int pontosVida; // o quanto de dano o robo ainda pode receber
   private int vidaMax;

   public RoboBlindado(String nome, int x,int y, int z, String d, int velocidadeMax, int vidaMax) {
       super(nome, x,y, z, d, velocidadeMax);
       this.pontosVida = vidaMax;
       this.vidaMax =vidaMax;
   }

   public int getPontosVida() {
       return pontosVida;
   }

   public int cura(int cura) {
       pontosVida +=cura;
       return pontosVida;
   }

   public int dano(int dano) { //recebe dano e diminiu pontos de vida
       pontosVida -= dano;
       return pontosVida;
   }

   public int getVidaMax() {
       return vidaMax;
   }

   public void consultarVida(){ //retorna a quantiade de vida atual
       System.out.println("Vida restante " + pontosVida);
   }
}


