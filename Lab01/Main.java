import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao Simulador de Robos!\nVamos comecar criando um ambiente.\nDigite a largura e altura (separados por espaco):");
        int largura = scanner.nextInt();
        int altura = scanner.nextInt();
        Ambiente ambiente = new Ambiente(largura, altura); /* altura e largura do ambiente e criação de um novo robo*/
            
        while (true){
            System.out.println("O que deseja fazer?\nDigite 1 para criar novo robo\nDigite 2 para mover o robo\nDigite 0 para fechar o simulador");
            int comando=scanner.next();
            if (comando==1){
                System.out.println("Digite o nome, coordenada x, coordenada y e direcao (separadas por espaco):");
                String nome = scanner.next();
                int coordenadaX = scanner.nextInt(); 
                int coordenadaY = scanner.nextInt();
                String direcao = scanner.next(); 
                Robo robo = new Robo(nome, coordenadaX, coordenadaY, direcao); /* nome do robo, posição x e posicção y  e criação de um novo robo*/
            }
            else if (comando==2){
                while (true){
                    System.out.println("Digite a distancia percorrida e a direcao (separadas por espaco):");
                    int distancia=scanner.nextInt();
                    string direcao = scanner.next(); 
                    while (true){
                        if (direcao.equalsIgnoreCase("norte")|| direcao.equalsIgnoreCase("sul")){
                            int coordenada_y = robo.setCoordenadas_y(distancia); /* altera a posição do robo em y */
                            if(ambiente.dentroDosLimites(0, coordenada_y) == true);{ /* verifica se o robo esta dentro dos limites */
                                robo.printar();
                                break;
                            }
                        }
                        else if (direcao.equalsIgnoreCase("oeste")|| direcao.equalsIgnoreCase("leste")){
                            int coordenada_x = robo.setCoordenadas_x(distancia); /* altera a posiçõa do robo em x */
                            if(ambiente.dentroDosLimites(coordenada_x, 0) == true);{ /* verifica se o robo esta dentro dos limites */
                                robo.printar();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
