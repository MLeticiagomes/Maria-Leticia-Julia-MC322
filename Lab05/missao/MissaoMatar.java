package missao;
import environment.*;
import interfaces.*;
import robo.*;
import entidade.*;
import java.util.List;
/* o robo guerreiro tem a missao matar na qual seleciona um robo blindado da lista e o ataca ate que ele seja morto */
public class MissaoMatar implements Missao {
    @Override
    public void executar ( Robo r , Ambiente a ) {
      List <Entidade> ents = a.getEntidade();
        int alvoX = -1;
        int alvoY = -1;
        int alvoZ  = -1;
        RoboBlindado alvo = null; 
      for (int i = 0; i < ents.size(); i++) {
          Entidade entidade = ents.get(i);
          if (entidade.getEntidade() == TipoEntidade.ROBO){
            if( entidade instanceof RoboBlindado){
                 alvoX = entidade.getX();
                 alvoY = entidade.getY();
                 alvoZ = entidade.getZ();
                 alvo  = (RoboBlindado) entidade;
                break;
            }
            else{
                System.out.println("Não ha robos blindados nesse ambiente.");
            }
            
          }
      }
      if (r instanceof RoboGuerreiro) {
        if(alvo != null){
            while(alvo.getPontosVida()> 0){
                ((RoboGuerreiro) r).atacar(alvoX, alvoY, alvoZ);
            }
             System.out.println("Robo blindado destruido com sucesso.");
        }
        
                
                }
    }

}
