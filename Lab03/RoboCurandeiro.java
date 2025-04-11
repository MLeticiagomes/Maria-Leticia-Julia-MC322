import java.util.List;


public class RoboCurandeiro extends RoboAereo{ //cura robos em seu eixo y
   private int poderDeCura;


   public RoboCurandeiro(String nome, int x, int y,  int z, String d, int alt_max, int poderDeCura){
       super(nome, x, y, z, d, alt_max);
       this.poderDeCura = poderDeCura;
   }


   @Override
   public int getCoordenadaX() { /* pega a coordenada x do robo */
       return super.getCoordenadaX();
   }


   @Override
   public int getCoordenadaZ() { /* pega a coordenada z do robo */
       return super.getCoordenadaZ();
   }


   public Boolean checarVida (RoboBlindado blindado){ /* verifica se a vida do robo mais os pontos de cura nao excede a vida maxima permitida  */
       int pontosV = blindado.getPontosVida();
       int pontosVMax =  blindado.getVidaMax();
       if (pontosV + this.poderDeCura <= pontosVMax){
           return true;
       }


       else{
           return false;
           }
   }


   public void verificarPosicaoZ(){
       int posicaoZ = this.getCoordenadaZ();
       for (Robo robo : Ambiente.getrobosAtivos()){
           if (robo != this && robo.getCoordenadaZ() == posicaoZ){
               verificarPosicaoX();
           }
       }


   }






   public void verificarPosicaoX(){
       int posicaoX = this.getCoordenadaX(); /* verifica se um robo na lista esta na mesma posicao x do robo curandeiro */
       for (Robo robo : Ambiente.getrobosAtivos()){
           if (robo != this && robo.getCoordenadaX() == posicaoX){
               if(robo instanceof RoboBlindado){ /* verifica se o robo e um robo blindado */
                   RoboBlindado blindado = (RoboBlindado) robo;
                   blindado.consultarVida();
                   if(checarVida(blindado) == true){ /* se for verdadeiro adiciona vida */
                       blindado.cura(poderDeCura);
                       System.out.println("Robo " + blindado.getNome() + " esta com "  + blindado.getPontosVida()+ " xp.");
                   }
                   else{
                       System.out.println("Robo " + blindado.getNome() + " esta com a vida maxima permitida." );
                   }
                  
               }
          
           }
       }
   }
}
