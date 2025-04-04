import java.util.Comparator;
import java.util.Scanner;
import ListaNaoOrdenada.listaEncadNaoOrd;
import ListaOrdenada.listaEncadOrd;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GeradorArquivosOrdenados.gerar();

        Comparator<Aluno> matriculaComparator = (a1, a2) -> Integer.compare(a1.getMatricula(), a2.getMatricula());
        listaEncadNaoOrd<Aluno> listaNaoOrd = new listaEncadNaoOrd<Aluno>();
        listaEncadOrd<Aluno> listaOrd = new listaEncadOrd<Aluno>(matriculaComparator);

        LeitorArquivos.read(listaNaoOrd, listaOrd);
        
        // *LEIA*
        // Adicionado o teste de pesquisa na lista não ordenada e ordenada
        // Inclui um loop mostrando o menu de pesquisa
        // Sugestões de melhorias:
        // - Preencher a lista ordenada demora muito 💀💀💀, talvez buscar outra forma de fazer isso.
        // - Organizar os arquivos e as pastas.

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

                    alunoPesquisado = listaNaoOrd.pesquisar(new Aluno(matricula, "", 0));
                    
                    if (alunoPesquisado != null) {
                        System.out.println("Aluno encontrado: " + alunoPesquisado);
                    } else {
                        System.out.println("Aluno não encontrado na lista não ordenada.");
                    }
                    
                    break;
                case 2:
                    System.out.print("Digite a matrícula do aluno: ");
                    matricula = scanner.nextInt();

                    alunoPesquisado = listaOrd.pesquisar(new Aluno(matricula, "", 0));

                    if (alunoPesquisado != null) {
                        System.out.println("Aluno encontrado: " + alunoPesquisado);
                    } else {
                        System.out.println("Aluno não encontrado na lista ordenada.");
                    }
                    
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
