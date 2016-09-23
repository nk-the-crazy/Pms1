package model.product;

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
import model.product.ProductDetails;

@Entity
@Table( name = "product" )
public class Product
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id")
    private long id;
    
    @Column( name = "product_name", nullable = false, unique=true)
    private String name;
    
    @Column( name = "code", nullable = false, unique=true)
    private String code;
    
    @Column( name = "type")
    private short type = 1;
    
    @Column( name = "status")
    private short status = 1;
        
    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY )
    @JoinColumn(name="details_id")
    private ProductDetails productDetails; 

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY )
    @JoinColumn(name="cost_details_id")
    private ProductCostDetails productCostDetails; 


    public long getId()
    {
        return id;
    }

    
    public void setId( long id )
    {
        this.id = id;
    }

    
    public String getName()
    {
        return name;
    }

    
    public void setName( String name )
    {
        this.name = name;
    }

    
    public short getType()
    {
        return type;
    }

    
    public void setType( short type )
    {
        this.type = type;
    }

    
    public short getStatus()
    {
        return status;
    }

    
    public void setStatus( short status )
    {
        this.status = status;
    }

    
    public String getCode()
    {
        return code;
    }

    
    public void setCode( String code )
    {
        this.code = code;
    }

    

    public ProductDetails getProductDetails()
    {
        return productDetails;
    }

    
    public void setProductDetails( ProductDetails productDetails )
    {
        this.productDetails = productDetails;
    }


    public ProductCostDetails getProductCostDetails()
    {
        return productCostDetails;
    }


    public void setProductCostDetails( ProductCostDetails productCostDetails )
    {
        this.productCostDetails = productCostDetails;
    }

    

}
