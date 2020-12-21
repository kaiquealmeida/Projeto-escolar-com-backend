package com.erick.escolar.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.erick.escolar.utils.Utilidades;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pessoa implements Serializable	{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String cpf;
	private Date dataNascimento;	
	private String endereco;
	private String telefone1;
	private String telefone2;
	private Date dataCadastro;
	
	
	public Pessoa() {
		
	}

	public Pessoa(Integer id, String nome, String sobrenome, String email, String senha, Date dataNascimento, String cpf, String endereco, String telefone1, String telefone2,
			Date dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.dataCadastro = dataCadastro;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDataNascimento() {
		return Utilidades.timestampToDate2(dataNascimento);
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone1() {
		return telefone1;
	}


	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}


	public String getTelefone2() {
		return telefone2;
	}


	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}


	public String  getDataCadastro() {
		return Utilidades.timestampToDate2(dataCadastro);
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", senha="
				+ senha + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco
				+ ", telefone1=" + telefone1 + ", telefone2=" + telefone2 + ", dataCadastro=" + dataCadastro + "]";
	}

}
