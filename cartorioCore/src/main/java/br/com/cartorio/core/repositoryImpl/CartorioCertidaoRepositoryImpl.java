package br.com.cartorio.core.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cartorio.core.entity.CartorioCertidaoVinc;
import br.com.cartorio.core.repository.CartorioCertidaoVincRepository;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor(onConstructor_ = @Autowired)
public class CartorioCertidaoRepositoryImpl implements CartorioCertidaoVincRepository{
	
	private final CartorioCertidaoRepositorySpringData repositorySpringData;

	@Override
	public void deletarVinculos(Integer idCartorio) {
		repositorySpringData.deletarVinculos(idCartorio);
		
	}

	@Override
	public void salvar(List<CartorioCertidaoVinc> cartorioCertidaoVincEntity) {
		repositorySpringData.saveAll(cartorioCertidaoVincEntity);
		
	}

	@Override
	public List<Integer> getListCertidoesSelecionados(Integer idCartorio) {
		return repositorySpringData.getListCertidoesSelecionados(idCartorio);
	}

}
