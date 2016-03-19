package agenda;


import javax.ejb.Local;


import br.com.agenda.entidades.Pessoa;

@Local
public interface PessoaServiceLocal {

	
Pessoa recuperarPessoa();	
	
}
