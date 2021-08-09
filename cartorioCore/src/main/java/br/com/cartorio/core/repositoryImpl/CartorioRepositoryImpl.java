package br.com.cartorio.core.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cartorio.core.entity.Cartorio;
import br.com.cartorio.core.repository.CartorioRepository;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor(onConstructor_ = @Autowired)
public class CartorioRepositoryImpl implements CartorioRepository{
	
	private final CartorioRepositorySpringData repositorySpringData;

	@Override
	public Cartorio saveOrUpdate(Cartorio cartorioEntity) {
		return repositorySpringData.save(cartorioEntity);
	}

	@Override
	public List<Cartorio> getAll() {
		return repositorySpringData.findAll();
	}

	@Override
	public void delete(Integer idCartorio) {
		repositorySpringData.deleteById(idCartorio);
		
	}

	@Override
	public Cartorio findById(Integer idCartorio) {
		return repositorySpringData.getInfos(idCartorio);
	}

}
