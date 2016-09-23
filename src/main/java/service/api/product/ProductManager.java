package service.api.product;

import java.util.List;

import model.product.Product;

public interface ProductManager
{

    Product addProduct( Product Product );

    void updateProduct( Product p );

    List<Product> getProductList();

    Product getProductById( long id );

    void removeProduct( long id );

    Product getProductByName( String productName );

    Product getProductByCode( String productCode );

    Product addProduct( String code, String name, short type );

    String generateCode();

    Product getProductDetails( long productId );

    Product getProductCostDetails( String productCode );

}
