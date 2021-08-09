package br.com.cartorio.core.service;

import java.util.List;

import br.com.cartorio.core.command.CartorioCertidaoVincCommand;
import br.com.cartorio.core.query.CartorioCertidaoVincQuery;

public interface CartorioCertidaoVincService {



	void deletarVinculos(Integer idCartorio);

	void cartorioCertidaoVincCommand(List<CartorioCertidaoVincCommand> cartorioCertidaoVincCommand);

	List<Integer> getListCertidoesSelecionados(Integer idCartorio);

}
