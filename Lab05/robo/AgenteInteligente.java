package robo;

import environment.Ambiente;
import missao.Missao;

public abstract class AgenteInteligente extends Robo {
    protected Missao mis;
    public AgenteInteligente(String nome, int x, int y, int z, String d) {
        super(nome, x, y, z, d);
        
    }

     public abstract void executarMissao(Ambiente a);

}

