package br.com.cartorio.core.factory;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.cartorio.core.command.CartorioCommand;
import br.com.cartorio.core.entity.Cartorio;
import br.com.cartorio.core.query.CartorioQuery;

public class CartorioFactory {
	private CartorioFactory() {
	}
	
	public static Cartorio makeCartorioCommandToEntity(CartorioCommand cartorioCommand) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(cartorioCommand, Cartorio.class);
	}
	
	public static CartorioQuery makeCartorioEntityToQuery(Cartorio cartorioEntity) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(cartorioEntity, CartorioQuery.class);
	}
	
	public static List<CartorioQuery> makeListCartorioEntityToListCartorioQuery(List<Cartorio> listCartorioEntity){
		return listCartorioEntity.stream()
				.map(CartorioFactory::makeCartorioEntityToQuery)
				.collect(toList());
	}
}
