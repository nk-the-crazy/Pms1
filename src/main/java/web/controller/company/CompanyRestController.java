package web.controller.company;

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
import service.api.company.CompanyManager;

@RestController
@RequestMapping("/rest/company")
public class CompanyRestController
{
    // ---------------------------------
    private static final Logger logger = LoggerFactory.getLogger( CompanyController.class );
    // ---------------------------------


    @Autowired
    private CompanyManager companyManager;
   
    
    /*******************************************************
     * 
     */
    @RequestMapping("/code/generate")
    public String generateCode() 
    {
        return companyManager.generateCode();
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
            logger.error( " **** Error getting company list (REST)", e );  
        }
        return null;
    }
    
    
    /*******************************************************
     * 
     */
    @RequestMapping(value="" ,  method = RequestMethod.GET)
    public Company getCompanyByCode( @RequestParam( "code" ) String companyCode) 
    {
        try
        {
            return companyManager.getCompanyByCode( companyCode );
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting company Data (REST)", e );  
        }
        return null;
    }
    
    
    
    /*******************************************************
     * 
     */
    @RequestMapping(value="/{companyId}" ,  method = RequestMethod.GET)
    public Company getCompanyById( @PathVariable long companyId) 
    {
        try
        {
            return companyManager.getCompanyById( companyId );
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting company Data (REST)", e );  
        }
        return null;
    }

}
