package biblioteca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Usando try-with-resources para garantir o fechamento do Scanner automaticamente
        try (Scanner entrada = new Scanner(System.in)) {
            int[] codigos = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            System.out.print("Digite o RA do Aluno: ");
            String aluno = entrada.nextLine();
            System.out.print("Digite o número de Livros a ser Emprestado: ");
            int num = entrada.nextInt();
            int aux;

            for (int i = 0; i < num; i++) {
                System.out.print("Digite o código do livro " + (i + 1) + ": ");
                aux = entrada.nextInt();
                codigos[i] = aux;
            }

            // Emprestando os livros
            Controle c = new Controle();
            c.emprestar(aluno, codigos, num);
        } catch (Exception e) {
            System.out.println("Erro ao processar a entrada: " + e.getMessage());
        }
    }
}
