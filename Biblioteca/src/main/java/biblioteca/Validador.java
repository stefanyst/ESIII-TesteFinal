package biblioteca;
import java.time.LocalDate;


public class Validador {

    public static boolean validarRA(String ra) {
        return ra != null && !ra.isEmpty() && ra.matches("\\d+");
    }

    public static boolean validarCodigoLivro(int codigo) {
        return codigo > 0;
    }

    public static boolean validarTitulo(String titulo) {
        return titulo != null && !titulo.trim().isEmpty();
    }

    public static boolean validarDataEmprestimo(LocalDate dataEmprestimo) {
        return dataEmprestimo != null && !dataEmprestimo.isBefore(LocalDate.now().minusYears(1));
    }
}

