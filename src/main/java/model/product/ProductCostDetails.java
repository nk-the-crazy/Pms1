package model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "product_cost_details" )
public class ProductCostDetails
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private long id;
    
    @Column( name = "cost")
    private float unitPrice = 0;
    
    @Column( name = "unit")
    private short unit = 0;

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public float getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice( float unitPrice )
    {
        this.unitPrice = unitPrice;
    }

    public short getUnit()
    {
        return unit;
    }

    public void setUnit( short unit )
    {
        this.unit = unit;
    }
    
    
}
