package service.impl.sales;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;

import common.exceptions.dao.DAOException;
import dao.api.sales.SalesOrderDAO;
import model.sales.SalesOrder;
import service.api.sales.SalesOrderManager;

@Service("salesOrderManagerService")
@Transactional
public class SalesOrderManagerImpl implements SalesOrderManager
{
    //---------------------------------
    private static final Logger logger = LoggerFactory.getLogger(SalesOrderManagerImpl.class);
    //---------------------------------
    
    
    @Autowired
    SalesOrderDAO salesOrderDAO;
    
   
    /**************************************************
     * 
     */
    @Override
    public String generateCode()
    {
        String code = "SR";
        try
        {
            int maxId = salesOrderDAO.getMaxId() + 1;
            code = code + String.format("%06d", maxId);
        }   
        catch(Exception e)
        {
            logger.error(" ***** Error  generating Code:", e);
        }
        
        return code;
    }

    /****************************************
     * 
     */
    @Override
    public SalesOrder addSalesOrder( SalesOrder salesOrder)
    {
        try
        {
            if(Strings.isNullOrEmpty( salesOrder.getCode()))
            {
                salesOrder.setCode( generateCode());
            }
            
            if(salesOrder.getOrderDate() == null)
            {
                salesOrder.setOrderDate( new Date(System.currentTimeMillis()) );
            }
           
                
            salesOrderDAO.merge( salesOrder );
        }
        catch ( Exception e )
        {
            logger.error( "**** Error adding new Sales Order" ,e );
        }

        return salesOrder;
    }
    
    
    /****************************************
     * 
     */
    @Override
    public SalesOrder getSalesOrder( long salesOrderId )
    {
        try
        {
           
            return salesOrderDAO.find( salesOrderId );
        }
        catch ( Exception e )
        {
            logger.error( "**** Error getting Sales Order Details" ,e );
        }

        return null;
    }
    
    
    /****************************************
     * 
     */
    @Override
    public void updateSalesOrder( SalesOrder p )
    {
        try
        {
            salesOrderDAO.merge( p );
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
    public List<SalesOrder> getSalesOrderList()
    {
        try
        {
            return salesOrderDAO.findAll();
        }
        catch ( DAOException e )
        {
            return Collections.emptyList();
        }
    }


}
