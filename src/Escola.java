import java.util.ArrayList;

// Escola vai gerenciar o cadastro de alunos,
// cursos e matrículas
public class Escola {
    public ArrayList<Aluno> alunos;
    public ArrayList<Curso> cursos;
    public ArrayList<Matricula> matriculas;

    public Escola(){
        alunos = new ArrayList<>();
        cursos = new ArrayList<>();
        matriculas = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno aluno){
        for(Aluno a : alunos){
            if(a.matricula.equals(aluno.matricula)){
                System.out.println("Já tem aluno com esta matrícula");
                return;
            }

            alunos.add(aluno);
            System.out.println("Aluno cadastrado com sucesso");
        }
    }

    public void cadastrarCurso(Curso curso){
        for(Curso c : cursos){
            if(c.codigo.equals(curso.codigo)){
                System.out.println("Já tem curso com esta codigo");
                return;
            }

            cursos.add(curso);
            System.out.println("Curso cadastrado com sucesso");
        }
    }

    public void matricularAluno(Matricula matricula){
        for(Matricula m : matriculas){
            if(m.aluno.matricula.equals(matricula.aluno.matricula) &&
            m.curso.codigo.equals(matricula.curso.codigo)) {
                System.out.println("Aluno ja esta matriculado neste curso");
                return;
            }
        }

        matriculas.add(matricula);
        System.out.println("Matricula realizada com sucesso");
    }

    // Remover a matricula de um aluno.matricula em um curso.codigo
    // Regra: Se a matrícula não for encontrada, printe erro
    public void removerMatricula(String matriculaAluno, String codigoCurso){

    }
}
