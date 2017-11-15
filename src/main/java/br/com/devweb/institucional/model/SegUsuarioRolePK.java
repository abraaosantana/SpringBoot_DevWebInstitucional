package br.com.devweb.institucional.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the seg_usuario_role database table.
 * 
 */
@Embeddable
public class SegUsuarioRolePK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "id_usuario", insertable = false, updatable = false)
	private Long idUsuario;

	@Column(name = "id_role", insertable = false, updatable = false)
	private Long idRole;

	public SegUsuarioRolePK() {
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdRole() {
		return this.idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SegUsuarioRolePK)) {
			return false;
		}
		SegUsuarioRolePK castOther = (SegUsuarioRolePK) other;
		return this.idUsuario.equals(castOther.idUsuario) && this.idRole.equals(castOther.idRole);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario.hashCode();
		hash = hash * prime + this.idRole.hashCode();

		return hash;
	}
}