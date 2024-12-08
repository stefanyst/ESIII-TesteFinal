package biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControleTest {

    @Test
    public void testEmprestarComRAValido() {
        Controle controle = new Controle();
        int[] prazos = {1, 2, 3};
        assertTrue(controle.emprestar("12345", prazos, 3));
    }

    @Test
    public void testEmprestarComRAInvalido() {
        Controle controle = new Controle();
        int[] prazos = {1, 2, 3};
        assertFalse(controle.emprestar("", prazos, 3));
    }

    @Test
    public void testEmprestarComLivrosInvalidos() {
        Controle controle = new Controle();
        int[] prazos = {-1, 2, 3};
        assertFalse(controle.emprestar("12345", prazos, 3));
    }

    @Test
    public void testEmprestarComExcessoDeLivros() {
        Controle controle = new Controle();
        int[] prazos = {1, 2, 3, 4, 5, 6};  // 6 livros ao invés de 5
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controle.emprestar("12345", prazos, 6);
        });
        assertEquals("Número de livros excede o limite permitido.", exception.getMessage());
    }
}

