package biblioteca;

import java.time.LocalDate;
import java.util.List;

public class Emprestimo {

    public boolean emprestar(List<Livro> livros) {
        if (livros == null || livros.isEmpty() || livros.size() > 5) {
            throw new IllegalArgumentException("Número de livros inválido para empréstimo.");
        }

        for (Livro livro : livros) {
            if (!livro.isDisponivel()) {
                System.out.println("Livro já reservado: " + livro.getCodigo());
                return false;
            }
        }

        // Alterar o estado dos livros para "reservado"
        for (Livro livro : livros) {
            livro.reservar();
        }

        return true;
    }

    public LocalDate calcularDataDevolucao(LocalDate dataEmprestimo, int prazoDias) {
        if (dataEmprestimo.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data de empréstimo inválida.");
        }
        return dataEmprestimo.plusDays(prazoDias);
    }

    public boolean validarPrazoDevolucao(LocalDate dataDevolucao) {
        return dataDevolucao != null && dataDevolucao.isAfter(LocalDate.now());
    }
}

