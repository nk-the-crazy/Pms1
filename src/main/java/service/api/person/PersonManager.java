package service.api.person;

import java.util.List;

import model.person.Person;

public interface PersonManager
{
	public Person addPerson( String firstName, String lastName , String middleName , short gender);
	
    public List<Person> getPersonList();
    
    public void updatePerson( Person p );
    
    public Person getPersonById(long id);
    
    public void removePerson(long id);
    
    public List<Person> getPersonByName(String firstName, String lastName);

    Person addPerson( Person person );

    Person getPersonDetails( long personId );

    String generateCode();

    Person getPersonFullDetails( long personId );

    public Person getPersonByCode( String personCode );
    
}
