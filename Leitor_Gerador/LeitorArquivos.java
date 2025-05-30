package Leitor_Gerador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Base.listaEncad;
import TesteAluno.Aluno;

public class LeitorArquivos {
    private static final String NOME_ARQUIVO = "alunosOrdenados.txt";
    
    public static void read(listaEncad<Aluno> l) {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            int numRegistros = Integer.parseInt(reader.readLine().trim());
            System.out.println("Número de registros: " + numRegistros);

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int matricula = Integer.parseInt(partes[0]);
                String nome = partes[1];
                float nota = Float.parseFloat(partes[2]);
                
                Aluno aluno = new Aluno(matricula, nome, nota);
                
                l.adicionar(aluno);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }
    }
}
