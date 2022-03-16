package br.com.isidrocorp.ecommerce.security;

import java.security.Key;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import br.com.isidrocorp.ecommerce.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenUtil {
	// puro preciosismo para clean code
	private static final int    SEGUNDOS = 1000;
	private static final int    MINUTOS  = 60*SEGUNDOS;
	private static final int    HORAS    = 60*MINUTOS;
	private static final int    DIAS     = 24*HORAS;
	
	private static final String HEADER = "Authorization";  // cabecalho http
	private static final String PREFIX = "Bearer ";        // prefixo do token
	private static final long   EXPIRATION = 2*MINUTOS;    // tempo de validade
	private static final String SECRET_KEY = "3c0MMerc3Do1f00dP@r@T3st3sD3JWT*";  // palavra chave do token
	private static final String EMISSOR    = "ProfIsidroIfood";
	
	
	public static String createToken(Usuario usuario) {
		// crio uma chave através dos bytes dessa SECRET_KEY que defini
		Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
		
		String token = Jwts.builder().setSubject(usuario.getUsername())
								     .setIssuer(EMISSOR)
								     .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
								     .signWith(secretKey, SignatureAlgorithm.HS256)
								     .compact();
		System.out.println("TOKEN gerado = "+token);
		return PREFIX + token;
	}
	
	/* posso criar métodos auxiliares para ajudar na validação */
	private static boolean isExpirationValid(Date expiration) {
		return expiration.after(new Date(System.currentTimeMillis()));	// a expiração para ser válida tem que ser após a data atual	
	}
	private static boolean isEmissorValid(String emissor) {
		return emissor.equals(EMISSOR);
	}
	private static boolean isSubjectValid(String username) {
		return username!=null && username.length() > 0;
	}
	
	public static Authentication validate(HttpServletRequest request) {
		// extrair o token do cabeçalho
		// extrair as infos relevantes que eu quero do token
		// se for válido, retorno um objeto do tipo Authentication
	
		return null; 
	}

}
