package br.com.cartorio.core.repositoryImpl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.cartorio.core.entity.CartorioCertidaoVinc;

public interface CartorioCertidaoRepositorySpringData extends JpaRepository<CartorioCertidaoVinc, Integer>, JpaSpecificationExecutor<CartorioCertidaoVinc>{

	@Modifying
	@Query("DELETE FROM CartorioCertidaoVinc WHERE idCartorio =?1")
	void deletarVinculos(Integer idCartorio);

	@Query(value = "SELECT id_certidao FROM cartorio_certidao_vinc WHERE id_cartorio = ?1", nativeQuery = true)
	List<Integer> getListCertidoesSelecionados(Integer idCartorio);
}
