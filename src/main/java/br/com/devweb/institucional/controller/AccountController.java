package br.com.devweb.institucional.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.devweb.institucional.model.SegUsuario;

@Controller
public class AccountController {

	private final Logger LOG = LoggerFactory.getLogger(AccountController.class);

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login(@AuthenticationPrincipal SegUsuario user) {

		ModelAndView modelAndView = new ModelAndView("account/login");

		if (user != null) {
			LOG.info("Usuario " + user.getEmail() + " encontrado!");
			modelAndView.setViewName("admin/index");
			LOG.info("Renderizando view " + modelAndView.getViewName());
			return modelAndView;

		} else {

			return modelAndView;

		}

	}
	
	@GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

	@GetMapping("/profile")
	public ModelAndView profile() {
		ModelAndView modelAndView = new ModelAndView("/account/profile");
		return modelAndView;
	}

}
