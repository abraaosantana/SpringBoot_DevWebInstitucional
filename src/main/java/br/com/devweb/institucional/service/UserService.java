package br.com.devweb.institucional.service;

import br.com.devweb.institucional.model.SegUsuario;

public interface UserService {
	public SegUsuario findUserByEmail(String email);
	public void saveUser(SegUsuario user);
}
