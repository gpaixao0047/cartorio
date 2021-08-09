package br.com.front.service;

import java.util.List;

import br.com.front.bean.CartorioBean;
import br.com.front.bean.CartorioCertidaoBean;
import br.com.front.bean.CertidaoBean;
import feign.Param;
import feign.RequestLine;

public interface CartorioService {

	@RequestLine("GET /cartorio/")
	List<CartorioBean> listaCartorios() throws Exception;

	@RequestLine("GET /cartorio/getInfos/{idCartorio}")
	CartorioBean getByIdCartorio(@Param("idCartorio")Integer idCartorio) throws Exception;

	@RequestLine("POST /cartorio")
	CartorioBean cadastrar(CartorioBean cartorioBean) throws Exception;

	@RequestLine("DELETE /cartorio/{idCartorio}")
	void deleteById(@Param("idCartorio")Integer idCartorio) throws Exception;

	@RequestLine("GET /cartorio/getInfos/{idCartorio}")
	CartorioBean getInfosById(@Param("idCartorio") Integer idCartorio) throws Exception;

	@RequestLine("GET /cartorio/getListCertidao")
	List<CertidaoBean> listaCertidoes() throws Exception;

	@RequestLine("POST /cartorio/cadastrarVinculoCertidao/{idCartorio}")
	void salvarVinculoCartorioCertidao(@Param("idCartorio")Integer idCartorio, List<CartorioCertidaoBean> listCartorioCertidaoBean) throws Exception;

	@RequestLine("GET /cartorio/getListCertidoesSelecionados/{idCartorio}")
	List<Integer> getListSelecionados(@Param("idCartorio")Integer idCartorio) throws Exception;

}
