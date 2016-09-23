package model.person;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.company.Company;
import model.contact.Address;
import model.contact.Contact;
import model.identity.User;
import model.person.Person;
import model.person.PersonDetails;


@Entity
@Table( name = "person" )
public class Person
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name = "id")
	private long id;
	
    @Column( name = "code", nullable = false, unique = true )
    private String code;
	
    @Column( name = "first_name", length = 60, nullable = false )
	private String firstName;
	
	@Column( name = "last_name", length = 60, nullable = false )
	private String lastName;
	
	@Column( name = "middle_name", length = 60 )
	private String middleName = "";
	
	@Column( name = "gender" )
	private short gender = 1;
	
	@Column( name = "type" )
	private short type = 0;
	
	@Column( name = "status" )
	private short status = 1;    
	
    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY )
    @JoinColumn(name="details_id")
    private PersonDetails personDetails; 
    
    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY )
    @JoinColumn(name="address_id")
    private Address address;
    
    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinColumn(name="contact_id")
    private Contact contact; 
    
    @ManyToMany(mappedBy="persons", fetch = FetchType.LAZY)
    private List<Company> companies = new ArrayList<Company>();

    @OneToMany(mappedBy="person", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<User>();
	
	/** *******************************************************************************
	 * 
	 * 
	 */
	
    public long getId()
	{
		return id;
	}

	public void setId( long id )
	{
		this.id = id;
	}

	
    public String getFirstName()
	{
		return firstName;
	}

	
    public void setFirstName( String firstName )
	{
		this.firstName = firstName;
	}

	
    public String getLastName()
	{
		return lastName;
	}

	
    public void setLastName( String lastName )
	{
		this.lastName = lastName;
	}

	
    public String getMiddleName()
	{
		return middleName;
	}

	
    public void setMiddleName( String middleName )
	{
		this.middleName = middleName;
	}
    
    	
    public String getCode()
    {
        return code;
    }

    public void setCode( String code )
    {
        this.code = code;
    }

    public short getType()
	{
		return type;
	}

	
    public void setType( short type )
	{
		this.type = type;
	}

	
    public short getGender()
    {
	    return gender;
    }

	
    public void setGender( short gender )
    {
	    this.gender = gender;
    }

	
    public short getStatus()
	{
		return status;
	}

	
    public void setStatus( short status )
	{
		this.status = status;
	}

	
    public PersonDetails getPersonDetails()
	{
		return personDetails;
	}

	
    public void setPersonDetails( PersonDetails personDetails )
	{
        this.personDetails = personDetails;
	}

    public Address getAddress()
    {
        return address;
    }

    public void setAddress( Address address )
    {
        this.address = address;
    }

    public Contact getContact()
    {
        return contact;
    }

    public void setContact( Contact contact )
    {
        this.contact = contact;
    }

    public List<Company> getCompanies()
    {
        return companies;
    }

    public void setCompanies( List<Company> companies )
    {
        this.companies = companies;
    }

    public Set<User> getUsers()
    {
        return users;
    }

    public void setUsers( Set<User> users )
    {
        this.users = users;
    }
    
    public void addCompany(Company company)
    {
        this.companies.add(company);
        
        if (!company.getPersons().contains( this )) 
        {
            company.getPersons().add( this );
        }
    }
    
    
}
