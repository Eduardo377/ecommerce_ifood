package br.com.isidrocorp.ecommerce.security;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EcommerceCrypto {
	
	public static String encrypt(String original) throws Exception {
		
		String strMinhaChave = "123456789 123456789 123456789 12"; 
		Key minhaChave = new SecretKeySpec(strMinhaChave.getBytes(), "AES");
		
		// preciso escolher o algoritmo de Criptografia
		Cipher cipher = Cipher.getInstance("AES");
		
		// inicializando o algoritmo de criptografia
		cipher.init(Cipher.ENCRYPT_MODE, minhaChave);
		
		// agora sim vamos trabalhar a "transformação" da nossa string
		cipher.update(original.getBytes());
				
		// gero a string criptografada
		String originalCripto = new String(cipher.doFinal(), "UTF-8");				
		byte[] teste = originalCripto.getBytes();
		
		StringBuilder cryptoHex = new StringBuilder();
		for (byte b: teste) {
			cryptoHex.append(Integer.toHexString(b));
		}
		
		return cryptoHex.toString();
	}

}
