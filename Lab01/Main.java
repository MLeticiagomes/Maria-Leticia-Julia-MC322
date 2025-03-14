public class Main {
    public static void main(String[] args){
        Robo robo = new Robo("Renaldo", 13, 4);
        Ambiente ambiente = new Ambiente(20, 20);
        
        
        int coordenada_x = robo.setCoordenadas_x(8);
        int coordenada_y = robo.setCoordenadas_y(7);;
        if(ambiente.dentroDosLimites(coordenada_x, coordenada_y) == true);{
            robo.printar();
        }

        
    }
}
