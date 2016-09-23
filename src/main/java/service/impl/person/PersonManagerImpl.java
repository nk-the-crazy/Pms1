package service.impl.person;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.exceptions.dao.DAOException;
import dao.api.person.PersonDAO;
import model.person.Person;
import service.api.person.PersonManager;

@Service("personManagerService")
@Transactional
public class PersonManagerImpl implements PersonManager
{
    //---------------------------------
    private static final Logger logger = LoggerFactory.getLogger(PersonManagerImpl.class);
    //---------------------------------
    
    @Autowired
    private PersonDAO personDAO;


    /****************************************
     * 
     */
    @Override
    public Person addPerson( String firstName, String lastName, String middleName, short gender )
    {
        Person person = null;

        try
        {
            person = new Person();
            person.setFirstName( firstName );
            person.setLastName( lastName );
            person.setMiddleName( middleName );
            person.setGender( gender );

            personDAO.merge( person );
        }
        catch ( Exception e )
        {
            logger.error( "**** Error adding new Person" ,e );
        }

        return person;
    }


    /****************************************
     * 
     */
    @Override
    public Person addPerson( Person person )
    {
        try
        {
            return personDAO.merge( person );
        }
        catch ( Exception e )
        {
            logger.error( "**** Error adding new Person" ,e );
        }

        return null;
    }

    /****************************************
     * 
     */
    @Override
    public void updatePerson( Person p )
    {
        try
        {
            personDAO.merge( p );
        }
        catch ( DAOException e )
        {
            logger.error( "**** Error merging Person" ,e );
        }
    }


    /****************************************
     * 
     */
    @Override
    public List<Person> getPersonList()
    {
        try
        {
            return personDAO.findAll();
        }
        catch ( DAOException e )
        {
            return Collections.emptyList();
        }
    }


    /****************************************
     * 
     */
    @Override
    public Person getPersonById( long id )
    {
        return personDAO.find( id );
    }

    

    /****************************************
     * 
     */
    @Override
    public Person getPersonByCode(String personCode )
    {
        return personDAO.getByCode( personCode );
    }

    /****************************************
     * 
     */
    @Override
    public void removePerson( long id )
    {
        try
        {
            personDAO.remove( personDAO.find( id ) );
        }
        catch ( DAOException e )
        {
            logger.error( "**** Error removing Person with id:" + id ,e );
        }
    }


    /****************************************
     * 
     */
    @Override
    public List<Person> getPersonByName( String firstName, String lastName )
    {
        return personDAO.getByName( firstName, lastName );
    }
    
    
    
    /**************************************************
     * 
     */
    @Override
    public Person getPersonDetails(long personId)
    {
        try
        {
            Person person = personDAO.find( personId );
            
            if(person != null)
            {
                if(person.getContact() != null)
                    person.getContact().getId();
                if(person.getAddress() != null)
                    person.getAddress().getId();
                if(person.getPersonDetails() != null)
                    person.getPersonDetails().getId();
            }
            
            return person;
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error getting person details:", e);
        }
        
        return null;
    }
    
    /**************************************************
     * 
     */
    @Override
    public Person getPersonFullDetails(long personId)
    {
        try
        {
            Person person = personDAO.find( personId );
            
            if(person != null)
            {
                if(person.getContact() != null)
                    person.getContact().getId();
                if(person.getAddress() != null)
                    person.getAddress().getId();
                if(person.getPersonDetails() != null)
                    person.getPersonDetails().getId();
                if(person.getCompanies() != null)
                    person.getCompanies().size();
            }
            
            return person;
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error getting person details:", e);
        }
        
        return null;
    }
    
    /**************************************************
     * 
     */
    @Override
    public String generateCode()
    {
        String code = "P";
        try
        {
            int maxId = personDAO.getMaxId() + 1;
            code = code + String.format("%05d", maxId);
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error  generating Code:", e);
        }
        
        return code;
    }
    

}
