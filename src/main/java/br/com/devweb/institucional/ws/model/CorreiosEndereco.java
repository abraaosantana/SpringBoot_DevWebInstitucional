package br.com.devweb.institucional.ws.model;

/**
 * Entidade baseada nos dados do WS dos correios
 */
public class CorreiosEndereco {

    private String cep;
    private String uf;
    private String bairro;
    private String cidade;
    private String logradouro;
    private String complemento;
    private String complemento2;

    public String getCep() {
        return cep;
    }

    public String getUf() {
        return uf;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getComplemento2() {
        return complemento2;
    }

    public CorreiosEndereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public CorreiosEndereco setUf(String uf) {
        this.uf = uf;
        return this;
    }
    
	public CorreiosEndereco setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

    public CorreiosEndereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public CorreiosEndereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public CorreiosEndereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public CorreiosEndereco setComplemento2(String complemento2) {
        this.complemento2 = complemento2;
        return this;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", uf='" + uf + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", complemento2='" + complemento2 + '\'' +
                '}';
    }

}
