package br.com.Vendas.domain;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "TB_FUNCIONARIOS")
@NamedQueries({ @NamedQuery(name = "Funcionario.listar", query = "SELECT funcionario FROM Funcionario funcionario"),
		@NamedQuery(name = "Funcionario.buscarPorCodigo", query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.codigo = :codigo") })
public class Funcionario {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "FUN_CODIGO")
	private Long Codigo;

	@Column(name = "FUN_NOME", length = 50, nullable = false, unique = true)
	private String nome;

	@Column(name = "FUN_CPF", length = 20, nullable = false)
	private String cpf;

	@Column(name = "FUN_SENHA", length = 50, nullable = false)
	private String senha;

	@Column(name = "FUN_FUNCAO", length = 50, nullable = false)
	private String funcao;

	public Long getCodigo() {
		return Codigo;
	}

	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Funcionario [Codigo=" + Codigo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", funcao="
				+ funcao + "]";
	}

}
