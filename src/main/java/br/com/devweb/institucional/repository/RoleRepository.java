package br.com.devweb.institucional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devweb.institucional.model.SegRole;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<SegRole, Long>{
	SegRole findByRole(String role);

}
