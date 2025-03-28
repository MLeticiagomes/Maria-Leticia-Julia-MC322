/*
Classe Ambiente
Objetivo: definir propriedas do ambiente e analisar limites
*/

import java.util.ArrayList;

public class Ambiente {
    private int largura;
    private int altura;
    private static ArrayList<Robo> robosAtivos;

    public Ambiente(int l, int a){
        this.largura=l;
        this.altura=a;
        this.robosAtivos = new ArrayList<>();
    }

    public static ArrayList<Robo> getRobosAtivos() {
        return robosAtivos;
    }

    public int getAltura(){
        return this.altura;
    }

    public boolean dentroDosLimites(int x, int y){ /*verifica se nova coordenada do robo esta dentro do ambiente */
        if (x<0 || y<0){
            System.out.println("Insira apenas coordenadas positivas!");
            return false;
        }
        else if (x<largura && y<altura){
            return true;
        }
        else if (x>largura){
            System.out.println("Largura fora dos limites :(");
            return false;
        }
        else{
            System.out.println("Altura fora dos limites :(");
            return false;
        }
    } 

    public  static void adicionarRobo(Robo r){ /*adiciona novo robo na lista de robos */
        robosAtivos.add(r);
    }
    
    public static ArrayList<Robo> getrobosAtivos(){
        return robosAtivos;
    }
}

