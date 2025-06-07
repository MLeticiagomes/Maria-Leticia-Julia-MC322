package modulos;
import sensores.*;
import java.util.ArrayList;

public class GerenciadorSensores {
    private ArrayList<Sensor> sensores;

    public GerenciadorSensores() {
        this.sensores = new ArrayList<>();
    }

    public void adicionarSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    public ArrayList<Sensor> getSensores() {
        return sensores;
    }

    public ArrayList<Sensor> getsensoresDosRobos(){
        return sensores;
       }
}
