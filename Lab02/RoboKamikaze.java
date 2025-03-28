import java.util.List;

public class RoboKamikaze extends RoboAereo{
    private int raioDeAtaque;


    public RoboKamikaze(tring nome, int x, int y, String d, int alt, int alt_max, int raioDeAtaque){
        super(d, x, y, d, alt, alt_max);
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
    public void sacrificio (List <robosAtivos>robos){ /* verifica se existem rofos  na circunferencia de ataque  e se tiver remove-os da lista */
        for (Robo robo : Ambiente.getrobosAtivos()){
            int posicaoX = this.getCoordenadaX();
            if (robo != this && robo.getCoordenadaX() <=  posicaoX + raioDeAtaque ){
                robosAtivos.remove(i);
                System.out.println("O robo" + robo.nome + " foi morto :)");

            }

            else if (robo != this && robo.getCoordenadaX() <=  posicaoX  - raioDeAtaque ){
                robosAtivos.remove(i);
                System.out.println("O robo" + robo.nome + " foi morto :)");
            }

            else if (robo != this && robo.getCoordenadaY() <=  posicaoX + raioDeAtaque ){
                robosAtivos.remove(i);
                System.out.println("O robo" + robo.nome + " foi morto :)");

            }

            else if (robo != this && robo.getCoordenadaY() <=  posicaoX  - raioDeAtaque ){
                robosAtivos.remove(i);
                System.out.println("O robo" + robo.nome + " foi morto :)");

            }

            i++;
        }  
        
    }
}