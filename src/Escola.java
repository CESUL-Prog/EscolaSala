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




    // Lista todos os alunos matriculados em um curso especifico
    public void listarAlunosPorCurso(){

    }

    //Calcula a media de notas dos alunos em um curso
    //Regra: Considere apenas matriculas com nota valida (>=0)
    public void calcularMediaNotasPorCurso(){

    }

    //Atribui uma nota a uma matricula especifica
    //Regra: A nota deve ser entre 0 e 10; caso contrario, msg de erro
    public void atribuirNota(){

    }

    //Busca alunos pelo nome (case insensitive)
    public void buscarAlunoPorNome(){

    }

    //Lista todos os cursos com media de notas
    // acima de um determinado valor (parametro)
    public void listarCursosComMediaAcima(){

    }

    // EXIBE um ranking de alunos baseado na media das notas de todas as matriculas
    // Ordene a lista de forma decrescente pela media
    public void rankearAlunos(){

    }


    // Exibe um relatorio geral com as info do sistema
    // (mostre todas as info nos prints)
    public void gerarRelatorioGeral(){

    }
}
