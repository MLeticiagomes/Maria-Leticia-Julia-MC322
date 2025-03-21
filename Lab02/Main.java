import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in); /*Introduz simulador */
        System.out.println("Bem vindo ao Simulador de Robos!\nVamos comecar criando um ambiente.\nDigite a largura e altura (separados por espaco):");
        int largura = scanner.nextInt(); /*leitura de dados para criacao do ambiente */
        int altura = scanner.nextInt();
        Ambiente ambiente = new Ambiente(largura, altura); 
        Robo robo= null;
            
        while (true){ /*Introduz comandos do simulador */
            System.out.println("O que deseja fazer?\nDigite 1 para criar novo robo\nDigite 2 para mover o robo\nDigite 0 para fechar o simulador");
            int comando=scanner.nextInt();

            if (comando==1){ /*Leitura de dados e criacao de novo robo */
                System.out.println("Digite o nome, coordenada x, coordenada y e direcao (separadas por espaco):");
                String nome = scanner.next();
                int coordenadaX = scanner.nextInt(); 
                int coordenadaY = scanner.nextInt();
                String direcao = scanner.next(); 
                robo = new Robo(nome, coordenadaX, coordenadaY, direcao); /* nome do robo, posição x e posicção y  e criação de um novo robo*/
            }
            else if (comando==2){ /*Leitura de dados e movimentacao do robo */
                if (robo == null) {
                    System.out.println("Nenhum robô criado ainda! Crie um antes de mover.");
                    continue;
                }
                System.out.println("Digite a direcao (separadas por espaco):");
                String direcao = scanner.next(); 
                robo.verificar_direcao(direcao); /*Verifica se existe algum obstaculo na direcao escolhida */

                System.out.println("Digite a distancia percorrida (separadas por espaco):");
                int distancia=scanner.nextInt();

                while (true){ /*altera as coordenadas do robo */
                    int x=robo.getCoordenadaX();
                    int y=robo.getCoordenadaY();
                    if (direcao.equalsIgnoreCase("norte")){
                        if(ambiente.dentroDosLimites(x, y+distancia)==true){
                            robo.setCoordenadas_y(distancia); /* altera a posição do robo em y */
                            robo.exibir_posicao();
                                break;
                        }
                        else{
                            break;
                        }
                    }
                    else if (direcao.equalsIgnoreCase("sul")){
                        if(ambiente.dentroDosLimites(x, y-distancia)==true){
                            robo.setCoordenadas_y(distancia); /* altera a posição do robo em y */
                            robo.exibir_posicao();
                                break;
                        }
                        else{
                            break;
                        }
                    }
                    else if (direcao.equalsIgnoreCase("oeste")){
                        if(ambiente.dentroDosLimites(x-distancia, y)==true){
                            robo.setCoordenadas_x(distancia); /* altera a posição do robo em y */
                            robo.exibir_posicao();
                                break;
                        }
                        else{
                            break;
                        }
                    }
                    else if (direcao.equalsIgnoreCase("leste")){
                        if(ambiente.dentroDosLimites(x+distancia, y)==true){
                            robo.setCoordenadas_x(distancia); /* altera a posição do robo em y */
                            robo.exibir_posicao();
                                break;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            else if (comando==0){ /*Fecha o simulador */
                System.out.println("Encerrando o simulador...");
                scanner.close();
                break;
            } 
        }
    }
}
