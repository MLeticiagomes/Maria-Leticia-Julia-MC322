public class Robo {
    
    private String  nome_do_robo;
    private int coordenada_x;
    private int coordenada_y; 

    public Robo(String nome, int x, int y){
        this.nome_do_robo = nome;
        this.coordenada_x = x;
        this.coordenada_y = y;

    }

    public int setCoordenadas(int deltax, int deltay){
        this.coordenada_x += deltax;
        this.coordenada_y += deltay;
        
    }

    public void printar(){
    System.out.println("Nova posicao : (" + coordenada_x + "," + coordenada_y+ ")");
    }

}

