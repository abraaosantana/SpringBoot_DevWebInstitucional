package br.com.devweb.institucional.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entidade baseada nos dados do WS do viacep.com
 */
@Entity
@Table(name = "usuario_endereco")
@NamedQuery(name = "UsuarioEndereco.findAll", query = "SELECT u FROM UsuarioEndereco u")
public class UsuarioEndereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USUARIO_IDENDERECO", sequenceName = "USUARIO_ENDERECO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_IDENDERECO")
	private Long id;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String numero;
	private String uf;
	private String unidade;
	private String ibge;
	private String gia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public UsuarioEndereco setCep(String cep) {
		this.cep = cep;
		return this;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public UsuarioEndereco setLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public String getNumero() {
		return this.numero;
	}

	public UsuarioEndereco setNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public String getComplemento() {
		return complemento;
	}

	public UsuarioEndereco setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}

	public String getBairro() {
		return bairro;
	}

	public UsuarioEndereco setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public String getLocalidade() {
		return localidade;
	}

	public UsuarioEndereco setLocalidade(String localidade) {
		this.localidade = localidade;
		return this;
	}

	public String getUf() {
		return uf;
	}

	public UsuarioEndereco setUf(String uf) {
		this.uf = uf;
		return this;
	}

	public String getUnidade() {
		return unidade;
	}

	public UsuarioEndereco setUnidade(String unidade) {
		this.unidade = unidade;
		return this;
	}

	public String getIbge() {
		return ibge;
	}

	public UsuarioEndereco setIbge(String ibge) {
		this.ibge = ibge;
		return this;
	}

	public String getGia() {
		return gia;
	}

	public UsuarioEndereco setGia(String gia) {
		this.gia = gia;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEndereco other = (UsuarioEndereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioEndereco [id=" + id + ", cep=" + cep + ", logradouro=" + logradouro + ", complemento="
				+ complemento + ", bairro=" + bairro + ", localidade=" + localidade + ", numero=" + numero + ", uf="
				+ uf + ", unidade=" + unidade + ", ibge=" + ibge + ", gia=" + gia + "]";
	}

}
