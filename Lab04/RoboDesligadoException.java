public class RoboDesligadoException  extends Exception{
    public RoboDesligadoException(String mensagem){
        super(mensagem);
    }
 public static void VerificarInterruptor (Robo robo) throws RoboDesligadoException{
    if(robo.getEstado() == EstadoRobo.DESLIGADO){
        throw new RoboDesligadoException("O robo" + robo.getNome() + "esta desligado, voce nao pode move-lo");
    }
 }
 }
 