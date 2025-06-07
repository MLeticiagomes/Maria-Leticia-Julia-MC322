package missao;
import environment.*;
import excecoes.ColisaoException;
import excecoes.ForaDosLimitesException;
import excecoes.RoboDesligadoException;
import interfaces.*;
import java.util.List;
import java.util.Random;
import robo.*;
import sensores.*;

public class MissaoExplorar implements Missao {
    private Random rand = new Random();
    private LogMissao log;
    private Ambiente ambiente;


    public MissaoExplorar(LogMissao l, Ambiente a){
        this.log=l;
        this.ambiente=a;
    }

    @Override
    public void executar(Robo robo, Ambiente ambiente) {
        LogMissao log = ambiente.getLog(); // log será fornecido pelo ambiente
        log.registrar("Início da missão de exploração do robô " + robo.getNome());

        for (int passo = 1; passo <= 5; passo++) {
            log.registrar("Passo " + passo + ":");

            int xMax=ambiente.getLargura();
            int zMax=ambiente.getComprimento();

            int xAleatorio=rand.nextInt(xMax);
            int zAleatorio=rand.nextInt(zMax);
            int y_do_robo = robo.getY();
             try{
            ambiente.moverEntidade(robo, xAleatorio, y_do_robo, zAleatorio);

            log.registrar("  Robô se moveu para posição: ( " + xAleatorio + ", " + robo.getY() + ", " + zAleatorio + ")");
            }
            catch(RoboDesligadoException e){
                 log.registrar("  ERRO: Robô desligado. Não foi possível mover.");
                break; 
            }
            catch (ForaDosLimitesException e) {
            log.registrar("  ERRO: Posição (" + xAleatorio + ", " + y_do_robo + ", " + zAleatorio + ") fora dos limites.");
            continue; // tenta próxima iteração
            }

            catch (ColisaoException e) {
                log.registrar("  ERRO: A posicao ja esta ocupada");
                continue; // tenta próxima iteração
                }

            List<Sensor> sensores =robo.getGerenciadorSensores().getsensoresDosRobos();
            int num_sensores=sensores.size();

            if(num_sensores!=0){
                for(int j = 0; j < sensores.size(); j++){
                    Sensor sensor=sensores.get(j);
                    ((Sensoreavel) robo).acionarSensores(sensor,robo,log);
                }
            }
        }
        log.registrar("Missão de exploração finalizada para robô " + robo.getNome());
    }
}
