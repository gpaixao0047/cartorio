package br.com.cartorio.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@SequenceGenerator(name = "SEQ_CARTORIO", allocationSize = 1)
public class Cartorio {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CARTORIO")
	private Integer idCartorio;
	private String nome;
	private String endereco;
}
