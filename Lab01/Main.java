public class Main {
    public static void main(String[] args){
        Robo robo = new Robo("Robo1", 13, 4); /* nome do robo, posição x e posicção y  e criação de um novo robo*/
        Ambiente ambiente = new Ambiente(20, 20); /* altura e largura do ambiente e criação de um novo robo*/
        
        
        int coordenada_x = robo.setCoordenadas_x(2); /* altera a posiçõa do robo em x */
        int coordenada_y = robo.setCoordenadas_y(2); /* altera a posição do robo em y */
        if(ambiente.dentroDosLimites(coordenada_x, coordenada_y) == true);{ /* verifica se o robo esta dentro dos limites */
            robo.exibir_posicao();
        }

        
    }
}
