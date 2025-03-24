public class RoboAereo extends Robo{

    private int altitude;
    private int altitudeMaxima;
    private Ambiente ambiente;
    private Robo robo;


    public RoboAereo(String nome, int x, int y, String d, int alt, int alt_max){
        super(nome,x,y,d);
        this.altitude = alt;
        this.altitudeMaxima = alt_max;
        this.ambiente = ambiente;
        this.robo = robo; 
        
    }

    public int getaltura_maxima(){ /* pega a altura maxima como a do ambiente */
       return ambiente.getAltura();
    }

    public int getaltitude(){ /* pega a altitude do robo como sua coordenada y */
        return robo.getCoordenadaY();
    }
    
    public void subir(int altitudeMaxima, int altitude,int deltay){

        if(altitude + deltay < getaltura_maxima()){ /* compara a altura do robo com a maxima */
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
