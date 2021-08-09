package br.com.cartorio.core.repository;

import java.util.List;

import br.com.cartorio.core.entity.Cartorio;

public interface CartorioRepository {

	Cartorio saveOrUpdate(Cartorio cartorioEntity);

	List<Cartorio> getAll();

	void delete(Integer idCartorio);

	Cartorio findById(Integer idCartorio);

}
