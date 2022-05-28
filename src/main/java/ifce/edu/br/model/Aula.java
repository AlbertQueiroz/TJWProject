package ifce.edu.br.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "tbl_aula")
public class Aula {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@ElementCollection
	private Collection<File> atividades = new ArrayList<File>();
	
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	// ------- Getters and Setters --------- 
	
	public Collection<File> getAtividades() {
		return atividades;
	}

	public void setAtividades(Collection<File> atividades) {
		this.atividades = atividades;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
}
