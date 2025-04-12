import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;




public class Robo {
   private Scanner scanner = new Scanner(System.in);
   private String  nome_do_robo;
   private int coordenada_x;
   private int coordenada_y;
   private int coordenada_z;
   private String direcao;
   private Ambiente ambiente;
   private static ArrayList<Sensor> sensoresDosRobos;

   public Robo(String nome, int x,  int y, int z, String d){ /* cria um robo com nome e posição x e y */
       this.nome_do_robo = nome;
       this.coordenada_x = x;
       this.coordenada_y = y;
       this.coordenada_z = z;
       this.direcao = d;
       Ambiente.adicionarRobo(this);
       sensoresDosRobos = new ArrayList<>();
   }

   public static void adicionarSensor(Sensor s){
        sensoresDosRobos.add(s);
   }


   public static ArrayList<Sensor> getsensoresDosRobos(){
    return sensoresDosRobos;
}

   public String getNome(){
       return nome_do_robo;
   }


   public int setCoordenadas_x_mais(int deltax){ /* muda a coordenada x */


       this.coordenada_x += deltax;
       return coordenada_x;
      
   }


   public int setCoordenadas_x_menos(int deltax){ /* muda a coordenada x */


       this.coordenada_x -= deltax;
       return coordenada_x;
      
   }




   public int setCoordenadas_z_mais(int deltaz){ /* muda a coordenada z */


       this.coordenada_z += deltaz;
       return coordenada_z;
      
   }


   public int setCoordenadas_z_menos(int deltaz){ /* muda a coordenada z */


       this.coordenada_z -= deltaz;
       return coordenada_z;
      
   }


   public void exibir_posicao(int coordenada_y){ /* printa as coordenadas */
   System.out.println("Nova posicao : (" + coordenada_x + "," + coordenada_y +  "," + coordenada_z + ")");
   }


   public int getCoordenadaX(){
       return coordenada_x;
   }

   public int getCoordenadaY(){
        return coordenada_y;
    }

   public int getCoordenadaZ(){
       return coordenada_z;
   }




   public void mover(Ambiente ambiente, String direcao, int distancia){


       while (true){ /*altera as coordenadas do robo */
           if (this instanceof RoboAereo){
               RoboAereo roboAereo = (RoboAereo) this;
               if (direcao.equalsIgnoreCase("norte")){
                  
                   if(ambiente.dentroDosLimites(coordenada_x,  coordenada_z+distancia)==true){
                       setCoordenadas_z_mais(distancia); /* altera a posição do robo em z */
                       if(this instanceof RoboTerrestre){
                           exibir_posicao(0);
                           break;
                       }
                       else{


                       }
                    
                   }
                   else{
                       break;
                   }
               }
               else if (direcao.equalsIgnoreCase("sul")){
                   if(ambiente.dentroDosLimites(coordenada_x, coordenada_z-distancia)==true){
                       setCoordenadas_z_menos(distancia); /* altera a posição do robo em z */
                       if(this instanceof RoboTerrestre){
                           exibir_posicao(0);
                           break;
                       }
                       else{
                          
                       }
                   }


                   else{
                       break;
                   }
               }
           }
           else if (direcao.equalsIgnoreCase("oeste")){
               if(ambiente.dentroDosLimites(coordenada_x-distancia, coordenada_z)==true){
                   setCoordenadas_x_menos(distancia); /* altera a posição do robo em x */
                   if(this instanceof RoboTerrestre){
                           exibir_posicao(0);
                           break;
                       }
                       else{
                          
                       }
               }
               else{
                   break;
               }
           }
           else if (direcao.equalsIgnoreCase("leste")){
               if(ambiente.dentroDosLimites(coordenada_x+distancia, coordenada_z)==true){
                   setCoordenadas_x_mais(distancia); /* altera a posição do robo em z */
                   if(this instanceof RoboTerrestre){
                       exibir_posicao(0);
                       break;
                   }
                   else{
                      
                   }
               }
               else{
                   break;
               }
           }
       }
   }


  
  
}
