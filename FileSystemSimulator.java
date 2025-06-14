import java.util.Scanner;
import java.util.List;

public class FileSystemSimulator {
    private DiretorioReal diretorioReal;
    private Journal journal;

    public FileSystemSimulator() {
        inicializarSistema();
    }

    private void inicializarSistema() {
        diretorioReal = new DiretorioReal(System.getProperty("user.dir"));
        journal = new Journal();
    }

    public void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simulador de Sistema de Arquivos (Diretórios Reais)");
        while (true) {
            System.out.print(diretorioReal.getCaminhoAtual() + " > ");
            String comando = scanner.nextLine().trim();

            if (comando.equals("exit")) {
                break;

            } else if (comando.equals("ls")) {
                List<String> conteudo = diretorioReal.listarConteudo();
                for (String item : conteudo) {
                    System.out.println(item);
                }
                journal.registrar("Listou conteúdo de: " + diretorioReal.getCaminhoAtual());

            } else if (comando.startsWith("cd ")) {
                String destino = comando.substring(3).trim();
                if (diretorioReal.mudarDiretorio(destino)) {
                    journal.registrar("Entrou no diretório: " + diretorioReal.getCaminhoAtual());
                } else {
                    System.out.println("Diretório não encontrado.");
                    journal.registrar("Tentativa falha de entrar em: " + destino);
                }

            } else if (comando.equals("tree")) {
                diretorioReal.mostrarTree("");
                journal.registrar("Visualizou árvore em: " + diretorioReal.getCaminhoAtual());

            } else if (comando.equals("log")) {
                journal.mostrarLog();

            } else {
                System.out.println("Comando não reconhecido.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        FileSystemSimulator fs = new FileSystemSimulator();
        fs.executar();
    }
}
