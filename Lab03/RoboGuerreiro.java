/*
SubClasse de RoboTerrestre- RoboGuerreiro
Objetivo: definir propriedas de RoboGuerreiro e realizar ataques
*/


import java.util.List;


public class RoboGuerreiro extends RoboTerrestre {
   private int inimigosDerrotados;
   private int dano;


   public RoboGuerreiro(String nome, int x, int z, String d, int velocidadeMax, int dano) {
       super(nome, x, z, d, velocidadeMax);
       this.inimigosDerrotados = 0;
       this.dano = dano;
   }


   public void atacar(int alvoX, int alvoY, int alvoZ) {
       List<Robo> robos = Ambiente.getrobosAtivos();
  
       for (int i = 0; i < robos.size(); i++) {
           Robo robo = robos.get(i);
  
           if (robo.getCoordenadaX() == alvoX && roboaereo.getCoordenadaY() == alvoY && robo.getCoordenadaZ() == alvoZ ) { /* verifica se existe um robo na posicao */
  
               if (robo instanceof RoboBlindado) { /* verifica se o tipo de robo e blindado e tira pontos de vida */
                   RoboBlindado blindado = (RoboBlindado) robo;
                   int novaVida = blindado.getPontosVida() - dano;
  
                   if (novaVida > 0) {
                       blindado.dano(dano);
                       System.out.println("Ataque realizado! Vida restante do robô blindado: " + blindado.getPontosVida());
                   } else {
                       Ambiente.removerRobo(robo);
                       inimigosDerrotados++;
                       System.out.println("O RoboBlindado foi destruído!");
                   }
               }
               else if (robo instanceof RoboKamikaze) {  /* verifica se o robo e kamikaze , se for ativa a função de auto destruicao do robo */
                   System.out.println("O robô kamikaze foi destruído!");
                   ((RoboKamikaze) robo).sacrificio();
                   Ambiente.removerRobo(robo);


                   inimigosDerrotados++;
               }
               else {
                   Ambiente.removerRobo(robo);
                   inimigosDerrotados++;
                   System.out.println("O robô em (" + alvoX + ", " + alvoY + ", " + alvoY +") foi destruído!");
               }
               return;
           }
       }
       System.out.println("Nenhum robô encontrado na posição (" + alvoX + ", " + alvoY + ", " + alvoZ + ").");
   }
}


