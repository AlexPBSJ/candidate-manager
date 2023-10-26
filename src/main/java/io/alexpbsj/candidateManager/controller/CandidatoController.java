package io.alexpbsj.candidateManager.controller;

import io.alexpbsj.candidateManager.dtos.CandidatoInput;
import io.alexpbsj.candidateManager.model.Candidato;
import io.alexpbsj.candidateManager.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("noesis/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping
    public List<Candidato> getAllCandidatos(){
        return candidatoService.findAll();
    }

    @GetMapping("/{id}")
    public Candidato getCandidato(@PathVariable Long id){
        return candidatoService.findById(id);
    }

    @PostMapping("/criar")
    public Candidato createCandidato(@RequestBody CandidatoInput candidato){
        return candidatoService.save(candidato);
    }

    @PutMapping("/editar/{id}")
    public Candidato updateCandidato(@PathVariable Long id, @RequestBody CandidatoInput candidato){
        return candidatoService.update(id, candidato);
    }

    @DeleteMapping("/apagar/{id}")
    public void deleteCandidato(@PathVariable Long id){
        candidatoService.deleteById(id);
    }
}
