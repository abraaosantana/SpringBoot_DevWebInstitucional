package br.com.devweb.institucional.ws.model;

/**
 * Entidade baseada nos dados do WS do postmon.com
 */
public class PostmonEndereco {
    private String bairro;
    private String cidade;
    private String cep;
    private String logradouro;
    private PostmonEstadoInfo estadoInfo;
    private PostmonCidadeInfo cidadeInfo;
    private String estado;

    public String getBairro() {
        return bairro;
    }

    public PostmonEndereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public PostmonEndereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public PostmonEndereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public PostmonEndereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public PostmonEstadoInfo getEstadoInfo() {
        return estadoInfo;
    }

    public PostmonEndereco setEstadoInfo(PostmonEstadoInfo estadoInfo) {
        this.estadoInfo = estadoInfo;
        return this;
    }

    public PostmonCidadeInfo getCidadeInfo() {
        return cidadeInfo;
    }

    public PostmonEndereco setCidadeInfo(PostmonCidadeInfo cidadeInfo) {
        this.cidadeInfo = cidadeInfo;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public PostmonEndereco setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", estadoInfo=" + estadoInfo +
                ", cidadeInfo=" + cidadeInfo +
                ", estado='" + estado + '\'' +
                '}';
    }
}
