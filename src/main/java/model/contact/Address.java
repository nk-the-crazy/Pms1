package model.contact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "address" )
public class Address
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id")
	private long id;
	
	@Column( name = "country_id")
	private int countryId = 0;
	
	@Column( name = "region_id")
	private int regionId = 0;
	
	@Column( name = "city", length = 120)
	private String city;
	
	@Column( name = "address_line1", length = 250)
	private String addressLine1;

	@Column( name = "address_line2", length = 250)
	private String addressLine2;
	
	/*********************************************************************************
	 * 
	 * 
	 **/
	
	
    public long getId()
	{
		return id;
	}

	public void setId( long id )
	{
		this.id = id;
	}

	
    public int getCountryId()
	{
		return countryId;
	}

	
    public void setCountryId( int countryId )
	{
		this.countryId = countryId;
	}

	
    public int getRegionId()
	{
		return regionId;
	}

	
    public void setRegionId( int regionId )
	{
		this.regionId = regionId;
	}

	
    public String getCity()
	{
		return city;
	}

	
    public void setCity( String city )
	{
		this.city = city;
	}

	
    public String getAddressLine1()	
	{
		return addressLine1;
	}


	
    public void setAddressLine1( String addressLine1 )
	{
		this.addressLine1 = addressLine1;
	}		

	
    public String getAddressLine2()
	{
		return addressLine2;
	}

	
    public void setAddressLine2( String addressLine2 )
	{
		this.addressLine2 = addressLine2;
	}


	//***************************************************************
	
    public String getCountryTypeName()
    {
	    return "";//SystemSettings.getSystemTypeName(SystemTypeGroup.COUNTRY, countryId );
    }
	
	
    public String getRegionTypeName()
    {
	    return "";//SystemSettings.getSystemTypeName(SystemTypeGroup.REGION, regionId );
    }
	//***************************************************************


}
