package ifce.edu.br.code;

import java.io.IOException;
import java.util.Calendar;

import ifce.edu.br.model.Aluno;
import ifce.edu.br.model.Aula;
import ifce.edu.br.model.Turma;
import ifce.edu.br.model.Professor;
import ifce.edu.br.utils.JPAUtil;
import javax.persistence.EntityManager;

public class JPAAluno {
	
	public static Aluno cadastraAluno(String nome, String RG, String CPF) {

		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setRG(RG);
		aluno.setCPF(CPF);
		manager.persist(aluno);
		
		manager.getTransaction().commit();
		manager.close();
		return aluno;

	}
	
	public static Aluno buscaAluno(Long matricula) {

		EntityManager manager = JPAUtil.getEntityManager();
		Aluno aluno = manager.getReference(Aluno.class, matricula);
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		return aluno;

	}
	
	public static String removeAluno(Long matricula) {
		
		Aluno aluno = buscaAluno(matricula);
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.remove(aluno);
			
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		return "O aluno " + matricula + " foi removido.";

	}
	
	
	public static Aluno atualizaAluno(Long matricula, String novoNome, String RG, String CPF) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		Aluno aluno = manager.getReference(Aluno.class, matricula);
		
		aluno.setNome(novoNome);
		aluno.setRG(RG);
		aluno.setCPF(CPF);
		manager.persist(aluno);
		System.out.println("O aluno " + matricula + " foi atualizado.");
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		return aluno;

	}
	
	public static void main(String args[]) throws IOException {
	
	}

}
