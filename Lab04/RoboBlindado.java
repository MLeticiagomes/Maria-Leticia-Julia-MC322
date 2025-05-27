/*
SubClasse de RoboTerrestre- RoboBlindado
Objetivo: definir propriedas de RoboBlindado e consultar vida atual
*/

import java.util.List;

public class RoboBlindado extends RoboTerrestre implements Sensoreavel {
   private int pontosVida; // o quanto de dano o robo ainda pode receber
   private int vidaMax;

   public RoboBlindado(String nome, int x,int y, int z, String d, int velocidadeMax, int vidaMax) {
       super(nome, x,y, z, d, velocidadeMax);
       this.pontosVida = vidaMax;
       this.vidaMax =vidaMax;
   }

   @Override
   public void acionarSensores(Sensor sensor,Robo robo_i){ /*verifica se esta ligado para ativacao dos sensores */
      if(getEstado()==EstadoRobo.LIGADO){
        System.out.println("Robo ligado, ativacao autorizada!");
        Ambiente.executarSensores(sensor, robo_i);
      }
      else{
        System.out.println("Robo desligado, ativacao nao autorizada!");
      }
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

   @Override
   public void executarTarefa() {
       consultarVida();
   }
}


