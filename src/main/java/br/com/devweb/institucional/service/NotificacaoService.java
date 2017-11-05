package br.com.devweb.institucional.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.devweb.institucional.model.SegUsuario;

@Service
public class NotificacaoService {

	private Logger LOG = LoggerFactory.getLogger(NotificacaoService.class);
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificacaoService(JavaMailSender javaMailSender){
		this.javaMailSender = javaMailSender;
	}
	
	public void enviarNotificacao(SegUsuario usuario, String senha) throws MailException{
		
		//Lógica de envio de notificacao por email
		
		SimpleMailMessage email = new SimpleMailMessage();
		
		email.setTo(usuario.getEmail());
		email.setFrom("deploys.app@gmail.com");
		email.setSubject("DevWeb-Tecnologia - Cadastro");
		email.setText("Sua Senha: "+ senha);
		

		LOG.info("Enviando e-mail!");
		javaMailSender.send(email);
		
		LOG.info("Email enviado!");
	}
	
}
