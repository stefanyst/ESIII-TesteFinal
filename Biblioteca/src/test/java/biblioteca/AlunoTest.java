package biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

    @Test
    public void testCriacaoAlunoValido() {
        Aluno aluno = new Aluno("12345", "João");
        assertEquals("12345", aluno.verificaAluno());
    }

    @Test
    public void testCriacaoAlunoRAInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Aluno("", "João");
        });
        assertEquals("RA inválido.", exception.getMessage());
    }

    @Test
    public void testCriacaoAlunoRALongo() {
        String raMuitoLongo = "1234567890123456789012345678901234567890";  // RA com 40 caracteres
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Aluno(raMuitoLongo, "João");
        });
        assertEquals("RA inválido.", exception.getMessage());
    }

    @Test
    public void testCriacaoAlunoNomeComCaracteresEspeciais() {
        Aluno aluno = new Aluno("12345", "João@#$");
        assertEquals("João@#$", aluno.getNome());
    }

    @Test
    public void testVerificaPendencias() {
        Aluno aluno = new Aluno("12345", "João");
        aluno.setPendencias(true);
        assertTrue(aluno.verificaPendencias());  
    }

    @Test
    public void testPodeEmprestar() {
        Aluno aluno = new Aluno("12345", "João");
        aluno.setLivrosEmprestados(4);
        assertTrue(aluno.podeEmprestar());  // Menos de 5 livros emprestados, deve retornar true
    }

    @Test
    public void testNaoPodeEmprestarComPendencias() {
        Aluno aluno = new Aluno("12345", "João");
        aluno.setPendencias(true);
        assertFalse(aluno.podeEmprestar());  // Pendências impedem o empréstimo
    }

    @Test
    public void testNaoPodeEmprestarComCincoLivrosEmprestados() {
        Aluno aluno = new Aluno("12345", "João");
        aluno.setLivrosEmprestados(5);  // Limite de 5 livros
        assertFalse(aluno.podeEmprestar());  // Não deve poder emprestar mais livros


    }
}

