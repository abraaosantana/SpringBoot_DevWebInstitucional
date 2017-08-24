package br.com.devweb.institucional.service;

import java.util.ArrayList;
import java.util.Arrays;
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
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public SegUsuario findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(SegUsuario user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setAtivo(true);
		SegRole userRole = roleRepository.findByRole("USER");
		if(userRole != null) {
			user.setRoles(new HashSet<SegRole>(Arrays.asList(userRole)));
			userRepository.save(user);
		} else {
			
			//TODO: Persitir SegRole no primeiro deploy
			SegRole role = new SegRole();
			role.setId(new Long(1));
			role.setRole("ADMIN");
			roleRepository.save(role);
			role.setId(new Long(2));
			role.setRole("USER");
			roleRepository.save(role);
			
			role = roleRepository.findByRole("USER");
			user.setRoles(new HashSet<SegRole>(Arrays.asList(role)));
			userRepository.save(user);
			
		}
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		SegUsuario user = userRepository.findByEmail(userName);
		List<GrantedAuthority> authorities = getUserAuthority(user.getRole());	
		
		return buildUserForAuthentication(user, authorities);
		
	}
 


	private List<GrantedAuthority> getUserAuthority(Set<SegRole> userRole) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (SegRole segRole : userRole) {
			roles.add(new SimpleGrantedAuthority(segRole.getRole()));
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(SegUsuario user, List<GrantedAuthority> authorities) {
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isAtivo(), true, true, true, authorities);
	}
	

}
