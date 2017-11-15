package br.com.devweb.institucional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devweb.institucional.model.SegUsuario;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<SegUsuario, Long> {
	
	SegUsuario findByEmail(String email);
	
}
