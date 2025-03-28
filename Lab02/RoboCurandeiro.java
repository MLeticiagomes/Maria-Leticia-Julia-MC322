import java.util.List;

public class RoboCurandeiro extends RoboAereo{
  private int poderDeCura;




  public RoboCurandeiro(string nome, int x, int y, String d, int alt_max, int poderDeCura){
      super(nome, x, y, d, y, alt_max);
      this.poderDeCura = poderDeCura;
  }




  @Override
  public int getCoordenadaX() { /* pega a coordenada x do robo */
      return super.getCoordenadaX();
  }




  public void verificarPosicaoX(ArrayList<Robo> robosAtivos){
      int posicaoX = this.getCoordenadaX(); /* verifica se um robo na lista esta na mesma posicao x do robo curandeiro */
      for (Robo robo : robos){
          if (robo != this && robo.getCoordenadaX() == posicaoX){
              if(robo instanceof RoboBlindado){ /* verifica se o robo e um robo blindado */
                  if(checarVida == true){ /* se for verdadeiro adiciona vida */
                       int pontos =  RoboBlindado.getpontosVida();
                       pontos += poderDeCura;
                       System.out.println("Robo" + RoboBlindado.nome + "esta com"  + RoboBlindado.getpontosVida()+ "xp.");
                  }




                  else{
                      System.out.println("Robo" + RoboBlindado.nome + "esta com a vida maxima permitida." );
                  }
                
              }
        
          }
      }




  }




  public Boolean checarVida (RoboBlindado pontosVida){ /* verifica se a vida do robo mais os pontos de cura nao excede a vida maxima permitida  */
       int pontosV =  RoboBlindado.getpontosVida();
       int pontosVMax =  RoboBlindado.getvidaMax();
       if (pontosV + poderDeCura < pontosVMax){
          return true;
      }




      else{
          return false;
      }
  }












 }
