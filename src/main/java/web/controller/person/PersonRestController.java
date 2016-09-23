package web.controller.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.company.Company;
import model.person.Person;
import service.api.person.PersonManager;

@RestController
@RequestMapping("/rest/person")
public class PersonRestController
{
    // ---------------------------------
    private static final Logger logger = LoggerFactory.getLogger( PersonRestController.class );
    // ---------------------------------


    @Autowired
    private PersonManager personManager;
   
    
    /*******************************************************
     * 
     */
    @RequestMapping("/code/generate")
    public String generateCode() 
    {
        return personManager.generateCode();
    }
    
    
    /*******************************************************
     * 
     */
    @RequestMapping("/list")
    public List<Company> getCompanyList() 
    {
        try
        {
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting person list (REST)", e );  
        }
        return null;
    }
    
    
    /*******************************************************
     * 
     */
    @RequestMapping(value="" ,  method = RequestMethod.GET)
    public Person getCompanyById( @RequestParam( "code" ) String personCode) 
    {
        try
        {
            Person person  = personManager.getPersonByCode( personCode );
            
            if(person != null)
            {
                person.setCompanies( null );
                person.setContact( null );
                person.setAddress( null );
                person.setUsers( null );
                person.setPersonDetails( null );
                
                return person;
            }
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting person Data (REST)", e );  
        }
        return null;
    }
    
    /*******************************************************
     * 
     */
    @RequestMapping(value="/{personId}" ,  method = RequestMethod.GET)
    public Person getCompanyById( @PathVariable long personId) 
    {
        try
        {
            return personManager.getPersonById( personId );
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting person Data (REST)", e );  
        }
        return null;
    }
}
