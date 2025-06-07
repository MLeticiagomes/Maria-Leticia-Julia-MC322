package missao;
import entidade.*;
import environment.*;
import java.util.List;
import robo.*;
/* o robo guerreiro tem a missao matar na qual seleciona um robo blindado da lista e o ataca ate que ele seja morto */
public class MissaoMatar implements Missao {
   private LogMissao log;

    public MissaoMatar(LogMissao l){
        this.log=l;
    }

    @Override
    public void executar ( Robo r , Ambiente a ) {
      LogMissao log = a.getLog(); // log será fornecido pelo ambiente
      log.registrar("Início da missão matar do robô " + r.getNome());
      
      List <Entidade> ents = Ambiente.getEntidade();
        int alvoX = -1;
        int alvoY = -1;
        int alvoZ  = -1;
        RoboBlindado alvo = null; 
      for (int i = 0; i < ents.size(); i++) {
          Entidade entidade = ents.get(i);
          if (entidade.getEntidade() == TipoEntidade.ROBO){
            if(entidade instanceof RoboBlindado){
                 alvoX = entidade.getX();
                 alvoY = entidade.getY();
                 alvoZ = entidade.getZ();
                 alvo  = (RoboBlindado) entidade;
                break;
            }
            else{
                log.registrar(("Não ha robos blindados nesse ambiente"));
                System.out.println("Não ha robos blindados nesse ambiente.");
            }
            
          }
      }
      if (r instanceof RoboGuerreiro) {
        if(alvo != null){
            while(alvo.getPontosVida()> 0){
                ((RoboGuerreiro) r).atacar(alvoX, alvoY, alvoZ);
            }
            log.registrar(("Robo blindado morto na posicao ("+ alvoX +  "," + alvoY  +"," + alvoZ + ")." ));
             System.out.println("Robo blindado destruido com sucesso.");
        } 
      }
      log.registrar("Missão matar finalizada para robô " + r.getNome());
    }
}
