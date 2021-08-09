package br.com.cartorio.core.controller;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cartorio.core.command.CartorioCertidaoVincCommand;
import br.com.cartorio.core.command.CartorioCommand;
import br.com.cartorio.core.query.CartorioQuery;
import br.com.cartorio.core.query.CertidaoQuery;
import br.com.cartorio.core.service.CartorioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cartorio")
@RequiredArgsConstructor
public class CartorioController {

	private final CartorioService service;

	@PostMapping
	@Transactional
	public ResponseEntity<CartorioQuery> cadastrar(@RequestBody CartorioCommand cartorioCommand) {
		CartorioQuery cartorioQuery = service.cadastrar(cartorioCommand);
		return ok(cartorioQuery);
	}

	@GetMapping("/getInfos/{idCartorio}")
	@Transactional
	public ResponseEntity<CartorioQuery> getByIdCartoriom(@PathVariable Integer idCartorio) {
		CartorioQuery cartorioQuery = service.findById(idCartorio);
		return ok(cartorioQuery);
	}

	@GetMapping
	@Transactional
	public ResponseEntity<List<CartorioQuery>> getAll() {
		List<CartorioQuery> listCartorioQuery = service.getAll();
		return ok(listCartorioQuery);
	}

	@DeleteMapping("/{idCartorio}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Integer idCartorio) {
		service.delete(idCartorio);
		return noContent().build();
	}

	@PostMapping("/cadastrarCertidoes")
	@Transactional
	public ResponseEntity<List<CertidaoQuery>> cadastrarCertidoes() {
		List<CertidaoQuery> listCertidaoQuery = service.cadastrarCertidoes();
		return ok(listCertidaoQuery);
	}


	@GetMapping("/getListCertidao")
	@Transactional
	public ResponseEntity<List<CertidaoQuery>> getListCertidaoQuery() {
		List<CertidaoQuery> listCertidaoQuery = service.getListCertidao();
		return ok(listCertidaoQuery);
	}

	@GetMapping("/getListCertidoesSelecionados/{idCartorio}")
	@Transactional
	public ResponseEntity<List<Integer>> getListCertidoesSelecionados(@PathVariable Integer idCartorio) {
		List<Integer> listCertidoesSelecionados = service.getListCertidoesSelecionados(idCartorio);
		return ok(listCertidoesSelecionados);
	}
	
	@PostMapping("/cadastrarVinculoCertidao/{idCartorio}")
	@Transactional
	public ResponseEntity<Void> cadastrarVinculoCertidao(@PathVariable Integer idCartorio,
			@RequestBody List<CartorioCertidaoVincCommand> cartorioCertidaoVincCommand) {
		service.deletarVinculos(idCartorio);
		service.cadastrarVinculoCertidao(cartorioCertidaoVincCommand);
		return noContent().build();
	}
}
