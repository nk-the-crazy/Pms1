package service.api.identity;

import java.util.List;

import common.exceptions.security.SystemSecurityException;
import model.identity.Role;
import model.identity.User;
import model.common.session.SessionData;
import model.company.Company;

public interface IdentityManager
{
    User auhtenticateUser( String userName, String password ) throws SystemSecurityException;;

    User auhtenticateByToken( String token ) throws SystemSecurityException;

    List<User> getUserList();

    User getUserById( long userId );

    SessionData loginUser( String userName, String password ) throws SecurityException;

    boolean changeUserPassword( long userId, String oldPassword, String newPassword ) throws Exception;

    boolean changeUserPassword( User user, String oldPassword, String newPassword ) throws Exception;

    void updateUser( User user );

    User addUser( User user );

    User addUser( User user, long companyId, long personId );

    Company getCompanyInfo( long companyId, long personId );

    List<Role> getRoleList();

    Role addRole( Role role );

    User addUser( User user, long companyId, long personId, List<Long> roleIds );

    Role getRoleById( long roleId );

    void removeRole( Role role );

    void removeRoleById( long roleId );

    User getUserDetails( long userId );
}
