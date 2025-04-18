/*
Classe Ambiente
Objetivo: definir propriedas do ambiente e analisar limites
*/
/* largura = x, comprimento = z, altura = y */
import java.util.ArrayList;


public class Ambiente {
   private int largura;
   private int altura;
   private int comprimento;
   private static ArrayList<Robo> robosAtivos;
   private static ArrayList<Obstaculo> obstaculosExistentes;


   public Ambiente(int l, int a, int c){
       this.largura=l;
       this.altura=a;
       this.comprimento = c;
       robosAtivos = new ArrayList<>();
       obstaculosExistentes = new ArrayList<>();
   }


   public int getAltura(){
       return this.altura;
   }


   public int getLargura(){
       return this.largura;
   }


   public int getComprimento(){
       return this.comprimento;
   }


   public boolean dentroDosLimites(int x,int z){ /*verifica se nova coordenada do robo esta dentro do ambiente */
       if (x<0 || z < 0){
           System.out.println("Insira apenas coordenadas positivas!");
           return false;
       }
       else if (x<largura && z<comprimento){
           return true;
       }
       else if (x>largura){
           System.out.println("Largura fora dos limites :(");
           return false;
       }


       else if (z>comprimento){
           System.out.println("Comprimento fora dos limites :(");
           return false;
       }
       else{
           System.out.println("Altura fora dos limites :(");
           return false;
       }
   }


   public boolean dentroDaAltura(int y){
       if(y < 0){
           System.out.println("Insira apenas coordenadas positivas!");
           return false;
       }
       else if (y < altura){
           return true;
       }


       else {
           System.out.println("Altura fora dos limites :(");
           return false;
       }


   }


   public static void adicionarRobo(Robo r){ /*adiciona novo robo na lista de robos */
       robosAtivos.add(r);
   }


   public static void removerRobo(Robo r){
       robosAtivos.remove(r);
   }
  
   public static ArrayList<Robo> getrobosAtivos(){
       return robosAtivos;
   }

   public static void adicionarObstaculo(Obstaculo o){ /*adiciona novo robo na lista de robos */
    obstaculosExistentes.add(o);
   }

   public static ArrayList<Obstaculo> getobstaculosExistentes(){
    return obstaculosExistentes;
}


}







