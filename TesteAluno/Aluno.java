package TesteAluno;

public class Aluno {
    private int matricula;
    private String nome;
    private float nota;

    public Aluno(Integer matricula, String nome, float nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    public int getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }
    public float getNota() {
        return nota;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica se é a mesma instância
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica o tipo

        Aluno aluno = (Aluno) obj; // Faz o cast para Aluno
        return matricula == aluno.getMatricula(); // Compara as matrículas
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome='" + nome + '\'' + ", matricula=" + matricula + ", nota=" + nota + '}';
    }
}
