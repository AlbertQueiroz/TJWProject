package ifce.edu.br.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table (name = "tbl_aluno")
public class Aluno {
	@Id
	@GeneratedValue
	private Long matricula;

	@Column (name = "nome_aluno")
	private String nome;
	
	@Column (name = "rg")
	private String RG;
	
	@Column (name = "cpf")
	private String CPF;
	
	@ManyToMany(mappedBy = "alunos")
	private Collection<Turma> turma = new ArrayList<Turma>();

	// ------- Getters and Setters --------- 
	
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public Collection<Turma> getTurma() {
		return turma;
	}
	public void setTurma(Collection<Turma> turma) {
		this.turma = turma;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
}
