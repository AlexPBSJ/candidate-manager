package io.alexpbsj.candidateManager.model;

import io.alexpbsj.candidateManager.enums.Descricao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profissao")

public class Profissao {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private Descricao descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
