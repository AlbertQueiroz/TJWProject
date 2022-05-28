package ifce.edu.br.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Table (name = "tbl_professor")
public class Professor {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name = "nome_professor")
	private String nome;
	
	@OneToMany
	private Collection<Turma> turmas = new ArrayList<Turma>();
	
	// ------- Getters and Setters --------- 
	
	public Collection<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Collection<Turma> turmas) {
		this.turmas = turmas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
