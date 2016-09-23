package model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import model.product.ProductDetails;

@Entity
@Table(name = "product_details")
public class ProductDetails
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private long id;
    
    @Column(name = "details") 
    private String details = "";

    
    public long getId()
    {
        return id;
    }



    public void setId( long id )
    {
        this.id = id;
    }



    public String getDetails()
    {
        return details;
    }


    
    public void setDetails( String details )
    {
        this.details = details;
    }



}
