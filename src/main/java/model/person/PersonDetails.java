package model.person;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import model.person.PersonDetails;

@Entity
@Table(name = "person_details")
public class PersonDetails
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private long id;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "marital_status")
    private short maritalStatus = 1;

    @Column(name = "tax_payer_number") // Tax payer NUmber
    private String taxPayerNumber = "";

    @Column(name = "passport_serial") // Passport Serial
    private String passportSerial = "";

    @Column(name = "passport_number") // Passport NUmber
    private String passportNumber = "";
    
    @Column(name = "details") // Passport NUmber
    private String details = "";
    
   

    /*********************************************************
     * 
     */

    public Date getBirthDate()
    {
        return birthDate;
    }
    
    
    public String getBirthDateAsString()
    {
        return "";// SystemSettings.DATE_FORMAT.format( birthDate );
    }


    
    public void setBirthDate( Date birthDate )
    {
        this.birthDate = birthDate;
    }


    
    public short getMaritalStatus()
    {
        return maritalStatus;
    }


    
    public void setMaritalStatus( short maritalStatus )
    {
        this.maritalStatus = maritalStatus;
    }


    
    public String getTaxPayerNumber()
    {
        return taxPayerNumber;
    }


    
    public void setTaxPayerNumber( String taxPayerNumber )
    {
        this.taxPayerNumber = taxPayerNumber;
    }


    
    public String getPassportSerial()
    {
        return passportSerial;
    }


    
    public void setPassportSerial( String passportSerial )
    {
        this.passportSerial = passportSerial;
    }


    
    public String getPassportNumber()
    {
        return passportNumber;
    }


    
    public void setPassportNumber( String passportNumber )
    {
        this.passportNumber = passportNumber;
    }


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
