import java.util.List;


public class RoboCurandeiro extends RoboAereo implements Comunicavel, Cooperativo{ //cura robos em seu eixo y
   private int poderDeCura;


   public RoboCurandeiro(String nome, int x, int y,  int z, String d, int alt_max, int poderDeCura){
       super(nome, x, y, z, d, alt_max);
       this.poderDeCura = poderDeCura;
   }


   public int getPoderDeCura(){
     return poderDeCura;
   }
   
   @Override 
   public void cooperarCom(Cooperativo roboAmigo) throws CooperativoException{ /* Robo pode cooperar apenas com outros robos cooperativos */
    if (roboAmigo!=this){
        int bonus=5; /*bonus fixo */
        this.poderDeCura+=bonus;
        System.out.println(getNome() + "recebeu um bonus de cura pelo poder da cooperacao :)");

    }
    else{
        throw new CooperativoException("O robo" + this.getNome() + " nao pode cooperar consigo mesmo");
    }
   }

   @Override
   public void enviarMensagem(Comunicavel destinatario, String mensagem){
        System.out.println(getNome() + "enviou a seguinte mensagem:" + mensagem);
        destinatario.receberMensagem(mensagem);
   }

   @Override
   public void receberMensagem(String mensagem){
        System.out.println("A mensagem foi recebida com sucesso por:" + getNome());
   }

   @Override
   public int getX() { /* pega a coordenada x do robo */
       return super.getX();
   }


   @Override
   public int getZ() { /* pega a coordenada z do robo */
       return super.getZ();
   }


   public Boolean checarVida (RoboBlindado blindado) throws VidaMaximaException{ /* verifica se a vida do robo mais os pontos de cura nao excede a vida maxima permitida  */
       int pontosV = blindado.getPontosVida();
       int pontosVMax =  blindado.getVidaMax();
       if (pontosV + this.poderDeCura <= pontosVMax){
           return true;
       }


       else{
        throw new VidaMaximaException("O robo" + blindado.getNome() + " esta com a vida maxima");
           }
   }

 
   public void verificarPosicaoZ(){
       int posicaoZ = this.getZ();
       List<Entidade> ents = Ambiente.getEntidade();
       for (int i = 0; i < ents.size(); i++) {
           Entidade entidade = ents.get(i);
           if (entidade.getEntidade() == TipoEntidade.ROBO){ /* verifica se a entidade é do tipo robo, se for executa as funçoes */
                Robo robo = (Robo) entidade;  
                if (robo != this && robo.getZ() == posicaoZ){
                    try{
                        verificarPosicaoX();
                    }
                    catch(VidaMaximaException e){
                        System.out.println(e.getMessage());
                    }
                 
                }
           }
       }
   }

   public void verificarPosicaoX() throws VidaMaximaException{
       int posicaoX = this.getX(); /* verifica se um robo na lista esta na mesma posicao x do robo curandeiro */
       
       List<Entidade> ents = Ambiente.getEntidade();
       for (int i = 0; i < ents.size(); i++) {
           Entidade entidade = ents.get(i);
           if (entidade.getEntidade() == TipoEntidade.ROBO){ /* verifica se a entidade é do tipo robo, se for executa as funçoes */
                Robo robo = (Robo) entidade;  
                if (robo != this && robo.getX() == posicaoX){
                    if(robo instanceof RoboBlindado){ /* verifica se o robo e um robo blindado */
                        RoboBlindado blindado = (RoboBlindado) robo;
                        blindado.consultarVida();
                        if(checarVida(blindado) == true){ /* se for verdadeiro adiciona vida */
                            blindado.cura(poderDeCura);
                            System.out.println("Robo " + blindado.getNome() + " esta com "  + blindado.getPontosVida()+ " xp.");
                        }
                        else{
                            throw new VidaMaximaException("O robo" + blindado.getNome() + " esta com a vida maxima"); /* chama a exception */
                        }
                    
                   }
            
               }
            }
       }
   }

   @Override
   public void executarTarefa(){
       verificarPosicaoZ();
   }

}