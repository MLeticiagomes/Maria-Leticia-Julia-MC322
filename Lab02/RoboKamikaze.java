import java.util.ArrayList;
import java.util.List;

public class RoboKamikaze extends RoboAereo{
    private int raioDeAtaque;


    public RoboKamikaze(String nome, int x, int y, String d, int alt_max, int raioDeAtaque){
        super(d, x, y, d, alt_max);
        this.raioDeAtaque = raioDeAtaque;
    
    }

   @Override
   public int getCoordenadaX() { /* pega a coordenada x do robo */
       return super.getCoordenadaX();
   }

   @Override
   public int getCoordenadaY() { /* pega a coordenada y do robo */
       return super.getCoordenadaY();
   }
 
    int i = 0;
    public void sacrificio (){ /* verifica se existem rofos  na circunferencia de ataque  e se tiver remove-os da lista */
        List<Robo> robos = Ambiente.getrobosAtivos();
    
        for (int i = 0; i < robos.size(); i++) {
            Robo robo = robos.get(i);

            int posicaoX = this.getCoordenadaX();

            if (robo != this && robo.getCoordenadaX() <=  posicaoX + raioDeAtaque ){
                robos.remove(i);
                System.out.println("O robo" + robo.getNome() + " foi morto :)");

            }

            else if (robo != this && robo.getCoordenadaX() <=  posicaoX  - raioDeAtaque ){
                robos.remove(i);
                System.out.println("O robo" + robo.getNome() + " foi morto :)");
            }

            else if (robo != this && robo.getCoordenadaY() <=  posicaoX + raioDeAtaque ){
                robos.remove(i);
                System.out.println("O robo" + robo.getNome() + " foi morto :)");

            }

            else if (robo != this && robo.getCoordenadaY() <=  posicaoX  - raioDeAtaque ){
                robos.remove(i);
                System.out.println("O robo" + robo.getNome() + " foi morto :)");

            }

            i++;
        }  
        
    }
}