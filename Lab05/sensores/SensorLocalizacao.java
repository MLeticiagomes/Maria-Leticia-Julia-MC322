/*
SubClasse de Sensor- Sensor Localizacao
Objetivo: definir propriedas de SensorLocalizacao e identificar posicao dos robos proximos
*/
package sensores;
import entidade.*;
import environment.*;
import java.util.List;
import robo.*;
import missao.*;

public class SensorLocalizacao  extends Sensor{

    public SensorLocalizacao(int raio, String nome){
        super(raio, nome);
    }

    public void identificarRobos(int coordx, int coordy, int coordz, LogMissao log){ /* pega o x e z do robo com o sensor e verifica se esta dentro do raio, e calcula a distancia*/
        int raio = getRaio();
        int xSensor = coordx;
        int ySensor = coordy;
        int zSensor = coordy;
    
        List<Entidade> ents = Ambiente.getEntidade();
        for (int i = 0; i < ents.size(); i++) {
            Entidade entidade = ents.get(i);
            if (entidade.getEntidade() == TipoEntidade.ROBO){ /* verifica se a entidade é do tipo robo, se for executa as funçoes */
                Robo robo = (Robo) entidade; 
                if (robo.getX()==xSensor && robo.getY()==ySensor && robo.getZ()==zSensor){
                    continue;
                }
        
                int xOutro = robo.getX();
                int yOutro = robo.getY();
                int zOutro = robo.getZ();
        
                int distancia = calcular_distancia(xSensor, zSensor, xOutro, zOutro, ySensor, yOutro);
        
                if (distancia <= raio) {
                    String mensagem= "Obstáculo detectado a " + distancia + " unidades: " + robo.getNome() + " em (" + xOutro + ", " + yOutro + ", " + zOutro + ")";
                    System.out.println(mensagem);
                    if (log != null){
                        log.registrar(mensagem);
                    }
                }
            }

            else{
                continue;
            }
       }
    }
    
    private int calcular_distancia(int x1, int z1, int x2, int z2, int y1, int y2) {
        return (int) Math.sqrt(Math.pow(Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(z2 - z1, 2))),2) + Math.pow(y2-y1,2));
    }

}



