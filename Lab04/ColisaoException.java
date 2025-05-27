import java.util.List;

public class ColisaoException extends Exception { 
  public ColisaoException(String mensagem){
      super(mensagem);
  }

public static void verificarPosicaoOcupada(Ambiente ambiente, int x, int y, int z) throws ColisaoException{
List<Entidade> ents = Ambiente.getEntidade();
    
  for (int i = 0; i < ents.size(); i++) { /* verifica se a casa esta ocupada por um robo ou um objeto */
      Entidade entidade = ents.get(i);
      if (entidade.getEntidade() == TipoEntidade.ROBO){
          Robo robo = (Robo) entidade;
          if (robo.getX() == x && robo.getY() == y && robo.getZ() == z) { /* se estiver ocupada imprime a frase */
              throw new ColisaoException("Posicao (" + x + "," + y + "," + "," + z + ") ocupada pelo robo" + robo.getNome()+ ".");              
          }
      }


      else if (entidade.getEntidade() == TipoEntidade.OBSTACULO){
          Obstaculo obstaculo = (Obstaculo) entidade;
          int x1 = obstaculo.getCoordenadaX1();
          int x2 = obstaculo.getCoordenadaX2();
          int z1 = obstaculo.getCoordenadaZ1();
          int z2 = obstaculo.getCoordenadaZ2();
           int xMin = Math.min(x1, x2); /* calcula o min e max entre os pontos */
          int xMax = Math.max(x1, x2);
          int zMin = Math.min(z1, z2);
          int zMax = Math.max(z1, z2);
           boolean dentroDaBase = (x>= xMin && x <= xMax && /* verifica se o ponto de  é maior que o minimo e menor que o maximp */
                                  z >= zMin && z <= zMax);
           int alturaObstaculo = obstaculo.getTipo().getTamanhoVertical();
          int yMin = obstaculo.getAltura();
          int yMax = yMin + alturaObstaculo;
           boolean dentroDaAltura = (y >= yMin && y <= yMax); /* verifica se o ponto y esta entre a base e a altura do objeto */
          boolean podeAtravessar = obstaculo.getTipo().getpodeAtravessar();
           if (dentroDaBase && dentroDaAltura && !podeAtravessar) { /* se estiver dentro da base, da altura e nao puder atravessar o objeto ele retorna true */
              throw new ColisaoException("Posição (" + x + ", " + y + ", " + z + ") ocupada por obstáculo do tipo " + obstaculo.getTipo());
          }
          }
      }
    }
}










