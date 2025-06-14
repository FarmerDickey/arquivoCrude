import java.util.ArrayList;
import java.util.List;

public class Journal {
    private List<String> logs = new ArrayList<>();

    public void registrar(String mensagem) {
        logs.add(mensagem);
    }

    public void mostrarLog() {
        if (logs.isEmpty()) {
            System.out.println("Nenhuma ação registrada.");
        } else {
            System.out.println("Registro de ações:");
            for (String log : logs) {
                System.out.println("- " + log);
            }
        }
    }
}
