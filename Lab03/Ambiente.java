/*
Classe Ambiente
Objetivo: definir propriedas do ambiente e analisar limites
*/
/* largura = x, comprimento = z, altura = y */
import java.util.ArrayList;
import java.util.List;


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

public boolean detectarColisoes(int xDestino, int zDestino, int alturaRobo){
     List<Obstaculo> obstaculos = Ambiente.getobstaculosExistentes();
        
        for (int i = 0; i < obstaculos.size(); i++) {
            Obstaculo obstaculo = obstaculos.get(i);
            int x1 = obstaculo.getCoordenadaX1();
            int x2 = obstaculo.getCoordenadaX2(); 
            int z1 = obstaculo.getCoordenadaZ1();
            int z2 = obstaculo.getCoordenadaZ2();
    
            int xMin = Math.min(x1, x2); /* calcula o min e max entre os pontos */
            int xMax = Math.max(x1, x2);
            int zMin = Math.min(z1, z2);
            int zMax = Math.max(z1, z2);
    
            boolean dentroDaBase = (xDestino >= xMin && xDestino <= xMax && /* verifica se o ponto de destino é maior que o minimo e menor que o maximp */
                                    zDestino >= zMin && zDestino <= zMax);
    
            int alturaObstaculo = obstaculo.getTipo().getTamanhoVertical(); 
            int yMin = obstaculo.getAltura();
            int yMax = yMin + alturaObstaculo;
    
            boolean dentroDaAltura = (alturaRobo >= yMin && alturaRobo <= yMax); /* verifica se o ponto y esta entre a base e a altura do objeto */
            boolean podeAtravessar = obstaculo.getTipo().getpodeAtravessar();
    
            if (dentroDaBase && dentroDaAltura && !podeAtravessar) { /* se estiver dentro da base, da altura e nao puder atravessar o objeto ele retorna true */
                System.out.println("O robô irá colidir com o obstáculo: " + obstaculo.getTipo());
                return true;
            }
        }
    
        return false;
    }

}







