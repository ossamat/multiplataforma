/*
 * Direitos de  c�pia pela BRASILPREV
 *
 * Todos os direitos reservados.
 *
 * Este sistema cont�m informa��es confidenciais e de propriedade da
 * BRASILPREV ("Informa��es Confidenciais").
 * Voc�  n�o deve divulgar tais informa��es confidenciais e deve
 * us�-las somente em conformidade com os termos do contrato de licen�a
 * definidos pela BRASILPREV.
 */
package DAO.local;

import java.util.List;

import javax.ejb.Local;

import br.com.agenda.entidades.Pessoa;

import agenda.DAO;

/**
 * Interface EAO Local para a entidade DocumentoEmissao.
 */
@Local
public interface PessoaDAOLocal extends DAO<Pessoa,Long> {

    /**
     * Recupera todos os tipos cadastrados.
     *
     * @return list Lista de tipos encontrados.
     */
	Pessoa recupararPessoa(long documentoPrincipal);
	List<Pessoa> recuperaPessoaPorNome(String nome);
    
}
