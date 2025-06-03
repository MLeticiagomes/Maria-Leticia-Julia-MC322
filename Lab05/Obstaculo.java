import java.util.List;

public class Obstaculo implements Entidade{

    private int coordenada_x1;
    private int coordenada_x2;
    private int coordenada_z1;
    private int coordenada_z2;
    private int altura;
    private TipoObstaculo tipo;
    private TipoEntidade entidade = TipoEntidade.OBSTACULO;

   public Obstaculo(int x1, int x2, int z1, int z2, int altura, TipoObstaculo tipo){
       this.coordenada_x1 = x1;
       this.coordenada_x2 = x2;
       this.coordenada_z1 = z1;
       this.coordenada_z2 = z2;
       this.altura = altura;
       this.tipo = tipo;
   }


   public TipoObstaculo getTipo(){
    return tipo;
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

    public int setCoordenada_x(int x){
        this.coordenada_x1  = x;
        return coordenada_x1;
    }

    public int setCoordenada_z(int z){
        this.coordenada_z1 = z;
        return coordenada_z1;
    }

    public int setAltura(int y){
        this.altura = y;
        return altura;
    }

    @Override
    public int getX(){
        return ((getCoordenadaX1()+getCoordenadaX2())/2); /*referente ao centro do objeto */
    }

    @Override
    public int getY(){
        return getAltura();
    }

    @Override
    public int getZ(){
        return ((getCoordenadaZ1()+getCoordenadaZ2())/2);
    }

    @Override
    public TipoEntidade getEntidade(){
        return entidade;
    }

    @Override
    public String getDescricao(){
        return "Obstaculo: " + tipo + "\n Pertence ao tipo de entidade Obstaculo \n Um obstaculo pode ou nao bloquear a passagem de um Robo";
    }
    
    @Override
    public char getRepresentacao(){
        return '▲';
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

}

