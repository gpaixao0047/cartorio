package br.com.cartorio.core.factory;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.cartorio.core.command.CartorioCertidaoVincCommand;
import br.com.cartorio.core.entity.CartorioCertidaoVinc;

public class CartorioCertidaoVincFactory {

	public CartorioCertidaoVincFactory() {
		
	}
	
	public static CartorioCertidaoVinc makeCartorioCertidaoCommandToEntity(CartorioCertidaoVincCommand command) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(command, CartorioCertidaoVinc.class);
	}
	
	public static List<CartorioCertidaoVinc> makeListCommandToEntity(List<CartorioCertidaoVincCommand> listCartorioCertidaoVincCommand){
		return listCartorioCertidaoVincCommand.stream()
				.map(CartorioCertidaoVincFactory::makeCartorioCertidaoCommandToEntity)
				.collect(toList());
	}
}
