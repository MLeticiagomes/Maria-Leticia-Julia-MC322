public class RoboAereo extends Robo{

    private int altitude;
    private int altitudeMaxima;

    public RoboAereo(String nome, int x, int z, String d, int y, int alt_max){
        super(nome,x,z,d);
        this.altitude = y;
        this.altitudeMaxima = alt_max;  
    }

    public int getaltura_maxima(){ /* pega a altura maxima como a do ambiente */
        return altitudeMaxima;
    }

    public int getCoordenadaY(){
        return altitude;
    }

    public void subir(int deltay){ /* muda a coordenada y */
        setCoordenadaY(getCoordenadaY() + deltay);
        
    }

    public void descer(int deltay){ /* muda a coordenada y */
        setCoordenadaY(getCoordenadaY()  - deltay);
    
    }




    public boolean verificarAlturaMax(int distancia){
        int altitude_max = getaltura_maxima();
        altitude = getCoordenadaY();
        if(altitude_max >= altitude){
            return true;
        }
        else{
            return false;
        }
    }
    

    public boolean verificarAlturaMin(int distancia){
        altitude = getCoordenadaY();
        if(altitude - distancia>=0){
            return true;
        }
        else{
            return false;
        }
    }
}
