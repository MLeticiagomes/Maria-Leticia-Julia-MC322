/*
SubClasse de RoboTerrestre- RoboBlindado
Objetivo: definir propriedas de RoboBlindado e consultar vida atual
*/
package robo;
import entidade.*;
import environment.*;
import interfaces.*;
import sensores.*;

public class RoboBlindado extends RoboTerrestre implements Sensoreavel, Camuflavel {
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

   @Override
   public void ativarCamuflagem() {
       TipoEntidade entidade=TipoEntidade.OBSTACULO;
       setTipoEntidade(entidade);
       System.out.println(getNome() + " se camuflou entre os obstaculos, boa sorte tentando localiza-lo!");
   }

   @Override
   public void desativarCamuflagem() {
       TipoEntidade entidade=TipoEntidade.ROBO;
       setTipoEntidade(entidade);
       System.out.println(getNome() + " desativou sua camuflagem e esta visivel novamente!");
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


