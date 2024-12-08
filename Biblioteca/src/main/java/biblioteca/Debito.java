package biblioteca;

public class Debito {
    int codigoAluno;

    public Debito(int aluno) {
        this.codigoAluno = aluno;
    }

    public boolean verificaDebito() {
        return this.codigoAluno != 4;
    }
}
