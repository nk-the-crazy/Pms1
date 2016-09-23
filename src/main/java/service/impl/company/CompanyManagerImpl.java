package service.impl.company;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.api.company.CompanyDAO;
import dao.api.person.PersonDAO;
import javassist.NotFoundException;
import model.company.Company;
import model.person.Person;
import service.api.company.CompanyManager;

@Service("companyManagerService")
@Transactional
public class CompanyManagerImpl implements CompanyManager
{
    //---------------------------------
    private static final Logger logger = LoggerFactory.getLogger(CompanyManagerImpl.class);
    //---------------------------------
            
    @Autowired
    CompanyDAO companyDAO;
    
    @Autowired
    PersonDAO personDAO;
    
    
    /**************************************************
     * 
     */
    @Override
    public Company addCompany( Company company )
    {
        try
        {
            companyDAO.persist( company );
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error adding new company:", e);
        }
        
        return company;
    }

    
    /**************************************************
     * 
     */
    @Override
    public Company updateCompany( Company company )
    {
        try
        {
            companyDAO.merge( company );
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error adding new company:", e);
        }
        
        return company;
    }
    

    /**************************************************
     * 
     */
    @Override
    public List<Company> getCompanyList()
    {
        try
        {
            return companyDAO.findAll();
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error adding new company:", e);
        }
        
        return Collections.emptyList();
    }
    
    
    /**************************************************
     * 
     */
    @Override
    public Company getCompanyById(long companyId)
    {
        try
        {
            Company company = companyDAO.find( companyId );
            
            if(company != null)
            {
                return company;
            }
            
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error getting company info:", e);
        }
        
        return null;
    }
    
    
    /**************************************************
     * 
     */
    @Override
    public Company getCompanyByCode(String companyCode)
    {
        try
        {
            Company company = companyDAO.getByCode( companyCode );
            
            if(company != null)
            {
                return company;
            }
            
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error getting company by Code:", e);
        }
        
        return null;
    }
    
    /**************************************************
     * 
     */
    @Override
    public Company getCompanyDetails(long companyId)
    {
        try
        {
            Company company = companyDAO.find( companyId );
            
            if(company != null)
            {
                if(company.getContact() != null)
                    company.getContact().getId();
                if(company.getAddress() != null)
                    company.getAddress().getId();
                if(company.getCompanyDetails() != null)
                    company.getCompanyDetails().getId();
                
                return company;
            }
            
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error getting company details:", e);
        }
        
        return null;
    }
    
    /**************************************************
     * 
     */
    @Override
    public Company getCompanyFullDetails(long companyId)
    {
        try
        {
            Company company = companyDAO.find( companyId );
            
            if(company != null)
            {
                if(company.getContact() != null)
                    company.getContact().getId();
                if(company.getAddress() != null)
                    company.getAddress().getId();
                if(company.getCompanyDetails() != null)
                    company.getCompanyDetails().getId();
                if(company.getPersons() != null)
                    company.getPersons().size();
                
                return company;
            }
            
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error getting company full details:", e);
        }
        
        return null;
    }
    
    /**************************************************
     * 
     */
    @Override
    public List<Person> getCompanyEmployees(long companyId)
    {
        try
        {
            Company company = companyDAO.getCompanyPersons( companyId );
            
            if(company != null)
            {
                if(company.getPersons() != null)
                    return company.getPersons();
            }
            
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error getting company employees:", e);
        }
        
        return Collections.emptyList();
    }
    
    
    /**************************************************
     * 
     */
    @Override
    public String generateCode()
    {
        String code = "F";
        try
        {
            int maxId = companyDAO.getMaxId() + 1;
            code = code + String.format("%04d", maxId);
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error  generating Code:", e);
        }
        
        return code;
    }
    
    
    /**************************************************
     * 
     */
    @Override
    public void addPerson(long companyId, long personId)
    {
        try
        {
            Company company = companyDAO.find( companyId );
            Person person = personDAO.find( personId );
            
            if(company != null && person != null)
            {
                company.addPerson( person );
                companyDAO.merge( company );
            }
            else
            {
                throw new NotFoundException( "No data found for companyId:" + companyId  );
            }
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error adding person:", e);
        }
    }
    
    


}
