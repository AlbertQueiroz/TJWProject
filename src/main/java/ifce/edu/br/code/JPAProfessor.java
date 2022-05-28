package ifce.edu.br.code;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import ifce.edu.br.model.Aluno;
import ifce.edu.br.model.Aula;
import ifce.edu.br.model.Professor;
import ifce.edu.br.model.Turma;
import ifce.edu.br.utils.JPAUtil;

public class JPAProfessor {
	
	public static Professor cadastraProfessor(String nome, ArrayList<Turma> turmas) {

		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		Professor professor = new Professor();
		professor.setNome(nome);
		professor.setTurmas(turmas);
		manager.persist(professor);
		
		manager.getTransaction().commit();
		manager.close();
		return professor;

	}
	

	public static void main(String args[]) throws IOException {
		
		// Inicia Turmas com alunos
		
		ArrayList<Aluno> alunosTurma1 = new ArrayList<Aluno>();
		Aluno aluno1 = JPAAluno.cadastraAluno("Jairo", "(88) 95896-2630", "987.235.654-09");
		alunosTurma1.add(aluno1);
		alunosTurma1.add( JPAAluno.cadastraAluno("Kelly", "(62) 91902-5202", "295.264.877-00"));
		 
		ArrayList<Aluno> alunosTurma2 = new ArrayList<Aluno>();
		alunosTurma2.add(JPAAluno.cadastraAluno("Gabriel", "(82) 93944-8866", "066.397.765-29"));
		alunosTurma2.add(JPAAluno.cadastraAluno("Ana", "(71) 91459-6396", "674.879.583-80"));
		 
		ArrayList<Aluno> alunosTurma3 = new ArrayList<Aluno>();
		alunosTurma3.add(JPAAluno.cadastraAluno("Felipe", "(68) 92899-5295", "876.654.098-12"));
		
		Turma turma1 = JPATurma.iniciaTurma("Microcontroladores", alunosTurma1, "2021.1");
		Turma turma2 = JPATurma.iniciaTurma("Microcontroladores", alunosTurma2, "2021.1");
		Turma turma3 = JPATurma.iniciaTurma("Tópicos de Java para Web", alunosTurma3, "2021.1");
		
		// Encerra turma
		
		String removido = JPATurma.encerraTurma(turma3.getCodigo());
		System.out.println(removido);
		
		// Atualiza turma
		
		JPATurma.atualizaTurma(turma2.getCodigo(), "Engenharia de Software", "2021.1");
		
		// Adiciona turma para Professor
		
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		turmas.add(turma1);
		turmas.add(turma2);
		
		Professor professor = cadastraProfessor("João Silva", turmas);
		
		// Cria atividades para uma determinada aula
		
		String nomeArquivo = "C:\\Users\\VISITANTE\\Documents\\Arquivos\\atividade_aula1.txt";
		File atividade1_aula1 = new File(nomeArquivo);
				
		ArrayList<File> atividades = new ArrayList<File>();
		atividades.add(atividade1_aula1);
		
		// Professor insere aula em uma determinada turma
				
		if (professor.getTurmas().contains(turma1)) {
			Aula aula = JPAAula.insereAtividades(atividades);
			JPAAula.insereAula(turma1.getCodigo(), aula);
		}
				
		JPAAula.lerArquivo(atividade1_aula1, nomeArquivo);
		
	}
}
