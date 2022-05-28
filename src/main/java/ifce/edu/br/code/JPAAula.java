package ifce.edu.br.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.EntityManager;

import ifce.edu.br.model.Aluno;
import ifce.edu.br.model.Aula;
import ifce.edu.br.model.Turma;
import ifce.edu.br.utils.JPAUtil;

public class JPAAula {

	public static void lerArquivo(File arquivo, String nomeArquivo) {
		String linhaTexto = new String();
		
		if (arquivo.exists()) {
			try {
				FileReader leitorArquivo = new FileReader(nomeArquivo);
				BufferedReader bufferArquivo = new BufferedReader(leitorArquivo);
				
				while(true) {
					linhaTexto = bufferArquivo.readLine();
					if (linhaTexto == null) {
						break;
					}
					
					System.out.print(linhaTexto + "\n");
				}
				
			} catch(Exception exception) {
				System.out.print("O seguinte erro ocorreu ao tentar ler o arquivo:\n" + exception);
			}
		}
	}
	
	public static Aula insereAtividades(ArrayList<File> atividades) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		Aula aula = new Aula();
		Calendar data = Calendar.getInstance();
		aula.setData(data);
		aula.setAtividades(atividades);
		manager.persist(aula);
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		return aula;
	}
	
	public static void insereAula(Long codigoTurma, Aula aula) {
		EntityManager manager = JPAUtil.getEntityManager();
		Turma turma  = manager.getReference(Turma.class, codigoTurma);
		turma.getAulas().add(aula);
		System.out.print("Uma nova aula foi postada na turma " + turma.getNome());
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
	}
	
	public static void main(String args[]) throws IOException {
	
	}
}
