package dao.impl.person;


import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import dao.api.person.PersonDAO;
import dao.impl.common.GenericDAOImpl;
import model.person.Person;


@Repository
public class PersonDAOImpl extends GenericDAOImpl<Person> implements PersonDAO
{

	public PersonDAOImpl()
    {
        super( Person.class );
    }


    /*************************************************************
	 * 
	 */
	@SuppressWarnings( "unchecked" )
	@Override
	public List<Person> getByName( String firstName, String lastName )
	{
		Query query = getEntityManager().createQuery( "Select e from Person e where LOWER(first_name) like '%" + firstName
		        + "%' and LOWER(last_name) like '%" + lastName + "%'" );
		return (List<Person>) query.getResultList();
	}
	
	
	 /*****************************************************
     *  
     */
    @Override
    @SuppressWarnings("unchecked")
    public Person getByCode( String personCode )
    {
        try
        {
            Query query = getEntityManager()
                    .createQuery( "Select p FROM Person p where p.code=:personCode" );
            query.setParameter( "personCode", personCode );
            List<Person> personList = (List<Person>) query.getResultList();

            if ( personList.isEmpty() )
                return null;
            else
                return (Person) personList.get( 0 );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        return null;
    }


}
