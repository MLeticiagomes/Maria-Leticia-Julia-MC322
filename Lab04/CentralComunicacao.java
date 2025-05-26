/*
Classe Central Comunicacao
Objetivo: armazenar mensagens trocadas entre robos
*/
import java.util.ArrayList;
import java.util.List;

public class CentralComunicacao {
   private static ArrayList <String> mensagens;

    public CentralComunicacao(){
        mensagens = new ArrayList<>();
    }

    public static void registrarMensagem (String remetente, String msg){
        mensagens.add(remetente+" enviou: '"+msg+"'");
    }

    public static ArrayList<String> getMensagens(){
        return mensagens;
    }

    public static void exibirMensagens(){
        List<String> chat = CentralComunicacao.getMensagens();
        for (int i = 0; i < chat.size(); i++) {
            String mensagem = chat.get(i);
            System.out.println(mensagem+"\n");
        }
    }
}