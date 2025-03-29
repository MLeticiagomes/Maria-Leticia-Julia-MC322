import java.util.Scanner;
import java.util.List;


public class Robo {
    private Scanner scanner = new Scanner(System.in);

    private String  nome_do_robo;
    private int coordenada_x;
    private int coordenada_y; 
    private String direcao;
    private Ambiente ambiente;

    public Robo(String nome, int x, int y, String d){ /* cria um robo com nome e posição x e y */
        this.nome_do_robo = nome;
        this.coordenada_x = x;
        this.coordenada_y = y;
        this.direcao = d;
        Ambiente.adicionarRobo(this);
    }

    public String getNome(){
        return nome_do_robo;
    }

    public int setCoordenadas_x_mais(int deltax){ /* muda a coordenada x */

        this.coordenada_x += deltax;
        return coordenada_x;
        
    }

    public int setCoordenadas_x_menos(int deltax){ /* muda a coordenada x */

        this.coordenada_x -= deltax;
        return coordenada_x;
        
    }


    public int setCoordenadas_y_mais(int deltay){ /* muda a coordenada y */
        this.coordenada_y += deltay;
        return coordenada_y;
        
    }

    public int setCoordenadas_y_menos(int deltay){ /* muda a coordenada x */

        this.coordenada_y -= deltay;
        return coordenada_y;
        
    }


    public void exibir_posicao(){ /* printa as coordenadas */
    System.out.println("Nova posicao : (" + coordenada_x + "," + coordenada_y+ ")");
    }
 

    public int getCoordenadaX(){
        return coordenada_x;
    }

    public int getCoordenadaY(){
        return coordenada_y;
    }

    public void mover(Ambiente ambiente, String direcao, int distancia){

        while (true){ /*altera as coordenadas do robo */
            if (direcao.equalsIgnoreCase("norte")){
                if(ambiente.dentroDosLimites(coordenada_x, coordenada_y+distancia)==true){
                    setCoordenadas_y_mais(distancia); /* altera a posição do robo em y */
                    exibir_posicao();
                        break;
                }
                else{
                    break;
                }
            }
            else if (direcao.equalsIgnoreCase("sul")){
                if(ambiente.dentroDosLimites(coordenada_x, coordenada_y-distancia)==true){
                    setCoordenadas_y_menos(distancia); /* altera a posição do robo em y */
                    exibir_posicao();
                        break;
                }
                else{
                    break;
                }
            }
            else if (direcao.equalsIgnoreCase("oeste")){
                if(ambiente.dentroDosLimites(coordenada_x-distancia, coordenada_y)==true){
                    setCoordenadas_x_menos(distancia); /* altera a posição do robo em y */
                    exibir_posicao();
                        break;
                }
                else{
                    break;
                }
            }
            else if (direcao.equalsIgnoreCase("leste")){
                if(ambiente.dentroDosLimites(coordenada_x+distancia, coordenada_y)==true){
                    setCoordenadas_x_mais(distancia); /* altera a posição do robo em y */
                    exibir_posicao();
                        break;
                }
                else{
                    break;
                }
            }
        }
    }

    public void verificar_direcao(String direcao){
        if(direcao.equalsIgnoreCase("norte")){
            identificar_obstaculos_N(coordenada_x);

        }
        else if(direcao.equalsIgnoreCase("sul")){
            identificar_obstaculos_S(coordenada_x);

        }
        else if(direcao.equalsIgnoreCase("leste")){
            identificar_obstaculos_L(coordenada_y);

        }

        else{
            identificar_obstaculos_O(coordenada_y);

        }
    }
    
    public int calcular_distancia(int coord_r , int coord_obs){
        return Math.abs(coord_r - coord_obs);
        
    }



    public void identificar_obstaculos_N(int posicao_ocupada){
        for(Robo robo : Ambiente.getrobosAtivos()){
            if(robo.getCoordenadaX() == posicao_ocupada && robo.getCoordenadaY() > this.coordenada_y){
                
                int dist  = calcular_distancia( this.coordenada_y,robo.getCoordenadaY());

                System.out.println("Obstaculo acima a" + dist + "unidades.");
            }
        }

    }

    public void identificar_obstaculos_S(int posicao_ocupada) {
        for (Robo robo : Ambiente.getrobosAtivos()) {
            if (robo.getCoordenadaX() == posicao_ocupada && robo.getCoordenadaY() < this.coordenada_y) {
                int dist = calcular_distancia(this.coordenada_y, robo.getCoordenadaY());
                System.out.println("Obstáculo abaixo a " + dist + " unidades.");
            }
        }
    }
    public void identificar_obstaculos_L(int posicao_ocupada) {
        for (Robo robo : Ambiente.getrobosAtivos()) {
            if (robo.getCoordenadaY() == posicao_ocupada && robo.getCoordenadaX() > this.coordenada_x) {
                int dist = calcular_distancia(this.coordenada_x, robo.getCoordenadaX());
                System.out.println("Obstáculo à direita a " + dist + " unidades.");
            }
        }
    }

    public void identificar_obstaculos_O(int posicao_ocupada) {
        for (Robo robo : Ambiente.getrobosAtivos()) {
            if (robo.getCoordenadaY() == posicao_ocupada && robo.getCoordenadaX() < this.coordenada_x) {
                int dist = calcular_distancia(this.coordenada_x, robo.getCoordenadaX());
                System.out.println("Obstáculo à esquerda a " + dist + " unidades.");
            }
        }
    }
    
}