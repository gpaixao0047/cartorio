package br.com.cartorio.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
@Entity
@SequenceGenerator(name = "SEQ_CERTIDAO", allocationSize = 1)
public class Certidao {
	@Id
	@Column(name = "id_certidao")
	private Integer id;
	private String nome;
}
