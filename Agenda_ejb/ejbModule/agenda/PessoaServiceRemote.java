package agenda;


import javax.ejb.Remote;

import br.com.agenda.entidades.Pessoa;

@Remote
public interface PessoaServiceRemote {

	
Pessoa recuperarPessoa();	
	
}
