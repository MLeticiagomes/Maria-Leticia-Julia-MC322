public class RoboAereo extends Robo{

    private int altitude;
    private int altitudeMaxima;

    public RoboAereo(String nome, int x, int y, String d, int alt_max){
        super(nome,x,y,d);
        this.altitude = y;
        this.altitudeMaxima = alt_max;  
    }

    public int getaltura_maxima(){ /* pega a altura maxima como a do ambiente */
       return altitudeMaxima;
    }

    public void subir(int deltay){ /* muda a coordenada y */
        setCoordenadaY(getCoordenadaY() + deltay);
        
    }

    public void descer(int deltay){ /* muda a coordenada y */
        setCoordenadaY(getCoordenadaY()  - deltay);
        
    }




    public boolean verificarAltura(int distancia){
        int altitude_max = getaltura_maxima();
        altitude = getCoordenadaY();
        if(altitude_max >= altitude + distancia){
            return true;
        }
        else{
            return false;
        }
    }
    
}
