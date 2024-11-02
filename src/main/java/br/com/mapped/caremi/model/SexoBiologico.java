package br.com.mapped.caremi.model;

public enum SexoBiologico {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    INTERSEXUAL("Intersexual");

    private final String descricao;

    SexoBiologico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}