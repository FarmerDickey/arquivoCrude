import java.util.*;

public class Diretorio extends Entrada {
    private Map<String, Entrada> conteudo;

    public Diretorio(String nome, Diretorio pai) {
        super(nome, pai);
        this.conteudo = new HashMap<>();
    }

    public void adicionarEntrada(Entrada entrada) {
        conteudo.put(entrada.getNome(), entrada);
    }

    public Entrada getEntrada(String nome) {
        return conteudo.get(nome);
    }

    public Collection<Entrada> listarEntradas() {
        return conteudo.values();
    }

    @Override
    public boolean isDiretorio() {
        return true;
    }

    public void mostrarTree(String prefixo) {
        System.out.println(prefixo + this.getNome() + "/");

        for (Entrada entrada : this.listarEntradas()) {
            if (entrada instanceof Diretorio) {
                ((Diretorio) entrada).mostrarTree(prefixo + "    ");
            } else {
                System.out.println(prefixo + "    " + entrada.getNome());
            }
        }
    }

}
