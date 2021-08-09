package br.com.cartorio.core.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static br.com.cartorio.core.factory.CertidaoFactory.makeListCertidaoEntityToQuery;

import br.com.cartorio.core.entity.Certidao;
import br.com.cartorio.core.query.CertidaoQuery;
import br.com.cartorio.core.repository.CertidaoRepository;
import br.com.cartorio.core.service.CertidaoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CertidaoServiceImpl implements CertidaoService {
	
	private final CertidaoRepository certidaoRepository;
	
	@Override
	public List<Certidao> cadastrar(List<Certidao> listCertidaoEntity) {
		return certidaoRepository.cadastrar(listCertidaoEntity);
	}

	@Override
	public List<CertidaoQuery> getListCertidao() {
		List<Certidao> listCertidaoEntity = certidaoRepository.getListCertidao();
		return makeListCertidaoEntityToQuery(listCertidaoEntity) ;
	}



}
