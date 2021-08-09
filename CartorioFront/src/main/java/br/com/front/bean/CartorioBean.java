package br.com.front.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartorioBean implements Serializable{
	
	private Integer idCartorio;
	private String nome;
	private String endereco;
}
