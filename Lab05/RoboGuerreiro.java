/*
SubClasse de RoboTerrestre- RoboGuerreiro
Objetivo: definir propriedas de RoboGuerreiro e realizar ataques
*/

import java.util.List;

public class RoboGuerreiro extends RoboTerrestre implements Comunicavel{
  private int inimigosDerrotados;
  private int dano;


  public RoboGuerreiro(String nome, int x, int y, int z, String d, int velocidadeMax, int dano) {
      super(nome, x, y, z, d, velocidadeMax);
      this.inimigosDerrotados = 0;
      this.dano = dano;
  }

  @Override
   public void enviarMensagem(Comunicavel destinatario, String mensagem){
        System.out.println(getNome() + " enviou a seguinte mensagem:" + mensagem);
        destinatario.receberMensagem(mensagem);
   }

   @Override
   public void receberMensagem(String mensagem){
        System.out.println("A mensagem foi recebida com sucesso por: " + getNome());
   }

  public int getDano() { /* pega a coordenada x do robo */
    return dano;
  }

  public void atacar(int alvoX, int alvoY, int alvoZ) {
      List<Entidade> ents = Ambiente.getEntidade();

      for (int i = 0; i < ents.size(); i++) {
          Entidade entidade = ents.get(i);
          if (entidade.getEntidade() == TipoEntidade.ROBO){ /* verifica se a entidade é do tipo robo, se for executa as funçoes */
               Robo robo = (Robo) entidade; 
           if (robo.getX() == alvoX  && robo.getY() == alvoY  && robo.getZ() == alvoZ ) { /* verifica se existe um robo na posicao */
               if (robo instanceof RoboBlindado) { /* verifica se o tipo de robo e blindado e tira pontos de vida */
                  RoboBlindado blindado = (RoboBlindado) robo;
                  int novaVida = blindado.getPontosVida() - dano;
                   if (novaVida > 0) {
                      blindado.dano(dano);
                      System.out.println("Ataque realizado! Vida restante do robô blindado: " + blindado.getPontosVida());
                  } else {
                      Ambiente.removerEntidade(robo);
                      inimigosDerrotados++;
                      System.out.println("O RoboBlindado foi destruído!");
                  }
              }
              else if (robo instanceof RoboKamikaze) {  /* verifica se o robo e kamikaze , se for ativa a função de auto destruicao do robo */
                  System.out.println("O robô kamikaze foi destruído!");
                  ((RoboKamikaze) robo).sacrificio();
                  Ambiente.removerEntidade(robo);
                  inimigosDerrotados++;
              }
              else {
                Ambiente.removerEntidade(robo);
                  inimigosDerrotados++;
                  System.out.println("O robô em (" + alvoX + "," + alvoY+ "," + alvoZ +") foi destruído!");
              }
              return;
          }
      }
      System.out.println("Nenhum robô encontrado na posição (" + alvoX + "," + alvoY+ "," + alvoZ +").");
    }
 }

 @Override
public void executarTarefa() { /* percorre a lista e acha o robo blindado com menor vida para atacar */
    List<Entidade> entidades = Ambiente.getEntidade();
    RoboBlindado alvoComMenorVida = null;
    int menorVida = Integer.MAX_VALUE;

    for (int i = 0; i < entidades.size(); i++) {
        Entidade entidade = entidades.get(i);
        if (entidade.getEntidade() == TipoEntidade.ROBO) {
            if (entidade instanceof RoboBlindado) {
                RoboBlindado blindado = (RoboBlindado) entidade;
                if (blindado.getPontosVida() < menorVida) {
                    menorVida = blindado.getPontosVida();
                    alvoComMenorVida = blindado;
                }
            }
        }
    }

    if (alvoComMenorVida != null) {
        System.out.println("O robo blindado com menor vida foi encontrado na posicao ("   + alvoComMenorVida.getX() + ","  + alvoComMenorVida.getY() + "," + alvoComMenorVida.getZ() + ")");
    } else {
        System.out.println("Nenhum RoboBlindado encontrado no ambiente.");
    }
}


}








