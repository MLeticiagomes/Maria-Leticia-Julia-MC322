/*
Classe Ambiente
Objetivo: definir propriedas do ambiente e analisar limites
*/

import java.util.ArrayList;

public class Ambiente {
    private int largura;
    private int altura;
    private ArrayList<Robo> robosAtivos;

    public Ambiente(int l, int a){
        this.largura=l;
        this.altura=a;
    }

    public boolean dentroDosLimites(int x, int y){
        if (x<largura && y<altura)
            return true;
        else if (x<0 || y<0)
            System.out.println("Insira apenas coordenadas positivas!");
            return false;
        else if
            (x>largura)
            System.out.println("Largura fora dos limites :(");
            return false;
        else
            System.out.println("Altura fora dos limites :(");
            return false;
    } 

    public void adicionarRobo(Robo r){
        robosAtivos.add(r);
    }
}

