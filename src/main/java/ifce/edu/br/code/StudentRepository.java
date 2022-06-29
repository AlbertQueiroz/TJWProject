package ifce.edu.br.code;

import java.io.IOException;
import java.util.Calendar;

import ifce.edu.br.model.Student;
import ifce.edu.br.model.Classroom;
import ifce.edu.br.model.Lesson;
import ifce.edu.br.model.Professor;
import ifce.edu.br.model.Student;
import ifce.edu.br.utils.JPAUtil;
import javax.persistence.EntityManager;

public class StudentRepository {
	
	public static Student createStudent(String name, String RG, String CPF) {

		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		Student aluno = new Student();
		aluno.setName(name);
		aluno.setRG(RG);
		aluno.setCPF(CPF);
		manager.persist(aluno);
		
		manager.getTransaction().commit();
		manager.close();
		return aluno;

	}
	
	public static Student readStudent(Long register) {

		EntityManager manager = JPAUtil.getEntityManager();
		Student aluno = manager.getReference(Student.class, register);
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		return aluno;

	}
	
	public static String deleteStudent(Long register) {
		
		Student aluno = readStudent(register);
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.remove(aluno);
			
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		
		return "O aluno " + register + " foi removido.";
	}
	
	
	public static Student updateStudent(Long register, String newName, String RG, String CPF) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		Student aluno = manager.getReference(Student.class, register);
		
		aluno.setName(newName);
		aluno.setRG(RG);
		aluno.setCPF(CPF);
		manager.persist(aluno);
		System.out.println("O aluno " + register + " foi atualizado.");
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		return aluno;

	}
	
	public static void main(String args[]) throws IOException {
	
	}

}
