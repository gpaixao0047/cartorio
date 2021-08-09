package br.com.cartorio.core.factory;

import java.util.List;

import org.modelmapper.ModelMapper;

import static java.util.stream.Collectors.toList;
import br.com.cartorio.core.entity.Certidao;
import br.com.cartorio.core.query.CertidaoQuery;

public class CertidaoFactory {

	public CertidaoFactory() {
		
	}
	
	public static CertidaoQuery makeCertidaoEntityToQuery(Certidao certidaoEntity) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(certidaoEntity, CertidaoQuery.class);
	}
	
	public static List<CertidaoQuery> makeListCertidaoEntityToQuery(List<Certidao> listCertidaoEntity){
		return listCertidaoEntity.stream().map(CertidaoFactory::makeCertidaoEntityToQuery).collect(toList());
	}
	
}
