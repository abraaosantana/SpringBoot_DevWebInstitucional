package br.com.devweb.institucional.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.devweb.institucional.model.SegUsuario;
import br.com.devweb.institucional.service.UserServiceImpl;

@Controller
public class AccountController {

	private final Logger LOG = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login(@AuthenticationPrincipal SegUsuario user) {

		ModelAndView modelAndView = new ModelAndView("account/login");
		LOG.info("Realizando login.");
		modelAndView.addObject("errorMessage", "Se é o primeiro acesso, realize o cadastro!");
		return modelAndView;

	}

	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}

	@GetMapping("/profile")
	public ModelAndView profile(SegUsuario user) {
		ModelAndView modelAndView = new ModelAndView("account/profile");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("segUsuario", user);
			
		return modelAndView;
	}

	@PostMapping("/profile")
	public ModelAndView createNewUser(@Valid SegUsuario user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("account/profile");

		LOG.info("Iniciando cadastro perfil de usuario");

		SegUsuario userExists = userService.findUserByEmail(user.getEmail());
		
		/**
		 * Somente teste para consumir ws de endereco pelo java
		 * Consumindo ws e Peenchendo formulario com javascript
		 */

		/*
		String formCep = user.getUsuarioProfile().getCep();
	    if (!formCep.equals(null) && !(formCep.contains("-"))) {
			UsuarioEndereco endereco = ClienteWsViaCep.getEnderecoPorCep(formCep);
		    user.getUsuarioProfile().setCep(endereco.getCep());
		    user.getUsuarioProfile().setBairro(endereco.getBairro());
		    user.getUsuarioProfile().setLocalidade(endereco.getLocalidade());
		    user.getUsuarioProfile().setComplemento(endereco.getComplemento());
		    user.getUsuarioProfile().setLogradouro(endereco.getLogradouro());
		    user.getUsuarioProfile().setUf(endereco.getUf());
		    user.getUsuarioProfile().setIbge(endereco.getIbge());
		    
			modelAndView.addObject("successMessage", "* Cep: " + formCep + " encontrado!Formulario preenchido com sucesso! ");
			modelAndView.setViewName("/account/profile");
			return modelAndView;
	    } */
		
		if (userExists != null) {
			if (userExists.getUsuarioProfile() != null) {
				
				user.getUsuarioProfile().setId(userExists.getUsuarioProfile().getId());
				user.getUsuarioProfile().getUsuarioEndereco().setId(userExists.getUsuarioProfile().getUsuarioEndereco().getId());
				
				userService.updateProfile(user.getUsuarioProfile());
				
				modelAndView.addObject("successMessage", "*  " + user.getNome() + " seu cadastro foi atualizado com sucesso! ");
				modelAndView.setViewName("account/profile");
				
				return modelAndView;
						    
		    } else {
		    	
		    	userExists.setUsuarioProfile(user.getUsuarioProfile());
				userService.updateUser(userExists);
				modelAndView.addObject("successMessage", "*  " + user.getNome() + " seu cadastro foi atualizado com sucesso! ");
				modelAndView.setViewName("account/profile");
				return modelAndView;
			
		    }
		}
		
		if (bindingResult.hasErrors()) {
			List<String> lista2 = new ArrayList<String>();
			for (FieldError lista : bindingResult.getFieldErrors()) {
				lista.getDefaultMessage();
				lista2.add(new String(lista.getDefaultMessage()));
			}

			modelAndView.addObject("errorMessage", lista2);
			modelAndView.addObject("segUsuario", user);

		}
		return modelAndView;
	}

}
