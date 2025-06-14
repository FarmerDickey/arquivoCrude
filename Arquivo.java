public class Arquivo extends Entrada {
    private String conteudo;

    public Arquivo(String nome, Diretorio pai, String conteudo) {
        super(nome, pai);
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String novoConteudo) {
        this.conteudo = novoConteudo;
    }

    @Override
    public boolean isDiretorio() {
        return false;
    }
}
