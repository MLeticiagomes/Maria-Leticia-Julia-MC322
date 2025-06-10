package robo;
import entidade.*;
import environment.*;
import java.util.Scanner;
import missao.*;
import modulos.ControleMovimento;
import modulos.GerenciadorSensores;
import modulos.ModuloComunicacao;

/*a classe robo é abstract permitindo chamar funções especificas de sub tipos */
public abstract class Robo implements Entidade{
    protected Missao missao;
    private Scanner scanner = new Scanner(System.in);
    private String  id;
    private int coordenada_x;
    private int coordenada_y;
    private int coordenada_z;
    private String direcao;
    private Ambiente ambiente;
    private TipoEntidade entidade = TipoEntidade.ROBO;
    private EstadoRobo estado;
    private ControleMovimento controleMovimento;
    private GerenciadorSensores gerenciadorSensores;
    private ModuloComunicacao moduloComunicacao;


   public Robo(String nome, int x,  int y, int z, String d){ /* cria um robo com nome e posição x e y */
       this.id = nome;
       this.coordenada_x = x;
       this.coordenada_y = y;
       this.coordenada_z = z;
       this.direcao = d;
       this.estado = EstadoRobo.DESLIGADO;
       this.controleMovimento = new ControleMovimento(this, ambiente);
       this.gerenciadorSensores = new GerenciadorSensores();
       this.moduloComunicacao = new ModuloComunicacao(this);
   }

    public ControleMovimento getControleMovimento() {
        return controleMovimento;
    }

    public GerenciadorSensores getGerenciadorSensores() {
        return gerenciadorSensores;
    }

    public ModuloComunicacao getModuloComunicacao() {
        return moduloComunicacao;
    }

   public void setMissao(Missao missao) {
        this.missao = missao;
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
    
    public abstract void executarTarefa();
  
}
   
 

