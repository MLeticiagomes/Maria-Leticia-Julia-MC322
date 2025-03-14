public class Robo {
    
    private String  nome_do_robo;
    private int coordenada_x;
    private int coordenada_y; 

    public Robo(String nome, int x, int y){
        this.nome_do_robo = nome;
        this.coordenada_x = x;
        this.coordenada_y = y;

    }

    public int setCoordenadas_x(int deltax){
        this.coordenada_x += deltax;
        return coordenada_x;
        
    }

    public int setCoordenadas_y(int deltay){
        this.coordenada_y += deltay;
        return coordenada_y;
        
    }

    public void printar(){
    System.out.println("Nova posicao : (" + coordenada_x + "," + coordenada_y+ ")");
    }

}

