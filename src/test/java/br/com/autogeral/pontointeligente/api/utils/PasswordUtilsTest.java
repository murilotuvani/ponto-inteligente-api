package br.com.autogeral.pontointeligente.api.utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtilsTest {
	
	private static final String SENHA = "1234";
	private final BCryptPasswordEncoder bCryptEconder = new BCryptPasswordEncoder();

	@Test
	public void testSenhaVazia() {
		assertNull(PasswordUtils.gerarBCrypt(null));
		assertNull(PasswordUtils.gerarBCrypt(""));
	}
	
	@Test
	public void testGerarHashSenha() {
		String hash = PasswordUtils.gerarBCrypt(SENHA);
		assertTrue(bCryptEconder.matches(SENHA, hash));
	}

}
