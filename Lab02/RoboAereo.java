public class RoboAereo extends Robo{

    private int altitude;
    private int altitudeMaxima;


    public RoboAereo(String nome, int x, int y, String d, int alt, int alt_max){
        super(nome,x,y,d);
        this.altitude = alt;
        this.altitudeMaxima = alt_max;
    }

    public int getaltitudeMaxima(){
        return altitudeMaxima;
    }

    public int getaltitude(){
        return altitude;
    }
    
    public void subir(int altitudeMaxima, int altitude,int deltay){

        if(altitude + deltay < altitudeMaxima){
            this.setCoordenadas_y(deltay);
            System.out.println("o robo subiu" + deltay + "metros.");
        }

        else{
            System.out.println("Altitude acima do permitido :(");
        }

        
    }

    public void descer(int altitude,int deltay, int d){

        if(altitude  - deltay > 0){
            d = - deltay;
            this.setCoordenadas_y(d);
            System.out.println("o robo desceu" + deltay + "metros.");
        }

        else{
            System.out.println("Altitude abaixo do permitido :(");
        }

        
    }

}
