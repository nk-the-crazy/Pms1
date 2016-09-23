package dao.impl.sales;

import org.springframework.stereotype.Repository;

import dao.api.sales.SalesOrderDAO;
import dao.impl.common.GenericDAOImpl;
import model.sales.SalesOrder;

@Repository
public class SalesOrderDAOImpl  extends GenericDAOImpl<SalesOrder> implements SalesOrderDAO
{
    public SalesOrderDAOImpl()
    {
        super( SalesOrder.class );
    }
    
}
