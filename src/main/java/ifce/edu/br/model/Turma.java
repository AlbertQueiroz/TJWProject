package ifce.edu.br.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Table (name = "tbl_turma")
public class Turma {
	
	@Id
	@GeneratedValue
	private Long codigo;
	
	@Column
	private String nome;
	
	@Column
	private String semestre;

	@ManyToMany
	private Collection<Aluno> alunos = new ArrayList<Aluno>();
	
	@OneToMany
	private Collection<Aula> aulas = new ArrayList<Aula>();

	// ------- Getters and Setters --------- 
	
	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Collection<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Collection<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(Collection<Aula> aulas) {
		this.aulas = aulas;
	}
	
}
	
