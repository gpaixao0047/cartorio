package br.com.cartorio.core.repository;

import java.util.List;

import br.com.cartorio.core.entity.Certidao;

public interface CertidaoRepository {

	List<Certidao> cadastrar(List<Certidao> listCertidaoEntity);

	List<Certidao> getListCertidao();

}
