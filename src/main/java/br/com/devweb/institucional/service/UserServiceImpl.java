package br.com.devweb.institucional.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.devweb.institucional.model.SegRole;
import br.com.devweb.institucional.model.SegUsuario;
import br.com.devweb.institucional.model.UsuarioProfile;
import br.com.devweb.institucional.repository.ProfileRepository;
import br.com.devweb.institucional.repository.RoleRepository;
import br.com.devweb.institucional.repository.UserRepository;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public SegUsuario findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(SegUsuario user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setAtivo(true);
		user.setDataCriacao(new Date());

		List<SegRole> userRole = roleRepository.findByRole("USER");
		if (userRole != null) {
			user.setSegRoles(userRole);
			userRepository.save(user);
		} else {

			// TODO: Persitir SegRole
			SegRole role = new SegRole();
			role.setIdRole(new Long(1));
			role.setRole("ADMIN");
			roleRepository.save(role);
			role.setIdRole(new Long(2));
			role.setRole("USER");
			roleRepository.save(role);

			userRole = roleRepository.findByRole("USER");
			user.setSegRoles(userRole);
			userRepository.save(user);

		}
	}
	
	@Override
	public void updateUser(SegUsuario user) {

		userRepository.saveAndFlush(user);	

	}
	
	@Override
	public void updateProfile(UsuarioProfile profile) {

		profileRepository.saveAndFlush(profile);	

	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		SegUsuario user = userRepository.findByEmail(userName);
		List<GrantedAuthority> authorities = getUserAuthority(user.getSegRoles());

		return buildUserForAuthentication(user, authorities);

	}

	private List<GrantedAuthority> getUserAuthority(List<SegRole> userRole) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (SegRole segRole : userRole) {
			roles.add(new SimpleGrantedAuthority(segRole.getRole()));
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(SegUsuario user, List<GrantedAuthority> authorities) {

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.isAtivo(), true, true, true, authorities);
	}

}
