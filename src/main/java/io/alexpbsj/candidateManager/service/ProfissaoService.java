package io.alexpbsj.candidateManager.service;

import io.alexpbsj.candidateManager.model.Profissao;
import io.alexpbsj.candidateManager.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissaoService {

    @Autowired
    private ProfissaoRepository profissaoRepository;

    public List<Profissao> findAll(){
        return profissaoRepository.findAll();
    }
}
