import java.util.ArrayList;
import java.util.List;


public class RoboKamikaze extends RoboAereo{ //explode quando atacado eliminando os robos a sua volta
   private int raioDeAtaque;

   public RoboKamikaze(String nome, int x, int y, int z, String d, int alt_max, int raioDeAtaque){
       super(nome, x, y, z, d, alt_max);
       this.raioDeAtaque = raioDeAtaque;
  
   } 

   public int getRaioDeAtaque(){
        return raioDeAtaque;
   }


   int i = 0;
   public void sacrificio (){ /* verifica se existem robos  na esfera de ataque  e se tiver remove-os da lista */

    List<Entidade> ents = Ambiente.getEntidade();
    for (int i = 0; i < ents.size(); i++) {
        Entidade entidade = ents.get(i);
        if (entidade.getEntidade() == TipoEntidade.ROBO){ /* verifica se a entidade é do tipo robo, se for executa as funçoes */
            Robo robo = (Robo) entidade; 

            int posicaoX = this.getCoordenadaX();
            int posicaoZ = this.getCoordenadaZ();
            int posicaoY = this.getCoordenadaY();

           if (robo != this && Math.abs(robo.getCoordenadaX() - posicaoX) <= raioDeAtaque ){
               System.out.println("O robo " + robo.getNome() + " foi morto :)");
                Ambiente.removerEntidade(robo);
           }
           else if (robo != this && Math.abs(robo.getCoordenadaZ() - posicaoZ) <= raioDeAtaque ){
               System.out.println("O robo " + robo.getNome() + " foi morto :)");
                Ambiente.removerEntidade(robo);
           }
           else if (robo != this && Math.abs(robo.getCoordenadaY() - posicaoY) <= raioDeAtaque ){
               System.out.println("O robo " + robo.getNome() + " foi morto :)");
                Ambiente.removerEntidade(robo);

           }
        }   
    }
  }
}

