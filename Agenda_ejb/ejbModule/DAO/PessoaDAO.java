package DAO;



import java.util.ArrayList;
import java.util.List;
import DAO.AbstractGenericDAO;
import DAO.local.PessoaDAOLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



import javax.ejb.TransactionManagementType;
import br.com.agenda.entidades.*;
import javax.ejb.TransactionAttributeType;;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PessoaDAO extends AbstractGenericDAO<Pessoa,Long> implements PessoaDAOLocal {

	 @EJB
	    private PessoaDAOLocal dao;
	
	public PessoaDAO() {
		super(Pessoa.class);
		// TODO Auto-generated constructor stub
	}

	private static final String SQL_RECUPERAR_POR_NOME = 
			"Pessoa.recuperar";
	//private static final String SQL_RECUPERAR_RESGATE_ATIVO = 
	//		"resgateDotal.recuperaAberturaResgateAtivo";
	
	

	
	
    /**
	 * Recupera Resgate Dotal a partir do status.
	 * @return List<ResgateDotal>
	 * @param Long
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Pessoa> recuperaPessoaPorNome(String nome) {

		final TypedQuery<Pessoa> query = 
                createNamedQuery(SQL_RECUPERAR_POR_NOME); 

		List<Pessoa> p =query.getResultList();
       return p;
		
	/*	List<Pessoa> result =
				((Session) getEntityManager().getDelegate())
						.createQuery(SQL_RECUPERAR_POR_NOME)
						.setParameter("nome", nome)
						.list();
*/
		

	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Pessoa recupararPessoa(long documentoPrincipal) {
		Query query = createNamedQuery(SQL_RECUPERAR_POR_NOME);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
          
	
		pessoas.addAll(query.getResultList());

		if (!pessoas.isEmpty()) {
			return pessoas.get(0);
		}

		return null;
	}

	
	   public void salvar(Pessoa pess) {
	       
	        dao.persist(pess);
	    }

	   public void remover(Pessoa pess) {
	       
	        dao.remove(pess);
	    }
	   
	   
	   

}
