package br.com.devweb.intitucional.util;

public class ValidaCepUtil {

	public static boolean validaCep(String cep) {
		if (!cep.matches("\\d{8}")) {
			return false;
		}

		return true;
	}

}
