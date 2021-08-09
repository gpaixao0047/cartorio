package br.com.cartorio.core.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cartorio.core.entity.Certidao;
import br.com.cartorio.core.repository.CertidaoRepository;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor(onConstructor_ = @Autowired)
public class CertidaoRepositoryImpl implements CertidaoRepository{
	
	private final CertidaoRepositorySpringData repositorySpringData;
	
	@Override
	public List<Certidao> cadastrar(List<Certidao> listCertidaoEntity) {
		return repositorySpringData.saveAll(listCertidaoEntity);
		
	}

	@Override
	public List<Certidao> getListCertidao() {
		return repositorySpringData.findAll();
	}

}
