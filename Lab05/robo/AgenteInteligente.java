package robo;

import environment.Ambiente;
import missao.Missao;

public abstract class AgenteInteligente extends Robo {
    protected Missao mis;
    public AgenteInteligente(String nome, int x, int y, int z, String d) {
        super(nome, x, y, z, d);
        
    }

     public abstract void executarMissao(Ambiente a);

    public void iniciarMissao(Ambiente ambiente) {
        if (missao != null) {
            missao.executar(this, ambiente);
        } else {
            System.out.println("Nenhuma missão atribuída ao robô " + getNome());
        }
    }

}

