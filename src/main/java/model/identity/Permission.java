package model.identity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 *
 */
@Entity
@Table( name = "permission" )
@Access( AccessType.FIELD )
public class Permission
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private long id;

    @Column( name = "object" )
    private int object;

    @Column( name = "scope" )
    private int scope = 1;

    @Column( name = "read" )
    private boolean read = false;

    @Column( name = "write" )
    private boolean write = false;

    @Column( name = "update" )
    private boolean update = false;

    @Column( name = "delete" )
    private boolean delete = false;


    
    public Long getId()
    {
        return id;
    }


    
    public void setId( final Long id )
    {
        this.id = id;
    }


    
    public int getObject()
    {
        return object;
    }


    
    public void setObject( int object )
    {
        this.object = object;
    }


    
    public int getScope()
    {
        return scope;
    }


    
    public void setScope( int scope )
    {
        this.scope = scope;
    }


    
    public boolean isRead()
    {
        return read;
    }


    
    public void setRead( boolean read )
    {
        this.read = read;
    }

  
    public boolean isWrite()
    {
        return write;
    }

    
    public void setWrite( boolean write )
    {
        this.write = write;
    }


    
    public boolean isUpdate()
    {
        return update;
    }


    
    public void setUpdate( boolean update )
    {
        this.update = update;
    }


    
    public boolean isDelete()
    {
        return delete;
    }


    
    public void setDelete( boolean delete )
    {
        this.delete = delete;
    }


    
    public String getObjectName()
    {
        return "";
    }


    
    public List<String> asString()
    {
        List<String> perms = new ArrayList<>();

        return perms;
    }
}