package br.com.cartorio.core.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
public class CartorioCertidaoVincCommand {
	
	private Integer idCartorioCertidaoVinc;
	private Integer idCartorio;
	private Integer idCertidao;
}
