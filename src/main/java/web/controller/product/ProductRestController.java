package web.controller.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.product.Product;
import service.api.product.ProductManager;
import web.controller.company.CompanyController;

@RestController
@RequestMapping("/rest/product")
public class ProductRestController
{
    // ---------------------------------
    private static final Logger logger = LoggerFactory.getLogger( CompanyController.class );
    // ---------------------------------


    @Autowired
    private ProductManager productManager;
   
    
    /*******************************************************
     * 
     */
    @RequestMapping("/code/generate")
    public String generateCode() 
    {
        return productManager.generateCode();
    }
    
    
    /*******************************************************
     * 
     */
    @RequestMapping("/list")
    public List<Product> getProductList() 
    {
        try
        {
            return null;
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting product list (REST)", e );  
        }
        return null;
    }
    
    
    /*******************************************************
     * 
     */
    @RequestMapping(value="/cost" ,  method = RequestMethod.GET)
    public Product getProductByCode( @RequestParam( "code" ) String productCode) 
    {
        try
        {
            Product product  = productManager.getProductCostDetails( productCode );
            
            if(product != null)
            {
                product.setProductDetails( null );
                return product;
            }
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting product by Code (REST)", e );  
        }
        return null;
    }

}
