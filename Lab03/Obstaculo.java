import java.util.List;

public class Obstaculo {

    private int coordenada_x1;
    private int coordenada_x2;
    private int coordenada_z1;
    private int coordenada_z2;
    private int altura;
    private TipoObstaculo tipo;

   public Obstaculo(int x1, int x2, int z1, int z2, int altura, TipoObstaculo tipo){
       this.coordenada_x1 = x1;
       this.coordenada_x2 = x2;
       this.coordenada_z1 = z1;
       this.coordenada_z2 = z2;
       this.altura = altura;
       this.tipo = tipo;
   }

   public int getCoordenadaX1() {
    return coordenada_x1;
   }

    public int getCoordenadaX2() {
        return coordenada_x2;
    }

    public int getCoordenadaZ1() {
        return coordenada_z1;
    }

    public int getCoordenadaZ2() {
        return coordenada_z2;
    }

    public int getAltura() {
        return altura;
    }

    public TipoObstaculo getTipo() {
        return tipo;
    }

   public enum TipoObstaculo{
        BURACO(0, false), /* tamanho vertical do objeto */
        ROCHA(2,false),
        BALAO(3, false),
        NUVEM(2,true),
        PREDIO(5,false);

        private final int tamanhoVertical;
        private final boolean podeAtravessar;

        TipoObstaculo(int tamanhoVertical, boolean podeAtravessar){
            this.tamanhoVertical = tamanhoVertical;
            this.podeAtravessar = podeAtravessar;
        }

        public int getTamanhoVertical(){
            return tamanhoVertical;
        }

        public boolean getpodeAtravessar(){
            return podeAtravessar;
        }
    }

    /* criar metodo do obstaculo para impedir que o robo va para aquela posicao  */
    



}

