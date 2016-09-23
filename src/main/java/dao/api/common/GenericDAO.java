package dao.api.common;


import java.util.List;
import common.exceptions.dao.DAOException;


/**
 *
 */
public interface GenericDAO<T>
{
    /**
     *
     */
    void persist( T entity ) throws DAOException;

    /**
     *
     */
    T merge( T entity ) throws DAOException;

    /**
     *
     */
    void remove( T entity ) throws DAOException;

    /***************************
     *
     */
    T find( Object id );

    /***************************
    *
    */
    List<T> findAll() throws DAOException;

    /***************************
    *
    */
    int getMaxId();

}