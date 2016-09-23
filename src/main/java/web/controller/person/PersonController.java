package web.controller.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.person.Person;
import service.api.person.PersonManager;
import web.view.ModelView;

@Controller
public class PersonController
{
    //---------------------------------
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    //---------------------------------
    
    
    @Autowired
    private PersonManager personManager;
    
    
    /*******************************************************
     * 
     * */
    @RequestMapping("/register_person.vw")
    public String registerPersonView()
    {
        return ModelView.VIEW_PERSON_REGISTER_PAGE;
    }
    
    
    /*******************************************************
     * 
     */
    @RequestMapping( value = "/register_person.do", method = RequestMethod.POST )
    public ModelAndView registerPerson( @ModelAttribute( "person" ) Person person )
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            person = personManager.addPerson( person );
            
            if ( person != null )
            {
                return getPersonList();
            }
            else
            {
                model.setViewName( ModelView.VIEW_PERSON_REGISTER_PAGE);
            }
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error registering person", e );        
            model.setViewName( ModelView.VIEW_PERSON_REGISTER_PAGE);
        }
        
        return model;
        
    }


    /*******************************************************
     * 
     */
    @RequestMapping( value = "/person_list.vw")
    public ModelAndView getPersonList()
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            List<Person> persons = personManager.getPersonList();
            
            model.addObject( "personList", persons );
            model.setViewName( ModelView.VIEW_PERSON_LIST_PAGE);
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting person list", e );        
        }
        
        return model;
        
    }
    
    
    /*******************************************************
     * 
     */
    @RequestMapping( value = "/person_details.vw", method = RequestMethod.GET)
    public ModelAndView getPersonDetails(@RequestParam( "person_id" ) long personId )
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            Person person = personManager.getPersonFullDetails( personId );
            
            if(person != null)
            {
                model.addObject( "personDetails", person );
            }
            
            model.setViewName( ModelView.VIEW_PERSON_DETAILS_PAGE);
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting person details", e );        
        }
        
        return model;
        
    }




}
