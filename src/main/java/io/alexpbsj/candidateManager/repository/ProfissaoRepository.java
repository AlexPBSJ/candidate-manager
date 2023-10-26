package io.alexpbsj.candidateManager.repository;

import io.alexpbsj.candidateManager.enums.Descricao;
import io.alexpbsj.candidateManager.model.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Long> {
    Optional<Profissao> findByDescricao(Descricao descricao);
}
