/*
SubClasse de RoboTerrestre- RoboGuerreiro
Objetivo: definir propriedas de RoboGuerreiro e realizar ataques
*/

import java.util.List;

public class RoboGuerreiro extends Robo {
    private int inimigosDerrotados;
    private int dano;

    public RoboGuerreiro(String nome, int x, int y, String d, int dano) {
        super(nome, x, y, d);
        this.inimigosDerrotados = 0;
        this.dano = dano;
    }

    public void atacar(int alvoX, int alvoY) {
        for (int i = 0; i < Ambiente.robosAtivos.size(); i++) {
            Robo robo = Ambiente.robosAtivos.get(i);

            if (robo.getCoordenadaX() == alvoX && robo.getCoordenadaY() == alvoY) {

                if (robo instanceof RoboBlindado) { // no caso de ataques a robos blindados, o dano precisa ser reduzido em sua vida total
                    RoboBlindado blindado = (RoboBlindado) robo; // mudando a classe de robo -> roboBlindado para acessar os atributos
                    int novaVida = blindado.getPontosVida() - dano;

                    if (novaVida > 0) {
                        blindado.setPontosVida(novaVida);
                        System.out.println("Ataque realizado! Vida restante do robô blindado: " + novaVida);
                    } else {
                        Ambiente.robosAtivos.remove(i);
                        inimigosDerrotados++;
                        System.out.println("O RoboBlindado foi destruído!");
                    }
                } else {
                    Ambiente.robosAtivos.remove(i);
                    inimigosDerrotados++;
                    System.out.println("O robô em (" + alvoX + ", " + alvoY + ") foi destruído!");
                }
                return;
            }
        }

        System.out.println("Nenhum robô encontrado na posição (" + alvoX + ", " + alvoY + ").");
    }
}