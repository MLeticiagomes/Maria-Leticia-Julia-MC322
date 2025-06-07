package modulos;

import excecoes.*;
import environment.*;
import robo.*;

public class ControleMovimento {
    private Robo robo;
    private Ambiente ambiente;

    public ControleMovimento(Robo robo, Ambiente ambiente) {
        this.robo = robo;
        this.ambiente = ambiente;
    }

    public void moverPara(int x, int y, int z) throws RoboDesligadoException, ForaDosLimitesException {
        if (robo.getEstado() == EstadoRobo.DESLIGADO) {
            throw new RoboDesligadoException("O robô está desligado.");
        }

        if (!ambiente.dentroDosLimites(x, z)) {
            throw new ForaDosLimitesException("Destino fora dos limites.");
        }

        if (y != 0 && !(robo instanceof RoboAereo)) {
            System.out.println("Robôs terrestres não podem se mover no eixo Y.");
            return;
        }

        robo.setCoordenada_x(x);
        robo.setCoordenada_z(z);
        robo.setCoordenada_y(y);
        robo.exibir_posicao();
    }
}
