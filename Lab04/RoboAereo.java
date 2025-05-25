public abstract class RoboAereo extends Robo{

    private int altitude;
    private int altitudeMaxima;

    public RoboAereo(String nome, int x, int y, int z, String d, int alt_max){
        super(nome,x,y, z,d);
        this.altitude = y;
        this.altitudeMaxima = alt_max;  
    }

    public int getaltura_maxima(){ /* pega a altura maxima como a do ambiente */
        return altitudeMaxima;
    }


    public boolean verificarAlturaMax(){
        int altitude_max = getaltura_maxima();
        altitude = getY();
        if(altitude_max >= altitude){
            return true;
        }
        else{
            return false;
        }
    }
    
}
