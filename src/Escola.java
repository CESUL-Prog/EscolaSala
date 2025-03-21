import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    public void removerMatricula(String matriculaAluno,
                                 String codigoCurso){
        boolean removido = false;
        for(int i = 0; i < matriculas.size(); i ++){
            //matriculas[i];
            Matricula m = matriculas.get(i);

            if(m.aluno.matricula.equals(matriculaAluno) &&
                    m.curso.codigo.equals(codigoCurso)){
                matriculas.remove(i);
                removido = true;
                System.out.println("Matricula removida com sucesso!");
                break;
            }
        }

        if(!removido){
            System.out.println("Matricula nao encontrada para remoção");
        }

    }


    // Lista todos os alunos matriculados em um curso especifico
    // Faça um for nas matriculas, e uma vez encontrado o curso,
    // printe o exibirInfo em matricula.aluno.exibirInfo()
    public void listarAlunosPorCurso(String codigoCurso){
        System.out.println("Alunos matriculados no curso de código: "
                + codigoCurso + ":");
        boolean encontrou = false;

        for(Matricula m : matriculas){
            if(m.curso.codigo.equals(codigoCurso)){
                m.aluno.exibirInfo();
                encontrou = true;
            }
        }
        if(!encontrou){
            System.out.println("Nenhum aluno matriculado");
        }
    }

    //Calcula a media de notas dos alunos em um curso especifico
    //Regra: Considere apenas matriculas com nota valida (>=0)
    public void calcularMediaNotasPorCurso(String codigoCurso){
        double soma = 0;
        int cont = 0;
        for(Matricula m : matriculas){
            if(m.curso.codigo.equals(codigoCurso) && m.nota >= 0){
                soma += m.nota;
                cont++;
            }
        }

        if(cont == 0){
            System.out.println("Nenhuma nota registrada para este curso");
        }else{
            double media = soma / cont;
            System.out.println("Media: " + media);
        }
    }

    //Atribui uma nota a uma matricula especifica
    //Regra: A nota deve ser entre 0 e 10; caso contrario, msg de erro
    public void atribuirNota(String matriculaAluno, double nota){
        boolean encontrado = false;
        for(Matricula m : matriculas){
            if(m.aluno.matricula.equals(matriculaAluno)){
                m.setNota(nota);
                System.out.println("Nota atribuída com sucesso");
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("Matrícula não encontrada");
        }
    }

    //Busca alunos pelo nome (case Insensitive)
    // Case-sensitive: idade != Idade
    // Case-Insensitive: mario == mario
    public void buscarAlunoPorNome(String nomeBusca){
        System.out.println("Resultados da busca por " + nomeBusca + ": ");
        boolean encontrou = false;
        for(Aluno a : alunos){
            if(a.nome.toLowerCase().contains(nomeBusca.toLowerCase())){
                a.exibirInfo();
                encontrou = true;
                break;
            }
        }

        if(!encontrou){
            System.out.println("Aluno não encontrado");
        }
    }

    //Lista todos os cursos com media de notas
    // acima de um determinado valor (parametro)
    public void listarCursosComMediaAcima(double media){
        System.out.println("Cursos com média acima de: " + media + ": ");
        boolean encontrou = false;

        for(Curso c : cursos){
            double soma = 0;
            int cont = 0;

            for(Matricula m : matriculas){
                if(m.curso.codigo.equals(c.codigo)){
                    soma += m.nota;
                    cont++;
                }
            }
            if(cont > 0){
                double mediaFinal = soma / cont;
                if(mediaFinal > media){
                    c.exibirInfo();
                    System.out.println("Média: " + mediaFinal);
                    encontrou = true;
                }
            }
        }
        if(!encontrou){
            System.out.println("Nenhum curso cencontrado com media acima de" + media);
        }
    }

    // EXIBE um ranking de alunos baseado na media das notas de todas as matriculas
    // Ordene a lista de forma decrescente pela media
    public void rankearAlunos(){
        ArrayList<AlunoMedia> ranking = new ArrayList<>();
        // 1º percorrer todos os alunos
        for(Aluno a : alunos){
            double soma = 0;
            int cont = 0;

            for(Matricula m : matriculas){
                if(m.aluno.matricula.equals(a.matricula)){
                    soma += m.nota;
                    cont++;
                }
            }
            if(cont > 0){
                double media = soma / cont;
                ranking.add(new AlunoMedia(a, media));
            }
        }

        Comparator comparador = new Comparator<AlunoMedia>(){
            public int compare(AlunoMedia am1, AlunoMedia am2){
                if(am1.media < am2.media) return 1;
                else if(am1.media > am2.media) return -1;
                else return 0;
            }
        };

        Collections.sort(ranking, comparador);
        //ranking.sort((am1, am2) -> Double.compare(am2.media, am1.media));

        System.out.println("Ranking de alunos: ");
        for(AlunoMedia am : ranking){
            am.aluno.exibirInfo();
            System.out.println("Média: " + am.media);
            System.out.println("-----------");
        }
    }


    // Exibe um relatorio geral com as info do sistema
    // (mostre todas as info nos prints)
    public void gerarRelatorioGeral() {
        System.out.println("-- Relatório geral --");
        System.out.println("Total de alunos: " + alunos.size());
        System.out.println("Total de cursos: " + cursos.size());
        System.out.println("Total de matriculas: " + matriculas.size());

        double soma = 0;
        int cont = 0;

        for (Matricula m : matriculas) {
            soma += m.nota;
            cont++;
        }

        if (cont > 0) {
            double mediaGeral = soma / cont;
            System.out.println("Média: " + mediaGeral);
        } else {
            System.out.println("Nenhuma nota no sistema");
        }
    }
}
