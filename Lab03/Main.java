import java.util.List;
import java.util.Scanner;
import java.util.List;
import java.util.Scanner;




public class Main {
  public static void main(String[] args){




      Scanner scanner = new Scanner(System.in); /*Introduz simulador */
      System.out.println("Bem vindo ao Simulador de Robos!\nVamos comecar criando um ambiente.\nDigite as dimensoes largura, comprimento e altura (separados por espaco):");
      int largura = scanner.nextInt(); /*leitura de dados para criacao do ambiente */
      int comprimento = scanner.nextInt();
      int altura = scanner.nextInt();
      Ambiente ambiente = new Ambiente(largura, altura, comprimento);
      Robo robo= null;
        
      while (true){ /*Introduz comandos do simulador */
          System.out.println("O que deseja fazer?\nDigite 1 para criar novo robo\nDigite 2 para selecionar o robo\nDigite 0 para fechar o simulador");
          int comando=scanner.nextInt();




          if (comando==1){ /*Leitura de dados e criacao de novo robo */


              System.out.println("Digite um nome:");
              String nome = scanner.next();
              List<Robo> robos = Ambiente.getrobosAtivos();
              boolean nomeJaExiste = false;
              for (int i = 0; i < robos.size(); i++) {
                   if(robo.getNome().equals(nome)){
                       System.out.println("Esse robo ja existe :(");
                       nomeJaExiste = true;
                       break;
                   }
               }
               if (nomeJaExiste) {
                   continue;
               }


               System.out.println("Digite uma direcao:");
               String direcao = scanner.next();
               System.out.println("Que tipo de robo deseja criar?\nDigite t para criar um robo terrestres\nDigite a para criar um robo aereo");
               String tipo_de_robo=scanner.next();


              if(tipo_de_robo.equals("t")){ /* criacao do  robo terrestre  com o atributo de velocidade maxima e coordenada x e z*/
                  System.out.println("Digite a velocidade maxima de deslocamento desejada, coordenada x e coordenada z");
                  int velocidadeMaxima=scanner.nextInt();
                  int coordenadaX = scanner.nextInt();
                  int coordenadaY = 0;
                  int coordenadaZ = scanner.nextInt();
                  while(coordenadaX > ambiente.getLargura() || coordenadaZ> ambiente.getComprimento()){ /* se a cordenada x ou z de criaçao do robo nao estiver nos limites do ambiente */
                       System.out.println("Coordenada fora do permitido, insira coordenadas validas");
                       coordenadaX = scanner.nextInt();
                       coordenadaZ = scanner.nextInt();
                  }


                  System.out.println("Que tipo de robo terrestre deseja criar?\nDigite g para criar um robo guerreiro \nDigite b para criar um robo blindado");
                  String tipo_de_terrestre=scanner.next();


                  if(tipo_de_terrestre.equals("g")){ /* criacao do robo guerreiro */
                      System.out.println("Digite a quantidade de dano de ataque desejado:");
                      int dano = scanner.nextInt(); /* quantidade de dano que cada ataque causa */
                      robo = new RoboGuerreiro(nome, coordenadaX, 0, coordenadaZ, direcao, velocidadeMaxima, dano);
                      continue;
                  }


                  else if(tipo_de_terrestre.equals("b")){ /* criacao do robo blindado */
                      System.out.println("Digite a quantidade de vida desejada:");
                      int vidaMax= scanner.nextInt(); /* quantidade de vida maixima que ele possui */
                      robo = new RoboBlindado(nome, coordenadaX, 0, coordenadaZ, direcao, velocidadeMaxima, vidaMax);
                      continue;
                  }


                  else{
                      System.out.println("Caractere invalido ):");
                      continue;
                  }       
              }


              if(tipo_de_robo.equals("a")){ /* criacao de um robo aereo com altura  maxima que pode alcançar */
                  System.out.println("Digite a altura maxima de voo, coordenada x, coordenada z e coordenada y (altura):");
                  int alturaMax= scanner.nextInt();
                  int coordenadaX = scanner.nextInt();
                  int coordenadaZ = scanner.nextInt();
                  int coordenadaY =scanner.nextInt();


                  while(coordenadaX > ambiente.getLargura() || coordenadaY > ambiente.getAltura() || coordenadaZ > ambiente.getComprimento()){ /* confere se o robo esta sendo criado dentro dos limites */
                       System.out.println("Coordenada fora do permitido, insira coordenadas validas");
                       coordenadaX = scanner.nextInt();
                   }


                   while(coordenadaY > alturaMax){ /* confere se a altura de criacao do robo é menor ou igual a maxima */
                       System.out.println("Altura maior do que a maxima, insira altura valida");
                        coordenadaY =scanner.nextInt();
                   }


                  System.out.println("Que tipo de robo aereo deseja criar?\nDigite c para criar um robo curandeiro \nDigite k  para criar um robo kamikaze");
                  String tipo_de_aereo=scanner.next();


                  if(tipo_de_aereo.equals("c")){/* criacao do robo curandeiro com poder de cura */
                       System.out.println("Digite a quantidade de pontos curados:");
                       int poderDeCura = scanner.nextInt();
                       robo = new RoboCurandeiro(nome, coordenadaX, coordenadaY, coordenadaZ, direcao, alturaMax, poderDeCura);
                       continue;
                  }


                  else if(tipo_de_aereo.equals("k")){ /* criacao do robo kamikaze e raio de alcance da explosao */
                       System.out.println("Digite raio de alcance:");
                       int raioDeAtaque = scanner.nextInt();
                       robo = new RoboKamikaze(nome, coordenadaX, coordenadaY, coordenadaZ, direcao, alturaMax, raioDeAtaque);
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
                   if ((robo_i.getNome()).equalsIgnoreCase(nome)){ /* acha o robo na lista pelo seu nome */
                       encontrado = true;
                       /* verificação do tipo de robo e os comandos especiais de cada um */
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
                               if(direcao.equalsIgnoreCase("leste") ||  direcao.equalsIgnoreCase("oeste") ||  direcao.equalsIgnoreCase("norte") ||  direcao.equalsIgnoreCase("sul")){
                                   System.out.println("Digite a distancia percorrida (separadas por espaco):");
                                   int distancia=scanner.nextInt();   
                                   int velocidadeMax = blindado.getvelocidadeMaxima();
                                   if((blindado.verificar_velocidade (velocidadeMax, distancia))){ /* verifica se o robo terrestre esta excedendo a velocidade permitida */
                                       blindado.mover(ambiente, direcao, distancia);


                                   }
                                  
                                   else{


                                       System.out.println("Velocidade maxima excedida");
                                   }              
                               }                        
                           }


                           else if(input==2){ /* ve a vida restante do robo blindado */
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


                               if(direcao.equalsIgnoreCase("leste") ||  direcao.equalsIgnoreCase("oeste") ||  direcao.equalsIgnoreCase("norte") ||  direcao.equalsIgnoreCase("sul")){  
                                   System.out.println("Digite a distancia percorrida (separadas por espaco):");
                                   int distancia=scanner.nextInt();


                                   int velocidadeMax = guerreiro.getvelocidadeMaxima();
                                   if((guerreiro.verificar_velocidade (velocidadeMax, distancia)) == true){ /* verifica se o robo terrestre esta excedendo a velocidade permitida */
                                       guerreiro.mover(ambiente, direcao, distancia);
                                   }
                                  
                                   else{


                                       System.out.println("Velocidade maxima excedida");
                                   }                                 
                               }
                           }


                           if(input==2){
                               System.out.println("Informe as coordenadas que deseja atacar no formato 'x e z'"); /* determina o local que o robo pode atacar */
                               int x= scanner.nextInt();
                               int y= scanner.nextInt();
                               int z= scanner.nextInt();
                               guerreiro.atacar(x,y,z);
                           }
                       }
                      


                       else if(robo_i instanceof RoboCurandeiro){
                           RoboCurandeiro curandeiro = (RoboCurandeiro) robo_i;
                           System.out.println("O que deseja fazer?\nDigite 1 para mover\nDigite 2 para curar robos em seu eixo y\nDigite 3 para subir ou descer");
                           int input=scanner.nextInt();
                           if(input==1){
                               if (robo==null){
                                   System.out.println("Crie um robo antes de mover!");
                                   continue;
                               }
                               System.out.println("Digite a direcao:");
                               String direcao = scanner.next();


                               if(direcao.equalsIgnoreCase("leste") ||  direcao.equalsIgnoreCase("oeste") ||  direcao.equalsIgnoreCase("norte") ||  direcao.equalsIgnoreCase("sul")){  
                                   System.out.println("Digite a distancia percorrida:");
                                   int distancia=scanner.nextInt();
                                   curandeiro.mover(ambiente, direcao,distancia);
                               }
                           }


                           else if(input==2){
                               curandeiro.verificarPosicaoX();
                           }


                           else if(input==3){
                               System.out.println("Deseja subir ou descer?");
                               String orientacao = scanner.next();


                               if(orientacao.equalsIgnoreCase("subir")){
                                   System.out.println("Digite a distancia percorrida:");
                                   int distancia=scanner.nextInt();
                                   if(curandeiro.verificarAlturaMax(distancia) == false){
                                       System.out.println("Altura acima da permitida");
                                       break;
                                   }
                                   else{
                                       curandeiro.subir(distancia);
                                   }
                               }
                               else if (orientacao.equalsIgnoreCase("descer")){
                                   System.out.println("Digite a distancia percorrida:");
                                   int distancia=scanner.nextInt();
                                   if(curandeiro.verificarAlturaMin(distancia) == false){
                                       System.out.println("Altura abaixo da permitida");
                                       break;
                                   }
                                   else{
                                       curandeiro.descer(distancia);
                                   }
                               }
                           }
                       }


                       else if(robo_i instanceof RoboKamikaze){
                           RoboKamikaze kamikaze = (RoboKamikaze) robo_i;
                           System.out.println("O que deseja fazer?\nDigite 1 para mover\nDigite 2 para subir ou descer");
                           int input=scanner.nextInt();
                           if(input==1){
                               if (robo==null){
                                   System.out.println("Crie um robo antes de mover!");
                                   continue;
                               }
                               System.out.println("Digite a direcao:");
                               String direcao = scanner.next();


                               if(direcao.equalsIgnoreCase("leste") ||  direcao.equalsIgnoreCase("oeste") ||  direcao.equalsIgnoreCase("norte") ||  direcao.equalsIgnoreCase("sul")){  
                                   System.out.println("Digite a distancia percorrida:");
                                   int distancia=scanner.nextInt();
                                   kamikaze.mover(ambiente, direcao,distancia);
                               }
                           }
                           if(input==2){
                               System.out.println("Deseja subir ou descer?");
                               String orientacao = scanner.next();


                               if(orientacao.equalsIgnoreCase("subir")){
                                   System.out.println("Digite a distancia percorrida:");
                                   int distancia=scanner.nextInt();
                                   if(kamikaze.verificarAlturaMax(distancia) == false){
                                       System.out.println("Altura acima da permitida");
                                       break;
                                   }
                                   else{
                                       kamikaze.subir(distancia);
                                   }
                               }
                               else if (orientacao.equalsIgnoreCase("descer")){
                                   System.out.println("Digite a distancia percorrida:");
                                   int distancia=scanner.nextInt();
                                   if(kamikaze.verificarAlturaMin(distancia) == false){
                                       System.out.println("Altura abaixo da permitida");
                                       break;
                                   }
                                   else{
                                       kamikaze.descer(distancia);
                                   }
                               }
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










