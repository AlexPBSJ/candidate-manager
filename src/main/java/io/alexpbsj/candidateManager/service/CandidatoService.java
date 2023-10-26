package io.alexpbsj.candidateManager.service;

import io.alexpbsj.candidateManager.dtos.CandidatoInput;
import io.alexpbsj.candidateManager.enums.Descricao;
import io.alexpbsj.candidateManager.model.Candidato;
import io.alexpbsj.candidateManager.model.Profissao;
import io.alexpbsj.candidateManager.repository.CandidatoRepository;
import io.alexpbsj.candidateManager.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static io.alexpbsj.candidateManager.enums.Descricao.basedOnValue;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;
    @Autowired
    private ProfissaoRepository profissaoRepository;

    public List<Candidato> findAll(){
        return candidatoRepository.findAll();
    }

    public Candidato findById(Long id){
        return candidatoRepository.findById(id).orElse(null);
    }

    public Candidato save(CandidatoInput candidatoDTO){
        Descricao descricao = Descricao.basedOnValue(candidatoDTO.profissao());
        if(descricao == null){
            throw new IllegalArgumentException("Profissao nao existe");
        }

        Optional<Profissao> byDescricao = profissaoRepository.findByDescricao(descricao);

        if(byDescricao.isEmpty()){
            throw new IllegalArgumentException("Is empty");
        }

        Candidato candidato = new Candidato(candidatoDTO, byDescricao.get());

        return candidatoRepository.save(candidato);
    }

    public void deleteById(Long id){
        candidatoRepository.deleteById(id);
    }
}
