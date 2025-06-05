package sensores;
import java.util.List;
import java.util.Scanner;

public class Sensor {
    private Scanner scanner = new Scanner(System.in);
    private int raio;
    private String nome;

    public Sensor(int raio, String nome){
        this.raio = raio;
        this.nome = nome; /*tipo do sensor */
    }

    public int getRaio(){
        return raio;
    }

    public String getNome(){
        return nome;
    }

    public boolean monitorar(List<Sensor> sensores){
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
