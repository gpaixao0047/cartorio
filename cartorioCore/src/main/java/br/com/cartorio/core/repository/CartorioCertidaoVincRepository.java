package br.com.cartorio.core.repository;

import java.util.List;

import br.com.cartorio.core.entity.CartorioCertidaoVinc;
import br.com.cartorio.core.entity.Certidao;

public interface CartorioCertidaoVincRepository {

	void deletarVinculos(Integer idCartorio);

	void salvar(List<CartorioCertidaoVinc> cartorioCertidaoVincEntity);

	List<Integer> getListCertidoesSelecionados(Integer idCartorio);

}
