package service.impl.product;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.exceptions.dao.DAOException;
import dao.api.product.ProductDAO;
import model.product.Product;
import service.api.product.ProductManager;

@Service("productManagerService")
@Transactional
public class ProductManagerImpl implements ProductManager
{

    //---------------------------------
    private static final Logger logger = LoggerFactory.getLogger(ProductManagerImpl.class);
    //---------------------------------

    
    @Autowired
    private ProductDAO productDAO;


    /****************************************
     * 
     */
    @Override
    public Product addProduct( String code, String name , short type)
    {
        Product product = null;

        try
        {
            product = new Product();
            product.setCode( code ); 
            product.setName( name );
            product.setType( type );

            productDAO.merge( product );
        }
        catch ( Exception e )
        {
            logger.error( "**** Error adding new Product" ,e );
        }

        return product;
    }


    /****************************************
     * 
     */
    @Override
    public Product addProduct( Product Product )
    {
        try
        {
            return productDAO.merge( Product );
        }
        catch ( Exception e )
        {
            logger.error( "**** Error adding new Product" ,e );
        }

        return null;
    }
    

    /****************************************
     * 
     */
    @Override
    public void updateProduct( Product p )
    {
        try
        {
            productDAO.merge( p );
        }
        catch ( DAOException e )
        {
            logger.error( "**** Error merging Product" ,e );
        }
    }


    /****************************************
     * 
     */
    @Override
    public List<Product> getProductList()
    {
        try
        {
            return productDAO.findAll();
        }
        catch ( DAOException e )
        {
            return Collections.emptyList();
        }
    }


    /****************************************
     * 
     */
    @Override
    public Product getProductById( long id )
    {
        return productDAO.find( id );
    }


    /****************************************
     * 
     */
    @Override
    public void removeProduct( long id )
    {
        try
        {
            productDAO.remove( productDAO.find( id ) );
        }
        catch ( DAOException e )
        {
            logger.error( "**** Error removing Product by id:" + id ,e );
        }
    }


    /****************************************
     * 
     */
    @Override
    public Product getProductByName( String productName)
    {
        return productDAO.getByName( productName );
    }


    /****************************************
     * 
     */
    @Override
    public Product getProductByCode( String productCode)
    {
        return productDAO.getByCode( productCode );
    }
    
    
    /****************************************
     * 
     */
    @Override
    public Product getProductCostDetails( String productCode)
    {
        return productDAO.getProductCostDetails( productCode );
    }
    
    
    /**************************************************
     * 
     */
    @Override
    public Product getProductDetails(long productId)
    {
        try
        {
            Product product = productDAO.find( productId );
            
            if(product != null)
            {
                product.getProductDetails().getDetails();
                product.getProductCostDetails().getUnitPrice();
            }
            
            return product;
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error getting product details:", e);
        }
        
        return null;
    }
    
    
    
    /**************************************************
     * 
     */
    @Override
    public String generateCode()
    {
        String code = "R";
        try
        {
            int maxId = productDAO.getMaxId() + 1;
            code = code + String.format("%06d", maxId);
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error  generating Code:", e);
        }
        
        return code;
    }


}
