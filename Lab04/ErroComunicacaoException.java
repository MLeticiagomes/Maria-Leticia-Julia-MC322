
public class ErroComunicacaoException extends Exception{
    public ErroComunicacaoException(String mensagem){
        super(mensagem);
    }
  
  
  public static void verificarComunicacao(Robo robo) throws ErroComunicacaoException{
      if(!(robo instanceof Comunicavel)){
          throw new ErroComunicacaoException ("O robo" + robo.getNome() + "nao possui suporte para receber mensagens");
        }
  }
}
  
  
  
  