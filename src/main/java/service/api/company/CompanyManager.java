package service.api.company;

import java.util.List;

import model.company.Company;
import model.person.Person; 

public interface CompanyManager
{
    Company addCompany( Company company );

    Company updateCompany( Company company );

    List<Company> getCompanyList();

    String generateCode();

    Company getCompanyDetails( long companyId );

    List<Person> getCompanyEmployees( long companyId );

    Company getCompanyFullDetails( long companyId );

    Company getCompanyById( long companyId );

    Company getCompanyByCode( String companyCode );

    void addPerson( long companyId, long personId );

}
