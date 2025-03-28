import java.util.List;


public class RoboCurandeiro extends RoboAereo{
   private int poderDeCura;


   public RoboCurandeiro(tring nome, int x, int y, String d, int alt, int alt_max, int poderDeCura){
       super(d, x, y, d, alt, alt_max);
       this.poderDeCura = poderDeCura;
   }


   @Override
   public int getCoordenadaX() { /* pega a coordenada x do robo */
       return super.getCoordenadaX();
   }
 


   public void verificarPosicaoX(List <robosAtivos>robos){
       int posicaoX = this.getCoordenadaX(); /* verifica se um robo na lista esta na mesma posicao x do robo curandeiro */
       for (Robo robo : robos){
           if (robo != this && robo.getCoordenadaX() == posicaoX){
               if(robo instanceof RoboBlindado){ /* verifica se o robo e um robo blindado */
                   if(checarVida == true){ /* se for verdadeiro adiciona vida */
                       RoboBlindado.pontosVida += poderDeCura;
                       System.out.println("Robo" + RoboBlindado.nome + "esta com"  + RoboBlindado.pontosVida + "xp.");
                   }


                   else{
                       System.out.println("Robo" + RoboBlindado.nome + "esta com a vida maxima permitida." );
                   }
                  
               }
          
           }
       }


   }


   public Boolean checarVida (RoboBlindado pontosVida){ /* verifica se a vida do robo mais os pontos de cura nao excede a vida maxima permitida  */
       if (RoboBlindado.pontosVida += poderDeCura < RoboBlindado.vidaMax){
           return true;
       }


       else{
           return false;
       }
   }






  
}


