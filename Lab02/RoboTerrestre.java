public class RoboTerrestre extends Robo {

    private int velocidadeMaxima;


    public RoboTerrestre(String nome, int x, int y, String d, int v){
        super(nome,x,y,d);
        this.velocidadeMaxima = v;
    }



    public int getvelocidadeMaxima(){
        return velocidadeMaxima;
    }
    
    
    public boolean verificar_velocidade(int velocidadeMaxima, int velocidade){
        if(velocidade < velocidadeMaxima){
            return true;
        }

        else{
            System.out.println("Velocidade acima do permitido :(");
            return false;
        }
    }




}
