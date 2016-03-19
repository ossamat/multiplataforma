package agenda.imp;




import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import br.com.agenda.entidades.Pessoa;

import DAO.local.PessoaDAOLocal;
import agenda.PessoaServiceLocal;
import agenda.PessoaServiceRemote;



@Stateless(name="PessoaRemoteService")
@Remote(PessoaServiceRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PessoaRemoteService implements PessoaServiceRemote {

    @EJB
    private PessoaDAOLocal pessoaDAOLocal;
    
	@Override
	public Pessoa recuperarPessoa() {
	
	
		return pessoaDAOLocal.recupararPessoa(1L);
	}


	

	
	

	
	
	

}
	
