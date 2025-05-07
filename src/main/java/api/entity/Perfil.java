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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "tb_perfis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Perfil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
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
