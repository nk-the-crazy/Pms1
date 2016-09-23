package model.company;


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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.company.CompanyDetails;
import model.contact.Address;
import model.contact.Contact;
import model.identity.User;
import model.person.Person;


@Entity
@Table(name = "company")
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "company_name", nullable = false, unique = true)
    private String name;

    @Column(name = "type")
    private short type = 0;

    @Column(name = "status")
    private short status = 1;


    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY )
    @JoinColumn(name="address_id")
    private Address address;
    
    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY )
    @JoinColumn(name="details_id")
    private CompanyDetails companyDetails;
    
    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinColumn(name="contact_id")
    private Contact contact; 
    
    @ManyToMany( fetch=FetchType.LAZY )
    @JoinTable(
        name="company_persons",
        joinColumns=@JoinColumn(name="company_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="person_id", referencedColumnName="id"))
    private List<Person> persons = new ArrayList<Person>();
    
    @OneToMany(mappedBy="company", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<User>();


    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode( String code )
    {
        this.code = code;
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

    public CompanyDetails getCompanyDetails()
    {
        return companyDetails;
    }

    public void setCompanyDetails( CompanyDetails companyDetails )
    {
        this.companyDetails = companyDetails;
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

    public List<Person> getPersons()
    {
        return persons;
    }

    public void setPersons( List<Person> persons )
    {
        this.persons = persons;
    }

    public Set<User> getUsers()
    {
        return users;
    }

    public void setUsers( Set<User> users )
    {
        this.users = users;
    }
    
    public void addPerson(Person person)
    {
        this.persons.add(person);
        
        if (!person.getCompanies().contains( this )) 
        {
            person.getCompanies().add(this);
        }
    }
    

}
