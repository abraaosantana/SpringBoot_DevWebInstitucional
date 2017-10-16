package br.com.devweb.institucional.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.devweb.institucional.model.SegUsuario;
import br.com.devweb.institucional.service.NotificacaoService;
import br.com.devweb.institucional.service.UserService;

@Controller
public class RegistroController {

	private final Logger log = LoggerFactory.getLogger(RegistroController.class);
	
	@Autowired
	private NotificacaoService notificacaoService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/registro")
	public ModelAndView registration(SegUsuario user) {
		ModelAndView modelAndView = new ModelAndView("/account/register");
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@PostMapping("/registro")
	public ModelAndView createNewUser(@Valid SegUsuario user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("/account/register");
		
		log.info("Iniciando controller /registro");
		
		SegUsuario userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			modelAndView.addObject("errorMessageEmail",
					"Já existe um usuário cadastrado com esse email: " + user.getEmail());
			modelAndView.setViewName("/account/login");
			return modelAndView;
		}

		if (bindingResult.hasErrors()) {
			List<String> lista2 = new ArrayList<String>();
			for (FieldError lista : bindingResult.getFieldErrors()) {
				lista.getDefaultMessage();
				lista2.add(new String(lista.getDefaultMessage()));
			}

			modelAndView.addObject("errorMessage", lista2);
			modelAndView.addObject("user", user);

		} else {
			String senhaInformada = user.getPassword();
			
			userService.saveUser(user);
			notificacaoService.enviarNotificacao(user, senhaInformada);
			
			modelAndView.addObject("successMessage", user.getNome() + " cadastrado(a) com sucesso!");
			
			modelAndView.setViewName("/account/login");
		}
		return modelAndView;
	}

	@GetMapping("/reset")
	public ModelAndView esqueceuSenha(SegUsuario user) {
		ModelAndView modelAndView = new ModelAndView("/account/reset");
		modelAndView.addObject("user", user);
		return modelAndView;
	}


	@PostMapping("/reset")
	public ModelAndView resetSenha(@Valid SegUsuario user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
		/** Verifica usuário por email informado, caso não exista exibe mensagem de erro 
		 *  e solicita registro.
		 * */

		SegUsuario userExists = userService.findUserByEmail(user.getEmail());
		
		if (userExists == null) {
			modelAndView.addObject("errorMessageEmail",
					"Não existe nenhum usuário cadastrado com esse email! Realizar cadastro para " + user.getEmail());
			modelAndView.addObject("user", user);
			modelAndView.setViewName("/account/register");
			return modelAndView;
		}else {
			String novaSenha = "123456";
			userExists.setPassword(novaSenha);
			userService.saveUser(userExists);
			notificacaoService.enviarNotificacao(userExists, novaSenha);
			modelAndView.addObject("successMessage",
					"Nova senha enviada para o e-mail: " + user.getEmail());
			modelAndView.setViewName("/account/login");
			return modelAndView;
		}
	}
		
		
}