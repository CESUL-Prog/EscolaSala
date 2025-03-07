// Esta classe representa a matrícula de um aluno
// em um curso;
// Todas as operações relacionadas à matrícula
// São feitas aqui dentro.
public class Matricula {
    public Aluno aluno;
    public Curso curso;
    // Classe wrapper Double, Integer, Float
    // public Double nota; nota == null
    // Classes wrapper tem métodos uteis
    // como Double.compare(3.14, 4.15);
    // Integer.parseInt();
    public double nota; // -1 indica "nota não atribuida"

    // Const. padrão
    public Matricula(){
        this.aluno = null;
        this.curso = null;
        this.nota = -1;
    }

    // Const. parametrizado
    public Matricula(Aluno aluno, Curso curso){
        this.aluno = aluno;
        this.curso = curso;
        this.nota = -1;
    }

    public Aluno getAluno(){return aluno;}
    public Curso getCurso(){return curso;}
    public double getNota(){return nota;}

}
