package model.common.session;

import java.util.Date;

import model.identity.User;


public class SessionData
{
	private User user = null;
	private String token = "";
	private Date lastLogin = null;
	private long companyId = 0;
    private long personId  = 0;

	
	/* ********************************
	 * 
	 */
	public SessionData(User user)
	{
		if(user != null)
		{
		    this.user = user;
		    this.lastLogin = user.getLastLogin();
		    
		    if(user.getLastLogin() != null)
	            this.lastLogin = user.getLastLogin();
		    else
		        this.lastLogin = new Date(System.currentTimeMillis());
		}
	}
	
    
	public String getToken()
    {
        return token;
    }


    public void setToken( String token )
    {
        this.token = token;
    }


	
	public User gerUser()
	{
	    return this.user;
	}


    public Date getLastLogin()
    {
        return lastLogin;
    }


    public void setLastLogin( Date lastLogin )
    {
        this.lastLogin = lastLogin;
    }


    public long getCompanyId()
    {
        return companyId;
    }


    public void setCompanyId( long companyId )
    {
        this.companyId = companyId;
    }


    public long getPersonId()
    {
        return personId;
    }


    public void setPersonId( long personId )
    {
        this.personId = personId;
    }
    
    
	
}
