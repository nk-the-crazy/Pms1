package dao.impl.identity;

import java.util.Collections;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import dao.api.identity.IdentityDAO;
import dao.impl.common.GenericDAOImpl;
import model.identity.User;

@Repository
public class IdentityDAOImpl  extends GenericDAOImpl<User>  implements IdentityDAO
{


	public IdentityDAOImpl()
    {
        super( User.class );
    }
	

    /*****************************************************
	 * 
	 * */
	@Override
    @SuppressWarnings("unchecked")
    public User getUserByUserName( String userName)
    {
		try
		{
    	    Query query = getEntityManager().createQuery( "Select e FROM User e where e.status=1 and e.userName=:userName" );
            query.setParameter( "userName", userName );
            List<User> userList = (List<User>)query.getResultList();
    		
    		
            if(userList.isEmpty())
            	return null;
            else
            	return (User)userList.get( 0 );
        }
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		
		return null;
    }
	
	
	
	/*****************************************************
     * 
     * */
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUserRoles(long userId)
    {
        try
        {
            Query query = getEntityManager().createQuery( "Select u FROM User u where u.id=:userId" );
            List<User> roleList = (List<User>)query.getResultList();
            
            if(roleList.isEmpty())
            {
                return roleList;
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return Collections.emptyList();
    }


    /** *************************************************
     * 
     * */
    @Override
    public User getUserDetails( long userId )
    {
        try
        {
            Query query = getEntityManager()
                    .createQuery( "Select e FROM User e JOIN FETCH e.person p JOIN FETCH e.company c where e.id=:userId" );
            query.setParameter( "userId", userId );
            User user = (User) query.getSingleResult();

            if ( user != null )
                return user;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        return null;
    }



}
