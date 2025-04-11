import java.util.ArrayList;
import java.util.List;


public class RoboKamikaze extends RoboAereo{ //explode quando atacado eliminando os robos a sua volta
   private int raioDeAtaque;




   public RoboKamikaze(String nome, int x, int y, int z, String d, int alt_max, int raioDeAtaque){
       super(nome, x, y, z, d, alt_max);
       this.raioDeAtaque = raioDeAtaque;
  
   } 


   int i = 0;
   public void sacrificio (){ /* verifica se existem robos  na esfera de ataque  e se tiver remove-os da lista */
       List<Robo> robos = Ambiente.getrobosAtivos();
       for (int i = 0; i < robos.size(); i++) {
           Robo robo = robos.get(i);


           int posicaoX = this.getCoordenadaX();
           int posicaoZ = this.getCoordenadaZ();
           int posicaoY = this.getCoordenadaY();


           if (robo != this && Math.abs(robo.getCoordenadaX() - posicaoX) <= raioDeAtaque ){
               System.out.println("O robo " + robo.getNome() + " foi morto :)");
               Ambiente.removerRobo(robo);
           }


           else if (robo != this && Math.abs(robo.getCoordenadaZ() - posicaoZ) <= raioDeAtaque ){
               System.out.println("O robo " + robo.getNome() + " foi morto :)");
               Ambiente.removerRobo(robo);
           }
           else if (robo != this && Math.abs(robo.getCoordenadaY() - posicaoY) <= raioDeAtaque ){
               System.out.println("O robo " + robo.getNome() + " foi morto :)");
               Ambiente.removerRobo(robo);


           }
       } 
      
   }
}

