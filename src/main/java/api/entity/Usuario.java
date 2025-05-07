package api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="senha",nullable = false)
    private String senha;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;
	
	@CreatedDate
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;
    
    @CreatedBy
    @Column(name = "criado_por",updatable = false)
    private String criadoPor;
        
    @LastModifiedDate
    @Column(name = "data_atualizacao",updatable = false)
    private LocalDateTime dataAtualizacao;

    @LastModifiedBy
    @Column(name = "atualizado_por",updatable = false)
    private String atualizadoPor;
	
	
	
	
	
	
	

}
