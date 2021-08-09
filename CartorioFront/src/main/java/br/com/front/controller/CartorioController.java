package br.com.front.controller;

import java.util.List;

import br.com.front.bean.CartorioBean;
import br.com.front.bean.CartorioCertidaoBean;
import br.com.front.bean.CertidaoBean;
import br.com.front.feign.FeignBuilder;
import br.com.front.service.CartorioService;

public class CartorioController {
	private static final CartorioService service = FeignBuilder.getInstanceWithTokenAcess(CartorioService.class);
	
	
	public static List<CartorioBean> listaCartorios() throws Exception {
		return service.listaCartorios();
	}


	public static CartorioBean getByIdCartorio(Integer idCartorio) throws Exception {
		return service.getByIdCartorio(idCartorio);
	}


	public static CartorioBean cadastrar(CartorioBean cartorioBean) throws Exception {
		return service.cadastrar(cartorioBean);
	}


	public static void deleteById(Integer idCartorio) throws Exception{
		service.deleteById(idCartorio);
		
	}


	public static CartorioBean getInfosById(Integer idCartorio) throws Exception{
		return service.getInfosById(idCartorio);
	}


	public static List<CertidaoBean> listaCertidoes() throws Exception{
		return service.listaCertidoes();
	}


	public static void salvarVinculoCartorioCertidao(Integer idCartorio, List<CartorioCertidaoBean> listCartorioCertidaoBean)throws Exception {
		service.salvarVinculoCartorioCertidao(idCartorio,listCartorioCertidaoBean);
		
	}


	public static List<Integer> getListSelecionados(Integer idCartorio)throws Exception {
		return service.getListSelecionados(idCartorio);
	}


	
}
