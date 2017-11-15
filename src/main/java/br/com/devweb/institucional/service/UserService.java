package br.com.devweb.institucional.service;

import br.com.devweb.institucional.model.SegUsuario;
import br.com.devweb.institucional.model.UsuarioProfile;

public interface UserService {
	public SegUsuario findUserByEmail(String email);
	public void saveUser(SegUsuario user);
	public void updateProfile(UsuarioProfile profile);
	public void updateUser(SegUsuario user);
}
