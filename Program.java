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

        t1 = System.currentTimeMillis();
        LeitorArquivos.read(listaNaoOrd);
        t2 = System.currentTimeMillis();

        delta = t2 - t1;
        System.out.println("A leitura da lista não ordenada levou " + delta + " milisegundos.");

        t1 = System.currentTimeMillis();
        LeitorArquivos.read(listaOrd);
        t2 = System.currentTimeMillis();

        delta = t2 - t1;
        System.out.println("A leitura da lista ordenada levou " + delta + " milisegundos.");

        
        // *LEIA*
        // Adicionado o teste de pesquisa na lista não ordenada e ordenada
        // Inclui um loop mostrando o menu de pesquisa
        // Sugestões de melhorias:
        // - Preencher a lista ordenada demora muito 💀💀💀, talvez buscar outra forma de fazer isso.

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

                    t1 = System.currentTimeMillis();
                    alunoPesquisado = listaNaoOrd.pesquisar(new Aluno(matricula, "", 0));
                    t2 = System.currentTimeMillis();

                    delta = t2 - t1;
                    
                    if (alunoPesquisado != null) {
                        System.out.println("Aluno encontrado: " + alunoPesquisado);
                    } else {
                        System.out.println("Aluno não encontrado na lista não ordenada.");
                    }

                    System.out.println("A busca levou " + delta + " milisegundos.");
                    
                    break;
                case 2:
                    System.out.print("Digite a matrícula do aluno: ");
                    matricula = scanner.nextInt();

                    t1 = System.currentTimeMillis();
                    alunoPesquisado = listaOrd.pesquisar(new Aluno(matricula, "", 0));
                    t2 = System.currentTimeMillis();

                    delta = t2 - t1;

                    if (alunoPesquisado != null) {
                        System.out.println("Aluno encontrado: " + alunoPesquisado);
                    } else {
                        System.out.println("Aluno não encontrado na lista ordenada.");
                    }

                    System.out.println("A busca levou " + delta + " milisegundos.");
                    
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
