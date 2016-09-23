package web.controller.sales;

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
import model.sales.SalesOrder;
import model.sales.SalesOrderDetails;
import service.api.product.ProductManager;
import service.api.sales.SalesOrderManager;
import web.view.ModelView;


@Controller
public class SalesOrderController
{
    //---------------------------------
    private static final Logger logger = LoggerFactory.getLogger(SalesOrderController.class);
    //---------------------------------
    
    @Autowired
    SalesOrderManager salesOrderManager; 
    
    @Autowired
    ProductManager productManager; 
    

    /*******************************************************
     * 
     */
    @RequestMapping("/register_sales_order.vw")
    public String registerProductView()
    {
        return ModelView.VIEW_SALES_ORDER_REGISTER_PAGE;
    }
    
    
    
    /*******************************************************
     * 
     */
    @RequestMapping( value = "/register_sales_order.do", method = RequestMethod.POST )
    public ModelAndView registerSalesOrder( @ModelAttribute( "salesOrder" ) SalesOrder salesOrder )
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            //*********************************************
            for(SalesOrderDetails orderDetails: salesOrder.getOrderDetails())
            {
                Product product = productManager.getProductById( orderDetails.getProduct().getId() );
                
                if(product != null)
                {
                    orderDetails.setProduct( product );
                }
            }
            //*********************************************
            
            salesOrder = salesOrderManager.addSalesOrder( salesOrder );
            
            if ( salesOrder != null )
            {
                return getSalesOrderList();
            }
            else
            {
                model.setViewName( ModelView.VIEW_SALES_ORDER_REGISTER_PAGE);
            }
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error registering Order", e );        
        }
        
        return model;
        
    }



    /*******************************************************
     * 
     */
    @RequestMapping( value = "/sales_order_list.vw")
    public ModelAndView getSalesOrderList()
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            List<SalesOrder> salesOrders = salesOrderManager.getSalesOrderList();
            
            model.addObject( "salesOrderList", salesOrders );
            model.setViewName( ModelView.VIEW_SALES_ORDER_LIST_PAGE);
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting SalesOrder list", e );        
        }
        
        return model;
        
    }
    
    
    /*******************************************************
     * 
     */
    @RequestMapping( value = "/sales_order_details.vw", method = RequestMethod.GET)
    public ModelAndView getSalesOrderDetails(@RequestParam( "sales_order_id" ) long salesOrderId )
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            SalesOrder salesOrder = salesOrderManager.getSalesOrder( salesOrderId );
            
            if(salesOrder != null)
            {
                model.addObject( "salesOrderDetails", salesOrder );
            }
            
            model.setViewName( ModelView.VIEW_SALES_ORDER_DETAILS_PAGE);
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting sales Order details", e );        
        }
        
        return model;
        
    }


    
}
