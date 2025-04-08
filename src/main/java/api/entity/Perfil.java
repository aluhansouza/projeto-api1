package api.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "perfil")
@Entity
public class Perfil implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	
	
	

}
