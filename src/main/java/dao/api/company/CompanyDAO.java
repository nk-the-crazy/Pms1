package dao.api.company;

import dao.api.common.GenericDAO;
import model.company.Company;

public interface CompanyDAO extends GenericDAO<Company>
{

    Company getByCode( String companyCode );

    Company getByName( String companyName );

    Company getCompanyPersons( long companyId );

    Company getCompanyPerson( long companyId, long personId );

}
