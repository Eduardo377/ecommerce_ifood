package br.com.isidrocorp.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity			// A anotação @Entity indica que a classe é mapeada para uma tabela (armazenar)
@Table(name="departamento")  // aqui eu especifico o nome da tabela no banco       
public class Departamento {
	

	@Id						   // mostra que o atributo é uma PK
	@Column(name = "numero")   // mapeio o atributo "numero" para a especificação da coluna "numero" na tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Indico que o valor é gerado e gerenciado pelo BD ( e o identity torna isso indepentende da implementação)
    private Integer numero;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String  nome;
	
	@Column(name = "andar")
	private Integer andar;
	
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAndar() {
		return andar;
	}
	public void setAndar(Integer andar) {
		this.andar = andar;
	}
	
	

}
