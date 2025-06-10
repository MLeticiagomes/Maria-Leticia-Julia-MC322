package robo;

import environment.Ambiente;
import missao.*;

public  class RoboTerrestre extends AgenteInteligente { /* robo terrestre com uma velocidade maxima */

    private int velocidadeMaxima;
    private LogMissao log;
   

    public RoboTerrestre(String nome, int x,int y, int z, String d, int v){
        super(nome,x,0,z,d);
        this.velocidadeMaxima = v;
        this.log = new LogMissao();
    }


    public int getvelocidadeMaxima(){
        return velocidadeMaxima;
    }
    
    
    public boolean verificar_velocidade(int velocidadeMaxima, int velocidade){ //verifica se o num de blocos que deseja andar nao excede a velocidade maxima
        if(velocidade < velocidadeMaxima){
            return true;
        }

        else{
            System.out.println("Velocidade acima do permitido :(");
            return false;
        }
    }

        @Override
    public void executarMissao(Ambiente ambiente) {
        log.registrar("Executando missão terrestre no ambiente.");
        // Lógica da missão aqui
    }

       @Override
    public void executarTarefa() {
        System.out.println("Executando tarefa do RoboTerrestre.");
        // Lógica da tarefa aqui
    }



}
