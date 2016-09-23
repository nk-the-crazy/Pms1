package model.finance;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "exchange_rates" )
public class ExchangeRate
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private long id;
    
    @Column(name = "date")
    private Date date;
    
    @Column( name = "currency")
    private short currency = 1;
    
    @Column( name = "rate")
    private float rate = 1;

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate( Date date )
    {
        this.date = date;
    }

    public short getCurrency()
    {
        return currency;
    }

    public void setCurrency( short currency )
    {
        this.currency = currency;
    }

    public float getRate()
    {
        return rate;
    }

    public void setRate( float rate )
    {
        this.rate = rate;
    }
    
    
    

}
