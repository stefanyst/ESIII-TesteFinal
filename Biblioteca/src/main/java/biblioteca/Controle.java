package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Controle {

    public boolean emprestar(String alunoRA, int[] codigosLivros, int numLivros) {
        if (!Validador.validarRA(alunoRA)) {
            System.out.println(Mensagens.RA_INVALIDO);
            return false;
        }

        Aluno aluno = new Aluno(alunoRA, ""); // Inicializando apenas com o RA
        if (!aluno.verificaPendencias()) {
            System.out.println(Mensagens.ALUNO_COM_PENDENCIAS);
            return false;
        }

        List<Livro> livros = new ArrayList<>();
        for (int i = 0; i < numLivros; i++) {
            int codigo = codigosLivros[i];
            if (!Validador.validarCodigoLivro(codigo)) {
                System.out.println(Mensagens.CODIGO_LIVRO_INVALIDO + ": " + codigo);
                return false;
            }
            Livro livro = new Livro(codigo, "Livro " + codigo);
            if (!livro.isDisponivel()) {
                System.out.println(Mensagens.LIVRO_NAO_DISPONIVEL + ": " + codigo);
                return false;
            }
            livro.reservar(); // Alterando o estado para reservado
            livros.add(livro);
        }

        if (livros.size() > 5) {
            System.out.println(Mensagens.LIMITE_LIVROS_EXCEDIDO);
            return false;
        }

        Emprestimo emprestimo = new Emprestimo();
        return emprestimo.emprestar(livros);
    }
}

