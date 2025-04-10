public class Obstaculo {

    private String  nome_do_objeto;
    private int coordenada_x;
    private int coordenada_y;


   public Obstaculo(String nome, int x, int y){
       this.nome_do_objeto = nome;
       this.coordenada_x = x;
       this.coordenada_y = 0;
       Ambiente.adicionarObstaculo(this);


   }


   public int getCoordenadaX() {
       return coordenada_x;
   }


}

