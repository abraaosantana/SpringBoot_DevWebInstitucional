package br.com.devweb.institucional.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_profile")
@NamedQuery(name = "UsuarioProfile.findAll", query = "SELECT u FROM UsuarioProfile u")
public class UsuarioProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USUARIO_PROFILE_ID", sequenceName = "SEG_USUARIO_PROFILE_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_PROFILE_ID")
	private Long id;

	private String celular;

	@Column(name = "telefone_fixo")
	private String telefoneFixo;

	private String profissao;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_endereco_id", foreignKey = @ForeignKey(name = "FK_USUARIO_ENDERECO"))
	private UsuarioEndereco usuarioEndereco;

	public UsuarioProfile() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getProfissao() {
		return this.profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getTelefoneFixo() {
		return this.telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public UsuarioEndereco getUsuarioEndereco() {
		return usuarioEndereco;
	}

	public void setUsuarioEndereco(UsuarioEndereco usuarioEndereco) {
		this.usuarioEndereco = usuarioEndereco;
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
		UsuarioProfile other = (UsuarioProfile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioProfile [id=" + id + ", celular=" + celular + ", telefoneFixo=" + telefoneFixo + ", profissao="
				+ profissao + ", usuarioEndereco=" + usuarioEndereco + "]";
	}

}