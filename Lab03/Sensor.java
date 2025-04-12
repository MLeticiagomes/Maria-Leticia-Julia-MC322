import java.util.List;
import java.util.Scanner;

public class Sensor {
    private Scanner scanner = new Scanner(System.in);
    private int raio;
    private Robo dono;
    private String nome;

    public Sensor(int raio, Robo dono, String nome){
        this.raio = raio;
        this.dono = dono;
        this.nome = nome;
        Robo.adicionarSensor(this);
    }
    public int getRaio(){
        return raio;
    }
    public Robo getDono(){
        return dono;
    }

    List<Sensor> sensores = Robo.getsensoresDosRobos();
    public boolean monitorar(){
        if(sensores == null){
            System.out.println("Esse robo nao possui sensores :(");
            return false;

        }
        else{
            int numero_de_sensores = sensores.size();
            System.out.println("Numero de sensores do robo: "+ numero_de_sensores + ".");
            return true;
        }
    }

    


}
