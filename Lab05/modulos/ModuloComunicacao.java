package modulos;
import robo.*;
import interfaces.*;

public class ModuloComunicacao {
    private Robo robo;

    public ModuloComunicacao(Robo robo) {
        this.robo = robo;
    }

    public void enviarMensagem(Comunicavel destino, String mensagem) {
        if(robo instanceof Comunicavel){
            ((Comunicavel)robo).enviarMensagem(destino, mensagem);
        }
    }

    public void receberMensagem(String origem, String mensagem) {
        if(robo instanceof Comunicavel){
            ((Comunicavel)robo).receberMensagem(mensagem);
        }
    }
}
