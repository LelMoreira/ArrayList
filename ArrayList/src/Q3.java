import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Aluno {
    private String matricula;
    private String nome;
    private double notaBimestre1;
    private double notaBimestre2;

    public Aluno(String matricula, String nome, double notaBimestre1, double notaBimestre2) {
        this.matricula = matricula;
        this.nome = nome;
        setNotaBimestre1(notaBimestre1);
        setNotaBimestre2(notaBimestre2);
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getNotaBimestre1() {
        return notaBimestre1;
    }

    public double getNotaBimestre2() {
        return notaBimestre2;
    }

    public void setNotaBimestre1(double notaBimestre1) {
        if (notaBimestre1 >= 0.0 && notaBimestre1 <= 10.0) {
            this.notaBimestre1 = notaBimestre1;
        } else {
            throw new IllegalArgumentException("Nota deve estar entre 0.0 e 10.0");
        }
    }

    public void setNotaBimestre2(double notaBimestre2) {
        if (notaBimestre2 >= 0.0 && notaBimestre2 <= 10.0) {
            this.notaBimestre2 = notaBimestre2;
        } else {
            throw new IllegalArgumentException("Nota deve estar entre 0.0 e 10.0");
        }
    }

    public double calcularMedia() {
        return (notaBimestre1 + notaBimestre2) / 2;
    }

    public String situacao() {
        double media = calcularMedia();
        if (media < 4.0) {
            return "Reprovado";
        } else if (media < 6.0) {
            return "Exame";
        } else {
            return "Aprovado";
        }
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> listaAlunos = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Digite a matrícula do aluno:");
            String matricula = scanner.nextLine();
            System.out.println("Digite o nome do aluno:");
            String nome = scanner.nextLine();
            System.out.println("Digite a nota do 1º bimestre:");
            double notaBimestre1 = scanner.nextDouble();
            System.out.println("Digite a nota do 2º bimestre:");
            double notaBimestre2 = scanner.nextDouble();
            scanner.nextLine();

            Aluno aluno = new Aluno(matricula, nome, notaBimestre1, notaBimestre2);
            listaAlunos.add(aluno);
        }

        int totalAlunos = listaAlunos.size();
        int aprovados = 0, reprovados = 0, exame = 0;
        double somaMedias = 0;
        Aluno alunoMaiorMedia = null;
        Aluno alunoMenorMedia = null;

        for (Aluno a : listaAlunos) {
            double media = a.calcularMedia();
            System.out.printf("%s obteve média: %.2f - %s%n", a.getNome(), media, a.situacao());

            somaMedias += media;

            if (a.situacao().equals("Aprovado")) {
                aprovados++;
            } else if (a.situacao().equals("Reprovado")) {
                reprovados++;
            } else {
                exame++;
            }

            if (alunoMaiorMedia == null || media > alunoMaiorMedia.calcularMedia()) {
                alunoMaiorMedia = a;
            }
            if (alunoMenorMedia == null || media < alunoMenorMedia.calcularMedia()) {
                alunoMenorMedia = a;
            }
        }

        double mediaClasse = somaMedias / totalAlunos;

        System.out.println("Total de alunos: " + totalAlunos);
        System.out.println("Quantidade de alunos Aprovados: " + aprovados);
        System.out.println("Quantidade de alunos Reprovados: " + reprovados);
        System.out.println("Quantidade de alunos em Exame: " + exame);
        System.out.printf("Média da classe: %.2f%n", mediaClasse);
        System.out.printf("Aluno com menor média: %s - Média: %.2f%n", alunoMenorMedia.getNome(), alunoMenorMedia.calcularMedia());
        

        scanner.close();
    }
}