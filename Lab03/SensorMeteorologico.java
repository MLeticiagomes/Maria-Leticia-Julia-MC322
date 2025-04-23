import java.util.List;

public class SensorMeteorologico extends Sensor {
    public SensorMeteorologico(int raio, Robo dono, String nome){
        super(raio,dono,nome);
    }

    public void identificarClima(){
        List<Obstaculo> obstaculos = Ambiente.getobstaculosExistentes();
        for (int i=0; i<obstaculos.size(); i++){
            Obstaculo obstaculo= obstaculos.get(i);
            if (obstaculo.getTipo()==Obstaculo.TipoObstaculo.NUVEM){
                int x1=obstaculo.getCoordenadaX1();
                int x2=obstaculo.getCoordenadaX2();
                int y1=obstaculo.getCoordenadaZ1();
                int y2=obstaculo.getCoordenadaZ2();
                int alt=obstaculo.getAltura();
                
                System.out.println("Chuva detectada na regiao ("+ x1 + "," + y1 + ",0) a (" + x2 + "," + y2+ "," + alt + ")");
            }
        }
    }    
}