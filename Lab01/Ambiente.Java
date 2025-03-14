/*
Classe Ambiente
Objetivo: definir propriedas do ambiente e analisar limites
*/

public class Ambiente {
    private int largura;
    private int altura;

    public Ambiente(int l, int a){
        this.largura=l;
        this.altura=a;
    }

    public boolean dentroDosLimites(int x, int y){
        if (x<largura && y<altura)
            return true;
        else
            System.out.println("Posicao fora dos limites :(");
            return false;
    } 
}
