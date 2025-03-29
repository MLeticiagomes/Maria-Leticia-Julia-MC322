/*
SubClasse de RoboTerrestre- RoboGuerreiro
Objetivo: definir propriedas de RoboGuerreiro e realizar ataques
*/

import java.util.List;

public class RoboGuerreiro extends RoboTerrestre {
    private int inimigosDerrotados;
    private int dano;

    public RoboGuerreiro(String nome, int x, int y, String d, int velocidadeMax, int dano) {
        super(nome, x, y, d, velocidadeMax);
        this.inimigosDerrotados = 0;
        this.dano = dano;
    }

    public void atacar(int alvoX, int alvoY) {
        List<Robo> robos = Ambiente.getrobosAtivos();
    
        for (int i = 0; i < robos.size(); i++) {
            Robo robo = robos.get(i);
    
            if (robo.getCoordenadaX() == alvoX && robo.getCoordenadaY() == alvoY) {
    
                if (robo instanceof RoboBlindado) { 
                    RoboBlindado blindado = (RoboBlindado) robo;
                    int novaVida = blindado.getPontosVida() - dano;
    
                    if (novaVida > 0) {
                        blindado.dano(dano);
                        System.out.println("Ataque realizado! Vida restante do robô blindado: " + blindado.getPontosVida());
                    } else {
                        Ambiente.removerRobo(robo);
                        inimigosDerrotados++;
                        System.out.println("O RoboBlindado foi destruído!");
                    }
                } 
                else if (robo instanceof RoboKamikaze) { 
                    System.out.println("O robô kamikaze foi destruído!");
                    ((RoboKamikaze) robo).sacrificio();
                    Ambiente.removerRobo(robo);

                    inimigosDerrotados++;
                }
                else {
                    Ambiente.removerRobo(robo);
                    inimigosDerrotados++;
                    System.out.println("O robô em (" + alvoX + ", " + alvoY + ") foi destruído!");
                }
                return;
            }
        }
        System.out.println("Nenhum robô encontrado na posição (" + alvoX + ", " + alvoY + ").");
    }
}
