package web.controller.product;

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

import model.product.Product;
import service.api.product.ProductManager;
import web.controller.product.ProductController;
import web.view.ModelView;

@Controller
public class ProductController
{
    //---------------------------------
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    //---------------------------------
    
    
    @Autowired
    private ProductManager productManager;
   
    
    /*******************************************************
     * 
     */
    @RequestMapping("/register_product.vw")
    public String registerProductView()
    {
        return ModelView.VIEW_PRODUCT_REGISTER_PAGE;
    }
    
    
    /*******************************************************
     * 
     */
    @RequestMapping( value = "/register_product.do", method = RequestMethod.POST )
    public ModelAndView registerProduct( @ModelAttribute( "product" ) Product product )
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            product = productManager.addProduct( product );
            
            if ( product != null )
            {
                return getProductList();
            }
            else
            {
                model.setViewName( ModelView.VIEW_PRODUCT_REGISTER_PAGE);
            }
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error registering Product", e );        
        }
        
        return model;
        
    }


    /*******************************************************
     * 
     */
    @RequestMapping( value = "/product_list.vw")
    public ModelAndView getProductList()
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            List<Product> Products = productManager.getProductList();
            
            model.addObject( "productList", Products );
            model.setViewName( ModelView.VIEW_PRODUCT_LIST_PAGE);
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting Product list", e );        
        }
        
        return model;
        
    }
    
    

    /*******************************************************
     * 
     */
    @RequestMapping( value = "/product_details.vw", method = RequestMethod.GET)
    public ModelAndView getProductDetails(@RequestParam( "product_id" ) long productId )
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            Product product = productManager.getProductDetails( productId );
            
            if(product != null)
            {
                model.addObject( "productDetails", product );
            }
            
            model.setViewName( ModelView.VIEW_PRODUCT_DETAILS_PAGE);
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting product details", e );        
        }
        
        return model;
        
    }


}
