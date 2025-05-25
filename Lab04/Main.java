import java.util.List;
import java.util.Scanner;

public class Main{
  public static void main(String[] args) {

        Entidade entidades = null;
        Ambiente ambiente = new Ambiente(10, 15, 10 );

        RoboGuerreiro robo1 = new RoboGuerreiro("Guerreiro1", 2, 0, 2, "norte", 5, 4);
        Ambiente.adicionarEntidade(robo1);
        RoboGuerreiro robo2 = new RoboGuerreiro("Guerreiro2", 9, 0, 4, "sul", 3, 5);
        Ambiente.adicionarEntidade(robo2);
        RoboCurandeiro robo3 = new RoboCurandeiro("Curandeiro1", 3, 1, 3, "leste", 10, 4);
        Ambiente.adicionarEntidade(robo3);
        RoboCurandeiro robo4 = new RoboCurandeiro("Curandeiro2", 5, 7, 5, "leste", 14, 6);
        Ambiente.adicionarEntidade(robo4);
        RoboBlindado robo5 = new RoboBlindado("Blindado1", 4, 0, 4, "oeste", 3, 10);
        Ambiente.adicionarEntidade(robo5);
        RoboBlindado robo6 = new RoboBlindado("Blindado2", 6, 0, 8, "norte", 4, 8);
        Ambiente.adicionarEntidade(robo6);
        RoboKamikaze robo7 = new RoboKamikaze("Kamikase1", 1, 5, 9, "sul", 15, 3);
        Ambiente.adicionarEntidade(robo7);
        RoboKamikaze robo8 = new RoboKamikaze("Kamikase2", 2, 7, 8, "sul", 15, 5);
        Ambiente.adicionarEntidade(robo8);


        Obstaculo rocha1 = new Obstaculo(0, 1, 0, 1, 0, Obstaculo.TipoObstaculo.ROCHA);
        Ambiente.adicionarEntidade(rocha1);
        Obstaculo rocha2 = new Obstaculo(7, 8, 1, 2, 0, Obstaculo.TipoObstaculo.ROCHA);
        Ambiente.adicionarEntidade(rocha2);
        Obstaculo predio1 = new Obstaculo(0, 1, 6, 7, 0, Obstaculo.TipoObstaculo.PREDIO);
        Ambiente.adicionarEntidade(predio1);
        Obstaculo predio2 = new Obstaculo(8, 9, 7, 8, 0, Obstaculo.TipoObstaculo.PREDIO);
        Ambiente.adicionarEntidade(predio2);
        Obstaculo buraco1 = new Obstaculo(0, 2, 3, 5, 0, Obstaculo.TipoObstaculo.BURACO);
        Ambiente.adicionarEntidade(buraco1);
        Obstaculo buraco2 = new Obstaculo(7, 8, 4, 5, 0, Obstaculo.TipoObstaculo.BURACO);
        Ambiente.adicionarEntidade(buraco2);
        Obstaculo nuvem1 = new Obstaculo(1, 2, 0, 1, 4, Obstaculo.TipoObstaculo.NUVEM);
        Ambiente.adicionarEntidade(nuvem1);
        Obstaculo nuvem2 = new Obstaculo(6, 7, 2, 3, 5, Obstaculo.TipoObstaculo.NUVEM);
        Ambiente.adicionarEntidade(nuvem2);
        Obstaculo balao1 = new Obstaculo(1, 2, 6, 7, 6, Obstaculo.TipoObstaculo.BALAO);
        Ambiente.adicionarEntidade(balao1);
        Obstaculo balao2 = new Obstaculo(4, 5, 8, 9, 5, Obstaculo.TipoObstaculo.BALAO);
        Ambiente.adicionarEntidade(balao2);


        Scanner scanner = new Scanner(System.in); /*Introduz simulador */
        System.out.println("Bem vindo ao Simulador de Robos!");
        Sensor sensor_ambiente= new Sensor(15,"SensorAmbiente"); /* monitora a quantidade de sensores dos robos */

      while (true){ /*Introduz comandos do simulador */
          System.out.println("O que deseja fazer?\nDigite 1 para visualizar os robos ativos\nDigite 2 para selecionar o robo\nDigite 3 para acessar sensores\nDigite 4 para ver a lista de objetos\n Digite 5 para verifica se há uma entidade em uma determinada posição\n Digite 0 para fechar o simulador");
          int comando=scanner.nextInt();

          if (comando==1){ /*Lista de robos */
            List<Entidade> ents = Ambiente.getEntidade();
            for (int i = 0; i < ents.size(); i++) {
                entidades = ents.get(i); /* pega o tipo da entidade e verifica se é um robo */
                if (entidades.getEntidade() == TipoEntidade.ROBO) {
                    Robo roboEnt = (Robo) entidades; /* converte a entidade geral em uma mais especifica, robo, para pegar seus atributos (naão sei se ta certo) */
                    System.out.println("=== Robô: " + roboEnt.getNome() + " ===");
                    System.out.println("Posição: (" + roboEnt.getX() + ", " + roboEnt.getY() + "," + roboEnt.getZ() + ")");
                    System.out.println("Estado do robo: " + roboEnt.getEstado() + ".");
                
                    // Se quiser mostrar atributos específicos dependendo do tipo de robô:
                    if (roboEnt instanceof RoboGuerreiro) {
                        RoboGuerreiro guerreiro = (RoboGuerreiro) roboEnt;
                        System.out.println("Velocidade Maxima: " + guerreiro.getvelocidadeMaxima());
                        System.out.println("Força de ataque: " + guerreiro.getDano());
                    }
                    
                    else if(roboEnt instanceof RoboBlindado){
                        RoboBlindado blindado = (RoboBlindado) roboEnt;
                        System.out.println("Velocidade Maxima: " + blindado.getvelocidadeMaxima());
                        System.out.println("Vida: " + blindado.getPontosVida());
                    }
    
    
                    else if (roboEnt instanceof RoboCurandeiro) {
                        RoboCurandeiro curandeiro = (RoboCurandeiro) roboEnt;
                        System.out.println("Poder de cura: " + curandeiro.getPoderDeCura());
                        System.out.println("Altura Maxima " + curandeiro.getaltura_maxima());
                    }
    
                    else  {
                        RoboKamikaze kamikaze = (RoboKamikaze) roboEnt;
                        System.out.println("Poder de cura: " + kamikaze.getRaioDeAtaque());
                        System.out.println("Altura Maxima " + kamikaze.getaltura_maxima());
                    }
                
                    System.out.println(); // Linha em branco pra separar os robôs

                }
            
            }
         }

           else if (comando==2){ /*Leitura de dados e movimentacao do robo */
               System.out.println("Digite o nome do robo para selecionar:");
               String nome= scanner.next();
               boolean encontrado = false;
               List<Entidade> ents = Ambiente.getEntidade();
               for (int i = 0; i < ents.size(); i++) {
                   Entidade entidade = ents.get(i);
                   if (entidade.getEntidade() == TipoEntidade.ROBO) { /* verifica se a entidade é do tipo robo, se for executa as funçoes */
                    Robo robo_i = (Robo) entidade; 
                    if ((robo_i.getNome()).equalsIgnoreCase(nome)){ /* acha o robo na lista pelo seu nome */
                        encontrado = true;
                        /* verificação do tipo de robo e os comandos especiais de cada um */
                        if(robo_i instanceof RoboBlindado){
                            RoboBlindado blindado = (RoboBlindado) robo_i;
                            System.out.println("O que deseja fazer?\nDigite 1 para mover\nDigite 2 para consultar vida\n Digite 3 para ligar/desligar o robo");
                            int input=scanner.nextInt();

                            if(input==1){
                                if (entidades ==null){ /* verificar se nao vai dar sempre null */
                                    System.out.println("Crie um robo antes de mover!");
                                    continue;
                                }
                                System.out.println("Digite as coordenadas:");
                                int x = scanner.nextInt();
                                int y = scanner.nextInt();
                                int z = scanner.nextInt();
                                int velocidadeMax = blindado.getvelocidadeMaxima();
                                int distancia = Math.abs(blindado.getX() - x) + 
                                Math.abs(blindado.getY() - y) + 
                                Math.abs(blindado.getZ() - z);

                                    if((blindado.verificar_velocidade (velocidadeMax, distancia))){ /* verifica se o robo terrestre esta excedendo a velocidade permitida */
                                        ambiente.moverEntidade(blindado, x, y, z);
                                    }
                                    
                                    else{
                                        System.out.println("Velocidade maxima excedida");
                                    }              
                                                        
                            }


                            else if(input==2){ /* ve a vida restante do robo blindado */
                                blindado.executarTarefa();
                            }
                            
                            else if (input == 3){
                                System.out.println("Deseja ligar ou desligar o robo?");
                                String interruptor = scanner.next();
                                if(interruptor.equalsIgnoreCase("ligar")){
                                    blindado.ligar();
                                    System.out.println("O robo esta ligado :)");
                                    
                                }

                                else if(interruptor.equalsIgnoreCase("desligar")){
                                    blindado.desligar();
                                    System.out.println("O robo esta desligado :)");
                                }
                            }

                        }

                        else if(robo_i instanceof RoboGuerreiro){
                            RoboGuerreiro guerreiro = (RoboGuerreiro) robo_i;
                            System.out.println("O que deseja fazer?\nDigite 1 para mover\nDigite 2 para atacar\n Digite 3 para ligar/desligar o robo\n Digite 4 para achar o melhor alvo");
                            int input=scanner.nextInt();
                            if(input==1){
                                if (entidades ==null){
                                    System.out.println("Crie um robo antes de mover!");
                                    continue;
                                }

                                System.out.println("Digite as coordenadas:");
                                    int x = scanner.nextInt();
                                    int y = scanner.nextInt();
                                    int z = scanner.nextInt();
                                    int velocidadeMax = guerreiro.getvelocidadeMaxima();
                                    int distancia = Math.abs(guerreiro.getX() - x) + 
                                    Math.abs(guerreiro.getY() - y) + 
                                    Math.abs(guerreiro.getZ() - z);
                                    if((guerreiro.verificar_velocidade (velocidadeMax, distancia)) == true){ /* verifica se o robo terrestre esta excedendo a velocidade permitida */
                                        ambiente.moverEntidade(guerreiro, x, y, z);
                                    }
                                    
                                    else{
                                        System.out.println("Velocidade maxima excedida");
                                    }   
                                                              
                                
                            }


                           if(input==2){
                               System.out.println("Informe as coordenadas que deseja atacar no formato 'x y z'"); /* determina o local que o robo pode atacar */
                               int x= scanner.nextInt();
                               int y= scanner.nextInt();
                               int z= scanner.nextInt();
                               guerreiro.atacar(x,y,z);
                            }

                            else if (input == 3){
                                System.out.println("Deseja ligar ou desligar o robo?");
                                String interruptor = scanner.next();
                                if(interruptor.equalsIgnoreCase("ligar")){
                                    guerreiro.ligar();
                                    System.out.println("O robo esta ligado :)");
                                    
                                }

                                else if(interruptor.equalsIgnoreCase("desligar")){
                                    guerreiro.desligar();
                                    System.out.println("O robo esta desligado :)");
                                }
                            }

                            else if ( input == 4){
                                guerreiro.executarTarefa();
                            }
                        }

                       else if(robo_i instanceof RoboCurandeiro){
                           RoboCurandeiro curandeiro = (RoboCurandeiro) robo_i;
                           System.out.println("O que deseja fazer?\nDigite 1 para mover\nDigite 2 para curar robos em seu eixo y\n Digite 3 para ligar/desligar o robo");
                           int input=scanner.nextInt();
                           if(input==1){
                               if (entidades==null){
                                   System.out.println("Crie um robo antes de mover!");
                                   continue;
                               }
                               System.out.println("Digite as coordenadas:");
                                int x = scanner.nextInt();
                                int y = scanner.nextInt();
                                int z = scanner.nextInt();
                                ambiente.moverEntidade(curandeiro, x, y, z);
                               
                           }

                           else if(input==2){
                               curandeiro.executarTarefa();
                               curandeiro.verificarPosicaoX();
                           }

                           else if (input == 3){
                            System.out.println("Deseja ligar ou desligar o robo?");
                            String interruptor = scanner.next();
                            if(interruptor.equalsIgnoreCase("ligar")){
                                curandeiro.ligar();
                                System.out.println("O robo esta ligado :)");
                                
                            }

                            else if(interruptor.equalsIgnoreCase("desligar")){
                                curandeiro.desligar();
                                System.out.println("O robo esta desligado :)");
                            }
                        }
                       }

                       else if(robo_i instanceof RoboKamikaze){
                           RoboKamikaze kamikaze = (RoboKamikaze) robo_i;
                           System.out.println("O que deseja fazer?\nDigite 1 para mover\n Digite 2 para ligar/desligar o robo\n Digite 3 para que o robo se autodestrua");
                           int input=scanner.nextInt();
                           if(input==1){
                               if (entidades==null){
                                   System.out.println("Crie um robo antes de mover!");
                                   continue;
                               }
                               System.out.println("Digite as coordenadas:");
                               int x = scanner.nextInt();
                               int y = scanner.nextInt();
                               int z = scanner.nextInt();
                               ambiente.moverEntidade(kamikaze, x, y, z);
                            }
                            else if (input == 2){
                                System.out.println("Deseja ligar ou desligar o robo?");
                                String interruptor = scanner.next();
                                if(interruptor.equalsIgnoreCase("ligar")){
                                   kamikaze.ligar();
                                    System.out.println("O robo esta ligado :)");
                                    
                                }

                                else if(interruptor.equalsIgnoreCase("desligar")){
                                    kamikaze.desligar();
                                    System.out.println("O robo esta desligado :)");
                                }
                            }

                            else if ( input == 3){
                                kamikaze.executarTarefa();
                            }
                        }
                       break;
                   }
                  

               if (!encontrado) {
                   System.out.println("Nenhum robo encontrado :(");
                }
              }
            }
        }


           else if(comando == 3){
              System.out.println("Digite 1 para criar um sensor\nDigite 2 para acessar um sensor ja existente");
              int input= scanner.nextInt();

              if (input == 1){
                System.out.println("Digite o nome do robo em que deseja implementar o sensor:");
                String nome = scanner.next();
                boolean robo_encontrado =false;
                List<Entidade> ents = Ambiente.getEntidade();
                for (int i = 0; i < ents.size(); i++) {
                    Entidade entidade = ents.get(i);
                    if (entidade.getEntidade() == TipoEntidade.ROBO) { /* verifica se a entidade é do tipo robo, se for executa as funçoes */
                     Robo robo_i = (Robo) entidade;  
                        if(robo_i.getNome().equalsIgnoreCase(nome)){
                            System.out.println("Digite o raio de atuacao do sensor");
                            int raio_do_sensor = scanner.nextInt();

                            System.out.println("Digite l para criar um sensor de localizacao ou m para criar um sensor meteorologico:");
                            String tipo_de_sensor = scanner.next();
                            if(tipo_de_sensor.equalsIgnoreCase("l")){/* cria um sensor de localizacao */
                                Sensor sensor = new SensorLocalizacao(raio_do_sensor, "SensorLocalizacao"); 
                                robo_i.adicionarSensor(sensor);
                                robo_encontrado=true;
                                break;
                            }
                            else if(tipo_de_sensor.equalsIgnoreCase("m")){/* cria um sensor meteorologico */
                                Sensor sensor = new SensorMeteorologico(raio_do_sensor, "SensorMeteorologico"); 
                                robo_i.adicionarSensor(sensor);
                                robo_encontrado=true;
                                break;
                            }

                        }
                    }
              }

              if(robo_encontrado==false){
                System.out.println("Robo nao encontrado :(");
              }
            }

            else if (input==2){
                System.out.println("Digite o nome do robo do qual deseja acessar o sensor:");
                String nome = scanner.next();
                boolean robo_encontrado=false;
                
                List<Entidade> ents = Ambiente.getEntidade();
                for (int i = 0; i < ents.size(); i++) {
                    Entidade entidade = ents.get(i);
                    if (entidade.getEntidade() == TipoEntidade.ROBO) { /* verifica se a entidade é do tipo robo, se for executa as funçoes */
                     Robo robo_i = (Robo) entidade;  
               
                    if(robo_i.getNome().equalsIgnoreCase(nome)){
                        robo_encontrado=true;
                        List<Sensor> sensores =robo_i.getsensoresDosRobos();
                        boolean num_sensores=sensor_ambiente.monitorar(sensores);

                        if(num_sensores==true){
                            for(int j = 0; j < sensores.size(); j++){
                                Sensor sensor=sensores.get(j);
                                System.out.println("Deseja utilizar " + sensor.getNome() + "? Digite 0 para utilizar ou 1 para continuar"); 
                                input = scanner.nextInt(); 
                                if(input==0){
                                    ambiente.executarSensores( sensor, robo_i);
                                }
                            }
                        }
                    }
                }

            }

            if(robo_encontrado==false){
                System.out.println("Robo nao encontrado :(");
            }
        
        }  
    }
        
        else if(comando == 4){

            System.out.println("O que deseja fazer?\nDigite 1 para mover\nDigite 2 para consultar lista de obstaculos");
            int input=scanner.nextInt();

            if(input == 1){
                System.out.println(" Objetos aparecem no formato : \n === Objeto: tipo_do_objeto  === \n Posição: (x1,x2,y1,y2,altura)\n \n");
                List<Entidade> ents = Ambiente.getEntidade();
                for (int i = 0; i < ents.size(); i++) {
                    Entidade entidade = ents.get(i);
                    if (entidade.getEntidade() == TipoEntidade.OBSTACULO) { /* verifica se a entidade é do tipo robo, se for executa as funçoes */
                        Obstaculo obstaculo= (Obstaculo) entidade;  
                        System.out.println("=== Objeto: " + obstaculo.getTipo() + " ===");
                        System.out.println("Posição: (" + obstaculo.getCoordenadaX1() + ", " + obstaculo.getCoordenadaX2() + "," + obstaculo.getCoordenadaZ1() + "," + obstaculo.getCoordenadaZ2() + ", " + obstaculo.getAltura() + ")");
                        System.out.println(); // Linha em branco pra separar os robôs
                    }
                }
            }

            else if (input == 2) {
                List<Entidade> ents = Ambiente.getEntidade();
        
                System.out.println("Digite o índice do obstáculo que deseja mover:");
                int index = scanner.nextInt();
        
                if (index >= 0 && index < ents.size()) {
                    Entidade entidade = ents.get(index);
                    if (entidade.getEntidade() == TipoEntidade.OBSTACULO) {
                        System.out.println("Digite as novas coordenadas X, Y e Z:");
                        int x = scanner.nextInt();
                        int y = scanner.nextInt();
                        int z = scanner.nextInt();
        
                        ambiente.moverEntidade(entidade, x, y, z);
                    } else {
                        System.out.println("A entidade selecionada não é um obstáculo.");
                    }
                } else {
                    System.out.println("Índice inválido.");
                }
            }
    }

        else if (comando == 5){
        System.out.println("Digite as coordenadas as quais deseja verificar:");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        ambiente.estaOcupado(x, y, z);
        }

        else if (comando==0){ /*Fecha o simulador */
            System.out.println("Encerrando o simulador...");
            scanner.close();
            break;
        }
    
    }
  }
}










