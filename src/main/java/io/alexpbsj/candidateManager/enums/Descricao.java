package io.alexpbsj.candidateManager.enums;

public enum Descricao {
    ESTUDANTE("Estudante"),
    DESEMPREGADO("Desempregado"),
    TRABALHADOR_OUTREM("Trabalhador por conta de outrem"),
    TRABALHADOR_PROPRIA("Trabalhador por conta propria"),
    OUTRO("Outro");

    private String value;

    public static final Descricao[] VALUES = Descricao.values();

    Descricao(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static Descricao basedOnValue(String value){
        for(Descricao d : VALUES){
            if(d.getValue().equals(value)){
                return d;
            }
        }
        return null;
    }
}
