public class SensorLocalizacao  extends Sensor{

    public SensorLocalizacao(int raio, Robo dono, String nome){
        super(raio, dono, nome);
    }

    public void identificar_obstaculos(){ /* pega o x e z do robo com o sensor e verifica se esta dentro do raio, e calcula a distancia*/
            int raio = getRaio();
            Robo roboSensor = getDono();
            int xSensor = roboSensor.getCoordenadaX();
            int zSensor = roboSensor.getCoordenadaZ(); 
        
        for(Robo robo : Ambiente.getrobosAtivos()){
            
            if (robo == roboSensor) continue;
    
                int xOutro = robo.getCoordenadaX();
                int zOutro = robo.getCoordenadaZ();
    
                int distancia = calcular_distancia(xSensor, zSensor, xOutro, zOutro);
    
                if (distancia <= raio) {
                    System.out.println("Obstáculo detectado a " + distancia + " unidades: Robo em (" + xOutro + ", " + zOutro + ")");
                }
        }
    }

    private int calcular_distancia(int x1, int z1, int x2, int z2) {
        return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(z2 - z1, 2));
    }
}



