package br.com.cartorio.core.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
public class CartorioCommand {
	
	private Integer idCartorio;
	private String nome;
	private String endereco;
}
