package model.sales;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table( name = "sales_orders" )
public class SalesOrder
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "order_date")
    private Date orderDate;
    
    @OneToMany (cascade = CascadeType.ALL , fetch= FetchType.EAGER)
    @JoinColumn(name="order_details_id", nullable = false)
    private List<SalesOrderDetails> orderDetails;
    

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public Date getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate( Date orderDate )
    {
        this.orderDate = orderDate;
    }

  
    public String getCode()
    {
        return code;
    }

    public void setCode( String code )
    {
        this.code = code;
    }

    public List<SalesOrderDetails> getOrderDetails()
    {
        return orderDetails;
    }

    public void setOrderDetails( List<SalesOrderDetails> orderDetails )
    {
        this.orderDetails = orderDetails;
    }
    
    
    
        
}
