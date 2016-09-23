package dao.impl.company;


import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import dao.api.company.CompanyDAO;
import dao.impl.common.GenericDAOImpl;
import model.company.Company;


@Repository
public class CompanyDAOImpl extends GenericDAOImpl<Company> implements CompanyDAO
{

    public CompanyDAOImpl()
    {
        super( Company.class );
    }

    /*****************************************************
     *  
     */
    @Override
    @SuppressWarnings("unchecked")
    public Company getByName( String companyName )
    {
        try
        {
            Query query = getEntityManager()
                    .createQuery( "Select e FROM Company e where e.status=1 and e.companyName=:companyName" );
            query.setParameter( "companyName", companyName );
            List<Company> companyList = (List<Company>) query.getResultList();

            if ( companyList.isEmpty() )
                return null;
            else
                return (Company) companyList.get( 0 );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        return null;
    }

    /*****************************************************
     *  
     */
    @Override
    @SuppressWarnings("unchecked")
    public Company getByCode( String companyCode )
    {
        try
        {
            Query query = getEntityManager()
                    .createQuery( "Select e FROM Company e where e.code=:companyCode" );
            query.setParameter( "companyCode", companyCode );
            List<Company> companyList = (List<Company>) query.getResultList();

            if ( companyList.isEmpty() )
                return null;
            else
                return (Company) companyList.get( 0 );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        return null;
    }
    

    /*****************************************************
     *  
     */
    @Override
    public Company getCompanyPersons( long companyId )
    {
        try
        {
            Query query = getEntityManager()
                    .createQuery( "Select e FROM Company e JOIN FETCH e.persons where e.id=:id" );
            query.setParameter( "id", companyId );
            Company company = (Company) query.getSingleResult();

            if ( company != null )
                return company;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        return null;

    }
    

    /*****************************************************
     *  
     */
    @Override
    public Company getCompanyPerson( long companyId, long personId )
    {
        try
        {
            Query query = getEntityManager()
                    .createQuery( "Select e FROM Company e JOIN FETCH e.persons p where e.id=:company_id and p.id=:person_id" );
            query.setParameter( "company_id", companyId );
            query.setParameter( "person_id", personId );
            Company company = (Company) query.getSingleResult();

            if ( company != null )
                return company;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        return null;

    }

}
