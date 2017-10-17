package br.com.devweb.institucional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.devweb.institucional.model.SegUsuario;
import br.com.devweb.institucional.service.UserServiceImpl;

@Controller
@RequestMapping("/sistema")
public class AdminController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("admin/index");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		SegUsuario user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("segUsuario", user);

		return modelAndView;
	}

	@GetMapping("/dashboardv2")
	public ModelAndView dashboardv2() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/index2");
		return modelAndView;
	}

	@GetMapping("/layout/top-nav")
	public ModelAndView layoutTopNav() {
		ModelAndView modelAndView = new ModelAndView("admin/pages/layout/top-nav");
		return modelAndView;
	}

	@GetMapping("/layout/boxed")
	public ModelAndView layoutBoxed() {
		ModelAndView modelAndView = new ModelAndView("admin/pages/layout/boxed");
		return modelAndView;
	}

	@GetMapping("/layout/collapsed-sidebar")
	public ModelAndView layoutCollapsedSidebar() {
		ModelAndView modelAndView = new ModelAndView("admin/pages/layout/collapsed-sidebar");
		return modelAndView;
	}

	@GetMapping("/layout/fixed")
	public ModelAndView layoutFixed() {
		ModelAndView modelAndView = new ModelAndView("admin/pages/layout/fixed");
		return modelAndView;
	}

	@GetMapping("/widgets")
	public ModelAndView widgets() {
		ModelAndView modelAndView = new ModelAndView("admin/pages/widgets");
		return modelAndView;
	}

	@GetMapping("/chartjs")
	public ModelAndView chartjs() {
		ModelAndView modelAndView = new ModelAndView("admin/pages/charts/chartjs");
		return modelAndView;
	}

	@GetMapping("/inline")
	public ModelAndView inline() {
		ModelAndView modelAndView = new ModelAndView("admin/pages/charts/inline");
		return modelAndView;
	}

	@GetMapping("/morris")
	public ModelAndView morris() {
		ModelAndView modelAndView = new ModelAndView("admin/pages/charts/morris");
		return modelAndView;
	}

	@GetMapping("/blank")
	public ModelAndView blank() {
		ModelAndView modelAndView = new ModelAndView("admin/pages/examples/blank");
		return modelAndView;
	}

	@GetMapping("/invoice-print")
	public ModelAndView invoicePrint() {
		ModelAndView modelAndView = new ModelAndView("admin/pages/examples/invoice-print");
		return modelAndView;
	}

	@GetMapping("/invoice")
	public ModelAndView invoice() {
		ModelAndView modelAndView = new ModelAndView("admin/pages/examples/invoice");
		return modelAndView;
	}

	@GetMapping("/pace")
	public ModelAndView pace() {
		ModelAndView modelAndView = new ModelAndView("admin/pages/examples/pace");
		return modelAndView;
	}

}
