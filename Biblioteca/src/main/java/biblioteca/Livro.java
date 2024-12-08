package biblioteca;

public class Livro {
    private int codigo;
    private String titulo;
    private boolean reservado;

    public Livro(int codigo, String titulo) {
        if (!Validador.validarCodigoLivro(codigo)) {
            throw new IllegalArgumentException(Mensagens.CODIGO_LIVRO_INVALIDO); 
        }
        if (!Validador.validarTitulo(titulo)) {
            throw new IllegalArgumentException(Mensagens.TITULO_LIVRO_INVALIDO); 
        }
        this.codigo = codigo;
        this.titulo = titulo;
        this.reservado = false; 
    }

    public int verPrazo() {
        // Exemplo: Retorna o prazo fixo de 14 dias
        return 14;
    }
    
    public boolean isDisponivel() {
        return !reservado;
    }

    public void reservar() {
        if (isDisponivel()) {
            this.reservado = true; // Reservar o livro
        } else {
            throw new IllegalStateException(Mensagens.LIVRO_NAO_DISPONIVEL); 
        }
    }

    public void devolver() {
        if (!isDisponivel()) {
            this.reservado = false; // Marcar o livro como disponível
        } else {
            throw new IllegalStateException(Mensagens.LIVRO_JA_DISPONIVEL); 
        }
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    
}

