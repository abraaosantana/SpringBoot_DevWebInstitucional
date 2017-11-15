package br.com.devweb.institucional.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "seg_role")
@NamedQuery(name = "SegRole.findAll", query = "SELECT s FROM SegRole s")
public class SegRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEG_ROLE_IDROLE", sequenceName = "SEG_ROLE_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEG_ROLE_IDROLE")
	@Column(name = "id_role")
	private Long idRole;

	private String role;

	// bi-directional many-to-many association to SegUsuario
	@ManyToMany(mappedBy = "segRoles")
	private List<SegUsuario> segUsuarios;

	public SegRole() {
	}

	public Long getIdRole() {
		return this.idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<SegUsuario> getSegUsuarios() {
		return this.segUsuarios;
	}

	public void setSegUsuarios(List<SegUsuario> segUsuarios) {
		this.segUsuarios = segUsuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRole == null) ? 0 : idRole.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((segUsuarios == null) ? 0 : segUsuarios.hashCode());
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
		SegRole other = (SegRole) obj;
		if (idRole == null) {
			if (other.idRole != null)
				return false;
		} else if (!idRole.equals(other.idRole))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (segUsuarios == null) {
			if (other.segUsuarios != null)
				return false;
		} else if (!segUsuarios.equals(other.segUsuarios))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SegRole [idRole=" + idRole + ", role=" + role + ", segUsuarios=" + segUsuarios + "]";
	}

}