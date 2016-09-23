package web.controller.sales;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.sales.SalesOrder;
import service.api.sales.SalesOrderManager;

@RestController
@RequestMapping("/rest/sales/order")
public class SalesOrderRestController
{
    //---------------------------------
    private static final Logger logger = LoggerFactory.getLogger(SalesOrderRestController.class);
    //---------------------------------
    
    
    @Autowired
    private SalesOrderManager salesOrderManager;
    
    
    
    /*******************************************************
     * 
     */
    @RequestMapping("/list")
    public List<SalesOrder> getSalesOrderList() 
    {
        try
        {
            return salesOrderManager.getSalesOrderList();
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting sales order list (REST)", e );  
        }
        return null;
    }
    
    
}
