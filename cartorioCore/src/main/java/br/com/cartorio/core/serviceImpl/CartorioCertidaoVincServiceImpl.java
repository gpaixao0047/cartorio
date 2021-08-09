package br.com.cartorio.core.serviceImpl;

import static br.com.cartorio.core.factory.CartorioCertidaoVincFactory.makeListCommandToEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cartorio.core.command.CartorioCertidaoVincCommand;
import br.com.cartorio.core.entity.CartorioCertidaoVinc;
import br.com.cartorio.core.repository.CartorioCertidaoVincRepository;
import br.com.cartorio.core.service.CartorioCertidaoVincService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CartorioCertidaoVincServiceImpl implements CartorioCertidaoVincService{
	
	private final CartorioCertidaoVincRepository cartorioCertidaoVincRepository;
	

	@Override
	public void deletarVinculos(Integer idCartorio) {
		cartorioCertidaoVincRepository.deletarVinculos(idCartorio);
		
	}

	@Override
	public void cartorioCertidaoVincCommand(List<CartorioCertidaoVincCommand> cartorioCertidaoVincCommand) {
		List<CartorioCertidaoVinc> cartorioCertidaoVincEntity = makeListCommandToEntity(cartorioCertidaoVincCommand);
		cartorioCertidaoVincRepository.salvar(cartorioCertidaoVincEntity);
		
	}

	@Override
	public List<Integer> getListCertidoesSelecionados(Integer idCartorio) {
		return cartorioCertidaoVincRepository.getListCertidoesSelecionados(idCartorio);
	}

}
