package dao.api.identity;

import java.util.List;

import dao.api.common.GenericDAO;
import model.identity.User;


public interface IdentityDAO extends GenericDAO<User>
{
    /** *************************************************
     * 
     */
    public User getUserByUserName( String userName);

    
	/** *************************************************
     * 
     */
    List<User> getUserRoles( long userId );

    
    /** *************************************************
     * 
     */
    public User getUserDetails( long userId );
}
