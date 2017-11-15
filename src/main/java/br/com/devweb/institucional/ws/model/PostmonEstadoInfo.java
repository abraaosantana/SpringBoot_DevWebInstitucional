package br.com.devweb.institucional.ws.model;

public class PostmonEstadoInfo {
    private String area_km2;
    private String codigo_ibge;
    private String nome;

    public String getArea_km2() {
        return area_km2;
    }

    public PostmonEstadoInfo setArea_km2(String area_km2) {
        this.area_km2 = area_km2;
        return this;
    }

    public String getCodigo_ibge() {
        return codigo_ibge;
    }

    public PostmonEstadoInfo setCodigo_ibge(String codigo_ibge) {
        this.codigo_ibge = codigo_ibge;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public PostmonEstadoInfo setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return "EstadoInfo{" +
                "area_km2='" + area_km2 + '\'' +
                ", codigo_ibge='" + codigo_ibge + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
