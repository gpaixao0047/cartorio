package br.com.cartorio.core.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
public class CartorioQuery {
	
	private Integer idCartorio;
	private String nome;
	private String endereco;
}
