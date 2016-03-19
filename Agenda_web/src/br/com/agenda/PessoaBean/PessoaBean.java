package br.com.agenda.PessoaBean;


import java.io.Serializable;



import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.agenda.entidades.Pessoa;
import agenda.PessoaServiceLocal;


@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaBean implements Serializable {

	/**
	 * 
	 */
	
	private String nomePessoa;
	
	

	private static final long serialVersionUID = 1L;
	@EJB
	private PessoaServiceLocal pessoaServiceLocal;

	public void recuperarPessoa(){
		
		
		Pessoa pessoaList =pessoaServiceLocal.recuperarPessoa();
		
		if(pessoaList != null)
		nomePessoa = pessoaList.getNome();
	
	
	}
	
	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	
	
}