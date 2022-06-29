package ifce.edu.br.code;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import ifce.edu.br.model.Student;
import ifce.edu.br.model.Lesson;
import ifce.edu.br.utils.JPAUtil;

public class LessonRepository {

	public static Lesson createLesson(String Name, ArrayList<Student> students, String semester) {

		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		Lesson Lesson = new Lesson();
		Lesson.setName(Name);
		Lesson.setSemester(semester);
		Lesson.setStudents(students);
		manager.persist(Lesson);
		
		manager.getTransaction().commit();
		manager.close();
		return Lesson;

	}
	
	public static Lesson readLesson(Long code) {

		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		Lesson Lesson  = manager.getReference(Lesson.class, code);
		
		manager.getTransaction().commit();
		manager.close();
		return Lesson;

	}
	
	public static String deleteLesson(Long code) {
		
		Lesson Lesson = readLesson(code);
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.remove(Lesson);
			
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		return "A Lesson " + Lesson.getName() + " foi removida.";

	}
	
	
	public static Lesson updateLesson(Long code, String newName, String semester) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		Lesson Lesson = manager.getReference(Lesson.class, code);
		
		Lesson.setName(newName);
		Lesson.setSemester(semester);
		manager.persist(Lesson);
		System.out.println("A Lesson " + Lesson.getName() + " foi atualizada.");
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		return Lesson;

	}
	
	public static void main(String args[]) throws IOException {
		
	}
}
