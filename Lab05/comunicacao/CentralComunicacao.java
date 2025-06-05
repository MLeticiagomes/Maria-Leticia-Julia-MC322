/*
Classe Central Comunicacao
Objetivo: armazenar mensagens trocadas entre robos
*/
package comunicacao;
import java.util.ArrayList;
import java.util.List;

public class CentralComunicacao {
   private static ArrayList <String> mensagens;

    public CentralComunicacao(){
        mensagens = new ArrayList<>();
    }

    public void registrarMensagem (String remetente, String msg){
        mensagens.add(remetente+" enviou: '"+msg+"'");
    }

    public static ArrayList<String> getMensagens(){
        return mensagens;
    }

    public void exibirMensagens(){
        List<String> chat = CentralComunicacao.getMensagens();
        if (chat==null){
            System.out.println("A central ainda nao registrou nehuma mensagem");
        }
        else{
            for (int i = 0; i < chat.size(); i++) {
                String mensagem = chat.get(i);
                System.out.println(mensagem+"\n");
            }
        }
    }
}