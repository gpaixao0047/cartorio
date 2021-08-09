package br.com.cartorio.core.query;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
@JsonInclude(value = Include.NON_NULL)
public class CartorioCertidaoVincQuery {
	private Integer idCartorio;
	private List<CertidaoQuery> sourceCertidao;
	private List<CertidaoQuery> targetCertidao;
}
