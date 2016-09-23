package dao.api.person;

import java.util.List;

import dao.api.common.GenericDAO;
import model.person.Person;

public interface PersonDAO extends GenericDAO<Person>
{

	/****************************************
	 * 
	 */
	public List<Person> getByName( String firstName, String lastName);

    Person getByCode( String personCode );

}
