package io.alexpbsj.candidateManager.model;

import io.alexpbsj.candidateManager.dtos.CandidatoInput;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@Entity
@Table(name = "candidato")

public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String contacto;
    private Integer idade;
    private String morada;
    @ManyToOne
    @JoinColumn(name = "profissao_id")
    private Profissao profissao;

    public Candidato() {

    }

    public Candidato(CandidatoInput candidatoInput, Profissao profissao) {
        this.nome = candidatoInput.nome();
        this.contacto = candidatoInput.contacto();
        this.idade = candidatoInput.idade();
        this.morada = candidatoInput.morada();
        this.profissao = profissao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }
}
