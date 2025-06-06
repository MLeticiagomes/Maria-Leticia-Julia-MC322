package missao;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogMissao {
    private List<String> linhas = new ArrayList<>();

    public void registrar(String linha) {
        linhas.add(linha);
        System.out.println("[LOG] " + linha);
    }

    public void salvar(String nomeArquivo) {
        try (FileWriter fw = new FileWriter(nomeArquivo)) {
            for (String linha : linhas) {
                fw.write(linha + "\n");
            }
            System.out.println("Log salvo em " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
