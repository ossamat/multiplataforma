
package DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.collections.CollectionUtils;

import agenda.DAO;





/**
 * Classe generica para implementacao dos DAOs.
 *
 * @param <T> tipo generico - entidade
 * @param <P> tipo generico - pk da entidade
 */
public abstract class AbstractGenericDAO<T extends Serializable, P extends Serializable> implements DAO<T, P> 
                   {
    
    /** type. */
    private Class<T> type;

    @PersistenceContext(unitName = "agendaJpa", type = PersistenceContextType.TRANSACTION) 
    private EntityManager em;
   
   /**
    *{@inheritDoc} 
    */
    @Override
   public void persist(final T t) {
       em.persist(t);
   }

   /**
    *{@inheritDoc} 
    */
   @Override
   public T find(final P pk) {
       return em.find(type, pk);
   }

   /**
    *{@inheritDoc} 
    */
   @Override
   public T merge(final T t) {
       return em.merge(t);
   }

   /**
    *{@inheritDoc} 
    */
   @Override
   public void remove(final T t) {
       em.remove(em.merge(t));
   }

   /**
    *{@inheritDoc} 
    */
    @Override
   public T refresh(T t) {
       if (!em.contains(t)) {
           t = em.merge(t);
       }
       em.refresh(t);
       return t;
   }
    
    /**
     * Instancia um novo objeto abstract generic eao.
     *
     * @param type o type
     */
    public AbstractGenericDAO(final Class<T> type) {
        this.type = type;
        this.em = getEntityManager();
         }

  

    /**
     * Obtém entity manager.
     *
     * @return entity manager
     */
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * Creates the named query.
     *
     * @param query o query
     * @return typed query
     */
    protected TypedQuery<T> createNamedQuery(final String query) {
        return getEntityManager().createNamedQuery(query, type);
    }

    
    protected Query createNativeQuery(final String query) {
        return getEntityManager().createNativeQuery(query);
    }
    
    /**
     * Obtém single result.
     *
     * @param query o query
     * @return single result
     */
    protected T getSingleResult(final TypedQuery<T> query) {
        T entidade = null;
        List<T> entidades = query.getResultList();
        if (CollectionUtils.isNotEmpty(entidades)) {
            entidade = entidades.iterator().next();  
        }
        return entidade;
    }
    
    /**
     * Obtém id single result.
     *
     * @param query o query
     * @return id single result
     */
    protected P getIdSingleResult(final TypedQuery<P> query) {
        P entidade = null;
        List<P> entidades = query.getResultList();
        if (CollectionUtils.isNotEmpty(entidades)) {
            entidade = entidades.iterator().next();  
        }
        return entidade;
    }
    
    /**
     * Obtém single result object.
     *
     * @param query o query
     * @return single result object
     */
    protected Object getSingleResultObject(final TypedQuery<?> query) {
        Object entidade = null;
        List<?> entidades = query.getResultList();
        if (CollectionUtils.isNotEmpty(entidades)) {
            entidade = entidades.iterator().next();  
        }
        return entidade;
    }
    
    /**
     * Obtém entity type.
     *
     * @return entity type
     */
    public Class<T> getEntityType() {
        return type;
    }
}