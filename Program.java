import java.util.Comparator;
import java.util.Scanner;


import Leitor_Gerador.GeradorArquivosOrdenados;
import Leitor_Gerador.LeitorArquivos;
import ListaNaoOrdenada.listaEncadNaoOrd;
import ListaOrdenada.listaEncadOrd;
import TesteAluno.Aluno;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GeradorArquivosOrdenados.gerar();

        Comparator<Aluno> matriculaComparator = (a1, a2) -> Integer.compare(a1.getMatricula(), a2.getMatricula());
        listaEncadNaoOrd<Aluno> listaNaoOrd = new listaEncadNaoOrd<Aluno>();
        listaEncadOrd<Aluno> listaOrd = new listaEncadOrd<Aluno>(matriculaComparator);

        long t1, t2, delta;

        t1 = System.nanoTime();
        LeitorArquivos.read(listaNaoOrd);
        t2 = System.nanoTime();

        delta = t2 - t1;
        System.out.println("A leitura da lista não ordenada levou " + delta + " nanosegundos.");

        t1 = System.nanoTime();
        LeitorArquivos.read(listaOrd);
        t2 = System.nanoTime();

        delta = t2 - t1;
        System.out.println("A leitura da lista ordenada levou " + delta + " nanosegundos.");

        while(true) {
            System.out.println("\n--- Menu:");
            System.out.println("1. Pesquisar na lista não ordenada.");
            System.out.println("2. Pesquisar na lista ordenada.");
            System.out.println("3. Sair");

            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            int matricula; 
            Aluno alunoPesquisado;
            

            switch (opcao) {
                case 1:
                    System.out.print("Digite a matrícula do aluno: ");
                    matricula = scanner.nextInt();

                    t1 = System.nanoTime();
                    alunoPesquisado = listaNaoOrd.pesquisar(new Aluno(matricula, "", 0));
                    t2 = System.nanoTime();

                    delta = t2 - t1;
                    
                    if (alunoPesquisado != null) {
                        System.out.println("Aluno encontrado: " + alunoPesquisado);
                    } else {
                        System.out.println("Aluno não encontrado na lista não ordenada.");
                    }

                    System.out.println("A busca levou " + delta + " nanosegundos.");
                    
                    break;
                case 2:
                    System.out.print("Digite a matrícula do aluno: ");
                    matricula = scanner.nextInt();

                    t1 = System.nanoTime();
                    alunoPesquisado = listaOrd.pesquisar(new Aluno(matricula, "", 0));
                    t2 = System.nanoTime();

                    delta = t2 - t1;

                    if (alunoPesquisado != null) {
                        System.out.println("Aluno encontrado: " + alunoPesquisado);
                    } else {
                        System.out.println("Aluno não encontrado na lista ordenada.");
                    }

                    System.out.println("A busca levou " + delta + " nanosegundos.");
                    
                    break;
                case 3:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;            
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
