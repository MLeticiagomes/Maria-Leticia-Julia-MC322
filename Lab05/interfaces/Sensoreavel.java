/*Define caracteristicas de um robo com sensores */
package interfaces;
import robo.*;
import sensores.*;
import missao.*;

public interface Sensoreavel {
    void acionarSensores(Sensor sensor, Robo robo, LogMissao log);
}
