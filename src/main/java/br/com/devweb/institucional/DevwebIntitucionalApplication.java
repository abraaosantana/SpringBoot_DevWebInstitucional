package br.com.devweb.institucional;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;


@SpringBootApplication
public class DevwebIntitucionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevwebIntitucionalApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
}

/**
 * extends SpringBootServletInitializer & SpringApplicationBuilder
 * utilizados para gerar deploy com WAR.
 */

//@SpringBootApplication
//public class DevwebIntitucionalApplication extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(DevwebIntitucionalApplication.class);
//    }
//
//	public static void main(String[] args) {
//		SpringApplication.run(DevwebIntitucionalApplication.class, args);
//	}
//	
//	@Bean
//	public LocaleResolver localeResolver() {
//		return new FixedLocaleResolver(new Locale("pt", "BR"));
//	}
//}
