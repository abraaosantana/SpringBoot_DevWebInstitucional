package br.com.devweb.institucional.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "seg_usuario")
@NamedQueries({ @NamedQuery(name = "SegUsuario.findAll", query = "SELECT u FROM SegUsuario u"),
		@NamedQuery(name = "SegUsuario.findPorId", query = "SELECT u FROM SegUsuario u where u.id = :id"),
		@NamedQuery(name = "SegUsuario.findPorLogin", query = "SELECT u FROM SegUsuario u where u.login = :login"),
		@NamedQuery(name = "SegUsuario.findPorEmail", query = "SELECT u FROM SegUsuario u where u.email = :email"),
		@NamedQuery(name = "SegUsuario.findPorToken", query = "SELECT u FROM SegUsuario u where u.token = :token"), })
public class SegUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "ativo")
	private boolean ativo;

	@Column(name = "cpf", unique = true)
	@CPF(message = "*Informe um CPF válido!")
	private String cpf;

	@Column(name = "data_criacao")
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;

	@Column(name = "email")
	@NotEmpty(message = "*Informe um email!")
	@Email(message = "*Iforme um email válido!")
	private String email;

	@NotEmpty(message = "*Informe um login! Ex. beatriz.santana")
	private String login;

	@Column(name = "nome")
	@NotEmpty(message = "*Informe seu nome!")
	@Pattern(message = "*Informe apenas letras no campo nome!", regexp = "^[A-Za-z áàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]*$")
	private String nome;

	@Column(name = "ultimo_nome")
	@NotEmpty(message = "*Informe seu Sobrenome!")
	@Pattern(message = "*Informe apenas letras no campo Sobrenome!", regexp = "^[A-Za-z áàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]*$")
	private String ultimoNome;

	@Column(name = "password")
	@NotEmpty(message = "*Informe sua senha!")
	@Length(min = 6, message = "*Sua senha deve conter no mínimo 6 caracteres!")
	private String password;

	private String token;

	@Column(name = "validade_token")
	private Date validadeToken;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "seg_usuario_role", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_role"))
	private Set<SegRole> segRole;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UsuarioProfile usuarioProfile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getValidadeToken() {
		return validadeToken;
	}

	public void setValidadeToken(Date validadeToken) {
		this.validadeToken = validadeToken;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Set<SegRole> getRole() {
		return segRole;
	}

	public void setRoles(Set<SegRole> segRole) {
		this.segRole = segRole;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Set<SegRole> getSegRole() {
		return segRole;
	}

	public void setSegRole(Set<SegRole> segRole) {
		this.segRole = segRole;
	}

	public UsuarioProfile getUsuarioProfile() {
		return usuarioProfile;
	}

	public void setUsuarioProfile(UsuarioProfile usuarioProfile) {
		this.usuarioProfile = usuarioProfile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		SegUsuario other = (SegUsuario) obj;
		if (ativo != other.ativo)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SegUsuario [id=" + id + ", ativo=" + ativo + ", cpf=" + cpf + ", dataCriacao=" + dataCriacao
				+ ", email=" + email + ", login=" + login + ", nome=" + nome + ", ultimoNome=" + ultimoNome
				+ ", password=" + password + ", token=" + token + ", validadeToken=" + validadeToken + ", segRole="
				+ segRole + ", usuarioProfile=" + usuarioProfile + "]";
	}

}
