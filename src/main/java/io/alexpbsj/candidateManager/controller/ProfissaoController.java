package io.alexpbsj.candidateManager.controller;

import io.alexpbsj.candidateManager.model.Profissao;
import io.alexpbsj.candidateManager.service.ProfissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("noesis/profissoes")
public class ProfissaoController {
    @Autowired
    private ProfissaoService profissaoService;

    @GetMapping
    public List<Profissao> getAll(){
        return profissaoService.findAll();
    }
}
