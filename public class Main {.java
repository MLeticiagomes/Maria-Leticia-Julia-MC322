public class Main {
    public static void main(String[] args){
        Robo robo = new Robo("Renaldo", 13, 4);
        Ambiente ambiente = new Ambiente(20, 20);
        
        robo.setCoordenadas(8, 7);

        if(ambiente.dentroDosLimites(int coordenada_x int coordenada_y) == true){
            robo.printar();
        }

        
    }
}
