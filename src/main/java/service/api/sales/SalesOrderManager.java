package service.api.sales;

import java.util.List;

import model.sales.SalesOrder;

public interface SalesOrderManager
{

    SalesOrder addSalesOrder( SalesOrder salesOrder );

    List<SalesOrder> getSalesOrderList();

    void updateSalesOrder( SalesOrder p );

    String generateCode();

    SalesOrder getSalesOrder( long salesOrderId );

}
