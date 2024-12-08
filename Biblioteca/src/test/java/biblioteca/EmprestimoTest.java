package biblioteca;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmprestimoTest {

    @Test
    public void testEmprestarLivrosValidos() {
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(1, "Livro A"));
        livros.add(new Livro(2, "Livro B"));

        Emprestimo emprestimo = new Emprestimo();
        assertTrue(emprestimo.emprestar(livros));
    }

    @Test
    public void testEmprestarLivrosComLivroReservado() {
        List<Livro> livros = new ArrayList<>();
        Livro livro = new Livro(1, "Livro A");
        livro.setReservado(true);
        livros.add(livro);

        Emprestimo emprestimo = new Emprestimo();
        assertFalse(emprestimo.emprestar(livros));
    }

    @Test
    public void testEmprestarMaisDeCincoLivros() {
        List<Livro> livros = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            livros.add(new Livro(i, "Livro " + i));
        }

        Emprestimo emprestimo = new Emprestimo();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            emprestimo.emprestar(livros);
        });
        assertEquals("Número de livros inválido para empréstimo.", exception.getMessage());
    }

    @Test
    public void testCalcularDataDevolucao() {
        Emprestimo emprestimo = new Emprestimo();
        LocalDate dataEmprestimo = LocalDate.now();
        // Passe o prazo desejado, por exemplo, 7 dias
        LocalDate dataDevolucao = emprestimo.calcularDataDevolucao(dataEmprestimo, 7);
    
        assertEquals(dataEmprestimo.plusDays(7), dataDevolucao);
    }
    

    @Test
public void testCalcularDataDevolucaoInvalida() {
    Emprestimo emprestimo = new Emprestimo();
    LocalDate dataInvalida = LocalDate.now().minusYears(2);

    // Passe o prazo como 7 dias ou outro valor válido
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        emprestimo.calcularDataDevolucao(dataInvalida, 7);
    });
    assertEquals("Data de empréstimo inválida.", exception.getMessage());
}


    @Test
    public void testEmprestarLivrosValidosEReservados() {
        List<Livro> livros = new ArrayList<>();
        Livro livroValido = new Livro(1, "Livro A");
        Livro livroReservado = new Livro(2, "Livro B");
        livroReservado.setReservado(true);

        livros.add(livroValido);
        livros.add(livroReservado);

        Emprestimo emprestimo = new Emprestimo();
        assertFalse(emprestimo.emprestar(livros));  // Não deve emprestar devido ao livro reservado
    }

    @Test
    public void testCalcularDataDevolucaoComPrazoPersonalizado() {
        Emprestimo emprestimo = new Emprestimo();
        LocalDate dataEmprestimo = LocalDate.now();
        int prazoDias = 14;  // Prazo de 14 dias
        LocalDate dataDevolucao = emprestimo.calcularDataDevolucao(dataEmprestimo, prazoDias);

        assertEquals(dataEmprestimo.plusDays(prazoDias), dataDevolucao);
    }
}

