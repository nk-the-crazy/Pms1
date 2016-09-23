package dao.api.product;

import dao.api.common.GenericDAO;
import model.product.Product;

public interface ProductDAO extends GenericDAO<Product>
{

    Product getByName( String productName );

    Product getByCode( String productCode );

    int getMaxId();

    Product getProductCostDetails( String productCode );

}
