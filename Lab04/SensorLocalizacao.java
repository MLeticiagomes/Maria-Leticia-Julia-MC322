/*
SubClasse de Sensor- Sensor Localizacao
Objetivo: definir propriedas de SensorLocalizacao e identificar posicao dos robos proximos
*/

import java.util.List;

public class SensorLocalizacao  extends Sensor{

    public SensorLocalizacao(int raio, String nome){
        super(raio, nome);
    }

    public void identificarRobos(int coordx, int coordy, int coordz){ /* pega o x e z do robo com o sensor e verifica se esta dentro do raio, e calcula a distancia*/
        int raio = getRaio();
        int xSensor = coordx;
        int ySensor = coordy;
        int zSensor = coordy;
    
        List<Entidade> ents = Ambiente.getEntidade();
        for (int i = 0; i < ents.size(); i++) {
            Entidade entidade = ents.get(i);
            if (entidade.getEntidade() == TipoEntidade.ROBO){ /* verifica se a entidade é do tipo robo, se for executa as funçoes */
                Robo robo = (Robo) entidade; 
                if (robo.getCoordenadaX()==xSensor && robo.getCoordenadaY()==ySensor && robo.getCoordenadaZ()==zSensor){
                    continue;
                }
        
                int xOutro = robo.getCoordenadaX();
                int yOutro = robo.getCoordenadaY();
                int zOutro = robo.getCoordenadaZ();
        
                int distancia = calcular_distancia(xSensor, zSensor, xOutro, zOutro, ySensor, yOutro);
        
                if (distancia <= raio) {
                    System.out.println("Obstáculo detectado a " + distancia + " unidades: Robo em (" + xOutro + ", " + yOutro + ", " + zOutro + ")");
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



