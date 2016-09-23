package model.sales;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.product.Product;

@Entity
@Table( name = "sales_order_details" )
public class SalesOrderDetails
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private long id;
    
    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="product_id", nullable = false)
    private Product product;  
    
    @Column(name = "quantity")
    private float quantity;
    
    @Column(name = "unitPrice")
    private float unitPrice;
    
    @Column(name = "discount")
    private float discount;

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct( Product product )
    {
        this.product = product;
    }

    public float getQuantity()
    {
        return quantity;
    }

    public void setQuantity( float quantity )
    {
        this.quantity = quantity;
    }

    public float getDiscount()
    {
        return discount;
    }

    public void setDiscount( float discount )
    {
        this.discount = discount;
    }

    public float getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice( float unitPrice )
    {
        this.unitPrice = unitPrice;
    }
    
    
    
    
    
}
