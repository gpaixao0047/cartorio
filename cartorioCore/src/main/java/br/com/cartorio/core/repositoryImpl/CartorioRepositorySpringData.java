package br.com.cartorio.core.repositoryImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import br.com.cartorio.core.entity.Cartorio;

public interface CartorioRepositorySpringData extends JpaRepository<Cartorio, Integer>, JpaSpecificationExecutor<Cartorio>{

	@Query(value = "SELECT * FROM cartorio WHERE id_cartorio = ?1", nativeQuery = true)
	Cartorio getInfos(Integer idCartorio);

	

}
