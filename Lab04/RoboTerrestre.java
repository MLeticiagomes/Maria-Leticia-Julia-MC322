public abstract class RoboTerrestre extends Robo { /* robo terrestre com uma velocidade maxima */

    private int velocidadeMaxima;


    public RoboTerrestre(String nome, int x,int y, int z, String d, int v){
        super(nome,x,0,z,d);
        this.velocidadeMaxima = v;
    }



    public int getvelocidadeMaxima(){
        return velocidadeMaxima;
    }
    
    
    public boolean verificar_velocidade(int velocidadeMaxima, int velocidade){ //verifica se o num de blocos que deseja andar nao excede a velocidade maxima
        if(velocidade < velocidadeMaxima){
            return true;
        }

        else{
            System.out.println("Velocidade acima do permitido :(");
            return false;
        }
    }




}
