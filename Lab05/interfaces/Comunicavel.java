/*Define caracteristicas de um robo que pode se comunicar com demais robos */
package interfaces;
public interface Comunicavel {
    void enviarMensagem(Comunicavel destinatario, String mensagem);
    void receberMensagem(String mensagem);
}

