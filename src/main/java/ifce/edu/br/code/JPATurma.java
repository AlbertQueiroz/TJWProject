package ifce.edu.br.code;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import ifce.edu.br.model.Aluno;
import ifce.edu.br.model.Turma;
import ifce.edu.br.utils.JPAUtil;

public class JPATurma {

	public static Turma iniciaTurma(String nome, ArrayList<Aluno> alunos, String semestre) {

		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		Turma turma = new Turma();
		turma.setNome(nome);
		turma.setSemestre(semestre);
		turma.setAlunos(alunos);
		manager.persist(turma);
		
		manager.getTransaction().commit();
		manager.close();
		return turma;

	}
	
	public static Turma buscaTurma(Long codigo) {

		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		Turma turma  = manager.getReference(Turma.class, codigo);
		
		manager.getTransaction().commit();
		manager.close();
		return turma;

	}
	
	public static String encerraTurma(Long codigo) {
		
		Turma turma = buscaTurma(codigo);
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.remove(turma);
			
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		return "A turma " + turma.getNome() + " foi removida.";

	}
	
	
	public static Turma atualizaTurma(Long codigo, String novoNome, String semestre) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		Turma turma = manager.getReference(Turma.class, codigo);
		
		turma.setNome(novoNome);
		turma.setSemestre(semestre);
		manager.persist(turma);
		System.out.println("A turma " + turma.getNome() + " foi atualizada.");
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		return turma;

	}
	
	public static void main(String args[]) throws IOException {
		
	}
}
