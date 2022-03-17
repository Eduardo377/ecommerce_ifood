package br.com.isidrocorp.ecommerce.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.Cipher;

public class EcommerceCrypto {
	
	public static String encrypt(String original) throws Exception {
		//Creating a Signature object
	    Signature sign = Signature.getInstance("SHA256withRSA");
		
		// 1 Preciso criar um Objeto do tipo KeyPairGenerator (para escolher meu algoritmo  de geração da chave)
		KeyPairGenerator keyPair = KeyPairGenerator.getInstance("RSA");
		
		// escolhi o tamanho da chave de criptografia (neste caso 2048 bits, o equivalente a uma string de 256 caracteres)
		keyPair.initialize(2048);
		
		// gera essa chave
		KeyPair pair = keyPair.generateKeyPair();
				
		// obtenho a chave pública a partir desta chave gerada
		PublicKey publicKey = pair.getPublic();
		
		// preciso escolher o algoritmo de Criptografia
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		
		// inicializando o algoritmo de criptografia
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		
		// agora sim vamos trabalhar a "transformação" da nossa string
		cipher.update(original.getBytes());
		
		// gero a string criptografada
		String originalCripto = new String(cipher.doFinal(), "UTF-8");
		
		return originalCripto;
	}

}
