package br.com.cartorio.core.service;

import java.util.List;

import br.com.cartorio.core.command.CartorioCertidaoVincCommand;
import br.com.cartorio.core.command.CartorioCommand;
import br.com.cartorio.core.query.CartorioQuery;
import br.com.cartorio.core.query.CertidaoQuery;

public interface CartorioService {

	CartorioQuery cadastrar(CartorioCommand cartorioCommand);

	List<CartorioQuery> getAll();

	void delete(Integer idCartorio);

	List<CertidaoQuery> cadastrarCertidoes();

	CartorioQuery findById(Integer idCartorio);

	List<CertidaoQuery> getListCertidao();

	void deletarVinculos(Integer idCartorio);

	void cadastrarVinculoCertidao(List<CartorioCertidaoVincCommand> cartorioCertidaoVincCommand);

	List<Integer> getListCertidoesSelecionados(Integer idCartorio);

}
