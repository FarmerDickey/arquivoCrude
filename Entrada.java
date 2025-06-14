public abstract class Entrada {
    protected String nome;
    protected Diretorio pai;

    public Entrada(String nome, Diretorio pai) {
        this.nome = nome;
        this.pai = pai;
    }

    public String getNome() {
        return nome;
    }

    public Diretorio getPai() {
        return pai;
    }

    public String getCaminhoAbsoluto() {
        if (pai == null) return nome; // raiz
        return pai.getCaminhoAbsoluto() + "/" + nome;
    }

    public abstract boolean isDiretorio();
}
