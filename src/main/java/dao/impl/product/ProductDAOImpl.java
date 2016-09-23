package dao.impl.product;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import dao.api.product.ProductDAO;
import dao.impl.common.GenericDAOImpl;
import model.product.Product;

@Repository
public class ProductDAOImpl extends GenericDAOImpl<Product> implements ProductDAO
{

    public ProductDAOImpl()
    {
        super( Product.class );
    }
    
    
    /*****************************************************
     * 
     * 
     * */
    @Override
    @SuppressWarnings("unchecked")
    public Product getByName( String productName)
    {
        try
        {
            Query query = getEntityManager().createQuery( "Select e FROM Product e where e.name=:productName" );
            query.setParameter( "productName", productName );
            List<Product> userList = (List<Product>)query.getResultList();
            
            
            if(userList.isEmpty())
                return null;
            else
                return (Product)userList.get( 0 );
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    


    /*****************************************************
     * 
     * 
     * */
    @Override
    @SuppressWarnings("unchecked")
    public Product getByCode( String productCode)
    {
        try
        {
            Query query = getEntityManager().createQuery( "Select e FROM Product e where e.code=:productCode" );
            query.setParameter( "productCode", productCode );
            List<Product> userList = (List<Product>)query.getResultList();
            
            
            if(userList.isEmpty())
                return null;
            else
                return (Product)userList.get( 0 );
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    /*****************************************************
     *  
     */
    @Override
    public Product getProductCostDetails( String productCode )
    {
        try
        {
            Query query = getEntityManager()
                    .createQuery( "Select p FROM Product p JOIN FETCH p.productCostDetails where p.code=:productCode" );
            query.setParameter( "productCode", productCode );
            Product product = (Product) query.getSingleResult();

            if ( product != null )
                return product;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        return null;

    }
    
    
}
