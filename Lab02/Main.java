import java.util.List;
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
           System.out.println("O que deseja fazer?\nDigite 1 para criar novo robo\nDigite 2 para selecionar o robo\nDigite 0 para fechar o simulador");
           int comando=scanner.nextInt();


           if (comando==1){ /*Leitura de dados e criacao de novo robo */

               System.out.println("Digite um nome e direcao (separados por espaco):");
               String nome = scanner.next();
               String direcao = scanner.next();

               System.out.println("Que tipo de robo deseja criar?\nDigite t para criar um robo terrestres\nDigite a para criar um robo aereo");
               String tipo_de_robo=scanner.next();

               if(tipo_de_robo.equals("t")){
                   System.out.println("Digite a velocidade maxima de deslocamento desejada e coordenada x:");
                   int velocidadeMaxima=scanner.nextInt();
                   int coordenadaX = scanner.nextInt();
                   if(coordenadaX > ambiente.getLargura()){
                        System.out.println("Coordenada fora do permitido, coloque uma nova coordenada x");
                        coordenadaX = scanner.nextInt();
                   }
                   int coordenadaY =0;

                   System.out.println("Que tipo de robo terrestre deseja criar?\nDigite g para criar um robo guerreiro \nDigite b para criar um robo blindado");
                   String tipo_de_terrestre=scanner.next();

                   if(tipo_de_terrestre.equals("g")){
                       System.out.println("Digite a quantidade de dano de ataque desejado:");
                       int dano = scanner.nextInt();
                       robo = new RoboGuerreiro(nome, coordenadaX, coordenadaY, direcao, velocidadeMaxima, dano);
                       continue;
                   }

                   else if(tipo_de_terrestre.equals("b")){
                       System.out.println("Digite a quantidade de vida desejada:");
                       int vidaMax= scanner.nextInt();
                       robo = new RoboBlindado(nome, coordenadaX, coordenadaY, direcao, velocidadeMaxima, vidaMax);
                       continue;
                   }

                   else{
                       System.out.println("Caractere invalido ):");
                       continue;
                   }        
               }

               if(tipo_de_robo.equals("a")){
                   System.out.println("Digite a altura maxima de voo, coordenada x e coordenada y:");
                   int alturaMax= scanner.nextInt();
                   int coordenadaX = scanner.nextInt();
                   if(coordenadaX > ambiente.getLargura()){
                        System.out.println("Coordenada fora do permitido, coloque uma nova coordenada x");
                        coordenadaX = scanner.nextInt();
                    }

                   int coordenadaY =scanner.nextInt();
                   if(coordenadaX > ambiente.getAltura()){
                        System.out.println("Coordenada fora do permitido, coloque uma nova coordenada y");
                        coordenadaY= scanner.nextInt();
                    }

                    if(coordenadaY > alturaMax){
                        System.out.println("Coordenada acima do permitido, digite a coordenada y novamente");
                         coordenadaY =scanner.nextInt();
                    }

                   System.out.println("Que tipo de robo aereo deseja criar?\nDigite c para criar um robo curandeiro \nDigite k  para criar um robo kamikaze");
                   String tipo_de_aereo=scanner.next();

                   if(tipo_de_aereo.equals("c")){
                        System.out.println("Digite a quantidade de pontos curados:");
                        int poderDeCura = scanner.nextInt();
                        robo = new RoboCurandeiro(nome, coordenadaX, coordenadaY, direcao, alturaMax, poderDeCura);
                        continue;
                   }

                   else if(tipo_de_aereo.equals("k")){
                        System.out.println("Digite raio de alcance:");
                        int raioDeAtaque = scanner.nextInt();
                        robo = new RoboKamikaze(nome, coordenadaX, coordenadaY, direcao, alturaMax, raioDeAtaque);
                        continue;
                   }

                   else{
                       System.out.println("Caractere invalido ):");
                       continue;
                   }                
               }

               else{
                   System.out.println("Caractere invalido ):");
                   continue;
               }           
           }

            else if (comando==2){ /*Leitura de dados e movimentacao do robo */
                System.out.println("Digite o nome do robo para selecionar:");
                String nome= scanner.next();

                List<Robo> robos = Ambiente.getrobosAtivos();
                boolean encontrado = false;
                for (int i = 0; i < robos.size(); i++) {
                    Robo robo_i = robos.get(i);
                    // System.out.println(robo_i);
                    // System.out.println(robo_i.getNome());
                    // System.out.println(nome);
                    // System.out.println(robo_i.getClass().getName());
                    
                    if ((robo_i.getNome()).equalsIgnoreCase(nome)){
                        encontrado = true;
                        if(robo_i instanceof RoboBlindado){
                            RoboBlindado blindado = (RoboBlindado) robo_i;
                            System.out.println("O que deseja fazer?\nDigite 1 para mover\nDigite 2 para consultar vida");
                            int input=scanner.nextInt();

                            if(input==1){
                                if (robo==null){
                                    System.out.println("Crie um robo antes de mover!");
                                    continue;
                                }
                                System.out.println("Digite a direcao (separadas por espaco):");
                                String direcao = scanner.next();
                                if(direcao.equalsIgnoreCase("leste") ||  direcao.equalsIgnoreCase("oeste")){
                                    blindado.verificar_direcao(direcao); /*Verifica se existe algum obstaculo na direcao escolhida */
                                    System.out.println("Digite a distancia percorrida (separadas por espaco):");
                                    int distancia=scanner.nextInt();    
                                    int velocidadeMax = blindado.getvelocidadeMaxima();
                                    if((blindado.verificar_velocidade (velocidadeMax, distancia))){
                                        blindado.mover(ambiente, direcao, distancia);

                                    }
                                    
                                    else{

                                        System.out.println("Velocidade maxima excedida");
                                    }


                                   
                                }

                                else if (direcao.equalsIgnoreCase("norte") ||  direcao.equalsIgnoreCase("sul")){
                                    System.out.println("Robos terrestres nao podem se mover no eixo y");
                                
                                }
                         
                            }

                            else if(input==2){
                                blindado.consultarVida();
                            }
                        }


                        else if(robo_i instanceof RoboGuerreiro){
                            RoboGuerreiro guerreiro = (RoboGuerreiro) robo_i;
                            System.out.println("O que deseja fazer?\nDigite 1 para mover\nDigite 2 para atacar");
                            int input=scanner.nextInt();

                            if(input==1){
                                if (robo==null){
                                    System.out.println("Crie um robo antes de mover!");
                                    continue;
                                }

                                System.out.println("Digite a direcao (separadas por espaco):");
                                String direcao = scanner.next();

                                if(direcao.equalsIgnoreCase("leste") ||  direcao.equalsIgnoreCase("oeste")){   
                                    guerreiro.verificar_direcao(direcao); /*Verifica se existe algum obstaculo na direcao escolhida */
                                    System.out.println("Digite a distancia percorrida (separadas por espaco):");
                                    int distancia=scanner.nextInt();

                                    int velocidadeMax = guerreiro.getvelocidadeMaxima();
                                    if((guerreiro.verificar_velocidade (velocidadeMax, distancia)) == true){
                                        guerreiro.mover(ambiente, direcao, distancia);
                                    }
                                    
                                    else{

                                        System.out.println("Velocidade maxima excedida");
                                    }
                                   
                                }

                                else if (direcao.equalsIgnoreCase("norte") ||  direcao.equalsIgnoreCase("sul")){
                                    System.out.println("Robos terrestres nao podem se mover no eixo y");
                                
                                }
                           
                            }

                            if(input==2){
                                System.out.println("Informe as coordenadas que deseja atacar no formato 'x y'");
                                int x= scanner.nextInt();
                                int y= scanner.nextInt();
                                guerreiro.atacar(x,y);
                            }
                        }
                        

                        else if(robo_i instanceof RoboCurandeiro){
                            RoboCurandeiro curandeiro = (RoboCurandeiro) robo_i;
                            System.out.println("O que deseja fazer?\nDigite 1 para mover\nDigite 2 para curar robos em seu eixo y");
                            int input=scanner.nextInt();
                            if(input==1){
                                if (robo==null){
                                    System.out.println("Crie um robo antes de mover!");
                                    continue;
                                }

                                System.out.println("Digite a distancia percorrida (separadas por espaco):");
                                int distancia=scanner.nextInt();
                                System.out.println("Digite a direcao (separadas por espaco):");
                                String direcao = scanner.next();
                                curandeiro.verificar_direcao(direcao); /*Verifica se existe algum obstaculo na direcao escolhida */
                                curandeiro.mover(ambiente, direcao,distancia);

                            }

                            if(input==2){
                                curandeiro.verificarPosicaoX();
                            }
                        }

                        else if(robo_i instanceof RoboKamikaze){
                            RoboKamikaze kamikaze = (RoboKamikaze) robo_i;
                            System.out.println("O que deseja fazer?\nDigite 1 para mover");
                            int input=scanner.nextInt();
                            if(input==1){
                                if (robo==null){
                                    System.out.println("Crie um robo antes de mover!");
                                    continue;
                                }
                                System.out.println("Digite a distancia percorrida (separadas por espaco):");
                                int distancia=scanner.nextInt();
                                System.out.println("Digite a direcao (separadas por espaco):");
                                String direcao = scanner.next();
                                kamikaze.verificar_direcao(direcao); /*Verifica se existe algum obstaculo na direcao escolhida */
                                kamikaze.mover(ambiente, direcao, distancia);
                            }
                        }

                        break;
                    } 
                }
                if (!encontrado) {
                    System.out.println("Nenhum robo encontrado :(");
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
