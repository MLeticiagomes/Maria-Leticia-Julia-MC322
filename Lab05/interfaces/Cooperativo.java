/*Define caracteristicas de um robo que pode cooperar com demais robos cooperativos aumentando a eficiencia na realizacaod e tarefas */
package interfaces;
import excecoes.*;
public interface Cooperativo {
    void cooperarCom(Cooperativo roboAmigo) throws CooperativoException;
}
