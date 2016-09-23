package service.impl.identity;

import java.security.AccessControlException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;

import common.exceptions.dao.DAOException;
import common.exceptions.security.InvalidLoginException;
import common.exceptions.security.SystemSecurityException;
import common.utils.security.SecurityUtils;
import dao.api.company.CompanyDAO;
import dao.api.identity.IdentityDAO;
import dao.api.identity.RoleDAO;
import model.identity.Role;
import model.identity.User;
import model.person.Person;
import model.common.UserType;
import model.common.session.SessionData;
import model.company.Company;
import service.api.identity.IdentityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("userManagerService")
@Transactional
public class IdentityManagerImpl implements IdentityManager
{
    
    //---------------------------------
    private static final Logger logger = LoggerFactory.getLogger(IdentityManagerImpl.class);
    //---------------------------------
            
    @Autowired
    IdentityDAO identityDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    CompanyDAO companyDAO;


    /**************************************************
     * 
     */
    @Override
    public User auhtenticateUser( String userName, String password ) throws SystemSecurityException
    {
        User user = identityDAO.getUserByUserName( userName );

        if ( user != null )
        {
            String pswHash = "";
            try
            {
                pswHash = SecurityUtils.generateSecurePassword( password, user.getSalt() );
            }
            catch ( NoSuchAlgorithmException e )
            {
                /* ignore */ 
            }

            if ( !pswHash.equals( user.getPassword() ) )
            {
                throw new InvalidLoginException( "***** Invalid Login for user:" + userName );
            }
        }
        else
        {
            throw new InvalidLoginException();
        }

        return user;
    }


    /**************************************************
     * 
     */
    @Override
    public User auhtenticateByToken( String token ) throws SecurityException
    {
        return null;
    }


    /**************************************************
     * 
     */
    @Override
    public SessionData loginUser( String userName , String password  ) throws SecurityException
    {
        SessionData sessionData = null;
        User user = null;
        
        
        if("token".equals( userName ))
        {
            user = auhtenticateByToken(password);
        }
        else
        {
            user = auhtenticateUser( userName, password );
        }
        
        if(user != null)
        {
            try
            {
                sessionData = new SessionData(user);
                user.setLastLogin( new Date(System.currentTimeMillis()) );
                identityDAO.merge( user );
            }
            catch ( DAOException e )
            {
            }
            
            return sessionData;
        }
        else
        {
            return null;
        }
        
    }
    

    /**************************************************
     * 
     */
    @Override
    public User addUser( User user )
    {
        // *********************************
        if ( Strings.isNullOrEmpty( user.getUserName() ) )
        {
            user.setUserName( Integer.toString( SecurityUtils.generateShortRandom() ));
        }
        if ( Strings.isNullOrEmpty( user.getPassword() ) )
        {
            user.setPassword( Integer.toString( SecurityUtils.generateShortRandom() ));
        }
        // *********************************

        isValidUserName( user.getUserName() );
        isValidPassword( user.getUserName(), user.getPassword() );

        try
        {
            String salt = SecurityUtils.generateSecureRandom();
            user.setPassword( SecurityUtils.generateSecurePassword( user.getPassword(), salt ));
            user.setSalt( salt );

            return identityDAO.merge( user );
        }
        catch ( Exception e )
        {
            logger.error( " **** Error in Adduser", e );        
        }

        return null;
    }
    

    /**************************************************
     * 
     */
    @Override
    public User addUser( User user, long companyId, long personId, List<Long> roleIds)
    {
        // *********************************
        try
        {
            Company company = companyDAO.getCompanyPerson( companyId, personId );
            
            if(company != null)
            {
                Person person = company.getPersons().get( 0 );
                user.setCompany( company );
                user.setPerson( person );
                
                for(long id : roleIds )
                {
                    Role role = roleDAO.find( id );
                    
                    if(role != null)
                        user.addRole( role );
                }
                
                return addUser( user );
            }
        }
        catch ( Exception e )
        {
            logger.error( " **** Error in Adduser", e );        
        }

        return null;
    }
    
    
    /**************************************************
     * 
     */
    @Override
    public User addUser( User user, long companyId, long personId)
    {
        // *********************************
        try
        {
            Company company = companyDAO.getCompanyPerson( companyId, personId );
            
            if(company != null)
            {
                Person person = company.getPersons().get( 0 );
                
                user.setCompany( company );
                user.setPerson( person );
                
                return addUser( user );
            }
        }
        catch ( Exception e )
        {
            logger.error( " **** Error in Adduser", e );        
        }

        return null;
    }
    
    
    /**************************************************
     * 
     */
    @Override
    public Company getCompanyInfo(long companyId, long personId )
    {
        // *********************************
        try
        {
            Company company = companyDAO.getCompanyPerson( companyId, personId );
            
            if(company != null)
            {
                return company;
            }
        }
        catch ( Exception e )
        {
            logger.error( " **** Error in get Company Info", e );        
        }

        return null;
    }


    /**************************************************
     * 
     */
    @Override
    public User getUserDetails( long userId )
    {
        // *********************************
        try
        {
            User userDetails = identityDAO.getUserDetails( userId );
            
            if(userDetails != null)
            {
                return userDetails;
            }
        }
        catch ( Exception e )
        {
            logger.error( " **** Error in get User Details", e );        
        }

        return null;
    }

    /**************************************************
     * 
     */
    @Override
    public List<User> getUserList()
    {
        try
        {
            return identityDAO.findAll();
        }
        catch ( DAOException e )
        {
            return Collections.emptyList();
        }
    }


    /**************************************************
     * 
     */
    @Override
    public List<Role> getRoleList()
    {
        try
        {
            return roleDAO.findAll();
        }
        catch ( Exception e )
        {
            return Collections.emptyList();
        }
    }
    

    /**************************************************
     * 
     */
    @Override
    public Role addRole(Role role)
    {
        try
        {
            roleDAO.persist( role );
            return role;
        }
        catch ( Exception e )
        {
            return null;
        }
    }
    
    /**************************************************
     * 
     */
    @Override
    public Role getRoleById( long roleId )
    {
        return roleDAO.find( roleId );
    }
    

    /**************************************************
     * 
     */
    @Override
    public void removeRole( Role role )
    {
        try
        {
            roleDAO.remove( role );
        }
        catch(Exception e)
        {
            
        }
    }
    
    
    /**************************************************
     * 
     */
    @Override
    public void removeRoleById( long roleId)
    {
        Role role = roleDAO.find( roleId );
        removeRole( role );
    }
    
    
    /**************************************************
     * 
     */
    @Override
    public User getUserById( long userId )
    {
        return identityDAO.find( userId );
    }
    
    
    /* *************************************************
     */
    @Override
    public boolean changeUserPassword( long userId, String oldPassword, String newPassword ) throws Exception
    {
        User user = identityDAO.find( userId );      
        return changeUserPassword( user, oldPassword, newPassword );
    }


    /* *************************************************
     */
    @Override
    public boolean changeUserPassword( User user, String oldPassword, String newPassword ) throws Exception
    {
        String salt;

        if ( oldPassword.equals( newPassword ) )
        {
            throw new IllegalArgumentException( "NewPassword cannot be the same as old one." );
        }

        //******Cannot update Internal User *************
        if ( user.getType() == UserType.System.getId() )
        {
            throw new AccessControlException( "Internal User cannot be updated" );
        }

        String pswHash = SecurityUtils.generateSecurePassword( oldPassword, user.getSalt() );

        if ( !pswHash.equals( user.getPassword() ) )
        {
            throw new InvalidLoginException( "Invalid old password specified" );
        }

        isValidPassword( user.getUserName(), newPassword );

        try
        {
            salt = SecurityUtils.generateSecureRandom();
            newPassword = SecurityUtils.generateSecurePassword( newPassword, salt );
            user.setSalt( salt );
            user.setPassword( newPassword );
            identityDAO.merge( user );
        }
        catch ( NoSuchAlgorithmException | NoSuchProviderException e )
        {
            throw new Exception( "Internal error" );
        }

        return true;
    }


    /* *************************************************
     */
    @Override
    public void updateUser( User user )
    {
        //******Cannot update Internal User *************
        if ( user.getType() == UserType.System.getId() )
        {
            throw new AccessControlException( "Internal User cannot be updated" );
        }
        //***********************************************

        try
        {
            identityDAO.merge( user );
        }
        catch ( DAOException e )
        {
        }
    }


    /**************************************************
     * 
     */
    private void isValidUserName( String userName )
    {
        if ( Strings.isNullOrEmpty( userName ) || userName.length() < 4 )
        {
            throw new IllegalArgumentException( "User name cannot be shorter than 4 characters." );
        }

        if ( userName.equalsIgnoreCase( "token" ) || userName.equalsIgnoreCase( "administrator" )
                || userName.equalsIgnoreCase( "system" ) )
        {
            throw new IllegalArgumentException( "User name is reserved by the system." );
        }
    }


    /**************************************************
     * 
     */
    private void isValidPassword( String userName, String password )
    {
        if ( Strings.isNullOrEmpty( password ) || password.length() < 4 )
        {
            throw new IllegalArgumentException( "Password cannot be shorter than 4 characters" );
        }

        if ( password.equalsIgnoreCase( userName ) || password.equalsIgnoreCase( "password" )
                || password.equalsIgnoreCase( "system" ) )
        {
            throw new IllegalArgumentException( "Password doesn't match security requirements" );
        }
    }

}
