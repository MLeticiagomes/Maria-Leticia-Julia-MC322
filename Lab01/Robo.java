public class Robo {
    
    private String  nome_do_robo;
    private int coordenada_x;
    private int coordenada_y; 

    public Robo(String nome, int x, int y){ /* cria um robo com nome e posição x e y */
        this.nome_do_robo = nome;
        this.coordenada_x = x;
        this.coordenada_y = y;

    }

    public int setCoordenadas_x(int deltax){ /* muda a coordenada x */
        this.coordenada_x += deltax;
        return coordenada_x;
        
    }

    public int setCoordenadas_y(int deltay){ /* muda a coordenada y */
        this.coordenada_y += deltay;
        return coordenada_y;
        
    }

    public void printar(){ /* printa as coordenadas */
    System.out.println("Nova posicao : (" + coordenada_x + "," + coordenada_y+ ")");
    }

}

