package classes;



import java.io.Serializable;

//transfer object
public class Produto implements Serializable{
	
	private Long id;
	
	private String nome;
	
	private double preco;
	
	private int quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public boolean equals(Object o) {
		Produto that = (Produto)o;
		return this.id == that.id;
	}

	
	
	
	
	

}