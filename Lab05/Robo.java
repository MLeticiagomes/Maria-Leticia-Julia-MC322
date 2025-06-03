import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/*a classe robo é abstract permitindo chamar funções especificas de sub tipos */
public abstract class Robo implements Entidade{
   private Scanner scanner = new Scanner(System.in);
   private String  id;
   private int coordenada_x;
   private int coordenada_y;
   private int coordenada_z;
   private String direcao;
   private Ambiente ambiente;
   private ArrayList<Sensor> sensoresDosRobos;
   private TipoEntidade entidade = TipoEntidade.ROBO;
   private EstadoRobo estado;


   public Robo(String nome, int x,  int y, int z, String d){ /* cria um robo com nome e posição x e y */
       this.id = nome;
       this.coordenada_x = x;
       this.coordenada_y = y;
       this.coordenada_z = z;
       this.direcao = d;
       this.estado = EstadoRobo.DESLIGADO;
       sensoresDosRobos = new ArrayList<>();
   }

   public void adicionarSensor(Sensor s){
        sensoresDosRobos.add(s);
   }


   public ArrayList<Sensor> getsensoresDosRobos(){
    return sensoresDosRobos;
   }

   public void setTipoEntidade(TipoEntidade TipoEntidade){
    this.entidade= TipoEntidade;
   }

   public String getDirecao(){
    return direcao;
   }

   public String getNome(){
       return id;
   }

    public int setCoordenada_x(int x){
        this.coordenada_x  = x;
        return coordenada_x;
    }

    public int setCoordenada_z(int z){
        this.coordenada_z = z;
        return coordenada_z;
    }

    public int setCoordenada_y(int y){
        this.coordenada_y = y;
        return coordenada_y;
    }

   public int getX(){
        return coordenada_x;
    }

    public int getY(){
        return coordenada_y;
    }

    public int getZ(){
        return coordenada_z;
    }

    @Override
    public TipoEntidade getEntidade(){
        return entidade;
    }

    @Override
    public String getDescricao(){
        return "Robo: " + id + "\n Pertence ao tipo de entidade Robo \n Um robo pode se mover no ambiente, utilizar sensores e ativar habilidades especificas de sua subclasse";
    }
    
    @Override
    public char getRepresentacao(){
        return '□';
    }

   public void exibir_posicao(){ /* printa as coordenadas */
        System.out.println("Nova posicao : (" + coordenada_x + "," + coordenada_y +  "," + coordenada_z + ")");
    }

    public void ligar() {
        estado = EstadoRobo.LIGADO;
        System.out.println("Robô " + id + " foi ligado.");
    }

    public void desligar() {
        estado = EstadoRobo.DESLIGADO;
        System.out.println("Robô " + id + " foi desligado.");
    }

    public EstadoRobo getEstado(){
        return estado;
    }

    public void moverPara(int x, int y, int z) throws RoboDesligadoException , ForaDosLimitesException {
        if (this.getEstado() == EstadoRobo.DESLIGADO) {
            throw new RoboDesligadoException(
                "O robô " + this.getNome() + " está desligado, você não pode movê-lo."
            );
        }
    
        if (ambiente.dentroDosLimites(x, z)) {
                setCoordenada_x(x);
                setCoordenada_z(z);
    
                if (y != 0) { // Se y for diferente de 0, verificar se é aéreo
                    if (this instanceof RoboAereo) {
                        RoboAereo roboAereo = (RoboAereo) this;
                        if (roboAereo.verificarAlturaMax()) {
                            setCoordenada_y(y);
                        } else {
                            System.out.println("Altura máxima excedida.");
                        }
                    } else {
                        System.out.println("Robôs terrestres não podem se mover no eixo y.");
                    }
                } else {
                    setCoordenada_y(y);
                }
            
        } 
    }
    
    public abstract void executarTarefa();
  
}
   
 

