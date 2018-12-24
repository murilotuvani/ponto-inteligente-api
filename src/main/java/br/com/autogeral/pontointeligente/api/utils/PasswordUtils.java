package br.com.autogeral.pontointeligente.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);
	
	/**
	 * Gera um hash utilizando o BCrypt
	 * @param senha
	 * @return
	 */
	public static String gerarBCrypt(String senha) {
		String hash = null;
		if (senha != null) {
			log.info("Gerando hash com o BCrypt.");
			BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
			hash = bCryptEncoder.encode(senha);
		}
		return hash;
	}

	public static boolean senhaValida(String string, String senhaEncoded) {
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.matches(string, senhaEncoded);
	}

}
