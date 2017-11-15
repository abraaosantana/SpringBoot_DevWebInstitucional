package br.com.devweb.institucional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devweb.institucional.model.UsuarioProfile;

@Repository("profileRepository")
public interface ProfileRepository extends JpaRepository<UsuarioProfile, Long> {
	
	
}
