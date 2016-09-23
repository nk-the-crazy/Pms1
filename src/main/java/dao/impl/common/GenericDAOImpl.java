package dao.impl.common;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import common.exceptions.dao.DAOException;
import dao.api.common.GenericDAO;


/**
 *
 */
@Repository
public abstract class GenericDAOImpl<T> implements GenericDAO<T>
{

    private static final Logger LOGGER = LoggerFactory.getLogger( GenericDAOImpl.class );

    //**********************************
    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> type;
    //**********************************
    
    public GenericDAOImpl(Class<T> type) 
    {
       this.type = type;
    }
  

    @Override
    public void persist( T entity ) throws DAOException
    {
        try
        {
            entityManager.persist( entity );
        }
        catch ( Exception e )
        {
            LOGGER.error( " ***** GenericDAOImpl Error" + e,e );
            throw new DAOException( e );
        }
    }


    @Override
    public T merge( T entity ) throws DAOException
    {
        try
        {
            return entityManager.merge( entity );
        }
        catch ( Exception e )
        {
            LOGGER.error( " ***** GenericDAOImpl Error" + e,e );
            throw new DAOException( e );
        }
    }


    @Override
    public void remove( T entity ) throws DAOException
    {
        try
        {
            entityManager.remove( entity );
        }
        catch ( Exception e )
        {
            LOGGER.error( " ***** GenericDAOImpl Error" + e,e );
            throw new DAOException( e );
        }
    }

    
    @Override
    public T find(final Object id) 
    {
        return (T) this.entityManager.find(type, id);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() throws DAOException
    {
        try
        {
            return (List<T>)entityManager.createQuery( "Select t from " + type.getName() + " t" )
                                      .getResultList();
        }
        catch ( Exception e )
        {
            LOGGER.error( " ***** GenericDAOImpl Error" + e,e );
            throw new DAOException( e );
        }
    }
    
    
    public EntityManager getEntityManager()
    {
        return entityManager;
    }
    
    
    /*****************************************************
     *  
     */
    @Override
    public int getMaxId()
    {
        try
        {
            Query query = getEntityManager().createQuery( "Select MAX(e.id) FROM "+type.getName()+" e" );
            Number maxId = (Number) query.getSingleResult();
            return maxId.intValue();

        }
        catch ( Exception e )
        {
            return 0;
        }

    }



}