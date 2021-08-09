package br.com.cartorio.core.service;

import java.util.List;

import br.com.cartorio.core.entity.Certidao;
import br.com.cartorio.core.query.CertidaoQuery;

public interface CertidaoService {

	List<Certidao> cadastrar(List<Certidao> listCertidaoEntity);

	List<CertidaoQuery> getListCertidao();



}
