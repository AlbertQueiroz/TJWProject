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
	
	@Column (name = "name_professor")
	private String name;
	
	@OneToMany
	private Collection<Lesson> classes = new ArrayList<Lesson>();
	
	// ------- Getters and Setters --------- 
	
	public Collection<Lesson> getClasses() {
		return classes;
	}

	public void setClasses(Collection<Lesson> classes) {
		this.classes = classes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = name;
	}
}
