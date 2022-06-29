package ifce.edu.br.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.EntityManager;

import ifce.edu.br.model.Student;
import ifce.edu.br.model.Classroom;
import ifce.edu.br.model.Lesson;
import ifce.edu.br.utils.JPAUtil;

public class ClassroomRepository {

	public static void readFile(File file, String fileName) {
		String textLine = new String();
		
		if (file.exists()) {
			try {
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferArquivo = new BufferedReader(fileReader);
				
				while(true) {
					textLine = bufferArquivo.readLine();
					if (textLine == null) {
						break;
					}
					
					System.out.print(textLine + "\n");
				}
				
			} catch(Exception exception) {
				System.out.print("O seguinte erro ocorreu ao tentar ler o arquivo:\n" + exception);
			}
		}
	}
	
	public static Classroom insertActivities(ArrayList<File> activities) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		Classroom classroom = new Classroom();
		Calendar date = Calendar.getInstance();
		classroom.setDate(date);
		classroom.setActivities(activities);
		manager.persist(classroom);
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		return classroom;
	}
	
	public static void insertClassroom(Long code, Classroom classroom) {
		EntityManager manager = JPAUtil.getEntityManager();
		Lesson lesson  = manager.getReference(Lesson.class, code);
		lesson.getClassrooms().add(classroom);
		System.out.print("Uma nova aula foi postada na turma " + lesson.getName());
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
	}
	
	public static void main(String args[]) throws IOException {
	
	}
}
