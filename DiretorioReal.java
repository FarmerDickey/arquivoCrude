import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiretorioReal {
    private File diretorioAtual;

    public DiretorioReal(String caminhoInicial) {
        diretorioAtual = new File(caminhoInicial);
        if (!diretorioAtual.exists() || !diretorioAtual.isDirectory()) {
            throw new IllegalArgumentException("Diretório inválido: " + caminhoInicial);
        }
    }

    public String getCaminhoAtual() {
        return diretorioAtual.getAbsolutePath();
    }

    public boolean mudarDiretorio(String nome) {
        if (nome.equals("..")) {
            File pai = diretorioAtual.getParentFile();
            if (pai != null && pai.isDirectory()) {
                diretorioAtual = pai;
                return true;
            }
            return false;
        } else {
            File novoDir = new File(diretorioAtual, nome);
            if (novoDir.exists() && novoDir.isDirectory()) {
                diretorioAtual = novoDir;
                return true;
            }
            return false;
        }
    }

    public List<String> listarConteudo() {
        File[] arquivos = diretorioAtual.listFiles();
        List<String> lista = new ArrayList<>();
        if (arquivos != null) {
            Arrays.stream(arquivos).forEach(f -> {
                if (f.isDirectory()) {
                    lista.add(f.getName() + "/");
                } else {
                    lista.add(f.getName());
                }
            });
        }
        return lista;
    }

    // Método tree com visual mais limpo
    public void mostrarTree(String prefixo) {
        System.out.println("📁 " + diretorioAtual.getName());
        mostrarTreeRecursivo(diretorioAtual, "", true);
    }

    private void mostrarTreeRecursivo(File dir, String prefixo, boolean ultimo) {
        File[] arquivos = dir.listFiles();
        if (arquivos == null) return;

        for (int i = 0; i < arquivos.length; i++) {
            File f = arquivos[i];
            boolean isLast = (i == arquivos.length - 1);

            String simbolo = isLast ? "└── " : "├── ";
            String novoPrefixo = prefixo + (ultimo ? "    " : "│   ");
            String icone = f.isDirectory() ? "📁 " : "📄 ";

            System.out.println(prefixo + simbolo + icone + f.getName());

            if (f.isDirectory()) {
                mostrarTreeRecursivo(f, novoPrefixo, isLast);
            }
        }
    }
}
