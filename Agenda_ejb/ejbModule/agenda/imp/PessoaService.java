package agenda.imp;




import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import br.com.agenda.entidades.Pessoa;

import DAO.local.PessoaDAOLocal;
import agenda.PessoaServiceLocal;



@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PessoaService implements PessoaServiceLocal {

    @EJB
    private PessoaDAOLocal pessoaDAOLocal;
    
	@Override
	public Pessoa recuperarPessoa() {
	
	
		return pessoaDAOLocal.recupararPessoa(1L);
	}


	

	
	

	
	
	

}
	
