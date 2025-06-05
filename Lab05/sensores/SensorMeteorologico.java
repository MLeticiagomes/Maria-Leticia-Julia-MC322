/*
SubClasse de Sensor- Sensor Meteorologico
Objetivo: definir propriedas de SensorMeteorologico e identificar clima em seu raio
*/
package sensores;
import entidade.*;
import environment.*;
import java.util.List;
import obstaculo.*;

public class SensorMeteorologico extends Sensor {
    public SensorMeteorologico(int raio, String nome){
        super(raio,nome);
    }

    public void identificarClima(int posX, int posZ){  
        List<Entidade> ents = Ambiente.getEntidade();
        for (int i = 0; i < ents.size(); i++) {
            Entidade entidade = ents.get(i);
            if (entidade.getEntidade() == TipoEntidade.ROBO){ /* verifica se a entidade é do tipo robo, se for executa as funçoes */
                Obstaculo obstaculo = (Obstaculo) entidade; 
                if (obstaculo.getTipo()==Obstaculo.TipoObstaculo.NUVEM){
                    int x1=obstaculo.getCoordenadaX1();
                    int x2=obstaculo.getCoordenadaX2();
                    int y1=obstaculo.getCoordenadaZ1();
                    int y2=obstaculo.getCoordenadaZ2();
                    int alt=obstaculo.getAltura();

                    int raio=getRaio();

                    int xmax= posX + raio;
                    int xmin= posX - raio;
                    int zmax= posZ + raio;
                    int zmin= posZ - raio;
                    
                    if((xmin<posX && posX<xmax) || (zmin<posZ && posZ<zmax)){
                        System.out.println("Chuva detectada na regiao ("+ x1 + "," + y1 + ",0) a (" + x2 + "," + y2+ "," + alt + ")");
                    }
                }
            }
    } 
  }   
}