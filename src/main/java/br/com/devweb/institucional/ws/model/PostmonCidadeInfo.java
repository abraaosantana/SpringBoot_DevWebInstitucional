package br.com.devweb.institucional.ws.model;

public class PostmonCidadeInfo {
    private String area_km2;
    private String codigo_ibge;

    public String getArea_km2() {
        return area_km2;
    }

    public PostmonCidadeInfo setArea_km2(String area_km2) {
        this.area_km2 = area_km2;
        return this;
    }

    public String getCodigo_ibge() {
        return codigo_ibge;
    }

    public PostmonCidadeInfo setCodigo_ibge(String codigo_ibge) {
        this.codigo_ibge = codigo_ibge;
        return this;
    }

    @Override
    public String toString() {
        return "CidadeInfo{" +
                "area_km2='" + area_km2 + '\'' +
                ", codigo_ibge='" + codigo_ibge + '\'' +
                '}';
    }
}
