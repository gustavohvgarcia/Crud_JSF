package classes;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;







@Named
@ViewScoped
public class ProdutoController implements Serializable{

	//Atributos da classe ProdutoController
	private Produto produto;
	
	private List<Produto> listaProdutos;
	
	
	//getters e setters
	public List<Produto> getListaProdutos() {
		return this.listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	//***MÉTODOS***
	
	//ADICIONAR AO BANCO
	//Método responsável pela inserção de um produto no banco de dados
	//declara um data access object para transferir os arquivos de entrada para o banco atraves do metodo inserir
	//retorna uma mensagem de sucesso na tela caso tudo ocorra como o esperado
	public void adicionar() {
		ProdutoDAO prod_dao = 
				new ProdutoDAO();
		
		prod_dao.inserir(this.produto);
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Produto "+this.produto.getNome()+" inserido com sucesso!"));
	}
	
	//BUSCAR NO BANCO
	
	public void buscarPorNome() {
		ProdutoDAO prod_dao = 
				new ProdutoDAO();
		
		System.out.println("Nome: "+this.produto.getNome());
		
		this.listaProdutos = 
				prod_dao.buscarPorNome(this.produto.getNome());
		
	}
	
	//EXCLUIR DO BANCO
	public void remover(Produto produto) {
			
			long idProduto = 
					produto.getId();
			
			ProdutoDAO prod_dao = 
					new ProdutoDAO();
			
			prod_dao.excluir(idProduto);
		
			listaProdutos.remove(produto);
			
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Produto "+produto.getNome()+" removido com sucesso!"));
		
	}
	
	public void alterar(Produto produto) {
		
		ProdutoDAO prod_dao = 
				new ProdutoDAO();
		
		prod_dao.alterar(produto);
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Dados do produto (id = "+produto.getId()+") alterado com sucesso"));
		
	}
	
	@PostConstruct
	public void init() {
		 produto = new Produto();
	}

}
