package ifce.edu.br.code;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import ifce.edu.br.model.Student;
import ifce.edu.br.model.Lesson;
import ifce.edu.br.model.Professor;
import ifce.edu.br.model.Classroom;
import ifce.edu.br.utils.JPAUtil;

public class ProfessorRepository {
	
	public static Professor createProfessor(String name, ArrayList<Lesson> lessons) {

		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		Professor professor = new Professor();
		professor.setName(name);
		professor.setClasses(lessons);
		manager.persist(professor);
		
		manager.getTransaction().commit();
		manager.close();
		return professor;

	}
	

	public static void main(String args[]) throws IOException {
		
		// Inicia Lessons com alunos
		
		ArrayList<Student> students1 = new ArrayList<Student>();
		Student student1 = StudentRepository.createStudent("Jairo", "(88) 95896-2630", "987.235.654-09");
		students1.add(student1);
		students1.add( StudentRepository.createStudent("Kelly", "(62) 91902-5202", "295.264.877-00"));
		 
		ArrayList<Student> students2 = new ArrayList<Student>();
		Student student2 = StudentRepository.createStudent("Jairo", "(88) 95896-2630", "987.235.654-09");
		students2.add(student1);
		students2.add( StudentRepository.createStudent("Kelly", "(62) 91902-5202", "295.264.877-00"));
		
		ArrayList<Student> students3 = new ArrayList<Student>();
		Student student3 = StudentRepository.createStudent("Jairo", "(88) 95896-2630", "987.235.654-09");
		students3.add(student1);
		students3.add( StudentRepository.createStudent("Kelly", "(62) 91902-5202", "295.264.877-00"));
		
		Lesson Lesson1 = LessonRepository.createLesson("Microcontroladores", students1, "2021.1");
		Lesson Lesson2 = LessonRepository.createLesson("Microcontroladores", students2, "2021.1");
		Lesson Lesson3 = LessonRepository.createLesson("Tópicos de Java para Web", students3, "2021.1");
		
		// Encerra Lesson
		
		String delete = LessonRepository.deleteLesson(Lesson3.getCode());
		System.out.println(delete);
		
		// Atualiza Lesson
		
		LessonRepository.updateLesson(Lesson2.getCode(), "Engenharia de Software", "2021.1");
		
		// Adiciona Lesson para Professor
		
		ArrayList<Lesson> Lessons = new ArrayList<Lesson>();
		Lessons.add(Lesson1);
		Lessons.add(Lesson2);
		
		Professor professor = createProfessor("João Silva", Lessons);
		
		// Cria atividades para uma determinada aula
		
		String filePath = "C:\\Users\\VISITANTE\\Documents\\Arquivos\\activitiesFile.txt";
		File activitiesFile = new File(filePath);
				
		ArrayList<File> activities = new ArrayList<File>();
		activities.add(activitiesFile);
		
		// Professor insere aula em uma determinada Lesson
				
		if (professor.getClasses().contains(Lesson1)) {
			Classroom classroom = ClassroomRepository.insertActivities(activities);
			ClassroomRepository.insertClassroom(Lesson1.getCode(), classroom);
		}
				
		ClassroomRepository.readFile(activitiesFile, filePath);
		
	}
}
