package br.com.cartorio.core.repositoryImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.cartorio.core.entity.Certidao;

public interface CertidaoRepositorySpringData extends JpaRepository<Certidao, Integer>, JpaSpecificationExecutor<Certidao> {

}
