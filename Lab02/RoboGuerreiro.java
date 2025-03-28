/*
SubClasse de RoboTerrestre- RoboGuerreiro
Objetivo: definir propriedas de RoboGuerreiro e realizar ataques
*/

import java.util.List;

public class RoboGuerreiro extends RoboTerrestre {
    private int inimigosDerrotados;
    private int dano;

    public RoboGuerreiro(String nome, int x, int y, String d, int dano) {
        super(nome, x, y, d);
        this.inimigosDerrotados = 0;
        this.dano = dano;
    }

    public void atacar(int alvoX, int alvoY) {

        int i=0;
    
        for (Robo robo : Ambiente.getrobosAtivos()) {

            if (robo.getCoordenadaX() == alvoX && robo.getCoordenadaY() == alvoY) {

                if (robo instanceof RoboBlindado) { // no caso de ataques a robos blindados, o dano precisa ser reduzido em sua vida total
                    RoboBlindado blindado = (RoboBlindado) robo; // mudando a classe de robo -> roboBlindado para acessar os atributos
                    int novaVida = blindado.getPontosVida() - dano;

                    if (novaVida > 0) {
                        blindado.setPontosVida(novaVida);
                        System.out.println("Ataque realizado! Vida restante do robô blindado: " + novaVida);
                    } else {
                        robosAtivos.remove(i);
                        inimigosDerrotados++;
                        System.out.println("O RoboBlindado foi destruído!");
                    }
                } 
                
                if (robo instanceof RoboKamikaze) { // no caso de ataques a robos kamikaze, acessasr sua funcao de explosaoo
                    RoboKamikaze.sacrificio();
                    robosAtivos.remove(i);
                    inimigosDerrotados++;
                }

                else {
                    robosAtivos.remove(i);
                    inimigosDerrotados++;
                    System.out.println("O robô em (" + alvoX + ", " + alvoY + ") foi destruído!");
                }
                return;
            }
            i++;
        }

        System.out.println("Nenhum robô encontrado na posição (" + alvoX + ", " + alvoY + ").");
    }
}