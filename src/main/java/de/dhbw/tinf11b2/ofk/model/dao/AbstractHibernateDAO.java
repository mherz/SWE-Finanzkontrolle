package de.dhbw.tinf11b2.ofk.model.dao;
 
import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
 
/**
 * @author felix
 *
 * @param <T>
 */
@Repository
@Transactional
public abstract class AbstractHibernateDAO< T extends Serializable> {
 
    private final Class< T> entity;
    @Autowired
    SessionFactory sessionFactory;
 
    /**
     * @param entityToSet
     */
    public AbstractHibernateDAO(final Class< T> entityToSet) {
        this.entity = entityToSet;
    }
 
    /**
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
	public T getById(final Long id) {
        Preconditions.checkArgument(id != null);
        return (T) this.getCurrentSession().get(this.entity, id);
    }
    
 
    /**
     * @return
     */
    @SuppressWarnings("unchecked")
	public List< T> getAll() {
        return this.getCurrentSession().createQuery("from " + this.entity.getName()).list();
    }
 
    /**
     * @param entity
     */
    public void create(final T entity){
        Preconditions.checkNotNull(entity);
        this.getCurrentSession().persist(entity);
    }
 
    /**
     * @param entity
     */
    public void update(final T entity) {
        Preconditions.checkNotNull(entity);
        this.getCurrentSession().merge(entity);
    }
 
    /**
     * @param entity
     */
    public void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        this.getCurrentSession().delete(entity);
    }
 
    /**
     * @param entityId
     */
    public void deleteById(final Long entityId) {
        final T entity = this.getById(entityId);
        Preconditions.checkState(entity != null);
        this.delete(entity);
    }
 
    /**
     * @param sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    /**
     * @return
     */
    protected final Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
 