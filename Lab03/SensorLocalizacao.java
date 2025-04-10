public class SensorLocalizacao  extends Sensor{

    public SensorLocalizacao(int raio){
        super(raio);
    }

    public void identificar_obstaculos(int posicao_ocupada, int raio){ /* mudar depois para passar parametro do robo */
        for(Robo robo : Ambiente.getrobosAtivos()){
            int xSensor = this.getCoordenadaX();
            int zSensor = this.getCootdenaZ();
            int raio = getRaio();
            
            for (Robo robo : Ambiente.getrobosAtivos()) {
               
                if (robo == this) continue;
    
                int xOutro = robo.getCoordenadaX();
                int zOutro = robo.getCoordenadaZ();
    
                int distancia = calcular_distancia(xSensor, zSensor, xOutro, zOutro);
    
                if (distancia <= raio) {
                    System.out.println("Obstáculo detectado a " + distancia + " unidades: Robo em (" + xOutro + ", " + zOutro + ")");
                }
            }



        }


    }


    private int calcular_distancia(int x1, int z1, int x2, int z2) {
        return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(z2 - z1, 2));
    }
}



