import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Escola sistema = new Escola();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\nSistema de gerenciamento escolar \n");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar curso");
            System.out.println("3 - Matricular Aluno em curso");
            System.out.println("4 - Remover matricula de aluno");
            System.out.println("5 - Listar alunos por curso");
            System.out.println("6 - Atribuir nota e matricula");
            System.out.println("7 - Calcular média de notas por curso");
            System.out.println("8 - Buscar aluno por nome");
            System.out.println("9 - Listar cursos com média acima de X");
            System.out.println("10 - Exibir ranking de alunos");
            System.out.println("11 - Relatório geral");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){
                case 1:
                    System.out.println("Digite o nome do aluno: ");
                    String nomeAluno = scanner.nextLine();
                    System.out.println("Digite a matrícula do aluno: ");
                    String matriculaAluno = scanner.nextLine();

                    Aluno alunoCadastro = new Aluno(nomeAluno, matriculaAluno);
                    sistema.cadastrarAluno(alunoCadastro);
                    break;
                case 2:

                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 0:

            }

        }while(opcao != 0);

        // 1 cadastrar aluno,
        // 2 cadastrar curso,
        // 3 matricular aluno em curso
        // 4 Remover matricula
        // 5 Listar alunos por curso
        // 6 atribuir nota a matricula
        // 7 calcular media de notas por curso
        // 8 buscar aluno por nome
        // 9 Listar cursos com media acima de X
        // 10 exibir ranking
        // 11 Relatorio geral
        // 0 sair
    }
}