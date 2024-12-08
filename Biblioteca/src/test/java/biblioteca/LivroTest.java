package biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    @Test
    public void testCriacaoLivroValido() {
        Livro livro = new Livro(1, "Livro A");
        assertTrue(livro.isDisponivel());
    }

    @Test
    public void testCriacaoLivroCodigoInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Livro(-1, "Livro A");
        });
        assertEquals("Dados do livro inválidos.", exception.getMessage());
    }

    @Test
    public void testSetReservado() {
        Livro livro = new Livro(1, "Livro A");
        livro.setReservado(true);
        assertFalse(livro.isDisponivel());
    }

    @Test
    public void testTituloInvalido() {
        Exception exceptionNull = assertThrows(IllegalArgumentException.class, () -> {
            new Livro(1, null);  // Título nulo
        });
        assertEquals("Dados do livro inválidos.", exceptionNull.getMessage());

        Exception exceptionEmpty = assertThrows(IllegalArgumentException.class, () -> {
            new Livro(2, "");  // Título vazio
        });
        assertEquals("Dados do livro inválidos.", exceptionEmpty.getMessage());
    }

    @Test
    public void testReusoLivroAposDevolucao() {
        Livro livro = new Livro(1, "Livro A");
        livro.setReservado(true);  // Livro reservado
        livro.setReservado(false);  // Livro devolvido, agora disponível
        assertTrue(livro.isDisponivel());
    }
}

