package web.controller.company;

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

import model.company.Company;
import service.api.company.CompanyManager;
import web.view.ModelView;

@Controller
public class CompanyController
{
    // ---------------------------------
    private static final Logger logger = LoggerFactory.getLogger( CompanyController.class );
    // ---------------------------------


    @Autowired
    private CompanyManager companyManager;

    /*******************************************************
     * 
     * */
    @RequestMapping("/register_company.vw")
    public String registerCompanyView()
    {
        return ModelView.VIEW_COMPANY_REGISTER_PAGE;
    }
    
    
    /*******************************************************
     * 
     * */
    @RequestMapping("/add_person.vw")
    public ModelAndView addPersonView( @RequestParam( "company_id" ) long companyId)
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            model.addObject( "companyData", companyManager.getCompanyById( companyId ) );
            model.setViewName( ModelView.VIEW_ADD_PERSON_PAGE);
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting person company page", e ); 
        }
        
        return model;
    }
    
    
    /*******************************************************
     * 
     * */
    @RequestMapping("/add_person.do")
    public ModelAndView addPerson( @RequestParam( "company_id" ) long companyId , @RequestParam( "person_id" ) long personId)
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            companyManager.addPerson( companyId, personId );
            
            return getCompanyFullDetails(companyId);
        }
        catch(Exception e)
        {
            logger.error( " **** Error adding person to company", e ); 
        }
        
        return model;
    }
    
    
    
    /*******************************************************
     * 
     * */
    @RequestMapping( value = "/register_company.do", method = RequestMethod.POST )
    public ModelAndView registerCompany( @ModelAttribute( "company" ) Company company )
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            company = companyManager.addCompany( company );
            
            if ( company != null )
            {
                return getCompanyList();
            }
            else
            {
                //model.addObject( "loginMessage", messageSource.getMessage( "message.error.invalid_login",null, null));
                model.setViewName( ModelView.VIEW_COMPANY_REGISTER_PAGE);
            }
        }
        catch(Exception e)
        {
            logger.error( " **** Error registering company", e );        
        }
        
        return model;
        
    }


    /*******************************************************
     * 
     */
    @RequestMapping( value = "/company_list.vw")
    public ModelAndView getCompanyList()
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            List<Company> companies = companyManager.getCompanyList();
            
            model.addObject( "companyList", companies );
            model.setViewName( ModelView.VIEW_COMPANY_LIST_PAGE);
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting company list", e );        
        }
        
        return model;
        
    }
    

   
    /*******************************************************
     * 
     */
    @RequestMapping( value = "/company_details.vw", method = RequestMethod.GET)
    public ModelAndView getCompanyFullDetails(@RequestParam( "company_id" ) long companyId )
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            Company company = companyManager.getCompanyFullDetails( companyId );
            
            if(company != null)
            {
                model.addObject( "companyDetails", company );
            }
            
            model.setViewName( ModelView.VIEW_COMPANY_DETAILS_PAGE);
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting company details", e );        
        }
        
        return model;
        
    }
}