package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;





@Named
@SessionScoped
public class CarrinhoController implements Serializable {
		
	//Atributo do tipo lista que guardara os produtos adicionados ao carrinho
	List<Produto> listaCarrinho;

	public List<Produto> getListaCarrinho() {
		return listaCarrinho;
	}

	public void setListaCarrinho(List<Produto> listaCarrinho) {
		this.listaCarrinho = listaCarrinho;
	}
	
public void adicionarEscolhido(Produto produto) {
		
		if (!listaCarrinho.contains(produto)) {
			listaCarrinho.add(produto);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Produto adicionado ao carrinho!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Produto já presente no carrinho!"));
		}
		
		
		
	}

public void remover(Produto produto) {
	
	listaCarrinho.remove(produto);
	
}


@PostConstruct
public void init() {
	listaCarrinho = 
			new ArrayList<Produto>();
}

	
}
