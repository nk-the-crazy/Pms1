package common.config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.common.PermissionObject;
import model.common.PermissionScope;
import model.common.UserType;
import model.company.Company;
import model.identity.Permission;
import model.identity.Role;
import model.identity.User;
import model.person.Person;
import service.api.identity.IdentityManager;

@Component
public class BaseConfig
{
    @Autowired
    private IdentityManager identityManager;
    
    @PostConstruct
    void init()
    {
        Role systemAdmin = setDefaultRoles();
    	setDefaultUser(systemAdmin);
    }
    
    //******************************************
    void setDefaultUser(Role systemAdmin)
    {
        
        //********************************
        Person person = new Person();
        person.setCode( "P00001" );
        person.setFirstName( "System" );
        person.setLastName( "Administrator" );
        
        //********************************
        Company company = new Company();
        company.setCode( "F0001" );
        company.setName( "Pms1 Administrative Company" );
        company.addPerson( person );
        
        //********************************
        User user = new User();
        user.setUserName( "admin" );
        user.setPassword( "secret" );
        user.setType( (short)UserType.Regular.getId() );
        user.setEmail( "admin@pms1.com" );
        user.addRole( systemAdmin );
        user.setCompany( company );
        user.setPerson( person );
        
        identityManager.addUser( user );
    }
    
    
    //******************************************
    Role setDefaultRoles()
    {
        Permission perm1, perm2, perm3 = null;
        
        //***********************************
        perm1 = createPermission(PermissionObject.IdentityManagement, PermissionScope.AllObject);
        perm2 = createPermission(PermissionObject.CompanyManagement, PermissionScope.AllObject);
        perm3 = createPermission(PermissionObject.PersonManagement, PermissionScope.AllObject);
        
        Role sysAdmin = new Role();
        sysAdmin.setName( "Global System Admin" );
        sysAdmin.setType( UserType.Regular.getId() );
        sysAdmin.addPermission(perm1);
        sysAdmin.addPermission(perm2);
        sysAdmin.addPermission(perm3);
        identityManager.addRole( sysAdmin );
        
        //***********************************
        perm1 = createPermission(PermissionObject.IdentityManagement, PermissionScope.OwnerObjects);
        perm2 = createPermission(PermissionObject.CompanyManagement, PermissionScope.OwnerObjects);
        perm3 = createPermission(PermissionObject.PersonManagement, PermissionScope.OwnerObjects);
        
        Role role = new Role();
        role.setName( "Local System Admin" );
        role.setType( UserType.Regular.getId() );
        sysAdmin.addPermission(perm1);
        sysAdmin.addPermission(perm2);
        sysAdmin.addPermission(perm3);
        identityManager.addRole( role );
        
        //***********************************
        perm1 = createPermission(PermissionObject.CompanyManagement, PermissionScope.OwnerObjects);
        perm2 = createPermission(PermissionObject.PersonManagement, PermissionScope.OwnerObjects);
        perm3 = createPermission(PermissionObject.FinanceManagement, PermissionScope.OwnerObjects);

        role = new Role();
        role.setName( "Company Director" );
        role.setType( UserType.Regular.getId() );
        role.addPermission(perm1);
        role.addPermission(perm2);
        role.addPermission(perm3);
        identityManager.addRole( role );
        
        //***********************************
        perm3 = createPermission(PermissionObject.FinanceManagement, PermissionScope.OwnerObjects);
        
        role = new Role();
        role.setName( "Accountant" );
        role.setType( UserType.Regular.getId() );
        role.addPermission(perm3);
        identityManager.addRole( role );
        
        //***********************************
        perm1 = createPermission(PermissionObject.ProductManagement, PermissionScope.OwnerObjects);
        perm2 = createPermission(PermissionObject.SalesManagement, PermissionScope.OwnerObjects);
        
        role = new Role();
        role.setType( UserType.Regular.getId() );
        role.setName( "Sales Manager" );
        role.addPermission(perm1);
        role.addPermission(perm2);
        identityManager.addRole( role );
        
        return sysAdmin;
    }
    
    
    Permission createPermission(PermissionObject pObj, PermissionScope scope)
    {
        Permission perms = new Permission();
        perms.setObject( pObj.getId() );
        perms.setScope( scope.getId() );
        perms.setRead( true );
        perms.setWrite( true );
        perms.setDelete( true );
        perms.setUpdate( true );
        
        return perms;
    }

}
