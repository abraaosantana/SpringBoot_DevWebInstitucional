package br.com.devweb.institucional.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "seg_usuario_role")
@NamedQuery(name = "SegUsuarioRole.findAll", query = "SELECT s FROM SegUsuarioRole s")
public class SegUsuarioRole implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SegUsuarioRolePK id;

	public SegUsuarioRole() {
	}

	public SegUsuarioRolePK getId() {
		return this.id;
	}

	public void setId(SegUsuarioRolePK id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SegUsuarioRole [id=" + id + "]";
	}

}