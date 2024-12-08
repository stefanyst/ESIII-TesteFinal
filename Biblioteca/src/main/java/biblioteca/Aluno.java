package biblioteca;

public class Aluno {
    private String ra;
    private String nome;
    private boolean pendencias;
    private int livrosEmprestados;

    public Aluno(String ra, String nome) {
        if (!Validador.validarRA(ra)) {
            throw new IllegalArgumentException("RA inválido.");
        }
        this.ra = ra;
        this.nome = nome;
        this.pendencias = false;
        this.livrosEmprestados = 0;
    }

    public boolean verificaAluno() {
        return Validador.validarRA(ra);
    }

    public boolean verificaPendencias() {
        return !pendencias;
    }

    public void setPendencias(boolean pendencias) {
        this.pendencias = pendencias;
    }

    public boolean podeEmprestar() {
        return livrosEmprestados < 5 && !pendencias;
    }

    public void setLivrosEmprestados(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade de livros não pode ser negativa.");
        }
        this.livrosEmprestados = quantidade;

    }

    public String getNome() {
        return nome;
    }
}


