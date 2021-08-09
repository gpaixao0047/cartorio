package br.com.cartorio.core.serviceImpl;

import static br.com.cartorio.core.factory.CartorioFactory.makeCartorioCommandToEntity;
import static br.com.cartorio.core.factory.CartorioFactory.makeCartorioEntityToQuery;
import static br.com.cartorio.core.factory.CartorioFactory.makeListCartorioEntityToListCartorioQuery;
import static br.com.cartorio.core.factory.CertidaoFactory.makeListCertidaoEntityToQuery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cartorio.core.command.CartorioCertidaoVincCommand;
import br.com.cartorio.core.command.CartorioCommand;
import br.com.cartorio.core.entity.Cartorio;
import br.com.cartorio.core.entity.Certidao;
import br.com.cartorio.core.query.CartorioQuery;
import br.com.cartorio.core.query.CertidaoQuery;
import br.com.cartorio.core.repository.CartorioRepository;
import br.com.cartorio.core.service.CartorioCertidaoVincService;
import br.com.cartorio.core.service.CartorioService;
import br.com.cartorio.core.service.CertidaoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CartorioServiceImpl implements CartorioService {

	private final CartorioRepository cartorioRepository;
	private final CartorioCertidaoVincService cartorioCertidaoVincService;
	private final CertidaoService certidaoService;
	private final String url ="https://docketdesafiobackend.herokuapp.com/api/v1/certidoes";
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CartorioQuery cadastrar(CartorioCommand cartorioCommand) {
		Cartorio cartorioEntity = makeCartorioCommandToEntity(cartorioCommand);
		cartorioEntity = cartorioRepository.saveOrUpdate(cartorioEntity);
		return makeCartorioEntityToQuery(cartorioEntity);
	}

	@Override
	public List<CartorioQuery> getAll() {
		List<Cartorio> listCartorioEntity = cartorioRepository.getAll();
		return makeListCartorioEntityToListCartorioQuery(listCartorioEntity);
	}

	@Override
	public void delete(Integer idCartorio) {
		cartorioCertidaoVincService.deletarVinculos(idCartorio);
		cartorioRepository.delete(idCartorio);

	}

	@Override
	public List<CertidaoQuery> cadastrarCertidoes() {
		ResponseEntity<List<Certidao>> listRespRestEntity = restTemplate
				.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Certidao>>() {});
		List<Certidao> listCertidaoEntity = listRespRestEntity.getBody();
		listCertidaoEntity =  certidaoService.cadastrar(listCertidaoEntity);
		return makeListCertidaoEntityToQuery(listCertidaoEntity);
	}

	@Override
	public CartorioQuery findById(Integer idCartorio) {
		Cartorio cartorioEntity =  cartorioRepository.findById(idCartorio);
		return makeCartorioEntityToQuery(cartorioEntity);
	}

	@Override
	public List<CertidaoQuery> getListCertidao() {
		List<CertidaoQuery> listCertidaoQuery = certidaoService.getListCertidao();
		return listCertidaoQuery;
	}

	@Override
	public void deletarVinculos(Integer idCartorio) {
		cartorioCertidaoVincService.deletarVinculos(idCartorio);
		
	}

	@Override
	public void cadastrarVinculoCertidao(List<CartorioCertidaoVincCommand> cartorioCertidaoVincCommand) {
		cartorioCertidaoVincService.cartorioCertidaoVincCommand(cartorioCertidaoVincCommand);
		
	}

	@Override
	public List<Integer> getListCertidoesSelecionados(Integer idCartorio) {
		return cartorioCertidaoVincService.getListCertidoesSelecionados(idCartorio);
	}

}
